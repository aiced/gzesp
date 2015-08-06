package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 
 * @author wenh
 * 调用BSS接口：用户校验及产品查询
 * 当前宽带账号的可以订购的产品列表中的优惠信息
 */
@XStreamAlias("DiscntReq")
public class DiscntReq {
	String DiscntType;
	String DiscntValue;
	public String getDiscntType() {
		return DiscntType;
	}
	public void setDiscntType(String discntType) {
		DiscntType = discntType;
	}
	public String getDiscntValue() {
		return DiscntValue;
	}
	public void setDiscntValue(String discntValue) {
		DiscntValue = discntValue;
	}
	
}
