package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDPRECMSFEE
* @Description: ORD_D_PRECMSFEE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPRECMSFEE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_PRECMSFEE.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_PRECMSFEE.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 商品标识
     */
    /**
     * @Fields ORD_D_PRECMSFEE.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 0：比例<br>
	 * 1：奖励
     */
    /**
     * @Fields ORD_D_PRECMSFEE.CMS_TYPE :0：比例
1：奖励
     */
    private String cmsType;

    /**
     * 商品预估佣金金额
     */
    /**
     * @Fields ORD_D_PRECMSFEE.CMS_PRE_FEE :商品预估佣金金额
     */
    private Long cmsPreFee;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_PRECMSFEE.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_PRECMSFEE : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_PRECMSFEE.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_PRECMSFEE : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 商品标识
     */
    /**
     * @return ORD_D_PRECMSFEE.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of ORD_D_PRECMSFEE : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 0：比例<br>
	 *         1：奖励
     */
    /**
     * @return ORD_D_PRECMSFEE.CMS_TYPE : 返回 0：比例
1：奖励
     */
    public String getCmsType() {
        return cmsType;
    }

    /**
     * @param cmsType 
	 *            0：比例<br>
	 *            1：奖励
     */
    /**
     * @param cmsType of ORD_D_PRECMSFEE : 设置 0：比例
1：奖励
     */
    public void setCmsType(String cmsType) {
        this.cmsType = cmsType == null ? null : cmsType.trim();
    }

    /**
     * @return 商品预估佣金金额
     */
    /**
     * @return ORD_D_PRECMSFEE.CMS_PRE_FEE : 返回 商品预估佣金金额
     */
    public Long getCmsPreFee() {
        return cmsPreFee;
    }

    /**
     * @param cmsPreFee 
	 *            商品预估佣金金额
     */
    /**
     * @param cmsPreFee of ORD_D_PRECMSFEE : 设置 商品预估佣金金额
     */
    public void setCmsPreFee(Long cmsPreFee) {
        this.cmsPreFee = cmsPreFee;
    }
}