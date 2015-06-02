package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    
}
