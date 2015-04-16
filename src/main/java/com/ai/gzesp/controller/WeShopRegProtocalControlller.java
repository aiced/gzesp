package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/auth")
public class WeShopRegProtocalControlller {
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/register/regProtocol")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopRegProtocal.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "用户注册协议");


        
        return mav;
    }
}
