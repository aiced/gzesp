package com.ai.gzesp.wopay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scala.annotation.meta.param;

import com.ai.gzesp.service.PayService;
import com.ai.gzesp.service.WoPayService;
import com.ai.sysframe.utils.StringUtil;


@Controller
public class WoPayController {

	
	@Autowired
	private WoPayService woPayService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping("/pay/woPay/payReq/{order_id}/{fee}/{flag}")
	@ResponseBody
	public String woPayOrder(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee,@PathVariable("flag") String flag)
	{
		System.out.println("woPay_orderid="+order_id);
		System.out.println("woPay_orderid="+fee);
		System.out.println("woPay_flag="+flag);
		//沃支付请求地址 正式用
		String url="https://epay.10010.com/symini/httpservice/wapPayPageAction.do?reqcharset=UTF-8"; 
		//沃支付请求地址 测试用
		//String url="http://123.125.97.67:8802/sy2_mini24_cs/httpservice/wapPayPageAction.do?reqcharset=UTF-8";
		fee=Integer.parseInt(fee)/10 + "";
		// 1.借记卡 2.信用卡
		String strRet=woPayService.payOrder(url,order_id,fee,flag);
		return strRet;
	}
	
	@RequestMapping("/pay/woPay/payQuery/{order_id}")
	public String woQueryOrder(@PathVariable("order_id") String order_id)
	{
		
		System.out.println("woPay_orderid="+order_id);
		String url="https://123.125.97.66:8085/pay/query/order.htm";
		String strRet=WoPayService.queryOrder(url,order_id);
		return strRet;
	}
	
	
	@RequestMapping("/payResult/woPay")
	public ModelAndView woResult(@RequestBody String inputParams)
	{
		//String strRet=woPayService.callBackResult(inputParams);
        System.out.println("回调");
        ModelAndView mav = new ModelAndView("woPayOrderPost.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "沃支付");
        return mav;
	}
	
	@RequestMapping("/payResult/woPayAsyn")
	public ModelAndView woResultAsyn(@RequestBody String inputParams)
	{
		String strRet=woPayService.callBackResultAsyn(inputParams);
        System.out.println("异步回调");
        ModelAndView mav = new ModelAndView("woPayOrderPost.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "沃支付");
        return mav;
		
	}
}
