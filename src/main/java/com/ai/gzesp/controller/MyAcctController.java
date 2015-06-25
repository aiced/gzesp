package com.ai.gzesp.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.utils.DESUtil;
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
            List<Map<String, Object>> acctbankinfo =myAcctService.queryAcctBankByUserId(user_id);
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
    	//提现
    	
        ModelAndView mav = new ModelAndView("withdraw.ftl");
        
       	Map<String, String> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null)
    	{
            mav.addObject("acctinfo",acctinfo);
            //查询数据库
            List<Map<String, Object>> acctbankinfolist =myAcctService.queryAcctBankByUserId(user_id);
            if(acctbankinfolist != null)
            {	
            	mav.addObject("acctbankinfolist",acctbankinfolist);
            }
    	}  
        
        return mav;
    }
    
    @RequestMapping("/acct/myBankCardList/{user_id}")
    public ModelAndView initMyBankCardList(@PathVariable("user_id") String user_id)
    {
    	//我的银行卡
    	
        ModelAndView mav = new ModelAndView("myBankCardList.ftl");
        
        //查询数据库
        List<Map<String, Object>> acctbankinfolist =myAcctService.queryAcctBankByUserId(user_id);

        if(acctbankinfolist != null)
        {	
        	mav.addObject("acctbankinfolist",acctbankinfolist);
        }
        mav.addObject("user_id",user_id);
        return mav;
    }
    
    @RequestMapping("/acct/acctBalance/{user_id}/{page_num}/{page_size}")
    public ModelAndView initAcctBalance(@PathVariable("user_id") String user_id,@PathVariable("page_num") String page_num,@PathVariable("page_size") String page_size){  
    	//收支明细
        ModelAndView mav = new ModelAndView("acctBalance.ftl");
        
        //查询数据库
        //user_id  
        //0	 订单类型 0 , 1 ,2 (收入，支出，提现)，默认为0；
        //page_num 页数，默认第一页
        //page_size 每页返回条目数量
        //""	时间
        List<Map<String, Object>> acctlogpagelist=myAcctService.queryAcctBalanceLogPage(user_id,0,Integer.parseInt(page_num),Integer.parseInt(page_size),"");
        
        if(acctlogpagelist != null)
        {
            mav.addObject("acctloglist",acctlogpagelist);
            List<Map<String, Object>> acctloglist=myAcctService.queryAcctBalanceLog(user_id,0,Integer.parseInt(page_num),Integer.parseInt(page_size),"");
            mav.addObject("acctlogtotal", acctloglist.size());//这个地方 应该取最近的一条数据，这里我乱写的。后面会修改
        }

    	return mav;
    }
    
    @RequestMapping("/acct/acctBalancePagePostData")
    public ModelAndView acctBalancePagePostData(@RequestBody String inputParam){  
    	//收支明细
    	
//    	type : //订单类型 0 , 1 ,2 (收入，支出，提现)，默认为0；
//		monthKey: 按月份查询，默认所有数据
//		pageNum: 页数，默认第一页
//		pageSize: 每页返回条目数量
    	
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");
		String type=paramsMap.get("type");
		String monthKey=paramsMap.get("monthKey");
		String pageNum=paramsMap.get("pageNum");
		String pageSize=paramsMap.get("pageSize");
    	
	    List<Map<String, Object>> acctlogpagelist=myAcctService.queryAcctBalanceLogPage(user_id,Integer.parseInt(type),Integer.parseInt(pageNum),Integer.parseInt(pageSize),monthKey);
	    
	    ModelAndView mav = new ModelAndView("acctBalanceSub.ftl");
	    
	    if(acctlogpagelist != null)
	    {
          mav.addObject("acctloglist",acctlogpagelist);
	    }
    	
    	return mav;
    }
    
    
    @RequestMapping("/acct/acctBalanceTotalPostData")
    @ResponseBody
    public int acctBalanceTotalPostData(@RequestBody String inputParam){  
    	//收支明细通过Type
    	
//    	type : //订单类型 0 , 1 ,2 (收入，支出，提现)，默认为0；
//		monthKey: 按月份查询，默认所有数据
//		pageNum: 页数，默认第一页
//		pageSize: 每页返回条目数量
    	
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");
		String type=paramsMap.get("type");
		String monthKey=paramsMap.get("monthKey");
		String pageNum=paramsMap.get("pageNum");
		String pageSize=paramsMap.get("pageSize");
    	
	    List<Map<String, Object>> acctloglist=myAcctService.queryAcctBalanceLog(user_id,Integer.parseInt(type),Integer.parseInt(pageNum),Integer.parseInt(pageSize),monthKey);
	    
    	return acctloglist.size();
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
 		
 		return mav;
     }
    @RequestMapping("/acct/payPasswordSet/postData")
    public ModelAndView payPasswordSetPostData(@RequestBody String inputParam){    	
        //密码设置

    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String user_id = paramsMap.get("user_id");
    	String user_pwd = MD5Util.md5s2(paramsMap.get("user_pwd"),Constants.md5key); //md5加密
 		
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
    	Map<String, String> acctinfo =myAcctService.queryAcctByUserId_UserPwd(user_id,user_pwd);
    	if(acctinfo != null)
    	{
    		return true;
    	}  
 		return false;
    }
    
    @RequestMapping("/acct/addBankCardInput1/{user_id}")
    public ModelAndView initAddBankCardInput1(@PathVariable("user_id") String user_id){    	
       //添加银行卡
    	
    	ModelAndView mav = new ModelAndView("addBankCardInput1.ftl");
    	mav.addObject("user_id",user_id);
    	return mav;
    }
    @RequestMapping("/acct/addBankCardInput1/postData")
    public ModelAndView addBankCardInput1PostData(@RequestBody String inputParam){    		
    	//插入表格
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    
    	String user_id =paramsMap.get("user_id");

    	String valid_flag=paramsMap.get("valid_flag");
    	String priority=paramsMap.get("priority");
    	String card_type=paramsMap.get("card_type");
    	String bank_type=paramsMap.get("bank_type");

    	byte[] bank_no=DESUtil.encryptMode(Constants.desKey.getBytes(),paramsMap.get("bank_no").getBytes());
    	String strbank_no=DESUtil.Bytes2HexString(bank_no);

    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id,paramsMap.get("bank_no"));
    	
    	if (acctbankinfo != null) //有数据
    	{
			//直接将valid_flag 变成1 即可 wenh_todo
		}
    	else {
        	int iRet=myAcctService.insertAcctBank(user_id, strbank_no, valid_flag, priority, card_type, bank_type);
            if (iRet > 0)
            {
            	//只需要调用奚总绑定接口_ximh_todo
            }
		}
    	
    	ModelAndView mav = new ModelAndView("redirect:/shopManage/acct/myBankCardList/"+user_id);
    	return mav;

    }

    @RequestMapping("/acct/bankCardDetail/{user_id}/{bank_no}")
    public ModelAndView initBankCardDetail(@PathVariable("user_id") String user_id,@PathVariable("bank_no") String bank_no)
    {
    	//银行卡详情 解绑银行卡
    	ModelAndView mav = new ModelAndView("bankCardDetail.ftl");
    	
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	
    	if (acctbankinfo !=null) {
			mav.addObject("acctbankinfo",acctbankinfo);
		}
    	mav.addObject("title",acctbankinfo.get("PARAM_VALUE"));
    	mav.addObject("user_id",acctbankinfo.get("USER_ID"));
    	return mav;
    }
    @RequestMapping("/acct/bankCardDetail/undindingBankCard")
    @ResponseBody
    public int UndindingBankCard(@RequestBody String inputParam)
    {
    	//1：密码错误 2:删除失败 3：操作成功
    	Boolean bRet=checkPwdPostData(inputParam);
    	
    	if (!bRet) {
			return 1;//密码错误
		}
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String user_id = paramsMap.get("user_id");
    	String bank_no = paramsMap.get("bank_no");
    	
    	//这个地方先放着，调用奚总的解绑接口_todo
//    	int iRet=myAcctService.delAcctBankDetail(user_id,bank_no);
//    	if (iRet>0) 
//    	{
//    		return 2; //删除失败
//		}
    	return  3; //操作成功
    }
    
}
