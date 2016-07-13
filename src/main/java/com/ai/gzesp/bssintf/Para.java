package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Para")
public class Para {

	private String ParaID;
	
	private String ParaValue;

	public String getParaID() {
		return ParaID;
	}

	public String getParaValue() {
		return ParaValue;
	}

	public void setParaID(String paraID) {
		ParaID = paraID;
	}

	public void setParaValue(String paraValue) {
		ParaValue = paraValue;
	}

	
}
