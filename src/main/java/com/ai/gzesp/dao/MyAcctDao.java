package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MyAcctDao {

	
	public Map<String, String> queryAcctByUserId(@Param("user_id") String user_id);
	
}
