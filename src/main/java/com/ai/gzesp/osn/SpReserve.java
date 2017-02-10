package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SP_RESERVE")
public class SpReserve {
	
	private String TRANS_IDC;
	
	private String CUTOFFDAY;
	
	private String OSNDUNS;
	
	private String HSNDUNS;
	
	private String CONV_ID;

	public String getTRANS_IDC() {
		return TRANS_IDC;
	}

	public String getCUTOFFDAY() {
		return CUTOFFDAY;
	}

	public String getOSNDUNS() {
		return OSNDUNS;
	}

	public String getHSNDUNS() {
		return HSNDUNS;
	}

	public String getCONV_ID() {
		return CONV_ID;
	}

	public void setTRANS_IDC(String tRANS_IDC) {
		TRANS_IDC = tRANS_IDC;
	}

	public void setCUTOFFDAY(String cUTOFFDAY) {
		CUTOFFDAY = cUTOFFDAY;
	}

	public void setOSNDUNS(String oSNDUNS) {
		OSNDUNS = oSNDUNS;
	}

	public void setHSNDUNS(String hSNDUNS) {
		HSNDUNS = hSNDUNS;
	}

	public void setCONV_ID(String cONV_ID) {
		CONV_ID = cONV_ID;
	}
	
	
}
