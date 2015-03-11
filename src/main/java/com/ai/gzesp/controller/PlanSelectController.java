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
public class PlanSelectController {
    
    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：店铺主页-新号入网-套餐列表选择<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/planSelect")
    public ModelAndView planSelect(){
        ModelAndView mav = new ModelAndView("planSelect.ftl");
        //从数据库获取信息赋值

        return mav;
    }

}
