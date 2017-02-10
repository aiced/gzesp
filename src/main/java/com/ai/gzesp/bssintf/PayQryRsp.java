package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 2.14	缴费记录查询接口 响应类
 * @author xmh
 *
 */
//@XStreamAlias("Resp")
public class PayQryRsp {
	
	private String RespCode; //0000 成功
	
	private String RespDesc;
	
//	@XStreamImplicit(itemFieldName="PayRecord")
	private List<PayRecord> PayRecordList;

	public String getRespCode() {
		return RespCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}



	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}

	public List<PayRecord> getPayRecordList() {
		return PayRecordList;
	}

	public void setPayRecordList(List<PayRecord> payRecordList) {
		PayRecordList = payRecordList;
	}


	
}
