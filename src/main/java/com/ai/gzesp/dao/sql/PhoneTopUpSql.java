/**
 * 
 */
package com.ai.gzesp.dao.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

/**
 * @author xinjunwang
 *
 */
@Service
public class PhoneTopUpSql {

@Resource
private CommonDao commonDao;

/*
 * 得到充值卡列表数据
 */
public List <Map<String, Object>> GetTopUpList() {
	
	StringBuffer sb = new StringBuffer();
	sb.append("select distinct "
			+ "t1.GOODS_ID as goodsId,"
			+ "to_char(t2.ORIGINAL_PRICE/1000) as originalPrice, "
			+ "to_char(t2.ADD_PRICE/1000) as addPrice "
			);
	sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2");
	sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
			+ " and t1.CTLG_CODE = '17'"
			+ " order by originalPrice");
		
	System.out.println(sb.toString());
	List<Map<String, Object>> topUpList = commonDao.queryForList(sb.toString());
	return topUpList;

}

// 得到充值卡交易记录
public List <Map<String, Object>> GetTopUpDealList(String phoneNum) {
	
	StringBuffer sb = new StringBuffer();
	
		sb.append("select distinct "
			+ "t1.GOODS_NAME as goodsName,"
			+ "t2.PHONE_NUMBER as phoneNumber,"
			+ "t2.ORDER_STATE as orderState,"
			+ "t2.CREATE_TIME as createTime,"
			+ "to_char(t2.TOPAY_MONEY/1000) as topayMoney "
			);
	sb.append(" from GDS_D_INFO t1, ORD_D_CARD_PAY t2");
	sb.append("	where t2.PHONE_NUMBER =" + phoneNum 
				+ " and t1.GOODS_ID = t2.GOODS_ID"
				+ " order by createTime");
		
	System.out.println(sb.toString());
	List<Map<String, Object>> topUpList = commonDao.queryForList(sb.toString());
	return topUpList;
	

}




}
