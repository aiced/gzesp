package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.service.TdAurDBASEINFODao;
import com.ai.gzesp.dao.sql.RegistSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/shopManage")
public class WeShopBindBankCard {

	@Autowired
    private WeShopService weShopService;
	@Resource
	TdAurDBASEINFODao tdAurDBASEINFODao;
	@Resource 
	RegistSql registSql;
	
	  @RequestMapping("/bindBankCard")
	    public ModelAndView index(@RequestParam(value = "userid", required = false)String struserid){
	        ModelAndView mav = new ModelAndView("bindBankCard.ftl");
	        //从数据库获取信息赋值
	        mav.addObject("title", "我的银行卡");

	        
	        List<Map<String, Object>> bankList=registSql.getBankList("BANK_TYPE");
	        
	        System.out.println("userid="+struserid);
	        mav.addObject("userid", struserid);
	        mav.addObject("bankList", bankList);
	        
	    	Criteria example = new Criteria();
	    	example.createConditon().andEqualTo("USER_ID", struserid);
	    	List<TdAurDBASEINFO> dataList =  tdAurDBASEINFODao.selectByExample(example);
	    	mav.addObject("nengrendata", dataList.get(0));
	    	
	    	System.out.println(dataList.get(0).getBankName());
	        return mav;
	    }    
	
    @RequestMapping("/BankCard_PostData")
    @ResponseBody
    public Boolean BankCard_PostData(@RequestBody String inputParams){
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String strhide_userid=paramsMap.get("hide_userid");
    	String strBankName=paramsMap.get("selBank");
    	String strBankCard=paramsMap.get("txtbankcardid");
    	
    	System.out.println("strBankName="+strBankName);
    	System.out.println("strBankCard="+strBankCard);
    	
    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("USER_ID", strhide_userid);
    	
    	TdAurDBASEINFO record = new TdAurDBASEINFO();
    	record.setBankName(strBankName);
    	record.setBankAcct(strBankCard);
    	int icount=tdAurDBASEINFODao.updateByExampleSelective(record, example);
    	System.out.println("icount="+icount);
    	if (icount>0) {
			return true;
		}
    	else {
			return false;
		}
//    	ModelAndView mav = new ModelAndView("redirect:bindBankCard?userid="+strhide_userid);
//    	
//    	return mav;
    }
    @RequestMapping("/BankBack")
    @ResponseBody
    public ModelAndView GoBack(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	
    	String strUserID=paramsMap.get("hide_userid");
    	//http://localhost:8080/esp/shopManage/commissionQuery?userid=2015042002370671
        ModelAndView mav =new ModelAndView("redirect:/shopManage/weShopSet?userid="+strUserID);
    

        return mav;
    }
  
}
