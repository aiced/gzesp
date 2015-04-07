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
	//通过日期获得佣金信息
	public List<Map<String,Object>> getCommListbyMonth(String strUserID,String startDate)
	{		
		strUserID="111";
		if (startDate==null) {
			startDate="";
		}
		
		StringBuffer sb=new StringBuffer();
		//select USER_ID,PARTITION_ID,ORDER_ID,CMS_MONTH,GOODS_ID,GOODS_NAME,CMS_SUM_MONEY,CMS_MONEY,CMS_MONTH, to_char(trunc(sysdate), 'yyyymm'),to_char(last_day(sysdate), 'yyyymm')
		//from CMS_D_MONTH
		//where user_id='111'and CMS_MONTH == to_char(trunc(sysdate), 'yyyymm') and CMS_MONTH <= to_char(last_day(sysdate), 'yyyymm')
		sb.append("select USER_ID,PARTITION_ID,ORDER_ID,CMS_MONTH,GOODS_ID,GOODS_NAME,CMS_SUM_MONEY,CMS_MONEY,CMS_MONTH ");
		sb.append("from CMS_D_MONTH ");
		sb.append("where USER_ID='"+strUserID+"'");
		if (startDate != "") {
			sb.append(" and CMS_MONTH = to_char(to_date('"+startDate+"','yyyymmdd'),'yyyymm')");
		}
		else {
			sb.append(" and CMS_MONTH = to_char(sysdate,'yyyymm')");
		}

		
		System.out.println(sb.toString());
		List<Map<String, Object>> CommList =commonDao.queryForList(sb.toString());

		return CommList;
	}
	
	
	
}
