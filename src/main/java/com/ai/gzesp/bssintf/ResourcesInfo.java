package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ResourcesInfo")
public class ResourcesInfo {
	
	private String ResourcesType;
	
	private String ResourcesCode;
	
	private String OccupiedFlag;

	public String getResourcesType() {
		return ResourcesType;
	}

	public void setResourcesType(String resourcesType) {
		ResourcesType = resourcesType;
	}

	public String getResourcesCode() {
		return ResourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		ResourcesCode = resourcesCode;
	}

	public String getOccupiedFlag() {
		return OccupiedFlag;
	}

	public void setOccupiedFlag(String occupiedFlag) {
		OccupiedFlag = occupiedFlag;
	}
	
	

}
