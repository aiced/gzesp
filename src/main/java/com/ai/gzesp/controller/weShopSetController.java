package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/shopManage")
public class WeShopSetController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/weShopSet")
    public ModelAndView weShopSet(){
        ModelAndView mav = new ModelAndView("weShopSet.ftl");
        //从数据库获取信息赋值
        mav.addObject("name", "喻露露");
        mav.addObject("phone", "18685292522"); 
        mav.addObject("weixin", "1306520198@qq.com"); 
        return mav;
    }
    
    
//   二维码界面。
    @RequestMapping("/weShopSet/weShopSetQrcode")
    public ModelAndView weShopSetQrcode(){
        //返回数据表格子页面
        ModelAndView mav = new ModelAndView("weShopSetQrcode.ftl"); 
        
        return mav;
    }
}
