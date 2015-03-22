package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDPRODKey
* @Description: ORD_D_PROD表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPRODKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields ORD_D_PROD.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_PROD.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * @return 商品标识
     */
    /**
     * @return ORD_D_PROD.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of ORD_D_PROD : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_PROD.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_PROD : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}