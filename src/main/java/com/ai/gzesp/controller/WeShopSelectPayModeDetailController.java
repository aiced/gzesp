package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/order")
public class WeShopSelectPayModeDetailController {
	
	
	@Autowired
    private WeShopService weShopService;
    @RequestMapping("/selectPayModeDetail")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("selectPayModeDetail.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "支付");
//        List<Map<String, Object>> cityList=registSql.getCityList("85");
//        
//        mav.addObject("cityList", cityList);
        
        return mav;
    }
}
