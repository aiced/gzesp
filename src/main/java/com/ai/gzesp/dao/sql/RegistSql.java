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
		
		sb.append("select ess_city_code city_code, city_name, ess_province_code province_code from SYS_P_WEB_CITY where ess_province_code="+strProvince_code+" order by order_number");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> cityList =commonDao.queryForList(sb.toString());

		return cityList;
	}
	//获得银行列表
	public List<Map<String, Object>> getBankList(String strParam_type)
	{
		StringBuffer sb=new StringBuffer();
		
		sb.append("select Param_code,param_value from SYS_D_ESPPARAM where Param_type='" + strParam_type+"'");
		
		System.out.println(sb.toString());
		List<Map<String, Object>> bankList =commonDao.queryForList(sb.toString());

		return bankList;
	}
	//通过openid来判断该账号是否注册过
	public int IsRegByOpenId(String strOpenId)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) count from AUR_D_AUTHINFO where WXOPEN_ID='"+strOpenId+"'");
		System.out.println(sb.toString());
		Map<String, Object> map =commonDao.queryForMap(sb.toString());
		if (map!=null) {
			return Integer.valueOf(map.get("count").toString());
		}
		return 0;
	}

}
