package com.ai.gzesp.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
    /**
     * 根据手机号获取用户信息
     * @param user_id
     * @return
     */
    public Map<String, String> getUserInfoByPhone(String phone_number){
        return userDao.getUserInfoByPhone(phone_number);
    }
    

    /**
     * 根据手机号和登陆密码获取用户信息
     * @param phone_number
     * @param password
     * @return
     */
    public Map<Object, Object> getUserInfoByPhonePassword(String phone_number, String password){
        return userDao.getUserInfoByPhonePassword(phone_number, password);
    }
    

    /**
     * 根据user_id 获取 商户号
     * @param user_id
     * @return
     */
    public Map<String, String> getMchId(String user_id){
        return userDao.getMchId(user_id);
    }
    
    /**
     * 根据openid获取用户信息
     * @param open_id
     * @return
     */
    public Map<Object, Object> getUserInfoByOpenId(String open_id){
        return userDao.getUserInfoByOpenId(open_id);
    }
    
    /**
     * 根据能人手机号码，查询出绑定的bss工号密码和cbss工号密码，以及店铺昵称
     * @param phone_number
     * @return
     */
    public Map<String, String> getBusiInfo(String phone_number){
        //return userDao.getBusiInfo(phone_number);
    	//先获取userid，店名，地市，区县等基本信息
    	Map<String, String> userInfo = userDao.getUserInfoByPhone(phone_number);
    	if(MapUtils.isEmpty(userInfo)){
    		return null;
    	}
    	else{
    		//先找出该能人店铺是否有特殊的绑定的cb工号
    		Map<String, String> busiInfo = userDao.getBusiInfo(phone_number);
    		//如果没有绑定过，那就用该区县默认的参数
    		if(MapUtils.isEmpty(busiInfo)){
    			busiInfo = userDao.getDefaultBusiInfo(userInfo.get("EPARCHY_CODE"));//根据地市编码找默认
    		}
    		
    		userInfo.putAll(busiInfo); //合并2个map
			return userInfo;
    		
    	}
    }

}
