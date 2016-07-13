package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.8	订单提交接口  响应类
 * @author xmh
 *
 */
@XStreamAlias("OrderSubRsp")
public class OrderSubRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
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

	public Para getPara() {
		return Para;
	}

	public void setPara(Para para) {
		Para = para;
	}
	
	

}
