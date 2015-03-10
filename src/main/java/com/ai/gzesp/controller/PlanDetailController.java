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
public class PlanDetailController {

    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：店铺主页-新号入网-套餐详情<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/planDetail")
    public ModelAndView planDetail(){
        ModelAndView mav = new ModelAndView("planDetail.ftl");
        //从数据库获取信息赋值
        //广告轮播图片的url
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");
        mav.addObject("banners", banners);

        return mav;
    }
    
    /**
     * 三级页面：店铺主页-新号入网-套餐详情-套餐ABC详情描述页<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/planDetailABC")
    public ModelAndView planDetailABC(){
        ModelAndView mav = new ModelAndView("planDetailABC.ftl");
        //从数据库获取信息赋值
        //广告轮播图片的url
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");
        mav.addObject("banners", banners);

        return mav;
    }
}
