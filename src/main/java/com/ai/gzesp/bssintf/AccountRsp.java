package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.7	开户信息预提交接口  响应类
 * @author xmh
 *
 */
@XStreamAlias("AccountRsp")
public class AccountRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
	private String ProvOrderID;
	
	private Para Para;

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

	public String getProvOrderID() {
		return ProvOrderID;
	}

	public void setProvOrderID(String provOrderID) {
		ProvOrderID = provOrderID;
	}

	public Para getPara() {
		return Para;
	}

	public void setPara(Para para) {
		Para = para;
	}
	
	

}
