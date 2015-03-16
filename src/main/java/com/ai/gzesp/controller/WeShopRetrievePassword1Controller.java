/** 
 * @author 文辉
 * 注册1
 */
package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/auth")
public class WeShopRetrievePassword1Controller {
    @Autowired
    private WeShopService weShopService;
	
    @RequestMapping("/findPassword/step1")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("retrievePassword1.ftl");
//        //从数据库获取信息赋值
        mav.addObject("title", "忘记密码");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        return mav;
    }
    @RequestMapping("/findPassword/findpwd_step1_postdata")
    @ResponseBody
    public ModelAndView FindPwdStep1_PostData(@RequestBody String inputParams)
    {
    	System.out.println(inputParams);
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String strPhoneNum=paramsMap.get("txtphonenum");//手机号
    	
    	System.out.println(strPhoneNum);
    	
    	
    	ModelAndView mav = new ModelAndView("retrievePassword2.ftl");
        //从数据库获取信息赋值
    	mav.addObject("title", "忘记密码"); //页面title
        mav.addObject("phonenum", strPhoneNum); 

    	return  mav;
    	
    	
    	
    }
    
    
}
