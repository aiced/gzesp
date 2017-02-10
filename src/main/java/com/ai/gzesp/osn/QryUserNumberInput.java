package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("QRY_USER_NUMBER_INPUT")
public class QryUserNumberInput {
	
	private UniBssHead UNI_BSS_HEAD;
	
	private UniBssBody UNI_BSS_BODY;
	
	private UniBssAttached UNI_BSS_ATTACHED;

	public UniBssHead getUNI_BSS_HEAD() {
		return UNI_BSS_HEAD;
	}

	public UniBssBody getUNI_BSS_BODY() {
		return UNI_BSS_BODY;
	}

	public UniBssAttached getUNI_BSS_ATTACHED() {
		return UNI_BSS_ATTACHED;
	}

	public void setUNI_BSS_HEAD(UniBssHead uNI_BSS_HEAD) {
		UNI_BSS_HEAD = uNI_BSS_HEAD;
	}

	public void setUNI_BSS_BODY(UniBssBody uNI_BSS_BODY) {
		UNI_BSS_BODY = uNI_BSS_BODY;
	}

	public void setUNI_BSS_ATTACHED(UniBssAttached uNI_BSS_ATTACHED) {
		UNI_BSS_ATTACHED = uNI_BSS_ATTACHED;
	}
	
	

}
