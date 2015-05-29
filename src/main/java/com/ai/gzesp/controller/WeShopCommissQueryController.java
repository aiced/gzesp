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

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdAurDBASEINFODao;
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
	@Resource
	TdAurDBASEINFODao tdAurDBASEINFODao;
	
    @RequestMapping("/commissionQuery")
    public ModelAndView index(@RequestParam(value = "userid", required = true)String strUserID){
        
    	System.out.println(strUserID);
    	
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> commList=commissionSql.getCommListbySelectGroup("0",strUserID,"","","","-1",16);//默认显示8条数据
    	String strTotalMoney=commissionSql.getCommTotalbySelectGroup("0",strUserID,"","","","-1",16);


    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("USER_ID", strUserID);
    	List<TdAurDBASEINFO> list = tdAurDBASEINFODao.selectByExample(example);
    	
    	
    	
    	ModelAndView mav = new ModelAndView("commissionQuery.ftl");
        //从数据库获取信息赋值
        
        mav.addObject("title", "收益查询");
        mav.addObject("hideuserid", strUserID); 
        mav.addObject("commList",commList);
        mav.addObject("totalmoney",Integer.valueOf(strTotalMoney));
        mav.addObject("isbandbank", list.get(0).getBankAcct()); 
        
        return mav;
    }
    @RequestMapping("/selectCommissions_Page")
    @ResponseBody
    public ModelAndView queryOrdersByDate_Page(@RequestBody String strParam)
    {
    	String strzhangqiTime="";
    	String strStartDate="";
    	String strEndDate="";
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	String strFlag=paramsMap.get("iflag");
    	String strUserID=paramsMap.get("userID");
    	String strStatusflag=paramsMap.get("iStatusflag");
    	String strHidePageIndex=paramsMap.get("hidepageindex");
    	
    	if (strFlag.equals("1")) {
    		strzhangqiTime=paramsMap.get("zhangqiTime");
    		//strzhangqiTime=strzhangqiTime.replace("-", "");
		}
    	else if(strFlag.equals("2"))
    	{
        	strStartDate=paramsMap.get("startDate");
        	strEndDate=paramsMap.get("endDate");
        	
        	//strStartDate=strStartDate.replace("-", "");
        	//strEndDate=strEndDate.replace("-", "");
    	}
    	
    	System.out.println(strFlag);
    	System.out.println(strUserID);
    	System.out.println(strzhangqiTime);
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strStatusflag);
    	System.out.println(strHidePageIndex);
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> commList=commissionSql.getCommListbySelectGroup(strFlag,strUserID,strzhangqiTime,strStartDate,strEndDate,strStatusflag,Integer.valueOf(strHidePageIndex));
    	
        ModelAndView mav = new ModelAndView("commissionQuerySub.ftl");
        mav.addObject("commList",commList);
        return mav;
    }
    @RequestMapping("/selectCommissions")
    @ResponseBody
    public ModelAndView queryOrdersByDate(@RequestBody String strParam)
    {
    	String strzhangqiTime="";
    	String strStartDate="";
    	String strEndDate="";
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	String strFlag=paramsMap.get("iflag");
    	String strUserID=paramsMap.get("userID");
    	String strStatusflag=paramsMap.get("iStatusflag");
    	String strHidePageIndex=paramsMap.get("hidepageindex");
    	
    	if (strFlag.equals("1")) {
    		strzhangqiTime=paramsMap.get("zhangqiTime");
    		//strzhangqiTime=strzhangqiTime.replace("-", "");
		}
    	else if(strFlag.equals("2"))
    	{
        	strStartDate=paramsMap.get("startDate");
        	strEndDate=paramsMap.get("endDate");
        	
        	//strStartDate=strStartDate.replace("-", "");
        	//strEndDate=strEndDate.replace("-", "");
    	}
    	
    	System.out.println(strFlag);
    	System.out.println(strUserID);
    	System.out.println(strzhangqiTime);
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strStatusflag);
    	System.out.println(strHidePageIndex);
    	//这里从数据库查询数据
    	
       	List<Map<String, Object>> commList=commissionSql.getCommListbySelectGroup(strFlag,strUserID,strzhangqiTime,strStartDate,strEndDate,strStatusflag,Integer.valueOf(strHidePageIndex));
    	
    	//String strTotalMoney=commissionSql.getCommTotalbySelectGroup(strFlag,strUserID,strzhangqiTime,strStartDate,strEndDate,"-1",16);//-1的参数不要动

        ModelAndView mav = new ModelAndView("commissionQuerySub.ftl");
        mav.addObject("commList",commList);
        //mav.addObject("totalmoney",Integer.valueOf(strTotalMoney));
        return mav;
    }
    
    @RequestMapping("/selectCommissionsTotal")
    @ResponseBody
    public int queryOrderstotalByDate(@RequestBody String strParam)
    {
    	String strzhangqiTime="";
    	String strStartDate="";
    	String strEndDate="";
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	String strFlag=paramsMap.get("iflag");
    	String strUserID=paramsMap.get("userID");
    	String strStatusflag=paramsMap.get("iStatusflag");
    	String strHidePageIndex=paramsMap.get("hidepageindex");
    	
    	if (strFlag.equals("1")) {
    		strzhangqiTime=paramsMap.get("zhangqiTime");
    		//strzhangqiTime=strzhangqiTime.replace("-", "");
		}
    	else if(strFlag.equals("2"))
    	{
        	strStartDate=paramsMap.get("startDate");
        	strEndDate=paramsMap.get("endDate");
        	
        	//strStartDate=strStartDate.replace("-", "");
        	//strEndDate=strEndDate.replace("-", "");
    	}
    	
    	System.out.println(strFlag);
    	System.out.println(strUserID);
    	System.out.println(strzhangqiTime);
    	System.out.println(strStartDate);
    	System.out.println(strEndDate);
    	System.out.println(strStatusflag);
    	System.out.println(strHidePageIndex);
    	//这里从数据库查询数据
    	
       	//List<Map<String, Object>> commList=commissionSql.getCommListbySelectGroup(strFlag,strUserID,strzhangqiTime,strStartDate,strEndDate,strStatusflag,Integer.valueOf(strHidePageIndex));
    	
    	String strTotalMoney=commissionSql.getCommTotalbySelectGroup(strFlag,strUserID,strzhangqiTime,strStartDate,strEndDate,"-1",16);//-1的参数不要动
    	return Integer.valueOf(strTotalMoney);
        //ModelAndView mav = new ModelAndView("commissionQuerySub.ftl");
        //mav.addObject("commList",commList);
        //mav.addObject("totalmoney",Integer.valueOf(strTotalMoney));
        //return mav;
    }    
}
