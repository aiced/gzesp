package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ai.gzesp.dto.OrderDPay;

/**
 * 支付公共接口dao<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface PayDao {
    

    public Map<Object, Object> queryUserIdByOrderId(@Param("order_id") String order_id);
    
    public int updatePayStateAndIncomeMoney(@Param("order_id") String order_id, @Param("order_state") String order_state, @Param("income_money") int income_money);  
    
    public int updateCardPayStateAndIncomeMoney(@Param("order_id") String order_id, @Param("order_state") String order_state, @Param("income_money") int income_money);  
    
    public int updateBandPayStateAndIncomeMoney(@Param("order_id") String order_id, @Param("order_state") String order_state, @Param("income_money") int income_money);    
   
    public int insertDealLog(@Param("operate_logid") String operate_logid, @Param("order_id") String order_id, @Param("partition_id") String partition_id, 
    		@Param("deal_content") String deal_content, @Param("result_code") String result_code, @Param("result_info") String result_info,
    		@Param("original_state") String original_state, @Param("current_state") String current_state);    
    
    public List<Map<String, String>> queryOrderDPay(@Param("order_id") String order_id);
    
    public int deletePayInfoBatch(@Param("order_id") String order_id);  
    
    public Map<String, String> insertPayInfoBatch(@Param("list") List<OrderDPay> list);    
    
    public int updateOrdDPay(@Param("order_id") String order_id, @Param("pay_state") String pay_state, @Param("pay_mode") String pay_mode);
    
    public int updateOrdDPayRefund(@Param("order_id") String order_id, @Param("pay_state") String pay_state);
    
    public Map<String, String> queryPhoneByOrderId(@Param("order_id") String order_id);
    
    public Map<String, String> queryGoodsNameByOrderId(@Param("order_id") String order_id);
    
    public List<Map<String, String>> queryPayModeByOrderId(@Param("order_id") String order_id);
    
    public int updatePayRefundState(@Param("order_id") String order_id, @Param("refund_state") String refund_state);    
    
    public int updatePayState(@Param("order_id") String order_id, @Param("order_state") String order_state);   
    
    public int updatePayStateBand(@Param("order_id") String order_id, @Param("order_state") String order_state); 
    
    public Map<String, String> queryRefundInfoByOrderId(@Param("order_id") String order_id);
    
    public Map<String, String> queryAccessLogAndBalanceByOrderId(@Param("order_id") String order_id);
    
    public int updateCouponLog(@Param("coupon_id") String coupon_id, @Param("status") String status, @Param("order_id") String order_id); 
    
    public Map<String, String> queryAcctBalanceAndVersion(@Param("acct_id") String acct_id);
    
    public int updateAcctBalanceAndVersion(@Param("acct_id") String acct_id, @Param("balance") int balance, @Param("version") String version);
    
    public int insertAcctAccessLog(@Param("log_id") String log_id, @Param("partition_id") String partition_id, 
    		@Param("acct_id") String acct_id, @Param("order_id") String order_id, 
    		@Param("trade_type") String trade_type, @Param("old_balance") int old_balance, 
    		@Param("fee") int fee, @Param("new_balance") int new_balance);
    
    public int updateOrdDPayStateBatch(@Param("order_id") String order_id, @Param("stateList") List<Map<String, String>> stateList);    
    
    public Map<String, String> queryOrderCardPayInfo(@Param("order_id") String order_id);
}
