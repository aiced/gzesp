package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UNI_BSS_HEAD")
public class UniBssHead {
	
	private String ORIG_DOMAIN;
	
	private String SERVICE_NAME;
	
	private String OPERATE_NAME;

	private String ACTION_CODE;
	
	private String ACTION_RELATION;
	
	private Routing ROUTING;
	
	private String PROC_ID;
	
	private String TRANS_IDO;
	
	private String PROCESS_TIME;
	
	private ComBusInfo COM_BUS_INFO;
	
	private SpReserve SP_RESERVE;
	
	private String TEST_FLAG;
	
	private String MSG_SENDER;
	
	private String MSG_RECEIVER;

	public String getORIG_DOMAIN() {
		return ORIG_DOMAIN;
	}

	public String getSERVICE_NAME() {
		return SERVICE_NAME;
	}

	public String getOPERATE_NAME() {
		return OPERATE_NAME;
	}

	public String getACTION_CODE() {
		return ACTION_CODE;
	}

	public String getACTION_RELATION() {
		return ACTION_RELATION;
	}

	public Routing getROUTING() {
		return ROUTING;
	}

	public String getPROC_ID() {
		return PROC_ID;
	}

	public String getTRANS_IDO() {
		return TRANS_IDO;
	}

	public String getPROCESS_TIME() {
		return PROCESS_TIME;
	}

	public ComBusInfo getCOM_BUS_INFO() {
		return COM_BUS_INFO;
	}

	public SpReserve getSP_RESERVE() {
		return SP_RESERVE;
	}

	public String getTEST_FLAG() {
		return TEST_FLAG;
	}

	public String getMSG_SENDER() {
		return MSG_SENDER;
	}

	public String getMSG_RECEIVER() {
		return MSG_RECEIVER;
	}

	public void setORIG_DOMAIN(String oRIG_DOMAIN) {
		ORIG_DOMAIN = oRIG_DOMAIN;
	}

	public void setSERVICE_NAME(String sERVICE_NAME) {
		SERVICE_NAME = sERVICE_NAME;
	}

	public void setOPERATE_NAME(String oPERATE_NAME) {
		OPERATE_NAME = oPERATE_NAME;
	}

	public void setACTION_CODE(String aCTION_CODE) {
		ACTION_CODE = aCTION_CODE;
	}

	public void setACTION_RELATION(String aCTION_RELATION) {
		ACTION_RELATION = aCTION_RELATION;
	}

	public void setROUTING(Routing rOUTING) {
		ROUTING = rOUTING;
	}

	public void setPROC_ID(String pROC_ID) {
		PROC_ID = pROC_ID;
	}

	public void setTRANS_IDO(String tRANS_IDO) {
		TRANS_IDO = tRANS_IDO;
	}

	public void setPROCESS_TIME(String pROCESS_TIME) {
		PROCESS_TIME = pROCESS_TIME;
	}

	public void setCOM_BUS_INFO(ComBusInfo cOM_BUS_INFO) {
		COM_BUS_INFO = cOM_BUS_INFO;
	}

	public void setSP_RESERVE(SpReserve sP_RESERVE) {
		SP_RESERVE = sP_RESERVE;
	}

	public void setTEST_FLAG(String tEST_FLAG) {
		TEST_FLAG = tEST_FLAG;
	}

	public void setMSG_SENDER(String mSG_SENDER) {
		MSG_SENDER = mSG_SENDER;
	}

	public void setMSG_RECEIVER(String mSG_RECEIVER) {
		MSG_RECEIVER = mSG_RECEIVER;
	}
	
	
	
}
