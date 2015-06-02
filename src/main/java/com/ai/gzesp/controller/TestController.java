package com.ai.gzesp.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.PathUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.service.MaterialService;
import com.ai.wx.util.SignUtils;
import com.ai.wxpay.WXPay;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Resource
	MaterialService materialService;
    
    @RequestMapping("/wxPay/prepay")
    @ResponseBody
    public Map<String, Object> prepay(@RequestBody Map<String, String> param, HttpServletRequest req) throws Exception{
    	
    	
    	String body = "jsapi wx pay from unicom";
    	String _out_trade_no = param.get("order_id");
    	int _total_fee = Integer.parseInt(param.get("fee"))/10;
    	String realIp = req.getHeader("X-Real-IP");
    	String _spbill_create_ip = "".equals(realIp) ? req.getRemoteAddr() : realIp;
    	String _notify_url = "http://"+req.getServerName()+"/"+req.getContextPath()+"/pay/wxPay/callback";
    	String _trade_type = "JSAPI";
    	// TODO
    	String _openid = "okhDVstuDQcv9hXYCTwZ2hR6e34s";
    	UnifiedOrderReqData reqData = new UnifiedOrderReqData(body, _out_trade_no, _total_fee, _spbill_create_ip, _notify_url, _trade_type, _openid);
    	
    	Map<String, Object> result = new HashMap();
    	UnifiedOrderResultListener resultListener = new UnifiedOrderResultListener(result);
//    	try {
			WXPay.doUnifiedOrderBusiness(reqData, resultListener);
			return result;
//		} catch (Exception e) {
//			throws e;
//		}
//        return result;
    }    
    
    @RequestMapping("/wxjs")
    public ModelAndView wxjs(@RequestBody String responseString, HttpServletRequest req)	{
    	ModelAndView mav = new ModelAndView("testWXJs.ftl");
    	
//		String url = req.getRequestURL().toString();
    	int port = req.getServerPort();
    	String portStr = (80==port || 443 == port) ? "" : ":"+port;
		String url =  req.getScheme() + "://" + req.getServerName() + portStr + req.getRequestURI();
		Map<String, String> signInfo = SignUtils.jsApiSign(DataConstants.jsApiTicket, url);
		signInfo.put("appId",  DataConstants.appid);  
		
		mav.addAllObjects(signInfo);
		return mav;
    }
    
    @RequestMapping("/getMedia")
    @ResponseBody
    public void getMedia(@RequestBody String responseString, HttpServletRequest req) throws IOException	{
    	String mediaId = "p1CWLaO3MRjrSj5tKgwCfXw6GUoBJUkmEuSvfhiH_4VVNR4WqpFCphMl9j7sAmvm";
    	byte[] content = materialService.getTempMedia(DataConstants.accessToken, mediaId);
    	String upToPath = PathUtil.WEB_ROOT_PARENT_PATH 
	    		  + "uploadfile"
	    		  + File.separator
	    		  + PathUtil.WEB_UPLOAD_PATH 
	    		  + DateUtil.getCurrentYearMonth()
	    		  + File.separator
	    		  + "320101198812121234" 
	    		  + File.separator;
    	
		File upFile = new File(upToPath);
		if (!upFile.exists()) {
			upFile.mkdirs();
		}
	      
    	 FileCopyUtils.copy(content, new File(upToPath + mediaId));
    }
    
}
