package com.ai.gzesp.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.bssintf.ExistedCustomer;
import com.ai.gzesp.bssintf.NumInfo;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.service.BssIntfService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.wxpay.common.MD5;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Resource
	private BssIntfService bssIntfService;

    @RequestMapping("/test1")
    public ModelAndView test1(){
    	
        ModelAndView mav = new ModelAndView("test1.ftl");
        return mav;
    }
    
    @RequestMapping("/test2")
    @ResponseBody
    public Map<String, String> test2(@RequestBody List<Map<String, String>> paramList)
    {
    	//返回map
    	Map<String, String> result = new HashMap<String, String>();
    	
    	
    	return result;
    } 
    
    @RequestMapping("/test3")
    @ResponseBody
    public Map<String, String> test3()
    {
    	//返回map
    	Map<String, String> result = new HashMap<String, String>();
    	
		String right = "BD6660EE405673BFC3BB01F918D60B9D";
		System.out.println("微信网页：" + right);
		
		String old = "appid=wx52db41a405183edb&body=【一年卡】12GB上网卡 含2GB全国流量 10GB省内流量 ！&device_info=WEB&mch_id=1241798102&nonce_str=5nniy9lekkrj8q6m2eu7ru2iz7z8ryhr&notify_url=http://wap.woboss.gz186.com/esp/pay/wxPay/callback&openid=okhDVstTJONDmyjrXBnIt44cryrc&out_trade_no=1331439346849965&spbill_create_ip=182.131.12.12&total_fee=15900&trade_type=JSAPI&key=0sbd781d015ca667d6eba25e609fuck3";
		
		String newStr1 = MD5.MD5Encode(old);
		System.out.println("徐总加密：" + newStr1);
		result.put("徐总加密", newStr1);
		
		String newStr2 = MD5Util.md5s2(old);
		System.out.println("银联加密：" + newStr2);
		result.put("银联加1", newStr2);
		
		String newStr3 = MD5Util.md5s2(old, "0sbd781d015ca667d6eba25e609fuck3");
		System.out.println("银联加密：" + newStr3);
		result.put("银联加2", newStr3);
		
		String newStr4 = md5s2(old);
		System.out.println("银联加密：" + newStr4);
		result.put("银联加3", newStr4);
		
		String newStr5 = md5s3(old);
		System.out.println("银联加密：" + newStr5);
		result.put("银联加4", newStr5);
    	
    	return result;
    }
    
    public String md5s2(String plainText)
    {
      StringBuffer buf = new StringBuffer("");
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try {
          md.update(plainText.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
        byte[] b = md.digest();

        for (int offset = 0; offset < b.length; offset++) {
          int i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          buf.append(Integer.toHexString(i));
        }
        return buf.toString();
      }
      catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }

      return buf.toString();
    }   
    
    public String md5s3(String plainText)
    {
      StringBuffer buf = new StringBuffer("");
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
        byte[] b = md.digest();

        for (int offset = 0; offset < b.length; offset++) {
          int i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          buf.append(Integer.toHexString(i));
        }
        return buf.toString();
      }
      catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }

      return buf.toString();
    }  
    
    
    @RequestMapping("/bssIntfTest")
    public ModelAndView test4()
    {
    	ModelAndView mav = new ModelAndView("bssIntfTest.ftl");
    	
    	
    	return mav;
    } 
    
    @RequestMapping(value="/callIntfCheckCust", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<ExistedCustomer> callIntfCheckCust(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfCheckCust(param);
    	
    }
    
    @RequestMapping(value="/callIntfUserCheck", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfUserCheck(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfUserCheck(param);
    	
    } 

    @RequestMapping(value="/callIntfNumQuery", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<List<NumInfo>> callIntfNumQuery(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfNumQuery(param);
    	
    } 
    
    @RequestMapping(value="/callIntfCheckRes", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfCheckRes(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfCheckRes(param);
    	
    }
    
    @RequestMapping(value="/callIntfCheckRule", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfCheckRule(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfCheckRule(param);
    	
    }
    
    @RequestMapping(value="/callIntfAccount", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfAccount(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfAccount(param);
    	
    }
    
    @RequestMapping(value="/callIntfOrderSub", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfOrderSub(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfOrderSub(param);
    	
    }
    
    @RequestMapping(value="/callIntfGetCardData", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfGetCardData(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfGetCardData(param);
    	
    }
    
    @RequestMapping(value="/callIntfWriteCard", method = RequestMethod.POST)
    @ResponseBody
    public RespInfo<Map<String, String>> callIntfWriteCard(@RequestBody Map<String, Object> param){
    	return bssIntfService.callIntfWriteCard(param);
    	
    }     
}
