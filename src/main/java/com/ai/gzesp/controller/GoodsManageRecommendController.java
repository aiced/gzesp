package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageRecommendController {
    
    @Autowired
    private WeShopService weShopService;
    
    @Resource 
    TdOrdDBASEDao tdOrdDBASEDao;
    
    @Resource 
    GoodsSql goodsSql;
    
    @RequestMapping("/goodsManageRecommend")
    public ModelAndView goodsManageRecommend(@RequestParam(value = "userid", required = true)String strUserID){
    	System.out.println(strUserID);

        Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian"); 
    	rspMap.put("userId", strUserID);   
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("title", "商品发布"); 
    	return new ModelAndView("goodsManageRecommend.ftl", rspMap);
    }
}
