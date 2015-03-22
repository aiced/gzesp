package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ai.gzesp.dao.sql.CommissionSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/shopManage")
public class WeShopCommissQueryController {

    @Autowired
    private WeShopService weShopService;
	@Resource 
	CommissionSql commissionSql;
	
    @RequestMapping("/commissionQuery")
    public ModelAndView index(@RequestParam(value = "userid", required = true)String strUserID){
        
    	System.out.println(strUserID);
    	
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> commList=commissionSql.getCommListbyMonth(strUserID,"");
    	

    	
    	
    	ModelAndView mav = new ModelAndView("commissionQuery.ftl");
        //从数据库获取信息赋值
        
        mav.addObject("title", "佣金查询");
        mav.addObject("hideuserid", strUserID); 
        mav.addObject("commList",commList);
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        return mav;
    }
    
    @RequestMapping("/selectCommissions")
    @ResponseBody
    public ModelAndView queryOrdersByDate(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strStartDate=paramsMap.get("startDate");
    	String strUserID=paramsMap.get("userID");

    	strStartDate=strStartDate.replace("-", "");
    	System.out.println(strStartDate);
    	System.out.println(strUserID);

    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> commList=commissionSql.getCommListbyMonth(strUserID,strStartDate);
    	
        ModelAndView mav = new ModelAndView("commissionQuerySub.ftl");
        mav.addObject("commList",commList);
        return mav;
    }
}
