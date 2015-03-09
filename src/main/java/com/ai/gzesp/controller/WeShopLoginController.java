/** 
 * @author 文辉
 * 微店登录
 */
package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;


@Controller
@RequestMapping("/auth")
public class WeShopLoginController {

    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/login")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopLogin.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "登录微店账号");

        
        return mav;
    }
    
}
