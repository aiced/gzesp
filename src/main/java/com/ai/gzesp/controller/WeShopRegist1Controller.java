package com.ai.gzesp.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.dao.sql.RegistSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/auth")
public class WeShopRegist1Controller {

    @Resource
    TdAurDAUTHINFODao tdAurDAUTHINFODao;
    
	@Autowired
    private WeShopService weShopService;
	@Resource 
	RegistSql registSql;

    @RequestMapping("/register/step1")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopRegist1.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "注册微店");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        List<Map<String, Object>> cityList=registSql.getCityList("85");
        
        mav.addObject("cityList", cityList);
        
        return mav;
    }
    @RequestMapping("/register/checkPhoneNum")
    @ResponseBody
    public Boolean checkPhoneNum(@RequestBody String strPhoneNum)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strPhoneNum);
    	String PhoneNum = paramsMap.get("PhoneNum");
    	System.out.println(PhoneNum);
    	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("PHONE_NUMBER", PhoneNum);
    	int count = tdAurDAUTHINFODao.countByExample(myCriteria);
    	System.out.println(count);
    	if(count >= 1) {
    		return false; //该账户已经注册了
            
    	} else {
    		return true;//没有注册过
    	}
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
