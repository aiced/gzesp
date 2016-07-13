package com.ai.gzesp.dto;

/**
 * 返回的响应类
 * @author xmh
 *
 */
public class RespInfo<T> {

	private String respCode;
	
	private String respDesc;
	
	private T data;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
