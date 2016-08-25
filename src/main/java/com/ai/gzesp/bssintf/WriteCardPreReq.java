package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.10	卡数据同步 请求类
 * @author xmh
 *
 */
@XStreamAlias("WriteCardPreReq")
public class WriteCardPreReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String OrderID;
	
	private String ProvOrderID;
	
	private String NumID;
	
	private String SimID;
	
	private String IMSI;
	
	private String CardType;
	
	private String BusiType;
	
	private String CardData;
	
	private String CardDataProcID;

	public String getOperatorID() {
		return OperatorID;
	}

	public String getProvince() {
		return Province;
	}

	public String getCity() {
		return City;
	}

	public String getDistrict() {
		return District;
	}

	public String getChannelID() {
		return ChannelID;
	}

	public String getChannelType() {
		return ChannelType;
	}

	public String getAccessType() {
		return AccessType;
	}

	public String getOrderID() {
		return OrderID;
	}

	public String getProvOrderID() {
		return ProvOrderID;
	}

	public String getNumID() {
		return NumID;
	}

	public String getSimID() {
		return SimID;
	}

	public String getIMSI() {
		return IMSI;
	}

	public String getCardType() {
		return CardType;
	}

	public String getBusiType() {
		return BusiType;
	}

	public String getCardData() {
		return CardData;
	}

	public String getCardDataProcID() {
		return CardDataProcID;
	}

	public void setOperatorID(String operatorID) {
		OperatorID = operatorID;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public void setCity(String city) {
		City = city;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}

	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}

	public void setAccessType(String accessType) {
		AccessType = accessType;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public void setProvOrderID(String provOrderID) {
		ProvOrderID = provOrderID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}

	public void setSimID(String simID) {
		SimID = simID;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public void setBusiType(String busiType) {
		BusiType = busiType;
	}

	public void setCardData(String cardData) {
		CardData = cardData;
	}

	public void setCardDataProcID(String cardDataProcID) {
		CardDataProcID = cardDataProcID;
	}

	
}
