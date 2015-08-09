package com.ai.gzesp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BandTest  extends BaseTest {

	
	@Autowired
	private BssBandService bssBandService;
	
	@Test
	public void test1(){
		String order_id="3181438926530413";
		String strRet=bssBandService.ReqProAndActPacket(order_id);

	}
	@Test
	public void test2()
	{
		bssBandService.syncBandStatus2BssJob();
	}
	@Test
	public void test3()
	{
		bssBandService.syncBandStatus2BssRespJob();
	}
}
