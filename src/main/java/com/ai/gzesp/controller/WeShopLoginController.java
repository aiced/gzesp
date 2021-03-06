/** 
 * @author 文辉
 * 微店登录
 */
package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.service.UserService;
import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/auth")
public class WeShopLoginController {
	
	@Resource
	TdAurDAUTHINFODao tdAurDAUTHINFODao;
	
    @Autowired
    private WeShopService weShopService;
    
	@Autowired
	private UserService userService;
    
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
    
    
/*    @RequestMapping("/checklogin")
    @ResponseBody
    public ModelAndView CheckLogin(@RequestBody String inputParams){
    	System.out.println(inputParams);
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String strPhoneNum = paramsMap.get("inputMobile");
    	String strPwd=MD5Util.md5s2(paramsMap.get("inputPassword"));
    	System.out.println(strPhoneNum);
    	System.out.println(strPwd);
    	
    	
    	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("PHONE_NUMBER", strPhoneNum).andEqualTo("USER_PASSWORD", strPwd);
 
    	List<TdAurDAUTHINFO> list = tdAurDAUTHINFODao.selectByExample(myCriteria);
    	ModelAndView mav = null;
    	ModelMap mmap=null;
    	if(list.size() >= 1) 
    	{
    		//mav = new ModelAndView("weShopHome.ftl");
    		mmap=new ModelMap();
            //从数据库获取信息赋值
    		//mmap.addAttribute("title", "我的微店");
//    		mmap.addAttribute("id", list.get(0).getId());
    		mmap.addAttribute("userid",list.get(0).getUserId());
//    		mmap.addAttribute("name", list.get(0).getUserName());//姓名
//    		mmap.addAttribute("storename", list.get(0).getStoreName());//姓名
//    		mmap.addAttribute("phone", list.get(0).getPhoneNumber()); //手机号
//    		mmap.addAttribute("weixin", list.get(0).getWeixinId()); //微信
    		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);            
    	} else {
    		ret="账号或密码不存在";
    		mav = new ModelAndView("redirect:/auth/login");
    	}
        return mav;
    }*/
    
    
    /**
     * 新的登陆入口，用shiro框架验证
     * @param inputParams
     * @return
     */
    @RequestMapping("/checklogin")
    @ResponseBody
    public ModelAndView checkLogin(@RequestBody String inputParams){
    	//获取入参里的手机号和密码，并将密码md5加密来和数据库比较
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String strPhoneNum = paramsMap.get("inputMobile");
    	String strPwd = MD5Util.md5s2(paramsMap.get("inputPassword")); //md5加密

        ModelAndView mav = null;
        ModelMap mmap=null;
        
		try {
			//手机号密码校验放这边了，其实应该放 EspRealm里面
			Map<Object, Object> userMap = userService.getUserInfoByPhonePassword(strPhoneNum, strPwd);
			//如果查到记录表示手机号密码正确，shiro里直接验证通过
			if(userMap != null){
				//调用shiro校验身份，EspRealm.doGetAuthenticationInfo(AuthenticationToken token)
				UsernamePasswordToken token = new UsernamePasswordToken(strPhoneNum, strPwd);
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
				
				//如果验证成功
				if (subject.isAuthenticated()) {
					//mav = new ModelAndView("weShopHome.ftl");
					org.apache.shiro.session.Session session = subject.getSession(true);
					session.setAttribute("mchId", userMap.get("MCH_ID"));
					
					mmap=new ModelMap();
	    		    mmap.addAttribute("userid", userMap.get("USER_ID"));
					mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);     
				}
				else{
					ret="账号或密码不存在";
					mav = new ModelAndView("redirect:/auth/login");
				}
			}
			else{
				ret="账号或密码不存在";
				mav = new ModelAndView("redirect:/auth/login");
			}
	        
		} catch (AuthenticationException e) {
			ret="账号或密码不存在";
    		mav = new ModelAndView("redirect:/auth/login");
		}

    	
        return mav;
    }
}
