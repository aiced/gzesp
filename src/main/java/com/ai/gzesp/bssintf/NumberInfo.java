package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("NumberInfo")
public class NumberInfo {
	
	private String NumID;
	
	private String NumGrade;
	
	private String TailNumType;
	
	private String NumProtPer;
	
	private String NumStoredFee;
	
	private String NumThawPro;
	
	private String NumMonthLowFee;
	
	private String FirstMonthAmount;
	
	private String EndMonthAmount;
	

	public String getNumID() {
		return NumID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}

	public String getNumGrade() {
		return NumGrade;
	}

	public String getTailNumType() {
		return TailNumType;
	}

	public String getNumProtPer() {
		return NumProtPer;
	}

	public String getNumStoredFee() {
		return NumStoredFee;
	}

	public String getNumThawPro() {
		return NumThawPro;
	}

	public String getNumMonthLowFee() {
		return NumMonthLowFee;
	}

	public String getFirstMonthAmount() {
		return FirstMonthAmount;
	}

	public String getEndMonthAmount() {
		return EndMonthAmount;
	}

	public void setNumGrade(String numGrade) {
		NumGrade = numGrade;
	}

	public void setTailNumType(String tailNumType) {
		TailNumType = tailNumType;
	}

	public void setNumProtPer(String numProtPer) {
		NumProtPer = numProtPer;
	}

	public void setNumStoredFee(String numStoredFee) {
		NumStoredFee = numStoredFee;
	}

	public void setNumThawPro(String numThawPro) {
		NumThawPro = numThawPro;
	}

	public void setNumMonthLowFee(String numMonthLowFee) {
		NumMonthLowFee = numMonthLowFee;
	}

	public void setFirstMonthAmount(String firstMonthAmount) {
		FirstMonthAmount = firstMonthAmount;
	}

	public void setEndMonthAmount(String endMonthAmount) {
		EndMonthAmount = endMonthAmount;
	}

	

}
