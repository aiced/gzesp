package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdOrdDPAYLOGKey
* @Description: ORD_D_PAYLOG表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPAYLOGKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_PAYLOG.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 支付标识
     */
    /**
     * @Fields ORD_D_PAYLOG.PAY_LOGID :支付标识
     */
    private Long payLogid;

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
}