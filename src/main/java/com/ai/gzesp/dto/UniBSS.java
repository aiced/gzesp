package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UniBSS")
public class UniBSS {
	String OrigDomain;
	String HomeDomain;
	String BIPCode;
	String BIPVer;
	String ActivityCode;
	String ActionCode;
	String ActionRelation;
	Routing Routing;
	String ProcID;
	String TransIDO;
	String ProcIDO;
	String TransIDH;
	String ProcessTime;
	SPReserve SPReserve;
	String TestFlag;
	String MsgSender;
	String MsgReceiver;
	String SvcContVer;
	String SvcCont;
	Response Response;
	public String getOrigDomain() {
		return OrigDomain;
	}
	public void setOrigDomain(String origDomain) {
		OrigDomain = origDomain;
	}
	public String getHomeDomain() {
		return HomeDomain;
	}
	public void setHomeDomain(String homeDomain) {
		HomeDomain = homeDomain;
	}
	public String getBIPCode() {
		return BIPCode;
	}
	public void setBIPCode(String bIPCode) {
		BIPCode = bIPCode;
	}
	public String getBIPVer() {
		return BIPVer;
	}
	public void setBIPVer(String bIPVer) {
		BIPVer = bIPVer;
	}
	public String getActivityCode() {
		return ActivityCode;
	}
	public void setActivityCode(String activityCode) {
		ActivityCode = activityCode;
	}
	public String getActionCode() {
		return ActionCode;
	}
	public void setActionCode(String actionCode) {
		ActionCode = actionCode;
	}
	public String getActionRelation() {
		return ActionRelation;
	}
	public void setActionRelation(String actionRelation) {
		ActionRelation = actionRelation;
	}
	public Routing getRouting() {
		return Routing;
	}
	public void setRouting(Routing routing) {
		Routing = routing;
	}

	public String getProcID() {
		return ProcID;
	}
	public void setProcID(String procID) {
		ProcID = procID;
	}
	public String getTransIDO() {
		return TransIDO;
	}
	public void setTransIDO(String transIDO) {
		TransIDO = transIDO;
	}
	public String getProcIDO() {
		return ProcIDO;
	}
	public void setProcIDO(String procIDO) {
		ProcIDO = procIDO;
	}
	public String getProcessTime() {
		return ProcessTime;
	}
	public void setProcessTime(String processTime) {
		ProcessTime = processTime;
	}

	public SPReserve getSPReserve() {
		return SPReserve;
	}
	public void setSPReserve(SPReserve sPReserve) {
		SPReserve = sPReserve;
	}
	public String getTestFlag() {
		return TestFlag;
	}
	public void setTestFlag(String testFlag) {
		TestFlag = testFlag;
	}
	public String getMsgSender() {
		return MsgSender;
	}
	public void setMsgSender(String msgSender) {
		MsgSender = msgSender;
	}
	public String getMsgReceiver() {
		return MsgReceiver;
	}
	public void setMsgReceiver(String msgReceiver) {
		MsgReceiver = msgReceiver;
	}
	public String getSvcContVer() {
		return SvcContVer;
	}
	public void setSvcContVer(String svcContVer) {
		SvcContVer = svcContVer;
	}
	public String getSvcCont() {
		return SvcCont;
	}
	public void setSvcCont(String svcCont) {
		SvcCont = svcCont;
	}
	public String getTransIDH() {
		return TransIDH;
	}
	public void setTransIDH(String transIDH) {
		TransIDH = transIDH;
	}
	public Response getResponse() {
		return Response;
	}
	public void setResponse(Response response) {
		Response = response;
	}

}
