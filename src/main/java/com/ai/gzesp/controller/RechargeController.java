package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.dto.ResultCode;
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
	 * 对外围提供接口，开关
	 */
	@Value("${intf.recharge.open}")
	private String intf_recharge_open;

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
    	Map<String, String> result = rechargeService.rechargeQry(log_id);
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
    
    
    /**
     * 对外提供接口的总入口，根据intfType参数来判断不同的业务类型
     * 请求参数：{"reqParam":"xxxxx", "merId":"A0001", "md5Desc":"e12976e48620f97682d2dd251ddd2cde"}
     *  其中reqParam为des加密后base64编码的字符串，加密前原参数json如下：
     *  号码校验接口：{"intfType":"010201", "merId":"A0001", "reqTime":"20160824112200", "outTradeId":"1234567890123456", "phoneNumber":"18651885060"}
     *  充值接口：{"intfType":"010202", "merId":"A0001", "reqTime":"20160824112200", "outTradeId":"1234567890123456", "phoneNumber":"18651885060", "fee":"100"}
     *  充值查询接口：{"intfType":"010204", "merId":"A0001", "reqTime":"20160824112200", "outTradeId":"1234567890123456", "origOutTradeId":"1234567890123456"}
     *  充值对账接口：{"intfType":"010205", "merId":"A0001", "reqTime":"20160824112200", "outTradeId":"1234567890123456", "origOutTradeId":"1234567890123456"}
     * 返回参数：{"respCode":"0000", "respDesc":"充值成功", "data"："xxxxx"}
     * @param card_no
     * @return
     */
    @RequestMapping(value = "/intf/recharge", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<String> intfRecharge(@RequestBody Map<String, String> param){
    	RespInfo<String> respInfo = null; 
    	
    	//如果接口开关为true，才可以往下调用，否则直接返回错误
    	boolean open_flag = Boolean.parseBoolean(intf_recharge_open);
    	if(open_flag){
    		respInfo = rechargeService.intfRecharge(param); 
    	}
    	else{
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(ResultCode.ERR2000.getResultCode()); 
    		respInfo.setRespDesc(ResultCode.ERR2000.getResultName());
    	}

        return respInfo;
    }
    
    
}
