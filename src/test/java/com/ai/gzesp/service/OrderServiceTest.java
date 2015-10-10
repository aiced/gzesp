package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceTest extends BaseTest {
    
	@Autowired
    private OrderService orderService;
    
	
	@Test
	public void test2(){
    	String user_id = "2015051408084496";
    	String phone_number = ""; //18685249827
    	String is_ok = ""; // 1身份证已经补录，0身份证未补录，“”表示全部
    	String start_day = "2015-01-01";
    	String end_day = "2016-01-01";
    	String pageNum = "1";
    	String pageSize = "10";
    	
    	List<Map<String, String>> list = orderService.queryOfflineOrders(
				user_id, is_ok, phone_number, start_day, end_day, pageNum,
				pageSize);
    	
		System.out.println(list);
	}
	
	@Test
	public void test3(){
    	HashMap<String, String> result = new HashMap<String, String>();
    	String order_id = "1581437469672119";
    	String pspt_no = "370402198707172514";
    	String cust_name = "文辉";
    	
		int n1 = orderService.updateOrderPsptNo(order_id, pspt_no, cust_name);
		int n2 = orderService.updateOrderCustName(order_id, cust_name);
		int n3 = orderService.updateOrderState(order_id);
		if(n1 > 0 && n2 > 0 && n3 > 0){
			result.put("result_code", "00");
			result.put("result_desc", "更新身份证成功");
			//再加上录单请求需要传给沃易登的数据
		}
		else{
			result.put("result_code", "01");
			result.put("result_desc", "订单号" + order_id + "更新身份证失败");
		}
		
		System.out.println(result);
	}
}
