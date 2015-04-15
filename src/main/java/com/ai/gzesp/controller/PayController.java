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
import com.ai.gzesp.unionpay.BusiType;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DateUtils;
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

        try {
            result = unionPayService.bindAndPay(param);
        } catch (Exception e) {
            e.printStackTrace();
            result = new HashMap<String, String>();
            result.put("status", "E00");
            result.put("detail", "支付失败！");
        }
        
        //如果支付成功返回成功页面,失败返回失败页面
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        
        return result;
    }
    
    @RequestMapping("/unionPay/testResp/{sys_trade_no}/{resp_trade_type}")
    @ResponseBody
    public Map<String, String> test(@PathVariable("sys_trade_no") String sys_trade_no, @PathVariable("resp_trade_type") String resp_trade_type){
        Map<String, String> result = new HashMap<String, String>();
        
        //原始响应报文map
        Map<String, String> xmlMap = new HashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.bindRsp.getTradeType()); //交易类型支付请求（0200）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, sys_trade_no);//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.resultCode, "00");
        xmlMap.put(UnionPayAttrs.resultDesc, "绑定成功");
        xmlMap.put(UnionPayAttrs.signCode, "1234567890123456"); //签约号
        xmlMap.put(UnionPayAttrs.orderId, "123"); //支付订单号
        xmlMap.put(UnionPayAttrs.currencyCode, UnionPayCons.currencyCode); //交易货币代码（156）
        
        byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
        boolean isSuccess = false;
        //调用mina客户端发送报文
        if(xmlSend != null){
            isSuccess = UnionPayUtil.sendMsg(xmlSend);
        }    
        
        result.put("status", isSuccess ? "00": "01");
        
        return result;
    }
}
