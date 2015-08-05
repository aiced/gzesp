package com.ai.gzesp.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *@author wenh 
 * 调用BSS接口：用户校验及产品查询
 * 返回该宽带账号对应的相关信息
 * 2015_08_03
 * 
 */
@XStreamAlias("UserCheckReq")
public class UserCheckReq_Res extends BSSBaseResp {

	String CustName;
	String ProvinceCode;	
	String CityCode;
	String NetType;
	String PayType;
	String UserStatus;
	String UserType;
	List<CurrProduct> CurrProductList;
	List<Product> ProductList;
	
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getProvinceCode() {
		return ProvinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		ProvinceCode = provinceCode;
	}
	public String getCityCode() {
		return CityCode;
	}
	public void setCityCode(String cityCode) {
		CityCode = cityCode;
	}
	public String getNetType() {
		return NetType;
	}
	public void setNetType(String netType) {
		NetType = netType;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public String getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public List<CurrProduct> getCurrProductList() {
		return CurrProductList;
	}
	public void setCurrProductList(List<CurrProduct> currProductList) {
		CurrProductList = currProductList;
	}
	public List<Product> getProductList() {
		return ProductList;
	}
	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}
}
