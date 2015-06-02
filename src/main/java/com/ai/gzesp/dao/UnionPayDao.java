package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 银联接口dao<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UnionPayDao {
    
    public Map<String, String> querySignCode(@Param("bank_card_no") String bank_card_no);
    
    public int insertBindlog(@Param("pay_id") String pay_id,
            @Param("partition_id") String partition_id, @Param("pay_type") String pay_type,
            @Param("pay_mode") String pay_mode, @Param("pay_state") String pay_state,
            @Param("req_time") String req_time, @Param("req_status") String req_status,
            @Param("req_trade_type") String req_trade_type, @Param("sys_trade_no") String sys_trade_no,
            @Param("order_id") String order_id, @Param("txn_amt") String txn_amt );

    public int insertPaylog(@Param("pay_id") String pay_id,
            @Param("partition_id") String partition_id, @Param("pay_type") String pay_type,
            @Param("pay_mode") String pay_mode, @Param("pay_state") String pay_state, @Param("pay_account_no") String pay_account_no,
            @Param("req_time") String req_time, @Param("req_status") String req_status,
            @Param("req_trade_type") String req_trade_type, @Param("sys_trade_no") String sys_trade_no,
            @Param("order_id") String order_id, @Param("txn_amt") String txn_amt );
    
    public int insertUnionPaylog(@Param("log_id") String log_id,
            @Param("partition_id") String partition_id, @Param("real_order_id") String real_order_id,
            @Param("req_time") String req_time, @Param("req_status") String req_status,
            @Param("req_trade_type") String req_trade_type, @Param("sys_trade_no") String sys_trade_no,
            @Param("order_id") String order_id, @Param("txn_amt") String txn_amt );
    
    public int insertBindCancellog(@Param("pay_id") String pay_id,
            @Param("partition_id") String partition_id, @Param("pay_account_no") String pay_account_no,
            @Param("req_time") String req_time, @Param("req_status") String req_status,
            @Param("req_trade_type") String req_trade_type, @Param("sys_trade_no") String sys_trade_no,
            @Param("order_id") String order_id );    
    
    public Map<String, String> queryPaylog(@Param("pay_id") String pay_id);
    
    public Map<String, String> queryUnionPaylog(@Param("log_id") String log_id);
    
    public int updateBindlog(@Param("resp_trade_type") String resp_trade_type,
            @Param("result_code") String result_code, @Param("result_desc") String result_desc,
            @Param("resp_time") String resp_time, @Param("sys_trade_no") String sys_trade_no);
    
    public int updateBindlogNew(@Param("resp_trade_type") String resp_trade_type,
            @Param("result_code") String result_code, @Param("result_desc") String result_desc,
            @Param("resp_time") String resp_time, @Param("sys_trade_no") String sys_trade_no, @Param("pay_acunt_no") String pay_acunt_no);
    
    public int updatePaylog(@Param("resp_trade_type") String resp_trade_type,
            @Param("result_code") String result_code, @Param("result_desc") String result_desc,
            @Param("resp_time") String resp_time, @Param("pay_state") String pay_state,
            @Param("sys_trade_no") String sys_trade_no ); 
    
    public int updateUnionPaylog(@Param("resp_trade_type") String resp_trade_type,
            @Param("result_code") String result_code, @Param("result_desc") String result_desc,
            @Param("resp_time") String resp_time, @Param("sys_trade_no") String sys_trade_no ); 
    
    public int updateBindCancellog(@Param("resp_trade_type") String resp_trade_type,
            @Param("result_code") String result_code, @Param("result_desc") String result_desc,
            @Param("resp_time") String resp_time, 
            @Param("sys_trade_no") String sys_trade_no ); 
    
    public int updatePayStateAndIncomeMoney(@Param("order_id") String order_id, @Param("order_state") String order_state, @Param("income_money") int income_money);    
    
    
    public int insertPayCancellog(
    		@Param("pay_id") String pay_id,
            @Param("partition_id") String partition_id,
            @Param("req_time") String req_time, 
            @Param("req_status") String req_status,
            @Param("req_trade_type") String req_trade_type, 
            @Param("sys_trade_no") String sys_trade_no,
            @Param("orig_order_id") String orig_order_id,
            @Param("orig_timestamp") String orig_timestamp);
    
    /**
     * 功能描述: 调用绑定接口前先插记录，签约号sign_code 不填，等待银联接口返回后根据sys_trade_no更新sign_code<br>
     * 〈功能详细描述〉
     *
     * @param acc_no
     * @param cvn2
     * @param nbr
     * @param name
     * @param certificate_code
     * @param expire_date
     * @param currency_code
     * @param sys_trade_no
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int insertSignCode(@Param("acc_no") String acc_no, @Param("cvn2") String cvn2, @Param("nbr") String nbr, 
            @Param("name") String name, @Param("certificate_code") String certificate_code, @Param("expire_date") String expire_date, 
            @Param("currency_code") String currency_code, @Param("sys_trade_no") String sys_trade_no,  @Param("valid_flag") String valid_flag);
    
    public int updateSignCode(@Param("sign_code") String sign_code, @Param("valid_flag") String valid_flag,
            @Param("sys_trade_no") String sys_trade_no );
    
    public int updateSignCodeValidFlag(@Param("sign_code") String sign_code, @Param("valid_flag") String valid_flag);
    
    
    public Map<String, String> queryBindResultRow(@Param("sys_trade_no") String sys_trade_no);

}
