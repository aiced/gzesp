package com.ai.gzesp.dao.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

@Service
public class CommissionSql {

	@Resource
	private CommonDao commonDao;
//	//通过日期获得佣金信息_这个方法暂时没有用到
//	public List<Map<String,Object>> getCommListbyMonth(String strUserID,String startDate)
//	{		
//		strUserID="10";
//		if (startDate==null) {
//			startDate="";
//		}
//		StringBuffer sb=new StringBuffer();
////		StringBuffer sb=new StringBuffer();
////		//select USER_ID,PARTITION_ID,ORDER_ID,CMS_MONTH,GOODS_ID,GOODS_NAME,CMS_SUM_MONEY,CMS_MONEY,CMS_MONTH, to_char(trunc(sysdate), 'yyyymm'),to_char(last_day(sysdate), 'yyyymm')
////		//from CMS_D_MONTH
////		//where user_id='111'and CMS_MONTH == to_char(trunc(sysdate), 'yyyymm') and CMS_MONTH <= to_char(last_day(sysdate), 'yyyymm')
////		sb.append("select USER_ID,PARTITION_ID,ORDER_ID,CMS_MONTH,GOODS_ID,GOODS_NAME,CMS_SUM_MONEY,CMS_MONEY,CMS_MONTH ");
////		sb.append("from CMS_D_MONTH ");
////		sb.append("where USER_ID='"+strUserID+"'");
////		if (startDate != "") {
////			sb.append(" and CMS_MONTH = to_char(to_date('"+startDate+"','yyyymmdd'),'yyyymm')");
////		}
////		else {
////			sb.append(" and CMS_MONTH = to_char(sysdate,'yyyymm')");
////		}
////
////		
////		System.out.println(sb.toString());
////		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());
////
////		return CommList;
//		
//		sb.append("with ");
//		sb.append("T1 as(");
//		sb.append("select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER");
//		sb.append("),");	
//		sb.append("T2 as(");
//		sb.append("select a.Order_Id,b.Cms_Month,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_MONTH b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.Cms_Month");	
//		sb.append("),");
//		sb.append("T3 as(");
//		sb.append("select T1.ORDER_ID,T1.USER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_MONTH from T1,T2 where T1.order_id=T2.order_id");
//		sb.append("),");
//		sb.append("T4 as(");
//		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE from ORD_D_BASE a,ORD_D_PROD b where a.Order_id=b.Order_id");
//		}
//		else if (strFlag.equals("2")) //按照订单时间查询
//		{
//			
//			//a.CREATE_TIME >=to_date(to_char(sysdate-1,'yyyy/mm/dd'),'yyyy/mm/dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy/mm/dd'),'yyyy/mm/dd') 
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE from ORD_D_BASE a,ORD_D_PROD b where a.Order_id=b.Order_id");	
//			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')");
//		}
//		else {
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE from ORD_D_BASE a,ORD_D_PROD b where a.Order_id=b.Order_id");
//		}
//
//		sb.append(")");
//		sb.append(" select * from T3,T4 where T3.order_id=T4.order_id");
//
//		
//		System.out.println(sb.toString());
//		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());
//
//		return CommList;
//		
//	}
	public List<Map<String,Object>> getCommissionCountByUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("with ");
		sb.append("T1 as(");
		sb.append("select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER");
		sb.append("),");	
		sb.append("T2 as(");
		sb.append("select a.Order_Id,b.CMS_DAY,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_DAILY b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.CMS_DAY");	
		sb.append("),");
		sb.append("T3 as(");
		sb.append("select T1.ORDER_ID,T1.USER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_DAY from T1,T2 where T1.order_id=T2.order_id");
		sb.append("),");
		sb.append("T4 as(");
		sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE,c.RECEIVER_NAME  from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id");		
		sb.append("),");
		sb.append("T5 as (");
		sb.append("select T3.ORDER_ID,USER_ID,ACT_STATUS,SUM_CMS_MONEY,CMS_DAY,CREATE_TIME,GOODS_ID,GOODS_NAME,CMS_PRE_FEE,RECEIVER_NAME from T3,T4 where T3.order_id=T4.order_id");
		sb.append(")");
		sb.append(" select count (case when create_time>=trunc(sysdate-1) and create_time<trunc(sysdate) then 1 else null end) yesterday_commison,");
		sb.append("count(case when create_time>=trunc(sysdate,'month') and create_time<trunc(add_months(sysdate,1),'month') then 1 else null end) month_commison,");
		sb.append("count(1) total_count");
		sb.append(" from T5 ");
		sb.append("where User_id='"+strUserID+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;
	}

	
	
	//根据各种条件查询佣金
	public List<Map<String,Object>> getCommListbySelectGroup(String strFlag,String strUserID,String strzhangqiTime,String strStartDate,String strEndDate,String strStatusflag)
	{
		StringBuffer sb=new StringBuffer();
		
//		with 
//		T1 as(
//		select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER
//		),
//		T2 as(
//		select a.Order_Id,b.Cms_Month,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_MONTH b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.Cms_Month
//		),
//		T3 as(
//		select T1.ORDER_ID,T1.USER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_MONTH from T1,T2 where T1.order_id=T2.order_id
//		),
//		T4 as(
//		select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE from ORD_D_BASE a,ORD_D_PROD b where a.Order_id=b.Order_id
//		)
//		select * from T3,T4 where T3.order_id=T4.order_id
		
		sb.append("with ");
		sb.append("T1 as(");
		sb.append("select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER");
		sb.append("),");	
		sb.append("T2 as(");
		sb.append("select a.Order_Id,b.CMS_DAY,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_DAILY b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.CMS_DAY");	
		sb.append("),");
		sb.append("T3 as(");
		sb.append("select T1.ORDER_ID,T1.USER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_DAY from T1,T2 where T1.order_id=T2.order_id");
		sb.append("),");
		sb.append("T4 as(");
		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE,c.RECEIVER_NAME  from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id");		
		}
		else if (strFlag.equals("2")) //按照订单时间查询
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE,c.RECEIVER_NAME  from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id");	
			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')");
		}
		else //刚一进来，默认是当天的时间 
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,b.CMS_PRE_FEE,c.RECEIVER_NAME  from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id");
			sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')");
		}

		sb.append(")");
		sb.append(" select * from T3,T4 where T3.order_id=T4.order_id");
		
		if (strStatusflag.equals("1")) //可提现 
		{
			sb.append(" and T3.ACT_STATUS='1' and T3.CMS_DAY is not null");
		}
		else if(strStatusflag.equals("2"))//无效单
		{
			sb.append(" and T3.ACT_STATUS='0' and T3.CMS_DAY is not null");
		}
		else if(strStatusflag.equals("3"))//结算中
		{
			sb.append(" and T3.ACT_STATUS='1' and T3.CMS_DAY is null");
		}
		else if(strStatusflag.equals("4"))//未激活
		{
			sb.append(" and T3.ACT_STATUS='0' and T3.CMS_DAY is null");
		}
		else //strStatusflag=-1 什么都不操作
		{
			
		}

		//sb.append(" where T3.USER_ID='"+strUserID+"'");//先注释掉
		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;
	}
	
	
	
}
