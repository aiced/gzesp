package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 微信支付接口日志<br>
	 * 微信后台通知的日志
 */
/**
 * @ClassName: TdPayDWEIXINLOG
* @Description: PAY_D_WEIXIN_LOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdPayDWEIXINLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 接口调用id
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.LOG_ID :接口调用id
     */
    private Long logId;

    /**
     * 分区标识,流水id后2位
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.PARTITION_ID :分区标识,流水id后2位
     */
    private Short partitionId;

    /**
     * 01：统一下单<br>
	 * 02：查询订单<br>
	 * 03：关闭订单<br>
	 * 04：申请退款<br>
	 * 05：查询退款
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.REQ_TYPE :01：统一下单
02：查询订单
03：关闭订单
04：申请退款
05：查询退款
     */
    private String reqType;

    /**
     * SUCCESS/FAIL<br>
	 * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断<br>
	 *  
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.RETURN_CODE :SUCCESS/FAIL
此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
 
     */
    private String returnCode;

    /**
     * 返回信息，如非空，为错误原因<br>
	 * 如：签名失败 参数格式校验错误
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.RETURN_MSG :返回信息，如非空，为错误原因
如：签名失败 参数格式校验错误
     */
    private String returnMsg;

    /**
     * 微信分配的公众账号ID<br>
	 * 
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.APP_ID :微信分配的公众账号ID

     */
    private String appId;

    /**
     *  微信支付分配的商户号 
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.MCH_ID : 微信支付分配的商户号 
     */
    private String mchId;

    /**
     * 微信支付分配的终端设备号
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.DEVICE_INFO :微信支付分配的终端设备号
     */
    private String deviceInfo;

    /**
     * 随机字符串，不长于32位
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.NONCE_STR :随机字符串，不长于32位
     */
    private String nonceStr;

    /**
     * 签名算法见微信支付文档
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.SIGN :签名算法见微信支付文档
     */
    private String sign;

    /**
     * SUCCESS/FAIL<br>
	 * 
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.RESULT_CODE :SUCCESS/FAIL

     */
    private String resultCode;

    /**
     * 详细参见第6节错误列表
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.ERR_CODE :详细参见第6节错误列表
     */
    private String errCode;

    /**
     * @Fields PAY_D_WEIXIN_LOG.ERR_CODE_DES :null
     */
    private String errCodeDes;

    /**
     * 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服<br>
	 * 务。
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.OPEN_ID :支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
务。
     */
    private String openId;

    /**
     * 用户是否关注了公众号。1 为关注，0 为未关注。
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.IS_SUBSCRIBE :用户是否关注了公众号。1 为关注，0 为未关注。
     */
    private String isSubscribe;

    /**
     * JSAPI、NATIVE、APP 
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.TRADE_TYPE :JSAPI、NATIVE、APP 
     */
    private String tradeType;

    /**
     * 银行类型，在微信中使用WX
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.BANK_TYPE :银行类型，在微信中使用WX
     */
    private String bankType;

    /**
     * 总金额(厘)<br>
	 * 支付金额，微信里单位为分，表里存厘，如果discount<br>
	 * 有值，通知的total_fee + discount =<br>
	 * 请求的total_fee
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.TOTAL_FEE :总金额(厘)
支付金额，微信里单位为分，表里存厘，如果discount
有值，通知的total_fee + discount =
请求的total_fee
     */
    private Long totalFee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.FEE_TYPE :货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    private String feeType;

    /**
     * 现金支付金额订单现金支付金额
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.CASH_FEE :现金支付金额订单现金支付金额
     */
    private Long cashFee;

    /**
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.CASH_FEE_TYPE :货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    private String cashFeeType;

    /**
     * 微信支付订单号
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.TRANSACTION_ID :微信支付订单号
     */
    private String transactionId;

    /**
     * 支付：商户系统的订单号，与请求一致<br>
	 * 退款：商户系统内部的订单号,<br>
	 * transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no<br>
	 * 
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.OUTER_TRADE_NO :支付：商户系统的订单号，与请求一致
退款：商户系统内部的订单号,
transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no

     */
    private String outerTradeNo;

    /**
     * 支付完成时间， 格式为<br>
	 * yyyyMMddhhmmss，如2009 年12<br>
	 * 月27 日9 点10 分10 秒表示为<br>
	 * 20091227091010。时区为GMT+8<br>
	 * beijing。
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.TIME_END :支付完成时间， 格式为
yyyyMMddhhmmss，如2009 年12
月27 日9 点10 分10 秒表示为
20091227091010。时区为GMT+8
beijing。
     */
    private String timeEnd;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.OUT_REFUND_NO :商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    private String outRefundNo;

    /**
     * 退款总金额(厘)
     */
    /**
     * @Fields PAY_D_WEIXIN_LOG.REFUND_FEE :退款总金额(厘)
     */
    private Long refundFee;

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
     * @Fields PAY_D_WEIXIN_LOG.TRADE_STATE :订单查询接口时返回：
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
     * @return 接口调用id
     */
    /**
     * @return PAY_D_WEIXIN_LOG.LOG_ID : 返回 接口调用id
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * @param logId 
	 *            接口调用id
     */
    /**
     * @param logId of PAY_D_WEIXIN_LOG : 设置 接口调用id
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * @return 分区标识,流水id后2位
     */
    /**
     * @return PAY_D_WEIXIN_LOG.PARTITION_ID : 返回 分区标识,流水id后2位
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识,流水id后2位
     */
    /**
     * @param partitionId of PAY_D_WEIXIN_LOG : 设置 分区标识,流水id后2位
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 01：统一下单<br>
	 *         02：查询订单<br>
	 *         03：关闭订单<br>
	 *         04：申请退款<br>
	 *         05：查询退款
     */
    /**
     * @return PAY_D_WEIXIN_LOG.REQ_TYPE : 返回 01：统一下单
02：查询订单
03：关闭订单
04：申请退款
05：查询退款
     */
    public String getReqType() {
        return reqType;
    }

    /**
     * @param reqType 
	 *            01：统一下单<br>
	 *            02：查询订单<br>
	 *            03：关闭订单<br>
	 *            04：申请退款<br>
	 *            05：查询退款
     */
    /**
     * @param reqType of PAY_D_WEIXIN_LOG : 设置 01：统一下单
02：查询订单
03：关闭订单
04：申请退款
05：查询退款
     */
    public void setReqType(String reqType) {
        this.reqType = reqType == null ? null : reqType.trim();
    }

    /**
     * @return SUCCESS/FAIL<br>
	 *         此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断<br>
	 *          
     */
    /**
     * @return PAY_D_WEIXIN_LOG.RETURN_CODE : 返回 SUCCESS/FAIL
此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
 
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * @param returnCode 
	 *            SUCCESS/FAIL<br>
	 *            此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断<br>
	 *             
     */
    /**
     * @param returnCode of PAY_D_WEIXIN_LOG : 设置 SUCCESS/FAIL
此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
 
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * @return 返回信息，如非空，为错误原因<br>
	 *         如：签名失败 参数格式校验错误
     */
    /**
     * @return PAY_D_WEIXIN_LOG.RETURN_MSG : 返回 返回信息，如非空，为错误原因
如：签名失败 参数格式校验错误
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * @param returnMsg 
	 *            返回信息，如非空，为错误原因<br>
	 *            如：签名失败 参数格式校验错误
     */
    /**
     * @param returnMsg of PAY_D_WEIXIN_LOG : 设置 返回信息，如非空，为错误原因
如：签名失败 参数格式校验错误
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * @return 微信分配的公众账号ID<br>
	 *         
     */
    /**
     * @return PAY_D_WEIXIN_LOG.APP_ID : 返回 微信分配的公众账号ID

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
     * @param appId of PAY_D_WEIXIN_LOG : 设置 微信分配的公众账号ID

     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return  微信支付分配的商户号 
     */
    /**
     * @return PAY_D_WEIXIN_LOG.MCH_ID : 返回  微信支付分配的商户号 
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * @param mchId 
	 *             微信支付分配的商户号 
     */
    /**
     * @param mchId of PAY_D_WEIXIN_LOG : 设置  微信支付分配的商户号 
     */
    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    /**
     * @return 微信支付分配的终端设备号
     */
    /**
     * @return PAY_D_WEIXIN_LOG.DEVICE_INFO : 返回 微信支付分配的终端设备号
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * @param deviceInfo 
	 *            微信支付分配的终端设备号
     */
    /**
     * @param deviceInfo of PAY_D_WEIXIN_LOG : 设置 微信支付分配的终端设备号
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    /**
     * @return 随机字符串，不长于32位
     */
    /**
     * @return PAY_D_WEIXIN_LOG.NONCE_STR : 返回 随机字符串，不长于32位
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * @param nonceStr 
	 *            随机字符串，不长于32位
     */
    /**
     * @param nonceStr of PAY_D_WEIXIN_LOG : 设置 随机字符串，不长于32位
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr == null ? null : nonceStr.trim();
    }

    /**
     * @return 签名算法见微信支付文档
     */
    /**
     * @return PAY_D_WEIXIN_LOG.SIGN : 返回 签名算法见微信支付文档
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign 
	 *            签名算法见微信支付文档
     */
    /**
     * @param sign of PAY_D_WEIXIN_LOG : 设置 签名算法见微信支付文档
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * @return SUCCESS/FAIL<br>
	 *         
     */
    /**
     * @return PAY_D_WEIXIN_LOG.RESULT_CODE : 返回 SUCCESS/FAIL

     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode 
	 *            SUCCESS/FAIL<br>
	 *            
     */
    /**
     * @param resultCode of PAY_D_WEIXIN_LOG : 设置 SUCCESS/FAIL

     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    /**
     * @return 详细参见第6节错误列表
     */
    /**
     * @return PAY_D_WEIXIN_LOG.ERR_CODE : 返回 详细参见第6节错误列表
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode 
	 *            详细参见第6节错误列表
     */
    /**
     * @param errCode of PAY_D_WEIXIN_LOG : 设置 详细参见第6节错误列表
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    /**
     * @return PAY_D_WEIXIN_LOG.ERR_CODE_DES : 返回 null
     */
    public String getErrCodeDes() {
        return errCodeDes;
    }

    /**
     * @param errCodeDes of PAY_D_WEIXIN_LOG : 设置 null
     */
    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes == null ? null : errCodeDes.trim();
    }

    /**
     * @return 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服<br>
	 *         务。
     */
    /**
     * @return PAY_D_WEIXIN_LOG.OPEN_ID : 返回 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
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
     * @param openId of PAY_D_WEIXIN_LOG : 设置 支付该笔订单的用户ID，商户可通过公众号其他接口为付款用户服
务。
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return 用户是否关注了公众号。1 为关注，0 为未关注。
     */
    /**
     * @return PAY_D_WEIXIN_LOG.IS_SUBSCRIBE : 返回 用户是否关注了公众号。1 为关注，0 为未关注。
     */
    public String getIsSubscribe() {
        return isSubscribe;
    }

    /**
     * @param isSubscribe 
	 *            用户是否关注了公众号。1 为关注，0 为未关注。
     */
    /**
     * @param isSubscribe of PAY_D_WEIXIN_LOG : 设置 用户是否关注了公众号。1 为关注，0 为未关注。
     */
    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe == null ? null : isSubscribe.trim();
    }

    /**
     * @return JSAPI、NATIVE、APP 
     */
    /**
     * @return PAY_D_WEIXIN_LOG.TRADE_TYPE : 返回 JSAPI、NATIVE、APP 
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType 
	 *            JSAPI、NATIVE、APP 
     */
    /**
     * @param tradeType of PAY_D_WEIXIN_LOG : 设置 JSAPI、NATIVE、APP 
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * @return 银行类型，在微信中使用WX
     */
    /**
     * @return PAY_D_WEIXIN_LOG.BANK_TYPE : 返回 银行类型，在微信中使用WX
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * @param bankType 
	 *            银行类型，在微信中使用WX
     */
    /**
     * @param bankType of PAY_D_WEIXIN_LOG : 设置 银行类型，在微信中使用WX
     */
    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    /**
     * @return 总金额(厘)<br>
	 *         支付金额，微信里单位为分，表里存厘，如果discount<br>
	 *         有值，通知的total_fee + discount =<br>
	 *         请求的total_fee
     */
    /**
     * @return PAY_D_WEIXIN_LOG.TOTAL_FEE : 返回 总金额(厘)
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
     * @param totalFee of PAY_D_WEIXIN_LOG : 设置 总金额(厘)
支付金额，微信里单位为分，表里存厘，如果discount
有值，通知的total_fee + discount =
请求的total_fee
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @return PAY_D_WEIXIN_LOG.FEE_TYPE : 返回 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * @param feeType 
	 *            货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @param feeType of PAY_D_WEIXIN_LOG : 设置 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * @return 现金支付金额订单现金支付金额
     */
    /**
     * @return PAY_D_WEIXIN_LOG.CASH_FEE : 返回 现金支付金额订单现金支付金额
     */
    public Long getCashFee() {
        return cashFee;
    }

    /**
     * @param cashFee 
	 *            现金支付金额订单现金支付金额
     */
    /**
     * @param cashFee of PAY_D_WEIXIN_LOG : 设置 现金支付金额订单现金支付金额
     */
    public void setCashFee(Long cashFee) {
        this.cashFee = cashFee;
    }

    /**
     * @return 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @return PAY_D_WEIXIN_LOG.CASH_FEE_TYPE : 返回 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public String getCashFeeType() {
        return cashFeeType;
    }

    /**
     * @param cashFeeType 
	 *            货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    /**
     * @param cashFeeType of PAY_D_WEIXIN_LOG : 设置 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType == null ? null : cashFeeType.trim();
    }

    /**
     * @return 微信支付订单号
     */
    /**
     * @return PAY_D_WEIXIN_LOG.TRANSACTION_ID : 返回 微信支付订单号
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId 
	 *            微信支付订单号
     */
    /**
     * @param transactionId of PAY_D_WEIXIN_LOG : 设置 微信支付订单号
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
     * @return PAY_D_WEIXIN_LOG.OUTER_TRADE_NO : 返回 支付：商户系统的订单号，与请求一致
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
     * @param outerTradeNo of PAY_D_WEIXIN_LOG : 设置 支付：商户系统的订单号，与请求一致
退款：商户系统内部的订单号,
transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no

     */
    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo == null ? null : outerTradeNo.trim();
    }

    /**
     * @return 支付完成时间， 格式为<br>
	 *         yyyyMMddhhmmss，如2009 年12<br>
	 *         月27 日9 点10 分10 秒表示为<br>
	 *         20091227091010。时区为GMT+8<br>
	 *         beijing。
     */
    /**
     * @return PAY_D_WEIXIN_LOG.TIME_END : 返回 支付完成时间， 格式为
yyyyMMddhhmmss，如2009 年12
月27 日9 点10 分10 秒表示为
20091227091010。时区为GMT+8
beijing。
     */
    public String getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd 
	 *            支付完成时间， 格式为<br>
	 *            yyyyMMddhhmmss，如2009 年12<br>
	 *            月27 日9 点10 分10 秒表示为<br>
	 *            20091227091010。时区为GMT+8<br>
	 *            beijing。
     */
    /**
     * @param timeEnd of PAY_D_WEIXIN_LOG : 设置 支付完成时间， 格式为
yyyyMMddhhmmss，如2009 年12
月27 日9 点10 分10 秒表示为
20091227091010。时区为GMT+8
beijing。
     */
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd == null ? null : timeEnd.trim();
    }

    /**
     * @return 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @return PAY_D_WEIXIN_LOG.OUT_REFUND_NO : 返回 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * @param outRefundNo 
	 *            商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    /**
     * @param outRefundNo of PAY_D_WEIXIN_LOG : 设置 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    /**
     * @return 退款总金额(厘)
     */
    /**
     * @return PAY_D_WEIXIN_LOG.REFUND_FEE : 返回 退款总金额(厘)
     */
    public Long getRefundFee() {
        return refundFee;
    }

    /**
     * @param refundFee 
	 *            退款总金额(厘)
     */
    /**
     * @param refundFee of PAY_D_WEIXIN_LOG : 设置 退款总金额(厘)
     */
    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
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
     * @return PAY_D_WEIXIN_LOG.TRADE_STATE : 返回 订单查询接口时返回：
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
     * @param tradeState of PAY_D_WEIXIN_LOG : 设置 订单查询接口时返回：
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
}