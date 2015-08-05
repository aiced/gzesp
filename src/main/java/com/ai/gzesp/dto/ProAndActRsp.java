package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 
 * @author wenh
 * 调用BSS接口：产品变更
 * 当前宽带账户产品变更后的产品相关信息
 */
@XStreamAlias("ProAndActRsp")
public class ProAndActRsp extends BSSBaseResp{
	String ProductActiveTime; //产品生效时间
	String ProductInActiveTime;//产品失效时间
	public String getProductActiveTime() {
		return ProductActiveTime;
	}
	public void setProductActiveTime(String productActiveTime) {
		ProductActiveTime = productActiveTime;
	}
	public String getProductInActiveTime() {
		return ProductInActiveTime;
	}
	public void setProductInActiveTime(String productInActiveTime) {
		ProductInActiveTime = productInActiveTime;
	}
	
	
}
