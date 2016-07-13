package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("AccountInfo")
public class AccountInfo {
	
	private String AccountName;
	
	private String AccountPasswd;
	
	private String AccountPayType;
	
	private String AcctType;
	
	private String AccountAddr;
	
	private String AccountZip;
	
	private String AccountPhone;
	
	private String ContactPhone;
	
	private String ContactAddr;
	
	private String PaymentAddr;
	
	private String BillRecvAddr;

	private String BillSendCont;
	
	private String SendBillFlag;

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getAccountPasswd() {
		return AccountPasswd;
	}

	public void setAccountPasswd(String accountPasswd) {
		AccountPasswd = accountPasswd;
	}

	public String getAccountPayType() {
		return AccountPayType;
	}

	public void setAccountPayType(String accountPayType) {
		AccountPayType = accountPayType;
	}

	public String getAcctType() {
		return AcctType;
	}

	public void setAcctType(String acctType) {
		AcctType = acctType;
	}

	public String getAccountAddr() {
		return AccountAddr;
	}

	public void setAccountAddr(String accountAddr) {
		AccountAddr = accountAddr;
	}

	public String getAccountZip() {
		return AccountZip;
	}

	public void setAccountZip(String accountZip) {
		AccountZip = accountZip;
	}

	public String getAccountPhone() {
		return AccountPhone;
	}

	public void setAccountPhone(String accountPhone) {
		AccountPhone = accountPhone;
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

	public String getPaymentAddr() {
		return PaymentAddr;
	}

	public void setPaymentAddr(String paymentAddr) {
		PaymentAddr = paymentAddr;
	}

	public String getBillRecvAddr() {
		return BillRecvAddr;
	}

	public void setBillRecvAddr(String billRecvAddr) {
		BillRecvAddr = billRecvAddr;
	}

	public String getBillSendCont() {
		return BillSendCont;
	}

	public void setBillSendCont(String billSendCont) {
		BillSendCont = billSendCont;
	}

	public String getSendBillFlag() {
		return SendBillFlag;
	}

	public void setSendBillFlag(String sendBillFlag) {
		SendBillFlag = sendBillFlag;
	}
	
	
	
}
