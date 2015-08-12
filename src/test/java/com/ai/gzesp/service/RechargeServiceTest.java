package com.ai.gzesp.service;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.gzesp.recharge.RechargeCons;

public class RechargeServiceTest extends BaseTest {
	
	@Autowired
	private RechargeService rechargeService;

	@Test
	public void test1(){
//		rechargeService.recharge(10000);
//		rechargeService.recharge(20000);
//		rechargeService.recharge(30000);
//		rechargeService.recharge(40000);
//		rechargeService.recharge(50000);
//		rechargeService.recharge(60000);
//		rechargeService.recharge(70000);
//		rechargeService.recharge(80000);
//		rechargeService.recharge(90000);		
//		rechargeService.recharge(100000);
//		rechargeService.recharge(110000);
//		rechargeService.recharge(120000);
//		rechargeService.recharge(130000);
//		rechargeService.recharge(140000);
//		rechargeService.recharge(150000);
//		rechargeService.recharge(160000);
//		rechargeService.recharge(170000);
//		rechargeService.recharge(180000);
//		rechargeService.recharge(190000);
//		rechargeService.recharge(200000);
//		rechargeService.recharge(210000);
//		rechargeService.rechargeTx(310000);
	}
	
	@Test
	public void test2(){
		rechargeService.syncCardStatus2BssJob();
	}
	
	@Test
	public void test3(){
		rechargeService.syncCardStatus2BssRespJob();
	}
	
	@Test
	public void test4(){
		System.out.println(StringUtils.rightPad(RechargeCons.desKey, 24, RechargeCons.keyPadChar));
		//rechargeService.syncCardStatus2BssRespJob();
	}
	
	@Test
	public void test5(){
		rechargeService.activeCardsJob();
	}
	
	@Test
	public void test9(){
		rechargeService.activeCard("850800000000037");
	}
	
	@Test
	public void test6(){
		rechargeService.recharge("12345", "18651885060", "3", 1);
	}
	
	@Test
	public void test7(){
		rechargeService.checkBillJob();
	}
	
	@Test
	public void test8(){
		rechargeService.checkBill("");
	}
}
