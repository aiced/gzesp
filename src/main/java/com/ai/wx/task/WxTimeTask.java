package com.ai.wx.task;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.wx.consts.DataConstants;
import com.ai.wx.service.CoreService;
import com.ai.wx.service.PayBillService;
import com.ai.wx.util.DateUtils;

@Service
public class WxTimeTask {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	public CoreService service;
	
    public void run(){   
         //执行的定时器任务  
    	log.info("执行的定时器任务--accessToken----jsApiTicket");
		 DataConstants.accessToken = service.getAccessToken(DataConstants.appid, DataConstants.appsecret);
		 DataConstants.jsApiTicket = service.getJsApiTicket(DataConstants.accessToken);
    }     
    
    @Resource
	public PayBillService billService;
    public void runBill(){ 
    	log.info("执行的定时器任务--微信对账单");
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	cal.add(Calendar.DAY_OF_MONTH, -1);
    	String tradeDay_YYYYMMDD = DateUtils.format(cal.getTime());
    	try {
			billService.downloadBill(tradeDay_YYYYMMDD);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
    }
}
