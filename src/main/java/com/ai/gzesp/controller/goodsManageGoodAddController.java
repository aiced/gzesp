package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;

@Controller
@RequestMapping("/weShop")
public class goodsManageGoodAddController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/goodsMananger/goodsManageGoodAdd")
    public ModelAndView index(){
    	
    	List list = new ArrayList();  
    	Map info = new HashMap();   
    	Map rspMap = new HashMap();    

    	info.put("num", "1111");   
    	info.put("amount", "1111");
    	info.put("time", "2104.5.6");  
    	list.add(info);    
    	info = new HashMap();   
    	info.put("num", "2222");   
    	info.put("amount", "2222");     
    	info.put("time", "2104.5.8");    
    	list.add(info);     	    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", list.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("list", list);     
    	return new ModelAndView("goodsManageGoodAdd.ftl", rspMap);
    	
//        ModelAndView mav = new ModelAndView("goodsManageGoodAdd.ftl");
//        //从数据库获取信息赋值
//        mav.addObject("name", "喻露露");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
//        return mav;
    }
}
