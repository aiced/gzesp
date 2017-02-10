package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PayRecord")
public class PayRecord {

	private String chargeId;
	
	private String acctId;
	
	private String payName;
	
	private String channelId;
	
	private String recvFee;
	
	private String recvDepartId;
	
	private String recvStaffId;
	
	private String recvTime;
	
	private String cancelTag;

	public String getChargeId() {
		return chargeId;
	}

	public String getAcctId() {
		return acctId;
	}

	public String getPayName() {
		return payName;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getRecvFee() {
		return recvFee;
	}

	public String getRecvDepartId() {
		return recvDepartId;
	}

	public String getRecvStaffId() {
		return recvStaffId;
	}

	public String getRecvTime() {
		return recvTime;
	}

	public String getCancelTag() {
		return cancelTag;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setRecvFee(String recvFee) {
		this.recvFee = recvFee;
	}

	public void setRecvDepartId(String recvDepartId) {
		this.recvDepartId = recvDepartId;
	}

	public void setRecvStaffId(String recvStaffId) {
		this.recvStaffId = recvStaffId;
	}

	public void setRecvTime(String recvTime) {
		this.recvTime = recvTime;
	}

	public void setCancelTag(String cancelTag) {
		this.cancelTag = cancelTag;
	}

	
}
