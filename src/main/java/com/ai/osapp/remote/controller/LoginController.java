package com.ai.osapp.remote.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ai.osapp.dao.beans.Criteria;
import com.ai.sysframe.utils.CommonUtil;

@Controller
public class LoginController extends BaseController {
	
    @RequestMapping(value="${adminPath}/login",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Map<String, Object> Login(@RequestBody Map<String, Object> inputParam) {
        boolean resultBool = true;
    	Map<String,Object> rspMap = new HashMap<String,Object>();
        final String passwd = (String) inputParam.get("passwd"); 
        final String phoneNum = (String) inputParam.get("phoneNum");
        
        try {
        	UsernamePasswordToken	token = new UsernamePasswordToken(phoneNum, passwd);
        	token.setRememberMe(true);
        	SecurityUtils.getSubject().login(token);
        	Subject subject = SecurityUtils.getSubject();
        	logger.debug(subject.toString());
        	
        } catch(Exception e) {
        	resultBool = false;
        }
    	
          if(resultBool) {
        	  
        	  rspMap.put("rspCode", "0000");
        	  rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
          } else {
        	  rspMap.put("rspCode", "9999");
            rspMap.put("rspDesc", CommonUtil.getMvcMsg("errorMsg"));
          }
        
        return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/logout",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> Logout() {
        Map<String,Object> rspMap = new HashMap<String,Object>();

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            rspMap.put("rspCode", "0000");
            rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            rspMap.put("rspCode", "9999");
            rspMap.put("rspDesc", CommonUtil.getMvcMsg("errorMsg"));
        }

        return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> Login() {
        Map<String,Object> rspMap = new HashMap<String,Object>();      
        
        rspMap.put("rspCode", "123456");
        rspMap.put("rspDesc", CommonUtil.getMvcMsg("notLoginError"));

        return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/notLogin")
    @ResponseBody
    public Map<String, Object> notLogin() {
    	Map<String,Object> rspMap = new HashMap<String,Object>();      
    	
    	rspMap.put("rspCode", "123456");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("notLoginError"));
    	
    	return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/unauthorized")
    @ResponseBody
    public Map<String, Object> unauthorized() {
    	Map<String,Object> rspMap = new HashMap<String,Object>();      
    	
    	rspMap.put("rspCode", "9999");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("unauthorized"));
    	
    	return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/error")
    @ResponseBody
    public Map<String, Object> error() {
    	Map<String,Object> rspMap = new HashMap<String,Object>();      
    	
    	rspMap.put("rspCode", "9999");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("errorMsg"));
    	
    	return rspMap;
    }
    
    @RequestMapping(value="${adminPath}/register",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map<String, Object> inputParam) {
        Map<String,Object> rspMap = new HashMap<String,Object>();

        final String passwd = (String) inputParam.get("passwd"); 
        final String phoneNum = (String) inputParam.get("phoneNum");
        
        Criteria crit = new Criteria();     	
    	crit.createConditon().andEqualTo("phoneNum", phoneNum);
    	
    	// TODO
    	List list = null;

		if (CollectionUtils.isEmpty(list)) {

			rspMap.put("rspCode", "0000");
			rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
		} else {
			rspMap.put("rspCode", "9999");
			rspMap.put("rspDesc", CommonUtil.getMvcMsg("registerError"));

		}
        

        return rspMap;
    }
    
//    @RequestMapping(value="${adminPath}/forget",method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Map<String, Object> forget(@RequestBody Map<String, Object> inputParam) {
//        Map<String,Object> rspMap = new HashMap<String,Object>();
//
//        final String userMail = (String) inputParam.get("userMail");
//        
//        Criteria crit = new Criteria();     	
//    	crit.createConditon().andEqualTo("USER_NAME", userMail);
//    	
//
//    	List<TdMUser> list = userDao.selectByExample(crit); 	 	
//
//    	if(CollectionUtils.isEmpty(list)) 
//    	{
//    		rspMap.put("rspCode", "9999");
//            rspMap.put("rspDesc", CommonUtil.getMvcMsg("existError"));
//    	}
//    	else
//    	{
//
//            String userPwd = getPwd();
//            MailUtil cn = new MailUtil();
//            
//            TdMUser tdMUser = new TdMUser();
//            
//    		tdMUser = list.get(0); 
//            
//    		tdMUser.setPassword(new Sha256Hash(userPwd,userMail,1).toBase64());
//    		
//    		userDao.updateByPrimaryKey(tdMUser);
//    		
//            // 设置发件人地址、收件人地址和邮件标题
//            cn.setAddress(CommonUtil.getAppMsg("mailUser"), userMail, "掌沃校园系统密码重置"); 
//            String message = "欢迎登陆掌沃系统，您的重置密码是:"+ userPwd +"。本邮件由系统自动发出，别回信哦！";
//            cn.send(message);
//            
//            rspMap.put("rspCode", "0000");
//            rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
//    	}
//        
//
//        return rspMap;
//    }
    
//    @RequestMapping(value="${adminPath}/queryVersion",method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Map<String, Object> queryVersion(@RequestBody Map<String, Object> inputParam) {
//        Map<String,Object> rspMap = new HashMap<String,Object>();
//        
//        final String fromSystem = (String) inputParam.get("fromSystem");
//        
//        if ("IOS".equals(fromSystem))
//        {
//        	rspMap.put("appVersion", systemParamDao.selectByPrimaryKey("IOS_SYSTEM_VERSION").getValue());
//        	rspMap.put("appVersionLowest", systemParamDao.selectByPrimaryKey("IOS_SYSTEM_VERSION_LOWEST").getValue());
//        }
//        else
//    	{
//    		rspMap.put("appVersion", systemParamDao.selectByPrimaryKey("ANDROID_SYSTEM_VERSION").getValue());
//        	rspMap.put("appVersionLowest", systemParamDao.selectByPrimaryKey("ANDROID_SYSTEM_VERSION_LOWEST").getValue());
//    	}
//
//    	rspMap.put("rspCode", "0000");
//        rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
//    	
//
//        return rspMap;
//    }
    
    
    
//    public char[] getChar()
//    {
//        char[] passwordLit = new char[62];
//        char fword = 'A';
//        char mword = 'a';
//        char bword = '0';
//        for (int i = 0; i < 62; i++) {
//            if (i < 26) {
//                passwordLit[i] = fword;
//                fword++;
//            }else if(i<52){
//                passwordLit[i] = mword;
//                mword++;
//            }else{
//                passwordLit[i] = bword;
//                bword++;
//            }//方法的抽取，按功能
//            //System.out.println(passwordLit[i]);
//        }
//     return passwordLit;
//    }
//    
//    public String getPwd()
//    {
//    	String pwd = "";
//    	char[] r = getChar();
//        Random rr = new Random();
//        char[] pw= new char[6];
//        
//        for(int i=0;i<pw.length;i++){
//            int num = rr.nextInt(62);
//            pw[i]=r[num];
//            pwd += pw[i];
//        }
//    	return pwd;
//    }
}
