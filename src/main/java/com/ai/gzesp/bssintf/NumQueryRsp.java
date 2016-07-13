package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 2.4	移动号码查询接口 响应类
 * @author xmh
 *
 */
@XStreamAlias("NumQueryRsp")
public class NumQueryRsp {
	
	private String RespCode;
	
	private String RespDesc;
	
	@XStreamImplicit(itemFieldName="NumInfo")//标注加在list上
	private List<NumInfo> NumInfolist;

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

	public List<NumInfo> getNumInfolist() {
		return NumInfolist;
	}

	public void setNumInfolist(List<NumInfo> numInfolist) {
		NumInfolist = numInfolist;
	}

	
	

}
