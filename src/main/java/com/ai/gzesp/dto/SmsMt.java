package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("mt")
public class SmsMt {
	String status;
	String msgid;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	
}
