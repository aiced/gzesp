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

    
    @RequestMapping("/ordersQuery")
    public ModelAndView index(@RequestParam(value = "userid", required = true)String strUserID,@RequestParam(value = "fromPage", required = true)String strfromPage){
    	
    	System.out.println(strUserID);
    	List<Map<String, Object>> orderList=ordersSql.getOrdersListbyUserID(strUserID);
    	
    	
        ModelAndView mav = new ModelAndView("ordersQuery.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "我的订单");
        mav.addObject("fromPage", strfromPage);
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
    @RequestMapping("/Back")
    @ResponseBody
    public ModelAndView GoBack(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strUserID=paramsMap.get("userid");
    	String strFromPage=paramsMap.get("fromPage");

        ModelAndView mav = new ModelAndView("weShopHome.ftl");

    	//这里从数据库查询数据
    	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("USER_ID", strUserID);
 
      	List<TdAurDAUTHINFO> list = tdAurDAUTHINFODao.selectByExample(myCriteria);
    	ModelMap mmap=null;
    	if(list.size() >= 1) 
    	{
    		//mav = new ModelAndView("weShopHome.ftl");
    		mmap=new ModelMap();
            //从数据库获取信息赋值
    		mmap.addAttribute("title", "我的微店");
    		mmap.addAttribute("id", list.get(0).getId());
    		mmap.addAttribute("userid",list.get(0).getUserId());
    		mmap.addAttribute("name", list.get(0).getUserName());//姓名
    		mmap.addAttribute("storename", list.get(0).getStoreName());//姓名
    		mmap.addAttribute("phone", list.get(0).getPhoneNumber()); //手机号
    		mmap.addAttribute("weixin", list.get(0).getWeixinId()); //微信
    		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);            
    	} 
    	
//    	if (strFromPage=="orderFill") 
//    	{
//			
//		}
    	
       	//List<Map<String, Object>> orderList=ordersSql.getOrdersList(strUserID,strOrderID,strStartDate,strEndDate);
    	
    	

        
        
        //mav.addObject("orderList",orderList);
        return mav;
    }
}
