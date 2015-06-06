package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
   
    public int insertDealLog(@Param("operate_logid") String operate_logid, @Param("order_id") String order_id, @Param("partition_id") String partition_id, 
    		@Param("deal_content") String deal_content, @Param("result_code") String result_code, @Param("result_info") String result_info,
    		@Param("original_state") String original_state, @Param("current_state") String current_state);    
    
    public List<Map<String, String>> queryOrderDPay(@Param("order_id") String order_id);
    
    public Map<String, String> insertPayInfoBatch(@Param("list") List<OrderDPay> list);    
    
    public int updateOrdDPay(@Param("order_id") String order_id, @Param("pay_state") String pay_state, @Param("pay_mode") String pay_mode);    
    
    public Map<String, String> queryPhoneByOrderId(@Param("order_id") String order_id);
    
    public Map<String, String> queryGoodsNameByOrderId(@Param("order_id") String order_id);
    
    public Map<String, String> queryPayModeByOrderId(@Param("order_id") String order_id);
    
    public int updatePayRefundState(@Param("order_id") String order_id, @Param("refund_state") String refund_state);    
    
    public int updatePayState(@Param("order_id") String order_id, @Param("order_state") String order_state);    
    
    public Map<String, String> queryRefundInfoByOrderId(@Param("order_id") String order_id);
}
