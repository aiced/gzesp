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
     * 作废，新方案中，esp不需要激活卡，直接从bss导出卡就已经是激活过的了
     * 激活全部卡，启动激活卡的job调度
     * @return
     */
    @RequestMapping("/active")
    @ResponseBody
    public Map<String, String> active(){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.activeCardsJob(); 
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 作废，新方案中，esp不需要激活卡，直接从bss导出卡就已经是激活过的了
     * 激活某一面值的卡，比如20面值的没有了，需要激活部分20面值的卡，不启动激活卡的job调度
     * @param card_value
     * @return
     */
    @RequestMapping("/activeCards/{card_value}")
    @ResponseBody
    public Map<String, String> activeCards(@PathVariable("card_value") String card_value){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.activeCards(card_value); 
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }    
    
    /**
     * 作废，新方案中，esp不需要激活卡，直接从bss导出卡就已经是激活过的了
     * 激活全部卡，启动激活卡的job调度
     * @param card_no
     * @return
     */
    @RequestMapping("/active/{card_no}")
    @ResponseBody
    public Map<String, String> active(@PathVariable("card_no") String card_no){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.activeCard(card_no); 
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 充值验证入口
     * A7业务号码类型：1 GSM；2 固话；3 宽带；4 小灵通或大灵通
     * 返回 json 成功：{"status":"00000", "detail":"成功"}， 失败 {"status":"xxx", "detail":"失败原因"}
     * @param serial_number
     * @return
     */
    @RequestMapping("/rechargeCheck/{serial_number}/{serial_number_type}")
    @ResponseBody
    public Map<String, String> rechargeCheck(@PathVariable("serial_number") String serial_number,
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
    	
    	rechargeService.checkBillJob();
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 单条充值记录对账
     * @param log_id
     * @return
     */
    @RequestMapping("/check/{log_id}")
    @ResponseBody
    public Map<String, String> check(@PathVariable("log_id") String log_id){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.checkBill(log_id);
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 单条充值记录查询
     * @param log_id
     * @return
     */
    @RequestMapping("/rechargeQry/{log_id}")
    @ResponseBody
    public Map<String, String> rechargeQry(@PathVariable("log_id") String log_id){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	try {
    		//发送查询接口请求
			rechargeService.rechargeQry(log_id);
			//等待一卡充响应结果
			rechargeService.waitForRechargeRqyResp(log_id, result);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "FAIL");
            result.put("detail", "充值查询未知异常！");
		}
   	
//		result.put("status", "SUCCESS");
//        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * 沃掌柜和bss系统 同步一卡充状态 ,手工调用
     * @return
     */
    @RequestMapping("/syncCardStatus2Bss")
    @ResponseBody
    public Map<String, String> syncCardStatus2Bss(){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.syncCardStatus2BssJob();
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
    
    /**
     * bss系统给沃掌柜的回执文件 ,手工调用
     * @return
     */
    @RequestMapping("/syncCardStatus2BssResp")
    @ResponseBody
    public Map<String, String> syncCardStatus2BssRespJob(){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	rechargeService.syncCardStatus2BssRespJob();
    	
		result.put("status", "SUCCESS");
        result.put("detail", "请求成功！");
        return result;
    }
}
