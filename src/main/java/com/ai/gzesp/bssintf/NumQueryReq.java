package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.4	移动号码查询接口
 * @author xmh
 *
 */
@XStreamAlias("NumQueryReq")
public class NumQueryReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String SerType;
	
	private String BrandID;	

	private String ProductID;	
	
	private QueryParas QueryParas;		
	

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

	public String getSerType() {
		return SerType;
	}

	public void setSerType(String serType) {
		SerType = serType;
	}

	public String getBrandID() {
		return BrandID;
	}

	public void setBrandID(String brandID) {
		BrandID = brandID;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public QueryParas getQueryParas() {
		return QueryParas;
	}

	public void setQueryParas(QueryParas queryParas) {
		QueryParas = queryParas;
	}


}
