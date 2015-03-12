package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单支付信息
 */
/**
 * @ClassName: TdOrdDPAYLOG
* @Description: ORD_D_PAYLOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPAYLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_PAYLOG.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 支付标识
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_LOGID :支付标识
     */
    private Long payLogid;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_PAYLOG.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 支付类型<br>
	 * 在线<br>
	 * 货到
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_TYPE :支付类型
在线
货到
     */
    private String payType;

    /**
     * 支付方式
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_MODE :支付方式
     */
    private String payMode;

    /**
     * 支付请求时间
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_ASK_TIME :支付请求时间
     */
    private Date payAskTime;

    /**
     * 支付完成时间
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_COMPLETE_TIME :支付完成时间
     */
    private Date payCompleteTime;

    /**
     * 本地支付完成时间
     */
    /**
     * @Fields ORD_D_PAYLOG.LOCAL_COMPLETE_TIME :本地支付完成时间
     */
    private Date localCompleteTime;

    /**
     * 币种
     */
    /**
     * @Fields ORD_D_PAYLOG.CURRENCY_TYPE :币种
     */
    private String currencyType;

    /**
     * 支付金额
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_MONEY :支付金额
     */
    private Long payMoney;

    /**
     * 支付状态<br>
	 * 0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_STATE :支付状态
0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    private String payState;

    /**
     * 备注
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_REMARK :备注
     */
    private String payRemark;

    /**
     * 冲正标记
     */
    /**
     * @Fields ORD_D_PAYLOG.HALT_TAG :冲正标记
     */
    private String haltTag;

    /**
     * 冲正时间
     */
    /**
     * @Fields ORD_D_PAYLOG.HALT_TIME :冲正时间
     */
    private Date haltTime;

    /**
     * 退款标志<br>
	 * 0-未退款<br>
	 * 1-需要退款<br>
	 * 2-已退款
     */
    /**
     * @Fields ORD_D_PAYLOG.REFUND_TAG :退款标志
0-未退款
1-需要退款
2-已退款
     */
    private String refundTag;

    /**
     * 退款时间
     */
    /**
     * @Fields ORD_D_PAYLOG.REFUND_TIME :退款时间
     */
    private Date refundTime;

    /**
     * 退款流水
     */
    /**
     * @Fields ORD_D_PAYLOG.REFUND_LOGID :退款流水
     */
    private Long refundLogid;

    /**
     * 统一支付流水
     */
    /**
     * @Fields ORD_D_PAYLOG.UDP_ORDER :统一支付流水
     */
    private String udpOrder;

    /**
     * 支付机构编码
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_ORG_CODE :支付机构编码
     */
    private String payOrgCode;

    /**
     * 支付机构流水
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_ORG_LOGID :支付机构流水
     */
    private String payOrgLogid;

    /**
     * 支付渠道编码
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_CHNL_CODE :支付渠道编码
     */
    private String payChnlCode;

    /**
     * 支付渠道流水
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_CHNL_ORDER :支付渠道流水
     */
    private String payChnlOrder;

    /**
     * 支付账号/卡号
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_ACUNT_NO :支付账号/卡号
     */
    private String payAcuntNo;

    /**
     * 支付账户名称
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_ACUNT_NAME :支付账户名称
     */
    private String payAcuntName;

    /**
     * 支付成功的通知方式<br>
	 * 1－页面重定向<br>
	 * 2－服务器点对点<br>
	 * 3－对账
     */
    /**
     * @Fields ORD_D_PAYLOG.NOTIFY_TYPE :支付成功的通知方式
1－页面重定向
2－服务器点对点
3－对账
     */
    private String notifyType;

    /**
     * 数字摘要
     */
    /**
     * @Fields ORD_D_PAYLOG.SIGN_HMAC :数字摘要
     */
    private String signHmac;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_PAYLOG.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_PAYLOG.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_PAYLOG.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_PAYLOG : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 支付标识
     */
    /**
     * @return ORD_D_PAYLOG.PAY_LOGID : 返回 支付标识
     */
    public Long getPayLogid() {
        return payLogid;
    }

    /**
     * @param payLogid 
	 *            支付标识
     */
    /**
     * @param payLogid of ORD_D_PAYLOG : 设置 支付标识
     */
    public void setPayLogid(Long payLogid) {
        this.payLogid = payLogid;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_PAYLOG.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_PAYLOG : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 支付类型<br>
	 *         在线<br>
	 *         货到
     */
    /**
     * @return ORD_D_PAYLOG.PAY_TYPE : 返回 支付类型
在线
货到
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType 
	 *            支付类型<br>
	 *            在线<br>
	 *            货到
     */
    /**
     * @param payType of ORD_D_PAYLOG : 设置 支付类型
在线
货到
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * @return 支付方式
     */
    /**
     * @return ORD_D_PAYLOG.PAY_MODE : 返回 支付方式
     */
    public String getPayMode() {
        return payMode;
    }

    /**
     * @param payMode 
	 *            支付方式
     */
    /**
     * @param payMode of ORD_D_PAYLOG : 设置 支付方式
     */
    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    /**
     * @return 支付请求时间
     */
    /**
     * @return ORD_D_PAYLOG.PAY_ASK_TIME : 返回 支付请求时间
     */
    public Date getPayAskTime() {
        return payAskTime;
    }

    /**
     * @param payAskTime 
	 *            支付请求时间
     */
    /**
     * @param payAskTime of ORD_D_PAYLOG : 设置 支付请求时间
     */
    public void setPayAskTime(Date payAskTime) {
        this.payAskTime = payAskTime;
    }

    /**
     * @return 支付完成时间
     */
    /**
     * @return ORD_D_PAYLOG.PAY_COMPLETE_TIME : 返回 支付完成时间
     */
    public Date getPayCompleteTime() {
        return payCompleteTime;
    }

    /**
     * @param payCompleteTime 
	 *            支付完成时间
     */
    /**
     * @param payCompleteTime of ORD_D_PAYLOG : 设置 支付完成时间
     */
    public void setPayCompleteTime(Date payCompleteTime) {
        this.payCompleteTime = payCompleteTime;
    }

    /**
     * @return 本地支付完成时间
     */
    /**
     * @return ORD_D_PAYLOG.LOCAL_COMPLETE_TIME : 返回 本地支付完成时间
     */
    public Date getLocalCompleteTime() {
        return localCompleteTime;
    }

    /**
     * @param localCompleteTime 
	 *            本地支付完成时间
     */
    /**
     * @param localCompleteTime of ORD_D_PAYLOG : 设置 本地支付完成时间
     */
    public void setLocalCompleteTime(Date localCompleteTime) {
        this.localCompleteTime = localCompleteTime;
    }

    /**
     * @return 币种
     */
    /**
     * @return ORD_D_PAYLOG.CURRENCY_TYPE : 返回 币种
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * @param currencyType 
	 *            币种
     */
    /**
     * @param currencyType of ORD_D_PAYLOG : 设置 币种
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
    }

    /**
     * @return 支付金额
     */
    /**
     * @return ORD_D_PAYLOG.PAY_MONEY : 返回 支付金额
     */
    public Long getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney 
	 *            支付金额
     */
    /**
     * @param payMoney of ORD_D_PAYLOG : 设置 支付金额
     */
    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return 支付状态<br>
	 *         0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    /**
     * @return ORD_D_PAYLOG.PAY_STATE : 返回 支付状态
0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    public String getPayState() {
        return payState;
    }

    /**
     * @param payState 
	 *            支付状态<br>
	 *            0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    /**
     * @param payState of ORD_D_PAYLOG : 设置 支付状态
0-未支付，1-已支付，2-支付失败，3-已冲正，4-冲正失败
     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    /**
     * @return 备注
     */
    /**
     * @return ORD_D_PAYLOG.PAY_REMARK : 返回 备注
     */
    public String getPayRemark() {
        return payRemark;
    }

    /**
     * @param payRemark 
	 *            备注
     */
    /**
     * @param payRemark of ORD_D_PAYLOG : 设置 备注
     */
    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark == null ? null : payRemark.trim();
    }

    /**
     * @return 冲正标记
     */
    /**
     * @return ORD_D_PAYLOG.HALT_TAG : 返回 冲正标记
     */
    public String getHaltTag() {
        return haltTag;
    }

    /**
     * @param haltTag 
	 *            冲正标记
     */
    /**
     * @param haltTag of ORD_D_PAYLOG : 设置 冲正标记
     */
    public void setHaltTag(String haltTag) {
        this.haltTag = haltTag == null ? null : haltTag.trim();
    }

    /**
     * @return 冲正时间
     */
    /**
     * @return ORD_D_PAYLOG.HALT_TIME : 返回 冲正时间
     */
    public Date getHaltTime() {
        return haltTime;
    }

    /**
     * @param haltTime 
	 *            冲正时间
     */
    /**
     * @param haltTime of ORD_D_PAYLOG : 设置 冲正时间
     */
    public void setHaltTime(Date haltTime) {
        this.haltTime = haltTime;
    }

    /**
     * @return 退款标志<br>
	 *         0-未退款<br>
	 *         1-需要退款<br>
	 *         2-已退款
     */
    /**
     * @return ORD_D_PAYLOG.REFUND_TAG : 返回 退款标志
0-未退款
1-需要退款
2-已退款
     */
    public String getRefundTag() {
        return refundTag;
    }

    /**
     * @param refundTag 
	 *            退款标志<br>
	 *            0-未退款<br>
	 *            1-需要退款<br>
	 *            2-已退款
     */
    /**
     * @param refundTag of ORD_D_PAYLOG : 设置 退款标志
0-未退款
1-需要退款
2-已退款
     */
    public void setRefundTag(String refundTag) {
        this.refundTag = refundTag == null ? null : refundTag.trim();
    }

    /**
     * @return 退款时间
     */
    /**
     * @return ORD_D_PAYLOG.REFUND_TIME : 返回 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * @param refundTime 
	 *            退款时间
     */
    /**
     * @param refundTime of ORD_D_PAYLOG : 设置 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * @return 退款流水
     */
    /**
     * @return ORD_D_PAYLOG.REFUND_LOGID : 返回 退款流水
     */
    public Long getRefundLogid() {
        return refundLogid;
    }

    /**
     * @param refundLogid 
	 *            退款流水
     */
    /**
     * @param refundLogid of ORD_D_PAYLOG : 设置 退款流水
     */
    public void setRefundLogid(Long refundLogid) {
        this.refundLogid = refundLogid;
    }

    /**
     * @return 统一支付流水
     */
    /**
     * @return ORD_D_PAYLOG.UDP_ORDER : 返回 统一支付流水
     */
    public String getUdpOrder() {
        return udpOrder;
    }

    /**
     * @param udpOrder 
	 *            统一支付流水
     */
    /**
     * @param udpOrder of ORD_D_PAYLOG : 设置 统一支付流水
     */
    public void setUdpOrder(String udpOrder) {
        this.udpOrder = udpOrder == null ? null : udpOrder.trim();
    }

    /**
     * @return 支付机构编码
     */
    /**
     * @return ORD_D_PAYLOG.PAY_ORG_CODE : 返回 支付机构编码
     */
    public String getPayOrgCode() {
        return payOrgCode;
    }

    /**
     * @param payOrgCode 
	 *            支付机构编码
     */
    /**
     * @param payOrgCode of ORD_D_PAYLOG : 设置 支付机构编码
     */
    public void setPayOrgCode(String payOrgCode) {
        this.payOrgCode = payOrgCode == null ? null : payOrgCode.trim();
    }

    /**
     * @return 支付机构流水
     */
    /**
     * @return ORD_D_PAYLOG.PAY_ORG_LOGID : 返回 支付机构流水
     */
    public String getPayOrgLogid() {
        return payOrgLogid;
    }

    /**
     * @param payOrgLogid 
	 *            支付机构流水
     */
    /**
     * @param payOrgLogid of ORD_D_PAYLOG : 设置 支付机构流水
     */
    public void setPayOrgLogid(String payOrgLogid) {
        this.payOrgLogid = payOrgLogid == null ? null : payOrgLogid.trim();
    }

    /**
     * @return 支付渠道编码
     */
    /**
     * @return ORD_D_PAYLOG.PAY_CHNL_CODE : 返回 支付渠道编码
     */
    public String getPayChnlCode() {
        return payChnlCode;
    }

    /**
     * @param payChnlCode 
	 *            支付渠道编码
     */
    /**
     * @param payChnlCode of ORD_D_PAYLOG : 设置 支付渠道编码
     */
    public void setPayChnlCode(String payChnlCode) {
        this.payChnlCode = payChnlCode == null ? null : payChnlCode.trim();
    }

    /**
     * @return 支付渠道流水
     */
    /**
     * @return ORD_D_PAYLOG.PAY_CHNL_ORDER : 返回 支付渠道流水
     */
    public String getPayChnlOrder() {
        return payChnlOrder;
    }

    /**
     * @param payChnlOrder 
	 *            支付渠道流水
     */
    /**
     * @param payChnlOrder of ORD_D_PAYLOG : 设置 支付渠道流水
     */
    public void setPayChnlOrder(String payChnlOrder) {
        this.payChnlOrder = payChnlOrder == null ? null : payChnlOrder.trim();
    }

    /**
     * @return 支付账号/卡号
     */
    /**
     * @return ORD_D_PAYLOG.PAY_ACUNT_NO : 返回 支付账号/卡号
     */
    public String getPayAcuntNo() {
        return payAcuntNo;
    }

    /**
     * @param payAcuntNo 
	 *            支付账号/卡号
     */
    /**
     * @param payAcuntNo of ORD_D_PAYLOG : 设置 支付账号/卡号
     */
    public void setPayAcuntNo(String payAcuntNo) {
        this.payAcuntNo = payAcuntNo == null ? null : payAcuntNo.trim();
    }

    /**
     * @return 支付账户名称
     */
    /**
     * @return ORD_D_PAYLOG.PAY_ACUNT_NAME : 返回 支付账户名称
     */
    public String getPayAcuntName() {
        return payAcuntName;
    }

    /**
     * @param payAcuntName 
	 *            支付账户名称
     */
    /**
     * @param payAcuntName of ORD_D_PAYLOG : 设置 支付账户名称
     */
    public void setPayAcuntName(String payAcuntName) {
        this.payAcuntName = payAcuntName == null ? null : payAcuntName.trim();
    }

    /**
     * @return 支付成功的通知方式<br>
	 *         1－页面重定向<br>
	 *         2－服务器点对点<br>
	 *         3－对账
     */
    /**
     * @return ORD_D_PAYLOG.NOTIFY_TYPE : 返回 支付成功的通知方式
1－页面重定向
2－服务器点对点
3－对账
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * @param notifyType 
	 *            支付成功的通知方式<br>
	 *            1－页面重定向<br>
	 *            2－服务器点对点<br>
	 *            3－对账
     */
    /**
     * @param notifyType of ORD_D_PAYLOG : 设置 支付成功的通知方式
1－页面重定向
2－服务器点对点
3－对账
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    /**
     * @return 数字摘要
     */
    /**
     * @return ORD_D_PAYLOG.SIGN_HMAC : 返回 数字摘要
     */
    public String getSignHmac() {
        return signHmac;
    }

    /**
     * @param signHmac 
	 *            数字摘要
     */
    /**
     * @param signHmac of ORD_D_PAYLOG : 设置 数字摘要
     */
    public void setSignHmac(String signHmac) {
        this.signHmac = signHmac == null ? null : signHmac.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_PAYLOG.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_PAYLOG : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_PAYLOG.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_PAYLOG : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}