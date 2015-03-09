package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;


@Controller
@RequestMapping("/auth")
public class WeShopRegist2Controller {

    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/register/step2")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopRegist2.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "注册微店");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        return mav;
    }
}
