package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;

@Controller
@RequestMapping("/order")
public class ImageAndTextDetailController {

    @Autowired
    private OrderService orderService;
    
    /**
     * 三级页面：图文详情页面 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/imageAndTextDetail")
    public ModelAndView selectNumber(){
        ModelAndView mav = new ModelAndView("imageAndTextDetail.ftl");
        //从数据库获取信息赋值
        //数据库获取地市
        return mav;
    }
}
