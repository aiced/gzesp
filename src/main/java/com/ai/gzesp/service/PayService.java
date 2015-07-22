package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.recharge.RechargeUtil;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayUtil;
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
    public void beforePayReq(String orderId, String orderFee, List<Map<String, String>> paramList){
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
        	//第一次支付失败后，可以再次支付，支付成功后会来更新表里的记录
        	//先删除原记录再插新记录，页面前端应该限制是否有成功支付记录，成功了页面就不允许再次选择支付模式支付
        	deletePayInfoBatch(orderId);
        	insertPayInfoBatch(orderId, orderFee, payInfoList);
        }
    } 
    
    
    private List<Map<String, String>> queryOrderDPay(String orderId){
        return payDao.queryOrderDPay(orderId);
    }
    
	/**
	 * 支付失败，再次支付时，先删除原支付记录ord_d_pay,再插新的
	 * @param orderId
	 */
	private int deletePayInfoBatch(String orderId) {
        return payDao.deletePayInfoBatch(orderId); 
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
     * 代客下单 代金券and账户and银联 全部完成后，除了更新各自的log日志表外，还有一系列后续操作
     * 1.更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
     * 2.新增一条 ORD_L_DEALLOG 处理日志
     * 3.更新 ord_d_pay 里 状态
     * 4.如果有号码预占而且支付返回响应是成功的则删掉号码预占表信息
     * 
     * orderFee 订单应收金额，incomeFee 实收金额=订单应收金额-代金券金额，单位厘
     * 
     * @param pay_mode
     * @param isSuccess
     * @param orderId
     * @param orderFee
     * @param incomeFee
     */
    public void afterInsteadPaySuccess(String pay_mode, boolean isSuccess, String orderId, int orderFee, int incomeFee){
    	//更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
    	if(isSuccess){
    	   int r1 = updatePayStateAndIncomeMoney(isSuccess, orderId, incomeFee);
    	}
    	//如果支付成功 则新增一条 ORD_L_DEALLOG 处理日志
    	if(isSuccess){
    		int r2 = insertDealLogAfterPaySuccess(orderId, orderFee);
    	}
    	
    	//如果收到响应，不管成功失败 都要更新ord_d_pay 里的状态,1 成功，2失败
//    	String pay_state = isSuccess ? "1" : "2" ;
//    	int r3 = updateOrdDPay(orderId, pay_state, pay_mode);
    	
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
     * @param isSuccess
     * @param orderId
     */
    public void afterRefundSuccess(boolean isSuccess, String orderId){
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
    		int r3 = updateOrdDPayRefund(orderId, "5");
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
    			"02"   //CURRENT_STATE,订单现状态，01待分配。 2015070 要求跳过外呼步骤直接改成02: 待处理
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
    
    /**
     * 退款成功后，更新ord_d_pay 该order_id的所有记录状态为5，退款成功
     * @param orderId
     * @param pay_state
     * @return
     */
    private int updateOrdDPayRefund(String orderId, String pay_state){
        return payDao.updateOrdDPayRefund(orderId, pay_state);
    }
    

    
    public Map<String, String> queryGoodsNameByOrderId(String orderId){
    	return payDao.queryGoodsNameByOrderId(orderId);
    }
    
    /**
     * 根据订单号查询支付方式：微信支付or沃支付or银联全要素支付 or代金券or账户or银联签约号z
     * 能人代客下单后一个订单号存在多条记录
     * @param orderId
     * @return
     */
    public List<Map<String, String>> queryPayModeByOrderId(String orderId){
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
     * 银联支付因为是异步响应，事务处理太复杂，所以没有用事务
     * 存在问题1，因为没有事务，可能代金券或者账户某一个处理异常了前面的操作不会回滚
     * 存在问题1，极端情况如果代金券或者账户都失败了，只会返回最后一个错误，前面的错误原因会被覆盖，可以考虑返回list
     * 注意代码里 null 和 MapUtils.isNotEmpty 的使用区别：null代表没有这个子记录，MapUtils.isNotEmpty表示处理成功无异常
     * @param user_id
     * @param order_id
     * @param order_fee
     * @param paramList
     * @param result
     */
    public void dealInsteadPay(String user_id, String order_id, String order_fee, List<Map<String, String>> paramList, Map<String, String> result){
    	log.info("【代客下单入参：" + paramList + "】"); //这边用info，以便系统稳定后也能打印出入参
    	int incomeFee = Integer.parseInt(order_fee); //实收金额=订单应收金额-代金券金额，单位厘
    	
    	//先插入ord_d_pay订单支付信息
    	beforePayReq(order_id, order_fee, paramList);
    	
        //因为银联是异步响应的，如果支付里有银联接口，放最前面调，成功了再执行代金券和账户的支付，失败了直接不执行
    	Map<String, String> resultUnionPay = null;
        for(Map<String, String> payInfo : paramList){
        	//如果是银联快捷支付,这里只插日志表和发送请求，因为响应时异步的，无法在这个事务里处理
    		if(payInfo.get("pay_mode").equals("10")){
    			//此方法会透传返回银联的错误或者成功编码
    			resultUnionPay = insteadPayUnionPay(user_id, order_id, payInfo);
    			if(MapUtils.isNotEmpty(resultUnionPay)){
    				result.put("status", resultUnionPay.get("status"));
    				result.put("detail", resultUnionPay.get("detail"));
    			}
    		    break; //执行完跳出循环
    		}
        }
        
        //如果resultUnionPay空，表示银联返回成功或者上面for循环没有银联接口需要调，则继续执行 代金券和账户的处理
        Map<String, String> resultCoupon = null;
        Map<String, String> resultAcct = null;
	    if(MapUtils.isEmpty(resultUnionPay)){
	    	//根据代金券or账户，调用不同的处理，银联快捷支付已经处理过无需再次处理
			for(Map<String, String> payInfo : paramList){
				//如果是代金券,更新act_d_coupon状态为2，已使用
	    		if(payInfo.get("pay_mode").equals("60")){
	    			//boolean canUse = checkCouponLimit(); //检查代金券使用条件
	    			incomeFee -= Integer.parseInt(payInfo.get("pay_fee")); //减去代金券金额
	    			resultCoupon = insteadPayCoupon(payInfo.get("coupon_id"), order_id, payInfo.get("pay_mode")); 
	    			if(MapUtils.isNotEmpty(resultCoupon)){
	    				result.put("status", resultCoupon.get("status"));
	    				result.put("detail", resultCoupon.get("detail"));
	    			}
	    		}
	    		//如果是账户支付，更新act_d_account里余额和版本，然后插入act_d_access_log变动日志
	    		else if(payInfo.get("pay_mode").equals("51")){
	    			resultAcct = insteadPayAcct(user_id, payInfo.get("pay_fee"), order_id, payInfo.get("pay_mode"));
	    			if(MapUtils.isNotEmpty(resultAcct)){
	    				result.put("status", resultAcct.get("status"));
	    				result.put("detail", resultAcct.get("detail"));
	    			}
	    		}
	    	}
			
	    }
	    
	    //更新支付表 ORD_D_PAY 里 代金券and账户and银联 子记录的支付状态为1-支付成功,2失败
	    if(resultUnionPay != null || resultCoupon != null || resultAcct != null){
	    	int n1 = updateOrdDPayStateBatch(order_id, resultUnionPay, resultCoupon, resultAcct);
	    	if(n1 < 0){
	    		result.put("status", "31");
	    		result.put("detail", "更新订单支付表状态记录数为0");
	    	}
	    }
	    
	    //调用公共service，做后续的统一的操作
	    boolean isSuccess = true; //三部分支付都成功才算成功
	    if(MapUtils.isEmpty(resultUnionPay) || MapUtils.isNotEmpty(resultCoupon) || MapUtils.isNotEmpty(resultAcct)){
	    	isSuccess = false;
	    }
        afterInsteadPaySuccess("10", isSuccess, order_id, Integer.parseInt(order_fee), incomeFee); //全要素支付是15，签约号支付时10
    }
    
    
    /**
     * 判断代金券使用限制条件，是否此订单可以使用此代金券
     * @return
     */
    private boolean checkCouponLimit(){
    	return true;
    }
    

    /**
     * 用代金券支付部分订单金额
     * 1.更新代金券表ACT_D_COUPON的状态
     * 2.更新支付表 ORD_D_PAY 里代金券子记录的支付状态
     * 如果order_id不是null，则表示是被订单代付使用，如果是null，表示是其他状态更新，比如过期失效
     * @param coupon_id
     * @param order_id
     * @param pay_mode
     * @return
     */
    private Map<String, String> insteadPayCoupon(String coupon_id, String order_id, String pay_mode) {
    	Map<String, String> result = new HashMap<String, String>();

    	//更新代金券表ACT_D_COUPON的状态 2：已使用
        int n1 = payDao.updateCouponLog(coupon_id, "2", order_id);
        if(n1 < 1){
        	result.put("status", "11");
        	result.put("detail", "代客下单代金券" + coupon_id + "未找到记录");
        	return result;
        }
        
        return result;
    }
    
    /**
     * 用现金账户里的金额支付部分订单金额
     * @param user_id
     * @param pay_fee
     * @param order_id
     * @param pay_mode
     * @return
     */
    private Map<String, String> insteadPayAcct(String user_id, String pay_fee, String order_id, String pay_mode) {
    	Map<String, String> result = new HashMap<String, String>();
    	
    	String acct_id = user_id + "2"; //默认现金可提账户是user_id||'2' ;
    	//查出最新的余额和版本号，在此基础上版本号+1,用乐观锁的机制更新，
    	//考虑到并发的情况，如果版本号+1进行update记录为0，需要重新查询一遍再更新，最多尝试5次
    	int num = 1;
    	while(true){
    		if(num > 5){
    			result.put("status", "21");
            	result.put("detail", "代客下单更新账户信息表ACT_D_ACCOUNT失败5次，不再尝试");
    			break;
    		}
    		
    		log.debug("【代客下单：更新act_d_account记录为0，acct_id=" + acct_id + ",第" + num + "次尝试。。。】");
    		
    		Map<String, String> acct = queryAcctBalanceAndVersion(acct_id);
    		int balance = Integer.parseInt(acct.get("BALANCE")); //原余额
    		int version = Integer.parseInt(acct.get("VERSION")); //原版本号
    		int balanceNew = balance - Integer.parseInt(pay_fee); //变动后的账户余额
    		String versionNew = RechargeUtil.fillZero(version + 1, 8); //新版本号，数字左补0凑成8位版本号
    		int n1 = updateAcctBalanceAndVersion(acct_id, balanceNew, versionNew); 
    		if(n1 > 0){
    			//如果更新成功了才可以插accesslog日志 22：账户支付(现金可提)(钱为负值)
    			int n2 = insertAcctAccessLog(acct_id, order_id, "22", balance, -Integer.parseInt(pay_fee), balanceNew);//pay_fee负值
    			//如果n1和n2都成功，更新支付表 ORD_D_PAY 里账户子记录的支付状态为1-支付成功
//    			if(n2 > 0){
//    		        int n3 = payDao.updateOrdDPay(order_id, n2>0?"1":"2", pay_mode);	
//    			}
    			if(n2 < 0){
    				result.put("status", "22");
                	result.put("detail", "代客下单插入账户变动日志表ACT_D_ACCESS_LOG失败，acct_id=" + acct_id);
    			}
    			
    			break; //跳出循环
    		}
    		
    		num++; //计数器+1
    	}
    	
    	return result;
    }
    
    /**
     * 现金账户退款52。(代客下单时用 现金账户支付22)
     * @param order_id
     * @return
     */
    public Map<String, String> refundOrderAcct(String order_id) {
    	Map<String, String> result = new HashMap<String, String>();
    	
    	//先从act_d_access_log关联act_d_account表查询出订单支付时账户的变动金额和当前账户的余额和版本
    	Map<String, String> AccessLogAndBalance = payDao.queryAccessLogAndBalanceByOrderId(order_id);
    	
    	if(MapUtils.isEmpty(AccessLogAndBalance)){
    		result.put("result_code", "FAIL") ;
    		result.put("result_desc", "没有找到账户支付成功记录") ;
    		return result;
    	}
    	
    	String acct_id = AccessLogAndBalance.get("ACCT_ID"); 
    	//查出最新的余额和版本号，在此基础上版本号+1,用乐观锁的机制更新，
    	//考虑到并发的情况，如果版本号+1进行update记录为0，需要重新查询一遍再更新，最多尝试5次
    	int num = 1;
    	while(true){
    		if(num > 5){
    			result.put("result_code", "FAIL");
            	result.put("result_desc", "现金账户退款更新账户信息表ACT_D_ACCOUNT失败5次，不再尝试");
    			break;
    		}
    		
    		log.debug("【退款：更新act_d_account记录为0，acct_id=" + acct_id + ",第" + num + "次尝试。。。】");
    		
    		int balance = Integer.parseInt(AccessLogAndBalance.get("BALANCE")); //原余额
    		int version = Integer.parseInt(AccessLogAndBalance.get("VERSION")); //原版本号
    		int fee = Integer.parseInt(AccessLogAndBalance.get("FEE")); //accesslog表里是负值
    		int balanceNew = balance - fee; //变动后的账户余额
    		String versionNew = RechargeUtil.fillZero(version + 1, 8); //新版本号，数字左补0凑成8位版本号
    		int n1 = updateAcctBalanceAndVersion(acct_id, balanceNew, versionNew); 
    		if(n1 > 0){
    			//如果更新成功了才可以插accesslog日志
    			int n2 = insertAcctAccessLog(acct_id, order_id, "52", balance, -fee, balanceNew);//fee正值
    			if(n2 < 0){
    				result.put("result_code", "FAIL");
                	result.put("result_desc", "现金账户退款插入账户变动日志表ACT_D_ACCESS_LOG失败，acct_id=" + acct_id);
    			}
    			
    			break; //跳出循环
    		}
    		
    		num++; //计数器+1
    	}
    	
    	return result;
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
     * @param trade_type
     * @param balanceOld
     * @param pay_fee
     * @param balanceNew
     * @return
     */
    private int insertAcctAccessLog(String acct_id, String order_id, String trade_type, int balanceOld, int pay_fee, int balanceNew) {
        String log_id = RechargeUtil.generateLogId();
        String partition_id = log_id.substring(14, 16);
        //String trade_type = "22"; //22：账户支付(现金可提)(钱为负值)
    	return payDao.insertAcctAccessLog(log_id, partition_id, acct_id, order_id, trade_type, balanceOld, pay_fee, balanceNew);
    }
    
    /**
     * 调用银联快捷支付接口，并返还结果
     * @param pay_fee
     * @param order_id
     * @param sign_code
     * @return
     */
    public Map<String, String> insteadPayUnionPay(String user_id,  String order_id,  Map<String, String> payInfo) {
    	//查出银行卡签约号sign_code，用于调用银联签约号快捷支付接口
    	String bank_no = payInfo.get("bank_no");
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	String sign_code = MD5Util.convertMD5(acctbankinfo.get("SIGN_CODE").toString());//md5解密，表里存放的是加密的
    	//String sign_code = "123457678";
    	
    	UnionPayParam param = new UnionPayParam();
    	param.setOrder_id(order_id); // 真实order_id
    	param.setFee(payInfo.get("pay_fee")); // 单位厘
    	param.setSign_code(sign_code); //解密过的sign_code
    	
        String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.pay.getTradeType()); //系统跟踪号
        param.setPay_sys_trade_no(sysTradeNo);
        String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
        param.setPay_time_stamp(timeStamp);
        String tradeType = TradeType.pay.getTradeType(); //业务类型
        param.setPay_trade_type(tradeType);
        String orderIdVir = UnionPayUtil.orderId2newOrderId(param.getOrder_id(), param.getPay_sys_trade_no()); //虚拟订单号，每次支付不重复
        param.setOrder_id_vir(orderIdVir);
        
    	return unionPayService2.unionPayPay(param);
    }
    
    /**
     * 更新支付表 ORD_D_PAY 里 代金券and账户and银联 子记录的支付状态为1-支付成功,2失败
     * @param order_id
     * @param resultCoupon
     * @param resultAcct
     */
    private int updateOrdDPayStateBatch(String order_id, Map<String, String> resultUnionPay, Map<String, String> resultCoupon, Map<String, String> resultAcct){
	    List<Map<String, String>> stateList = new ArrayList<Map<String, String>>();
	    
	    if(resultUnionPay != null){
	    	Map<String, String> unionPay = new HashMap<String, String>();
	    	unionPay.put("pay_mode", "10");
	    	unionPay.put("pay_state", MapUtils.isEmpty(resultUnionPay) ? "1" : "2");
	    	stateList.add(unionPay);
	    }
	    if(resultCoupon != null){
	    	Map<String, String> coupon = new HashMap<String, String>();
	    	coupon.put("pay_mode", "60");
	    	coupon.put("pay_state", MapUtils.isEmpty(resultCoupon) ? "1" : "2");
	    	stateList.add(coupon);
	    }
	    if(resultAcct != null){
	    	Map<String, String> acct = new HashMap<String, String>();
	    	acct.put("pay_mode", "51");
	    	acct.put("pay_state", MapUtils.isEmpty(resultAcct) ? "1" : "2");
	    	stateList.add(acct);
	    }
	    //批量更新
        return payDao.updateOrdDPayStateBatch(order_id, stateList);
    }
}
