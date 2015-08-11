package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

public interface MyAcctDao {

	
	public Map<String, Object> queryAcctByUserId(@Param("user_id") String user_id);
	public int insertAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public int insertAccount(@Param("user_id") String user_id,@Param("acct_id") String acct_id,@Param("balance") String balance,@Param("acct_type") String acct_type,@Param("acct_status") String acct_status,@Param("version") String version);
	public int updateAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public List<Map<String, Object>> queryAcctBankByUserId(@Param("user_id") String user_id);
	public Map<String, String> queryAcctByUserId_UserPwd(@Param("user_id") String user_id,@Param("user_pwd") String user_pwd);
	public int insertAcctBank(
			@Param("user_id") String user_id,
			@Param("bank_no") String bank_no,
			@Param("cvn2") String cvn2,
			@Param("phone") String phone,
			@Param("name") String name,
			@Param("certificate_code") String certificate_code,
			@Param("expire_date") String expire_date,
			@Param("card_type") String card_type,
			@Param("bank_type") String bank_type,
			@Param("sign_code") String sign_code,
			@Param("valid_flag") String valid_flag,
			@Param("priority") String priority,
			@Param("sys_trade_no") String sys_trade_no
			);
	
	public int updateAcctBank(
			@Param("user_id") String user_id,
			@Param("bank_no") String bank_no,
			@Param("cvn2") String cvn2,
			@Param("phone") String phone,
			@Param("name") String name,
			@Param("certificate_code") String certificate_code,
			@Param("expire_date") String expire_date,
			@Param("card_type") String card_type,
			@Param("bank_type") String bank_type,
			@Param("sign_code") String sign_code,
			@Param("valid_flag") String valid_flag,
			@Param("priority") String priority,
			@Param("sys_trade_no") String sys_trade_no
			);
	
	public Map<String,Object> queryAcctBankDetail(@Param("user_id") String user_id,@Param("bank_no") String bank_no);
	public int delAcctBankDetail(@Param("user_id") String user_id,@Param("bank_no") String bank_no);
	public List<Map<String, Object>> queryAcctBalanceLog(@Param("user_id") String user_id,@Param("iFlag") int iFlag,@Param("page_num") int page_num,@Param("page_size") int page_size,@Param("update_time") String update_time);
	public List<Map<String, Object>> queryAcctBalanceLogPage(@Param("user_id") String user_id,@Param("iFlag") int iFlag,@Param("page_num") int page_num,@Param("page_size") int page_size,@Param("update_time") String update_time);
	public Map<String, String> queryToPayMoneyByOrderId(@Param("order_id") String order_id);
	public Map<String, String> queryToPayMoneyCardByOrderId(@Param("order_id") String order_id);	
	
	public int insertWidthDrawAuDit(@Param("log_id") String log_id,@Param("partition_id") String partition_id,@Param("apply_time") String apply_time,@Param("user_id") String user_id,@Param("dwithdraw_fee") Double dwithdraw_fee,@Param("audit_state") String audit_state,@Param("bank_no") String bank_no,@Param("bank_type") String bank_type);
	
}
