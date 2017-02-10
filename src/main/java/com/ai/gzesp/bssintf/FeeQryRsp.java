package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.12	移网应缴费用查询  响应类
 * @author xmh
 *
 */
@XStreamAlias("Resp")
public class FeeQryRsp {
	
	private String RespCode; //0000 成功
	
	private String RespDesc;
	
	private String UserName;
	
	private String EparchyCode;
	
	private String EparchyNme;
	
	private String ProductName;
	
	private String Amount; //实时话费
	
	private String Balance; //可用余额（账本余额-实时话费）

	public String getRespCode() {
		return RespCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public String getUserName() {
		return UserName;
	}

	public String getEparchyCode() {
		return EparchyCode;
	}

	public String getEparchyNme() {
		return EparchyNme;
	}

	public String getProductName() {
		return ProductName;
	}

	public String getAmount() {
		return Amount;
	}

	public String getBalance() {
		return Balance;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setEparchyCode(String eparchyCode) {
		EparchyCode = eparchyCode;
	}

	public void setEparchyNme(String eparchyNme) {
		EparchyNme = eparchyNme;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}

	
}
