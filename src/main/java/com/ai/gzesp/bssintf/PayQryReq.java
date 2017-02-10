package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.14	缴费记录查询接口
 * @author xmh
 *
 */
@XStreamAlias("Req")
public class PayQryReq {
	
	private String UserNumber;
	
	private String StartDate;
	
	private String EndDate;

	public String getUserNumber() {
		return UserNumber;
	}

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	

}
