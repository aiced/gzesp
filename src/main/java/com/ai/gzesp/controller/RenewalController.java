/**
 * 
 */
package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ai.gzesp.dao.sql.PhoneTopUpSql;
import com.ai.gzesp.dao.sql.RenewalSql;
import com.ai.sysframe.utils.StringUtil;

/**
 * @author xinjunwang
 *
 */
@Controller
@RequestMapping("/renewal")
public class RenewalController {
    
    @Resource 
    RenewalSql renewalSql;   
     
    @RequestMapping("/renewalList/{searchNumber}")
    public ModelAndView renewalList(@PathVariable("searchNumber") String searchNumber){
    	//查询 列表
    	List<Map<String, Object>> topUpDealList = renewalSql.GetTopUpDealList(searchNumber,0);
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpDealList", topUpDealList);  
    	rspMap.put("title", "宽带续约记录");     
    	rspMap.put("from", "renewal");     
    	rspMap.put("searchNumber", searchNumber);         	
        return new ModelAndView("phoneTradRecordList.ftl",rspMap);
    }
    
    @RequestMapping("/renewalListSub")
    public ModelAndView renewalListSub(@RequestBody String inputParam){
    	//查询 列表
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String searchNumber = paramsMap.get("searchNumber");
		int pageNum= Integer.parseInt(paramsMap.get("pageNum"));
    	List<Map<String, Object>> topUpDealList = renewalSql.GetTopUpDealList(searchNumber,pageNum *10);
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpDealList", topUpDealList);  
    	rspMap.put("from", "renewal");     
        return new ModelAndView("phoneTradRecordListSub.ftl",rspMap);
    }
    
    
   @RequestMapping("/renewalDetail/{orderId}")
    public ModelAndView renewalDetail(@PathVariable("orderId") String orderId){
	   List<Map<String, Object>> topUpDetail = renewalSql.GetTopUpDealById(orderId);
	   Map<String, Object> rspMap = new HashMap<String, Object>(); 
	   rspMap.put("topUpDetail", topUpDetail);  
	   rspMap.put("title", "宽带续约详情");    
	   rspMap.put("from", "renewal");     
       return new ModelAndView("phoneTradRecordDetail.ftl",rspMap);
    }
    
}
