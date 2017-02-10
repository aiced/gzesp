package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UNI_BSS_ATTACHED")
public class UniBssAttached {
	
	private String MEDIA_INFO;

	public String getMEDIA_INFO() {
		return MEDIA_INFO;
	}

	public void setMEDIA_INFO(String mEDIA_INFO) {
		MEDIA_INFO = mEDIA_INFO;
	}
	
	

}
