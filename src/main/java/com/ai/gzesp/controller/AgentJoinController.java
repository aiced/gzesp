package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/weShop")
public class AgentJoinController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/agentJoin")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("agentJoin.ftl");
        //从数据库获取信息赋值
        
        return mav;
    }

}
