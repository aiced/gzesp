package com.ai.gzesp.dto;

/**
 * 一卡充系统接口返回数据包转换的对象
 * 包含包头+包体 里有用的业务字段信息
 * @author xmh
 *
 */
public class RechargeResp {
	
	/**
	 * 业务流水号
	 */
	private String logId;
	
	/**
	 * 成功标志 1 表示成功 0 表示失败，仅适用于响应包
	 */
	private String successFlag;
	
	/**
	 * 交易类型（6位）： 010202，010203，010204，010205，010206，010201
	 */
	private String interfaceType;
	
	/**
	 * 业务类型（2位）：00-99 标志各种业务。00为空中充值，01为一卡充业务。目前只填01
	 */
	private String busiType;
	
	/**
	 * 业务号码（20位）：当A4交易类型为010202或010201时，
	 * A6字段的含义为： 移动电话号码、固话号码、宽带帐号，小灵通/大灵通或固定值。
	 */
	private String serialNum;
	
	/**
	 * 业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。当A4为010203时，此值为空格
	 */
	private String serialNumType;
	
	/**
	 * 错误码（5位）：在标志为失败时需检查该错误码。错误码包括系统操作错误和业务处理错误。成功交易填写00000
	 */
	private String resultCode;	
	
	/**
	 * 请求时间（12位）：YYMMDDHHMMSS
	 */
	private String reqTime;
	
	/**
	 * 用户余额表示的是用户号码本次被充值后的余额
	 */
	private String agentBalance;
	
	/**
	 * 充值平台的流水号
	 */
	private String uniconSerilNum;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getSerialNumType() {
		return serialNumType;
	}

	public void setSerialNumType(String serialNumType) {
		this.serialNumType = serialNumType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}	
	
	

	public String getAgentBalance() {
		return agentBalance;
	}

	public void setAgentBalance(String agentBalance) {
		this.agentBalance = agentBalance;
	}

	public String getUniconSerilNum() {
		return uniconSerilNum;
	}

	public void setUniconSerilNum(String uniconSerilNum) {
		this.uniconSerilNum = uniconSerilNum;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(300);
		sb.append("logId:" + this.logId);
		sb.append(", successFlag:" + this.successFlag);
		sb.append(", interfaceType:" + this.interfaceType);
		sb.append(", busiType:" + this.busiType);
		sb.append(", serialNum:" + this.serialNum);
		sb.append(", serialNumType:" + this.serialNumType);
		sb.append(", resultCode:" + this.resultCode);
		sb.append(", reqTime:" + this.reqTime);
		sb.append(", agentBalance:" + this.agentBalance);
		sb.append(", uniconSerilNum:" + this.uniconSerilNum);
		
		return sb.toString();
	}
	
}
