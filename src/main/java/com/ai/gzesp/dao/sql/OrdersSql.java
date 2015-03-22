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

@Service
public class OrdersSql {

	@Resource
	private CommonDao commonDao;
	
//	select ORD_D_DEAL.ORDER_ID,
	//ORD_D_PROD.GOODS_NAME,
	//ORD_D_BASE.INCOME_MONEY,
	//ORD_D_BASE.Order_Time,
	//ORD_D_POST.RECEIVER_NAME,
	//ORD_D_POST.POST_ADDR,
	//ORD_D_POST.MOBILE_PHONE,
	//ORD_D_POST.DELIVER_TIME_CODE,
	//ORD_D_PAYLOG.PAY_MODE,
	//ORD_D_PAYLOG.PAY_STATE,
	//ORD_D_PAYLOG.PAY_REMARK
//	 from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_PAYLOG,ORD_D_POST where 
//	 ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id 
	//and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id 
	//and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id 
	//and ORD_D_POST.Order_Id=ORD_D_PAYLOG.Order_Id
//	 	
	//通过userid获取商品列表
	public List<Map<String, Object>> getOrdersListbyUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("select "
				+"ORD_D_DEAL.ORDER_ID,"//订单id
				+"ORD_D_PROD.GOODS_NAME,"//商品名称
				+"ORD_D_BASE.INCOME_MONEY,"//订单金额
				+"ORD_D_BASE.Order_Time,"//下单时间
				+"ORD_D_POST.RECEIVER_NAME,"//收件人
				+"ORD_D_POST.POST_ADDR,"//详细地址
				+"ORD_D_POST.MOBILE_PHONE,"//联系电话
				+"NVL(ORD_D_POST.DELIVER_TIME_CODE,'0') as Deliver_Time_Code,"
				//+"ORD_D_POST.DELIVER_TIME_CODE,"//送货时间
				+"ORD_D_PAYLOG.PAY_MODE,"//支付方式
				+"ORD_D_PAYLOG.PAY_STATE,"//订单状态
				+"NVL(ORD_D_PAYLOG.PAY_REMARK,'0') as PAY_REMARK"
				//+"ORD_D_PAYLOG.PAY_REMARK"//无货处理
				//+"GDS_D_PHOTO.PHOTO_LINKS"//先注释掉，后面需要放开注释
				);
		sb.append(" from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_PAYLOG,ORD_D_POST");//GDS_D_PHOTO,GDS_D_INFO 先注释掉后面需要放开注释
		sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
				+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
				+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
				+" and ORD_D_POST.Order_Id=ORD_D_PAYLOG.Order_Id"	
				//+" and GDS_D_INFO.Goods_Id=ORD_D_PROD.Goods_Id"先注释掉，后面需要放开注释
				//+ "and GDS_D_INFO.ALBUM_ID=GDS_D_PHOTO.ALBUM_ID"先注释掉，后面需要放开注释
				+" and ORD_D_DEAL.USER_ID="+strUserID
				+" order by ORD_D_BASE.Order_Time DESC"
				);
		System.out.println(sb.toString());
		List<Map<String, Object>> orderList =commonDao.queryForList(sb.toString());

		return orderList;
		
	}
	
	//通过userid获取商品列表
	public List getOrdersList(String strUserID,String strOrderID,String startDate,String endDate)
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
		
		sb.append("select "
				+"ORD_D_DEAL.ORDER_ID,"
				+"ORD_D_PROD.GOODS_NAME,"
				+"ORD_D_BASE.INCOME_MONEY,"
				+"ORD_D_BASE.Order_Time,"
				+"ORD_D_POST.RECEIVER_NAME,"
				+"ORD_D_POST.POST_ADDR,"
				+"ORD_D_POST.MOBILE_PHONE,"
				+"NVL(ORD_D_POST.DELIVER_TIME_CODE,'0') as Deliver_Time_Code,"
				//+"ORD_D_POST.DELIVER_TIME_CODE,"
				+"ORD_D_PAYLOG.PAY_MODE,"
				+"ORD_D_PAYLOG.PAY_STATE,"
				+"NVL(ORD_D_PAYLOG.PAY_REMARK,'0') as PAY_REMARK"
				//+"ORD_D_PAYLOG.PAY_REMARK"
				+" "
				);
		sb.append("from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_PAYLOG,ORD_D_POST");
		sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
				+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
				+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
				+" and ORD_D_POST.Order_Id=ORD_D_PAYLOG.Order_Id"	
				+" and ORD_D_DEAL.USER_ID="+strUserID
				);
		if (strOrderID.length()<=0 && startDate.length()<=0) //订单id为空 ,时间为空，查全部的
		{
			

		}
		else if (strOrderID.length()>0 && startDate.length()>0)//订单id不为空，时间不为空，按时间，订单id查
		{
			sb.append(" and ORD_D_DEAL.ORDER_ID=" + strOrderID);
			sb.append(" and ORD_D_BASE.Order_Time >="+"to_date('"+startDate+"','yyyy-mm-dd')" +" and ORD_D_BASE.Order_Time <"+ "to_date('"+endDate+"','yyyy-mm-dd')");
		}
		else if(strOrderID.length()<=0 && startDate.length()>0)//订单id为空，时间不为空，按时间查
		{
			sb.append(" and ORD_D_BASE.Order_Time >="+"to_date('"+startDate+"','yyyy-mm-dd')" +" and ORD_D_BASE.Order_Time <"+ "to_date('"+endDate+"','yyyy-mm-dd')");
		}
		else if(strOrderID.length()>0 && startDate.length() <=0)//订单不为空，时间为空，按订单id查
		{
			sb.append(" and ORD_D_DEAL.ORDER_ID=" + strOrderID);
		}
		sb.append(" order by ORD_D_BASE.Order_Time DESC");
		System.out.println(sb.toString());
		List orderList =commonDao.queryForList(sb.toString());
	
		return orderList;
	}
	//通过userid获得订单获得订单量
	//iflag 
	public List getOrderCountByUserID(String strUserID)
	{
		strUserID="1234567890";
		StringBuffer sb=new StringBuffer();
		
		sb.append("select b.user_id,");
		sb.append("count(case when a.CREATE_TIME >=to_date(to_char(sysdate-1,'yyyy/mm/dd'),'yyyy/mm/dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy/mm/dd'),'yyyy/mm/dd') then 1 else null end) yesterday_count,");
		sb.append("count(case when a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy/mm'),'yyyy/mm') and a.CREATE_TIME < add_months(to_date(to_char(sysdate,'yyyy/mm'),'yyyy/mm'),1) then 1 else null end) month_count,");
		sb.append("count(1) total_count");
		sb.append(" from ORD_D_BASE a,ORD_D_DEAL b");
		sb.append(" where a.order_id=b.order_id");
		sb.append(" and b.user_id=" + strUserID);
		sb.append(" group by b.user_id");
		System.out.println(sb.toString());
		List saleList =commonDao.queryForList(sb.toString());

		return saleList;
	}
}
