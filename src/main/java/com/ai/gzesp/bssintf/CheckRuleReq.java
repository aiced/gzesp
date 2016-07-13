package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("CheckRuleReq")
public class CheckRuleReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String NumID;
	
	private String ServiceType;
	
	private String AreaCode;
	
	private String BindNumID;
	
	private String GuarantorType;
	
	private String GuaratorID;
	
	private String GroupFlag;
	
	//private NumberInfo NumberInfo;
	
	private String SerType;
	
	private ProductInfo ProductInfo;

	public String getOperatorID() {
		return OperatorID;
	}

	public void setOperatorID(String operatorID) {
		OperatorID = operatorID;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getChannelID() {
		return ChannelID;
	}

	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}

	public String getChannelType() {
		return ChannelType;
	}

	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}

	public String getAccessType() {
		return AccessType;
	}

	public void setAccessType(String accessType) {
		AccessType = accessType;
	}

	public String getNumID() {
		return NumID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public String getAreaCode() {
		return AreaCode;
	}

	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}

	public String getBindNumID() {
		return BindNumID;
	}

	public void setBindNumID(String bindNumID) {
		BindNumID = bindNumID;
	}

	public String getGuarantorType() {
		return GuarantorType;
	}

	public void setGuarantorType(String guarantorType) {
		GuarantorType = guarantorType;
	}

	public String getSerType() {
		return SerType;
	}

	public void setSerType(String serType) {
		SerType = serType;
	}

	public ProductInfo getProductInfo() {
		return ProductInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		ProductInfo = productInfo;
	}

	public String getGuaratorID() {
		return GuaratorID;
	}

	public void setGuaratorID(String guaratorID) {
		GuaratorID = guaratorID;
	}

	public String getGroupFlag() {
		return GroupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		GroupFlag = groupFlag;
	}
	

}
