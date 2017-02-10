package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.12	移网应缴费用查询
 * @author xmh
 *
 */
@XStreamAlias("Req")
public class FeeQryReq {
	
	private String UserNumber;

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}
	
	
}
