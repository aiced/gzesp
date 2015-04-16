package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDREFUNDKey
* @Description: ORD_D_REFUND表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDREFUNDKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields ORD_D_REFUND.ORDER_ID :null
     */
    private Long orderId;

    /**
     * @Fields ORD_D_REFUND.PARTITION_ID :null
     */
    private Short partitionId;

    /**
     * @return ORD_D_REFUND.ORDER_ID : 返回 null
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId of ORD_D_REFUND : 设置 null
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return ORD_D_REFUND.PARTITION_ID : 返回 null
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId of ORD_D_REFUND : 设置 null
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }
}