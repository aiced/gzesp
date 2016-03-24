package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("sms")
public class SmsResp {
	SmsMt mt;

	public SmsMt getMt() {
		return mt;
	}

	public void setMt(SmsMt mt) {
		this.mt = mt;
	}

}
