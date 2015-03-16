package com.ai.gzesp.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.epfl.lamp.fjbg.Main;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/auth")
public class WeShopRegist1Controller {
    @Autowired
    private WeShopService weShopService;

    @RequestMapping("/register/step1")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopRegist1.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "注册微店");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        return mav;
    }
    @RequestMapping("/register/reg_step1_postdata")
    @ResponseBody
    public ModelAndView RegStep1_PostData(@RequestBody String inputParams){
    	System.out.println(inputParams);
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	//Double bId=getID();
    	String strArea=paramsMap.get("selArea");//地区
    	String strPhoneNum = paramsMap.get("txtphonenum");//手机号
    	//String stryanzhengma=paramsMap.get("txtyanzhengma");//验证码
    	String strwecharaccount=paramsMap.get("txtwechataccount");//微信号
    	String strPwd=paramsMap.get("txtpassword");//密码
    	
    	//System.out.println(bId);
    	System.out.println(strArea);
    	System.out.println(strPhoneNum);
    	System.out.println(strwecharaccount);
    	System.out.println(strPwd);

    	
    	ModelAndView mav = new ModelAndView("weShopRegist2.ftl");
        //从数据库获取信息赋值
    	mav.addObject("title", "注册微店"); //页面title
        mav.addObject("area",strArea);//销售区域
        mav.addObject("phonenum", strPhoneNum); 
        mav.addObject("weixin", strwecharaccount); 
        mav.addObject("pwd", strPwd); 

        
        
        return mav;
    }

}
