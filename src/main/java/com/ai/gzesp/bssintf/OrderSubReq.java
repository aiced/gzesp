package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.8	订单提交接口
 * @author xmh
 *
 */
@XStreamAlias("OrderSubReq")
public class OrderSubReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String OrderType;
	
	private String ProvOrderID;
	
	private String EcsOrderID;
	
	private String TaxType;
	

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

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}

	public String getProvOrderID() {
		return ProvOrderID;
	}

	public void setProvOrderID(String provOrderID) {
		ProvOrderID = provOrderID;
	}

	public String getEcsOrderID() {
		return EcsOrderID;
	}

	public void setEcsOrderID(String ecsOrderID) {
		EcsOrderID = ecsOrderID;
	}

	public String getTaxType() {
		return TaxType;
	}

	public void setTaxType(String taxType) {
		TaxType = taxType;
	}


}
