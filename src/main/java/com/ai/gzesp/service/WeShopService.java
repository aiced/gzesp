package com.ai.gzesp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.WeShopDao;

@Service
public class WeShopService {

    @Autowired
    private WeShopDao weShopDao;
    
    public String getInfo(){
        return null;
    }
}
