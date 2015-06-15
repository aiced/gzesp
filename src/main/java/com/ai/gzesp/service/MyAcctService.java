package com.ai.gzesp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.MyAcctDao;

@Service
public class MyAcctService {

    @Autowired
    private MyAcctDao myAcctDao;
	//通过userid 获得账户信息
    public Map<String, String> queryAcctByUserId(String user_id) {
        return myAcctDao.queryAcctByUserId(user_id);
    }
    
    //插入数据 密码表
    public int insertAcctPwd(String user_id,String user_pwd){
    	return myAcctDao.insertAcctPwd(user_id,user_pwd);
    }
    //更新数据 密码表
    public int updateAcctPwd(String user_id,String user_pwd){
    	return myAcctDao.updateAcctPwd(user_id,user_pwd);
    }
    //通过userid获得绑定银行卡信息
    public Map<String, String> queryAcctBankByUserId(String user_id)
    {
        return myAcctDao.queryAcctBankByUserId(user_id);
    }
    
    //通过账号和密码判断是否为该用户
    public Map<String, String> queryAcctByUserId_UserPwd(String user_id,String user_pwd)
    {
    	return myAcctDao.queryAcctByUserId_UserPwd(user_id,user_pwd);
    }
}
