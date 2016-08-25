package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.10	卡数据同步接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("WriteCardPreRsp")
public class WriteCardPreRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
	private FeeInfo FeeInfo;
	
	private String TotalFee;
	
	private Para Para;

	public String getRespCode() {
		return RespCode;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
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
