package com.ai.wx.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.wx.consts.DataConstants;
import com.ai.wx.service.CoreService;

@Service
public class WxTimeTask {

	@Resource
	public CoreService service;
	
    public void run(){   
         //执行的定时器任务  
		 System.out.println("执行的定时器任务  ");
		 DataConstants.accessToken = service.getAccessToken(DataConstants.appid, DataConstants.appsecret);
		 DataConstants.jsApiTicket = service.getJsApiTicket(DataConstants.accessToken);
    }     
}
