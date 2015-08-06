package com.ai.gzesp.dao.sql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

@Service
public class RefundSql {
	@Resource
	private CommonDao commonDao;
	//通过orderid获得退款金额
	public List getOrderInfoByOrderID(String strOrderID)
	{
		//select t2.Order_Id,t2.Partition_Id,t2.order_no,t2.create_time,t2.order_from,t2.order_time,t1.unit_price,t2.order_state from ORD_D_PROD t1,ORD_D_BASE t2 where t1.ORDER_ID=t2.ORDER_ID

		StringBuffer sb=new StringBuffer();
		
		sb.append("select t2.Order_Id,t2.Partition_Id,t2.order_no,t2.create_time,t2.order_from,t2.order_time,t1.unit_price,t2.order_state from ORD_D_PROD t1,ORD_D_BASE t2 where t1.ORDER_ID=t2.ORDER_ID");
		sb.append(" and t2.Order_Id='"+strOrderID+"'");
		
		System.out.println(sb.toString());
		List reFundList =commonDao.queryForList(sb.toString());

		return reFundList;

	}
	public int InsertRefundInfo()
	{
		return 0;
	}
}
