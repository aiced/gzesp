package com.ai.gzesp.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 一卡充接口用到的dao<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RechargeDao {
    
    public int lockCardList(@Param("group") Map<Integer, Integer> group, @Param("order_id") String order_id); 
    
    public int lockCard(@Param("card_value") int card_value, @Param("order_id") String order_id); 
    
    public List<Map<String, String>> getUseCardList(@Param("order_id") String order_id); 
    
    public List<Map<String, String>> getUnActiveCardList(@Param("card_no") String card_no); 
    
    public List<Map<String, String>> getRechargeLogList(@Param("log_id") String log_id); 
    
    public int insertRechargeCheckLog(
    		@Param("log_id") String log_id,
    		@Param("partition_id") String partition_id,
    		@Param("req_time") String req_time, 
    		@Param("interface_type") String interface_type,
    		@Param("serial_number") String serial_number,
    		@Param("serial_number_type") String serial_number_type); 
    
    public Map<String, String> insertRechargeLogBatch(
    		@Param("order_id") String order_id, 
    		@Param("req_time") String req_time, 
    		@Param("interface_type") String interface_type,
    		@Param("busi_type") String busi_type,   
    		@Param("serial_number") String serial_number,
    		@Param("serial_number_type") String serial_number_type, 
    		@Param("cardList") List<Map<String, String>> cardList);
    
    public Map<String, String> insertActiveLogBatch(
    		@Param("req_time") String req_time, 
    		@Param("interface_type") String interface_type,
    		@Param("busi_type") String busi_type,   
    		@Param("cardList") List<Map<String, String>> cardList);       
    
    public int updateRechargeLog(@Param("log_id") String log_id, @Param("success_flag") String success_flag,
    		@Param("result_code") String result_code, @Param("agent_balance") String agent_balance, 
    		@Param("unicon_serial_num") String unicon_serial_num, @Param("check_status") String check_status); 
    
    public int updateRechargeCard(@Param("card_no") String card_no,
    		@Param("card_status") String card_status); 
    
    public Map<String, String> getActiveLog(@Param("log_id") String log_id);   
    
    public int updateCheckStatus(@Param("log_id") String log_id, @Param("check_status") String check_status); 
    
    public List<LinkedHashMap<String, String>> getRechargedCardList(@Param("req_day") String req_day); 
    
    public int updateCardResultCode(@Param("card_no") String card_no,
    		@Param("result_code") String result_code); 
    
    public Map<String, String> queryRechargeChecklog(@Param("log_id") String log_id);   
}
