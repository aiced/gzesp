package com.ai.gzesp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pay/wopay")
public class WoPayOrderPostController {
    @RequestMapping("/orderPost/{order_id}/{fee}")
    public ModelAndView index(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("woPayOrderPost.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "沃支付");
        return mav;
    }
}
