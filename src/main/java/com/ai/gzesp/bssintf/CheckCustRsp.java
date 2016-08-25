package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 2.3	客户资料验证接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("CheckCustRsp")
public class CheckCustRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
	@XStreamImplicit(itemFieldName="ExistedCustomer")
	private List<ExistedCustomer> ListExistedCustomer;

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

	public List<ExistedCustomer> getListExistedCustomer() {
		return ListExistedCustomer;
	}

	public void setListExistedCustomer(List<ExistedCustomer> listExistedCustomer) {
		ListExistedCustomer = listExistedCustomer;
	}


	

}
