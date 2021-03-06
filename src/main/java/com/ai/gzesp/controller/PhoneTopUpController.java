/**
 * 
 */
package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ai.gzesp.dao.sql.PhoneTopUpSql;
import com.ai.sysframe.utils.StringUtil;

/**
 * @author xinjunwang
 *
 */
@Controller
@RequestMapping("/topUp")
public class PhoneTopUpController {
    
    @Resource 
    PhoneTopUpSql phoneTopUpSql;   
    
    @RequestMapping("/phoneTopUp/{user_id}")
    public ModelAndView phoneTopUp(@PathVariable("user_id") String user_id){
    	List<Map<String, Object>> topUpList = phoneTopUpSql.GetTopUpList();
    	for (Map<String, Object> m : topUpList)  
        {  
            System.out.println( ); 
            
            List<Map<String, Object>> avalibleList = phoneTopUpSql.GetAvalibleCardsList(m.get("originalPrice").toString());
            if(avalibleList != null && avalibleList.size()>0){
            	m.put("clickAble", "yes");  
            }else{
            	m.put("clickAble", "no");  
            }
        }  
    	
    	
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
        return new ModelAndView("phoneTradRecordSearch.ftl",rspMap);
    }
    
    @RequestMapping("/phoneTradRecordList/{searchNumber}")
    public ModelAndView phoneTradRecordList(@PathVariable("searchNumber") String searchNumber){
    	//查询 列表
    	List<Map<String, Object>> topUpDealList = phoneTopUpSql.GetTopUpDealList(searchNumber,0);
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpDealList", topUpDealList);  
    	rspMap.put("title", "充值记录");     
    	rspMap.put("searchNumber", searchNumber);         	
        return new ModelAndView("phoneTradRecordList.ftl",rspMap);
    }
    
    @RequestMapping("/phoneTradRecordListSub")
    public ModelAndView phoneTradRecordListSub(@RequestBody String inputParam){
    	
    	//查询 列表
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String searchNumber = paramsMap.get("searchNumber");
		int pageNum= Integer.parseInt(paramsMap.get("pageNum"));
    	List<Map<String, Object>> topUpDealList = phoneTopUpSql.GetTopUpDealList(searchNumber,pageNum *10);
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpDealList", topUpDealList);  
        return new ModelAndView("phoneTradRecordListSub.ftl",rspMap);
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
