package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDPAYKey
* @Description: ORD_D_PAY表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPAYKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * wap端订单id
     */
    /**
     * @Fields ORD_D_PAY.ORDER_ID :wap端订单id
     */
    private Long orderId;

    /**
     * 支付顺序<br>
	 * 默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    /**
     * @Fields ORD_D_PAY.PAY_ORDER :支付顺序
默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    private Short payOrder;

    /**
     * @return wap端订单id
     */
    /**
     * @return ORD_D_PAY.ORDER_ID : 返回 wap端订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            wap端订单id
     */
    /**
     * @param orderId of ORD_D_PAY : 设置 wap端订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 支付顺序<br>
	 *         默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    /**
     * @return ORD_D_PAY.PAY_ORDER : 返回 支付顺序
默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    public Short getPayOrder() {
        return payOrder;
    }

    /**
     * @param payOrder 
	 *            支付顺序<br>
	 *            默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    /**
     * @param payOrder of ORD_D_PAY : 设置 支付顺序
默认是1，如果是组合支付的，相同订单id会有多条payid，顺序从1开始
     */
    public void setPayOrder(Short payOrder) {
        this.payOrder = payOrder;
    }
}