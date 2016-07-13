package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("NumInfo")
public class NumInfo {
	
	private String NumID;
	
	private String NumMemo;

	public String getNumID() {
		return NumID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}

	public String getNumMemo() {
		return NumMemo;
	}

	public void setNumMemo(String numMemo) {
		NumMemo = numMemo;
	}
	
	

}
