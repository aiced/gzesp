package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class WeShopOrderDetailController {
    @Autowired
    private WeShopService weShopService;
	@Resource 
	OrdersSql ordersSql;
	
    @RequestMapping("/orderDetail")
    public ModelAndView index(@RequestBody String inputParams){
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	System.out.println(paramsMap);
        ModelAndView mav = new ModelAndView("orderDetail.ftl");

        String strOrderid=paramsMap.get("ORDER_ID");
//        String strGoodesName=paramsMap.get("GOODS_NAME");
//        String strInCome_Money=paramsMap.get("INCOME_MONEY");
//        String strOrder_Time=paramsMap.get("Order_Time");
//        String strReceiver_Name=paramsMap.get("RECEIVER_NAME");
//        String strPost_addr=paramsMap.get("POST_ADDR");
//        String strMobile_phone=paramsMap.get("MOBILE_PHONE");
//        String strDeliver_time_code=paramsMap.get("DELIVER_TIME_CODE");
//        String strPay_Mode=paramsMap.get("PAY_MODE");
//        String strPay_State=paramsMap.get("PAY_STATE");
//        String strPay_Remark=paramsMap.get("PAY_REMARK");
        
        
        //从数据库获取信息赋值
    	List<Map<String, Object>> orderList=ordersSql.getOrderInfobyOrderID(strOrderid);
    	
        if (orderList.size()<=0) {
            mav.addObject("title", "订单详情");
            mav.addObject("ORDER_ID","没有数据");
            mav.addObject("GOODS_NAME","没有数据");
            mav.addObject("INCOME_MONEY","没有数据");
            mav.addObject("Order_Time","没有数据");
            mav.addObject("RECEIVER_NAME","没有数据");
            mav.addObject("POST_ADDR","没有数据");
            mav.addObject("MOBILE_PHONE","没有数据");
            mav.addObject("DELIVER_TIME_CODE","没有数据");
            mav.addObject("PAY_MODE","没有数据");
            mav.addObject("PAY_STATE","没有数据");      
            mav.addObject("PAY_REMARK","没有数据");
		
		}
        else {
            mav.addObject("title", "订单详情");
            mav.addObject("ORDER_ID",strOrderid);
            mav.addObject("GOODS_NAME",orderList.get(0).get("GOODS_NAME"));
            mav.addObject("INCOME_MONEY",orderList.get(0).get("INCOME_MONEY"));
            mav.addObject("Order_Time",orderList.get(0).get("Order_Time"));
            mav.addObject("RECEIVER_NAME",orderList.get(0).get("RECEIVER_NAME"));
            mav.addObject("POST_ADDR",orderList.get(0).get("POST_ADDR"));
            mav.addObject("MOBILE_PHONE",orderList.get(0).get("MOBILE_PHONE"));
            mav.addObject("DELIVER_TIME_CODE",orderList.get(0).get("DELIVER_TIME_CODE"));
            mav.addObject("PAY_MODE",orderList.get(0).get("PAY_MODE"));
            mav.addObject("PAY_STATE",orderList.get(0).get("PAY_STATE"));      
            mav.addObject("PAY_REMARK",orderList.get(0).get("PAY_REMARK"));
		
		}
        

        
        
        return mav;
    }
}
