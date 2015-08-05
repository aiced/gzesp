package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SPReserve")
public class SPReserve {
	String TransIDC;
	String CutOffDay;
	String OSNDUNS;
	String HSNDUNS;
	String ConvID;
	public String getTransIDC() {
		return TransIDC;
	}
	public void setTransIDC(String transIDC) {
		TransIDC = transIDC;
	}
	public String getCutOffDay() {
		return CutOffDay;
	}
	public void setCutOffDay(String cutOffDay) {
		CutOffDay = cutOffDay;
	}
	public String getOSNDUNS() {
		return OSNDUNS;
	}
	public void setOSNDUNS(String oSNDUNS) {
		OSNDUNS = oSNDUNS;
	}
	public String getHSNDUNS() {
		return HSNDUNS;
	}
	public void setHSNDUNS(String hSNDUNS) {
		HSNDUNS = hSNDUNS;
	}
	public String getConvID() {
		return ConvID;
	}
	public void setConvID(String convID) {
		ConvID = convID;
	}
	
}
