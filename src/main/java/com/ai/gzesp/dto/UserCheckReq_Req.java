package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserCheckReq")
public class UserCheckReq_Req {
	String NumID;
	String SignMsg;
	
	public String getNumID() {
		return NumID;
	}
	public void setNumID(String numID) {
		NumID = numID;
	}
	public String getSignMsg() {
		return SignMsg;
	}
	public void setSignMsg(String signMsg) {
		SignMsg = signMsg;
	}
	
}
