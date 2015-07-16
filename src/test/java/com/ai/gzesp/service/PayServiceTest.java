package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PayServiceTest extends BaseTest {

	@Autowired
	private PayService payService;

	@Test
	public void test1(){
		//返回map
    	Map<String, String> result = new HashMap<String, String>();
    	
		String user_id = "2015052804213719" ; //20150514080844962 
		String order_id = "1071435216606404" ;
		String order_fee = "25000" ;
		List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
		Map<String, String> param1 = new HashMap<String, String>();
		param1.put("pay_order", "1");
		param1.put("pay_type", "01");
		param1.put("pay_mode", "60");
		param1.put("pay_fee", "10000");
		param1.put("coupon_id", "12345678");
		paramList.add(param1);
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("pay_order", "2");
		param2.put("pay_type", "01");
		param2.put("pay_mode", "51");
		param2.put("pay_fee", "10000");
		paramList.add(param2);
		Map<String, String> param3 = new HashMap<String, String>();
		param3.put("pay_order", "3");
		param3.put("pay_type", "01");
		param3.put("pay_mode", "10");
		param3.put("pay_fee", "5000");
		param3.put("bank_no", "6226090253538876");
		paramList.add(param3);
		
		payService.dealInsteadPayTx(user_id, order_id, order_fee, paramList, result);
	}
}
