package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.6	订购信息合法性验证与费用计算 响应类
 * @author xmh
 *
 */
@XStreamAlias("CheckRuleRsp")
public class CheckRuleRsp {
	
	private String RspCode;
	
	private String RspDesc;
	
	private FeeInfo FeeInfo;
	
	private String TotalFee;
	
	private Para Para;

	public String getRspCode() {
		return RspCode;
	}

	public void setRspCode(String rspCode) {
		RspCode = rspCode;
	}

	public String getRspDesc() {
		return RspDesc;
	}

	public void setRspDesc(String rspDesc) {
		RspDesc = rspDesc;
	}

	public FeeInfo getFeeInfo() {
		return FeeInfo;
	}

	public void setFeeInfo(FeeInfo feeInfo) {
		FeeInfo = feeInfo;
	}

	public String getTotalFee() {
		return TotalFee;
	}

	public Para getPara() {
		return Para;
	}

	public void setTotalFee(String totalFee) {
		TotalFee = totalFee;
	}

	public void setPara(Para para) {
		Para = para;
	}
	
	

}
