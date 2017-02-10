package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Body")
public class Body {
	
	private QryUserNumberInput QRY_USER_NUMBER_INPUT;

	public QryUserNumberInput getQRY_USER_NUMBER_INPUT() {
		return QRY_USER_NUMBER_INPUT;
	}

	public void setQRY_USER_NUMBER_INPUT(QryUserNumberInput qRY_USER_NUMBER_INPUT) {
		QRY_USER_NUMBER_INPUT = qRY_USER_NUMBER_INPUT;
	}
	

}
