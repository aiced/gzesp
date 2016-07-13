package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FeeInfo")
public class FeeInfo {

	private String FeeID;
	
	private String FeeCategory;
	
	private String FeeDes;
	
	private String MaxRelief;
	
	private String OrigFee;
	
	private String TotalFee;

	public String getFeeID() {
		return FeeID;
	}

	public void setFeeID(String feeID) {
		FeeID = feeID;
	}

	public String getFeeCategory() {
		return FeeCategory;
	}

	public void setFeeCategory(String feeCategory) {
		FeeCategory = feeCategory;
	}

	public String getFeeDes() {
		return FeeDes;
	}

	public void setFeeDes(String feeDes) {
		FeeDes = feeDes;
	}

	public String getMaxRelief() {
		return MaxRelief;
	}

	public void setMaxRelief(String maxRelief) {
		MaxRelief = maxRelief;
	}

	public String getOrigFee() {
		return OrigFee;
	}

	public void setOrigFee(String origFee) {
		OrigFee = origFee;
	}

	public String getTotalFee() {
		return TotalFee;
	}

	public void setTotalFee(String totalFee) {
		TotalFee = totalFee;
	}
	
	
}
