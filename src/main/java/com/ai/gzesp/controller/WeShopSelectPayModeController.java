package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/order")
public class WeShopSelectPayModeController {
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/selectPayMode")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("selectPayMode.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "支付方式");
//        mav.addObject("name", "喻露露");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
//        
        return mav;
    }
}
