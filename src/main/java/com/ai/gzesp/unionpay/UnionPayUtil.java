package com.ai.gzesp.unionpay;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.utils.DESUtil;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;
import com.ai.gzesp.utils.XmlUtils;

/**
 * 银联接口 工具类<br> 
 * 拼装报文数据map等功能
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnionPayUtil {

    private static final Logger log = Logger.getLogger(UnionPayUtil.class); 
    
    /**
     * 银联接口：生成 银行卡绑定接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> genBindReq(UnionPayParam param){
        log.debug("【银联支付：创建bind请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, param.getBind_trade_type()); //交易类型银行卡绑定（0120）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getBind_sys_trade_no());//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.accNo, param.getBank_card_no());  //银行卡号
        xmlMap.put(UnionPayAttrs.cvn2, param.getBank_card_cvn() == null ? "" : param.getBank_card_cvn()); //储蓄卡没有cvn，null在后面getbyte方法会报错
        xmlMap.put(UnionPayAttrs.currencyCode, UnionPayCons.currencyCode); //交易货币代码（156）
        xmlMap.put(UnionPayAttrs.Nbr, param.getPhone_no()); //手机号
        xmlMap.put(UnionPayAttrs.Name, param.getFull_name()); //姓名
        xmlMap.put(UnionPayAttrs.certificateCode, param.getId_card_no());  //身份证号
        xmlMap.put(UnionPayAttrs.expireDate, param.getBank_card_expire_date() == null ? "" : param.getBank_card_expire_date()); //储蓄卡没有有效期
        xmlMap.put(UnionPayAttrs.cardType, param.getCard_type()); //卡类型（信用卡:01或借记卡:02）

        //return genByteReq(xmlMap);
        return xmlMap;
    }
    
    /**
     * 银联接口：生成 银行卡绑定关系查询接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> genBindQryReq(UnionPayParam param){
        log.debug("【银联支付：创建bindQry请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.bindQry.getTradeType()); //交易类型绑定关系查询（0100）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, genSysTradeNo(TradeType.bindQry.getTradeType()));//受卡方系统跟踪号，作为对应请求交易的编号。
        xmlMap.put(UnionPayAttrs.accNo, param.getBank_card_no());  //银行卡号
        xmlMap.put(UnionPayAttrs.certificateCode, param.getId_card_no());  //身份证号
        xmlMap.put(UnionPayAttrs.Nbr, param.getPhone_no()); //手机号
        xmlMap.put(UnionPayAttrs.Name, param.getFull_name()); //姓名

        //return genByteReq(xmlMap);
        return xmlMap;
    }
    
    /**
     * 银联接口：生成 支付接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> genPayReq(UnionPayParam param){
        log.debug("【银联支付：创建pay请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, param.getPay_trade_type()); //交易类型支付请求（0200）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.BusiType, BusiType.type001.getCode()); //业务类型，001：购买电子产品
        xmlMap.put(UnionPayAttrs.AccountID, ""); //帐单号（根据业务类型的需求来填写）,可以为空
        xmlMap.put(UnionPayAttrs.AreaCode, ""); //地区代码 发起交易的地区区号（根据不同业务类型需要来填写）,可以为空
        xmlMap.put(UnionPayAttrs.timeStamp, param.getPay_time_stamp()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getPay_sys_trade_no());//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.signCode, param.getSign_code()); //签约号
        xmlMap.put(UnionPayAttrs.orderId, param.getOrder_id()); //支付订单号
        xmlMap.put(UnionPayAttrs.industryType, UnionPayCons.industryType); //支付行业类型
        xmlMap.put(UnionPayAttrs.txnAmt, String.valueOf(Integer.parseInt(param.getFee())/10)); //订单传过来是厘，传给银联单位是分 需要除以10

        //return genByteReq(xmlMap);
        return xmlMap;
    }
    
    /**
     * 银联接口：生成 全要素支付接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> genPayNewReq(UnionPayParam param){
        log.debug("【银联支付：创建payNew请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, param.getPay_trade_type()); //交易类型全要素支付请求（0202）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.BusiType, BusiType.type001.getCode()); //业务类型，001：购买电子产品
        xmlMap.put(UnionPayAttrs.AccountID, ""); //帐单号（根据业务类型的需求来填写）,可以为空
        xmlMap.put(UnionPayAttrs.AreaCode, ""); //地区代码 发起交易的地区区号（根据不同业务类型需要来填写）,可以为空
        xmlMap.put(UnionPayAttrs.timeStamp, param.getPay_time_stamp()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getPay_sys_trade_no());//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.accNo, param.getBank_card_no());  //银行卡号
        xmlMap.put(UnionPayAttrs.cvn2, param.getBank_card_cvn() == null ? "" : param.getBank_card_cvn()); //储蓄卡没有cvn，null在后面getbyte方法会报错
        //xmlMap.put(UnionPayAttrs.currencyCode, UnionPayCons.currencyCode); //交易货币代码（156）
        xmlMap.put(UnionPayAttrs.Nbr, param.getPhone_no()); //手机号
        xmlMap.put(UnionPayAttrs.Name, param.getFull_name()); //姓名
        xmlMap.put(UnionPayAttrs.certificateCode, param.getId_card_no());  //身份证号
        xmlMap.put(UnionPayAttrs.expireDate, param.getBank_card_expire_date() == null ? "" : param.getBank_card_expire_date()); //储蓄卡没有有效期
        xmlMap.put(UnionPayAttrs.cardType, param.getCard_type()); //卡类型（信用卡:01或借记卡:02）
        //xmlMap.put(UnionPayAttrs.signCode, param.getSign_code()); //签约号
        xmlMap.put(UnionPayAttrs.orderId, param.getOrder_id()); //支付订单号
        xmlMap.put(UnionPayAttrs.industryType, UnionPayCons.industryType); //支付行业类型
        xmlMap.put(UnionPayAttrs.txnAmt, String.valueOf(Integer.parseInt(param.getFee())/10)); //订单传过来是厘，传给银联单位是分 需要除以10
        xmlMap.put(UnionPayAttrs.ifInstal, "0"); //是否做分期付款（0表示不分期1表示分期）
        xmlMap.put(UnionPayAttrs.instalTransInfo, ""); //分期付款期数（两位数字，比如分为6期取值为06）
        
        
        //return genByteReq(xmlMap);
        return xmlMap;
    }
    
    /**
     * 银联接口：生成 支付结果查询接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayQryReq(UnionPayParam param){
        log.debug("【银联支付：创建payQry请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payQry.getTradeType()); //交易类型支付查询（0300）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, genSysTradeNo(TradeType.payQry.getTradeType()));//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.orderId, ); //原始交易返回的orderId

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    /**
     * 银联接口：生成 代付接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayProxyReq(UnionPayParam param){
        log.debug("【银联支付：创建payProxy请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payProxy.getTradeType()); //交易类型代付请求（0250）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.BusiType, BusiType.type001.getCode()); //业务类型，001：购买电子产品
        xmlMap.put(UnionPayAttrs.AreaCode, null); //地区代码 发起交易的地区区号（根据不同业务类型需要来填写）,可以为空
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, genSysTradeNo(TradeType.payProxy.getTradeType()));//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.accNo, "4392260020839718");  //受卡人卡号
        xmlMap.put(UnionPayAttrs.Name, "奚敏辉"); //受卡人姓名
        xmlMap.put(UnionPayAttrs.Nbr, "18651885060"); //手机号
        xmlMap.put(UnionPayAttrs.orderId, ); //支付订单号
        xmlMap.put(UnionPayAttrs.txnAmt, String.valueOf(Integer.parseInt(param.getFee())/10)); //订单传过来是厘，传给银联单位是分 需要除以10

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/

    /**
     * 银联接口：生成 代付结果查询接口 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayProxyQryReq(UnionPayParam param){
        log.debug("【银联支付：创建payProxyQry请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payProxyQry.getTradeType()); //交易类型代付查询（0370）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, genSysTradeNo(TradeType.payProxyQry.getTradeType()));//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.orderId, ); //原始交易返回的orderId

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    /**
     * 银联接口：生成 支付交易撤销(指当日交易撤消) 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, String> genPayCancelReq(UnionPayParam param){
        log.debug("【银联支付：创建payNew请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, param.getPay_trade_type()); //交易类型全要素支付请求（0202）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.BusiType, BusiType.type001.getCode()); //业务类型，001：购买电子产品
        xmlMap.put(UnionPayAttrs.AccountID, ""); //帐单号（根据业务类型的需求来填写）,可以为空
        xmlMap.put(UnionPayAttrs.AreaCode, ""); //地区代码 发起交易的地区区号（根据不同业务类型需要来填写）,可以为空
        xmlMap.put(UnionPayAttrs.timeStamp, param.getPay_time_stamp()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getPay_sys_trade_no());//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.accNo, param.getBank_card_no());  //银行卡号
        xmlMap.put(UnionPayAttrs.cvn2, param.getBank_card_cvn() == null ? "" : param.getBank_card_cvn()); //储蓄卡没有cvn，null在后面getbyte方法会报错
        //xmlMap.put(UnionPayAttrs.currencyCode, UnionPayCons.currencyCode); //交易货币代码（156）
        xmlMap.put(UnionPayAttrs.Nbr, param.getPhone_no()); //手机号
        xmlMap.put(UnionPayAttrs.Name, param.getFull_name()); //姓名
        xmlMap.put(UnionPayAttrs.certificateCode, param.getId_card_no());  //身份证号
        xmlMap.put(UnionPayAttrs.expireDate, param.getBank_card_expire_date() == null ? "" : param.getBank_card_expire_date()); //储蓄卡没有有效期
        xmlMap.put(UnionPayAttrs.cardType, param.getCard_type()); //卡类型（信用卡:01或借记卡:02）
        //xmlMap.put(UnionPayAttrs.signCode, param.getSign_code()); //签约号
        xmlMap.put(UnionPayAttrs.orderId, param.getOrder_id()); //支付订单号
        xmlMap.put(UnionPayAttrs.industryType, UnionPayCons.industryType); //支付行业类型
        xmlMap.put(UnionPayAttrs.txnAmt, String.valueOf(Integer.parseInt(param.getFee())/10)); //订单传过来是厘，传给银联单位是分 需要除以10
        xmlMap.put(UnionPayAttrs.ifInstal, "0"); //是否做分期付款（0表示不分期1表示分期）
        xmlMap.put(UnionPayAttrs.instalTransInfo, ""); //分期付款期数（两位数字，比如分为6期取值为06）
        
        
        //return genByteReq(xmlMap);
        return xmlMap;
    }    
    
    
    
    
    
    
/*    public static Map<String, String> genPayCancelReq(UnionPayParam param){
        log.debug("【银联支付：创建payCancel请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payCancel.getTradeType()); //交易类型支付撤消（0970）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, genSysTradeNo(TradeType.payCancel.getTradeType()));//受卡方系统跟踪号，作为对应请求交易的编号
        xmlMap.put(UnionPayAttrs.origsignCode, ); // 原交易签约号
        xmlMap.put(UnionPayAttrs.origtimeStamp, ); // 原交易时间
        xmlMap.put(UnionPayAttrs.origsysTradeNo, ); // 原交易系统跟踪号
        xmlMap.put(UnionPayAttrs.origOrderId, ); // 原支付交易订单号
        xmlMap.put(UnionPayAttrs.origtxnAmt, ); // 原支付交易金额（单位：分）（不支持部分撤消）
        xmlMap.put(UnionPayAttrs.orderId, ); //撤消交易订单号

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    /**
     * 银联接口：生成 支付交易撤销(指当日交易撤消)结果查询 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayCancelQryReq(UnionPayParam param){
        log.debug("【银联支付：创建payCancelQry请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payCancelQry.getTradeType()); //交易类型支付退款查询（0320）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getOrder_id());//受卡方系统跟踪号，作为对应请求交易的编号。此处填订单号
        xmlMap.put(UnionPayAttrs.origtimeStamp, ); // 原退款时间
        xmlMap.put(UnionPayAttrs.orderId, ); //原退款订单号

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    /**
     * 银联接口：生成 支付交易退款(非当日交易) 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayRefundReq(UnionPayParam param){
        log.debug("【银联支付：创建payRefund请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payRefund.getTradeType()); //交易类型支付退款（0900）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getOrder_id());//受卡方系统跟踪号，作为对应请求交易的编号。此处填订单号
        xmlMap.put(UnionPayAttrs.origsignCode, ); // 原交易签约号
        xmlMap.put(UnionPayAttrs.origtimeStamp, ); // 原交易时间
        xmlMap.put(UnionPayAttrs.origsysTradeNo, ); // 原交易系统跟踪号
        xmlMap.put(UnionPayAttrs.origOrderId, ); // 原支付交易订单号
        xmlMap.put(UnionPayAttrs.origtxnAmt, ); // 原支付交易金额（单位：分）（不支持部分撤消）
        xmlMap.put(UnionPayAttrs.orderId, ); //撤消交易订单号

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    /**
     * 银联接口：生成 支付交易退款(非当日交易)结果查询 发送报文<br>
     *
     * @param param
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static Map<String, String> genPayRefundQryReq(UnionPayParam param){
        log.debug("【银联支付：创建payRefundQry请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, TradeType.payRefundQry.getTradeType()); //交易类型退货交易查询（0350）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, DateUtils.getCurentTime()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getOrder_id());//受卡方系统跟踪号，作为对应请求交易的编号。此处填订单号
        xmlMap.put(UnionPayAttrs.origtimeStamp, ); // 原退款时间
        xmlMap.put(UnionPayAttrs.orderId, ); //原退款订单号

        //return genByteReq(xmlMap);
        return xmlMap;
    }*/
    
    public static Map<String, String> genBindCancelReq(UnionPayParam param){
        log.debug("【银联支付：创建bindCancelReq请求原始数据map】");
        //原始请求报文map
        Map<String, String> xmlMap = new LinkedHashMap<String, String>();
        xmlMap.put(UnionPayAttrs.charCode, UnionPayCons.charCode);
        xmlMap.put(UnionPayAttrs.Version, UnionPayCons.Version);
        xmlMap.put(UnionPayAttrs.TradeType, param.getBindCacnel_trade_type()); //交易类型退货交易查询（0350）
        xmlMap.put(UnionPayAttrs.ChannelID, UnionPayCons.ChannelID); // 发送渠道号
        xmlMap.put(UnionPayAttrs.MerType, UnionPayCons.MerType); //商户类型（填01表示直连，填02表示转接）
        xmlMap.put(UnionPayAttrs.bmMerId, UnionPayCons.bmMerId); // 前置平台获批后分配的商户身份ID
        xmlMap.put(UnionPayAttrs.timeStamp, param.getBindCacnel_time_stamp()); //时间戳，当前接口调用时间，yyyyMMddHHmmss
        xmlMap.put(UnionPayAttrs.sysTradeNo, param.getBindCacnel_sys_trade_no());//受卡方系统跟踪号，作为对应请求交易的编号。此处填订单号
        xmlMap.put(UnionPayAttrs.signCode, param.getSign_code()); // 签约号

        //return genByteReq(xmlMap);
        return xmlMap;
    }
    
    /**
     * 根据请求参数的map 生成对应的请求 byte[]报文<br>
     * 〈功能详细描述〉
     *
     * @param xmlMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static byte[] genByteReq(Map<String, String> xmlMap){
        if(xmlMap == null){
            return null;
        }
        log.debug("【银联支付：1.请求map创建成功】");
        
        //map转换层原始数据xml报文
        //String xmlStr1 = XmlUtils.toXML(xmlMap);
        String data = getDataFromxmlMap(xmlMap);
        log.debug("【银联支付：2.请求map里提取原始数据用于md5加密: " + data + "】");
        //xml报文加密生成MD5摘要
        //String xmlMD5 = MD5Util.str2MD5(xmlStr1);
        String xmlMD5 = MD5Util.md5s2(data, UnionPayCons.md5Key);
        log.debug("【银联支付：3.请求原始数据 md5加密摘要: " + xmlMD5 + "】");
        //加密后的摘要 加 到 原始数据 后面
        xmlMap.put(UnionPayAttrs.md5ConSec, xmlMD5); 
        //重新转换层 xml报文(包含了md5摘要)
        String xmlStr2 = XmlUtils.toXML(xmlMap);
        log.debug("【银联支付：4.请求重新转换成 xml报文(包含了md5摘要): " + xmlStr2 + "】");
        
        try {
            //3DES加密 报文
            byte[] xmlByte = DESUtil.encryptMode(xmlStr2.getBytes(UnionPayCons.charCode));
            /*        if(xmlByte == null)
        {
            log.error("【加密XML失败,xmlStr = " + xmlStr2);
        }*/
            
            //4位报文体字节长度+渠道号（16位）+加密后的xml报文体。如：0231+渠道号（16位）+加密后的xml报文体（215字节）
            //转化为4位长度字节数据以供另一端读取,长度不足4字节要补0
            byte[] xmlHead = new byte[4];
            byte[] xmlHeadLen = ((xmlByte.length+16)<1000 ? "0"+String.valueOf(xmlByte.length+16) : String.valueOf(xmlByte.length+16)).getBytes(UnionPayCons.charCode);
            System.arraycopy(xmlHeadLen, 0, xmlHead, xmlHead.length - xmlHeadLen.length, xmlHeadLen.length); //给xmlHead 赋值
            byte[] xmlSend = new byte[4 + 16 + xmlByte.length]; 
            System.arraycopy(xmlHead, 0, xmlSend, 0, 4);
            System.arraycopy(UnionPayCons.ChannelID.getBytes(UnionPayCons.charCode), 0, xmlSend, 4, 16);
            System.arraycopy(xmlByte, 0, xmlSend, 20, xmlByte.length);
            log.debug("【银联支付：5.请求最终发送报文: " + new String(xmlSend) + "】");
            return  xmlSend;
        } catch (Exception e) {
            log.debug("【银联支付：请求xmlMap生成Bytes 异常！！！】");
            e.printStackTrace();
            return null;
        } 
    }
    
    /**
     * 调用mina客户端 发送byte[] 报文<br>
     *
     * @param xmlSend
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean sendMsg(byte[] xmlSend){
        boolean isSuccess = true;
        try {
            //设置心跳过滤器链
//        ClientKeepAliveFactoryImpl ckafi = new ClientKeepAliveFactoryImpl(); 
//        KeepAliveFilter kaf = new KeepAliveFilter(ckafi, IdleStatus.BOTH_IDLE,KeepAliveRequestTimeoutHandler.CLOSE); 
//        kaf.setForwardEvent(true); //继续调用 IoHandlerAdapter 中的 sessionIdle时间 
//        kaf.setRequestInterval(UnionPayCons.HEART_INTERVAL); //设置当连接的读取通道空闲的时候，心跳包请求时间间隔 
//        kaf.setRequestTimeout(UnionPayCons.HEART_TIMEOUT); //设置心跳包请求后 等待反馈超时时间

            // 创建客户端连接器. 
//            NioSocketConnector connector = new NioSocketConnector(); 
//            connector.getFilterChain().addLast("logger", new LoggingFilter() ); 
//            connector.getFilterChain().addLast("codec", new ProtocolCodecFilter( new ByteArrayCodecFactory())); //设置编码过滤器 
//            //connector.getFilterChain().addLast("heart", kaf);  //设置心跳
//            connector.setHandler(new ClientHandler());//设置事件处理器 
//            ConnectFuture cf = connector.connect( 
//            new InetSocketAddress(UnionPayCons.SERVER_HOST, UnionPayCons.SERVER_PORT));//建立连接 
//            cf.awaitUninterruptibly();//等待连接创建完成 
//            cf.getSession().write(xmlSend);//发送消息 
//            cf.getSession().close(true);
//            cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开 
//            connector.dispose(); //断开连接，释放资源
            
            ClientHandler.sendMsg(xmlSend);
            
            return isSuccess;
        } catch (Exception e) {
            log.debug("【银联支付：生成最终请求报文后发送异常！！！】");
            isSuccess = false;
            e.printStackTrace();
            return isSuccess;
        }
        
    }
    
    
    /**
     * 接收byte[]响应报文进行处理转换成map<br>
     * 如果收到的msg是银联发来的心跳报文0000，则返回响应报文0000，
     * 其他情况都是收到的银联的响应，方法返回null，也不需要返回报文
     *
     * @param msg
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public static String recvMsg(byte[] msg){
        if(msg.length == 0){
            log.debug("【银联支付：服务端收到报文 长度=0, 是心跳报文】");
            return null;
        }
        
        if(msg.length < 4){
            log.debug("【银联支付：收到的报文字节数<4, 报文有问题，esp忽略不处理！！！ 】");
            return null;
        }
        
        byte [] header = new byte[4];
        System.arraycopy(msg, 0, header, 0, 4); //获取前4位字节 
        //如果收到的是心跳报文0000,则返回 0000响应,心跳报文银联也不需要我返回
        if(UnionPayCons.HEARTBEAT_REQ.equals(new String(header))){
            log.debug("【银联支付：服务端收到报文 0000, 是心跳报文】");
            //return UnionPayCons.HEARTBEAT_RESP;
            return null;
        }
        
        //4位报文体字节长度+渠道号（16位）+加密后的xml报文体。如：0231+渠道号（16位）+加密后的xml报文体（215字节）
        if(msg.length <= (4+16)){
            log.debug("【银联支付：收到的响应报文长度<=(4+16),报文有问题，esp忽略不处理！！！ 】");
            return null;
        }
        
        //header存的是 正在报文体的字节数+16位渠道号字节数
        int len = Integer.parseInt(new String(header));
        if(len != (msg.length-4)){
            log.debug("【银联支付：收到的响应报文,head里字节数!=报文体节数-4,报文有问题，esp忽略不处理！！！ 】");
            return null;
        }
        
        byte [] channel = new byte[16];
        byte [] resp = new byte[len-16];
        System.arraycopy(msg, 4, channel, 0, 16); //获取响应报文channelId部分
        System.arraycopy(msg, 20, resp, 0, len-16); //获取响应报文数据部分,还未解密
        String xmlResp = null;
        try {
            //解密数据
            byte [] respDecr = DESUtil.decryptMode(resp);
            xmlResp = new String(respDecr, UnionPayCons.charCode);
            log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml," + xmlResp +" 】");
            Map<String, String> xmlMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
            log.debug("【银联支付：收到的响应报文,数据部分xml转换成map成功】");
        } catch (Exception e) {
            log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml再转换成map 出现异常！！！ 】");
            e.printStackTrace();
            return null;
        }
        
        //根据respMap里交易类型进行业务处理
        if(xmlResp != null ){
            Map<String, String> respMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
            IDealUnionPayResp respHanler = RespHandlerFactory.create(respMap);
            respHanler.dealResp(respMap);
        }
        
        return xmlResp;
    }*/
    
    public static String recvMsg(byte[] msg){
        //如果收到的是心跳报文0000,则返回 0000响应,心跳报文银联也不需要我返回
          if(msg.length == 0){
              log.debug("【银联支付：服务端收到报文 长度=0, 是心跳报文】");
              return null;
          }
          
          //4位报文体字节长度+渠道号（16位）+加密后的xml报文体。如：0231+渠道号（16位）+加密后的xml报文体（215字节）
          if(msg.length <= 16){
              log.debug("【银联支付：收到的响应报文长度<=16,报文有问题，esp忽略不处理！！！ 】");
              return null;
          }
          
          //header存的是 正在报文体的字节数+16位渠道号字节数
          int len = msg.length;
          byte [] channel = new byte[16];
          byte [] resp = new byte[len-16];
          System.arraycopy(msg, 0, channel, 0, 16); //获取响应报文channelId部分
          System.arraycopy(msg, 16, resp, 0, len-16); //获取响应报文数据部分,还未解密
          String xmlResp = null;
          try {
              //解密数据
              byte [] respDecr = DESUtil.decryptMode(resp);
              xmlResp = new String(respDecr, UnionPayCons.charCode);
              log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml," + xmlResp +" 】");
              Map<String, String> xmlMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
              log.debug("【银联支付：收到的响应报文,数据部分xml转换成map成功】");
          } catch (Exception e) {
              log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml再转换成map 出现异常！！！ 】");
              e.printStackTrace();
              return null;
          }
          
          //根据respMap里交易类型进行业务处理
          if(xmlResp != null ){
              Map<String, String> respMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
              IDealUnionPayResp respHanler = RespHandlerFactory.create(respMap);
              respHanler.dealResp(respMap);
          }
          
          return xmlResp;
      }
    
    /**
     * 获取byte[]数据包后，解密并获取里面的xml原始报文
     * 如果是心跳包则返回null
     * @param msg
     * @return
     */
/*    public static String getXmlFromMsg(byte[] msg){
      //如果收到的是心跳报文0000,则返回 0000响应,心跳报文银联也不需要我返回
        if(msg.length == 0){
            log.debug("【银联支付：服务端收到报文 长度=0, 是心跳报文】");
            return null;
        }
        
        //4位报文体字节长度+渠道号（16位）+加密后的xml报文体。如：0231+渠道号（16位）+加密后的xml报文体（215字节）
        if(msg.length <= 16){
            log.debug("【银联支付：收到的响应报文长度<=16,报文有问题，esp忽略不处理！！！ 】");
            return null;
        }
        
        //header存的是 正在报文体的字节数+16位渠道号字节数
        int len = msg.length;
        byte [] channel = new byte[16];
        byte [] resp = new byte[len-16];
        System.arraycopy(msg, 0, channel, 0, 16); //获取响应报文channelId部分
        System.arraycopy(msg, 16, resp, 0, len-16); //获取响应报文数据部分,还未解密
        String xmlResp = null;
        try {
            //解密数据
            byte [] respDecr = DESUtil.decryptMode(resp);
            xmlResp = new String(respDecr, UnionPayCons.charCode);
            log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml," + xmlResp +" 】");
            Map<String, String> xmlMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
            log.debug("【银联支付：收到的响应报文,数据部分xml转换成map成功】");
        } catch (Exception e) {
            log.debug("【银联支付：收到的响应报文,数据部分解密后byte[]转换成xml再转换成map 出现异常！！！ 】");
            e.printStackTrace();
            return null;
        }
        
        //根据respMap里交易类型进行业务处理
        if(xmlResp != null ){
            Map<String, String> respMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
            IDealUnionPayResp respHanler = RespHandlerFactory.create(respMap);
            respHanler.dealResp(respMap);
        }
        
        return xmlResp;
    }*/
    
    
    
    /**
     * 功能描述: 生成受卡方系统跟踪号 16位<br>
     * 10|1428833337996|12 : 2位类型|当前时间戳13位long型|1位随机整数
     *
     * @param tradeType
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String genSysTradeNo(String tradeType){
        StringBuffer sb = new StringBuffer(16);
        if(TradeType.bind.getTradeType().equals(tradeType)){
            sb.append("10");
        }
        else if(TradeType.bindCancel.getTradeType().equals(tradeType)){
            sb.append("12");
        }
        else if(TradeType.pay.getTradeType().equals(tradeType)){
            sb.append("20");
        }
        else if(TradeType.payNew.getTradeType().equals(tradeType)){
            sb.append("40");
        }
        else if(TradeType.payProxy.getTradeType().equals(tradeType)){
            sb.append("30");
        }
        else if(TradeType.bindQry.getTradeType().equals(tradeType)){
            sb.append("11");
        }
        else if(TradeType.payQry.getTradeType().equals(tradeType)){
            sb.append("21");
        }
        else if(TradeType.payProxyQry.getTradeType().equals(tradeType)){
            sb.append("31");
        }
        else if(TradeType.payCancel.getTradeType().equals(tradeType)){
            sb.append("50");
        }
        else if(TradeType.payRefund.getTradeType().equals(tradeType)){
            sb.append("51");
        }
        else{
            sb.append("00");
        }
        
        sb.append(System.currentTimeMillis()); //13位
        Random random = new Random();
        sb.append(random.nextInt(2)); //加1位随机整数
        return sb.toString();
    }
    
    public static String getDataFromxmlMap(Map<String, String> xmlMap)
    {
      StringBuffer sb = new StringBuffer(200);
      for (Map.Entry entry : xmlMap.entrySet()) {
        sb.append(entry.getValue().toString());
      }
      return sb.toString();
    }
}
