package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/customer")
public class WeShopCustOrderDetailQueryController {
	
    @Autowired
    private WeShopService weShopService;
	   @RequestMapping("/custOrderDetailQuery")
	    public ModelAndView index(){
	    	ModelAndView mav = new ModelAndView("custOrderDetailQuery.ftl");
	        //从数据库获取信息赋值
	        
	        mav.addObject("title", "订单详情");
	//	        mav.addObject("weixin", "1306520198@qq.com"); 
	        
	        return mav;
	    }
}
