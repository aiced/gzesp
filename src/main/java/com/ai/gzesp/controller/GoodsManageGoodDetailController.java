package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodDetailController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/goodsManageGoodDetail")
    public ModelAndView goodsManageGoodDetail(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String name = paramsMap.get("index");
        ModelAndView mav = new ModelAndView("goodsManageGoodDetail.ftl");
        //从数据库获取信息赋值
        mav.addObject("name", "喻露露");
        mav.addObject("phone", "18685292522"); 
        mav.addObject("weixin", "1306520198@qq.com"); 
        mav.addObject("title", "商品详情");
        return mav;
    }
}
