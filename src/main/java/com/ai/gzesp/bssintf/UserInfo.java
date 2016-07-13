package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserInfo")
public class UserInfo {
	
	private String UserName;
	
	private String UserPasswd;
	
	private String CreditVale;
	
	private String CheckCreditVale;
	
	private String PackID;
	
	private String UserAddr;
	
	private String GuarantorType;
	
	private String GuaratorID;
	
	private String GroupFlag;
	
	
	private String BrandID;
	
	private String UserType;
	
	private String CertExpireDate;
	
	private String CertAddr;
	
	private String ContactAddr;
	
	private String ContactPhone;
	
	private String BillSendType;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPasswd() {
		return UserPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		UserPasswd = userPasswd;
	}

	public String getCreditVale() {
		return CreditVale;
	}

	public void setCreditVale(String creditVale) {
		CreditVale = creditVale;
	}

	public String getCheckCreditVale() {
		return CheckCreditVale;
	}

	public void setCheckCreditVale(String checkCreditVale) {
		CheckCreditVale = checkCreditVale;
	}

	public String getPackID() {
		return PackID;
	}

	public void setPackID(String packID) {
		PackID = packID;
	}

	public String getUserAddr() {
		return UserAddr;
	}

	public void setUserAddr(String userAddr) {
		UserAddr = userAddr;
	}

	public String getGuarantorType() {
		return GuarantorType;
	}

	public void setGuarantorType(String guarantorType) {
		GuarantorType = guarantorType;
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

	public String getBrandID() {
		return BrandID;
	}

	public void setBrandID(String brandID) {
		BrandID = brandID;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public String getCertExpireDate() {
		return CertExpireDate;
	}

	public void setCertExpireDate(String certExpireDate) {
		CertExpireDate = certExpireDate;
	}

	public String getCertAddr() {
		return CertAddr;
	}

	public void setCertAddr(String certAddr) {
		CertAddr = certAddr;
	}

	public String getContactAddr() {
		return ContactAddr;
	}

	public void setContactAddr(String contactAddr) {
		ContactAddr = contactAddr;
	}

	public String getContactPhone() {
		return ContactPhone;
	}

	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}

	public String getBillSendType() {
		return BillSendType;
	}

	public void setBillSendType(String billSendType) {
		BillSendType = billSendType;
	}
	
	
	

}
