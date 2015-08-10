package com.ai.gzesp.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import scala.annotation.meta.param;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.sql.RegistSql;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.service.MyAcctService;
import com.ai.gzesp.service.UnionPayService2;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DESUtil;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class MyAcctController {
	
    @Autowired
    private MyAcctService myAcctService;
	@Resource 
	RegistSql registSql;
	
    @Autowired
	UnionPayService2 unionPayService2;
	
    @RequestMapping("/acct/myAcct/{user_id}")
	public ModelAndView initAcct(@PathVariable("user_id") String user_id)
	{
    	//我的账户
    	
        ModelAndView mav = new ModelAndView("myAcct.ftl");
    	
    	//查询数据库
    	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null)
    	{
            mav.addObject("acctinfo",acctinfo);
            System.out.println(acctinfo);
            
            //查询数据库
            List<Map<String, Object>> acctbankinfo =myAcctService.queryAcctBankByUserId(user_id);
            if(acctbankinfo != null && acctbankinfo.size()>0)
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
        
       	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null && acctinfo.size()>0)
    	{
            mav.addObject("acctinfo",acctinfo);
            //查询数据库
            List<Map<String, Object>> acctbankinfolist =myAcctService.queryAcctBankByUserId(user_id);
            if(acctbankinfolist != null && acctbankinfolist.size()>0)
            {	
            	mav.addObject("acctbankinfolist",acctbankinfolist);
            }
    	}  
    	mav.addObject("user_id",user_id);
        return mav;
    }
    
    //提现功能：输入安全码后点击确定按钮
    //传入：userid和fee（提现金额——厘）
    //返回：字符串 给前端页面
    //插入到 ACT_D_WITHDRAW_AUDIT表中
    @RequestMapping("/acct/withdraw/postData")
    @ResponseBody
    public String withdrawPostData(@RequestBody String inputParam)
    {
    	//该处需要特别注意！！！
    	
    	//由于时间紧迫，在本controller处会直接处理
    	//ACT_D_ACCOUNT做账户金额更新，ACT_D_ACCESS_LOG账户明细查询
    	//后面这两个表的代码操作需要转移到网盟的后台，请切记，
    	//所以暂时放到本controller处理
    	
    	//直接将审核的状态变成审核中，后续当网盟后台功能添加后，将该状态默认插入未审核
    	
    	
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");
		String withdraw_fee=paramsMap.get("withdraw_fee");
		String hide_acctid=paramsMap.get("hide_acctid");
		String log_id=CommonUtil.generateLogId("6");
		String partition_id=log_id.substring(14,16);
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式		
		String apply_time=dateFormat.format(now);
		String audit_state="02"; //后续要修改成为未审核  00
		
 		String strRet=myAcctService.insertWidthDrawAuDit(log_id,partition_id,apply_time,user_id,withdraw_fee,audit_state,hide_acctid);
 		return strRet;


    }
    @RequestMapping("/acct/myBankCardList/{user_id}")
    public ModelAndView initMyBankCardList(@PathVariable("user_id") String user_id)
    {
    	//我的银行卡
    	
        ModelAndView mav = new ModelAndView("myBankCardList.ftl");
        
        //查询数据库
        List<Map<String, Object>> acctbankinfolist =myAcctService.queryAcctBankByUserId(user_id);

        if(acctbankinfolist != null && acctbankinfolist.size()>0)
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
        
        if(acctlogpagelist != null && acctlogpagelist.size()>0)
        {
            mav.addObject("acctloglist",acctlogpagelist);
            List<Map<String, Object>> acctloglist=myAcctService.queryAcctBalanceLog(user_id,0,Integer.parseInt(page_num),Integer.parseInt(page_size),"");
            mav.addObject("acctlogtotal", acctloglist.get(0).get("NEW_BALANCE"));
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
	    
	    if(acctlogpagelist != null && acctlogpagelist.size()>0)
	    {
          mav.addObject("acctloglist",acctlogpagelist);
	    }
    	
    	return mav;
    }
    
    
    @RequestMapping("/acct/acctBalanceTotalPostData")
    @ResponseBody
    public String acctBalanceTotalPostData(@RequestBody String inputParam){  
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
	    
	    if ((acctloglist != null ) && (acctloglist.size() > 0)) {
	    	return 	acctloglist.get(0).get("NEW_BALANCE").toString();
		}
    	return  "-1";
    }
    
    
    @RequestMapping("/acct/acctSecurity/{user_id}")
    public ModelAndView initAcctSecurity(@PathVariable("user_id") String user_id){    	
       //安全设置
		ModelAndView mav = new ModelAndView("acctSecurity.ftl");
		
    	//查询数据库
    	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null && acctinfo.size()>0)
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
    	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
    	if(acctinfo != null && acctinfo.size()>0)
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
    	if(acctinfo != null && acctinfo.size()>0)
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
    	
        List<Map<String, Object>> bankList=registSql.getBankList("BANK_TYPE");
        
        mav.addObject("bankList", bankList);
        
    	return mav;
    }
    @RequestMapping("/acct/addBankCardInput1/postData")
    @ResponseBody
    public String addBankCardInput1PostData(@RequestBody String inputParam){    		
    	//插入表格
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	Map<String, String> paramsRet=null;
    	String user_id =paramsMap.get("user_id");
    	
    	
    	//注意这个地方
    	//银行卡的绑定状态
    	//2015_08_10 因为要暂时去掉绑定银行卡的功能（调银联接口），所以这个地方直接插入绑定成功的状态标志
    	String valid_flag=paramsMap.get("valid_flag");
    	valid_flag="1";//先暂时写死，绑定成功 edit_by_wenh_2015_8_10
    	
    	String priority=paramsMap.get("priority");
    	String card_type=paramsMap.get("card_type");
    	String bank_type=paramsMap.get("bank_type");
    	String certificate_code=paramsMap.get("certificate_code");
    	String phone=paramsMap.get("phone");
    	String name=paramsMap.get("name");
    	
    	String systradeno = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号

    	
    	//下面两句可能报错
		String cvn2=paramsMap.get("cvn2");
		String expire_date=paramsMap.get("expire_date");
    	
    	byte[] bank_no=DESUtil.encryptMode(Constants.desKey.getBytes(),paramsMap.get("bank_no").getBytes());
    	String strbank_no=DESUtil.Bytes2HexString(bank_no);


    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id,paramsMap.get("bank_no"));
    	
    	if (acctbankinfo != null && acctbankinfo.size()>0) //有数据
    	{

    		String strvalid_flag= acctbankinfo.get("VALID_FLAG").toString();

    		if (strvalid_flag.equals("1"))  //已经绑定的银行卡
    		{
    			return "ok";
			}
    		else if(strvalid_flag.equals("3"))//已经绑定过，但是解绑过
    		{
    			//只需将状态进行修改为1
    			
    			int iRet=myAcctService.updateAcctBank(
            			acctbankinfo.get("USER_ID").toString(), 
            			strbank_no,//注意这个地方是加密的银行卡
            			acctbankinfo.get("CVN2").toString(),
            			acctbankinfo.get("PHONE").toString(),
            			acctbankinfo.get("NAME").toString(),
            			acctbankinfo.get("CERTIFICATE_CODE").toString(),
            			acctbankinfo.get("EXPIRE_DATE").toString(),
            			acctbankinfo.get("CARD_TYPE").toString(),
            			acctbankinfo.get("BANK_TYPE").toString(),
            			acctbankinfo.get("SIGN_CODE").toString(),
            			"1",//acctbankinfo.get("VALID_FLAG").toString()
            			acctbankinfo.get("PRIORITY").toString(),
            			acctbankinfo.get("SYS_TRADE_NO").toString()
            			);
            	if (iRet<0) 
            	{
            		return "插入报错～"; //插入报错～
        		}
            	return  "ok"; //操作成功
    			
    		}
    		else if (strvalid_flag.equals("2") || strvalid_flag.equals("0")) {
				//1,先更新要素
    			//2.然后调用接口
    			//3.wenh_do
    			
    			int iRet=myAcctService.updateAcctBank(
	            			user_id, 
	            			strbank_no,
	            			cvn2,
	            			phone,
	            			name,
	            			certificate_code,
	            			expire_date,
	            			card_type,
	            			bank_type,
	            			"",//固定写死，奚总后面会有更新的操作，签约号
	            			valid_flag, 
	            			priority,
	            			systradeno
    					);
                if (iRet > 0)
                {
                	//调用奚总的绑定接口，暂时先注释掉
                	return "ok";
//                	paramsRet=bindCard(
//                			systradeno,
//                			paramsMap.get("bank_no"),
//                			cvn2,
//                			expire_date,
//                			card_type,
//                			name, 
//                			certificate_code,
//                			phone
//                			);
                }
                else {
    				return "插入报错～";
				}
			}
		}
    	else //没有记录直接插入掉接口 
    	{
        	int iRet=myAcctService.insertAcctBank(
        			user_id, 
        			strbank_no,
        			cvn2,
        			phone,
        			name,
        			certificate_code,
        			expire_date,
        			card_type,
        			bank_type,
        			"",//固定写死，奚总后面会有更新的操作，签约号
        			valid_flag, 
        			priority,
        			systradeno
        			);
        	
            if (iRet > 0)
            {
            	
            	//这个地方暂时注释掉，直接返回绑定成功就可以
            	//只需要调用奚总绑定接口_ximh_todo
//            	
//            	paramsRet=bindCard(
//            			systradeno,
//            			paramsMap.get("bank_no"),
//            			cvn2,
//            			expire_date,
//            			card_type,
//            			name, 
//            			certificate_code,
//            			phone
//            			);
//            	
//            	System.out.println(paramsRet);
////            	result.put("status", "E01");
////                result.put("detail", "支付失败！绑定日志插入失败");
            	
            	paramsRet=new HashMap<String, String>();
            	paramsRet.put("status", "00");
            	paramsRet.put("detail", "操作成功");
            }
            else {
				return "插入报错～";
			}
		}
    	
    	if (paramsRet.get("status").equals("00"))//成功
    	{
			return "ok";
		}
    	else {
    		return paramsRet.get("detail").toString();
		}
    }

    public Map<String, String> bindCard(String systradeno,String bank_no,String cvn2,String expire_date,String card_type,String name, String certificate_code,String phone)
    {
    	UnionPayParam param = new UnionPayParam();
    	
    	param.setBind_sys_trade_no(systradeno);  //接口日志流水号
    	param.setBank_card_no(bank_no);   //银行卡号
    	param.setBank_card_cvn(cvn2);  //cvn2
    	param.setBank_card_expire_date(expire_date); //有效期 1501
    	param.setCard_type(card_type);  //卡类型 信用卡:01或借记卡:02
    	param.setFull_name(name);   //姓名
    	param.setId_card_no(certificate_code); //身份证
    	param.setPhone_no(phone); //手机号
    	
    	return unionPayService2.bindCard(param);
    }
    
    
    @RequestMapping("/acct/bankCardDetail/{user_id}/{bank_no}")
    public ModelAndView initBankCardDetail(@PathVariable("user_id") String user_id,@PathVariable("bank_no") String bank_no)
    {
    	//银行卡详情 解绑银行卡
    	ModelAndView mav = new ModelAndView("bankCardDetail.ftl");
    	
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	
    	if (acctbankinfo !=null && acctbankinfo.size()>0) {
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
    	
    	byte[] bank_no=DESUtil.encryptMode(Constants.desKey.getBytes(),paramsMap.get("bank_no").getBytes());
    	String strbank_no=DESUtil.Bytes2HexString(bank_no);
    	
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id,paramsMap.get("bank_no"));
    	
    	if (acctbankinfo != null && acctbankinfo.size()>0) //有数据
    	{
        	//解绑 直接修改为不可用
        	int iRet=myAcctService.updateAcctBank(
        			acctbankinfo.get("USER_ID").toString(), 
        			strbank_no,//注意这个地方是加密的银行卡
        			acctbankinfo.get("CVN2").toString(),
        			acctbankinfo.get("PHONE").toString(),
        			acctbankinfo.get("NAME").toString(),
        			acctbankinfo.get("CERTIFICATE_CODE").toString(),
        			acctbankinfo.get("EXPIRE_DATE").toString(),
        			acctbankinfo.get("CARD_TYPE").toString(),
        			acctbankinfo.get("BANK_TYPE").toString(),
        			acctbankinfo.get("SIGN_CODE").toString(),
        			"3",//acctbankinfo.get("VALID_FLAG").toString()
        			acctbankinfo.get("PRIORITY").toString(),
        			acctbankinfo.get("SYS_TRADE_NO").toString()
        			);
        	if (iRet<0) 
        	{
        		return 2; //删除失败
    		}
        	return  3; //操作成功
    	}
    	return 2;
    }

    //隐藏接口，主要用于银行卡解密操作
    @RequestMapping("/acct/bankCardDecode/{user_id}/{bank_no}")
    @ResponseBody
    public Map<String, Object> bankCardDecode(@PathVariable("user_id") String user_id,@PathVariable("bank_no") String bank_no)
    {
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	return acctbankinfo;
    }
    //隐藏接口，主要用于账户银行卡的更新操作。同上，其实主要是为了防止用户输入错误的银行后由程序进行更新操作
    @RequestMapping("/acct/bankCardUpdate/{user_id}/{bank_no}")
    @ResponseBody
    public int bankCardUpdate(@PathVariable("user_id") String user_id,@PathVariable("bank_no") String bank_no)
    {    	
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id,bank_no);
    	
    	byte[] bbank_no=DESUtil.encryptMode(Constants.desKey.getBytes(),bank_no.getBytes());
    	String strbank_no=DESUtil.Bytes2HexString(bbank_no);
    	
    	if (acctbankinfo != null && acctbankinfo.size()>0) //有数据
    	{
        	//解绑 直接修改为不可用
        	int iRet=myAcctService.updateAcctBank(
        			acctbankinfo.get("USER_ID").toString(), 
        			strbank_no,//注意这个地方是加密的银行卡
        			acctbankinfo.get("CVN2").toString(),
        			acctbankinfo.get("PHONE").toString(),
        			acctbankinfo.get("NAME").toString(),
        			acctbankinfo.get("CERTIFICATE_CODE").toString(),
        			acctbankinfo.get("EXPIRE_DATE").toString(),
        			acctbankinfo.get("CARD_TYPE").toString(),
        			acctbankinfo.get("BANK_TYPE").toString(),
        			acctbankinfo.get("SIGN_CODE").toString(),
        			"1",//acctbankinfo.get("VALID_FLAG").toString()
        			acctbankinfo.get("PRIORITY").toString(),
        			acctbankinfo.get("SYS_TRADE_NO").toString()
        			);
        	if (iRet<0) 
        	{
        		return 0; //操作失败
    		}
        	return  1; //操作成功
    	}
    	return 0;//操作失败
    }    
}
