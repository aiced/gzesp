package com.ai.gzesp.unionpay;

/**
 * 银联接口 请求响应xml报文里所有属性<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnionPayAttrs {

    public static String accNo = "accNo" ; //银行卡号
    public static String AccountID = "AccountID" ; //帐单号（根据业务类型的需求来填写）
    public static String AreaCode = "AreaCode" ; //地区代码
    public static String bmMerId = "bmMerId" ; //前置平台获批后分配的商户身份ID
    public static String BusiType = "BusiType"  ; //业务类型
    public static String cardType = "cardType"  ; //卡类型（信用卡:01或借记卡:02）
    public static String certificateCode = "certificateCode" ; //证件编号：持卡人身份认证信息
    public static String ChannelID = "ChannelID"  ; //发送渠道号
    public static String charCode = "charCode"  ; //参数编码方式，推荐用gbk。
    public static String creditNo = "creditNo"  ; //转入信用卡卡号
    public static String currencyCode = "currencyCode" ; //交易货币代码
    public static String cvn2 = "cvn2" ; //CVN2
    public static String expireDate = "expireDate"; //有效期
    public static String industryType = "industryType" ; //支付行业类型
    public static String md5ConSec = "md5ConSec" ; //加密后的摘要
    public static String MerType = "MerType" ; //商户类型
    public static String Name = "Name"  ; //姓名
    public static String Nbr = "Nbr" ; //手机号
    public static String orderId = "orderId" ; //退款订单号
    public static String origOrderId = "origOrderId"  ; //原支付交易订单号
    public static String origsignCode = "origsignCode"  ; //原交易签约号
    public static String origsysTradeNo = "origsysTradeNo"; //原交易系统跟踪号
    public static String origtimeStamp = "origtimeStamp" ; //原退款时间
    public static String origtxnAmt = "origtxnAmt"; //原交易交易金额(单位：分)
    public static String Pin = "Pin"  ; //转出卡密码（需加密）
    public static String resultCode = "resultCode"; //应答码
    public static String resultDesc = "resultDesc"; //应答描述
    public static String settleDate = "settleDate"; //清算日期，格式：MMDD
    public static String signCode = "signCode"  ; //签约号
    public static String sysTradeNo = "sysTradeNo"; //受卡方系统跟踪号，作为对应请求交易的编号。
    public static String timeStamp = "timeStamp"; //时间戳，当前接口调用时间，具体格式: yyyyMMddHHmmss
    public static String Track2 = "Track2"; //转出卡二磁道信息（需加密）
    public static String TradeType = "TradeType" ; //交易类型
    public static String txnAmt = "txnAmt"; //交易金额（单位：分）
    public static String Version = "Version" ; //接口版本号（2.0.1）
    public static String IcData = "IcData"; //IC卡数据
    public static String ifInstal = "ifInstal"; //是否做分期付款（0表示不分期1表示分期）
    public static String instalTransInfo = "instalTransInfo"; //分期付款期数（两位数字，比如分为6期取值为06）

}
