package com.ai.gzesp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayUtil;

public class UnionPayService2Test extends BaseTest {
	
	@Autowired
	private UnionPayService2 unionPayService2;
	
	@Test
	public void testBind(){
    	UnionPayParam param = new UnionPayParam();
    	param.setBank_card_no("1234567890123");
    	param.setBank_card_cvn("421");  
    	param.setPhone_no("18651885060");
    	param.setFull_name("奚敏辉"); 
    	param.setId_card_no("320282198401162411"); //身份证
    	param.setBank_card_expire_date("1501"); //有效期
    	param.setCard_type("01");  //信用卡:01或借记卡:02
    	String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
    	param.setBind_sys_trade_no(sysTradeNo);
    	
    	unionPayService2.bindCard(param);
	}
	
	@Test
	public void testPay(){
    	UnionPayParam param = new UnionPayParam();
        param.setOrder_id("1234567890");
        param.setFee("1000");
        param.setSign_code("abcdqwertyuiopasdfghj"); //签约号要解密过的32位的
    	
    	unionPayService2.unionPayPay(param);
	}

}
