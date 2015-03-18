package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdGdsDINFOKey
* @Description: GDS_D_INFO表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDINFOKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_INFO.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_INFO.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_INFO.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_INFO : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_INFO.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_INFO : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }
}