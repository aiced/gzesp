package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 微信支付接口日志<br>
	 * 微信后台通知的日志
 */
/**
 * @ClassName: TdITFDWEIXINLOG
* @Description: ITF_D_WEIXIN_LOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdITFDWEIXINLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 交易日期<br>
	 * 支付发生的日期或者退款发生的日期
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TRADE_DAY :交易日期
支付发生的日期或者退款发生的日期
     */
    private String tradeDay;

    /**
     * 交易时间
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TRADE_TIME :交易时间
     */
    private String tradeTime;

    /**
     * 微信分配的公众账号ID<br>
	 * 
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.APP_ID :微信分配的公众账号ID

     */
    private String appId;

    /**
     *  微信支付分配的商户号 
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.MCH_ID : 微信支付分配的商户号 
     */
    private String mchId;

    /**
     * @Fields ITF_D_WEIXIN_LOG.SUB_MCH_ID :null
     */
    private String subMchId;

    /**
     * 微信支付分配的终端设备号
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.DEVICE_INFO :微信支付分配的终端设备号
     */
    private String deviceInfo;

    /**
     * 微信支付订单号
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TRANSACTION_ID :微信支付订单号
     */
    private String transactionId;

    /**
     * 支付：商户系统的订单号，与请求一致<br>
	 * 退款：商户系统内部的订单号,<br>
	 * transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no<br>
	 * 
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.OUTER_TRADE_NO :支付：商户系统的订单号，与请求一致
退款：商户系统内部的订单号,
transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no

     */
    private String outerTradeNo;

    /**
     * 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服<br>
	 * 务。
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.OPEN_ID :支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
务。
     */
    private String openId;

    /**
     * JSAPI、NATIVE、APP 
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TRADE_TYPE :JSAPI、NATIVE、APP 
     */
    private String tradeType;

    /**
     * 订单查询接口时返回：<br>
	 * SUCCESS—支付成功<br>
	 * REFUND—转入退款<br>
	 * NOTPAY—未支付<br>
	 * CLOSED—已关闭<br>
	 * REVOKED—已撤销<br>
	 * USERPAYING--用户支付中<br>
	 * PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TRADE_STATE :订单查询接口时返回：
SUCCESS—支付成功
REFUND—转入退款
NOTPAY—未支付
CLOSED—已关闭
REVOKED—已撤销
USERPAYING--用户支付中
PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    private String tradeState;

    /**
     * 银行类型，在微信中使用WX
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.BANK_TYPE :银行类型，在微信中使用WX
     */
    private String bankType;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.FEE_TYPE :货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    private String feeType;

    /**
     * 总金额(厘)<br>
	 * 支付金额，微信里单位为分，表里存厘，如果discount<br>
	 * 有值，通知的total_fee + discount =<br>
	 * 请求的total_fee
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.TOTAL_FEE :总金额(厘)
支付金额，微信里单位为分，表里存厘，如果discount
有值，通知的total_fee + discount =
请求的total_fee
     */
    private Long totalFee;

    /**
     * 企业红包金额
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.CUPON_FEE :企业红包金额
     */
    private Long cuponFee;

    /**
     * 微信退款单号
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.WX_REFUND_NO :微信退款单号
     */
    private String wxRefundNo;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.OUT_REFUND_NO :商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    private String outRefundNo;

    /**
     * 退款总金额(厘)
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.REFUND_FEE :退款总金额(厘)
     */
    private Long refundFee;

    /**
     * 企业红包退款金额
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.REFUND_CUPON_FEE :企业红包退款金额
     */
    private Long refundCuponFee;

    /**
     * 退款类型
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.REFUND_TYPE :退款类型
     */
    private String refundType;

    /**
     * 退款状态
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.REFUND_STATE :退款状态
     */
    private String refundState;

    /**
     * 商品名称
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.GOODS_NAME :商品名称
     */
    private String goodsName;

    /**
     * 手续费
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.SERVICE_FEE :手续费
     */
    private String serviceFee;

    /**
     * 手续费率
     */
    /**
     * @Fields ITF_D_WEIXIN_LOG.SERVICE_FEE_RATE :手续费率
     */
    private String serviceFeeRate;

    /**
     * @return 交易日期<br>
	 *         支付发生的日期或者退款发生的日期
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TRADE_DAY : 返回 交易日期
支付发生的日期或者退款发生的日期
     */
    public String getTradeDay() {
        return tradeDay;
    }

    /**
     * @param tradeDay 
	 *            交易日期<br>
	 *            支付发生的日期或者退款发生的日期
     */
    /**
     * @param tradeDay of ITF_D_WEIXIN_LOG : 设置 交易日期
支付发生的日期或者退款发生的日期
     */
    public void setTradeDay(String tradeDay) {
        this.tradeDay = tradeDay == null ? null : tradeDay.trim();
    }

    /**
     * @return 交易时间
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TRADE_TIME : 返回 交易时间
     */
    public String getTradeTime() {
        return tradeTime;
    }

    /**
     * @param tradeTime 
	 *            交易时间
     */
    /**
     * @param tradeTime of ITF_D_WEIXIN_LOG : 设置 交易时间
     */
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime == null ? null : tradeTime.trim();
    }

    /**
     * @return 微信分配的公众账号ID<br>
	 *         
     */
    /**
     * @return ITF_D_WEIXIN_LOG.APP_ID : 返回 微信分配的公众账号ID

     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId 
	 *            微信分配的公众账号ID<br>
	 *            
     */
    /**
     * @param appId of ITF_D_WEIXIN_LOG : 设置 微信分配的公众账号ID

     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return  微信支付分配的商户号 
     */
    /**
     * @return ITF_D_WEIXIN_LOG.MCH_ID : 返回  微信支付分配的商户号 
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * @param mchId 
	 *             微信支付分配的商户号 
     */
    /**
     * @param mchId of ITF_D_WEIXIN_LOG : 设置  微信支付分配的商户号 
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * @return ITF_D_WEIXIN_LOG.SUB_MCH_ID : 返回 null
     */
    public String getSubMchId() {
        return subMchId;
    }

    /**
     * @param subMchId of ITF_D_WEIXIN_LOG : 设置 null
     */
    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
    }

    /**
     * @return 微信支付分配的终端设备号
     */
    /**
     * @return ITF_D_WEIXIN_LOG.DEVICE_INFO : 返回 微信支付分配的终端设备号
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * @param deviceInfo 
	 *            微信支付分配的终端设备号
     */
    /**
     * @param deviceInfo of ITF_D_WEIXIN_LOG : 设置 微信支付分配的终端设备号
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    /**
     * @return 微信支付订单号
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TRANSACTION_ID : 返回 微信支付订单号
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId 
	 *            微信支付订单号
     */
    /**
     * @param transactionId of ITF_D_WEIXIN_LOG : 设置 微信支付订单号
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * @return 支付：商户系统的订单号，与请求一致<br>
	 *         退款：商户系统内部的订单号,<br>
	 *         transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no<br>
	 *         
     */
    /**
     * @return ITF_D_WEIXIN_LOG.OUTER_TRADE_NO : 返回 支付：商户系统的订单号，与请求一致
退款：商户系统内部的订单号,
transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no

     */
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    /**
     * @param outerTradeNo 
	 *            支付：商户系统的订单号，与请求一致<br>
	 *            退款：商户系统内部的订单号,<br>
	 *            transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no<br>
	 *            
     */
    /**
     * @param outerTradeNo of ITF_D_WEIXIN_LOG : 设置 支付：商户系统的订单号，与请求一致
退款：商户系统内部的订单号,
transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no

     */
    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo == null ? null : outerTradeNo.trim();
    }

    /**
     * @return 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服<br>
	 *         务。
     */
    /**
     * @return ITF_D_WEIXIN_LOG.OPEN_ID : 返回 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
务。
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId 
	 *            支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服<br>
	 *            务。
     */
    /**
     * @param openId of ITF_D_WEIXIN_LOG : 设置 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
务。
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return JSAPI、NATIVE、APP 
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TRADE_TYPE : 返回 JSAPI、NATIVE、APP 
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType 
	 *            JSAPI、NATIVE、APP 
     */
    /**
     * @param tradeType of ITF_D_WEIXIN_LOG : 设置 JSAPI、NATIVE、APP 
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * @return 订单查询接口时返回：<br>
	 *         SUCCESS—支付成功<br>
	 *         REFUND—转入退款<br>
	 *         NOTPAY—未支付<br>
	 *         CLOSED—已关闭<br>
	 *         REVOKED—已撤销<br>
	 *         USERPAYING--用户支付中<br>
	 *         PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TRADE_STATE : 返回 订单查询接口时返回：
SUCCESS—支付成功
REFUND—转入退款
NOTPAY—未支付
CLOSED—已关闭
REVOKED—已撤销
USERPAYING--用户支付中
PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    public String getTradeState() {
        return tradeState;
    }

    /**
     * @param tradeState 
	 *            订单查询接口时返回：<br>
	 *            SUCCESS—支付成功<br>
	 *            REFUND—转入退款<br>
	 *            NOTPAY—未支付<br>
	 *            CLOSED—已关闭<br>
	 *            REVOKED—已撤销<br>
	 *            USERPAYING--用户支付中<br>
	 *            PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    /**
     * @param tradeState of ITF_D_WEIXIN_LOG : 设置 订单查询接口时返回：
SUCCESS—支付成功
REFUND—转入退款
NOTPAY—未支付
CLOSED—已关闭
REVOKED—已撤销
USERPAYING--用户支付中
PAYERROR--支付失败(其他原因，如银行返回失败) 
     */
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState == null ? null : tradeState.trim();
    }

    /**
     * @return 银行类型，在微信中使用WX
     */
    /**
     * @return ITF_D_WEIXIN_LOG.BANK_TYPE : 返回 银行类型，在微信中使用WX
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * @param bankType 
	 *            银行类型，在微信中使用WX
     */
    /**
     * @param bankType of ITF_D_WEIXIN_LOG : 设置 银行类型，在微信中使用WX
     */
    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    /**
     * @return 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @return ITF_D_WEIXIN_LOG.FEE_TYPE : 返回 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * @param feeType 
	 *            货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @param feeType of ITF_D_WEIXIN_LOG : 设置 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * @return 总金额(厘)<br>
	 *         支付金额，微信里单位为分，表里存厘，如果discount<br>
	 *         有值，通知的total_fee + discount =<br>
	 *         请求的total_fee
     */
    /**
     * @return ITF_D_WEIXIN_LOG.TOTAL_FEE : 返回 总金额(厘)
支付金额，微信里单位为分，表里存厘，如果discount
有值，通知的total_fee + discount =
请求的total_fee
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee 
	 *            总金额(厘)<br>
	 *            支付金额，微信里单位为分，表里存厘，如果discount<br>
	 *            有值，通知的total_fee + discount =<br>
	 *            请求的total_fee
     */
    /**
     * @param totalFee of ITF_D_WEIXIN_LOG : 设置 总金额(厘)
支付金额，微信里单位为分，表里存厘，如果discount
有值，通知的total_fee + discount =
请求的total_fee
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return 企业红包金额
     */
    /**
     * @return ITF_D_WEIXIN_LOG.CUPON_FEE : 返回 企业红包金额
     */
    public Long getCuponFee() {
        return cuponFee;
    }

    /**
     * @param cuponFee 
	 *            企业红包金额
     */
    /**
     * @param cuponFee of ITF_D_WEIXIN_LOG : 设置 企业红包金额
     */
    public void setCuponFee(Long cuponFee) {
        this.cuponFee = cuponFee;
    }

    /**
     * @return 微信退款单号
     */
    /**
     * @return ITF_D_WEIXIN_LOG.WX_REFUND_NO : 返回 微信退款单号
     */
    public String getWxRefundNo() {
        return wxRefundNo;
    }

    /**
     * @param wxRefundNo 
	 *            微信退款单号
     */
    /**
     * @param wxRefundNo of ITF_D_WEIXIN_LOG : 设置 微信退款单号
     */
    public void setWxRefundNo(String wxRefundNo) {
        this.wxRefundNo = wxRefundNo == null ? null : wxRefundNo.trim();
    }

    /**
     * @return 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @return ITF_D_WEIXIN_LOG.OUT_REFUND_NO : 返回 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * @param outRefundNo 
	 *            商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @param outRefundNo of ITF_D_WEIXIN_LOG : 设置 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    /**
     * @return 退款总金额(厘)
     */
    /**
     * @return ITF_D_WEIXIN_LOG.REFUND_FEE : 返回 退款总金额(厘)
     */
    public Long getRefundFee() {
        return refundFee;
    }

    /**
     * @param refundFee 
	 *            退款总金额(厘)
     */
    /**
     * @param refundFee of ITF_D_WEIXIN_LOG : 设置 退款总金额(厘)
     */
    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
    }

    /**
     * @return 企业红包退款金额
     */
    /**
     * @return ITF_D_WEIXIN_LOG.REFUND_CUPON_FEE : 返回 企业红包退款金额
     */
    public Long getRefundCuponFee() {
        return refundCuponFee;
    }

    /**
     * @param refundCuponFee 
	 *            企业红包退款金额
     */
    /**
     * @param refundCuponFee of ITF_D_WEIXIN_LOG : 设置 企业红包退款金额
     */
    public void setRefundCuponFee(Long refundCuponFee) {
        this.refundCuponFee = refundCuponFee;
    }

    /**
     * @return 退款类型
     */
    /**
     * @return ITF_D_WEIXIN_LOG.REFUND_TYPE : 返回 退款类型
     */
    public String getRefundType() {
        return refundType;
    }

    /**
     * @param refundType 
	 *            退款类型
     */
    /**
     * @param refundType of ITF_D_WEIXIN_LOG : 设置 退款类型
     */
    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    /**
     * @return 退款状态
     */
    /**
     * @return ITF_D_WEIXIN_LOG.REFUND_STATE : 返回 退款状态
     */
    public String getRefundState() {
        return refundState;
    }

    /**
     * @param refundState 
	 *            退款状态
     */
    /**
     * @param refundState of ITF_D_WEIXIN_LOG : 设置 退款状态
     */
    public void setRefundState(String refundState) {
        this.refundState = refundState == null ? null : refundState.trim();
    }

    /**
     * @return 商品名称
     */
    /**
     * @return ITF_D_WEIXIN_LOG.GOODS_NAME : 返回 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName 
	 *            商品名称
     */
    /**
     * @param goodsName of ITF_D_WEIXIN_LOG : 设置 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return 手续费
     */
    /**
     * @return ITF_D_WEIXIN_LOG.SERVICE_FEE : 返回 手续费
     */
    public String getServiceFee() {
        return serviceFee;
    }

    /**
     * @param serviceFee 
	 *            手续费
     */
    /**
     * @param serviceFee of ITF_D_WEIXIN_LOG : 设置 手续费
     */
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee == null ? null : serviceFee.trim();
    }

    /**
     * @return 手续费率
     */
    /**
     * @return ITF_D_WEIXIN_LOG.SERVICE_FEE_RATE : 返回 手续费率
     */
    public String getServiceFeeRate() {
        return serviceFeeRate;
    }

    /**
     * @param serviceFeeRate 
	 *            手续费率
     */
    /**
     * @param serviceFeeRate of ITF_D_WEIXIN_LOG : 设置 手续费率
     */
    public void setServiceFeeRate(String serviceFeeRate) {
        this.serviceFeeRate = serviceFeeRate == null ? null : serviceFeeRate.trim();
    }
}