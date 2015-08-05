package com.ai.gzesp.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 
 * @author wenh
 * 调用BSS接口：用户校验及产品查询
 * 当前宽带账号的可以订购的产品列表
 */

@XStreamAlias("Product")
public class Product {
	String ProductType;
	String ProductCode;
	String ProductName;
	String ProductFee;
	String ProductRate;
	DiscntReq DiscntReq;
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductFee() {
		return ProductFee;
	}
	public void setProductFee(String productFee) {
		ProductFee = productFee;
	}
	public String getProductRate() {
		return ProductRate;
	}
	public void setProductRate(String productRate) {
		ProductRate = productRate;
	}
	public DiscntReq getDiscntReq() {
		return DiscntReq;
	}
	public void setDiscntReq(DiscntReq discntReq) {
		DiscntReq = discntReq;
	}

	
	
}
