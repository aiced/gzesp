package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.SmsUtils;

@Controller
@RequestMapping("/customer")
public class WeShopCustRefundSuccessController {
    @Autowired
    private WeShopService weShopService;
	   @RequestMapping("/custRefundSuccess")
	    public ModelAndView index(@RequestParam(value = "orderid", required = false)String strOrderid,@RequestParam(value = "phonenum", required = false)String phonenum){
	    	
		   phonenum="18551855717";
	       String strRet=SmsUtils.doSendMessage(phonenum,"MB-2015052703","@1@="+strOrderid);
		   
		   
		   ModelAndView mav = new ModelAndView("custRefundSuccess.ftl");
	       mav.addObject("title", "申请退款");
	       mav.addObject("orderid",strOrderid);
	       mav.addObject("status",strRet);
	       return mav;
	    }
}
