package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MyAcctDao {

	
	public Map<String, String> queryAcctByUserId(@Param("user_id") String user_id);
	public int insertAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public int updateAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public List<Map<String, Object>> queryAcctBankByUserId(@Param("user_id") String user_id);
	public Map<String, String> queryAcctByUserId_UserPwd(@Param("user_id") String user_id,@Param("user_pwd") String user_pwd);
	public int insertAcctBank(
			@Param("user_id") String user_id,
			@Param("bank_no") String bank_no,
			@Param("valid_flag") String valid_flag,
			@Param("priority") String priority,
			@Param("card_type") String card_type,
			@Param("bank_type") String bank_type
			);
	public Map<String,Object> queryAcctBankDetail(@Param("user_id") String user_id,@Param("bank_no") String bank_no);
	public int delAcctBankDetail(@Param("user_id") String user_id,@Param("bank_no") String bank_no);
	public List<Map<String, Object>> queryAcctBalanceLog(@Param("user_id") String user_id,@Param("iFlag") int iFlag,@Param("page_num") int page_num,@Param("page_size") int page_size,@Param("update_time") String update_time);
	public List<Map<String, Object>> queryAcctBalanceLogPage(@Param("user_id") String user_id,@Param("iFlag") int iFlag,@Param("page_num") int page_num,@Param("page_size") int page_size,@Param("update_time") String update_time);

}
