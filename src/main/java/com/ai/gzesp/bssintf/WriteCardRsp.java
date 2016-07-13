package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.1	写卡结果通知  响应类
 * @author xmh
 *
 */
@XStreamAlias("WriteCardRsp")
public class WriteCardRsp {
	
	private String RespCode;
	
	private String RespDesc;

	public String getRespCode() {
		return RespCode;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}


}
