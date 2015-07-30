/**
 * 
 */
package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.dao.sql.PhoneTopUpSql;
import com.ai.gzesp.service.WeShopService;

/**
 * @author xinjunwang
 *
 */
@Controller
@RequestMapping("/topUp")
public class PhoneTopUpController {

    @Autowired
    private WeShopService weShopService;
    
    @Resource 
    TdGdsDINFODao tdGdsDinfoDao;
    
    @Resource 
    PhoneTopUpSql phoneTopUpSql;   

    @RequestMapping("/phoneTopUp/{user_id}")
    public ModelAndView phoneTopUp(@PathVariable("user_id") String user_id){
    	List<Map<String, Object>> topUpList = phoneTopUpSql.GetTopUpList();
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpList", topUpList);  
    	rspMap.put("title", "手机充值"); 
    	rspMap.put("user_id", user_id); 
        return new ModelAndView("phoneTopUp.ftl", rspMap);
    }
    
    @RequestMapping("/phoneTradRecordSearch/{user_id}")
    public ModelAndView phoneTradRecordSearch(@PathVariable("user_id") String user_id){
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("title", "搜索"); 
    	rspMap.put("user_id", user_id); 
        return new ModelAndView("phoneTradRecordSearch.ftl");
    }
    
    @RequestMapping("/phoneTradRecordList/{phoneNum}")
    public ModelAndView phoneTradRecordList(@PathVariable("phoneNum") String phoneNum){
    	//查询 列表
    	List<Map<String, Object>> topUpDealList = phoneTopUpSql.GetTopUpDealList(phoneNum);
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpDealList", topUpDealList);  
    	rspMap.put("title", "充值记录");     
        return new ModelAndView("phoneTradRecordList.ftl",rspMap);
    }
    
   @RequestMapping("/phoneTradRecordDetail/{orderId}")
    public ModelAndView phoneTradRecordDetail(@PathVariable("orderId") String orderId){
	   List<Map<String, Object>> topUpDetail = phoneTopUpSql.GetTopUpDealById(orderId);
	   Map<String, Object> rspMap = new HashMap<String, Object>(); 
	   rspMap.put("topUpDetail", topUpDetail);  
	   rspMap.put("title", "充值记录详情");     		   
       return new ModelAndView("phoneTradRecordDetail.ftl",rspMap);
    }
    
    
    
}
