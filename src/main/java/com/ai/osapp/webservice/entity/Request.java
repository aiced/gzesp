package com.ai.osapp.webservice.entity;

import java.util.Map;

public class Request {

	private String operCode;
	
	private Map<String, Object> param;

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}
	
}
