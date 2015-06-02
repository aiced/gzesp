package com.ai.gzesp.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.PayDao;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;
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
    public void beforePayReq(UnionPayParam param, Map<String, String> result){
        
    }  
    
    /**
     * 调用微信支付，沃支付，银联支付前 插支付日志总表 ord_d_pay 
     * @param param
     * @param result
     * @return
     */
/*    private int insertPayInfo(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        
            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payNew.getTradeType()); //系统跟踪号
            param.setPay_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setPay_time_stamp(timeStamp);
            String tradeType = TradeType.payNew.getTradeType(); //业务类型
            param.setPay_trade_type(tradeType);
             
            //
            int n2 = payDao.insertPayInfo(param.getPay_sys_trade_no(), //pay_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
                    "01",  //pay_type
                    param.getCard_type().equals("01") ? "11" : "12", //pay_mode
                            "0", //pay_state 初始0已发起支付
                            null, //银联支付接口时插入md5 加密后的签约号,用于退款时知道退到哪个账户, 全要素支付接口不需要传签约号
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getPay_trade_type(), //req_trade_type
                                    param.getPay_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id(),
                                    param.getFee()
                    );
            
            if(n2 <= 0){
            	//都成功则result为空
            	result.put("status", "E04");
            	result.put("detail", "支付失败！全要素支付日志流水插入失败");
            	//return result; //直接返回
            }
        
        //return result;
    }*/
    

    /**
     * 微信支付，沃支付，银联支付成功收到返回后，除了更新各自的log日志表外，还有一系列后续操作
     * 1.更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
     * 2.新增一条 ORD_L_DEALLOG 处理日志
     * 3.更新 ord_d_pay 里 状态
     * 4.如果有号码预占而且支付返回响应是成功的则删掉号码预占表信息
     * 
     * @param param
     * @param result
     * @return
     */
    public void afterPaySuccess(boolean isSuccess, String orderId, int fee){
    	//更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
    	int r1 = updatePayStateAndIncomeMoney(isSuccess, orderId, fee);
    	
    	//如果支付成功 则新增一条 ORD_L_DEALLOG 处理日志
    	if(isSuccess){
    		int r2 = insertDealLog(orderId, fee);
    	}
    	
    	//如果收到响应，不管成功失败 都要更新ord_d_pay 里的状态
    	
    	//先根据返回报文里的order_id 获取到订单当时是否有选择号码
    	Map<Object, Object> numberRow = getNumberByOrderId(orderId);
    	//如果有号码而且返回响应是成功的则删掉号码预占表信息
        if(MapUtils.isNotEmpty(numberRow) && isSuccess){
        	//号码预占表删掉号码记录
        	String[] numbers = {(String) numberRow.get("SERIAL_NUMBER")}; 
        	int r4 = deleteNumberReserve(numbers);
        }
        
        //支付成功发短信
    	
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
        	int income_money = fee*10; //银联是分，表里是厘
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
    			"支付成功,金额" + fee/100 + "元",  //DEAL_CONTENT
    			"0",  //RESULT_CODE
    			"成功",   //RESULT_INFO
    			"00",  //ORIGINAL_STATE，订单原始状态未支付
    			"01"   //CURRENT_STATE,订单线状态，待分配
    			);
    }
    
}
