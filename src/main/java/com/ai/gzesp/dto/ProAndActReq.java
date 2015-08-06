package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;



@XStreamAlias("ProAndActReq")
public class ProAndActReq {
	String NumID;
	String ProductCode;
	String OrigFee;
	String RealFee;
	String optTime;
	String OldProductCode;
	String SignMsg;

	public String getNumID() {
		return NumID;
	}
	public void setNumID(String numID) {
		NumID = numID;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getOrigFee() {
		return OrigFee;
	}
	public void setOrigFee(String origFee) {
		OrigFee = origFee;
	}
	public String getRealFee() {
		return RealFee;
	}
	public void setRealFee(String realFee) {
		RealFee = realFee;
	}
	public String getOptTime() {
		return optTime;
	}
	public void setOptTime(String optTime) {
		this.optTime = optTime;
	}
	public String getOldProductCode() {
		return OldProductCode;
	}
	public void setOldProductCode(String oldProductCode) {
		OldProductCode = oldProductCode;
	}
	public String getSignMsg() {
		return SignMsg;
	}
	public void setSignMsg(String signMsg) {
		SignMsg = signMsg;
	}
	
}
