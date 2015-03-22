package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单基本信息
 */
/**
 * @ClassName: TdOrdDBASE
* @Description: ORD_D_BASE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDBASE extends TdOrdDBASEKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @Fields ORD_D_BASE.ORDER_NO :展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    private String orderNo;

    /**
     * 订单填写数据库时间
     */
    /**
     * @Fields ORD_D_BASE.CREATE_TIME :订单填写数据库时间
     */
    private Date createTime;

    /**
     * 订单来源<br>
	 * 00:WEB<br>
	 * 01:微信<br>
	 * 
     */
    /**
     * @Fields ORD_D_BASE.ORDER_FROM :订单来源
00:WEB
01:微信

     */
    private String orderFrom;

    /**
     * 客户实际订购时间
     */
    /**
     * @Fields ORD_D_BASE.ORDER_TIME :客户实际订购时间
     */
    private Date orderTime;

    /**
     * 订单原价
     */
    /**
     * @Fields ORD_D_BASE.ORIGINAL_PRICE :订单原价
     */
    private Long originalPrice;

    /**
     * 优惠总金额
     */
    /**
     * @Fields ORD_D_BASE.COUPON_MONEY :优惠总金额
     */
    private Long couponMoney;

    /**
     * 特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    /**
     * @Fields ORD_D_BASE.MAN_MADE_MONEY :特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    private Long manMadeMoney;

    /**
     * 邮寄费用
     */
    /**
     * @Fields ORD_D_BASE.POST_FEE :邮寄费用
     */
    private Long postFee;

    /**
     * 应收总金额
     */
    /**
     * @Fields ORD_D_BASE.TOPAY_MONEY :应收总金额
     */
    private Long topayMoney;

    /**
     * 实际已经收款金额
     */
    /**
     * @Fields ORD_D_BASE.INCOME_MONEY :实际已经收款金额
     */
    private Long incomeMoney;

    /**
     * 未处理 ： 00<br>
	 * 待分配 ： 01<br>
	 * 订单补录 ： 02<br>
	 * 待发货 ： 03<br>
	 * 发货中 ： 04<br>
	 * 物流在途 ： 05<br>
	 * 成功关闭 ： 06
     */
    /**
     * @Fields ORD_D_BASE.ORDER_STATE :未处理 ： 00
待分配 ： 01
订单补录 ： 02
待发货 ： 03
发货中 ： 04
物流在途 ： 05
成功关闭 ： 06
     */
    private String orderState;

    /**
     * 买家留言
     */
    /**
     * @Fields ORD_D_BASE.CUST_REMARK :买家留言
     */
    private String custRemark;

    /**
     * 卖家备注
     */
    /**
     * @Fields ORD_D_BASE.SELLER_REMARK :卖家备注
     */
    private String sellerRemark;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_BASE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_BASE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @return ORD_D_BASE.ORDER_NO : 返回 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo 
	 *            展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @param orderNo of ORD_D_BASE : 设置 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * @return 订单填写数据库时间
     */
    /**
     * @return ORD_D_BASE.CREATE_TIME : 返回 订单填写数据库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            订单填写数据库时间
     */
    /**
     * @param createTime of ORD_D_BASE : 设置 订单填写数据库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 订单来源<br>
	 *         00:WEB<br>
	 *         01:微信<br>
	 *         
     */
    /**
     * @return ORD_D_BASE.ORDER_FROM : 返回 订单来源
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
     * @param orderFrom of ORD_D_BASE : 设置 订单来源
00:WEB
01:微信

     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    /**
     * @return 客户实际订购时间
     */
    /**
     * @return ORD_D_BASE.ORDER_TIME : 返回 客户实际订购时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime 
	 *            客户实际订购时间
     */
    /**
     * @param orderTime of ORD_D_BASE : 设置 客户实际订购时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @return 订单原价
     */
    /**
     * @return ORD_D_BASE.ORIGINAL_PRICE : 返回 订单原价
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice 
	 *            订单原价
     */
    /**
     * @param originalPrice of ORD_D_BASE : 设置 订单原价
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * @return 优惠总金额
     */
    /**
     * @return ORD_D_BASE.COUPON_MONEY : 返回 优惠总金额
     */
    public Long getCouponMoney() {
        return couponMoney;
    }

    /**
     * @param couponMoney 
	 *            优惠总金额
     */
    /**
     * @param couponMoney of ORD_D_BASE : 设置 优惠总金额
     */
    public void setCouponMoney(Long couponMoney) {
        this.couponMoney = couponMoney;
    }

    /**
     * @return 特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    /**
     * @return ORD_D_BASE.MAN_MADE_MONEY : 返回 特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    public Long getManMadeMoney() {
        return manMadeMoney;
    }

    /**
     * @param manMadeMoney 
	 *            特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    /**
     * @param manMadeMoney of ORD_D_BASE : 设置 特殊业务情况，无理由，折后再手工修改价格，亦即最终客户应付金额
     */
    public void setManMadeMoney(Long manMadeMoney) {
        this.manMadeMoney = manMadeMoney;
    }

    /**
     * @return 邮寄费用
     */
    /**
     * @return ORD_D_BASE.POST_FEE : 返回 邮寄费用
     */
    public Long getPostFee() {
        return postFee;
    }

    /**
     * @param postFee 
	 *            邮寄费用
     */
    /**
     * @param postFee of ORD_D_BASE : 设置 邮寄费用
     */
    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    /**
     * @return 应收总金额
     */
    /**
     * @return ORD_D_BASE.TOPAY_MONEY : 返回 应收总金额
     */
    public Long getTopayMoney() {
        return topayMoney;
    }

    /**
     * @param topayMoney 
	 *            应收总金额
     */
    /**
     * @param topayMoney of ORD_D_BASE : 设置 应收总金额
     */
    public void setTopayMoney(Long topayMoney) {
        this.topayMoney = topayMoney;
    }

    /**
     * @return 实际已经收款金额
     */
    /**
     * @return ORD_D_BASE.INCOME_MONEY : 返回 实际已经收款金额
     */
    public Long getIncomeMoney() {
        return incomeMoney;
    }

    /**
     * @param incomeMoney 
	 *            实际已经收款金额
     */
    /**
     * @param incomeMoney of ORD_D_BASE : 设置 实际已经收款金额
     */
    public void setIncomeMoney(Long incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * @return 未处理 ： 00<br>
	 *         待分配 ： 01<br>
	 *         订单补录 ： 02<br>
	 *         待发货 ： 03<br>
	 *         发货中 ： 04<br>
	 *         物流在途 ： 05<br>
	 *         成功关闭 ： 06
     */
    /**
     * @return ORD_D_BASE.ORDER_STATE : 返回 未处理 ： 00
待分配 ： 01
订单补录 ： 02
待发货 ： 03
发货中 ： 04
物流在途 ： 05
成功关闭 ： 06
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState 
	 *            未处理 ： 00<br>
	 *            待分配 ： 01<br>
	 *            订单补录 ： 02<br>
	 *            待发货 ： 03<br>
	 *            发货中 ： 04<br>
	 *            物流在途 ： 05<br>
	 *            成功关闭 ： 06
     */
    /**
     * @param orderState of ORD_D_BASE : 设置 未处理 ： 00
待分配 ： 01
订单补录 ： 02
待发货 ： 03
发货中 ： 04
物流在途 ： 05
成功关闭 ： 06
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * @return 买家留言
     */
    /**
     * @return ORD_D_BASE.CUST_REMARK : 返回 买家留言
     */
    public String getCustRemark() {
        return custRemark;
    }

    /**
     * @param custRemark 
	 *            买家留言
     */
    /**
     * @param custRemark of ORD_D_BASE : 设置 买家留言
     */
    public void setCustRemark(String custRemark) {
        this.custRemark = custRemark == null ? null : custRemark.trim();
    }

    /**
     * @return 卖家备注
     */
    /**
     * @return ORD_D_BASE.SELLER_REMARK : 返回 卖家备注
     */
    public String getSellerRemark() {
        return sellerRemark;
    }

    /**
     * @param sellerRemark 
	 *            卖家备注
     */
    /**
     * @param sellerRemark of ORD_D_BASE : 设置 卖家备注
     */
    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark == null ? null : sellerRemark.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_BASE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_BASE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_BASE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_BASE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}