package com.ai.gzesp.dao.sql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

@Service
public class ViewSql {
	@Resource
	private CommonDao commonDao;
	
	//通过userid获得访问量
	//iflag 
	public List getViewCountByUserID(String strUserID)
	{
		StringBuffer sb=new StringBuffer();
//		select count(case when visit_time>=trunc(sysdate-1) and visit_time<trunc(sysdate) then 1 else null end), --昨日 
//	       count(case when visit_time>=trunc(sysdate, 'month') and visit_time<trunc(add_months(sysdate, 1), 'month') then 1 else null end), --本月 
//	       count(1) --本月 
//	  from AUR_D_VISIT_LOG a
//	 where store_id = 2015000000000000
		sb.append("select count(case when visit_time>=trunc(sysdate-1) and visit_time<trunc(sysdate) then 1 else null end) yesterday_view,");
		sb.append("count(case when visit_time>=trunc(sysdate, 'month') and visit_time<trunc(add_months(sysdate, 1), 'month') then 1 else null end) month_view,");
		sb.append("count(1) total_count ");
		sb.append(" from AUR_D_VISIT_LOG a ");
		sb.append("where user_id ="+strUserID);

		System.out.println(sb.toString());
		List viewList =commonDao.queryForList(sb.toString());

		return viewList;
	}
}
