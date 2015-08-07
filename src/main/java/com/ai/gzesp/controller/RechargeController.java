package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.gzesp.service.RechargeService;

/**
 * @author xmh
 * 一卡充controller，联调测试用，正式场景不用controller，直接用service
 */
@Controller
@RequestMapping("/recharge")
public class RechargeController {
	
	@Resource
	private RechargeService rechargeService;

    /**
     * 激活全部卡，启动激活卡的job调度
     * @param card_no
     * @return
     */
    @RequestMapping("/active")
    @ResponseBody
    public Map<String, String> active(){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.activeCardsJob(null); 
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 激活全部卡，启动激活卡的job调度
     * @param card_no
     * @return
     */
    @RequestMapping("/active/{card_no}")
    @ResponseBody
    public Map<String, String> active(@PathVariable("card_no") String card_no){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.activeCardsJob(card_no); 
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 充值验证入口
     * @param serial_number
     * @return
     */
    @RequestMapping("/rechargeCheck/{serial_number}/{serial_number_type}")
    @ResponseBody
    public Map<String, String> recharge(@PathVariable("serial_number") String serial_number,
    		@PathVariable("serial_number_type") String serial_number_type){
    	
    	Map<String, String> result = rechargeService.rechargeCheck(serial_number, serial_number_type); 
        return result;
    }
    
    /**
     * 充值入口
     * @param card_no
     * @return
     */
    @RequestMapping("/recharge/{order_id}/{serial_number}/{serial_number_type}/{total_fee}")
    @ResponseBody
    public Map<String, String> recharge(@PathVariable("order_id") String order_id, @PathVariable("serial_number") String serial_number,
    		@PathVariable("serial_number_type") String serial_number_type, @PathVariable("total_fee") int total_fee){
    	
    	Map<String, String> result = rechargeService.recharge(order_id, serial_number, serial_number_type, total_fee); 
        return result;
    }

    /**
     * 所有充值记录对账
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public Map<String, String> check(){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.checkBillJob(null);
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 单条充值记录对账
     * @param card_no
     * @return
     */
    @RequestMapping("/check/{log_id}")
    @ResponseBody
    public Map<String, String> check(@PathVariable("log_id") String log_id){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.checkBillJob(log_id);
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
}
