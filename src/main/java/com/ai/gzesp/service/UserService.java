package com.ai.gzesp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map<Object, Object> getUserInfoByPhone(String phone_number){
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
     * 根据openid获取用户信息
     * @param open_id
     * @return
     */
    public Map<Object, Object> getUserInfoByOpenId(String open_id){
        return userDao.getUserInfoByOpenId(open_id);
    }
    


}
