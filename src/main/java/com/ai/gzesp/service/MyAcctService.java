package com.ai.gzesp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.MyAcctDao;

@Service
public class MyAcctService {

    @Autowired
    private MyAcctDao myAcctDao;
	
    public Map<String, String> queryAcctByUserId(String user_id) {
        return myAcctDao.queryAcctByUserId(user_id);
    }
}
