package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WoPayService;

@Controller
@RequestMapping("pay/wopay")
public class WoPayOrderPostController {
	
	@Autowired
	private WoPayService woPayService;
	
	
    @RequestMapping("/orderPost/{order_id}/{fee}/{flag}")
    public ModelAndView index(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee,@PathVariable("flag") String flag){
        ModelAndView mav = new ModelAndView("woPayOrderPost.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "沃支付");
        
		//String url="http://123.125.97.67:8802/sy2_mini24_cs/httpservice/wapPayPageAction.do?reqcharset=UTF-8";
		String url="https://epay.10010.com/symini/httpservice/wapPayPageAction.do?reqcharset=UTF-8";
		fee=Integer.parseInt(fee)/10 + "";
		String strRet=woPayService.payOrder(url,order_id,fee,flag);
        mav.addObject("postdata",strRet);
        return mav;
    }
}
