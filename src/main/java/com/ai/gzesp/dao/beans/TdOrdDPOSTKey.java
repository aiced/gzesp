package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDPOSTKey
* @Description: ORD_D_POST表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPOSTKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_POST.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_POST.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_POST.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_POST : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_POST.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_POST : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }
}