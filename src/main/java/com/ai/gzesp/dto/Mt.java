package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("mt")
public class Mt {

	@XStreamAlias("status")
	private String status;
	
	@XStreamAlias("msgid")
	private String msgid;

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
