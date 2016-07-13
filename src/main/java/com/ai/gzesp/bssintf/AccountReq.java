package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.7	开户信息预提交接口
 * @author xmh
 *
 */
@XStreamAlias("AccountReq")
public class AccountReq {
	
	private String OperatorID;
	
	private String Province;
	
	private String City;
	
	private String District;
	
	private String ChannelID;
	
	private String ChannelType;
	
	private String AccessType;
	
	private String OrdersID;
	
	private String NumID;
	
	private String CertTag;
	
	private String SerType;
	
	private String FirstMonBillMode;
	
	private String RealNameType;
	
	private NewCustomerInfo NewCustomerInfo;
	
	private UserInfo UserInfo;
	
	private AccountInfo AccountInfo;
	
	private ProductInfo ProductInfo;
	
	
	
	private String OrigTotalFee;
	
    private PayInfo PayInfo;
	

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

	public String getOrdersID() {
		return OrdersID;
	}

	public void setOrdersID(String ordersID) {
		OrdersID = ordersID;
	}

	public String getNumID() {
		return NumID;
	}

	public void setNumID(String numID) {
		NumID = numID;
	}

	public String getCertTag() {
		return CertTag;
	}

	public void setCertTag(String certTag) {
		CertTag = certTag;
	}

	public String getSerType() {
		return SerType;
	}

	public void setSerType(String serType) {
		SerType = serType;
	}

	public String getFirstMonBillMode() {
		return FirstMonBillMode;
	}

	public void setFirstMonBillMode(String firstMonBillMode) {
		FirstMonBillMode = firstMonBillMode;
	}

	public String getRealNameType() {
		return RealNameType;
	}

	public void setRealNameType(String realNameType) {
		RealNameType = realNameType;
	}

	public NewCustomerInfo getNewCustomerInfo() {
		return NewCustomerInfo;
	}

	public void setNewCustomerInfo(NewCustomerInfo newCustomerInfo) {
		NewCustomerInfo = newCustomerInfo;
	}

	public UserInfo getUserInfo() {
		return UserInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		UserInfo = userInfo;
	}

	public AccountInfo getAccountInfo() {
		return AccountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		AccountInfo = accountInfo;
	}

	public ProductInfo getProductInfo() {
		return ProductInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		ProductInfo = productInfo;
	}

	public String getOrigTotalFee() {
		return OrigTotalFee;
	}

	public void setOrigTotalFee(String origTotalFee) {
		OrigTotalFee = origTotalFee;
	}

	public PayInfo getPayInfo() {
		return PayInfo;
	}

	public void setPayInfo(PayInfo payInfo) {
		PayInfo = payInfo;
	}


	

}
