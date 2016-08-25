package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 2.6	订购信息合法性验证与费用计算 响应类
 * @author xmh
 *
 */
@XStreamAlias("CheckRuleRsp")
public class CheckRuleRsp {
	
	private String RspCode;
	
	private String RspDesc;
	
	@XStreamImplicit(itemFieldName="FeeInfo")
	private List<FeeInfo> listFeeInfo;
	
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

//	public FeeInfo getFeeInfo() {
//		return FeeInfo;
//	}
//
//	public void setFeeInfo(FeeInfo feeInfo) {
//		FeeInfo = feeInfo;
//	}
	
	

	public String getTotalFee() {
		return TotalFee;
	}


	public List<FeeInfo> getListFeeInfo() {
		return listFeeInfo;
	}

	public void setListFeeInfo(List<FeeInfo> listFeeInfo) {
		this.listFeeInfo = listFeeInfo;
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
