package com.ai.gzesp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.WeShopDao;

@Service
public class WeShopService {

    @Autowired
    private WeShopDao weShopDao;
    
    public List<Map<Object, Object>> getInfo(String startMon, String endMon){
        return weShopDao.getInfo(startMon, endMon);
    }
}
