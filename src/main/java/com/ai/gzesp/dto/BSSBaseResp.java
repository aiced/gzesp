package com.ai.gzesp.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 *@author wenh 
 *调用Bss接口返回的错误码和错误名称
 * 
 * 
 */
@XStreamAlias("BSSBaseResp")
public class BSSBaseResp {
	String RespCode;//应答编码
	String RespDesc;//应答编码名称
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
