package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWEIXINLOG;
import com.ai.gzesp.dao.service.TdPayDWEIXINLOGDao;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.entity.WebAuthAccessTokenModel;
import com.ai.wx.service.WebAuthService;
import com.ai.wxpay.WXPay;
import com.ai.wxpay.business.UnifiedOrderBusiness;
import com.ai.wxpay.common.RandomStringGenerator;
import com.ai.wxpay.common.Signature;
import com.ai.wxpay.common.Util;
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
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
    @Resource
	WebAuthService webAuthService;
    
    @Resource
    TdPayDWEIXINLOGDao tdPayDWEIXINLOGDao;
	
    @RequestMapping("/wxPay/prepay_step1/{order_id}/{fee}")
    public ModelAndView prepay_step1(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
    	// 授权回调页限制
    	String  redirect_uri = CommonUtil.appResource.getString("espRoot")+"/esp/pay/wxPay/prepay_step2/"+order_id+"/"+fee;
    	log.debug("redirect_uri-----"+redirect_uri);
    	String state = "";
    	String url = webAuthService.getRedirectUrl(DataConstants.appid, redirect_uri, state);
        return new ModelAndView("redirect:"+url);
    }
    
    
    @RequestMapping("/wxPay/prepay_step2/{order_id}/{fee}")
    @ResponseBody
    public ModelAndView prepay_step2(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee,
    		@RequestParam(value="code", required=true) String code,  HttpServletRequest req) throws Exception{
    	
    	WebAuthAccessTokenModel webToken =  webAuthService.getAccessToken(DataConstants.appid, DataConstants.appsecret, code);
    	ModelAndView mav = null;
		if (webToken != null) {
			String openId = webToken.getOpenid();
			if (openId == null) {
				mav = new ModelAndView("redirect:/pay/selectPayMode/"+"order_id"+"/"+fee);
			} else {
				mav = new ModelAndView("redirect:/pay/wxPay/prepay_step3");
				String body = "jsapi wx pay from unicom";
				String _out_trade_no = order_id;
				int _total_fee = Integer.parseInt(fee)/10;
				String realIp = req.getHeader("X-Real-IP");
				String _spbill_create_ip = "".equals(realIp) ? req.getRemoteAddr() : realIp;
				
				int port = req.getServerPort();
		    	String portStr = (80==port || 443 == port) ? "" : ":"+port;
		    	String _notify_url = req.getScheme() + "://" + req.getServerName() + portStr + "/" + req.getContextPath()+"/pay/wxPay/callback";
		    	log.debug("_notify_url-----"+_notify_url);
		    	
				String _trade_type = "JSAPI";
				UnifiedOrderReqData reqData = new UnifiedOrderReqData(body, _out_trade_no, _total_fee, _spbill_create_ip, _notify_url, _trade_type, openId);
				
				Map<String, String> result = new HashMap();
				UnifiedOrderResultListener resultListener = new UnifiedOrderResultListener(result);
				WXPay.doUnifiedOrderBusiness(reqData, resultListener);
				mav.addAllObjects(result);
			}
		}
		return mav;
    }
    
    @RequestMapping("/wxPay/prepay_step3")
    @ResponseBody
    public ModelAndView prepay_step3(HttpServletRequest req) {
    	ModelAndView mav = new ModelAndView("wxPrepay.ftl", req.getParameterMap());
    	return mav;
    }
    
    
    @RequestMapping("/wxPay/callback")
    public void callback(@RequestBody String responseString)	{
    	log.debug("responseString-----"+responseString);
    	TdPayDWEIXINLOG resData = (TdPayDWEIXINLOG) Util.getObjectFromXML(responseString, TdPayDWEIXINLOG.class);
    	
    	String transactionId = resData.getTransactionId();
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("TRANSACTION_ID", transactionId);
    	int count = tdPayDWEIXINLOGDao.countByExample(example);
    	// 过滤重复数据
    	if(count == 0) {
    		String logId = CommonUtil.generateLogId("2");
    		resData.setLogId(CommonUtil.string2Long(logId));
    		resData.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(logId)));
    		resData.setReqType("01");
    		Long totalFee = resData.getTotalFee();
    		Long cashFee = resData.getCashFee();
    		Long refundFee = resData.getRefundFee();
    		if(totalFee != null) {
    			resData.setTotalFee(totalFee*10);
    		}
    		if(cashFee != null) {
    			resData.setCashFee(cashFee*10);
    		}
    		if(refundFee != null) {
    			resData.setRefundFee(refundFee*10);
    		}
    		tdPayDWEIXINLOGDao.insertSelective(resData);
    		// TODO 更新订单状态，调用奚总的接口
    	}
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
//
//	@Override
//	public void onFailByReturnCodeError(UnifiedOrderResData resData) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFailByReturnCodeFail(UnifiedOrderResData resData) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFailBySignInvalid(UnifiedOrderResData resData) {
//		// TODO Auto-generated method stub
//		
//	}
	
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
