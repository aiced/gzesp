package com.ai.gzesp.dto;

/**
 * 一卡充请求参数dto
 * @author xmh
 *
 */
public class RechargeParam {

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
	
	
}
