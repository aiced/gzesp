package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class WeShopOrderDetailController {
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/orderDetail")
    public ModelAndView index(@RequestBody String inputParams){
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	System.out.println(paramsMap);
        ModelAndView mav = new ModelAndView("orderDetail.ftl");

        String strOrderid=paramsMap.get("ORDER_ID");
        String strGoodesName=paramsMap.get("GOODS_NAME");
        String strInCome_Money=paramsMap.get("INCOME_MONEY");
        String strOrder_Time=paramsMap.get("Order_Time");
        String strReceiver_Name=paramsMap.get("RECEIVER_NAME");
        String strPost_addr=paramsMap.get("POST_ADDR");
        String strMobile_phone=paramsMap.get("MOBILE_PHONE");
        String strDeliver_time_code=paramsMap.get("DELIVER_TIME_CODE");
        String strPay_Mode=paramsMap.get("PAY_MODE");
        String strPay_State=paramsMap.get("PAY_STATE");
        String strPay_Remark=paramsMap.get("PAY_REMARK");
        
        
        //从数据库获取信息赋值
        mav.addObject("title", "订单详情");
        mav.addObject("ORDER_ID",strOrderid);
        mav.addObject("GOODS_NAME",strGoodesName);
        mav.addObject("INCOME_MONEY",strInCome_Money);
        mav.addObject("Order_Time",strOrder_Time);
        mav.addObject("RECEIVER_NAME",strReceiver_Name);
        mav.addObject("POST_ADDR",strPost_addr);
        mav.addObject("MOBILE_PHONE",strMobile_phone);
        mav.addObject("DELIVER_TIME_CODE",strDeliver_time_code);
        mav.addObject("PAY_MODE",strPay_Mode);
        mav.addObject("PAY_STATE",strPay_State);      
        mav.addObject("PAY_REMARK",strPay_Remark);

        
        
        return mav;
    }
}
