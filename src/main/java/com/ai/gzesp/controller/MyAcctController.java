package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.MyAcctService;

@Controller
@RequestMapping("/shopManage")
public class MyAcctController {
	
    @Autowired
    private MyAcctService myAcctService;

	
	
    @RequestMapping("/acct/myAcct/{user_id}")
	public ModelAndView initAcct(@PathVariable("user_id") String user_id)
	{
    	//我的账户
    	
        ModelAndView mav = new ModelAndView("myAcct.ftl");
    	
    	//查询数据库
    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null)
    	{
            mav.addObject("acctinfo",acctinfo);
            System.out.println(acctinfo);
    	}    	 
        return mav;
	}
    
    @RequestMapping("/acct/withdraw/{user_id}")
    public ModelAndView initWithdraw(@PathVariable("user_id") String user_id)
    {
        ModelAndView mav = new ModelAndView("withdraw.ftl");
        return mav;
    }
    
    @RequestMapping("/acct/myBankCardList/{user_id}")
    public ModelAndView initMyBankCardList(@PathVariable("user_id") String user_id)
    {
        ModelAndView mav = new ModelAndView("myBankCardList.ftl");
        return mav;
    }
    
    @RequestMapping("/acct/acctBalance/{user_id}")
    public ModelAndView acctBalance(@PathVariable("user_id") String user_id){    	
        ModelAndView mav = new ModelAndView("acctBalance.ftl");
    	return mav;
    }
    
    @RequestMapping("/acct/acctSecurity/{user_id}")
    public ModelAndView acctSecurity(@RequestBody String inputParam){    	
       //安全设置
		ModelAndView mav = new ModelAndView("acctSecurity.ftl");
		return mav;
    }
    
}
