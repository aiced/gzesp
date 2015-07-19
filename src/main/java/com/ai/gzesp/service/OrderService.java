package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.beans.TdOrdDCMSSTATE;
import com.ai.gzesp.dao.beans.TdOrdDCUST;
import com.ai.gzesp.dao.beans.TdOrdDDEAL;
import com.ai.gzesp.dao.beans.TdOrdDPAYLOG;
import com.ai.gzesp.dao.beans.TdOrdDPOST;
import com.ai.gzesp.dao.beans.TdOrdDPRECMSFEE;
import com.ai.gzesp.dao.beans.TdOrdDPROD;
import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.beans.TdOrdDRES;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.service.TdOrdDCMSSTATEDao;
import com.ai.gzesp.dao.service.TdOrdDCUSTDao;
import com.ai.gzesp.dao.service.TdOrdDDEALDao;
import com.ai.gzesp.dao.service.TdOrdDPAYLOGDao;
import com.ai.gzesp.dao.service.TdOrdDPOSTDao;
import com.ai.gzesp.dao.service.TdOrdDPRECMSFEEDao;
import com.ai.gzesp.dao.service.TdOrdDPRODDao;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.service.TdOrdDRESDao;
import com.ai.gzesp.dao.service.TdResDATTRVALDao;
import com.ai.gzesp.dao.sql.CommissionSql;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.utils.DateUtils;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.RegexUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class OrderService {
	
	 protected Logger logger = LoggerFactory.getLogger(getClass());
	
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
    TdOrdDPRODDao tdOrdDPRODDao;
    
    @Resource 
    TdOrdDRESDao tdOrdDRESDao;
    
    @Resource 
    TdOrdDREFUNDDao tdOrdDREFUNDDao;
    
    @Resource 
    TdOrdDCMSSTATEDao tdOrdDCMSSTATEDao;
    
    @Resource 
    TdOrdDPRECMSFEEDao tdOrdDPRECMSFEEDao;
    
    @Resource 
    TdResDATTRVALDao tdResDATTRVALDao;
    
    @Resource 
    GoodsSql goodsSql;
    
    @Resource 
    OrdersSql ordersSql;
    
    @Resource 
    CommissionSql commissionSql;
    
    @Autowired
    private OrderDao orderDao;
    
    public String GetGoodsNumAttr(String goodsId) {
    	return goodsSql.GetGoodsNumAttr(goodsId);
    }
    
    public String GetGoodsFMonthDAttr(String goodsId) {
    	return goodsSql.GetGoodsFMonthDAttr(goodsId);
    }
    
    public List GetGoodsFMonthDList(String resId) {
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("RES_ID", resId).andEqualTo("ATTR_CODE", "FMONTHD");
    	example.setOrderByClause("SEQ_NUM");
    	return tdResDATTRVALDao.selectByExample(example);
    }
    
    public Map getGoodsDefaultPhoto(String goodsId) {
    	return goodsSql.GetGoodsDefaultPhoto(goodsId);
    }
    
    public List getCustMyOrder(String passport, String phone, String keyword,int iHidePageIndex) {
    	return ordersSql.getCustMyOrder(passport, phone, keyword, iHidePageIndex);
    }
    
    public Map getCustOrderDetail(String orderId) {
    	return ordersSql.getCustOrderDetail(orderId);
    }
    
    
    public List<Map>[] getContractByGoodsID(String goodsId) {
    	
    	String orderByStr = "SEQ_NUM"; 
    	List<Map<String, Object>> contactList = goodsSql.getContractByGoodsID(goodsId, orderByStr);
    	
    	List<Map> packList = new ArrayList();
    	List<Map> pageList = new ArrayList();
    	List<Map>[] result = new ArrayList[2];
    	result[0] = packList;
    	result[1] = pageList;
    	
    	if(contactList.size() > 0) {
    		for(int i=0; i<contactList.size(); i++) {
    			Map<String, Object> info = contactList.get(i);
    			String code = String.valueOf(info.get("code"));
    			
    			if("PACKRES".equals(code)) {
    				packList.add(info);
    			} else if("PAGERES".equals(code)) {
    				pageList.add(info);
    			}
    		}
    	}
    	
    	return result;
    }
    
    
    private void cacuCMSPreFee(Map<String, String> paramsMap) {
    	// get cms rules
    	String goodsId = paramsMap.get("goodsId");
    	String originalPrice = paramsMap.get("originalPrice");
    	String cmsRule = commissionSql.getCmsRuleByGoodsId(goodsId);
    	logger.debug("cmsRule:"+cmsRule);
    	// no need to check con for pre Fee
    	// SAVEMEY( 4G组合套餐，还是ORD_D_RES表中  	这个商品去取RES_ATTR_CODE='SAVEMEY'),PACKMEY(ORD_D_RES表中套餐面值),PRODMEY(上网卡的价格,是直接取商品价格还是说需要配置一个物品属性,需要确认)
    	String[] result = RegexUtil.getCMSRule(cmsRule);
    	if(result != null) {
    		String money = "";
    		if("SAVEMEY".equals(result[0]) ) {
    			money = getOriginMoneyByAttrCode("SAVEMEY", paramsMap);
    		} else if("PACKMEY".equals(result[0])) {
    			money = getOriginMoneyByAttrCode("PACKRES", paramsMap);
    		} else if("PRODMEY".equals(result[0])) {
    			money = originalPrice;
    		}
    		
    		float cmsPreFee = Long.parseLong("".equals(money)?"0":money)*Float.parseFloat(result[1]);
			paramsMap.put("cmsPreFee", String.valueOf(cmsPreFee));
			
			logger.debug(result[0]+"---"+result[1]+"---"+cmsPreFee);
    	}
    }
    
    private void cacuReward(Map<String, String> paramsMap) {
    	String goodsId = paramsMap.get("goodsId");
    	String userId = paramsMap.get("userId");
    	String rewardRule = "";
//    	if(isUserSingleOrd(goodsId, userId)) {
//    		rewardRule = commissionSql.getRewardRuleByGoodsId(goodsId, "SINGLE");
//    	} else {
//    		rewardRule = commissionSql.getRewardRuleByGoodsId(goodsId, "EVERY");
//    	}
    	rewardRule = commissionSql.getRewardRuleByGoodsId(goodsId, "");
    	logger.debug("rewardRule:"+rewardRule);
    	String[] result = RegexUtil.getRewardRule(rewardRule);
    	if(result != null) {
    		String money = "";
    		if("SINGLE".equals(result[0]) ) {
    			if(isUserSingleOrd(goodsId, userId)) {
    				money = result[1];
    	    	} else {
    	    		return;
    	    	}
    		} else if("EVERY".equals(result[0])) {
    			money = result[1];
    		} else {
    			return;
    		}
			paramsMap.put("reward", String.valueOf("".equals(money)?"0":money));
			
			logger.debug(result[0]+"---"+result[1]+"---"+money);
    	}
    }
    
    private boolean isUserSingleOrd(String goodsId, String userId) {
    	//CMS_P_GOODS_RULE(goodsId&sysdate{begind,end})-->CMS_P_RULE(rule{single})---->ORD_D_PROD(orderId&goodsId)-->ORD_D_DEAL(orderId&userId)
    	int ordNum = commissionSql.getUserOrdNum(goodsId, userId);
    	if(ordNum == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private String getOriginMoneyByAttrCode(String attrCode, Map<String, String> paramsMap) {
    	String resAttrStr = paramsMap.get("resAttr");
    	
    	if(resAttrStr == null) {
    		return "";
    	}
    	
    	String[] rows = resAttrStr.split("\\^", -1);
    	for(String row : rows) {
    		String[] col = row.split("\\|", -1);
    		if(col.length < 3) {
    			continue;
    		}
    		
//    		String resId = col[0];
    		String resAttrCode = col[1];
    		String resAttrVal = col[2];
    		
    		if(attrCode.equals(resAttrCode)) {
    			String money = RegexUtil.getMoney(resAttrVal);
    			return money;
    		}
    	}
    	return "";
    }
    
    public void insertOrder(Map<String, String> paramsMap) {
    	insertOrderBaseInfo(paramsMap);
    	insertOrderCustInfo(paramsMap);
    	insertOrderDealInfo(paramsMap);
//    	insertOrderPayLogInfo(paramsMap);
    	insertOrderPostInfo(paramsMap);
    	insertOrderResInfo(paramsMap);
    	cacuCMSPreFee(paramsMap);
    	cacuReward(paramsMap);
    	insertOrderProdInfo(paramsMap);
    	insertOrderCMSStateInfo(paramsMap);
    	insertOrderPreCMSFeeInfo(paramsMap);
//    	insertOrderReFundInfo(paramsMap);
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
    	String orderType = paramsMap.get("orderType"); //20150716 ximh add
    	
    	TdOrdDBASE record = new TdOrdDBASE();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setCreateTime(DateUtil.getNow());
    	record.setOrderFrom(orderFrom);
    	record.setOrderTime(DateUtil.getNow());
    	record.setOriginalPrice(CommonUtil.toDbPrice(CommonUtil.string2Long(originalPrice)));
    	record.setCouponMoney(CommonUtil.toDbPrice(CommonUtil.string2Long(couponMoney)));
    	record.setManMadeMoney(CommonUtil.toDbPrice(CommonUtil.string2Long(manMadeMoney)));
    	record.setPostFee(0l);
    	record.setTopayMoney(CommonUtil.toDbPrice(CommonUtil.string2Long(topayMoney)));
    	record.setIncomeMoney(0l);
    	record.setOrderState("00");
    	record.setCustRemark(custRemark);
    	record.setSellerRemark(sellerRemark);
    	record.setOrderType(orderType);  //20150716 ximh add
    
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
    	record.setOrderId(CommonUtil.string2Long(orderId));
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
    	String invoceContent = paramsMap.get("invoceContent");
    	
    	TdOrdDDEAL record = new TdOrdDDEAL();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setUserId(CommonUtil.string2Long(userId));
//    	record.setPartitionId((short)DateUtil.getCurrentMonth());
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setUserName(userName);
    	record.setPhoneNumber(phoneNum);
    	record.setDevlopId(devlpId);
    	record.setDevlopName(devlpName);
    	record.setInvoceTitle(invoiceTitle);
    	record.setInvoceContent(invoceContent);

    	tdOrdDDEALDao.insertSelective(record);
    }
    

    private void insertOrderPayLogInfo(Map<String, String> paramsMap) {
    	String orderId = paramsMap.get("orderId");
    	String payLogId = paramsMap.get("payLogId");
    	String payType = paramsMap.get("payType");
    	String payMode = paramsMap.get("payMode");
//    	String payMoney = paramsMap.get("payMoney");
    	
    	
    	TdOrdDPAYLOG record = new TdOrdDPAYLOG();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setPayLogid(CommonUtil.string2Long(payLogId));
    	record.setPayType(payType);
    	record.setPayMode(payMode);
//    	record.setPayMoney(CommonUtil.string2Long(payMoney));
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
    	String expressCompany = paramsMap.get("expressCompany");
    	
    	TdOrdDPOST record = new TdOrdDPOST();
    	record.setOrderId(CommonUtil.string2Long(orderId));
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
    	record.setExpressCompnay(expressCompany);
    	
    	tdOrdDPOSTDao.insertSelective(record);
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
    	String goodsDisc = paramsMap.get("goodsDisc");
//    	String cmsPreFee = paramsMap.get("cmsPreFee");
    	String ctlgCode = paramsMap.get("ctlgCode");
    	String originalPrice = paramsMap.get("originalPrice");
    	String albumId = paramsMap.get("albumId");
    	String verNo = paramsMap.get("verNo");
    	String merchantId = paramsMap.get("merchantId");
    	String createTime = paramsMap.get("createTime");
    	String createStaffId = paramsMap.get("createStaffId");
    	String goodsState = paramsMap.get("goodsState");
    	String recomTag = paramsMap.get("recomTag");
    	String priceRule = paramsMap.get("priceRule");
    	String beginTime = paramsMap.get("beginTime");
    	String endTime = paramsMap.get("endTime");
    	String simpDesc = paramsMap.get("simpDesc");
    	
    	TdOrdDPROD record = new TdOrdDPROD();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setGoodsId(CommonUtil.string2Long(goodsId));
    	record.setGoodsName(goodsName);
    	record.setUnitPrice(CommonUtil.toDbPrice(CommonUtil.string2Long(unitPrice)));
    	record.setSaleNum(CommonUtil.string2Int(saleNum));
    	record.setTopayFee(CommonUtil.toDbPrice(CommonUtil.string2Long(topayFee)));
    	record.setDerateFee(CommonUtil.toDbPrice(CommonUtil.string2Long(derateFee)));
    	record.setDerateReason(derateReason);
    	record.setRecvFee(CommonUtil.toDbPrice(CommonUtil.string2Long(recvFee)));
    	record.setResInfo(goodsDisc);
    	
    	record.setCtlgCode(CommonUtil.string2Long(ctlgCode));
    	record.setOriginalPrice(CommonUtil.toDbPrice(CommonUtil.string2Long(originalPrice)));
    	record.setAlbumId(CommonUtil.string2Long(albumId));
    	record.setVerNo(Short.parseShort(verNo));
    	record.setMerchantId(CommonUtil.string2Int(merchantId));
    	record.setCreateTime(DateUtils.parse(createTime, DateUtils.TIMESTAMP_FORMAT));
    	record.setCreateStaffId(CommonUtil.string2Long(createStaffId));
    	record.setGoodsState(goodsState);
    	record.setRecomTag(recomTag);
    	record.setPriceRule(priceRule);
    	record.setBeginTime(DateUtils.parse(beginTime, DateUtils.TIMESTAMP_FORMAT));
    	record.setEndTime(DateUtils.parse(endTime, DateUtils.TIMESTAMP_FORMAT));
    	record.setSimpDesc(simpDesc);
//    	record.setCmsPreFee(CommonUtil.toDbPrice(CommonUtil.string2Float(cmsPreFee)));
    	
    	
    	tdOrdDPRODDao.insertSelective(record);
    }
    
    private void insertOrderResInfo(Map<String, String> paramsMap) {
    	String resAttrStr = paramsMap.get("resAttr");
    	String orderId = paramsMap.get("orderId");
    	
    	if(resAttrStr == null) {
    		return;
    	}
    	
    	String[] rows = resAttrStr.split("\\^", -1);
    	for(String row : rows) {
    		String[] col = row.split("\\|", -1);
    		if(col.length < 3) {
    			continue;
    		}
    		
    		String resId = col[0];
    		String resAttrCode = col[1];
    		String resAttrVal = col[2];
    		String values1 = "";
    		if(col.length > 3) {
    			values1 = col[3];
    		}
    		
    		TdOrdDRES record = new TdOrdDRES();
    		record.setOrderId(CommonUtil.string2Long(orderId));
        	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
        	record.setResId(CommonUtil.string2Long(resId));
        	record.setResAttrCode(resAttrCode);
        	record.setResAttrVal(resAttrVal);
        	record.setValues1(values1);
    		tdOrdDRESDao.insertSelective(record);
    	}
    }
    	
	private void insertOrderReFundInfo(Map<String, String> paramsMap) {
		String orderId = paramsMap.get("orderId");
    	String topayFee = paramsMap.get("topayFee");
    	
    	TdOrdDREFUND record = new TdOrdDREFUND();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	record.setTxnAmt(CommonUtil.toDbPrice(CommonUtil.string2Long(topayFee)));
    	
    	tdOrdDREFUNDDao.insertSelective(record);
	}
	
	private void insertOrderCMSStateInfo(Map<String, String> paramsMap) {
		String orderId = paramsMap.get("orderId");
    	
    	TdOrdDCMSSTATE record = new TdOrdDCMSSTATE();
    	record.setOrderId(CommonUtil.string2Long(orderId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
    	//record.setCmsType("0");
    	record.setCmsState("00");
    	record.setAddTime(DateUtil.getNow());
    	
    	tdOrdDCMSSTATEDao.insertSelective(record);
	}
	
	private void insertOrderPreCMSFeeInfo(Map<String, String> paramsMap) {
		String orderId = paramsMap.get("orderId");
		String goodsId = paramsMap.get("goodsId");
		
		if(paramsMap.containsKey("cmsPreFee")) {
			String cmsPreFee = paramsMap.get("cmsPreFee");
			TdOrdDPRECMSFEE record = new TdOrdDPRECMSFEE();
			record.setOrderId(CommonUtil.string2Long(orderId));
			record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
			record.setGoodsId(CommonUtil.string2Long(goodsId));
			record.setCmsType("0");
			record.setCmsPreFee(CommonUtil.toDbPrice(CommonUtil.string2Float(cmsPreFee)));
			tdOrdDPRECMSFEEDao.insertSelective(record);
		}
		
		if(paramsMap.containsKey("reward")) {
			String reward = paramsMap.get("reward");
			TdOrdDPRECMSFEE record = new TdOrdDPRECMSFEE();
			record.setOrderId(CommonUtil.string2Long(orderId));
			record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(orderId)));
			record.setGoodsId(CommonUtil.string2Long(goodsId));
			record.setCmsType("1");
			record.setCmsPreFee(CommonUtil.string2Long(reward));
			tdOrdDPRECMSFEEDao.insertSelective(record);
		}
		
		
	}
	
	/**
	 * 订单提交后
	 */
	public int updateGoodsAmount(String goods_id){
		//2个方法在一个事务里,库存减1，销售加1
		//orderDao.storeDelOne();
		//orderDao.salesAddOne();
		return orderDao.updateGoodsAmount(goods_id);
	}
	
	/**
	 * 如果订单半小时后未支付，释放预占的号码，同时库存数量销量都要相应返销,同时
	 */
	public boolean ordersTimeoutReverse(String[] orderIds, String[] goodIds){
		if(goodIds.length > 0){
			//几个个方法在一个事务里,库存减+1，销售减-1
			int r1 = orderDao.updateGoodsAmountReverse(goodIds);
			logger.debug("【订单超时未支付定时任务：商品数量表update " + r1 + " 条记录】");
		}
		
/*		if(orderIds.length > 0){
			//下面是删除订单相关表
			int r2 = orderDao.deleteOrderBaseInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_BASE表delete " + r2 + " 条记录】");
			
			int r3 = orderDao.deleteOrderCustInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_CUST表delete " + r3 + " 条记录】");
			
			int r4 = orderDao.deleteOrderDealInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_DEAL表delete " + r4 + " 条记录】");
			
			int r5 = orderDao.deleteOrderPostInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_POST表delete " + r5 + " 条记录】");
			
			int r6 = orderDao.deleteOrderResInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_RES表delete " + r6 + " 条记录】");
			
			int r7 = orderDao.deleteOrderCMSPreFee(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_PRECMSFEE表delete " + r7 + " 条记录】");
			
			int r8 = orderDao.deleteOrderProdInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_PROD表delete " + r8 + " 条记录】");
			
			int r9 = orderDao.deleteOrderCMSStateInfo(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_CMSSTATE表delete " + r9 + " 条记录】");
		}*/
		
		//20150603 ximh 修改，做逻辑删除，不做物理删除，更新订单状态为99,作废
		if(orderIds.length > 0){
			int r10 = orderDao.updateOrderBaseState(orderIds);
			logger.debug("【订单超时未支付定时任务：ORD_D_BASE表update " + r10 + " 条记录,order_state=99】");
		}

		return true; //只要不报异常就返回true
		
	}
	
    /**
     * 查询超时超时未支付的订单，sql里写死了超时时间为半小时 
     * @return
     */
    public List<Map<Object, Object>> queryOrdersTimeout(){
    	List<Map<Object, Object>> list = orderDao.queryOrdersTimeout();
    	logger.debug("【订单超时未支付库存释放定时任务：查询到超时未支付订单 " + list.size() + " 个】");
        return list;
    }
    
    /**
     * 支付改造后新的方法：支付表用新的 ord_d_pay 表
     * 查询超时超时未支付的订单，sql里写死了超时时间为半小时 
     * @return
     */
    public List<Map<Object, Object>> queryOrdersTimeout2(){
    	List<Map<Object, Object>> list = orderDao.queryOrdersTimeout2();
    	logger.debug("【订单超时未支付库存释放定时任务：查询到超时未支付订单 " + list.size() + " 个】");
        return list;
    }
    
    public static void main(String[] args) {
        	String resAttrStr = "3415041400000014|PACKRES|校园沃派16元套餐|校园沃派16元套餐";
        	
        	String[] col = resAttrStr.split("\\|", -1);
        	String resAttrCode = col[1];
    		String resAttrVal = col[2];
        	String money = RegexUtil.getMoney(resAttrVal);
			System.out.println(money);
        	System.out.println("bb");
	}
    	
    
    /**
     * @author wenh
     * 根据order_id查询ord_d_deallog获得订单状态流转详情
     * 
     */
    
   public List<Map<String, Object>> queryOrdersDealLogByOrderId(String order_id)
   {
	   return orderDao.queryOrdersDealLogByOrderId(order_id);

   }
}
