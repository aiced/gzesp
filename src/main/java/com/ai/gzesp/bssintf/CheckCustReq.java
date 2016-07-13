package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.3	客户资料验证接口 请求类
 * @author xmh
 *
 */
@XStreamAlias("CheckCustReq")
public class CheckCustReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String CertType;
	
	private String CertNum;
	
	private String ServiceType;
	
	private String AreaCode;
	
	private String NumID;

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

	public String getCertType() {
		return CertType;
	}

	public void setCertType(String certType) {
		CertType = certType;
	}

	public String getCertNum() {
		return CertNum;
	}

	public void setCertNum(String certNum) {
		CertNum = certNum;
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

	public String getNumID() {
		return NumID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}
	
	

}
