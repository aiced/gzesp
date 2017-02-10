package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UNI_BSS_BODY")
public class UniBssBody {
	
	private QryUserNumberReq QRY_USER_NUMBER_REQ;

	public QryUserNumberReq getQRY_USER_NUMBER_REQ() {
		return QRY_USER_NUMBER_REQ;
	}

	public void setQRY_USER_NUMBER_REQ(QryUserNumberReq qRY_USER_NUMBER_REQ) {
		QRY_USER_NUMBER_REQ = qRY_USER_NUMBER_REQ;
	}
	
	

}
