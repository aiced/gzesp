package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ResourcesRsp")
public class ResourcesRsp {
	
	private String ResourcesType;
	
	private String ResourcesCode;
	
	private String RscStateCode;
	
	private String RscStateDesc;
	
	private String SalePrice;
	
	private String ReservaPrice;
	
	private String ProductID;
	
	private String ResourcesBrand;
	
	private String ResourcesModel;
	
	private Para Para;

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

	public String getRscStateCode() {
		return RscStateCode;
	}

	public void setRscStateCode(String rscStateCode) {
		RscStateCode = rscStateCode;
	}

	public String getRscStateDesc() {
		return RscStateDesc;
	}

	public void setRscStateDesc(String rscStateDesc) {
		RscStateDesc = rscStateDesc;
	}

	public String getSalePrice() {
		return SalePrice;
	}

	public void setSalePrice(String salePrice) {
		SalePrice = salePrice;
	}

	public String getReservaPrice() {
		return ReservaPrice;
	}

	public void setReservaPrice(String reservaPrice) {
		ReservaPrice = reservaPrice;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getResourcesBrand() {
		return ResourcesBrand;
	}

	public void setResourcesBrand(String resourcesBrand) {
		ResourcesBrand = resourcesBrand;
	}

	public String getResourcesModel() {
		return ResourcesModel;
	}

	public void setResourcesModel(String resourcesModel) {
		ResourcesModel = resourcesModel;
	}

	public Para getPara() {
		return Para;
	}

	public void setPara(Para para) {
		Para = para;
	}
	
	

}
