package com.ai.gzesp.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.beans.TdAurDRELINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.service.TdAurDBASEINFODao;
import com.ai.gzesp.dao.service.TdAurDRELINFODao;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.sql.RegistSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/auth")
public class WeShopRegist2Controller {

    @Autowired
    private WeShopService weShopService;
	
	
    @Resource 
    TdAurDAUTHINFODao tdAurDAUTHINFODao;
    
    @Resource 
    TdAurDRELINFODao tdAurDRELINFODao;
	
    @Resource
    TdAurDBASEINFODao tdAurDBASEINFODao;
    
    @RequestMapping("/register/step2")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopRegist2.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "注册微店");


        
        return mav;
    }
    
    @RequestMapping("/register/checkBankCard")
    @ResponseBody
    public Boolean checkBankCard(@RequestBody String strBankCard)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strBankCard);
    	String BankCard = paramsMap.get("BankCard");
    	return CommonUtil.checkBankCard(BankCard);
    }
    
    @RequestMapping("/register/reg_step2_postdata")
    public ModelAndView RegStep2_PostData(@RequestBody String inputParams)
    {
    	///插入数据需要用事务来处理：因为涉及到多表插入
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	Long LId=getID();
    	String strArea=paramsMap.get("selArea");//地区
    	String strPhoneNum = paramsMap.get("txtphonenum");//手机号
    	//String stryanzhengma=paramsMap.get("txtyanzhengma");//验证码
    	String strwecharaccount=paramsMap.get("txtwechataccount");//微信号
    	String strPwd=paramsMap.get("txtpassword");//密码
    	String strName=paramsMap.get("txtname");//姓名
    	String strSex=paramsMap.get("radsex");//性别
    	String strPersonalId=paramsMap.get("txtpersonalid");//身份证号
    	String strBank=paramsMap.get("selBank");//开户银行
    	String strBankCardId=paramsMap.get("txtbankcardid");//银行卡号
    	
    	
    	System.out.println("打印的数据");
    	System.out.println(LId);
    	System.out.println(strArea);
    	System.out.println(strPhoneNum);
    	System.out.println(strwecharaccount);
    	System.out.println(strPwd);
    	System.out.println(strName);
    	System.out.println(strSex);
    	System.out.println(strPersonalId);
    	System.out.println(strBank);
    	System.out.println(strBankCardId);
    	
    	
    	
    	//插入能人登录信息表
    	TdAurDAUTHINFO record_aurdauthinfo = new TdAurDAUTHINFO();
    	record_aurdauthinfo.setId(LId);//ID
    	record_aurdauthinfo.setUserId(LId.toString());//USER_ID用户名
    	record_aurdauthinfo.setUserName(strName);//USER_NAME
    	record_aurdauthinfo.setUserPassword(strPwd);//USER_PASSWORD
    	record_aurdauthinfo.setWeixinId(strwecharaccount); //WEIXIN_ID
    	record_aurdauthinfo.setPhoneNumber(strPhoneNum);//PHONE_NUMBER
    	record_aurdauthinfo.setStatus("00");//STATUS
    	record_aurdauthinfo.setStoreId(LId.toString());//STORE_ID
    	record_aurdauthinfo.setStoreName(strName);//STORE_NAME
    	//record.setCreateTime(DateUtil.getNow());
    	tdAurDAUTHINFODao.insertSelective(record_aurdauthinfo);
    	
    	//插入能人关系信息表
    	TdAurDRELINFO record_aurdrelinfo=new TdAurDRELINFO();
    	record_aurdrelinfo.setId(LId);//ID
    	record_aurdrelinfo.setUserId(LId.toString());//USER_ID用户名
    	record_aurdrelinfo.setDevlopId("100");//DEVLOP_ID
    	record_aurdrelinfo.setDevlopName("100");//DEVLOP_NAME
    	tdAurDRELINFODao.insertSelective(record_aurdrelinfo);
    	
    	//插入能人基础信息表
    	TdAurDBASEINFO record_aurdbaseinfo=new TdAurDBASEINFO();
    	record_aurdbaseinfo.setId(LId);//ID
    	record_aurdbaseinfo.setUserId(LId.toString());//USER_ID
    	record_aurdbaseinfo.setUserName(strName);//USER_NAME
    	record_aurdbaseinfo.setChannelType("05");//CHANNEL_TYPE
    	record_aurdbaseinfo.setChannelLevel("00");//CHANNEL_LEVEL
    	record_aurdbaseinfo.setSalesArea(strArea);//SALES_AREA
    	record_aurdbaseinfo.setCreateDate(DateUtil.getNow());//CREATE_DATE
    	record_aurdbaseinfo.setStatus("00");//STATUS
    	record_aurdbaseinfo.setIdentityType("00");//IDENTITY_TYPE
    	record_aurdbaseinfo.setIdentityNum(strPersonalId);//IDENTITY_NUM
    	record_aurdbaseinfo.setMobile(strPhoneNum);//MOBILE
    	record_aurdbaseinfo.setBankName(strBank);//BANK_NAME
    	record_aurdbaseinfo.setBankAcct(strBankCardId);//BANK_ACCT
    	tdAurDBASEINFODao.insertSelective(record_aurdbaseinfo);
    	 	
    	
    	ModelAndView mav = null;
    	ModelMap mmap=null;
		mmap=new ModelMap();
        //从数据库获取信息赋值
		mmap.addAttribute("title", "我的微店");
		mmap.addAttribute("id", LId.toString());
		mmap.addAttribute("userid",LId.toString());
		mmap.addAttribute("name", strName);//姓名
		mmap.addAttribute("phone", strPhoneNum); //手机号
		mmap.addAttribute("weixin", strwecharaccount); //微信
		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);     
    	
    	//ModelAndView mav = new ModelAndView("weShopLogin.ftl");
//    	ModelAndView mav = new ModelAndView("redirect:../../shopManage/weShopHome/");
//    	mav.addObject("title", "登录微店账号");
//    	mav.addObject("id",);
//    	mav.addObject("userid", attributeValue)
//    	mav.addObject("name", attributeValue);
//    	mav.addObject("phone", attributeValue);
//    	mav.addObject("weixin", attributeValue);
    	return mav;
    	
    } 
    
    
    //生成id
    //当前时间+2位随机码
    private Long getID()
    {
        Date date = new Date(); 
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); 
        //产生2位随机验证码
        String strCode="";
        for (int i = 0; i < 2; i++) {  
        	 
        	strCode += Integer.parseInt(new DecimalFormat("0").format(Math.random() * 9));  
        }
       //14位的时间+2位随机验证码，四舍五入之后转换成double并返回
        strCode=df.format(date)+strCode;
        System.out.println(strCode);
        Long lCode=Long.parseLong(strCode);
        return lCode;

    }
}
