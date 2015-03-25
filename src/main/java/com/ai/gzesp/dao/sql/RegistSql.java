package com.ai.gzesp.dao.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.service.CommonDao;

@Service
public class RegistSql {
	@Resource
	private CommonDao commonDao;
	
	//获得省份
	public List<Map<String, Object>> getCityList(String strProvince_code)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("select city_code, city_name, province_code from sys_p_city where province_code="+strProvince_code+" order by order_number");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> cityList =commonDao.queryForList(sb.toString());

		return cityList;
	}
	//获得银行
	public List<Map<String, Object>> getBankList(String strParam_type)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("select Param_code,param_value from SYS_D_ESPPARAM where Param_type='" + strParam_type+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> bankList =commonDao.queryForList(sb.toString());

		return bankList;
	}
}
