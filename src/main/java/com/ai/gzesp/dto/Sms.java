package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sms")
public class Sms {
	
	@XStreamAlias("mt")
	private Mt mt;

	public Mt getMt() {
		return mt;
	}

	public void setMt(Mt mt) {
		this.mt = mt;
	}
	
	

}
