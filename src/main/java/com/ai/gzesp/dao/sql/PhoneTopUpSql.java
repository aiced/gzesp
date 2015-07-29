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
			+ "t1.GOODS_NAME as goodsName, "
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




}
