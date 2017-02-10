package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PARA")
public class Para {
	
	private String PARA_ID;
	
	private String PARA_VALUE;

	public String getPARA_ID() {
		return PARA_ID;
	}

	public String getPARA_VALUE() {
		return PARA_VALUE;
	}

	public void setPARA_ID(String pARA_ID) {
		PARA_ID = pARA_ID;
	}

	public void setPARA_VALUE(String pARA_VALUE) {
		PARA_VALUE = pARA_VALUE;
	}
	
	

}
