package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ProCompInfo")
public class ProCompInfo {
	
	private String ProComponentID;
	
	private String BusiID;
	
	private String ProFinanceID;

	public String getProComponentID() {
		return ProComponentID;
	}

	public void setProComponentID(String proComponentID) {
		ProComponentID = proComponentID;
	}

	public String getBusiID() {
		return BusiID;
	}

	public void setBusiID(String busiID) {
		BusiID = busiID;
	}

	public String getProFinanceID() {
		return ProFinanceID;
	}

	public void setProFinanceID(String proFinanceID) {
		ProFinanceID = proFinanceID;
	}
	
	

}
