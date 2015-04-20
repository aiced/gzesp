package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;


@Controller
@RequestMapping("/shopManage")
public class WeShopCommissionDetailController {

	@Autowired
	private WeShopService weShopService;
	
	   @RequestMapping("/commissionDetail")
	    public ModelAndView index(){
	    	ModelAndView mav = new ModelAndView("commissionDetail.ftl");
	        //从数据库获取信息赋值
	        
	        mav.addObject("title", "收益查询");
	//	        mav.addObject("weixin", "1306520198@qq.com"); 
	        
	        return mav;
	    }
	}
