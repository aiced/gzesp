package com.ai.gzesp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("")
public class AA {

	@RequestMapping("test/acct/acctBalance/{user_id}")
	public ModelAndView acctBalance(@PathVariable("user_id") String user_id,
			@RequestBody String inputParam) {
		String type = "1";
		String monthKey = null;
		String pageNum = "1";
		String pageSize = "20";

		List<Map<String, Object>> costList = new ArrayList<Map<String, Object>>();
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		if (paramsMap.get("type") != null) {
			type = paramsMap.get("type");
		}
		if (paramsMap.get("monthKey") != null) {
			monthKey = paramsMap.get("monthKey");
		}
		if (paramsMap.get("pageNum") != null) {
			pageNum = paramsMap.get("pageNum");
		}
		if (paramsMap.get("pageSize") != null) {
			pageSize = paramsMap.get("pageSize");
		}

		// type : //订单类型 0 , 1 ,2 (收入，支出，提现)，默认为0；
		// monthKey: 按月份查询，默认所有数据
		// pageNum: 页数，默认第一页
		// pageSize: 每页返回条目数量

		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("TRADE_TYPE", "代客下单1");
		item1.put("UPDATE_TIME", "2015 －04 －17");
		item1.put("ORDER_ID", "1234568363738883874478747");
		item1.put("FEE", "501");
		item1.put("AUDIT_STATE", "审核中");

		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put("TRADE_TYPE", "代客下单2");
		item2.put("ORDER_ID", "1234568363738883874478747");
		item2.put("UPDATE_TIME", "2015 －04 －18");
		item2.put("FEE", "502");
		item2.put("AUDIT_STATE", "审核未通过");

		Map<String, Object> item3 = new HashMap<String, Object>();
		item3.put("TRADE_TYPE", "代客下单3");
		item3.put("ORDER_ID", "1234568363738883874478747");
		item3.put("UPDATE_TIME", "2015 －04 －19");
		item3.put("FEE", "503");
		item3.put("AUDIT_STATE", "审核已通过");

		Map<String, Object> item4 = new HashMap<String, Object>();
		item4.put("TRADE_TYPE", "代客下单4");
		item4.put("ORDER_ID", "1234568363738883874478747");
		item4.put("UPDATE_TIME", "2015 －04 －20");
		item4.put("FEE", "504");
		item4.put("AUDIT_STATE", "已打款");

		Map<String, Object> item5 = new HashMap<String, Object>();
		item5.put("TRADE_TYPE", "代客下单4");
		item5.put("ORDER_ID", "1234568363738883874478747");
		item5.put("UPDATE_TIME", "2015 －04 －20");
		item5.put("FEE", "504");
		item5.put("AUDIT_STATE", "已打款");
		Map<String, Object> item6 = new HashMap<String, Object>();
		item6.put("TRADE_TYPE", "代客下单4");
		item6.put("ORDER_ID", "1234568363738883874478747");
		item6.put("UPDATE_TIME", "2015 －04 －20");
		item6.put("FEE", "504");
		item6.put("AUDIT_STATE", "已打款");
		Map<String, Object> item7 = new HashMap<String, Object>();
		item7.put("TRADE_TYPE", "代客下单4");
//		item7.put("orderNum", "1234568363738883874478747");
		item7.put("UPDATE_TIME", "2015 －04 －20");
		item7.put("FEE", "504");
		item7.put("AUDIT_STATE", "已打款");
		Map<String, Object> item8 = new HashMap<String, Object>();
		item8.put("TRADE_TYPE", "代客下单4");
//		item8.put("orderNum", "1234568363738883874478747");
		item8.put("UPDATE_TIME", "2015 －04 －20");
		item8.put("FEE", "504");
		item8.put("AUDIT_STATE", "已打款");
		Map<String, Object> item9 = new HashMap<String, Object>();
		item9.put("TRADE_TYPE", "代客下单4");
		item9.put("UPDATE_TIME", "2015 －04 －20");
		item9.put("ORDER_ID", "1234568363738883874478747");
		item9.put("FEE", "504");
		item9.put("AUDIT_STATE", "已打款");

		costList.add(item1);
		costList.add(item2);
		costList.add(item3);
		costList.add(item4);
		costList.add(item5);
		costList.add(item6);
		costList.add(item7);
		costList.add(item8);
		costList.add(item9);

		// ModelAndView mav = new ModelAndView("acctBalance.ftl");
		// mav.addObject("sumNumObj", sumNum);
		// mav.addObject("title", "标题");
		// mav.addObject("costList", costList);
		// return mav;

		// 读取月 json 数据

		URL path = this.getClass().getClassLoader().getResource("month.json");
		if (path != null) {
			System.out.println(path.getFile());
			System.out.println("######################################");
			System.out.println("######################################");
			System.out.println("######################################");
			System.out.println("######################################");
		}
		List<String> monthList = readMonthFile();

		Map<String, Object> rspMap = new HashMap<String, Object>();
		rspMap.put("sumTitle", "总收入:");
		rspMap.put("sumNum", "10000");
		rspMap.put("sumTitle", "总收入:");
		rspMap.put("title", "标题1");
		rspMap.put("acctloglist", costList);
		rspMap.put("monthList", monthList);
		
		
		// 点击tab，点击搜索，加载更多查询
		if (inputParam.length() != 0) {
			return new ModelAndView("acctBalanceSub.ftl", rspMap);
		}
		// 首次进入查询
		return new ModelAndView("acctBalance.ftl", rspMap);

	}

	public static List<String> readMonthFile() {  	    
    	List<String> monthList = Arrays.asList(
    		"2015-06",
			"2015-07",
			"2015-08",
			"2015-09",
			"2015-10",
			"2015-11",
			"2015-12",
			"2016-01",
			"2016-02",
			"2016-03",
			"2016-04",
			"2016-05",
			"2016-06",
			"2016-07",
			"2016-08",
			"2016-09",
			"2016-10",
			"2016-11",
			"2016-12",
			"2017-01",
			"2017-02",
			"2017-03",
			"2017-04",
			"2017-05",
			"2017-06",
			"2017-07",
			"2017-08",
			"2017-09",
			"2017-10",
			"2017-11",
			"2017-12",
			"2018-01",
			"2018-02",
			"2018-03",
			"2018-04",
			"2018-05",
			"2018-06",
			"2018-07",
			"2018-08",
			"2018-09",
			"2018-10",
			"2018-11",
			"2018-12",
			"2019-01",
			"2019-02",
			"2019-03",
			"2019-04",
			"2019-05",
			"2019-06",
			"2019-07",
			"2019-08",
			"2019-09",
			"2019-10",
			"2019-11",
			"2019-12"		);
    	
			
		return monthList;	    
    }}
