package com.ai.gzesp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BandTest  extends BaseTest {

	
	@Autowired
	private BssBandService bssBandService;
	
	@Test
	public void test1(){
		String order_id="3981438849124645";
		String strRet=bssBandService.ReqProAndActPacket(order_id);

	}
	
}
