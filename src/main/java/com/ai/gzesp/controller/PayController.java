package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.service.UnionPayService;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.MD5Util;

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
public class PayController {
    
    @Autowired
    private UnionPayService unionPayService;

    /**
     * 选择支付方式(在线支付or货到付款) 以及选择 银联or支付宝 <br>
     * 〈功能详细描述〉
     *
     * @param order_id
     * @param fee
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/selectPayMode/{order_id}/{fee}")
    public ModelAndView selectPayMode(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("selectPayMode.ftl");
        
        mav.addObject("title", "选择支付方式");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        return mav;
    }
    
    /**
     * 银联支付细分：信用卡支付or储蓄卡支付<br>
     * 〈功能详细描述〉
     *
     * @param order_id
     * @param fee
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/unionPay/input/{order_id}/{fee}")
    public ModelAndView unionPayInput(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("unionPayInput.ftl");
        
        mav.addObject("title", "输入支付信息");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        return mav;
    }
    
    /**
     * 银联支付：调用绑定接口<br>
     * 〈功能详细描述〉
     *
     * @param order_id
     * @param fee
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/unionPay/bind/{order_id}/{fee}")
    public ModelAndView unionPayBind(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("unionPayInput.ftl");
        
        //mav.addObject("title", "选择支付方式");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        return mav;
    }   

    /**
     * 银联支付：调用支付接口 <br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/unionPay/pay/{order_id}/{fee}")
    @ResponseBody
    public Map<String, String> unionPayPay(@RequestBody UnionPayParam param){
        Map<String, String> result;
        
        //判断校验参数

        result = unionPayService.bindAndPay(param);
        
        //如果支付成功返回成功页面,失败返回失败页面
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        
        return result;
    }
    
    @RequestMapping("/test")
    public ModelAndView test(UnionPayParam param){
        //unionPayService.test();
        return new ModelAndView("payInput.ftl");
    }
}
