package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.13	移网缴费
 * @author xmh
 *
 */
@XStreamAlias("Req")
public class PayReq {
	
	private String UserNumber;
	
	private String Money;

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}

	public String getMoney() {
		return Money;
	}

	public void setMoney(String money) {
		Money = money;
	}
	
	
}
