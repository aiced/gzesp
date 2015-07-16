package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.PayDao;
import com.ai.gzesp.dto.OrderDPay;
import com.ai.gzesp.dto.PayInfo;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.recharge.RechargeUtil;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;
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
    
    @Autowired
    private UnionPayService2 unionPayService2;
    
    @Autowired
    private MyAcctService myAcctService;
    
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
    public void beforePayReq(String orderId, String orderFee, List<Map<String, String>> paramList, Map<String, String> result){
    	//组装list
    	List<PayInfo> payInfoList = new ArrayList<PayInfo>();
    	for(int i = 0; i < paramList.size(); i++){
    		PayInfo row = new PayInfo();
    		row.setPay_order(String.valueOf(i+1)); //默认从1开始
    		row.setPay_type(paramList.get(i).get("pay_type")); //线上
    		row.setPay_mode(paramList.get(i).get("pay_mode")); //30 微信支付  40 沃支付
    		row.setPay_fee(paramList.get(i).get("pay_fee")); //单位厘
    		payInfoList.add(row);
    	}
    	
    	//先查下ord_d_pay 里是否已经有记录了，避免再次支付时多插记录
    	List<Map<String, String>> rows = queryOrderDPay(orderId);
    	//如果没有记录则插记录, 有记录则更新记录
        if(rows.size() == 0){
        	insertPayInfoBatch(orderId, orderFee, payInfoList);
        }
        else{
        	//暂时不写，第一次支付失败后，可以再次支付，支付成功后会来更新表里的记录
        	//先删除原记录再插新记录，其实这样有问题，应该判断是否有成功支付记录，成功了页面就不允许再次选择支付模式支付
        	
        	//insertPayInfoBatch(orderId, orderFee, payInfoList);
        }
    } 
    
    
    private List<Map<String, String>> queryOrderDPay(String orderId){
        return payDao.queryOrderDPay(orderId);
    }
    
    /**
     * 调用微信支付，沃支付，银联支付前 插支付日志总表 ord_d_pay 
     * 目前一条订单只插一条记录
     * 以后可扩展为一条订单多部分支付，比如一条订单金额：100，能人账户优惠券抵扣10块，能人账户现金抵扣20块，微信支付70块，则插3条paylog记录
     * 因为mybatis 里 oracle 的 insert 支持不好，不好插入多条记录，得用<select>，不能用<insert>，所以无法返回int，会返回null
     * @param orderId
     * @param orderFee
     * @param payInfo
     * @return
     */
	private void insertPayInfoBatch(String orderId, String orderFee, List<PayInfo> payInfoList) {
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
    	
    	//因为mybatis 里 oracle 的 insert 支持不好，不好插入多条记录，得用<select>，不能用<insert>，所以无法返回int，会返回null
        payDao.insertPayInfoBatch(list); 
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
    		int r2 = insertDealLogAfterPaySuccess(orderId, orderFee);
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
     * 退款接口请求返回成功后 后续统一操作
     * 1.ord_d_refund, ORDER_STATE 后台审核通过未退款 13，后台审核通过已退款14 
     * 2.ord_d_base, 
     * 3.ord_d_pay, 
     * 4.ORD_L_DEALLOG, 
     * 5.退佣金（能人账户功能完成后开发）
     * 6.发短信通知(放到后台管理去发了)
     * @param pay_mode
     * @param isSuccess
     * @param orderId
     */
    public void afterRefundSuccess(String pay_mode, boolean isSuccess, String orderId){
    	//先从ord_d_refund表里查询出订单表里原来的状态,用于插到 ORD_L_DEALLOG
    	Map<String, String> refundInfo = payDao.queryRefundInfoByOrderId(orderId);
    	String orig_order_state = refundInfo.get("ORDER_STATE");
    	
    	//不管成功与否 都要 更新订单退款表 ord_d_refund里的  refund_state 后台审核通过未退款 13，后台审核通过已退款14 
    	String order_state = isSuccess ? "14" : "13";
    	int r1 = updatePayRefundState(orderId, order_state);
    	
    	//不管成功与否 都要 更新订单基本表 ord_d_base 里的  ORDER_STATE 
    	int r2 = updatePayState(orderId, order_state);
    	
    	//如果退款请求成功 更新ord_d_pay 里的状态 5 已退款
    	if(isSuccess){
    		//String pay_state = isSuccess ? "5";
    		int r3 = updateOrdDPay(orderId, "5", pay_mode);
    	}
    	
    	//不管退款成功失败 则新增一条 ORD_L_DEALLOG 处理日志
    	String content = isSuccess ? "退款请求成功" : "退款请求失败" ;
    	int r4 = insertDealLogAfterPayRefund(orderId, content, orig_order_state, order_state);
    	
    	
        //退款成功发短信

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
        	//20150702 ximh 修改，要跳过外呼步骤，所以支付成功直接改成 02: 待处理状态
        	//String order_state = "01"; //下单时是00，支付成功改成01，支付失败则不更新还是00
        	String order_state = "02";
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
    private int insertDealLogAfterPaySuccess(String orderId, int fee){
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
    
    /**
     * 退款成功后插 ORD_L_DEALLOG 记录
     * @return
     */
    private int insertDealLogAfterPayRefund(String orderId, String content, String orig_order_state, String current_state){
    	return payDao.insertDealLog(
    			CommonUtil.generateLogId("5"),
    			orderId, 
    			orderId.substring(14, 16), //partition_id
    			content,  //DEAL_CONTENT
    			"0",  //RESULT_CODE
    			content,   //RESULT_INFO
    			orig_order_state,  //ORIGINAL_STATE，订单原始状态未支付
    			current_state   //CURRENT_STATE,订单线状态，待分配
    			);
    }
    
    private int updateOrdDPay(String orderId, String pay_state, String pay_mode){
        return payDao.updateOrdDPay(orderId, pay_state, pay_mode);
    }
    

    
    public Map<String, String> queryGoodsNameByOrderId(String orderId){
    	return payDao.queryGoodsNameByOrderId(orderId);
    }
    
    /**
     * 根据订单号查询支付方式：微信支付or沃支付or银联支付
     * @param orderId
     * @return
     */
    public Map<String, String> queryPayModeByOrderId(String orderId){
    	return payDao.queryPayModeByOrderId(orderId);
    }
    
    /**
     * 根据退款请求返回的成功失败 更新 ord_d_refund 表里的 order_state 
     * @param order_id
     * @param order_state 
     * @return
     */
    private int updatePayRefundState(String order_id, String order_state){
        return payDao.updatePayRefundState(order_id, order_state);
    }
    
    
    /**
     * 退款请求收到响应后更新订单基本表里订单状态 order_state
     * @param order_id
     * @param order_state
     * @return
     */
    private int updatePayState(String order_id, String order_state) {
        return payDao.updatePayState(order_id, order_state);
    }
    
    /**
     * 处理代客下单支付的业务逻辑
     * 所有数据库操作事务控制，发生异常全部回滚
     * 银联支付返回失败时，虽不发生异常，但也手工回滚，所以会出现 PAY_D_UNIONPAY_LOG 有日志接口调用记录，但订单表和 ord_d_pay里面没有相关记录的情况
     * @param user_id
     * @param order_id
     * @param order_fee
     * @param paramList
     * @param result
     */
    public void dealInsteadPayTx(String user_id, String order_id, String order_fee, List<Map<String, String>> paramList, Map<String, String> result){
    	//先插入ord_d_pay订单支付信息
    	beforePayReq(order_id, order_fee, paramList, result);
    	
    	//根据代金券or账户or银联快捷支付，调用不同的处理
		for(Map<String, String> payInfo : paramList){
			//如果是代金券,更新act_d_coupon状态为2，已使用
    		if(payInfo.get("pay_mode").equals("60")){
    			//boolean canUse = checkCouponLimit();
    			int n1 = updateCouponLog(payInfo.get("coupon_id"), "2", order_id); 
    			if(n1 <= 0){
    				result.put("status", "11");
    	        	result.put("detail", "代客下单代金券未找到记录");
    	        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
    	        	break; //跳出循环
    			}
    		}
    		//如果是账户支付，更新act_d_account里余额和版本，然后插入act_d_access_log变动日志
    		else if(payInfo.get("pay_mode").equals("51")){
    			useAcctForPay(user_id, payInfo.get("pay_fee"), order_id);
    		}
    		//如果是银联快捷支付
    		else if(payInfo.get("pay_mode").equals("10")){
    	        //查出银行卡签约号sign_code，用于调用银联签约号快捷支付接口
    			String bank_no = payInfo.get("bank_no");
    	        Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	        String sign_code = MD5Util.convertMD5(acctbankinfo.get("SIGN_CODE").toString());//md5解密，表里存放的是加密的
    	        Map<String, String> resultUnionPay = callUnionPay(payInfo.get("pay_fee"), order_id, sign_code); //调用银联接口
    	        //如果银联返回失败，则透传返回错误信息给前台
    		    if(!resultUnionPay.get("status").equals(UnionPayCons.RESULT_CODE_SUCCESS)){
    		    	result.put("status", resultUnionPay.get("status")); //直接把银联返回的错误编码返回
    	        	result.put("detail", resultUnionPay.get("detail"));
    		    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
    		    	break; //跳出循环
    		    }
    		}
    		else{
    		}
    	}
    }
    
    /**
     * 判断代金券使用限制条件，是否此订单可以使用此代金券
     * @return
     */
    private boolean checkCouponLimit(){
    	return true;
    }
    

    /**
     * 更新代金券表的状态
     * 如果order_id不是null，则表示是被订单代付使用，如果是null，表示是其他状态更新，比如过期失效
     * @param coupon_id
     * @param status
     * @param order_id
     * @return
     */
    private int updateCouponLog(String coupon_id, String status, String order_id) {
        return payDao.updateCouponLog(coupon_id, status, order_id);
    }
    
    private void useAcctForPay(String user_id, String pay_fee, String order_id) {
    	String acct_id = user_id + "2"; //默认现金可提账户是user_id||'2' ;
    	//查出最新的余额和版本号，在此基础上版本号+1,用乐观锁的机制更新，
    	//考虑到并发的情况，如果版本号+1进行update记录为0，需要重新查询一遍再更新
    	while(true){
    		Map<String, String> acct = queryAcctBalanceAndVersion(acct_id);
    		int balance = Integer.parseInt(acct.get("BALANCE")); //原余额
    		int version = Integer.parseInt(acct.get("VERSION")); //原版本号
    		int balanceNew = balance - Integer.parseInt(pay_fee); //变动后的账户余额
    		String versionNew = RechargeUtil.fillZero(version + 1, 8); //新版本号，数字左补0凑成8位版本号
    		int num = updateAcctBalanceAndVersion(acct_id, balanceNew, versionNew); 
    		if(num > 0){
    			//如果更新成功了才可以插accesslog日志
    			insertAcctAccessLog(acct_id, order_id, balance, -Integer.parseInt(pay_fee), balanceNew);//pay_fee负值
    			break; //跳出循环
    		}
    		log.debug("【代客下单：更新act_d_account记录为0，重试。。。】");
    	}
    }

    /**
     * 查询账户余额和版本
     * @param acct_id
     * @return
     */
    private Map<String, String> queryAcctBalanceAndVersion(String acct_id) {
        return payDao.queryAcctBalanceAndVersion(acct_id);
    }
    
    /**
     * 更新账户余额和版本
     * @param acct_id
     * @param balanceNew
     * @param versionNew
     * @return
     */
    private int updateAcctBalanceAndVersion(String acct_id, int balanceNew, String versionNew) {
        return payDao.updateAcctBalanceAndVersion(acct_id, balanceNew, versionNew);
    }
    
    /**
     * 插账户变动access_log日志
     * @param acct_id
     * @param order_id
     * @param balanceOld
     * @param pay_fee
     * @param balanceNew
     * @return
     */
    private int insertAcctAccessLog(String acct_id, String order_id, int balanceOld, int pay_fee, int balanceNew) {
        String log_id = RechargeUtil.generateLogId();
        String partition_id = log_id.substring(14, 16);
        String trade_type = "22"; //22：账户支付(现金可提)(钱为负值)
    	return payDao.insertAcctAccessLog(log_id, partition_id, acct_id, order_id, trade_type, balanceOld, pay_fee, balanceNew);
    }
    
    /**
     * 调用银联快捷支付接口，并返还结果
     * @param pay_fee
     * @param order_id
     * @param sign_code
     * @return
     */
    private Map<String, String> callUnionPay(String pay_fee, String order_id, String sign_code) {
    	UnionPayParam param = new UnionPayParam();
    	param.setOrder_id(order_id); // 真实order_id
    	param.setFee(pay_fee); // 单位厘
    	param.setSign_code(sign_code); //解密过的sign_code
    
    	return unionPayService2.unionPayPay(param);
    	
    }
}
