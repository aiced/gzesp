package com.ai.gzesp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    
    public String getInfo(){
        return null;
    }
}
