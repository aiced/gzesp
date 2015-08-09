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
public class RenewalSql {

@Resource
private CommonDao commonDao;

// 得到充值卡交易记录
public List <Map<String, Object>> GetTopUpDealList(String searchNumber) {
	
	StringBuffer sb = new StringBuffer();
	
		sb.append("select distinct "
			+ "t1.GOODS_NAME as goodsName,"
			+ "t2.BANDNUMID as bandNumber,"
			+ "t2.ORDER_ID as orderId,"
			+ "t2.ORDER_STATE as orderState,"
			+ "t2.CREATE_TIME as createTime,"
			+ "to_char(t2.TOPAY_MONEY/1000) as topayMoney "
			);
	sb.append(" from GDS_D_INFO t1, ORD_D_BAND_PAY t2");
	sb.append("	where t2.BANDNUMID =" + searchNumber 
				+ " and t1.GOODS_ID = t2.GOODS_ID"
				+ " and t2.ORDER_STATE  !='99'"
				+ " order by createTime DESC");
		
	System.out.println("################################" + sb.toString());
	List<Map<String, Object>> topUpList = commonDao.queryForList(sb.toString());
	return topUpList;
	

}

public List<Map<String, Object>> GetTopUpDealList(String searchNumber,int iHidePageIndex) {
	StringBuffer sb=new StringBuffer();
	sb.append("select * from ("
			+ "select tt.*,ROWNUM as rowno from (");
	sb.append("select distinct "
			+ "t1.GOODS_NAME as goodsName,"
			+ "t2.BANDNUMID as searchNumber,"
			+ "t2.ORDER_ID as orderId,"
			+ "t2.ORDER_STATE as orderState,"
			+ "t2.CREATE_TIME as createTime,"
			+ "to_char(t2.TOPAY_MONEY/1000) as topayMoney "
			);
	sb.append(" from GDS_D_INFO t1, ORD_D_BAND_PAY t2");
	sb.append("	where t2.BANDNUMID =" + searchNumber 
				+ " and t1.GOODS_ID = t2.GOODS_ID"
				+ " and t2.ORDER_STATE  !='99'"
				+ " order by createTime DESC");
	sb.append(" ) tt");
	sb.append(" where Rownum <="+(iHidePageIndex+10)+") table_alias");
	sb.append("	where table_alias.rowno >"+iHidePageIndex);

	System.out.println("################################" + sb.toString());
	List<Map<String, Object>> custMyOrderList =commonDao.queryForList(sb.toString());

	return custMyOrderList;
}



//得到充值卡交易记录
public List <Map<String, Object>> GetTopUpDealById(String orderId) {
	
	StringBuffer sb = new StringBuffer();
	
		sb.append("select distinct "
			+ "t1.GOODS_NAME as goodsName,"
			+ "t2.BANDNUMID as searchNumber,"
			+ "t2.ORDER_ID as orderId,"
			+ "t2.ORDER_STATE as orderState,"
			+ "t2.ORDER_FROM as orderFrom,"
			+ "t2.CREATE_TIME as createTime,"
			+ "to_char(t2.TOPAY_MONEY/1000) as topayMoney "
			);
	sb.append(" from GDS_D_INFO t1, ORD_D_BAND_PAY t2");
	sb.append("	where t2.ORDER_ID =" + orderId 
				+ " and t1.GOODS_ID = t2.GOODS_ID"
				+ " order by createTime DESC");
		
	System.out.println("################################" + sb.toString());
	List<Map<String, Object>> topUpList = commonDao.queryForList(sb.toString());
	return topUpList;
	

}

}
