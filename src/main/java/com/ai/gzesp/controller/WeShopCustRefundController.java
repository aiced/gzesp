package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/customer")
public class WeShopCustRefundController {

    @Autowired
    private WeShopService weShopService;
	
	   @RequestMapping("/custRefund")
	    public ModelAndView index(){
	    	ModelAndView mav = new ModelAndView("custRefund.ftl");
	        //从数据库获取信息赋值
	        
	        mav.addObject("title", "申请退款");
	//	        mav.addObject("weixin", "1306520198@qq.com"); 
	        
	        return mav;
	    }
}
