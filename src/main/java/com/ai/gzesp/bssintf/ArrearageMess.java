package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ArrearageMess")
public class ArrearageMess {
	
	private String ArrearageNum;
	
	private String ArrearageFee;

	public String getArrearageNum() {
		return ArrearageNum;
	}

	public void setArrearageNum(String arrearageNum) {
		ArrearageNum = arrearageNum;
	}

	public String getArrearageFee() {
		return ArrearageFee;
	}

	public void setArrearageFee(String arrearageFee) {
		ArrearageFee = arrearageFee;
	}
	
	

}
