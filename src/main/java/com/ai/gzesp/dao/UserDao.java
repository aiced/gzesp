package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	public Map<Object, Object> getUserInfoByPhone(@Param("phone_number") String phone_number);
	
	public Map<Object, Object> getUserInfoByPhonePassword(@Param("phone_number") String phone_number, @Param("password") String password);
	
	public Map<Object, Object> getUserInfoByOpenId(@Param("open_id") String open_id);
	
}
