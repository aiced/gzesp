package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AppDao {

	public Map<String, String> queryLatestVersion(@Param("os") String os);
	
	public int updateOrderIntfStatus(@Param("phone_number") String phone_number, @Param("intf_order_status") String intf_order_status, 
			@Param("intf_order_desc") String intf_order_desc,
			@Param("prov_order_id") String prov_order_id,
			@Param("orig_total_fee") String orig_total_fee);
	
	public int updateWriteCardStatus(@Param("phone_number") String phone_number, @Param("write_card_status") String write_card_status);
}
