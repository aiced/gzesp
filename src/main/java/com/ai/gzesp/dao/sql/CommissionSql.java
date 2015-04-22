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
	

	
	
	///这个sql用在算佣金的。不要删除！！！！
//	with
//	T1 as
//	 (select a.Order_Id, b.CMS_DAY, sum(CMS_MONEY) as SUM_CMS_MONEY
//	    from ORD_D_BASE a, CMS_D_DAILY b
//	   where a.Order_Id = b.Order_Id(+)
//	   group by a.order_id, b.CMS_DAY),
//
//	T2 as
//	 (select a.ORDER_ID,
//	         a.CREATE_TIME,
//	         b.Goods_Id,
//	         b.goods_name,
//	         nvl(b.CMS_PRE_FEE, 0) CMS_PRE_FEE,
//	         c.RECEIVER_NAME,
//	         d.User_Id
//	    from ORD_D_BASE a, ORD_D_PROD b, ORD_D_POST c, ORD_D_DEAL d
//	   where a.Order_id = b.Order_id
//	     and b.Order_Id = c.Order_Id
//	     and a.order_id = d.order_id),
//	     
//	T5 as
//	 (--1511429624010512  --1381429679378644
//	select t2.*,CMS_DAY,SUM_CMS_MONEY from T1,T2  where T1.Order_id=T2.order_id)
//	select sum(case
//	             when create_time >= trunc(sysdate - 1) and
//	                  create_time < trunc(sysdate) then
//	              nvl(SUM_CMS_MONEY, CMS_PRE_FEE)
//	             else
//	              0
//	           end) yesterday_commison,
//	       sum(case
//	             when create_time >= trunc(sysdate, 'month') and
//	                  create_time < trunc(add_months(sysdate, 1), 'month') then
//	              nvl(SUM_CMS_MONEY, CMS_PRE_FEE)
//	             else
//	              null
//	           end) month_commison,
//	       sum(nvl(SUM_CMS_MONEY, CMS_PRE_FEE)) total_count
//	  from T5
//	 where User_id = '2015042107084562'

	
	
	
	//算count,被屏蔽的功能
	public List<Map<String,Object>> getCommissionCountByUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("with ");
		sb.append("T1 as(");
		sb.append("select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS,Open_DATE from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER(+)");
		sb.append("),");	
		sb.append("T2 as(");
		sb.append("select a.Order_Id,b.CMS_DAY,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_DAILY b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.CMS_DAY");	
		sb.append("),");
		sb.append("T3 as(");
		sb.append("select T1.ORDER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_DAY,T1.Open_DATE from T1,T2 where T1.order_id=T2.order_id");
		sb.append("),");
		sb.append("T4 as(");
		sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");		
		sb.append("),");
		sb.append("T5 as (");
		sb.append("select T3.ORDER_ID,T4.USER_ID,ACT_STATUS,SUM_CMS_MONEY,CMS_DAY,CREATE_TIME,GOODS_ID,GOODS_NAME,CMS_PRE_FEE,RECEIVER_NAME from T3,T4 where T3.order_id=T4.order_id");
		sb.append(")");
		sb.append(" select sum(case when create_time >= trunc(sysdate - 1) and create_time < trunc(sysdate) then nvl(SUM_CMS_MONEY, CMS_PRE_FEE) else 0 end) yesterday_commison,");
		sb.append("sum(case when create_time >= trunc(sysdate, 'month') and create_time < trunc(add_months(sysdate, 1), 'month') then nvl(SUM_CMS_MONEY, CMS_PRE_FEE) else null end) month_commison,");
		sb.append("sum(nvl(SUM_CMS_MONEY, CMS_PRE_FEE)) total_count");
		sb.append(" from T5 ");
		sb.append("where User_id='"+strUserID+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;
	}

//	with T1 as
//	 (select a.Order_Id, b.CMS_DAY, sum(CMS_MONEY) as SUM_CMS_MONEY
//	    from ORD_D_BASE a, CMS_D_DAILY b
//	   where a.Order_Id = b.Order_Id(+)
//	   group by a.order_id, b.CMS_DAY),
//	T2 as
//	 (select a.ORDER_ID,
//	         a.CREATE_TIME,
//	         b.Goods_Id,
//	         b.goods_name,
//	         nvl(b.CMS_PRE_FEE, 0) CMS_PRE_FEE,
//	         c.RECEIVER_NAME,
//	         d.User_Id
//	    from ORD_D_BASE a, ORD_D_PROD b, ORD_D_POST c, ORD_D_DEAL d
//	   where a.Order_id = b.Order_id
//	     and b.Order_Id = c.Order_Id
//	     and a.order_id = d.order_id
//	     and a.CREATE_TIME >=
//	         to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd')
//	     and a.CREATE_TIME <
//	         to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') + 1),
//	T3 as (
//	select T2.ORDER_ID,T2.CREATE_TIME,T2.GOODS_ID,T2.GOODS_NAME,T2.CMS_PRE_FEE,T2.RECEIVER_NAME,T2.USER_ID,T1.CMS_DAY,T1.SUM_CMS_MONEY
//	  from T1, T2
//	 where T1.order_id = T2.order_id
//	   and T2.USER_ID = '2015042107084562' 
//	),
//	T4 as (
//	select CMS_STATE,ORDER_ID from ORD_D_CMSSTATE
//	)
//	select * from T3,T4 where T3.order_id=T4.order_id(+)
	
	
	//根据各种条件查询佣金
	public List<Map<String,Object>> getCommListbySelectGroup(String strFlag,String strUserID,String strzhangqiTime,String strStartDate,String strEndDate,String strStatusflag)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("with T1 as");
		sb.append("(select a.Order_Id, b.CMS_DAY, sum(CMS_MONEY) as SUM_CMS_MONEY"
				+ " from ORD_D_BASE a, CMS_D_DAILY b"
				+ " where a.Order_Id = b.Order_Id(+)"
				+ " group by a.order_id, b.CMS_DAY),");
		sb.append("T2 as (");
		//sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE, 0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a, ORD_D_PROD b, ORD_D_POST c, ORD_D_DEAL d where a.Order_id = b.Order_id and b.Order_Id = c.Order_Id and a.order_id = d.order_id");
		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");

		}
		else if (strFlag.equals("2")) //按照订单时间查询
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");			
			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
		}
		else //刚一进来，默认是当天的时间 
		{
			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");
			sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')+1");
		}
		sb.append("),");
		sb.append("T3 as (select T2.ORDER_ID,T2.CREATE_TIME,T2.GOODS_ID,T2.GOODS_NAME,T2.CMS_PRE_FEE,T2.RECEIVER_NAME,T2.USER_ID,T1.CMS_DAY,T1.SUM_CMS_MONEY");
		sb.append(" from T1, T2");
		sb.append(" where T1.order_id = T2.order_id and T2.USER_ID ='"+strUserID+"'),");
		sb.append("T4 as (select CMS_STATE,ORDER_ID from ORD_D_CMSSTATE)");
		sb.append("select T3.ORDER_ID,T3.CREATE_TIME,T3.GOODS_ID,T3.GOODS_NAME,T3.CMS_PRE_FEE,T3.RECEIVER_NAME,T3.USER_ID,T3.CMS_DAY,T3.SUM_CMS_MONEY,T4.CMS_STATE from T3,T4 where T3.order_id=T4.order_id(+)");
//		00：未激活
//		01：结算中
//		02：已到帐
//		03：已退货
//		04：已失效';
		if (strStatusflag.equals("00")) //未激活
		{
			sb.append(" and CMS_STATE='00'");
		}
		else if(strStatusflag.equals("01"))//结算中
		{
			sb.append(" and CMS_STATE='01'");
		}
		else if(strStatusflag.equals("02"))//已到帐
		{
			sb.append(" and CMS_STATE='02'");
		}
		else if(strStatusflag.equals("03"))//已退货
		{
			sb.append(" and CMS_STATE='03'");
		}
		else if(strStatusflag.equals("04"))//已失效
		{
			sb.append(" and CMS_STATE='04'");
		}
		else //strStatusflag=-1 什么都不操作
		{
			
		}
		
//		sb.append("with ");
//		sb.append("T1 as(");//-- 0 没到两个月 1 超过2个月
//		sb.append("select ORDER_ID,RES_ATTR_CODE,RES_ATTR_VAL,USER_ID,ACT_STATUS,Open_DATE,case when open_date < add_months(sysdate,-2) or open_date is null then '0' else '1' end OPENDATE_STATUS from ORD_D_RES,ITF_D_NUMBER_INFO where RES_ATTR_CODE='NUMBERS' and RES_ATTR_VAL=SERIAL_NUMBER(+)");
//		sb.append("),");	
//		sb.append("T2 as(");
//		sb.append("select a.Order_Id,b.CMS_DAY,sum(CMS_MONEY) as SUM_CMS_MONEY from ORD_D_BASE a,CMS_D_DAILY b where a.Order_Id=b.Order_Id(+) group by a.order_id,b.CMS_DAY");	
//		sb.append("),");
//		sb.append("T3 as(");
//		sb.append("select T1.ORDER_ID,T1.ACT_STATUS,T2.SUM_CMS_MONEY,T2.CMS_DAY,T1.Open_DATE,T1.OPENDATE_STATUS from T1,T2 where T1.order_id=T2.order_id");
//		sb.append("),");
//		sb.append("T4 as(");
//		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");		
//		}
//		else if (strFlag.equals("2")) //按照订单时间查询
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");			
//			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
//		}
//		else //刚一进来，默认是当天的时间 
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id");
//			sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')+1");
//		}
//
//		sb.append(")");
//		sb.append(" select * from T3,T4 where T3.order_id=T4.order_id");
//		
//		if (strStatusflag.equals("1")) //可提现 
//		{
//			sb.append(" and T3.ACT_STATUS='1' and T3.OPENDATE_STATUS='1'");
//		}
//		else if(strStatusflag.equals("2"))//无效单
//		{
//			sb.append(" and T3.ACT_STATUS='0' and T3.OPENDATE_STATUS='1'");
//		}
//		else if(strStatusflag.equals("3"))//结算中
//		{
//			sb.append(" and T3.ACT_STATUS='1' and T3.OPENDATE_STATUS='0'");
//		}
//		else if(strStatusflag.equals("4"))//未激活
//		{
//			sb.append(" and T3.ACT_STATUS='0' and T3.OPENDATE_STATUS='0'");
//		}
//		else //strStatusflag=-1 什么都不操作
//		{
//			
//		}
//
//		sb.append(" and T4.USER_ID='"+strUserID+"'");//先注释掉
//		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;
	}
	
	public String getCmsRuleByGoodsId(String goodsId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct "
				+ " a.GOODS_ID, b.COMMISSION_RULE "
				+ " FROM cms_p_goods_rule a, cms_p_rule b"
				+ " WHERE a.GOODS_ID = '" + goodsId + "'"
				+ " AND a.RULE_ID = b.ID"
				);
		List<Map<String, Object>> ruleList = commonDao.queryForList(sb.toString());
		if(ruleList.size() > 0) {
			Map info = ruleList.get(0);
			return String.valueOf(info.get("COMMISSION_RULE"));
		}
		return "";
	}
	
}
