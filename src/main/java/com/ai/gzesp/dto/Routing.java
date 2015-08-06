package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Routing")
public class Routing {
	String RouteType;
	String RouteValue;
	public String getRouteType() {
		return RouteType;
	}
	public void setRouteType(String routeType) {
		RouteType = routeType;
	}
	public String getRouteValue() {
		return RouteValue;
	}
	public void setRouteValue(String routeValue) {
		RouteValue = routeValue;
	}
	
	
}
