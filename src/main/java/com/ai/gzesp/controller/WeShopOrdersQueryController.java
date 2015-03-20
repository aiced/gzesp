package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/shopManage")
public class WeShopOrdersQueryController {

    @Autowired
    private WeShopService weShopService;
	@Resource 
	OrdersSql ordersSql;
	

    
    @RequestMapping("/ordersQuery")
    public ModelAndView index(@RequestParam(value = "userid", required = true)String strUserID){
    	
    	System.out.println(strUserID);
    	List<Map<String, Object>> orderList=ordersSql.getOrdersListbyUserID(strUserID);
    	
    	
        ModelAndView mav = new ModelAndView("ordersQuery.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "我的订单");
        mav.addObject("hideuserid",strUserID);
        mav.addObject("orderList", orderList);
   
        return mav;
    }
    @RequestMapping("/selectOrders")
    @ResponseBody
    public ModelAndView queryOrdersByDate(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strStartDate=paramsMap.get("startDate");
    	String strEndDate=paramsMap.get("endDate");
    	String strOrderID=paramsMap.get("orderID");
    	String strUserID=paramsMap.get("userID");
    	
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strOrderID);
    	System.out.println(strUserID);
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> orderList=ordersSql.getOrdersList(strUserID,strOrderID,strStartDate,strEndDate);
    	
    	
        ModelAndView mav = new ModelAndView("ordersQuerySub.ftl");
        
        
        
//        //数据库分页获取号码列表 默认第一页
//        ArrayList<HashMap<String, String>> ordersInfo = new ArrayList<HashMap<String, String>>();
//        HashMap<String, String> order_one = new HashMap<String, String>();
//        order_one.put("number", "13851885061");
//        order_one.put("fee", "0");
//        HashMap<String, String> order_two = new HashMap<String, String>();
//        order_two.put("number", "13851885062");
//        order_two.put("fee", "0");
//        HashMap<String, String> order_three = new HashMap<String, String>();
//        order_three.put("number", "13851885063");
//        order_three.put("fee", "100");
//        ordersInfo.add(order_one);
//        ordersInfo.add(order_two);
//        ordersInfo.add(order_three);
//        mav.addObject("ordersInfo", ordersInfo);
        
        mav.addObject("orderList",orderList);
        return mav;
    }
    
}
