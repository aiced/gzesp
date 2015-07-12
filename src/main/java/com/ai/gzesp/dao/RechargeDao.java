package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ai.gzesp.dto.OrderDPay;
import com.ai.gzesp.recharge.InterfaceType;

/**
 * 一卡充接口用到的dao<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RechargeDao {
    
    public int updateCardList(@Param("group") Map<Integer, Integer> group, @Param("order_id") String order_id);   
    
    public List<Map<String, String>> getUseCardList(@Param("order_id") String order_id);   
    
    public Map<String, String> insertRechargeLogBatch(@Param("log_id") String log_id, 
    		@Param("partitionId") String partition_id, 
    		@Param("order_id") String order_id, 
    		@Param("req_time") String req_time, 
    		@Param("interface_Type") String interface_Type,
    		@Param("busi_type") String busi_type,   
    		@Param("serial_number") String serial_number,
    		@Param("serial_number_type") String serial_number_type, 
    		@Param("cardList") List<Map<String, String>> cardList);   
    
    
}
