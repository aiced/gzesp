/** 
 * @author 文辉
 * 微店登录
 */
package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/auth")
public class WeShopLoginController {
	
	@Resource
	TdAurDAUTHINFODao tdAurDAUTHINFODao;
	
    @Autowired
    private WeShopService weShopService;
    
    private String ret="";//记录返回的结果
    
    @RequestMapping("/login")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("weShopLogin.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "登录微店账号");
        mav.addObject("ret", ret);
        ret="";
        return mav;
    }
    @RequestMapping("/checklogin")
    @ResponseBody
    public ModelAndView CheckLogin(@RequestBody String inputParams){
    	System.out.println(inputParams);
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String strPhoneNum = paramsMap.get("inputMobile");
    	String strPwd=paramsMap.get("inputPassword");
    	System.out.println(strPhoneNum);
    	System.out.println(strPwd);
    	
    	
    	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("PHONE_NUMBER", strPhoneNum).andEqualTo("USER_PASSWORD", strPwd);
    	int count = tdAurDAUTHINFODao.countByExample(myCriteria);
    	ModelAndView mav = null;
    	if(count == 1) {
    		mav = new ModelAndView("weShopHome.ftl");
            //从数据库获取信息赋值
            mav.addObject("title", "我的微店");
            mav.addObject("name", "喻露露");
            mav.addObject("phone", "18685292522"); 
            mav.addObject("weixin", "1306520198@qq.com"); 
            
    	} else {
    		ret="账号或密码不存在";
    		mav = new ModelAndView("redirect:/auth/login");
    	}
        return mav;
    }
    
}
