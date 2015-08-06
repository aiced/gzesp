package com.ai.gzesp.dto;

/**
 * 一卡充请求参数dto
 * @author xmh
 *
 */
public class RechargeReq {

	/**
	 * 充值金额(元)
	 */
	private String chargeMoney;
	
	/**
	 * 卡号
	 */
	private String agentID;	
	
	/**
	 * 卡密码
	 */
	private String pasword;	
	
	/**
	 * 发起方流水号
	 */
	private String serialNum;
	
	/**
	 * 被充值帐号
	 */
	private String accountNumber;
	
	/**
	 * 发起方充值请求流水号,对账时用，原充值请求流水号
	 */
	private String chargeSerilNum;

	public String getChargeMoney() {
		return chargeMoney;
	}

	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getChargeSerilNum() {
		return chargeSerilNum;
	}

	public void setChargeSerilNum(String chargeSerilNum) {
		this.chargeSerilNum = chargeSerilNum;
	}	
	
	
}
