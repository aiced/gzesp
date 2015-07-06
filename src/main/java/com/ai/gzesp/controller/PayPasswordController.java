package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("")
public class PayPasswordController {
    @RequestMapping("/set/acctSecurity")
    public ModelAndView acctSecurity(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("acctSecurity.ftl");
    	mav.addObject("title", "安全设置"); //页面title
    	return mav;
    }
    

    @RequestMapping("/set/acct/payPasswordSet")
  	public ModelAndView payPasswordSet(@RequestBody String inputParam)
  	{
        ModelAndView mav = new ModelAndView("payPasswordSet.ftl");
      	mav.addObject("title", "密码设置"); //页面title
      	return mav ;
  	}
	
    
    @RequestMapping("/set/payPasswordResetVerify")
    public ModelAndView payPasswordResetVerify(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("payPasswordResetVerify.ftl");
    	mav.addObject("title", "密码验证"); //页面title
    	return mav;
    }
    
    
    @RequestMapping("/set/payPasswordReset")
    public ModelAndView payPasswordReset(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("payPasswordReset.ftl");
    	mav.addObject("title", "密码重置"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/payPasswordSuccess")
    public ModelAndView payPasswordSuccess(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("payPasswordSuccess.ftl");
    	mav.addObject("title", "设置成功"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/acctBalance")
    public ModelAndView acctBalance(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("acctBalance.ftl");
    	mav.addObject("title", "收支明细"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/addBankCardInput1")
    public ModelAndView addBankCardInput1(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("addBankCardInput1.ftl");
    	mav.addObject("title", "添加银行卡"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/addBankCardInput2")
    public ModelAndView addBankCardInput2(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("addBankCardInput2.ftl");
    	mav.addObject("title", "添加银行卡"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/phoneTopUp")
    public ModelAndView phoneTopUp(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("phoneTopUp.ftl");
    	mav.addObject("title", "手机充值"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/phoneTopUpCards")
    public ModelAndView phoneTopUpCards(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("phoneTopUpCards.ftl");
    	mav.addObject("title", "购买充值卡"); //页面title
    	return mav;
    }
    

    @RequestMapping("/set/phoneTradRecordSearch")
    public ModelAndView phoneTradRecordSearch(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("phoneTradRecordSearch.ftl");
    	mav.addObject("title", "交易记录查询"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/phoneTradRecordList")
    public ModelAndView phoneTradRecordList(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("phoneTradRecordList.ftl");
    	mav.addObject("title", "交易记录"); //页面title
    	return mav;
    }
    
    @RequestMapping("/set/phoneTradRecordDetail")
    public ModelAndView phoneTradRecordDetail(@RequestBody String inputParam){    	
        ModelAndView mav = new ModelAndView("phoneTradRecordDetail.ftl");
    	mav.addObject("title", "详情"); //页面title
    	return mav;
    }

}
