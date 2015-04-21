package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.WeShopService;

/**
 * 一级功能：wap端<br> 
 * 二级功能：店铺主页
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/customer")
public class CustController {
    
	@Resource
    private OrderService orderService;
    
    
    @RequestMapping("/custOrderQuery")
    public ModelAndView custOrderQuery(){
        ModelAndView mav = new ModelAndView("custOrderQuery.ftl");
        mav.addObject("title", "我的订单");
        return mav;
    }
    
    @RequestMapping("/custMyOrder/{cust_phone}/{cust_passport}")
    public ModelAndView custMyOrder(@PathVariable("cust_phone") String cust_phone,
    		@PathVariable("cust_passport") String cust_passport){
    	List custMyOrderList = orderService.getCustMyOrder(cust_passport, cust_phone, null);
    	
    	ModelAndView mav = new ModelAndView("custMyOrder.ftl");
    	mav.addObject("custMyOrderList", custMyOrderList);
    	mav.addObject("cust_phone", cust_phone);
    	mav.addObject("cust_passport", cust_passport);
    	
    	return mav;
    }
    
    
	   @RequestMapping("/custOrderFilterByAjax")
	   public ModelAndView custOrderFilterByAjax(@RequestBody Map<String, String> inputParams){
		   String cust_passport = inputParams.get("cust_passport");
		   String cust_phone = inputParams.get("cust_phone");
		   String keyword = inputParams.get("keyword");
		   List custMyOrderList = orderService.getCustMyOrder(cust_passport, cust_phone, keyword);
	    	
	    	ModelAndView mav = new ModelAndView("custMyOrderSub.ftl");
	    	mav.addObject("custMyOrderList", custMyOrderList);
		   
		   return mav;
	   }
    
	   @RequestMapping("/custOrderDetail/{orderId}")
	    public ModelAndView custOrderDetail(@PathVariable("orderId") String orderId){
	    	ModelAndView mav = new ModelAndView("custOrderDetailQuery.ftl");
	        //从数据库获取信息赋值
	    	
	    	Map custOrderDetail = orderService.getCustOrderDetail(orderId);
	        
	        mav.addObject("title", "订单详情");
	        mav.addAllObjects(custOrderDetail);
	//	        mav.addObject("weixin", "1306520198@qq.com"); 
	        
	        return mav;
	    }
	   
}