/**
 * @author wenhui
 * 查询订单相关操作
 * 
 */
package com.ai.gzesp.dao.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;
import com.ai.sysframe.utils.StringUtil;
import com.ibm.wsdl.util.StringUtils;

@Service
public class OrdersSql {

	@Resource
	private CommonDao commonDao;	
	
	//通过userid获取商品列表
	/**
	 * 通过userid获得所有的订单商品列表数据()
	 * strUserID: 用户id
	 * 返回：该userid对应所有的订单商品列表数据
	 * 
	 * 
	 */
	public List<Map<String, Object>> getOrdersListbyUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("with T1 as"
				+"("
				+"select "
				+"ORD_D_DEAL.ORDER_ID,"//订单id
				+"ORD_D_PROD.GOODS_NAME,"//商品名称
				+"ORD_D_PROD.TOPAY_FEE,"//订单金额
				+"ORD_D_BASE.Order_Time,"//下单时间
				+"ORD_D_POST.RECEIVER_NAME,"//收件人
				+"ORD_D_POST.POST_ADDR,"//详细地址
				+"ORD_D_POST.MOBILE_PHONE,"//联系电话
				+"case when ORD_D_POST.DELIVER_TIME_CODE ='00' then"
				+"'工作日'"
				+"when ORD_D_POST.DELIVER_TIME_CODE ='01' then"
				+"'周末'"
				+"when ORD_D_POST.DELIVER_TIME_CODE ='02' then" 
				+"'工作日、周末'"
				+"else"
				+"'未知'"
				+"end" 
				+" DELIVER_TIME_CODE,"
				+"case when ORD_D_POST.DELIVER_TYPE_CODE ='00' then"
				+"'不需要配送'"
				+"when ORD_D_POST.DELIVER_TYPE_CODE ='01' then"
				+"'送货'"
				+"when ORD_D_POST.DELIVER_TYPE_CODE ='02' then" 
				+"'自提'"
				+"else"
				+"'未知'"
				+"end" 
				+" DELIVER_TYPE_CODE,"
				+"ORD_D_BASE.ORDER_STATE,"//订单状态
				+"GDS_D_PHOTO.PHOTO_LINKS,"//先注释掉，后面需要放开注释
				+ "ORD_D_BASE.ORDER_TYPE"
				);
		sb.append(" from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_POST,GDS_D_INFO,GDS_D_PHOTO");
		sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
				+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
				+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
				+" and GDS_D_INFO.Goods_Id=ORD_D_PROD.Goods_Id" //先注释掉，后面需要放开注释
				+" and GDS_D_INFO.ALBUM_ID=GDS_D_PHOTO.ALBUM_ID" //先注释掉，后面需要放开注释
				+" and GDS_D_PHOTO.DEFAULT_TAG=0"
				+" and ORD_D_DEAL.USER_ID='"+strUserID+"'"
				+" order by ORD_D_BASE.Order_Time DESC"
				);
		sb.append("),");
		sb.append("T2 as ("
				+ "select Order_id,PAY_MODE from ORD_D_PAY "
				+ ")");
		sb.append("select * from ("
				+ "select tt.*,ROWNUM as rowno from (");
		sb.append("select T1.ORDER_ID,"
				+ "T1.GOODS_NAME,"
				+ "T1.TOPAY_FEE,"
				+ "T1.Order_Time,"
				+ "T1.RECEIVER_NAME,"
				+ "T1.POST_ADDR,"
				+ "T1.MOBILE_PHONE,"
				+ "T1.DELIVER_TIME_CODE,"
				+ "T1.DELIVER_TYPE_CODE,"
				+ "T1.ORDER_STATE,"
				+"T1.PHOTO_LINKS,"
				+"T2.PAY_MODE,"
				+ "ORDER_TYPE"
				+" from T1,T2 where T1.Order_id=T2.Order_id(+) and T1.ORDER_STATE !='99'"
				);
		sb.append(" ) tt");
		sb.append(" where Rownum <="+4+") table_alias");
		sb.append("	where table_alias.rowno >="+1);
		
		System.out.println(sb.toString());
		List<Map<String, Object>> orderList =commonDao.queryForList(sb.toString());

		return orderList;
		
	}
	
	//通过orderid获取商品信息:订单详情
	public List getOrderInfobyOrderID(String strOrderID)
	{
	StringBuffer sb=new StringBuffer();
	sb.append("with T1 as"
			+"("
			+"select "
			+"ORD_D_DEAL.ORDER_ID,"//订单id
			+"ORD_D_PROD.GOODS_NAME,"//商品名称
			+"ORD_D_PROD.TOPAY_FEE,"//订单金额
			+"ORD_D_BASE.Order_Time,"//下单时间
			+"ORD_D_POST.RECEIVER_NAME,"//收件人
			+"ORD_D_POST.POST_ADDR,"//详细地址
			+"ORD_D_POST.MOBILE_PHONE,"//联系电话
			+"case when ORD_D_POST.DELIVER_TIME_CODE ='00' then"
			+"'工作日'"
			+"when ORD_D_POST.DELIVER_TIME_CODE ='01' then"
			+"'周末'"
			+"when ORD_D_POST.DELIVER_TIME_CODE ='02' then" 
			+"'工作日、周末'"
			+"else"
			+"'未知'"
			+"end" 
			+" DELIVER_TIME_CODE,"
			+"case when ORD_D_POST.DELIVER_TYPE_CODE ='00' then"
			+"'不需要配送'"
			+"when ORD_D_POST.DELIVER_TYPE_CODE ='01' then"
			+"'送货'"
			+"when ORD_D_POST.DELIVER_TYPE_CODE ='02' then" 
			+"'自提'"
			+"else"
			+"'未知'"
			+"end" 
			+" DELIVER_TYPE_CODE,"
			+"ORD_D_BASE.ORDER_STATE,"//订单状态
			+"GDS_D_PHOTO.PHOTO_LINKS,"//先注释掉，后面需要放开注释
			+ "(select RES_ATTR_VAL from ord_d_res where order_id='"+strOrderID+"' and Res_attr_code='NUMBERS') as RES_ATTR_VAL_1,"
			+ "(select RES_ATTR_VAL from ord_d_res where order_id='"+strOrderID+"' and Res_attr_code='SAVEMEY') as RES_ATTR_VAL_2,"
			+ "(select RES_ATTR_VAL from ord_d_res where order_id='"+strOrderID+"' and Res_attr_code='PACKRES') as RES_ATTR_VAL_3,"
			+ "(select RES_ATTR_VAL from ord_d_res where order_id='"+strOrderID+"' and Res_attr_code='FMONTHD') as RES_ATTR_VAL_4"
			);
	sb.append(" from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_POST,GDS_D_INFO,GDS_D_PHOTO,ORD_D_RES");
	sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
			+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
			+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
			+" and ORD_D_PROD.Order_Id=ORD_D_RES.Order_Id"
			+" and GDS_D_INFO.Goods_Id=ORD_D_PROD.Goods_Id" //先注释掉，后面需要放开注释
			+" and GDS_D_INFO.ALBUM_ID=GDS_D_PHOTO.ALBUM_ID" //先注释掉，后面需要放开注释
			+" and GDS_D_PHOTO.DEFAULT_TAG=0"
			+" and ORD_D_DEAL.ORDER_ID='"+strOrderID+"'"
			+" and ORD_D_RES.RES_ATTR_CODE='NUMBERS'"
			+" order by ORD_D_BASE.Order_Time DESC"
			);
	sb.append("),");
	sb.append("T2 as ("
			+ "select Order_id,PAY_MODE from ORD_D_PAY "
			+ ")");
	sb.append("select distinct T1.ORDER_ID,"
			+ "T1.GOODS_NAME,"
			+ "T1.TOPAY_FEE,"
			+ "T1.Order_Time,"
			+ "T1.RECEIVER_NAME,"
			+ "T1.POST_ADDR,"
			+ "T1.MOBILE_PHONE,"
			+ "T1.DELIVER_TIME_CODE,"
			+ "T1.DELIVER_TYPE_CODE,"
			+ "T1.ORDER_STATE,"
			+"T1.PHOTO_LINKS,"
			+"T2.PAY_MODE,"
			+ "case"
			+ " when RES_ATTR_VAL_1 is null then"
            + "'无号码'"
            + " else"
            + " RES_ATTR_VAL_1"
            + " end RES_ATTR_VAL_1,"
			+ "case"
			+ " when RES_ATTR_VAL_2 is null then"
            + "'无'"
            + " else"
            + " RES_ATTR_VAL_2"
            + " end RES_ATTR_VAL_2,"
			+ "case"
			+ " when RES_ATTR_VAL_3 is null then"
            + "'无'"
            + " else"
            + " RES_ATTR_VAL_3"
            + " end RES_ATTR_VAL_3,"  
			+ "case"
			+ " when RES_ATTR_VAL_4 is null then"
            + "'无'"
            + " else"
            + " RES_ATTR_VAL_4"
            + " end RES_ATTR_VAL_4,"
            + "case"
            + " when REFUND_STATE = '11' then"
            + " '店主审核中'"
            + " when REFUND_STATE = '12' then"
            + " '管理员审核中'"
            + " when REFUND_STATE = '13' then"
            + " '审核通过未退款'"
            + " when REFUND_STATE = '14' then"
            + " '审核通过已退款'"
            + " when REFUND_STATE = '15' then"
            + " '店主审核不通过'"
            + " when REFUND_STATE = '16' then"
            + " '管理员审核不通过'"
            + " else "
            + " '未知'"
            + " end REFUND_STATE,REFUND_REASON,T3.ORDER_STATE as ORDER_STATE_REFUND"
			+ " from T1,T2,ord_d_refund T3 where T1.Order_id=T2.Order_id(+)"
			+ " and T1.Order_id=T3.Order_id(+) and T1.ORDER_STATE !='99'"
			);	
	
		System.out.println(sb.toString());
		List<Map<String, Object>> orderList =commonDao.queryForList(sb.toString());

		return orderList;
	}
	
	/**
	 * 通过各个条件查询订单的数据
	 * @param strUserID 用户id
	 * @param strOrderID 订单id
	 * @param startDate 订单开始时间
	 * @param endDate 订单结束时间
	 * @param strHidePageIndex 分页用到的
	 * @return 筛选出来的订单数据
	 */
	public List getOrdersList(String strUserID,String strOrderID,String startDate,String endDate,int strHidePageIndex)
	{
		if (strOrderID==null) {
			strOrderID="";
		}
		if(startDate==null)
		{
			startDate="";
		}
		if(endDate==null){
			endDate="";
		}
		StringBuffer sb=new StringBuffer();
		
		sb.append("with T1 as"
				+"("
				+"select "
				+"ORD_D_DEAL.ORDER_ID,"//订单id
				+"ORD_D_PROD.GOODS_NAME,"//商品名称
				+"ORD_D_PROD.TOPAY_FEE,"//订单金额
				+"ORD_D_BASE.Order_Time,"//下单时间
				+"ORD_D_POST.RECEIVER_NAME,"//收件人
				+"ORD_D_POST.POST_ADDR,"//详细地址
				+"ORD_D_POST.MOBILE_PHONE,"//联系电话
				+"case when ORD_D_POST.DELIVER_TIME_CODE ='00' then"
				+"'工作日'"
				+"when ORD_D_POST.DELIVER_TIME_CODE ='01' then"
				+"'周末'"
				+"when ORD_D_POST.DELIVER_TIME_CODE ='02' then" 
				+"'工作日、周末'"
				+"else"
				+"'未知'"
				+"end" 
				+" DELIVER_TIME_CODE,"
				+"case when ORD_D_POST.DELIVER_TYPE_CODE ='00' then"
				+"'不需要配送'"
				+"when ORD_D_POST.DELIVER_TYPE_CODE ='01' then"
				+"'送货'"
				+"when ORD_D_POST.DELIVER_TYPE_CODE ='02' then" 
				+"'自提'"
				+"else"
				+"'未知'"
				+"end" 
				+" DELIVER_TYPE_CODE,"
				+"ORD_D_BASE.ORDER_STATE,"//订单状态
				+"GDS_D_PHOTO.PHOTO_LINKS,"//先注释掉，后面需要放开注释
				+ "ORD_D_BASE.ORDER_TYPE"
				);
		sb.append(" from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_POST,GDS_D_INFO,GDS_D_PHOTO");
		sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
				+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
				+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
				+" and GDS_D_INFO.Goods_Id=ORD_D_PROD.Goods_Id" //先注释掉，后面需要放开注释
				+" and GDS_D_INFO.ALBUM_ID=GDS_D_PHOTO.ALBUM_ID" //先注释掉，后面需要放开注释
				+" and GDS_D_PHOTO.DEFAULT_TAG=0"
				+" and ORD_D_DEAL.USER_ID='"+strUserID+"'"
				);
		if (strOrderID.length()<=0 && startDate.length()<=0) //订单id为空 ,时间为空，查全部的
		{
			

		}
		else if (strOrderID.length()>0 && startDate.length()>0)//订单id不为空，时间不为空，按时间，订单id查
		{
			sb.append(" and ORD_D_DEAL.ORDER_ID=" + strOrderID);
			sb.append(" and ORD_D_BASE.Order_Time >="+"to_date('"+startDate+"','yyyy-mm-dd')" +" and ORD_D_BASE.Order_Time <"+ "to_date('"+endDate+"','yyyy-mm-dd')+1");
		}
		else if(strOrderID.length()<=0 && startDate.length()>0)//订单id为空，时间不为空，按时间查
		{
			sb.append(" and ORD_D_BASE.Order_Time >="+"to_date('"+startDate+"','yyyy-mm-dd')" +" and ORD_D_BASE.Order_Time <"+ "to_date('"+endDate+"','yyyy-mm-dd')+1");
		}
		else if(strOrderID.length()>0 && startDate.length() <=0)//订单不为空，时间为空，按订单id查
		{
			sb.append(" and ORD_D_DEAL.ORDER_ID=" + strOrderID);
		}
		sb.append(" order by ORD_D_BASE.Order_Time DESC");
		sb.append("),");
		sb.append("T2 as ("
				+ "select Order_id,PAY_MODE from ORD_D_PAY"
				+ ")");
		
		
		sb.append("select * from ("
				+ "select tt.*,ROWNUM as rowno from (");
		sb.append("select T1.ORDER_ID,"
				+ "T1.GOODS_NAME,"
				+ "T1.TOPAY_FEE,"
				+ "T1.Order_Time,"
				+ "T1.RECEIVER_NAME,"
				+ "T1.POST_ADDR,"
				+ "T1.MOBILE_PHONE,"
				+ "T1.DELIVER_TIME_CODE,"
				+ "T1.DELIVER_TYPE_CODE,"
				+ "T1.ORDER_STATE,"
				+ "T1.PHOTO_LINKS,"
				+ "T2.PAY_MODE,"
				+ "ORDER_TYPE"
				+ " from T1,T2 where T1.Order_id=T2.Order_id(+) and T1.ORDER_STATE !='99'"
				);				
		sb.append(" ) tt");
		sb.append(" where Rownum <="+(strHidePageIndex+3)+") table_alias");
		sb.append("	where table_alias.rowno >="+strHidePageIndex);
		
		System.out.println(sb.toString());
		List orderList =commonDao.queryForList(sb.toString());
	
		return orderList;
	}
	/**
	 * 能人管理首页 展示该用户的订单总量
	 * @param strUserID：用户id
	 * @return 返回订单总量
	 */
	public List getOrderCountByUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("select b.user_id,");
		sb.append("count(case when a.CREATE_TIME >=to_date(to_char(sysdate-1,'yyyy/mm/dd'),'yyyy/mm/dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy/mm/dd'),'yyyy/mm/dd') then 1 else null end) yesterday_count,");
		sb.append("count(case when a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy/mm'),'yyyy/mm') and a.CREATE_TIME < add_months(to_date(to_char(sysdate,'yyyy/mm'),'yyyy/mm'),1) then 1 else null end) month_count,");
		sb.append("count(1) total_count");
		sb.append(" from ORD_D_BASE a,ORD_D_DEAL b");
		sb.append(" where a.order_id=b.order_id"
				+ " and a.ORDER_STATE !='99'");
		sb.append(" and b.user_id='" + strUserID+"'");
		sb.append(" group by b.user_id");
		System.out.println(sb.toString());
		List saleList =commonDao.queryForList(sb.toString());

		return saleList;
	}
	
	
	/*
	 * 用户订单查询
	 * passport：身份证号
	 * phone：手机号
	 * keyword：搜索的条件
	 * iHidePageIndex：分页使用
	 * 
	 * 用户订单查询只能查询由客户自身购买的订单信息（查询不到代客下单的消息）
	 * 返回：该身份证号和手机号对应的所有的订单信息列表
	 */
	
	public List getCustMyOrder(String passport, String phone, String keyword,int iHidePageIndex) {
		StringBuffer sb=new StringBuffer();
		sb.append("select * from ("
				+ "select tt.*,ROWNUM as rowno from (");
		sb.append("select distinct"
				+ "	a.ORDER_ID, b.ORDER_STATE as ORDER_STATE_CODE ,"
				+ " CASE WHEN b.ORDER_STATE='00' then '待支付'"
				+ " WHEN b.ORDER_STATE='01' then '待分配'"
				+ " WHEN b.ORDER_STATE='02' then '待处理'"
				+ " WHEN b.ORDER_STATE='03' then '处理中'"
				+ " WHEN b.ORDER_STATE='04' then '待发货'"
				+ " WHEN b.ORDER_STATE='05' then '发货中'"
				+ " WHEN b.ORDER_STATE='06' then '物流在途'"
				+ " WHEN b.ORDER_STATE='07' then '待归档'"
				+ " WHEN b.ORDER_STATE='08' then '成功关闭（已归档）'"
				+ " WHEN b.ORDER_STATE='09' then '订单处理退单'"
				+ " WHEN b.ORDER_STATE='10' then '客户拒收退单'"
				+ " WHEN b.ORDER_STATE='11' then '店主审核中'"
				+ " WHEN b.ORDER_STATE='12' then '管理员审核中'"
				+ " WHEN b.ORDER_STATE='13' then '审核通过未退款'"
				+ " WHEN b.ORDER_STATE='14' then '审核通过已退款'"
				+ " ELSE '未知'"
				+ " END ORDER_STATE," 
				+ " c.GOODS_NAME, c.SALE_NUM, c.TOPAY_FEE/1000 as TOPAY_FEE, b.INCOME_MONEY/1000 as INCOME_MONEY,"
				+ " e.USER_IMG, e.STORE_NAME,  g.PHOTO_LINKS,b.Order_Time" );
		sb.append("	from ORD_D_CUST a, ORD_D_BASE b, ORD_D_PROD c, ORD_D_DEAL d, AUR_D_AUTHINFO e,"
				+ " GDS_D_INFO f, GDS_D_PHOTO g");
		sb.append(" where "
				+ " a.PSPT_NO = '" + passport + "'"
				+ " and a.PHONE_NUMBER = '"+ phone + "'"
				+ " and a.ORDER_ID = b.ORDER_ID "
				+ " and a.ORDER_ID = c.ORDER_ID "
				+ " and a.ORDER_ID = d.ORDER_ID "
				+ " and d.USER_ID = e.USER_ID "
				+ " and c.GOODS_ID = f.GOODS_ID"
				+ " and f.ALBUM_ID = g.ALBUM_ID"
				+ " and g.DEFAULT_TAG = '0'"
				+ " and ORDER_STATE!='99'" 
				+ " and ORDER_TYPE ='1'");
		if(keyword != null && !"".equals(keyword)) {
			sb.append(" and (a.ORDER_ID like '%"+keyword+"%'"
					+ " 	or c.GOODS_NAME like '%"+keyword+"%')" );
		}
		sb.append(" order by b.Order_Time DESC");
		
		sb.append(" ) tt");
		sb.append(" where Rownum <="+(iHidePageIndex+3)+") table_alias");
		sb.append("	where table_alias.rowno >="+iHidePageIndex);
		

		System.out.println(sb.toString());
		List custMyOrderList =commonDao.queryForList(sb.toString());

		return custMyOrderList;
	}
	/*
	 * 用户详细订单查询
	 * orderId:订单编号
	 * 
	 * 用户详细订单查询:获得该用户某一个订单的详细信息数据
	 * 返回：该用户某一个订单的详细数据信息
	 */
	
	public Map getCustOrderDetail(String orderId) {
		StringBuffer sb=new StringBuffer();
		sb.append("select distinct"
				+ "	a.ORDER_ID, "
				+ " b.ORDER_STATE as ORDER_STATE_CODE, b.POST_FEE, b.ORDER_TIME, b.TOPAY_MONEY/1000 as TOPAY_MONEY,"
				+ " CASE WHEN b.ORDER_STATE='00' then '待支付'"
				+ " WHEN b.ORDER_STATE='01' then '待分配'"
				+ " WHEN b.ORDER_STATE='02' then '待处理'"
				+ " WHEN b.ORDER_STATE='03' then '处理中'"
				+ " WHEN b.ORDER_STATE='04' then '待发货'"
				+ " WHEN b.ORDER_STATE='05' then '发货中'"
				+ " WHEN b.ORDER_STATE='06' then '物流在途'"
				+ " WHEN b.ORDER_STATE='07' then '待归档'"
				+ " WHEN b.ORDER_STATE='08' then '成功关闭（已归档）'"
				+ " WHEN b.ORDER_STATE='09' then '订单处理退单'"
				+ " WHEN b.ORDER_STATE='10' then '客户拒收退单'"
				+ " WHEN b.ORDER_STATE='11' then '店主审核中'"
				+ " WHEN b.ORDER_STATE='12' then '管理员审核中'"
				+ " WHEN b.ORDER_STATE='13' then '审核通过未退款'"
				+ " WHEN b.ORDER_STATE='14' then '审核通过已退款'"
				+ " ELSE '未知'"
				+ " END ORDER_STATE," 
				+ " c.GOODS_NAME, c.SALE_NUM, c.TOPAY_FEE/1000 as TOPAY_FEE, b.INCOME_MONEY/1000 as INCOME_MONEY,"
				+ " d.INVOCE_TITLE, d.INVOCE_CONTENT,"
				+ " e.USER_IMG, e.STORE_NAME,  g.PHOTO_LINKS,"
				+ " h.RECEIVER_NAME, h.MOBILE_PHONE, h.EXPRESS_ID, h.EXPRESS_COMPNAY as EXPRESS_COMPNAY_CODE,"
				+ " CASE WHEN h.EXPRESS_COMPNAY = '1' THEN '顺丰速运'"
				+ " 	 WHEN h.EXPRESS_COMPNAY = '2' THEN '宅急送' "
				+ " 	 ELSE '未知'"
				+ " END EXPRESS_COMPNAY ,"
				+ " CASE WHEN i.pay_type = '01' THEN '在线支付'"
				+ " 	 WHEN i.pay_type = '02' THEN '货到付款' "
				+ " 	 ELSE '未知'"
				+ " END PAY_TYPE ,"
				+ " i.PAY_STATE as PAY_STATE_CODE,"
				+ " CASE WHEN i.pay_state = '0' THEN '未支付'"
				+ " 	 WHEN i.pay_state = '1' THEN '支付成功' "
				+ " 	 WHEN i.pay_state = '2' THEN '支付失败' "
				+ " 	 WHEN i.pay_state = '3' THEN '已冲正' "
				+ " 	 WHEN i.pay_state = '4' THEN '冲正失败' "
				+ " 	 WHEN i.pay_state = '5' THEN '已退款' "
				+ " 	 WHEN i.pay_state = '9' THEN '已发起支付请求未收到响应' "
				+ " 	 ELSE '未知'"
				+ " END PAY_STATE ,"
				+ " j.CITY_NAME||j.DISTRICT_NAME|| h.POST_ADDR ADDRESS,"
				+ "CASE WHEN k.refund_state='00' THEN '未审核'"
                +"WHEN k.refund_state='11' THEN '店主审核中'"
                +"WHEN k.refund_state='12' THEN '管理员审核中'"
                +"WHEN k.refund_state='13' THEN '审核通过未退款'"
                +"WHEN k.refund_state='14' THEN '审核通过已退款'"
                +"WHEN k.refund_state='15' THEN '店主审核不通过'"
                +"WHEN k.refund_state='16' THEN '管理员审核不通过'"
                +"ELSE '未知'"
                +"END refund_state");
		sb.append("	from ORD_D_CUST a, ORD_D_BASE b, ORD_D_PROD c, ORD_D_DEAL d, AUR_D_AUTHINFO e,"
				+ " GDS_D_INFO f, GDS_D_PHOTO g,"
				+ " ORD_D_POST h "
				+ "LEFT JOIN ORD_D_REFUND k on h.order_id=k.order_id "
				+ "LEFT JOIN ORD_D_PAY i ON   h.ORDER_ID = i.ORDER_ID ,"
				+ "	 (select t1.CITY_NAME, t1.CITY_CODE, t2.DISTRICT_CODE, t2.DISTRICT_NAME" 
					+ " from SYS_P_WEB_CITY t1, SYS_P_WEB_DISTRICT t2"
					+ " where t1.ESS_PROVINCE_CODE = '85'" 
					+ " and t1.ESS_CITY_CODE = t2.ESS_CITY_CODE) j");
		sb.append(" where "
				+ " a.ORDER_ID = '" + orderId + "'"
				+ " and a.ORDER_ID = b.ORDER_ID "
				+ " and a.ORDER_ID = c.ORDER_ID "
				+ " and a.ORDER_ID = d.ORDER_ID "
				+ " and d.USER_ID = e.USER_ID "
				+ " and c.GOODS_ID = f.GOODS_ID"
				+ " and f.ALBUM_ID = g.ALBUM_ID"
				+ " and g.DEFAULT_TAG = '0'"
				+ "	and a.ORDER_ID = h.ORDER_ID"
				+ " and h.DISTRICT_CODE = j.DISTRICT_CODE"
				+ " and b.ORDER_STATE!='99'" );
		
		System.out.println("客户查询："+sb.toString());
		Map custOrderDetail =commonDao.queryForMap(sb.toString());
		
		return custOrderDetail;
	}
	
	//沃支付需要的订单信息_退单
	public  List<Map<String, Object>> getOrderforRefund(String order_id)
	{
		StringBuffer sb=new StringBuffer();		
		sb.append("select b.order_id,to_char(trunc(b.Create_time),'yyyymmdd') CREATE_TIME,a.PAY_FLOOD_ID,a.PAY_BALANCE,c.refund_reason");
		sb.append(" from PAY_D_WOPAY_LOG a,Ord_d_base b,Ord_d_Refund c");
		sb.append(" where a.order_id(+) = b.order_id and a.order_id=c.order_id(+) and"
				+ " b.order_id='"+order_id+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> ls =commonDao.queryForList(sb.toString());
		return ls;
	}
	//沃支付需要的订单信息_支付
	public  List<Map<String, Object>> getOrderforPay(String order_id)
	{
		StringBuffer sb=new StringBuffer();		
		sb.append("select a.order_id, a.cust_name, a.pspt_no, a.Phone_Number,b.goods_name, c.user_id");
		sb.append(" from ord_d_cust a, ORD_D_PROD b, ord_d_deal c");
		sb.append(" where a.order_id = b.order_id"
				+ " and a.order_id = c.order_id"
				+ " and a.order_id='"+order_id+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> ls =commonDao.queryForList(sb.toString());
		return ls;
	}
}
