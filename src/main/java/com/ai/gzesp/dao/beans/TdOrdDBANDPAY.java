package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 宽带续约订单表
 */
/**
 * @ClassName: TdOrdDBANDPAY
* @Description: ORD_D_BAND_PAY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDBANDPAY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    /**
     * @Fields ORD_D_BAND_PAY.ORDER_ID :订单编号
     */
    private Long orderId;

    /**
     * 分区编号
     */
    /**
     * @Fields ORD_D_BAND_PAY.PARTITION_ID :分区编号
     */
    private Short partitionId;

    /**
     * 宽带续约产品号
     */
    /**
     * @Fields ORD_D_BAND_PAY.GOODS_ID :宽带续约产品号
     */
    private String goodsId;

    /**
     * 用户编号
     */
    /**
     * @Fields ORD_D_BAND_PAY.USER_ID :用户编号
     */
    private Long userId;

    /**
     * 订单来源：00,web 01，微信
     */
    /**
     * @Fields ORD_D_BAND_PAY.ORDER_FROM :订单来源：00,web 01，微信
     */
    private String orderFrom;

    /**
     * 宽带固网账号
     */
    /**
     * @Fields ORD_D_BAND_PAY.BANDNUMID :宽带固网账号
     */
    private String bandnumid;

    /**
     * 宽带产品编号
     */
    /**
     * @Fields ORD_D_BAND_PAY.PRODUCT_ID :宽带产品编号
     */
    private String productId;

    /**
     * 应收总金额
     */
    /**
     * @Fields ORD_D_BAND_PAY.TOPAY_MONEY :应收总金额
     */
    private Long topayMoney;

    /**
     * 实际已经收款金额
     */
    /**
     * @Fields ORD_D_BAND_PAY.INCOME_MONEY :实际已经收款金额
     */
    private Long incomeMoney;

    /**
     * 订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    /**
     * @Fields ORD_D_BAND_PAY.ORDER_STATE :订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    private String orderState;

    /**
     * 订单类型，1普通用户订单 2，店长代客下单
     */
    /**
     * @Fields ORD_D_BAND_PAY.ORDER_TYPE :订单类型，1普通用户订单 2，店长代客下单
     */
    private String orderType;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_BAND_PAY.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_BAND_PAY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 订单插入时间
     */
    /**
     * @Fields ORD_D_BAND_PAY.CREATE_TIME :订单插入时间
     */
    private Date createTime;

    /**
     * 订单更新时间
     */
    /**
     * @Fields ORD_D_BAND_PAY.UPDATE_TIME :订单更新时间
     */
    private Date updateTime;

    /**
     * 订单原价
     */
    /**
     * @Fields ORD_D_BAND_PAY.ORIGINAL_PRICE :订单原价
     */
    private Long originalPrice;

    /**
     * @return 订单编号
     */
    /**
     * @return ORD_D_BAND_PAY.ORDER_ID : 返回 订单编号
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单编号
     */
    /**
     * @param orderId of ORD_D_BAND_PAY : 设置 订单编号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区编号
     */
    /**
     * @return ORD_D_BAND_PAY.PARTITION_ID : 返回 分区编号
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区编号
     */
    /**
     * @param partitionId of ORD_D_BAND_PAY : 设置 分区编号
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 宽带续约产品号
     */
    /**
     * @return ORD_D_BAND_PAY.GOODS_ID : 返回 宽带续约产品号
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            宽带续约产品号
     */
    /**
     * @param goodsId of ORD_D_BAND_PAY : 设置 宽带续约产品号
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * @return 用户编号
     */
    /**
     * @return ORD_D_BAND_PAY.USER_ID : 返回 用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户编号
     */
    /**
     * @param userId of ORD_D_BAND_PAY : 设置 用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 订单来源：00,web 01，微信
     */
    /**
     * @return ORD_D_BAND_PAY.ORDER_FROM : 返回 订单来源：00,web 01，微信
     */
    public String getOrderFrom() {
        return orderFrom;
    }

    /**
     * @param orderFrom 
	 *            订单来源：00,web 01，微信
     */
    /**
     * @param orderFrom of ORD_D_BAND_PAY : 设置 订单来源：00,web 01，微信
     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    /**
     * @return 宽带固网账号
     */
    /**
     * @return ORD_D_BAND_PAY.BANDNUMID : 返回 宽带固网账号
     */
    public String getBandnumid() {
        return bandnumid;
    }

    /**
     * @param bandnumid 
	 *            宽带固网账号
     */
    /**
     * @param bandnumid of ORD_D_BAND_PAY : 设置 宽带固网账号
     */
    public void setBandnumid(String bandnumid) {
        this.bandnumid = bandnumid == null ? null : bandnumid.trim();
    }

    /**
     * @return 宽带产品编号
     */
    /**
     * @return ORD_D_BAND_PAY.PRODUCT_ID : 返回 宽带产品编号
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId 
	 *            宽带产品编号
     */
    /**
     * @param productId of ORD_D_BAND_PAY : 设置 宽带产品编号
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * @return 应收总金额
     */
    /**
     * @return ORD_D_BAND_PAY.TOPAY_MONEY : 返回 应收总金额
     */
    public Long getTopayMoney() {
        return topayMoney;
    }

    /**
     * @param topayMoney 
	 *            应收总金额
     */
    /**
     * @param topayMoney of ORD_D_BAND_PAY : 设置 应收总金额
     */
    public void setTopayMoney(Long topayMoney) {
        this.topayMoney = topayMoney;
    }

    /**
     * @return 实际已经收款金额
     */
    /**
     * @return ORD_D_BAND_PAY.INCOME_MONEY : 返回 实际已经收款金额
     */
    public Long getIncomeMoney() {
        return incomeMoney;
    }

    /**
     * @param incomeMoney 
	 *            实际已经收款金额
     */
    /**
     * @param incomeMoney of ORD_D_BAND_PAY : 设置 实际已经收款金额
     */
    public void setIncomeMoney(Long incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * @return 订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    /**
     * @return ORD_D_BAND_PAY.ORDER_STATE : 返回 订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState 
	 *            订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    /**
     * @param orderState of ORD_D_BAND_PAY : 设置 订单状态，00：待支付 01：支付成功待续约成功 02：续约成功，99取消
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * @return 订单类型，1普通用户订单 2，店长代客下单
     */
    /**
     * @return ORD_D_BAND_PAY.ORDER_TYPE : 返回 订单类型，1普通用户订单 2，店长代客下单
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * @param orderType 
	 *            订单类型，1普通用户订单 2，店长代客下单
     */
    /**
     * @param orderType of ORD_D_BAND_PAY : 设置 订单类型，1普通用户订单 2，店长代客下单
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_BAND_PAY.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_BAND_PAY : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_BAND_PAY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_BAND_PAY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 订单插入时间
     */
    /**
     * @return ORD_D_BAND_PAY.CREATE_TIME : 返回 订单插入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            订单插入时间
     */
    /**
     * @param createTime of ORD_D_BAND_PAY : 设置 订单插入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 订单更新时间
     */
    /**
     * @return ORD_D_BAND_PAY.UPDATE_TIME : 返回 订单更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            订单更新时间
     */
    /**
     * @param updateTime of ORD_D_BAND_PAY : 设置 订单更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 订单原价
     */
    /**
     * @return ORD_D_BAND_PAY.ORIGINAL_PRICE : 返回 订单原价
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice 
	 *            订单原价
     */
    /**
     * @param originalPrice of ORD_D_BAND_PAY : 设置 订单原价
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }
}