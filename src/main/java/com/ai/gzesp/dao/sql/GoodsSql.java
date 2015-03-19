package com.ai.gzesp.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

@Service
public class GoodsSql {
	
	@Resource
	private CommonDao commonDao;
	
	/*
	 * 获取商品列表
	 */
	public List getGoodsList() {
//		String sql = "select 1 from TD_APP_TASK t1, TD_APP_TASK_DATA t2 "
//    			+ "	where t1.task_type = 3 "
//    			+ " and t2.user_id = " + userId
//    			+ " and t1.task_id =  t2.task_id ";
//    	List list = commonDao.query(sql, 
//    			new RowMapper() {
//					public Object mapRow(ResultSet rs, int paramInt) throws SQLException {
//					       return null;
//					}
//    	});
//    	
//    	sql = "select t1.task_id, t1.task_score from TD_APP_TASK t1 "
//    			+ "	where t1.task_type = 3 ";
//    	List<String[]> taskIdList = commonDao.query(sql, 
//    			new RowMapper() {
//					public Object mapRow(ResultSet rs, int paramInt)
//							throws SQLException {
//							String[] strArr = {
//									rs.getString("TASK_ID"),
//									rs.getString("TASK_SCORE")
//							};
//					       return strArr;
//					}
//    	});
		
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as addPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_ALBUM t3 , GDS_D_PHOTO t4 , GDS_P_CTLG t5");
		sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t3.ALBUM_ID"
				+ " and t3.ALBUM_ID = t4.ALBUM_ID"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		
		List goodsList = commonDao.queryForList(sb.toString());
		return goodsList;
	}
	
	public List getGoodsListWithCondition(Map rspMap) {
		
//		Iterator it= rspMap.keySet().iterator();    
//		while(it.hasNext()){    
//		     String key;    
//		     String value;    
//		     key=it.next().toString();    
//		     value= rspMap.get(key);    
//		     System.out.println(key+"--"+value);    
//		}  
//		
//		for(Map.Entry<String, String> entry:rspMap.entrySet()){    
//		     System.out.println(entry.getKey()+"--->"+entry.getValue());    
//		}   
		
		Iterator it=rspMap.entrySet().iterator();           
		System.out.println( rspMap.entrySet().size());    
		String key;           
		String value;    
		while(it.hasNext()){    
		        Map.Entry entry = (Map.Entry)it.next();           
		        key=entry.getKey().toString();           
		        value=entry.getValue().toString();           
		        System.out.println(key+"===="+value);                     
		}   
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as addPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_ALBUM t3 , GDS_D_PHOTO t4 , GDS_P_CTLG t5");
		sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t3.ALBUM_ID"
				+ " and t3.ALBUM_ID = t4.ALBUM_ID"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		List goodsList = commonDao.queryForList(sb.toString());
		return goodsList;
	}
	
	public List GetRcdList() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t4.PHOTO_LINKS as photoLinks"
				);
		sb.append(" from GDS_D_INFO t1,GDS_D_ABLE_RCD t2, GDS_D_ALBUM t3, GDS_D_PHOTO t4");
		sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t3.ALBUM_ID"
				+ " and t3.ALBUM_ID = t4.ALBUM_ID"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		List rcdList = commonDao.queryForList(sb.toString());
		return rcdList;
	}
	
	public List GetGoodsDetail(String goodsId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as goodsPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName,"
				+ "t6.ATY_TITLE as atyTitle,"
				+ "t6.ATY_CONTENT as atyContent"

				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_ALBUM t3 , GDS_D_PHOTO t4 , GDS_P_CTLG t5, GDS_D_ABLE_ACTIVITY t6");
		sb.append(" where t1.GOODS_ID = " + goodsId
				+ "	and t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t3.ALBUM_ID"
				+ " and t3.ALBUM_ID = t4.ALBUM_ID"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " and t1.GOODS_ID = t6.GOODS_ID"
				+ " order by t1.GOODS_ID");

		List rcdList = commonDao.queryForList(sb.toString());
		return rcdList;
	}

}
