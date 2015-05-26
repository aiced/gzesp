package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.service.UnionPayService;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DESUtil;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;
import com.ai.wxpay.WXPay;
import com.ai.wxpay.business.UnifiedOrderBusiness;
import com.ai.wxpay.common.RandomStringGenerator;
import com.ai.wxpay.common.Signature;
import com.ai.wxpay.common.Util;
import com.ai.wxpay.protocol.pay_query_protocol.PayQueryResData;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderResData;

/**
 * 支付入口<br> 
 * 银联和支付宝都在此类里面
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/pay")
public class PayWXController {
    
    @RequestMapping("/wxPay/prepay")
    @ResponseBody
    public Map<String, String> prepay(@RequestBody Map<String, String> param, HttpServletRequest req) throws Exception{
    	
    	
    	String body = "jsapi wx pay from unicom";
    	String _out_trade_no = param.get("order_id");
    	int _total_fee = Integer.parseInt(param.get("fee"))/10;
    	String realIp = req.getHeader("X-Real-IP");
    	String _spbill_create_ip = "".equals(realIp) ? req.getRemoteAddr() : realIp;
    	String _notify_url = req.getServerPort()+"/"+req.getContextPath()+"/pay/wxPay/callback";
    	String _trade_type = "JSAPI";
    	// TODO
    	String _openid = "okhDVstuDQcv9hXYCTwZ2hR6e34s";
    	UnifiedOrderReqData reqData = new UnifiedOrderReqData(body, _out_trade_no, _total_fee, _spbill_create_ip, _notify_url, _trade_type, _openid);
    	
    	Map<String, String> result = new HashMap();
    	UnifiedOrderResultListener resultListener = new UnifiedOrderResultListener(result);
//    	try {
			WXPay.doUnifiedOrderBusiness(reqData, resultListener);
			return result;
//		} catch (Exception e) {
//			throws e;
//		}
//        return result;
    }    
    
    @RequestMapping("/wxPay/callback")
    public void callback(@RequestBody String responseString)	{
    	System.out.println(responseString);
    	PayQueryResData resData = (PayQueryResData) Util.getObjectFromXML(responseString, PayQueryResData.class);
    	System.out.println(resData);
    	// TODO 插数据库 PAY_D_WEIXIN_LOG 需要判断重复记录，区分交易类型
    }
    
}

class UnifiedOrderResultListener implements UnifiedOrderBusiness.ResultListener {
	private Map<String, String> result;
	
	UnifiedOrderResultListener(Map<String, String> _result) {
		if(_result == null) {
			_result = new HashMap<String, String>();
		}
		result = _result;
	}

	@Override
	public void onFailByReturnCodeError(UnifiedOrderResData resData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailByReturnCodeFail(UnifiedOrderResData resData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailBySignInvalid(UnifiedOrderResData resData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFail(UnifiedOrderResData resData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(UnifiedOrderResData resData) {
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String appid = resData.getAppid();
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String nonceStr = RandomStringGenerator.getRandomStringByLength(32);
		String prepay_id = "prepay_id="+resData.getPrepay_id();
		String packages = prepay_id;
		finalpackage.put("appId", appid);  
		finalpackage.put("nonceStr", nonceStr);  
		finalpackage.put("package", packages);  
		finalpackage.put("signType", "MD5");
		finalpackage.put("timeStamp", timestamp);  
		try {
			String finalsign = Signature.getSign(finalpackage);
			result.putAll(finalpackage);
			result.put("paySign", finalsign);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
