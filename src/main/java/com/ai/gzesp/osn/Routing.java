package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ROUTING")
public class Routing {
	
	private String ROUTE_TYPE;
	
	private String ROUTE_VALUE;

	public String getROUTE_TYPE() {
		return ROUTE_TYPE;
	}

	public String getROUTE_VALUE() {
		return ROUTE_VALUE;
	}

	public void setROUTE_TYPE(String rOUTE_TYPE) {
		ROUTE_TYPE = rOUTE_TYPE;
	}

	public void setROUTE_VALUE(String rOUTE_VALUE) {
		ROUTE_VALUE = rOUTE_VALUE;
	}
	

}
