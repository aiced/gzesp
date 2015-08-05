package com.ai.gzesp.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author wenh
 * 调用BSS接口：用户校验及产品查询
 * 当前宽带账号的拥有的产品列表
 *
 * 
 */

@XStreamAlias("CurrProduct")
public class CurrProduct {
	String CurrProductType;
	String CurrProductCode;
	String CurrProductName;
	String ProductActiveTime;
	String ProductInActiveTime;
	
	
	public String getCurrProductType() {
		return CurrProductType;
	}
	public void setCurrProductType(String currProductType) {
		CurrProductType = currProductType;
	}
	public String getCurrProductCode() {
		return CurrProductCode;
	}
	public void setCurrProductCode(String currProductCode) {
		CurrProductCode = currProductCode;
	}
	public String getCurrProductName() {
		return CurrProductName;
	}
	public void setCurrProductName(String currProductName) {
		CurrProductName = currProductName;
	}
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
