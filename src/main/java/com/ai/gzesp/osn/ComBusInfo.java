package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("COM_BUS_INFO")
public class ComBusInfo {
	
	private String OPER_ID;
	
	private String PROVINCE_CODE;
	
	private String EPARCHY_CODE;
	
	private String CITY_CODE;
	
	private String CHANNEL_ID;
	
	private String CHANNEL_TYPE;
	
	private String ACCESS_TYPE;
	
	private String ORDER_TYPE;

	public String getOPER_ID() {
		return OPER_ID;
	}

	public String getPROVINCE_CODE() {
		return PROVINCE_CODE;
	}

	public String getEPARCHY_CODE() {
		return EPARCHY_CODE;
	}

	public String getCITY_CODE() {
		return CITY_CODE;
	}

	public String getCHANNEL_ID() {
		return CHANNEL_ID;
	}

	public String getCHANNEL_TYPE() {
		return CHANNEL_TYPE;
	}

	public String getACCESS_TYPE() {
		return ACCESS_TYPE;
	}

	public String getORDER_TYPE() {
		return ORDER_TYPE;
	}

	public void setOPER_ID(String oPER_ID) {
		OPER_ID = oPER_ID;
	}

	public void setPROVINCE_CODE(String pROVINCE_CODE) {
		PROVINCE_CODE = pROVINCE_CODE;
	}

	public void setEPARCHY_CODE(String ePARCHY_CODE) {
		EPARCHY_CODE = ePARCHY_CODE;
	}

	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}

	public void setCHANNEL_ID(String cHANNEL_ID) {
		CHANNEL_ID = cHANNEL_ID;
	}

	public void setCHANNEL_TYPE(String cHANNEL_TYPE) {
		CHANNEL_TYPE = cHANNEL_TYPE;
	}

	public void setACCESS_TYPE(String aCCESS_TYPE) {
		ACCESS_TYPE = aCCESS_TYPE;
	}

	public void setORDER_TYPE(String oRDER_TYPE) {
		ORDER_TYPE = oRDER_TYPE;
	}
	
	
}
