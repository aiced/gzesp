package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodAddController {
    
    @Autowired
    private WeShopService weShopService;
    @Resource 
    GoodsSql goodsSql;
    
    @RequestMapping("/goodsManageGoodAdd")
    public ModelAndView goodsManageGoodAdd(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String name = paramsMap.get("index");
    	
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
    	rspMap.put("title", "选择商品"); 
    	
    	
    	
    	List<Map<String, Object>> list = goodsSql.getGoodsList();
    	
    	

    	return new ModelAndView("goodsManageGoodAdd.ftl", rspMap);
    	
//        ModelAndView mav = new ModelAndView("goodsManageGoodAdd.ftl");
//        //从数据库获取信息赋值
//        mav.addObject("name", "喻露露");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
//        return mav;
    }
}
