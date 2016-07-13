package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.3	用户验证接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("UserCheckRsp")
public class UserCheckRsp {
	
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
