/** 
 * @author 文辉
 * 注册2
 */
package com.ai.gzesp.controller;

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
import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/auth")
public class WeShopRetrievePassword2Controller {
	

    @Autowired
    private WeShopService weShopService;

	@Resource 
	TdAurDAUTHINFODao tdAurDAUTHINFODao;
	
    
    @RequestMapping("/findPassword/step2")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("retrievePassword2.ftl");
//        //从数据库获取信息赋值
        mav.addObject("title", "忘记密码");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
        
        return mav;
    }
    
    @RequestMapping("/findPassword/findpwd_step2_postdata")
    @ResponseBody
    public ModelAndView FindPwdStep1_PostData(@RequestBody String inputParams)
    {
    	///插入数据需要用事务来处理：因为涉及到多表插入
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String strPhoneNum = paramsMap.get("txtphonenum");//手机号
    	String strPwd=MD5Util.md5s2(paramsMap.get("txtpassword"));//密码
    	
    	System.out.println(strPhoneNum);
    	System.out.println(strPwd);
    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("PHONE_NUMBER", strPhoneNum);
    	
    	TdAurDAUTHINFO record = new TdAurDAUTHINFO();
    	record.setUserPassword(strPwd);
    	
    	tdAurDAUTHINFODao.updateByExampleSelective(record, example);
    	//ModelAndView mav = new ModelAndView("weShopLogin.ftl");
    	ModelAndView mav = new ModelAndView("redirect:/auth/login");
    	
    	mav.addObject("title", "登录微店账号");
    	return mav;
    	
    }
}
