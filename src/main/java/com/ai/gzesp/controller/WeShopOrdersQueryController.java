package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;







import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/shopManage")
public class WeShopOrdersQueryController {

    @Autowired
    private WeShopService weShopService;
	@Resource 
	OrdersSql ordersSql;
	@Resource
	TdAurDAUTHINFODao tdAurDAUTHINFODao;
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/ordersQuery")
    public ModelAndView index(@RequestParam(value = "userid", required = true)String strUserID,@RequestParam(value = "fromPage", required = true)String strfromPage){
    	
    	System.out.println(strUserID);
    	List<Map<String, Object>> orderList=ordersSql.getOrdersListbyUserID(strUserID);
    	
    	
        ModelAndView mav = new ModelAndView("ordersQueryTab.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "我的订单");
        mav.addObject("fromPage", strfromPage);
        mav.addObject("hideuserid",strUserID);
        mav.addObject("orderList", orderList);
   
        
       	List<Map<String, Object>> czcardlist=orderService.queryCZCard("", "", strUserID, "", 1);
       	if (czcardlist!=null && czcardlist.size()>0) {
    	    mav.addObject("czcardlist",czcardlist);
            
		}

        return mav;
    }
    
    
    @RequestMapping("/selectOrders_Page")
    @ResponseBody
    public ModelAndView queryOrders_Page(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strStartDate=paramsMap.get("startDate");
    	String strEndDate=paramsMap.get("endDate");
    	String strOrderID=paramsMap.get("orderID");
    	String strUserID=paramsMap.get("userID");
    	String strHidePageIndex=paramsMap.get("hidepageindex");
    	
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strOrderID);
    	System.out.println(strUserID);
    	System.out.println(strHidePageIndex);
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> orderList=ordersSql.getOrdersList(strUserID,strOrderID,strStartDate,strEndDate,Integer.valueOf(strHidePageIndex));
    	
        ModelAndView mav = new ModelAndView("ordersQuerySub.ftl");
        
        mav.addObject("orderList",orderList);
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
    	String strHidePageIndex=paramsMap.get("hidepageindex");
    	
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strOrderID);
    	System.out.println(strUserID);
    	System.out.println(strHidePageIndex);	
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> orderList=ordersSql.getOrdersList(strUserID,strOrderID,strStartDate,strEndDate,Integer.valueOf(strHidePageIndex));
    	
    	
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
    @RequestMapping("/Back")
    @ResponseBody
    public ModelAndView GoBack(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strUserID=paramsMap.get("userid");
    	String strFromPage=paramsMap.get("fromPage");

        ModelAndView mav = null;
    	ModelMap mmap=new ModelMap();
        //mmap.addAttribute("title", "我的微店");
		mmap.addAttribute("userid",strUserID);
		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);     
        return mav;
    }
    
    @RequestMapping("/selectCZCard")
    public ModelAndView queryCZCard(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String startDate=paramsMap.get("startDate");
    	String endDate=paramsMap.get("endDate");
    	String czcard_no=paramsMap.get("cardnocz");
    	String user_id=paramsMap.get("userID");
    	int hidepageindex=Integer.valueOf(paramsMap.get("hidepageindex"));
    	
    	System.out.println(startDate);
    	System.out.println(endDate);
    	System.out.println(czcard_no);
    	System.out.println(user_id);
    	System.out.println(hidepageindex);
    	    	
        ModelAndView mav = new ModelAndView("ordersQueryCardPaySub.ftl");

        
       	List<Map<String, Object>> czcardlist=orderService.queryCZCard(startDate, endDate, user_id, czcard_no, hidepageindex);

	    mav.addObject("czcardlist",czcardlist);
	    System.out.println(czcardlist);
	    
	    return mav;    	
    }
}
