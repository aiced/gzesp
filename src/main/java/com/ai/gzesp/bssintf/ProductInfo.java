package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ProductInfo")
public class ProductInfo {
	
	private String ProductID;
	
	@XStreamImplicit(itemFieldName="ProCompInfo")//标注加在list上
	private List<ProCompInfo> ProCompInfoList;

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public List<ProCompInfo> getProCompInfoList() {
		return ProCompInfoList;
	}

	public void setProCompInfoList(List<ProCompInfo> proCompInfoList) {
		ProCompInfoList = proCompInfoList;
	}

	
}
