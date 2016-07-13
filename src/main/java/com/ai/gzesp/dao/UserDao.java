package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	public Map<String, String> getUserInfoByPhone(@Param("phone_number") String phone_number);
	
	public Map<Object, Object> getUserInfoByPhonePassword(@Param("phone_number") String phone_number, @Param("password") String password);
	
	public Map<Object, Object> getUserInfoByOpenId(@Param("open_id") String open_id);
	
	public Map<String, String> getBusiInfo(@Param("phone_number") String phone_number);
	
	public Map<String, String> getDefaultBusiInfo(@Param("city_code") String city_code);
	
	public Map<String, String> getBssIntfInfo(@Param("user_id") String user_id);
	
	public List<String> getBssPkeParam(@Param("product_id") String product_id,
			@Param("pkeList") List<String> pkeList);
	
}
