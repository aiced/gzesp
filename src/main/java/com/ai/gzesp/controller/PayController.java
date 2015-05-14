package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DESUtil;
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
/*    @RequestMapping("/unionPay/bind/{order_id}/{fee}")
    public ModelAndView unionPayBind(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("unionPayInput.ftl");
        
        //mav.addObject("title", "选择支付方式");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        return mav;
    }   */

    /**
     * 银联支付：调用绑定和支付接口 <br>
     * 此方法作废，因为后来银联根据我们的要求改造代码
     * 改造前esp系统单独有个签约信息表，每次支付前先查询是否曾经绑定成功过，有就直接取出签约号支付，没有则先绑定接口再支付接口，重复绑定会返回错误码
     * 改造后每次支付我们都先绑定然后支付，不管是否曾经绑定成功，只要5要素都正确，绑定接口银联都返回成功和签约号，然后再用返回的签约号调支付接口
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    @RequestMapping("/unionPay/pay")
    @ResponseBody
    public Map<String, String> unionPayPay(@RequestBody UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        
        //判断校验参数
        
        //逻辑放controller是因为service里都有事务控制，没法分开
        try {
			//查询是否有签约号，如果有直接用来调支付接口，没有则调绑定接口获取签约号，然后再支付接口
			Map<String, String> signCodeRow = unionPayService.querySignCode(param.getBank_card_no());
			
			if(signCodeRow == null){
				unionPayService.insertBindlogAndSignCode(param, result); //插日志
				if(!result.isEmpty()){
					return result; //非空表示有错误代码了，返回给界面，不继续往下执行了
				}
				unionPayService.sendBindReq(param, result);  //调绑定接口
				if(!result.isEmpty()){
					return result; 
				}
				unionPayService.waitForBindResp(param, result); //等待绑定返回签约号
				if(!result.isEmpty()){
					return result; 
				}
				
				//以上签约都成功了，则开始调用支付接口
				unionPayService.insertPaylog(param, result);
				if(!result.isEmpty()){
					return result; 
				}
				unionPayService.sendPayReq(param, result);
				if(!result.isEmpty()){
					return result; 
				}
				unionPayService.waitForPayResp(param, result);
				if(!result.isEmpty()){
					return result; 
				}
			}
			else{
			    //如果根据卡号捞到记录，则要校验输入的值和表里的信息是否都一致
			    //boolean flag = checkParam(param, signCodeRow, result);
			    
			    param.setSign_code(MD5Util.convertMD5(signCodeRow.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
				
			    unionPayService.insertPaylog(param, result);
				if(!result.isEmpty()){
					return result; 
				}
				unionPayService.sendPayReq(param, result);
				if(!result.isEmpty()){
					return result; 
				}
				unionPayService.waitForPayResp(param, result);
				if(!result.isEmpty()){
					return result; 
				}
			}
			
			result.put("status", "E11");
            result.put("detail", "支付失败！");
		} catch (Exception e1) {
			e1.printStackTrace();
			result.put("status", "E12");
            result.put("detail", "支付失败！");
		}      
        
        return result;
    }*/
    
    /**
     * 银联支付：调用绑定和支付接口 <br>
     * 此为银联改造后的新的方法
     * 改造前esp系统单独有个签约信息表，每次支付前先查询是否曾经绑定成功过，有就直接取出签约号支付，没有则先绑定接口再支付接口，重复绑定会返回错误码
     * 改造后每次支付我们都先绑定然后支付，不管是否曾经绑定成功，只要5要素都正确，绑定接口银联都返回成功和签约号，然后再用返回的签约号调支付接口
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/unionPay/pay")
    @ResponseBody
    public Map<String, String> unionPayPay(@RequestBody UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        
        //判断校验参数
        
        //逻辑放controller是因为service里都有事务控制，没法分开
        try {
        	unionPayService.insertBindlog(param, result); //插绑定日志, 此处用新的方法
			if(!result.isEmpty()){
				return result; //非空表示有错误代码了，返回给界面，不继续往下执行了
			}
			unionPayService.sendBindReq(param, result);  //调绑定接口
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForBindRespNew(param, result); //等待绑定返回签约号 ,此处用新的方法
			if(!result.isEmpty()){
				return result; 
			}
			
			//以上签约都成功了，则开始调用支付接口
			unionPayService.insertPaylog(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.sendPayReq(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForPayResp(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			
			result.put("status", "E11");
            result.put("detail", "支付失败！");
		} catch (Exception e1) {
			e1.printStackTrace();
			result.put("status", "E12");
            result.put("detail", "支付失败！");
		}      
        
        return result;
    }   
    
    /**
     * 银联支付：调用全要素支付接口 <br>
     * 此为银联改造后的新的方法
     * 不用 先调绑定接口再获取签约号然后再调支付接口了，直接全要素上传调支付接口
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/unionPay/payNew")
    @ResponseBody
    public Map<String, String> unionPayPayNew(@RequestBody UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        
        //判断校验参数
        
        //逻辑放controller是因为service里都有事务控制，没法分开
        try {
			unionPayService.insertPayNewlog(param, result); //新的方法
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.sendPayNewReq(param, result); //新的方法
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForPayResp(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			
			result.put("status", "E11");
            result.put("detail", "支付失败！");
		} catch (Exception e1) {
			e1.printStackTrace();
			result.put("status", "E12");
            result.put("detail", "支付失败！");
		}      
        
        return result;
    }    
    
    
    /**
     * 银联支付：调用全要素支付接口 <br>
     * 此为银联改造后的新的方法 wenh
     * 不用 先调绑定接口再获取签约号然后再调支付接口了，直接全要素上传调支付接口
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     */
    @RequestMapping("/unionPay/payCancel")
    @ResponseBody
    public Map<String, String> unionPayCancel(@RequestBody UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        
        //判断校验参数
        
        //逻辑放controller是因为service里都有事务控制，没法分开
        try {
			unionPayService.insertPayCancellog(param, result); //新的方法
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.sendPayCancelReq(param, result); //新的方法
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForPayCancelResp(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			
			result.put("status", "E11");
            result.put("detail", "支付失败！");
		} catch (Exception e1) {
			e1.printStackTrace();
			result.put("status", "E12");
            result.put("detail", "支付失败！");
		}      
        
        return result;
    } 
    
    
/*    @RequestMapping("/unionPay/testResp/{sys_trade_no}/{resp_trade_type}")
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
    
    @RequestMapping("/unionPay/test1")
    public ModelAndView test1(){
        ModelAndView mav = new ModelAndView("unionPayInput.ftl");
        
        //原始响应报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.bindRsp.getTradeType()); //交易类型支付请求（0200）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, "1234567890123456");//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.resultCode, "00");
        xmlMap.put(UnionPayAttrs.resultDesc, "绑定成功");
        xmlMap.put(UnionPayAttrs.signCode, "1234567890123456"); //签约号
        xmlMap.put(UnionPayAttrs.orderId, "123"); //支付订单号
        xmlMap.put(UnionPayAttrs.currencyCode, UnionPayCons.currencyCode); //交易货币代码（156）
        
        byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
        UnionPayUtil.sendMsg(xmlSend);
        return mav;
    }
    
    @RequestMapping("/unionPay/test2")
    public ModelAndView test2(){
        ModelAndView mav = new ModelAndView("unionPayInput.ftl");
        
        //原始响应报文map
        String xmlStr2 = "<?xml version=\"1.0\" encoding=\"GBK\"?><responseData><charCode>GBK</charCode><TradeType>0130</TradeType><ChannelID>7651444882235483</ChannelID><MerType>01</MerType><bmMerId>1000000000009904</bmMerId><timeStamp>20150417091333</timeStamp><sysTradeNo>1014292332134671</sysTradeNo><resultCode>W5</resultCode><resultDesc>该卡已绑定过，请勿重新绑定</resultDesc><signCode>03a05df6c2d44ebda29c457751feaba5</signCode><currencyCode>156</currencyCode><md5ConSec>a38efa1e54970726582f283705af2432</md5ConSec></responseData>";

        try {
            //3DES加密 报文
            byte[] xmlByte = DESUtil.encryptMode(xmlStr2.getBytes(UnionPayCons.charCode));
                    if(xmlByte == null)
        {
            log.error("【加密XML失败,xmlStr = " + xmlStr2);
        }
            
            //4位报文体字节长度+渠道号（16位）+加密后的xml报文体。如：0231+渠道号（16位）+加密后的xml报文体（215字节）
            //转化为4位长度字节数据以供另一端读取,长度不足4字节要补0
            byte[] xmlHead = new byte[4];
            byte[] xmlHeadLen = ((xmlByte.length+16)<1000 ? "0"+String.valueOf(xmlByte.length+16) : String.valueOf(xmlByte.length+16)).getBytes(UnionPayCons.charCode);
            System.arraycopy(xmlHeadLen, 0, xmlHead, xmlHead.length - xmlHeadLen.length, xmlHeadLen.length); //给xmlHead 赋值
            byte[] xmlSend = new byte[4 + 16 + xmlByte.length]; 
            System.arraycopy(xmlHead, 0, xmlSend, 0, 4);
            System.arraycopy(UnionPayCons.ChannelID.getBytes(UnionPayCons.charCode), 0, xmlSend, 4, 16);
            System.arraycopy(xmlByte, 0, xmlSend, 20, xmlByte.length);
            
        UnionPayUtil.sendMsg(xmlSend);
        return mav;
    }catch (Exception e) {
        e.printStackTrace();
        return null;
    } 
        
    }*/
    
    @RequestMapping("/unionPay/bindCancel/{bank_card_no}")
    @ResponseBody
    public Map<String, String> bindCancel(@PathVariable("bank_card_no") String bank_card_no){
        Map<String, String> result = new HashMap<String, String>();
        
        UnionPayParam param = new UnionPayParam();
        param.setBank_card_no(bank_card_no);
        
        //查询是否有签约号
		Map<String, String> signCodeRow = unionPayService.querySignCode(bank_card_no);
		if(signCodeRow == null){
			result.put("status", "E11");
        	result.put("detail", "支付失败！银行卡绑定解除没找到相应签约号");
		}
		else{
			param.setSign_code(MD5Util.convertMD5(signCodeRow.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
			unionPayService.insertBindCancellog(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.sendBindCancelReq(param, result);
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForBindCancelResp(param, result);
			if(!result.isEmpty()){
				return result; 
			}
		}
        
        return result;
    }
    
    /**
     * 支付结束后，选择再去逛逛，回到能人店铺的首页
     * 根据order_id 查询 能人id，然后再跳转
     * @param order_id
     * @param fee
     * @return
     */
    @RequestMapping("/goToWeShopIndex/{order_id}")
    public ModelAndView goToWeShopIndex(@PathVariable("order_id") String order_id){
    	Map<Object, Object> userInfo = unionPayService.queryUserIdByOrderId(order_id);
    	
        ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+userInfo.get("USER_ID"));
    	//ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+"2015000000000000");
        
        return mav;
    }
}
