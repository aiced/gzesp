package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MyAcctDao {

	
	public Map<String, String> queryAcctByUserId(@Param("user_id") String user_id);
	public int insertAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public int updateAcctPwd(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);
	public Map<String, String> queryAcctBankByUserId(@Param("user_id") String user_id);
	public Map<String, String> queryAcctByUserId_UserPwd(@Param("user_id") String user_id,@Param("user_pwd") String user_pwd);
	
}
