package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/weShop")
public class WeShopController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopIndex.ftl");
        //从数据库获取信息赋值
        mav.addObject("name", "奚敏辉");
        mav.addObject("phone", "18612345678"); 
        mav.addObject("weixin", "ximinhui12345"); 
        return mav;
    }

}
