package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderMainController {

    @Autowired
    private OrderService orderService;
    

    @RequestMapping("/orderMain")
    public ModelAndView selectNumber(){
        ModelAndView mav = new ModelAndView("orderMain.ftl");
        //从数据库获取信息赋值
        //广告轮播图片的url
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");
        mav.addObject("banners", banners);
        
        return mav;
    }
}
