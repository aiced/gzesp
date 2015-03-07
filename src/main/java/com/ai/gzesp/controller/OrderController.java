package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/newNumberJoin")
    public ModelAndView newNumberJoin(@RequestBody String inputParam){
        ModelAndView mav = new ModelAndView("newNumberJoin.ftl");
        //从数据库获取信息赋值
        mav.addObject("selectedPhone", "Iphone6 plus(5.5英寸) 16G深空灰色");
        mav.addObject("selectedContract", "4G 106元套餐 12月合约 </br> 电话 短信 流量 </br> 合约价6999"); 
        mav.addObject("selectedNumber", "1306520198"); 
        return mav;
    }
}
