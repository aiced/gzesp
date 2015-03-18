/**
 * @author wenhui
 * 查询订单相关操作
 * 
 */
package com.ai.gzesp.dao.sql;

import java.util.List;

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
	//获取商品列表
	public List getOrdersListbyUserID(String strUserID)
	{
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select "
				+"ORD_D_DEAL.ORDER_ID,"
				+"ORD_D_PROD.GOODS_NAME,"
				+"ORD_D_BASE.INCOME_MONEY,"
				+"ORD_D_BASE.Order_Time,"
				+"ORD_D_POST.RECEIVER_NAME,"
				+"ORD_D_POST.POST_ADDR,"
				+"ORD_D_POST.MOBILE_PHONE,"
				+"ORD_D_POST.DELIVER_TIME_CODE,"
				+"ORD_D_PAYLOG.PAY_MODE,"
				+"ORD_D_PAYLOG.PAY_STATE,"
				+"ORD_D_PAYLOG.PAY_REMARK"
				+" "
				);
		sb.append("from ORD_D_DEAL,ORD_D_BASE,ORD_D_PROD,ORD_D_PAYLOG,ORD_D_POST");
		sb.append(" where ORD_D_DEAL.ORDER_ID=ORD_D_BASE.Order_Id "
				+" and ORD_D_BASE.Order_Id=ORD_D_PROD.Order_Id"
				+" and ORD_D_PROD.Order_Id=ORD_D_POST.Order_Id"
				+" and ORD_D_POST.Order_Id=ORD_D_PAYLOG.Order_Id"	
				+" and ORD_D_DEAL.USER_ID="+strUserID
				+" order by ORD_D_BASE.Order_Time DESC"
				);
		System.out.println(sb.toString());
		List orderList =commonDao.queryForList(sb.toString());

		return orderList;
		
	}
}
