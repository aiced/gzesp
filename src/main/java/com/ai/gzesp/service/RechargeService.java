package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ai.gzesp.recharge.RechargeUtil;

/**
 * 充值缴费service
 * @author xmh
 *
 */
@Service
public class RechargeService {
	
    private static final Logger log = Logger.getLogger(RechargeService.class); 
	
	public void recharge(int total_fee){
		//l	A4交易类型（6位）： 010202，010203，010204，010205，010206，010201
		//l	A6业务号码:移动电话号码、固话号码、宽带帐号，小灵通/大灵通或固定值
		//l	A7业务号码类型(1位):1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
		//l	A13请求时间（12位）：YYMMDDHHMMSS
		//  A2流水号（20位）：业务流水号，标志每笔具体交易 String logId = generateLogId();
		log.debug("【充值】需要充值" + total_fee + "厘，开始计算充值卡面额组合");
		int temp_fee = total_fee/1000; //单位换成元
		
		RechargeUtil.startCompute(temp_fee);
	}
	
  
	
	
	
	public static void main(String[] args) {
		int total_fee = 1000;
	    int[] array = {1000, 500, 300, 100};
	    
/*	    Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
	    
	    compute(total_fee, 0, groups);*/
		
		System.out.println(Math.floor(total_fee/array[0]));
		System.out.println((int)Math.floor(total_fee/array[0]));
	}
}
