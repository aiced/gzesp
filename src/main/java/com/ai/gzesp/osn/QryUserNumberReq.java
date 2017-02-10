package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("QRY_USER_NUMBER_REQ")
public class QryUserNumberReq {
	
	private String CHECK_TYPE;
	
	private String CERT_TYPE;
	
	private String CERT_NAME;
	
	private String CERT_NUM;
	
    private Para PARA;

	public String getCHECK_TYPE() {
		return CHECK_TYPE;
	}

	public String getCERT_TYPE() {
		return CERT_TYPE;
	}

	public String getCERT_NAME() {
		return CERT_NAME;
	}

	public String getCERT_NUM() {
		return CERT_NUM;
	}

	public Para getPARA() {
		return PARA;
	}

	public void setCHECK_TYPE(String cHECK_TYPE) {
		CHECK_TYPE = cHECK_TYPE;
	}

	public void setCERT_TYPE(String cERT_TYPE) {
		CERT_TYPE = cERT_TYPE;
	}

	public void setCERT_NAME(String cERT_NAME) {
		CERT_NAME = cERT_NAME;
	}

	public void setCERT_NUM(String cERT_NUM) {
		CERT_NUM = cERT_NUM;
	}

	public void setPARA(Para pARA) {
		PARA = pARA;
	}
    
    
}
