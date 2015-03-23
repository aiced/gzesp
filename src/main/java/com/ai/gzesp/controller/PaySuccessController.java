package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
public class PaySuccessController {
    
    
    @RequestMapping("/paySuccess")
    public ModelAndView goodsManageRecommend(@RequestBody String inputParam){
    	String userId = null;
    	if(userId == null){
    		userId = "123456";
        	System.out.println(userId);
    	}
    	String orderId = "123455666";
    	String payModle = "货到付款";


        Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian"); 
    	rspMap.put("userId", userId);   
    	rspMap.put("orderId", orderId);   
    	rspMap.put("payModle", payModle);   
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("title", "支付成功"); 
    	return new ModelAndView("paySuccess.ftl", rspMap);
    }
}
