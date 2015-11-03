package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	

	
	@Test
	public void test1(){
		Map<String, String> busiInfo = userService.getBusiInfo("18651885060");
		System.out.println(busiInfo);
	}
	


}
