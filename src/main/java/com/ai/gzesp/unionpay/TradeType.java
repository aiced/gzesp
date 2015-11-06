package com.ai.gzesp.unionpay;

/**
 * 银联接口 交易类型 映射关系枚举类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum TradeType {
    //请求
    bind("0120", "银行卡绑定请求"),
    pay("0200", "支付请求"),
    payNew("0202", "全要素支付请求"),
    payProxy("0250", "代付请求"),
    payCancel("0970", "支付撤消(指当日交易撤消)请求"),
    payRefund("0900", "支付退款(非当日交易)请求"),
    bindCancel("0150", "银行卡绑定关系撤销"),
    
    bindQry("0100", "银行卡绑定关系查询请求"),
    payQry("0300", "支付结果查询请求"),
    payProxyQry("0370", "代付结果查询请求"),
    payCancelQry("0320", "支付撤消(指当日交易撤消)结果查询请求"),
    payRefundQry("0350", "支付退款(非当日交易)结果查询请求"),
    
    //响应
    bindRsp("0130", "银行卡绑定响应"),
    payRsp("0210", "支付响应"),
    payNewRsp("0203", "全要素支付响应"),
    payProxyRsp("0260", "代付响应"),
    payCancelRsp("0980", "支付撤消(指当日交易撤消)响应"),
    payRefundRsp("0910", "支付退款(非当日交易)响应"),
    bindCancelRsp("0160", "银行卡绑定关系撤销响应"),
    
    bindQryRsp("0110", "银行卡绑定关系查询响应"),
    payQryRsp("0310", "支付结果查询响应"),
    payProxyQryRsp("0380", "代付结果查询响应"),
    payCancelQryRsp("0330", "支付撤消(指当日交易撤消)结果查询响应"),
    payRefundQryRsp("0360", "支付退款(非当日交易)结果查询响应");

    private String tradeType;
    
    private String tradeName;
    
    private TradeType(String tradeType, String tradeName){
        this.tradeType = tradeType;
        this.tradeName = tradeName;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
    
    
}
