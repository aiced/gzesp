package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 能人按月商品佣金表
 */
/**
 * @ClassName: TdCmsDMONTH
* @Description: CMS_D_MONTH表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdCmsDMONTH implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 能人编码
     */
    /**
     * @Fields CMS_D_MONTH.USER_ID :能人编码
     */
    private Long userId;

    /**
     * 分区ID,按月份分区
     */
    /**
     * @Fields CMS_D_MONTH.PARTITION_ID :分区ID,按月份分区
     */
    private Short partitionId;

    /**
     * 订单ID
     */
    /**
     * @Fields CMS_D_MONTH.ORDER_ID :订单ID
     */
    private Long orderId;

    /**
     * 订单NO
     */
    /**
     * @Fields CMS_D_MONTH.ORDER_NO :订单NO
     */
    private String orderNo;

    /**
     * 10：商城渠道，11：WEIXIN渠道
     */
    /**
     * @Fields CMS_D_MONTH.CONN_CHANNEL :10：商城渠道，11：WEIXIN渠道
     */
    private Short connChannel;

    /**
     * 添加时间
     */
    /**
     * @Fields CMS_D_MONTH.CREATE_TIME :添加时间
     */
    private Date createTime;

    /**
     * WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    /**
     * @Fields CMS_D_MONTH.ORDER_FROM :WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    private String orderFrom;

    /**
     * 计算金额
     */
    /**
     * @Fields CMS_D_MONTH.INCOME_MONEY :计算金额
     */
    private Long incomeMoney;

    /**
     * 商品编码
     */
    /**
     * @Fields CMS_D_MONTH.GOODS_ID :商品编码
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    /**
     * @Fields CMS_D_MONTH.GOODS_NAME :商品名称
     */
    private String goodsName;

    /**
     * 佣金总金额
     */
    /**
     * @Fields CMS_D_MONTH.CMS_SUM_MONEY :佣金总金额
     */
    private Long cmsSumMoney;

    /**
     * 佣金金额
     */
    /**
     * @Fields CMS_D_MONTH.CMS_MONEY :佣金金额
     */
    private Long cmsMoney;

    /**
     * 佣金月份
     */
    /**
     * @Fields CMS_D_MONTH.CMS_MONTH :佣金月份
     */
    private Integer cmsMonth;

    /**
     * 计算日期
     */
    /**
     * @Fields CMS_D_MONTH.CAL_DATE :计算日期
     */
    private Date calDate;

    /**
     * 商品号码
     */
    /**
     * @Fields CMS_D_MONTH.GOODS_NUMBER :商品号码
     */
    private String goodsNumber;

    /**
     * 状态<br>
	 * 0:未发放<br>
	 * 1:已发放<br>
	 * 
     */
    /**
     * @Fields CMS_D_MONTH.STATUS :状态
0:未发放
1:已发放

     */
    private String status;

    /**
     * 佣金规则
     */
    /**
     * @Fields CMS_D_MONTH.COMMISSION_RULE :佣金规则
     */
    private String commissionRule;

    /**
     * @return 能人编码
     */
    /**
     * @return CMS_D_MONTH.USER_ID : 返回 能人编码
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人编码
     */
    /**
     * @param userId of CMS_D_MONTH : 设置 能人编码
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 分区ID,按月份分区
     */
    /**
     * @return CMS_D_MONTH.PARTITION_ID : 返回 分区ID,按月份分区
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区ID,按月份分区
     */
    /**
     * @param partitionId of CMS_D_MONTH : 设置 分区ID,按月份分区
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 订单ID
     */
    /**
     * @return CMS_D_MONTH.ORDER_ID : 返回 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单ID
     */
    /**
     * @param orderId of CMS_D_MONTH : 设置 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 订单NO
     */
    /**
     * @return CMS_D_MONTH.ORDER_NO : 返回 订单NO
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo 
	 *            订单NO
     */
    /**
     * @param orderNo of CMS_D_MONTH : 设置 订单NO
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * @return 10：商城渠道，11：WEIXIN渠道
     */
    /**
     * @return CMS_D_MONTH.CONN_CHANNEL : 返回 10：商城渠道，11：WEIXIN渠道
     */
    public Short getConnChannel() {
        return connChannel;
    }

    /**
     * @param connChannel 
	 *            10：商城渠道，11：WEIXIN渠道
     */
    /**
     * @param connChannel of CMS_D_MONTH : 设置 10：商城渠道，11：WEIXIN渠道
     */
    public void setConnChannel(Short connChannel) {
        this.connChannel = connChannel;
    }

    /**
     * @return 添加时间
     */
    /**
     * @return CMS_D_MONTH.CREATE_TIME : 返回 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            添加时间
     */
    /**
     * @param createTime of CMS_D_MONTH : 设置 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    /**
     * @return CMS_D_MONTH.ORDER_FROM : 返回 WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    public String getOrderFrom() {
        return orderFrom;
    }

    /**
     * @param orderFrom 
	 *            WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    /**
     * @param orderFrom of CMS_D_MONTH : 设置 WEIXIN,EMAL,TAOBAO,MOBILE,PERIPHERY,PAIPAI
     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    /**
     * @return 计算金额
     */
    /**
     * @return CMS_D_MONTH.INCOME_MONEY : 返回 计算金额
     */
    public Long getIncomeMoney() {
        return incomeMoney;
    }

    /**
     * @param incomeMoney 
	 *            计算金额
     */
    /**
     * @param incomeMoney of CMS_D_MONTH : 设置 计算金额
     */
    public void setIncomeMoney(Long incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * @return 商品编码
     */
    /**
     * @return CMS_D_MONTH.GOODS_ID : 返回 商品编码
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品编码
     */
    /**
     * @param goodsId of CMS_D_MONTH : 设置 商品编码
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 商品名称
     */
    /**
     * @return CMS_D_MONTH.GOODS_NAME : 返回 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName 
	 *            商品名称
     */
    /**
     * @param goodsName of CMS_D_MONTH : 设置 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return 佣金总金额
     */
    /**
     * @return CMS_D_MONTH.CMS_SUM_MONEY : 返回 佣金总金额
     */
    public Long getCmsSumMoney() {
        return cmsSumMoney;
    }

    /**
     * @param cmsSumMoney 
	 *            佣金总金额
     */
    /**
     * @param cmsSumMoney of CMS_D_MONTH : 设置 佣金总金额
     */
    public void setCmsSumMoney(Long cmsSumMoney) {
        this.cmsSumMoney = cmsSumMoney;
    }

    /**
     * @return 佣金金额
     */
    /**
     * @return CMS_D_MONTH.CMS_MONEY : 返回 佣金金额
     */
    public Long getCmsMoney() {
        return cmsMoney;
    }

    /**
     * @param cmsMoney 
	 *            佣金金额
     */
    /**
     * @param cmsMoney of CMS_D_MONTH : 设置 佣金金额
     */
    public void setCmsMoney(Long cmsMoney) {
        this.cmsMoney = cmsMoney;
    }

    /**
     * @return 佣金月份
     */
    /**
     * @return CMS_D_MONTH.CMS_MONTH : 返回 佣金月份
     */
    public Integer getCmsMonth() {
        return cmsMonth;
    }

    /**
     * @param cmsMonth 
	 *            佣金月份
     */
    /**
     * @param cmsMonth of CMS_D_MONTH : 设置 佣金月份
     */
    public void setCmsMonth(Integer cmsMonth) {
        this.cmsMonth = cmsMonth;
    }

    /**
     * @return 计算日期
     */
    /**
     * @return CMS_D_MONTH.CAL_DATE : 返回 计算日期
     */
    public Date getCalDate() {
        return calDate;
    }

    /**
     * @param calDate 
	 *            计算日期
     */
    /**
     * @param calDate of CMS_D_MONTH : 设置 计算日期
     */
    public void setCalDate(Date calDate) {
        this.calDate = calDate;
    }

    /**
     * @return 商品号码
     */
    /**
     * @return CMS_D_MONTH.GOODS_NUMBER : 返回 商品号码
     */
    public String getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * @param goodsNumber 
	 *            商品号码
     */
    /**
     * @param goodsNumber of CMS_D_MONTH : 设置 商品号码
     */
    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber == null ? null : goodsNumber.trim();
    }

    /**
     * @return 状态<br>
	 *         0:未发放<br>
	 *         1:已发放<br>
	 *         
     */
    /**
     * @return CMS_D_MONTH.STATUS : 返回 状态
0:未发放
1:已发放

     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态<br>
	 *            0:未发放<br>
	 *            1:已发放<br>
	 *            
     */
    /**
     * @param status of CMS_D_MONTH : 设置 状态
0:未发放
1:已发放

     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 佣金规则
     */
    /**
     * @return CMS_D_MONTH.COMMISSION_RULE : 返回 佣金规则
     */
    public String getCommissionRule() {
        return commissionRule;
    }

    /**
     * @param commissionRule 
	 *            佣金规则
     */
    /**
     * @param commissionRule of CMS_D_MONTH : 设置 佣金规则
     */
    public void setCommissionRule(String commissionRule) {
        this.commissionRule = commissionRule == null ? null : commissionRule.trim();
    }
}