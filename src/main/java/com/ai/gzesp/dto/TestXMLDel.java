package com.ai.gzesp.dto;

import java.util.ArrayList;
import java.util.List;

import com.ai.gzesp.common.Constants;
import com.thoughtworks.xstream.XStream;

public class TestXMLDel {
	
	
	 public static void main(String[] args) {  
		 
		 CurrProduct currProduct=new CurrProduct();
		 currProduct.setCurrProductCode("");
		 currProduct.setCurrProductName("");
		 currProduct.setCurrProductType("");
		 currProduct.setProductActiveTime("");
		 currProduct.setProductInActiveTime("");
		 
		 List<CurrProduct> currProductList=new ArrayList<CurrProduct>();
		 
		 currProductList.add(currProduct);
		 
		 
		 Product product1=new Product();
		 product1.setProductCode("");
		 product1.setProductFee("");
		 product1.setProductName("");
		 product1.setProductRate("");
		 product1.setProductType("");
		 
		 DiscntReq discntReq1=new DiscntReq();
		 discntReq1.setDiscntType("");
		 discntReq1.setDiscntValue("");
		 product1.setDiscntReq(discntReq1);
		 
		 
		 Product product2=new Product(); 
		 product2.setProductCode("");
		 product2.setProductFee("");
		 product2.setProductName("");
		 product2.setProductRate("");
		 product2.setProductType("");
		 DiscntReq discntReq2=new DiscntReq();
		 discntReq2.setDiscntType("");
		 discntReq2.setDiscntValue("");
		 product2.setDiscntReq(discntReq2);
		 
		 
		 Product product3=new Product();
		 product3.setProductCode("");
		 product3.setProductFee("");
		 product3.setProductName("");
		 product3.setProductRate("");
		 product3.setProductType("");	 
		 DiscntReq discntReq3=new DiscntReq();
		 discntReq3.setDiscntType("");
		 discntReq3.setDiscntValue("");
		 product3.setDiscntReq(discntReq3);
		 
		 Product product4=new Product();
		 product4.setProductCode("");
		 product4.setProductFee("");
		 product4.setProductName("");
		 product4.setProductRate("");
		 product4.setProductType("");		 
		 DiscntReq discntReq4=new DiscntReq();
		 discntReq4.setDiscntType("");
		 discntReq4.setDiscntValue("");
		 product4.setDiscntReq(discntReq4);	 
		 
		 Product product5=new Product();
		 product5.setProductCode("");
		 product5.setProductFee("");
		 product5.setProductName("");
		 product5.setProductRate("");
		 product5.setProductType(""); 
		 DiscntReq discntReq5=new DiscntReq();
		 discntReq5.setDiscntType("");
		 discntReq5.setDiscntValue("");
		 product5.setDiscntReq(discntReq5);		 
		 
		 Product product6=new Product();
		 product6.setProductCode("");
		 product6.setProductFee("");
		 product6.setProductName("");
		 product6.setProductRate("");
		 product6.setProductType("");
		 DiscntReq discntReq6=new DiscntReq();
		 discntReq6.setDiscntType("");
		 discntReq6.setDiscntValue("");
		 product6.setDiscntReq(discntReq6);
		 
		 Product product7=new Product();
		 product7.setProductCode("");
		 product7.setProductFee("");
		 product7.setProductName("");
		 product7.setProductRate("");
		 product7.setProductType("");
		 DiscntReq discntReq7=new DiscntReq();
		 discntReq7.setDiscntType("");
		 discntReq7.setDiscntValue("");

		 product7.setDiscntReq(discntReq7);		 
		 
		 
		 
		 
		 Product product8=new Product();
		 product8.setProductCode("");
		 product8.setProductFee("");
		 product8.setProductName("");
		 product8.setProductRate("");
		 product8.setProductType("");

		 DiscntReq discntReq8=new DiscntReq();
		 discntReq8.setDiscntType("");
		 discntReq8.setDiscntValue("");
		 product8.setDiscntReq(discntReq8);
		 
		 
		 List<Product> productList=new ArrayList<Product>();
		 productList.add(product1);
		 productList.add(product2);
		 productList.add(product3);
		 productList.add(product4);
		 productList.add(product5);
		 productList.add(product6);
		 productList.add(product7);
		 productList.add(product8);
		 
		 
		 
		 UserCheckReq_Res bandAcctInfo=new UserCheckReq_Res();
		 
		 bandAcctInfo.setRespCode("");
		 bandAcctInfo.setRespDesc("");
		 bandAcctInfo.setCustName("");
		 bandAcctInfo.setProvinceCode("");
		 bandAcctInfo.setCityCode("");
		 bandAcctInfo.setNetType("");
		 bandAcctInfo.setPayType("");
		 bandAcctInfo.setUserStatus("");
		 bandAcctInfo.setUserType("");
		 bandAcctInfo.setCurrProductList(currProductList);
		 bandAcctInfo.setProductList(productList);
		 
		 
		 XStream xStream = new XStream();  
         xStream.autodetectAnnotations(true);  
         String xml = xStream.toXML(bandAcctInfo);  
         System.out.println(xml); 
         xml=Constants.xmlhead+xml;
         bandAcctInfo=(UserCheckReq_Res) xStream.fromXML(xml);
         
		 System.out.println(bandAcctInfo);
	 }
}
