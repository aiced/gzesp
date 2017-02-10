package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.13	移网缴费  响应类
 * @author xmh
 *
 */
//@XStreamAlias("Resp")
public class PayRsp {
	
	private String RespCode; //0000 成功
	
	private String RespDesc;
	
	private String TradeId;

	public String getRespCode() {
		return RespCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public String getTradeId() {
		return TradeId;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}

	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}

	
}
