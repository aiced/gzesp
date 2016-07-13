package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("NewCustomerInfo")
public class NewCustomerInfo {
	
	private String CustomerType;
	
	private String CustomerLevel;
	
	private String CustomerLoc;
	
	private String CertType;
	
	private String CertNum;
	
	private String CustomerName;
	
	private String CustomerPasswd;
	
	private String ReleOfficeID;
	
	private String CertExpireDate;
	
	private String CustomerZip;
	
	private String CustomerAddr;
	
	//private String CustomerEmail;
	
	private String ContactPerson;
	
	private String ContactPhone;
	
	//private String ContactEmail;
	
	private String ContactAddr;
	
	//private String ContactZip;
	
	private String CustomerSex;
	
	private String CustomerBirth;
	
	private String CertAddr;
	
	private String CustStatus;

	public String getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}

	public String getCustomerLevel() {
		return CustomerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		CustomerLevel = customerLevel;
	}

	public String getCustomerLoc() {
		return CustomerLoc;
	}

	public void setCustomerLoc(String customerLoc) {
		CustomerLoc = customerLoc;
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

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerPasswd() {
		return CustomerPasswd;
	}

	public void setCustomerPasswd(String customerPasswd) {
		CustomerPasswd = customerPasswd;
	}

	public String getReleOfficeID() {
		return ReleOfficeID;
	}

	public void setReleOfficeID(String releOfficeID) {
		ReleOfficeID = releOfficeID;
	}

	public String getCertExpireDate() {
		return CertExpireDate;
	}

	public void setCertExpireDate(String certExpireDate) {
		CertExpireDate = certExpireDate;
	}

	public String getCustomerZip() {
		return CustomerZip;
	}

	public void setCustomerZip(String customerZip) {
		CustomerZip = customerZip;
	}

	public String getCustomerAddr() {
		return CustomerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		CustomerAddr = customerAddr;
	}

	public String getContactPerson() {
		return ContactPerson;
	}

	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}

	public String getContactPhone() {
		return ContactPhone;
	}

	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}

	public String getContactAddr() {
		return ContactAddr;
	}

	public void setContactAddr(String contactAddr) {
		ContactAddr = contactAddr;
	}

	public String getCustomerSex() {
		return CustomerSex;
	}

	public void setCustomerSex(String customerSex) {
		CustomerSex = customerSex;
	}

	public String getCustomerBirth() {
		return CustomerBirth;
	}

	public void setCustomerBirth(String customerBirth) {
		CustomerBirth = customerBirth;
	}

	public String getCertAddr() {
		return CertAddr;
	}

	public void setCertAddr(String certAddr) {
		CertAddr = certAddr;
	}

	public String getCustStatus() {
		return CustStatus;
	}

	public void setCustStatus(String custStatus) {
		CustStatus = custStatus;
	}
	
	
}
