package com.ai.gzesp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopManage")
public class MyAcctController {
	
    @RequestMapping("/acct/myAcct/{user_id}")
	public ModelAndView initAcct(@PathVariable("user_id") String user_id)
	{
        ModelAndView mav = new ModelAndView("myAcct.ftl");
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
    	mav.addObject("title", "收支明细"); //页面title
    	return mav;
    }
    
    
}
