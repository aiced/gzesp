package com.ai.gzesp.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	 * 得到个人信息数据
	 */
	public List GetProfileList(String userId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.USER_ID as userId,"
				+ "t1.STORE_NAME as storeName,"
				+"NVL(t1.USER_IMG,'0') as avatar,"
				+ "t1.PHONE_NUMBER as phoneNumber"
				);
		sb.append(" from AUR_D_AUTHINFO t1");
		sb.append("	where t1.USER_ID ="+ userId);
		List userList = commonDao.queryForList(sb.toString());
		return userList;
	}
	
	
	/*
	 * 得到推荐列表数据
	 */
	public List GetRcdList() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t4.PHOTO_LINKS as photoLinks"
				);
		sb.append(" from GDS_D_INFO t1,GDS_D_ABLE_RCD t2, GDS_D_PHOTO t4");
		sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t4.ALBUM_ID"
				+ " and t4.DEFAULT_TAG = '0'"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		List rcdList = commonDao.queryForList(sb.toString());
		return rcdList;
	}
	
	
	/*
	 * 获取商品列表
	 */
	public List getGoodsList() {

		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as addPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_PHOTO t4 , GDS_P_CTLG t5");
		sb.append("	where t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t4.ALBUM_ID"
				+ " and t4.DEFAULT_TAG = '0'"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		
		List goodsList = commonDao.queryForList(sb.toString());
		return goodsList;
	}
	
	public List getGoodsListNotIn(String sbStr) {

		StringBuffer sb = new StringBuffer();
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as addPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_PHOTO t4 , GDS_P_CTLG t5");
		sb.append("	where t1.GOODS_ID not in" + sbStr
				+ " and t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t4.ALBUM_ID"
				+ " and t4.DEFAULT_TAG = '0'"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");
		
		List goodsList = commonDao.queryForList(sb.toString());
		return goodsList;
	}
	/*
	 * 带有筛选条件的所有商品列表
	 */
	public List<Map<String, Object>> getGoodsListWithCondition(Map rspMap) {
		String searchKey = null;           
		String searchType= null;           
		String searchLowPrice= null;          
		String searchHightPrice= null;          
		String key;           
		String value;  
		Iterator it=rspMap.entrySet().iterator();           
		while(it.hasNext()){    
		        Map.Entry entry = (Map.Entry)it.next();
		        key=entry.getKey().toString();  
		        value=entry.getValue().toString();           
		        if(key.equals("searchKey")){
		        	searchKey = value;
		        }else if(key.equals("searchType")){
		        	searchType = value;
		        }else if(key.equals("searchLowPrice")){
		        	searchLowPrice = value;
		        }else if(key.equals("searchHightPrice")){
		        	searchHightPrice = value;
		        }
		        System.out.println(key+"===="+value);                     
		}   
		StringBuffer quarySb = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		String sbStr = null;

		sb.append("'%");
		if(searchKey !=null){
			sb.append(searchKey);
			sb.append("%'");
			sbStr = sb.toString();
			quarySb.append("select distinct "
					+ "t1.GOODS_ID as goodsId,"
					+ "t1.GOODS_NAME as goodsName, "
					+ "t2.ADD_PRICE as addPrice, "
					+ "t4.PHOTO_LINKS as photoLinks,"
					+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
					);
			quarySb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2, GDS_D_PHOTO t4 , GDS_P_CTLG t5");
			quarySb.append("	where t1.GOODS_NAME like" +sbStr
					+ " and t1.GOODS_ID = t2.GOODS_ID "
					+ " and t1.ALBUM_ID = t4.ALBUM_ID"
					+ " and t4.DEFAULT_TAG = '0'"
					+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
					+ " and t1.GOODS_STATE = '1'"
					+ " order by t1.GOODS_ID");
			
		}else if(searchType != null){
			quarySb.append("select distinct "
					+ "t1.GOODS_ID as goodsId,"
					+ "t1.GOODS_NAME as goodsName, "
					+ "t2.ADD_PRICE as addPrice, "
					+ "t4.PHOTO_LINKS as photoLinks,"
					+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
					);
			quarySb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2,  GDS_D_PHOTO t4 , GDS_P_CTLG t5");
			quarySb.append("	where t1.CTLG_CODE =" +searchType
					+ " and t1.GOODS_ID = t2.GOODS_ID "
					+ " and t1.ALBUM_ID = t4.ALBUM_ID"
					+ " and t4.DEFAULT_TAG = '0'"
					+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
					+ " and t1.GOODS_STATE = '1'"
					+ " order by t1.GOODS_ID");
			
		}else if((searchLowPrice != null) && (searchHightPrice != null)){

			quarySb.append("select distinct "
					+ "t1.GOODS_ID as goodsId,"
					+ "t1.GOODS_NAME as goodsName, "
					+ "t2.ADD_PRICE as addPrice, "
					+ "t4.PHOTO_LINKS as photoLinks,"
					+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
					);
			quarySb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2,  GDS_D_PHOTO t4 , GDS_P_CTLG t5");
			quarySb.append("	where t2.ADD_PRICE <=" + searchHightPrice 
					+ " and t2.ADD_PRICE >= "+ searchLowPrice
					+ " and t1.GOODS_ID = t2.GOODS_ID "
					+ " and t1.ALBUM_ID = t4.ALBUM_ID"
					+ " and t4.DEFAULT_TAG = '0'"
					+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
					+ " and t1.GOODS_STATE = '1'"
					+ " order by t1.GOODS_ID");
			
		}
		List<Map<String, Object>>goodsList = commonDao.queryForList(quarySb.toString());
		return goodsList;
	}



	/*
	 * 得到商品详情数据
	 */
	public List GetGoodsDetail(String goodsId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t1.GOODS_NAME as goodsName, "
				+ "t2.ADD_PRICE as goodsPrice, "
				+ "t4.PHOTO_LINKS as photoLinks,"
				+ "t5.GOODS_CTLG_NAME as goodsCtlgName"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PRICE t2,  GDS_D_PHOTO t4 , GDS_P_CTLG t5");
		sb.append(" where t1.GOODS_ID = " + goodsId
				+ "	and t1.GOODS_ID = t2.GOODS_ID "
				+ " and t1.ALBUM_ID = t4.ALBUM_ID"
				+ " and t4.DEFAULT_TAG = '0'"
				+ " and t1.CTLG_CODE = t5.GOODS_CTLG_CODE"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");

		List rcdList = commonDao.queryForList(sb.toString());
		return rcdList;
	}
	
	public List GetGoodsDetailPhotos(String goodsId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select distinct "
				+ "t1.GOODS_ID as goodsId,"
				+ "t4.PHOTO_LINKS as photoLinks"
				);
		sb.append(" from GDS_D_INFO t1, GDS_D_PHOTO t4 ");
		sb.append(" where t1.GOODS_ID = " + goodsId
				+ " and t1.ALBUM_ID = t4.ALBUM_ID"
				+ " and t1.GOODS_STATE = '1'"
				+ " order by t1.GOODS_ID");

		List goodsDatailPhotoList = commonDao.queryForList(sb.toString());
		return goodsDatailPhotoList;
	}
	
	public List GetGoodsDetailActivity(String goodsId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select distinct "
				+ "t6.ATY_TITLE as atyTitle,"
				+ "t6.ATY_CONTENT as atyContent"				);
		sb.append(" from GDS_D_INFO t1, GDS_D_ABLE_ACTIVITY t6 ");
		sb.append(" where t1.GOODS_ID = " + goodsId
				+ " and t1.GOODS_ID = t6.GOODS_ID"
				);
		List goodsActivityList = commonDao.queryForList(sb.toString());
		return goodsActivityList;
	}
	
public List<Map<String, Object>> getContractByGoodsID(String goodsID) {
		
		StringBuffer sb=new StringBuffer();
		  
//		sb.append("select  "
//				+ "a.RES_ID as resId, "
//				+ "b.ATTR_CODE as code, "
//				+ "b.ATTR_VAL_NAME as name, "
//				+ "b.VALUES1 as values "
//				+ "");
//		sb.append(" from rel_goods_res a, res_d_attrval b");
//		sb.append(" where"
//				+ "a.GOODS_ID=" + goodsID );
//		sb.append(" and  a.RES_ID = b.RES_ID ");
//		sb.append(" and  b.ATTR_CODE ='PAGERES'");
//		
//		sb.append(" union all");
//		
//		sb.append("select  "
//				+ "a.RES_ID as resId, "
//				+ "b.ATTR_CODE as code, "
//				+ "b.ATTR_VAL_NAME as name, "
//				+ "b.VALUES1 as values "
//				+ "");
//		sb.append(" from rel_goods_res a, res_d_attrval b");
//		sb.append(" where"
//				+ "a.GOODS_ID=" + goodsID );
//		sb.append(" and  a.RES_ID = b.RES_ID ");
//		sb.append(" and  b.ATTR_CODE ='PACKRES'");
		
		sb.append(" select  t1.goodsId, t1.resId, t1.name as packName, t1.values1 as packVal, t2.name as pageName , t2.values1 as pageVal from ");
		
		sb.append("  (select a.GOODS_ID as goodsId, a.RES_ID as resId, b.ATTR_CODE, b.ATTR_VAL_NAME as name ,b.VALUES1 ");
		sb.append("  from rel_goods_res a, res_d_attrval b ");
		sb.append("  where a.GOODS_ID=" + goodsID);
		sb.append("  and a.RES_ID = b.RES_ID  ");
		sb.append("  and b.ATTR_CODE like 'PACKRES') t1, ");
		
		sb.append("  (select b.RES_ID as resid, b.ATTR_CODE, b.ATTR_VAL_NAME as name ,b.VALUES1 ");
		sb.append("  from   res_d_attrval b ");
		sb.append("  where b.ATTR_CODE like 'PAGERES' ) t2 ");
		
		sb.append("  where t1.resId =  t2.resId ");
		sb.append("  order by t1.resId ");
				  
		System.err.println(sb.toString());
		
		List contractList =commonDao.queryForList(sb.toString());

		return contractList;
	}

}
