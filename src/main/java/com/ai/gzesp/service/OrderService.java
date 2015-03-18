package com.ai.gzesp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.beans.TdOrdDCUST;
import com.ai.gzesp.dao.beans.TdOrdDDEAL;
import com.ai.gzesp.dao.beans.TdOrdDPAYLOG;
import com.ai.gzesp.dao.beans.TdOrdDPOST;
import com.ai.gzesp.dao.beans.TdOrdDPROD;
import com.ai.gzesp.dao.beans.TdOrdDRES;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.service.TdOrdDCUSTDao;
import com.ai.gzesp.dao.service.TdOrdDDEALDao;
import com.ai.gzesp.dao.service.TdOrdDPAYLOGDao;
import com.ai.gzesp.dao.service.TdOrdDPOSTDao;
import com.ai.gzesp.dao.service.TdOrdDRESDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class OrderService {
	
    @Resource 
    TdOrdDBASEDao tdOrdDBASEDao;
    
    @Resource 
    TdOrdDCUSTDao tdOrdDCUSTDao;
    
    @Resource 
    TdOrdDDEALDao tdOrdDDEALDao;
    
    @Resource 
    TdOrdDPAYLOGDao tdOrdDPAYLOGDao;
    
    @Resource 
    TdOrdDPOSTDao tdOrdDPOSTDao;
    
    @Resource 
    TdOrdDRESDao tdOrdDRESDao;
    
    @Resource 
    GoodsSql goodsSql;
    
    public void insertOrder(Map<String, String> paramsMap) {
    	insertOrderBaseInfo(paramsMap);
    	insertOrderCustInfo(paramsMap);
    	insertOrderDealInfo(paramsMap);
    	insertOrderPayLogInfo(paramsMap);
    	insertOrderPostInfo(paramsMap);
    	insertOrderProdInfo(paramsMap);
    	insertOrderResInfo(paramsMap);
    }
    
    
    private void insertOrderBaseInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String orderFrom = paramsMap.get("orderFrom");
    	String originalPrice = paramsMap.get("originalPrice");
    	String couponMoney = paramsMap.get("couponMoney");
    	String manMadeMoney = paramsMap.get("manMadeMoney");
    	String topayMoney = paramsMap.get("topayMoney");
    	String custRemark = paramsMap.get("custRemark");
    	String sellerRemark = paramsMap.get("sellerRemark");
    	
    	TdOrdDBASE record = new TdOrdDBASE();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setCreateTime(DateUtil.getNow());
    	record.setOrderFrom(orderFrom);
    	record.setOrderTime(DateUtil.getNow());
    	record.setOriginalPrice(Long.parseLong(originalPrice));
    	record.setCouponMoney(Long.parseLong(couponMoney));
    	record.setManMadeMoney(Long.parseLong(manMadeMoney));
    	record.setTopayMoney(Long.parseLong(topayMoney));
    	record.setIncomeMoney(0l);
    	record.setOrderState("00");
    	record.setCustRemark(custRemark);
    	record.setSellerRemark(sellerRemark);
    
    	tdOrdDBASEDao.insertSelective(record);
    }
    
    
    private void insertOrderCustInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String custName = paramsMap.get("custName");
    	String phoneNum = paramsMap.get("phoneNum");
    	String idCardNum = paramsMap.get("idCardNum");
    	String cardPic1 = paramsMap.get("cardPic1");
    	String cardPic2 = paramsMap.get("cardPic2");
    	
    	TdOrdDCUST record = new TdOrdDCUST();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setCustName(custName);
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setPhoneNumber(phoneNum);
    	record.setPsptTypeCode("01");
    	record.setPsptNo(idCardNum);
    	record.setPsptImg1(cardPic1);
    	record.setPsptImg2(cardPic2);
    	
    	tdOrdDCUSTDao.insertSelective(record);
    }
    
    
    private void insertOrderDealInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String userId = paramsMap.get("userId");
    	String userName = paramsMap.get("userName");
    	String devlpId = paramsMap.get("devlpId");
    	String devlpName = paramsMap.get("devlpName");
    	String phoneNum = paramsMap.get("phoneNum");
    	String invoiceTitle = paramsMap.get("invoiceTitle");
    	
    	TdOrdDDEAL record = new TdOrdDDEAL();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setUserId(Long.parseLong(userId));
//    	record.setPartitionId((short)DateUtil.getCurrentMonth());
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setUserName(userName);
    	record.setPhoneNumber(phoneNum);
    	record.setDevlopId(devlpId);
    	record.setDevlopName(devlpName);
    	record.setInvoceTitle(invoiceTitle);

    	tdOrdDDEALDao.insertSelective(record);
    }
    

    private void insertOrderPayLogInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String payLogId = paramsMap.get("payLogId");
    	String payType = paramsMap.get("payType");
    	String payMode = paramsMap.get("payMode");
//    	String payMoney = paramsMap.get("payMoney");
    	
    	
    	TdOrdDPAYLOG record = new TdOrdDPAYLOG();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setPayLogid(Long.parseLong(payLogId));
    	record.setPayType(payType);
    	record.setPayMode(payMode);
//    	record.setPayMoney(Long.parseLong(payMoney));
    	record.setPayAskTime(DateUtil.getNow());
    	record.setPayState("0");

    	tdOrdDPAYLOGDao.insertSelective(record);
    }
    
    private void insertOrderPostInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String deliverTypeCode = paramsMap.get("deliverTypeCode");
    	String deliverTimeCode = paramsMap.get("deliverTimeCode");
    	String receiverName = paramsMap.get("receiverName");
    	String receiverPsptType = paramsMap.get("receiverPsptType");
    	String receiverPsptNo = paramsMap.get("receiverPsptNo");
    	String phoneNum = paramsMap.get("phoneNum");
    	String postAddr = paramsMap.get("postAddr");
    	String provinceCode = paramsMap.get("provinceCode");
    	String cityCode = paramsMap.get("cityCode");
    	String districtCode = paramsMap.get("districtCode");
    	String postRemark = paramsMap.get("postRemark");
    	
    	TdOrdDPOST record = new TdOrdDPOST();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setDeliverTypeCode(deliverTypeCode);
    	record.setDeliverTimeCode(deliverTimeCode);
    	record.setReceiverName(receiverName);
    	record.setReceiverPsptType(receiverPsptType);
    	record.setReceiverPsptNo(receiverPsptNo);
    	record.setMobilePhone(phoneNum);
    	record.setPostAddr(postAddr);
    	record.setProvinceCode(provinceCode);
    	record.setCityCode(cityCode);
    	record.setDistrictCode(districtCode);
    	record.setPostRemark(postRemark);
    }
    
    private void insertOrderProdInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String goodsId = paramsMap.get("goodsId");
    	String goodsName = paramsMap.get("goodsName");
    	String unitPrice = paramsMap.get("unitPrice");
    	String saleNum = paramsMap.get("saleNum");
    	String topayFee = paramsMap.get("topayFee");
    	String derateFee = paramsMap.get("derateFee");
    	String derateReason = paramsMap.get("derateReason");
    	String recvFee = paramsMap.get("recvFee");
    	
    	TdOrdDPROD record = new TdOrdDPROD();
    	record.setOrderId(Long.parseLong(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setGoodsId(Long.parseLong(goodsId));
    	record.setGoodsName(goodsName);
    	record.setUnitPrice(Long.parseLong(unitPrice));
    	record.setSaleNum(Integer.parseInt(saleNum));
    	record.setTopayFee(Long.parseLong(topayFee));
    	record.setDerateFee(Long.parseLong(derateFee));
    	record.setDerateReason(derateReason);
    	record.setRecvFee(Long.parseLong(recvFee));
    }
    
    private void insertOrderResInfo(Map<String, String> paramsMap) {
    	String ordAttrStr = paramsMap.get("ordAttr");
    	JSONArray ordAttrJson =  JSON.parseArray(ordAttrStr);
    	String orderId = paramsMap.get("orderId");
    	
    	for(int i=0; i<ordAttrJson.size(); i++) {
    		JSONObject jsonObj = ordAttrJson.getJSONObject(i);
    		String resId = jsonObj.getString("resId");
    		String resAttrCode = jsonObj.getString("resAttrCode");
    		String resAttrVal = jsonObj.getString("resAttrVal");
    		
    		TdOrdDRES record = new TdOrdDRES();
    		record.setOrderId(Long.parseLong(orderId));
        	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
        	record.setResId(Long.parseLong(resId));
        	record.setResAttrCode(resAttrCode);
        	record.setResAttrVal(resAttrVal);
    		tdOrdDRESDao.insertSelective(record);
    	}
    }
    
}
