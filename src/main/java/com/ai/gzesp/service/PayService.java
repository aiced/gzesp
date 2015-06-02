package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.PayDao;
import com.ai.gzesp.dto.OrderDPay;
import com.ai.gzesp.dto.PayInfo;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.SmsUtils;
import com.ai.sysframe.utils.CommonUtil;

/**
 * 支付公共服务类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class PayService {
    
    private static final Logger log = Logger.getLogger(PayService.class); 
    
    @Autowired
    private PayDao payDao;
    
    @Autowired
    private OrderDao orderDao;
    
    
    /**
     * 根据orderid查询能人店铺id
     * @param order_id
     * @return
     */
    public Map<Object, Object> queryUserIdByOrderId(String order_id) {
        return payDao.queryUserIdByOrderId(order_id);
    }
    
    /**
     * 调用微信支付，沃支付，银联支付前 做的工作
     * 1.插支付日志总表 ord_d_pay 
     * @param param
     * @param result
     * @return
     */
    public void beforePayReq(String orderId, String orderFee, List<PayInfo> payInfoList){
    	//先查下ord_d_pay 里是否已经有记录了，避免再次支付时多插记录
    	List<Map<String, String>> rows = queryOrderDPay(orderId);
    	//如果没有记录则插记录, 有记录则更新记录
        if(rows.size() == 0){
        	insertPayInfoBatch(orderId, orderFee, payInfoList);
        }
        else{
        	//暂时不写，等账户功能上了再写
        }
    }  
    
    private List<Map<String, String>> queryOrderDPay(String orderId){
        return payDao.queryOrderDPay(orderId);
    }
    
    /**
     * 调用微信支付，沃支付，银联支付前 插支付日志总表 ord_d_pay 
     * 目前一条订单只插一条记录
     * 以后可扩展为一条订单多部分支付，比如一条订单金额：100，能人账户优惠券抵扣10块，能人账户现金抵扣20块，微信支付70块，则插3条paylog记录
     * @param orderId
     * @param orderFee
     * @param payInfo
     * @return
     */
	private int insertPayInfoBatch(String orderId, String orderFee, List<PayInfo> payInfoList) {
    	List<OrderDPay> list = new ArrayList<OrderDPay>();
    	String partition_id = orderId.substring(14, 16); 
    	String pay_time = DateUtils.getCurentTime();
    	
    	for(int i = 0; i < payInfoList.size(); i++){
    		OrderDPay item = new OrderDPay();
    		item.setOrder_id(orderId);
    		item.setPartition_id(partition_id);
    		//item.setPay_id(pay_id);
    		item.setPay_order(String.valueOf(i+1)); //默认是1开始
    		item.setPay_type("01"); //默认01 在线付款
    		item.setPay_mode(payInfoList.get(i).getPay_mode()); //按顺序取
    		item.setPay_state("0");  //默认初始状态 0-未支付
    		item.setOrder_fee(orderFee); //单位厘
    		item.setPay_fee(payInfoList.get(i).getPay_fee());  //单位厘
    		item.setPay_time(pay_time);
    		
    		list.add(item);
    	}
    	
		return payDao.insertPayInfoBatch(list);
	}
    

    /**
     * 微信支付，沃支付，银联支付成功收到返回后，除了更新各自的log日志表外，还有一系列后续操作
     * 1.更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
     * 2.新增一条 ORD_L_DEALLOG 处理日志
     * 3.更新 ord_d_pay 里 状态
     * 4.如果有号码预占而且支付返回响应是成功的则删掉号码预占表信息
     * 
     * orderFee 单位厘
     * 
     * @param pay_mode
     * @param isSuccess
     * @param orderId
     * @param orderFee
     * @return
     */
    public void afterPaySuccess(String pay_mode, boolean isSuccess, String orderId, int orderFee){
    	//更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
    	if(isSuccess){
    	   int r1 = updatePayStateAndIncomeMoney(isSuccess, orderId, orderFee);
    	}
    	//如果支付成功 则新增一条 ORD_L_DEALLOG 处理日志
    	if(isSuccess){
    		int r2 = insertDealLog(orderId, orderFee);
    	}
    	
    	//如果收到响应，不管成功失败 都要更新ord_d_pay 里的状态,1 成功，2失败
    	String pay_state = isSuccess ? "1" : "2" ;
    	int r3 = updateOrdDPay(orderId, pay_state, pay_mode);
    	
    	//先根据返回报文里的order_id 获取到订单当时是否有选择号码
    	Map<Object, Object> numberRow = getNumberByOrderId(orderId);
    	//如果有号码而且返回响应是成功的则删掉号码预占表信息
        if(MapUtils.isNotEmpty(numberRow) && isSuccess){
        	//号码预占表删掉号码记录
        	String[] numbers = {(String) numberRow.get("SERIAL_NUMBER")}; 
        	int r4 = deleteNumberReserve(numbers);
        }
        
        //支付成功发短信
        if(isSuccess){
        	Map<String, String> phone = payDao.queryPhoneByOrderId(orderId);
        	Map<String, String> goods = payDao.queryGoodsNameByOrderId(orderId);
        	if(MapUtils.isNotEmpty(phone)){
        		String strRet = SmsUtils.doSendMessage(phone.get("PHONE_NUMBER"), "MB-2015052754", "@1@=" + goods.get("GOODS_NAME"));
        	}
    	}
    }
    
    /**
     * 支付收到响应后更新订单基本表里订单状态 和 实收金额
     * @param isSuccess
     * @param orderId
     * @param fee
     * @return
     */
    private int updatePayStateAndIncomeMoney(boolean isSuccess, String orderId, int fee) {
    	int r2 = 0;
        if(isSuccess){
        	String order_state = "01"; //下单时是00，支付成功改成01，支付失败则不更新还是00
        	int income_money = fee; //银联是分，表里是厘
        	//20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
        	//String realOrderId = UnionPayUtil.newOrderId2OrderId(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.sysTradeNo));
        	//r2 = unionPayDao.updatePayStateAndIncomeMoney(respMap.get(UnionPayAttrs.orderId), order_state, income_money);
        	r2 = payDao.updatePayStateAndIncomeMoney(orderId, order_state, income_money);
        }
        return r2;
    }
    
    /**
     * 根据order_id 查找是否用了手机号码
     * @param order_id
     * @return
     */
    private Map<Object, Object> getNumberByOrderId(String order_id){
        return orderDao.getNumberByOrderId(order_id);
    }
    
    /**
     * 支付成功后删除号码预占表里的记录
     * @param numbers
     * @return
     */
    private int deleteNumberReserve(String[] numbers){
    	int r2 = orderDao.deleteNumberReserve(numbers);
    	StringBuffer sb = new StringBuffer();
    	for(String number : numbers){
    		sb.append(numbers);
    		sb.append(", ");
    	}
    	log.debug("【支付成功：号码预占表delete " + r2 + " 条记录," + sb.toString() + "】");
    	return r2;
    }
    
    
    /**
     * 支付成功后插 ORD_L_DEALLOG 记录
     * @return
     */
    private int insertDealLog(String orderId, int fee){
    	return payDao.insertDealLog(
    			CommonUtil.generateLogId("5"),
    			orderId, 
    			orderId.substring(14, 16), //partition_id
    			"支付成功金额" + fee/1000 + "元",  //DEAL_CONTENT
    			"0",  //RESULT_CODE
    			"成功",   //RESULT_INFO
    			"00",  //ORIGINAL_STATE，订单原始状态未支付
    			"01"   //CURRENT_STATE,订单线状态，待分配
    			);
    }
    
    private int updateOrdDPay(String orderId, String pay_state, String pay_mode){
        return payDao.updateOrdDPay(orderId, pay_state, pay_mode);
    }
    
}
