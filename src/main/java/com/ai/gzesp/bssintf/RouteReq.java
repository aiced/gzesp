package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.15	路由查询
 * @author xmh
 *
 */
@XStreamAlias("Req")
public class RouteReq {
	
	private String UserNumber;

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}
	
	
}
