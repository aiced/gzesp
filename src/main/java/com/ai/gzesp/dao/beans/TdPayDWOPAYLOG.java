package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 微信支付接口日志<br>
	 * 微信后台通知的日志
 */
/**
 * @ClassName: TdPayDWOPAYLOG
* @Description: PAY_D_WOPAY_LOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdPayDWOPAYLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 接口调用id
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.LOG_ID :接口调用id
     */
    private Long logId;

    /**
     * 分区标识,流水id后2位
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PARTITION_ID :分区标识,流水id后2位
     */
    private Short partitionId;

    /**
     * 支付交易流水号
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PAY_FLOOD_ID :支付交易流水号
     */
    private String payFloodId;

    /**
     * 支付结果<br>
	 * 1:成功 0:失败
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PAY_RESULT :支付结果
1:成功 0:失败
     */
    private String payResult;

    /**
     * 支付金额<br>
	 * 沃支付单位分，表里存放单位厘
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PAY_BALANCE :支付金额
沃支付单位分，表里存放单位厘
     */
    private BigDecimal payBalance;

    /**
     * 此字段仅对特殊商户适用，无特殊约定商户请忽略。<br>
	 * 02-现金，03-一卡充<br>
	 * 如：02:300,03:0<br>
	 * 表示:现金:300分,充值卡：0分。
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PAYMENT_BALANCE_DETAIL :此字段仅对特殊商户适用，无特殊约定商户请忽略。
02-现金，03-一卡充
如：02:300,03:0
表示:现金:300分,充值卡：0分。
     */
    private String paymentBalanceDetail;

    /**
     * 受理时间（订单支付的成功时间，与对账文件中一致）<br>
	 * yyyyMMddHH24mmss
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.RESP_TIME :受理时间（订单支付的成功时间，与对账文件中一致）
yyyyMMddHH24mmss
     */
    private String respTime;

    /**
     * 为“1”浏览器重定向<br>
	 * 为“2”服务器点对点通讯
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.RE_TYPE :为“1”浏览器重定向
为“2”服务器点对点通讯
     */
    private String reType;

    /**
     * 商户用户id,请求中一致
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.USER_ID :商户用户id,请求中一致
     */
    private String userId;

    /**
     * 返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.PASSPORT :返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    private String passport;

    /**
     * 将请求的参数保持不变返回<br>
	 * (仅限浏览器回调,后台点对点回调默认返回2)
     */
    /**
     * @Fields PAY_D_WOPAY_LOG.MP :将请求的参数保持不变返回
(仅限浏览器回调,后台点对点回调默认返回2)
     */
    private String mp;

    /**
     * @return 接口调用id
     */
    /**
     * @return PAY_D_WOPAY_LOG.LOG_ID : 返回 接口调用id
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * @param logId 
	 *            接口调用id
     */
    /**
     * @param logId of PAY_D_WOPAY_LOG : 设置 接口调用id
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * @return 分区标识,流水id后2位
     */
    /**
     * @return PAY_D_WOPAY_LOG.PARTITION_ID : 返回 分区标识,流水id后2位
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识,流水id后2位
     */
    /**
     * @param partitionId of PAY_D_WOPAY_LOG : 设置 分区标识,流水id后2位
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 支付交易流水号
     */
    /**
     * @return PAY_D_WOPAY_LOG.PAY_FLOOD_ID : 返回 支付交易流水号
     */
    public String getPayFloodId() {
        return payFloodId;
    }

    /**
     * @param payFloodId 
	 *            支付交易流水号
     */
    /**
     * @param payFloodId of PAY_D_WOPAY_LOG : 设置 支付交易流水号
     */
    public void setPayFloodId(String payFloodId) {
        this.payFloodId = payFloodId == null ? null : payFloodId.trim();
    }

    /**
     * @return 支付结果<br>
	 *         1:成功 0:失败
     */
    /**
     * @return PAY_D_WOPAY_LOG.PAY_RESULT : 返回 支付结果
1:成功 0:失败
     */
    public String getPayResult() {
        return payResult;
    }

    /**
     * @param payResult 
	 *            支付结果<br>
	 *            1:成功 0:失败
     */
    /**
     * @param payResult of PAY_D_WOPAY_LOG : 设置 支付结果
1:成功 0:失败
     */
    public void setPayResult(String payResult) {
        this.payResult = payResult == null ? null : payResult.trim();
    }

    /**
     * @return 支付金额<br>
	 *         沃支付单位分，表里存放单位厘
     */
    /**
     * @return PAY_D_WOPAY_LOG.PAY_BALANCE : 返回 支付金额
沃支付单位分，表里存放单位厘
     */
    public BigDecimal getPayBalance() {
        return payBalance;
    }

    /**
     * @param payBalance 
	 *            支付金额<br>
	 *            沃支付单位分，表里存放单位厘
     */
    /**
     * @param payBalance of PAY_D_WOPAY_LOG : 设置 支付金额
沃支付单位分，表里存放单位厘
     */
    public void setPayBalance(BigDecimal payBalance) {
        this.payBalance = payBalance;
    }

    /**
     * @return 此字段仅对特殊商户适用，无特殊约定商户请忽略。<br>
	 *         02-现金，03-一卡充<br>
	 *         如：02:300,03:0<br>
	 *         表示:现金:300分,充值卡：0分。
     */
    /**
     * @return PAY_D_WOPAY_LOG.PAYMENT_BALANCE_DETAIL : 返回 此字段仅对特殊商户适用，无特殊约定商户请忽略。
02-现金，03-一卡充
如：02:300,03:0
表示:现金:300分,充值卡：0分。
     */
    public String getPaymentBalanceDetail() {
        return paymentBalanceDetail;
    }

    /**
     * @param paymentBalanceDetail 
	 *            此字段仅对特殊商户适用，无特殊约定商户请忽略。<br>
	 *            02-现金，03-一卡充<br>
	 *            如：02:300,03:0<br>
	 *            表示:现金:300分,充值卡：0分。
     */
    /**
     * @param paymentBalanceDetail of PAY_D_WOPAY_LOG : 设置 此字段仅对特殊商户适用，无特殊约定商户请忽略。
02-现金，03-一卡充
如：02:300,03:0
表示:现金:300分,充值卡：0分。
     */
    public void setPaymentBalanceDetail(String paymentBalanceDetail) {
        this.paymentBalanceDetail = paymentBalanceDetail == null ? null : paymentBalanceDetail.trim();
    }

    /**
     * @return 受理时间（订单支付的成功时间，与对账文件中一致）<br>
	 *         yyyyMMddHH24mmss
     */
    /**
     * @return PAY_D_WOPAY_LOG.RESP_TIME : 返回 受理时间（订单支付的成功时间，与对账文件中一致）
yyyyMMddHH24mmss
     */
    public String getRespTime() {
        return respTime;
    }

    /**
     * @param respTime 
	 *            受理时间（订单支付的成功时间，与对账文件中一致）<br>
	 *            yyyyMMddHH24mmss
     */
    /**
     * @param respTime of PAY_D_WOPAY_LOG : 设置 受理时间（订单支付的成功时间，与对账文件中一致）
yyyyMMddHH24mmss
     */
    public void setRespTime(String respTime) {
        this.respTime = respTime == null ? null : respTime.trim();
    }

    /**
     * @return 为“1”浏览器重定向<br>
	 *         为“2”服务器点对点通讯
     */
    /**
     * @return PAY_D_WOPAY_LOG.RE_TYPE : 返回 为“1”浏览器重定向
为“2”服务器点对点通讯
     */
    public String getReType() {
        return reType;
    }

    /**
     * @param reType 
	 *            为“1”浏览器重定向<br>
	 *            为“2”服务器点对点通讯
     */
    /**
     * @param reType of PAY_D_WOPAY_LOG : 设置 为“1”浏览器重定向
为“2”服务器点对点通讯
     */
    public void setReType(String reType) {
        this.reType = reType == null ? null : reType.trim();
    }

    /**
     * @return 商户用户id,请求中一致
     */
    /**
     * @return PAY_D_WOPAY_LOG.USER_ID : 返回 商户用户id,请求中一致
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            商户用户id,请求中一致
     */
    /**
     * @param userId of PAY_D_WOPAY_LOG : 设置 商户用户id,请求中一致
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    /**
     * @return PAY_D_WOPAY_LOG.PASSPORT : 返回 返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport 
	 *            返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    /**
     * @param passport of PAY_D_WOPAY_LOG : 设置 返回扣款成功的沃支付账户号 （安全起见，暂不返回任何值）
     */
    public void setPassport(String passport) {
        this.passport = passport == null ? null : passport.trim();
    }

    /**
     * @return 将请求的参数保持不变返回<br>
	 *         (仅限浏览器回调,后台点对点回调默认返回2)
     */
    /**
     * @return PAY_D_WOPAY_LOG.MP : 返回 将请求的参数保持不变返回
(仅限浏览器回调,后台点对点回调默认返回2)
     */
    public String getMp() {
        return mp;
    }

    /**
     * @param mp 
	 *            将请求的参数保持不变返回<br>
	 *            (仅限浏览器回调,后台点对点回调默认返回2)
     */
    /**
     * @param mp of PAY_D_WOPAY_LOG : 设置 将请求的参数保持不变返回
(仅限浏览器回调,后台点对点回调默认返回2)
     */
    public void setMp(String mp) {
        this.mp = mp == null ? null : mp.trim();
    }
}