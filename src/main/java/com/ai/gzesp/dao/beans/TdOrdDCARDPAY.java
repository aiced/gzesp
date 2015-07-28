package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 充值卡缴费基本信息
 */
/**
 * @ClassName: TdOrdDCARDPAY
* @Description: ORD_D_CARD_PAY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDCARDPAY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_CARD_PAY.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_CARD_PAY.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 充值商品ID
     */
    /**
     * @Fields ORD_D_CARD_PAY.GOODS_ID :充值商品ID
     */
    private Long goodsId;

    /**
     * 充值手机号
     */
    /**
     * @Fields ORD_D_CARD_PAY.PHONE_NUMBER :充值手机号
     */
    private String phoneNumber;

    /**
     * @Fields ORD_D_CARD_PAY.USER_ID :null
     */
    private Long userId;

    /**
     * 订单来源<br>
	 * 00:WEB<br>
	 * 01:微信<br>
	 * 
     */
    /**
     * @Fields ORD_D_CARD_PAY.ORDER_FROM :订单来源
00:WEB
01:微信

     */
    private String orderFrom;

    /**
     * 订单原价
     */
    /**
     * @Fields ORD_D_CARD_PAY.ORIGINAL_PRICE :订单原价
     */
    private Long originalPrice;

    /**
     * 应收总金额
     */
    /**
     * @Fields ORD_D_CARD_PAY.TOPAY_MONEY :应收总金额
     */
    private Long topayMoney;

    /**
     * 实际已经收款金额
     */
    /**
     * @Fields ORD_D_CARD_PAY.INCOME_MONEY :实际已经收款金额
     */
    private Long incomeMoney;

    /**
     *  00: 待支付<br>
	 *  01: 支付成功待充值<br>
	 *  02: 充值成功<br>
	 *   99:取消
     */
    /**
     * @Fields ORD_D_CARD_PAY.ORDER_STATE : 00: 待支付
 01: 支付成功待充值
 02: 充值成功
  99:取消
     */
    private String orderState;

    /**
     * 1：普通用户订单<br>
	 * 2：店长代客下单<br>
	 * 3：充值卡缴费<br>
	 * 4：充值卡售卖v
     */
    /**
     * @Fields ORD_D_CARD_PAY.ORDER_TYPE :1：普通用户订单
2：店长代客下单
3：充值卡缴费
4：充值卡售卖v
     */
    private String orderType;

    /**
     * 操作备注
     */
    /**
     * @Fields ORD_D_CARD_PAY.VALUES1 :操作备注
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_CARD_PAY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 订单填写数据库时间
     */
    /**
     * @Fields ORD_D_CARD_PAY.CREATE_TIME :订单填写数据库时间
     */
    private Date createTime;

    /**
     * @Fields ORD_D_CARD_PAY.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_CARD_PAY.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_CARD_PAY : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_CARD_PAY.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_CARD_PAY : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 充值商品ID
     */
    /**
     * @return ORD_D_CARD_PAY.GOODS_ID : 返回 充值商品ID
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            充值商品ID
     */
    /**
     * @param goodsId of ORD_D_CARD_PAY : 设置 充值商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 充值手机号
     */
    /**
     * @return ORD_D_CARD_PAY.PHONE_NUMBER : 返回 充值手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            充值手机号
     */
    /**
     * @param phoneNumber of ORD_D_CARD_PAY : 设置 充值手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return ORD_D_CARD_PAY.USER_ID : 返回 null
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId of ORD_D_CARD_PAY : 设置 null
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 订单来源<br>
	 *         00:WEB<br>
	 *         01:微信<br>
	 *         
     */
    /**
     * @return ORD_D_CARD_PAY.ORDER_FROM : 返回 订单来源
00:WEB
01:微信

     */
    public String getOrderFrom() {
        return orderFrom;
    }

    /**
     * @param orderFrom 
	 *            订单来源<br>
	 *            00:WEB<br>
	 *            01:微信<br>
	 *            
     */
    /**
     * @param orderFrom of ORD_D_CARD_PAY : 设置 订单来源
00:WEB
01:微信

     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    /**
     * @return 订单原价
     */
    /**
     * @return ORD_D_CARD_PAY.ORIGINAL_PRICE : 返回 订单原价
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice 
	 *            订单原价
     */
    /**
     * @param originalPrice of ORD_D_CARD_PAY : 设置 订单原价
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * @return 应收总金额
     */
    /**
     * @return ORD_D_CARD_PAY.TOPAY_MONEY : 返回 应收总金额
     */
    public Long getTopayMoney() {
        return topayMoney;
    }

    /**
     * @param topayMoney 
	 *            应收总金额
     */
    /**
     * @param topayMoney of ORD_D_CARD_PAY : 设置 应收总金额
     */
    public void setTopayMoney(Long topayMoney) {
        this.topayMoney = topayMoney;
    }

    /**
     * @return 实际已经收款金额
     */
    /**
     * @return ORD_D_CARD_PAY.INCOME_MONEY : 返回 实际已经收款金额
     */
    public Long getIncomeMoney() {
        return incomeMoney;
    }

    /**
     * @param incomeMoney 
	 *            实际已经收款金额
     */
    /**
     * @param incomeMoney of ORD_D_CARD_PAY : 设置 实际已经收款金额
     */
    public void setIncomeMoney(Long incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * @return  00: 待支付<br>
	 *          01: 支付成功待充值<br>
	 *          02: 充值成功<br>
	 *           99:取消
     */
    /**
     * @return ORD_D_CARD_PAY.ORDER_STATE : 返回  00: 待支付
 01: 支付成功待充值
 02: 充值成功
  99:取消
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState 
	 *             00: 待支付<br>
	 *             01: 支付成功待充值<br>
	 *             02: 充值成功<br>
	 *              99:取消
     */
    /**
     * @param orderState of ORD_D_CARD_PAY : 设置  00: 待支付
 01: 支付成功待充值
 02: 充值成功
  99:取消
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * @return 1：普通用户订单<br>
	 *         2：店长代客下单<br>
	 *         3：充值卡缴费<br>
	 *         4：充值卡售卖v
     */
    /**
     * @return ORD_D_CARD_PAY.ORDER_TYPE : 返回 1：普通用户订单
2：店长代客下单
3：充值卡缴费
4：充值卡售卖v
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * @param orderType 
	 *            1：普通用户订单<br>
	 *            2：店长代客下单<br>
	 *            3：充值卡缴费<br>
	 *            4：充值卡售卖v
     */
    /**
     * @param orderType of ORD_D_CARD_PAY : 设置 1：普通用户订单
2：店长代客下单
3：充值卡缴费
4：充值卡售卖v
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * @return 操作备注
     */
    /**
     * @return ORD_D_CARD_PAY.VALUES1 : 返回 操作备注
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            操作备注
     */
    /**
     * @param values1 of ORD_D_CARD_PAY : 设置 操作备注
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_CARD_PAY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_CARD_PAY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 订单填写数据库时间
     */
    /**
     * @return ORD_D_CARD_PAY.CREATE_TIME : 返回 订单填写数据库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            订单填写数据库时间
     */
    /**
     * @param createTime of ORD_D_CARD_PAY : 设置 订单填写数据库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return ORD_D_CARD_PAY.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of ORD_D_CARD_PAY : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}