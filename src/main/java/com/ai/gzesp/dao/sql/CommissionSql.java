package com.ai.gzesp.dao.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;
import com.ai.sysframe.utils.DateUtil;

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
	
	
	//根据各种条件查询佣金;这个地方写渣了，就按照现在的来吧。
	public List<Map<String,Object>> getCommListbySelectGroup(String strFlag,String strUserID,String strzhangqiTime,String strStartDate,String strEndDate,String strStatusflag,int strHidePageIndex)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("with T1 as");
		sb.append("(select a.order_id, a.cms_type, a.cms_money cms_money from cms_d_daily a union all select b.order_id, b.cms_type, b.cms_pre_fee cms_money from ord_d_precmsfee b where not exists (select 1 from cms_d_daily c where c.order_id = b.order_id))");
		sb.append("select * from ( select tt.*,ROWNUM as rowno from (");
		sb.append("select T1.order_id,"
				+ " a.create_time,"
				+ " c.goods_id,"
				+ " c.goods_name,"
				+ " nvl(T1.cms_money, 0) cms_money,"
				+ " d.receiver_name,"
				+ " b.user_id,"
				+ " T1.cms_type,"
				+ " e.cms_state"
				+ " from T1,"
				+ " ord_d_base a,"
				+ " ord_d_deal b,"
				+ " ord_d_prod c,"
				+ " ord_d_post d,"
				+ " ord_d_cmsstate e"
				+ " where T1.order_id = a.order_id"
				+ " and a.order_id = b.order_id"
				+ " and a.order_id = c.order_id"
				+ " and a.order_id = d.order_id"
				+ " and a.order_id = e.order_id"
				+ " and b.user_id = "+strUserID
				+ " and a.order_state != '99'"
				);
		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
		{
		
		}
		else if(strFlag.equals("2"))//按照订单时间查询
		{
			sb.append(" and a.create_time >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.create_time < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
		}
		else //刚一进来，默认是当月的时间 
		{
			sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
		}
		if (strStatusflag.equals("00")) //未激活
		{
			sb.append(" and e.cms_state='00'");
		}
		else if(strStatusflag.equals("01"))//结算中
		{
			sb.append(" and e.cms_state='01'");
		}
		else if(strStatusflag.equals("02"))//已到帐
		{
			sb.append(" and e.cms_state='02'");
		}
		else if(strStatusflag.equals("03"))//已退货
		{
			sb.append(" and e.cms_state='03'");
		}
		else if(strStatusflag.equals("04"))//已失效
		{
			sb.append(" and e.cms_state='04'");
		}
		else //strStatusflag=-1 什么都不操作
		{
			
		}
		sb.append(" order by a.create_time desc");
		sb.append(" ) tt  where Rownum <="+(strHidePageIndex)+") table_alias where table_alias.rowno >="+1);
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;

//		sb.append("with T1 as");
//		sb.append("(select a.Order_Id, b.CMS_DAY, b.CMS_TYPE as CMS_TYPE_DAILLY,sum(CMS_MONEY) as SUM_CMS_MONEY"
//				+ " from ORD_D_BASE a, CMS_D_DAILY b"
//				+ " where a.Order_Id = b.Order_Id(+)"
//				+ " group by a.order_id, b.CMS_DAY,b.CMS_TYPE),");
//		sb.append("T2 as (");
//		//sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE, 0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a, ORD_D_PROD b, ORD_D_POST c, ORD_D_DEAL d where a.Order_id = b.Order_id and b.Order_Id = c.Order_Id and a.order_id = d.order_id");
//		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state !='99'");
//
//		}
//		else if (strFlag.equals("2")) //按照订单时间查询
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state !='99'");			
//			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
//			//sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
//		}
//		else //刚一进来，默认是当月的时间 
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state !='99'");
//			//sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')+1");
//			sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
//		}
//		sb.append("),");
//		sb.append("T3 as (select T2.ORDER_ID,T2.CREATE_TIME,T2.GOODS_ID,T2.GOODS_NAME,T2.CMS_PRE_FEE,T2.RECEIVER_NAME,T2.USER_ID,T1.CMS_DAY,T1.SUM_CMS_MONEY,T2.CMS_TYPE,T1.CMS_TYPE_DAILLY");
//		sb.append(" from T1 full outer join T2");
//		sb.append(" on T1.order_id = T2.order_id),");
//		sb.append("T4 as (select CMS_STATE,ORDER_ID from ORD_D_CMSSTATE)");
//		
//		sb.append("select * from ("
//				+ "select tt.*,ROWNUM as rowno from (");
//		sb.append("select T3.ORDER_ID,T3.CREATE_TIME,T3.GOODS_ID,T3.GOODS_NAME,T3.CMS_PRE_FEE,T3.RECEIVER_NAME,T3.USER_ID,T3.CMS_DAY,T3.SUM_CMS_MONEY,T4.CMS_STATE,T3.CMS_TYPE,T3.CMS_TYPE_DAILLY from T3,T4 where T3.order_id=T4.order_id and T3.USER_ID ='"+strUserID+"'");
////		00：未激活
////		01：结算中
////		02：已到帐
////		03：已退货
////		04：已失效';
//		if (strStatusflag.equals("00")) //未激活
//		{
//			sb.append(" and CMS_STATE='00'");
//		}
//		else if(strStatusflag.equals("01"))//结算中
//		{
//			sb.append(" and CMS_STATE='01'");
//		}
//		else if(strStatusflag.equals("02"))//已到帐
//		{
//			sb.append(" and CMS_STATE='02'");
//		}
//		else if(strStatusflag.equals("03"))//已退货
//		{
//			sb.append(" and CMS_STATE='03'");
//		}
//		else if(strStatusflag.equals("04"))//已失效
//		{
//			sb.append(" and CMS_STATE='04'");
//		}
//		else //strStatusflag=-1 什么都不操作
//		{
//			
//		}
//		sb.append(" order by CREATE_TIME desc");
//		sb.append(" ) tt");
//		sb.append(" where Rownum <="+(strHidePageIndex)+") table_alias");
//		sb.append("	where table_alias.rowno >="+1);


	}
	
	
	
	//根据各种条件查询佣金总额total
	public String  getCommTotalbySelectGroup(String strFlag,String strUserID,String strzhangqiTime,String strStartDate,String strEndDate,String strStatusflag,int strHidePageIndex)
	{
		
		StringBuffer sb=new StringBuffer();
		sb.append("with T1 as");
		sb.append("(select a.order_id, a.cms_type, a.cms_money cms_money from cms_d_daily a union all select b.order_id, b.cms_type, b.cms_pre_fee cms_money from ord_d_precmsfee b where not exists (select 1 from cms_d_daily c where c.order_id = b.order_id)),");
		sb.append("T2 as (");
		sb.append("select T1.order_id,"
				+ " a.create_time,"
				+ " c.goods_id,"
				+ " c.goods_name,"
				+ " nvl(T1.cms_money, 0) cms_money,"
				+ " d.receiver_name,"
				+ " b.user_id,"
				+ " T1.cms_type,"
				+ " e.cms_state"
				+ " from T1,"
				+ " ord_d_base a,"
				+ " ord_d_deal b,"
				+ " ord_d_prod c,"
				+ " ord_d_post d,"
				+ " ord_d_cmsstate e"
				+ " where T1.order_id = a.order_id"
				+ " and a.order_id = b.order_id"
				+ " and a.order_id = c.order_id"
				+ " and a.order_id = d.order_id"
				+ " and a.order_id = e.order_id"
				+ " and b.user_id = "+strUserID
				+ " and a.order_state not in('00','11','12','13','14','99')"
				);
		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
		{
		
		}
		else if(strFlag.equals("2"))//按照订单时间查询
		{
			sb.append(" and a.create_time >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.create_time < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
		}
		else //刚一进来，默认是当月的时间 
		{
			sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
		}
		if (strStatusflag.equals("00")) //未激活
		{
			sb.append(" and e.cms_state='00'");
		}
		else if(strStatusflag.equals("01"))//结算中
		{
			sb.append(" and e.cms_state='01'");
		}
		else if(strStatusflag.equals("02"))//已到帐
		{
			sb.append(" and e.cms_state='02'");
		}
		else if(strStatusflag.equals("03"))//已退货
		{
			sb.append(" and e.cms_state='03'");
		}
		else if(strStatusflag.equals("04"))//已失效
		{
			sb.append(" and e.cms_state='04'");
		}
		else //strStatusflag=-1 什么都不操作
		{
			
		}
		sb.append(" order by a.create_time desc");
		sb.append(")");
		sb.append("select nvl(sum(cms_money),0) TotalMoney from T2");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());
		
		return CommList.get(0).get("TotalMoney").toString();
		
//		sb.append("with T1 as");
//		sb.append("(select a.Order_Id, b.CMS_DAY, b.CMS_TYPE as CMS_TYPE_DAILLY,sum(CMS_MONEY) as SUM_CMS_MONEY"
//				+ " from ORD_D_BASE a, CMS_D_DAILY b"
//				+ " where a.Order_Id = b.Order_Id(+)"
//				+ " group by a.order_id, b.CMS_DAY,b.CMS_TYPE),");
//		sb.append("T2 as (");
//		//sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(b.CMS_PRE_FEE, 0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id from ORD_D_BASE a, ORD_D_PROD b, ORD_D_POST c, ORD_D_DEAL d where a.Order_id = b.Order_id and b.Order_Id = c.Order_Id and a.order_id = d.order_id");
//		if (strFlag.equals("1")) //按照帐期查询，暂时先这样写着
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state not in('00','11','12','13','14','99')");
//
//		}
//		else if (strFlag.equals("2")) //按照订单时间查询
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state not in('00','11','12','13','14','99')");			
//			sb.append(" and a.CREATE_TIME >=to_date('"+strStartDate+"','yyyy-mm-dd') and a.CREATE_TIME < to_date('"+strEndDate+"','yyyy-mm-dd')+1");
//			//sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
//		}
//		else //刚一进来，默认是当月的时间 
//		{
//			sb.append("select a.ORDER_ID,a.CREATE_TIME,b.Goods_Id,b.goods_name,nvl(e.CMS_PRE_FEE,0) CMS_PRE_FEE,c.RECEIVER_NAME,d.User_Id, e.CMS_TYPE from ORD_D_BASE a,ORD_D_PROD b,ORD_D_POST c,ORD_D_DEAL d,ORD_D_PRECMSFEE e where a.Order_id=b.Order_id and b.Order_Id=c.Order_Id and a.order_id=d.order_id and a.order_id = e.order_id and a.order_state not in('00','11','12','13','14','99')");
//			//sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')+1");
//			sb.append(" and a.create_time >= trunc(sysdate, 'month') and a.create_time < trunc(add_months(sysdate, 1), 'month')");
//		}
//		sb.append("),");
//		sb.append("T3 as (select T2.ORDER_ID,T2.CREATE_TIME,T2.GOODS_ID,T2.GOODS_NAME,T2.CMS_PRE_FEE,T2.RECEIVER_NAME,T2.USER_ID,T1.CMS_DAY,T1.SUM_CMS_MONEY,T2.CMS_TYPE,T1.CMS_TYPE_DAILLY");
//		sb.append(" from T1, T2");
//		sb.append(" where T1.order_id(+) = T2.order_id and T1.CMS_TYPE_DAILLY(+)= T2.CMS_TYPE and T2.USER_ID ='"+strUserID+"'),");
//		sb.append("T4 as (select CMS_STATE,ORDER_ID from ORD_D_CMSSTATE)");
//		sb.append("select nvl(sum(case when SUM_CMS_MONEY is null then CMS_PRE_FEE else SUM_CMS_MONEY end),0) TotalMoney from T3, T4 where T3.order_id = T4.order_id(+)");
//			

	}
	
	
	
	public String getCmsRuleByGoodsId(String goodsId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct "
				+ " a.GOODS_ID, b.COMMISSION_RULE "
				+ " FROM cms_p_goods_rule a, cms_p_rule b"
				+ " WHERE a.GOODS_ID = '" + goodsId + "'"
				+ " AND a.RULE_ID = b.ID"
				+ " AND b.STATUS = '1'"
				+ " AND b.CMS_TYPE = '0'"
				);
		List<Map<String, Object>> ruleList = commonDao.queryForList(sb.toString());
		if(ruleList.size() > 0) {
			Map info = ruleList.get(0);
			return String.valueOf(info.get("COMMISSION_RULE"));
		}
		return "";
	}
	
	public String getRewardRuleByGoodsId(String goodsId, String rewardKeyWord) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct "
				+ " a.GOODS_ID, b.COMMISSION_RULE "
				+ " FROM cms_p_goods_rule a, cms_p_rule b"
				+ " WHERE a.GOODS_ID = '" + goodsId + "'"
				+ " AND a.RULE_ID = b.ID"
				+ " AND b.STATUS = '1'"
				+ " AND b.CMS_TYPE = '1'"
//				+ " and sysdate >= a.BEGIN_DATE "
//				+ "	and sysdate <= a.END_DATE "
				+ " and TO_DATE("+ DateUtil.getNowyyyyMMdd()+ ", 'yyyymmdd') >= a.BEGIN_DATE "
				+ "	and TO_DATE("+ DateUtil.getNowyyyyMMdd()+ ", 'yyyymmdd') <= a.END_DATE "
//				+ " AND b.COMMISSION_RULE like '%"+rewardKeyWord+"%'"
//				sb.append(" and a.CREATE_TIME >=to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') and a.CREATE_TIME < to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd')+1");
				);
		List<Map<String, Object>> ruleList = commonDao.queryForList(sb.toString());
		if(ruleList.size() > 0) {
			Map info = ruleList.get(0);
			return String.valueOf(info.get("COMMISSION_RULE"));
		}
		return "";
	}
	
	public int getUserOrdNum(String goodsId, String userId) {
		StringBuffer sb = new StringBuffer();
		sb.append("	select count(1) NUM from " 
			+ " CMS_P_GOODS_RULE a  "
	    	+ " inner join CMS_P_RULE b on a.RULE_ID = b.ID AND b.STATUS = '1'    	AND b.CMS_TYPE = '1'  and b.COMMISSION_RULE like '%SINGLE%' "
	    	+ " inner join 	ORD_D_PRECMSFEE c on a.GOODS_ID = c.GOODS_ID and c.CMS_TYPE='1' "
	    	+ " inner join  ORD_D_DEAL d on c.ORDER_ID = d.ORDER_ID and d.USER_ID = '"+ userId +"' "
	    	+ " inner join  ORD_D_BASE e on c.ORDER_ID = e.ORDER_ID "
	    	+ " where a.GOODS_ID = '"+ goodsId +"' "
	    	+ " and TO_DATE("+ DateUtil.getNowyyyyMMdd()+ ", 'yyyymmdd') >= a.BEGIN_DATE "
			+ "	and TO_DATE("+ DateUtil.getNowyyyyMMdd()+ ", 'yyyymmdd') <= a.END_DATE "
    	);
    	Map<String, Object> map = commonDao.queryForMap(sb.toString());
		return Integer.parseInt(String.valueOf(map.get("NUM")));
	}
	
}
