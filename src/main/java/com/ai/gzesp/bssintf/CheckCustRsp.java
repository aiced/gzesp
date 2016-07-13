package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.3	客户资料验证接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("CheckCustRsp")
public class CheckCustRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
	private ExistedCustomer ExistedCustomer;

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

	public ExistedCustomer getExistedCustomer() {
		return ExistedCustomer;
	}

	public void setExistedCustomer(ExistedCustomer existedCustomer) {
		ExistedCustomer = existedCustomer;
	}
	

}
