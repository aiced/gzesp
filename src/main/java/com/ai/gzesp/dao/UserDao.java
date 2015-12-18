package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	public Map<String, String> getUserInfoByPhone(@Param("phone_number") String phone_number);
	
	public Map<Object, Object> getUserInfoByPhonePassword(@Param("phone_number") String phone_number, @Param("password") String password);
	
	public Map<Object, Object> getUserInfoByOpenId(@Param("open_id") String open_id);
	
	public Map<String, String> getBusiInfo(@Param("phone_number") String phone_number);
	
	public Map<String, String> getDefaultBusiInfo(@Param("city_code") String city_code);
	
}
