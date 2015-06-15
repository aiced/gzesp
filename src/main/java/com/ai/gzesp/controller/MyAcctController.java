package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.service.MyAcctService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.StringUtil;

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
            
            //查询数据库
            Map<String, String> acctbankinfo =myAcctService.queryAcctBankByUserId(user_id);
            if(acctbankinfo != null)
            {
            	mav.addObject("bankcout",acctbankinfo.size());
                System.out.println(acctbankinfo);
            }
            else 
            {
            	mav.addObject("bankcout",0);
			}
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
    	//我的银行卡
    	
        ModelAndView mav = new ModelAndView("myBankCardList.ftl");
        
        //查询数据库
        Map<String, String> acctbankinfo =myAcctService.queryAcctBankByUserId(user_id);
        if(acctbankinfo != null)
        {
        	mav.addObject("acctbankinfo",acctbankinfo);
            System.out.println(acctbankinfo);
        }
        return mav;
    }
    
    @RequestMapping("/acct/acctBalance/{user_id}")
    public ModelAndView initAcctBalance(@PathVariable("user_id") String user_id){    	
        ModelAndView mav = new ModelAndView("acctBalance.ftl");
    	return mav;
    }
    
    @RequestMapping("/acct/acctSecurity/{user_id}")
    public ModelAndView initAcctSecurity(@PathVariable("user_id") String user_id){    	
       //安全设置
		ModelAndView mav = new ModelAndView("acctSecurity.ftl");
		
    	//查询数据库
    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null)
    	{
            mav.addObject("acctinfo",acctinfo);

            System.out.println(acctinfo);
    	}    	 
        return mav;
    }
    
    @RequestMapping("/acct/payPasswordResetVerify/{user_id}")
    public ModelAndView initPayPasswordResetVerify(@PathVariable("user_id") String user_id){    	
        //安全验证
 		ModelAndView mav = new ModelAndView("payPasswordResetVerify.ftl");
 		mav.addObject("user_id",user_id);
 		return mav;
     }
    
    @RequestMapping("/acct/payPasswordSet/{user_id}")
    public ModelAndView initPayPasswordSet(@PathVariable("user_id") String user_id){    	
        //密码设置
 		ModelAndView mav = new ModelAndView("payPasswordSet.ftl");
 		
    	//查询数据库
    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null)
    	{
            mav.addObject("acctinfo",acctinfo);
            System.out.println(acctinfo);
    	}  
 		return mav;
     }
    @RequestMapping("/acct/payPasswordReset/{user_id}")
    public ModelAndView initPayPasswordReset(@PathVariable("user_id") String user_id){    	
        //密码重置
 		ModelAndView mav = new ModelAndView("payPasswordReset.ftl");
 		mav.addObject("user_id",user_id);
//    	//查询数据库
//    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
//    	if(acctinfo != null)
//    	{
//            mav.addObject("acctinfo",acctinfo);
//            System.out.println(acctinfo);
//    	}  
 		return mav;
     }
    @RequestMapping("/acct/payPasswordSet/postData")
    public ModelAndView payPasswordSetPostData(@RequestBody String inputParam){    	
        //密码设置

    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String user_id = paramsMap.get("user_id");
    	String user_pwd = MD5Util.md5s2(paramsMap.get("user_pwd"),Constants.md5key); //md5加密
    	String update_date=paramsMap.get("update_time");
    	
 		System.out.println(user_id);
 		System.out.println(user_pwd);
 		System.out.println(update_date);
 		
// 		if (update_date.equals("") || update_date==null ) //为空，说明第一次设置密码 insert操作
// 		{
// 			myAcctService.insertAcctPwd(user_id,user_pwd);
//		}
// 		else	//有值 直接修改密码 update操作 
// 		{
// 			myAcctService.updateAcctPwd(user_id, user_pwd);
//		}
 		
 		myAcctService.insertAcctPwd(user_id,user_pwd);
 		ModelAndView mav = new ModelAndView("redirect:/shopManage/acct/payPasswordSuccess/"+user_id);
 		return mav;
     }
    @RequestMapping("/acct/payPasswordReset/postData")
    public ModelAndView payPasswordResetPostData(@RequestBody String inputParam){    	
        //密码设置

    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String user_id = paramsMap.get("user_id");
    	String user_pwd = MD5Util.md5s2(paramsMap.get("user_pwd"),Constants.md5key); //md5加密
    	
 		System.out.println(user_id);
 		System.out.println(user_pwd);
 		
// 		if (update_date.equals("") || update_date==null ) //为空，说明第一次设置密码 insert操作
// 		{
// 			myAcctService.insertAcctPwd(user_id,user_pwd);
//		}
// 		else	//有值 直接修改密码 update操作 
// 		{
// 			myAcctService.updateAcctPwd(user_id, user_pwd);
//		}
 		
 		myAcctService.updateAcctPwd(user_id, user_pwd);
 		ModelAndView mav = new ModelAndView("redirect:/shopManage/acct/payPasswordSuccess/"+user_id);
 		return mav;
     }
    
    
    @RequestMapping("/acct/payPasswordSuccess/{user_id}")
    public ModelAndView initPayPasswordSuccess(@PathVariable("user_id") String user_id){    	
        //密码设置成功
 		ModelAndView mav = new ModelAndView("payPasswordSuccess.ftl");
 		mav.addObject("user_id",user_id);
 		return mav;
     }
    
    @RequestMapping("/acct/myBankCardList/checkPwd")
    @ResponseBody
    public Boolean checkPwdPostData(@RequestBody String inputParam)
    {
    	//校验支付密码是否正确
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String user_id = paramsMap.get("user_id");
    	String user_pwd = MD5Util.md5s2(paramsMap.get("user_pwd"),Constants.md5key); //md5加密
    	
 		System.out.println(user_id);
 		System.out.println(user_pwd);
 		
    	//查询数据库
    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null && acctinfo.size()==1)
    	{
    		return true;
    	}  
 		return false;
    	
    }
    
    @RequestMapping("/acct/addBankCardInput1/{user_id}")
    public ModelAndView initAddBankCardInput1(@PathVariable("user_id") String user_id){    	
        ModelAndView mav = new ModelAndView("addBankCardInput1.ftl");
    	mav.addObject("title", "添加银行卡"); //页面title
    	return mav;
    }
	
    		
    		
    		
}
