package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 能人推荐商品
 */
/**
 * @ClassName: TdGdsDABLERCD
* @Description: GDS_D_ABLE_RCD表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDABLERCD implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_ABLE_RCD.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_ABLE_RCD.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 能人ID
     */
    /**
     * @Fields GDS_D_ABLE_RCD.USER_ID :能人ID
     */
    private String userId;

    /**
     * 排序顺序
     */
    /**
     * @Fields GDS_D_ABLE_RCD.SEQ_NUM :排序顺序
     */
    private Short seqNum;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_ABLE_RCD.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_ABLE_RCD.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_ABLE_RCD.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_ABLE_RCD : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_ABLE_RCD.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_ABLE_RCD : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 能人ID
     */
    /**
     * @return GDS_D_ABLE_RCD.USER_ID : 返回 能人ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人ID
     */
    /**
     * @param userId of GDS_D_ABLE_RCD : 设置 能人ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 排序顺序
     */
    /**
     * @return GDS_D_ABLE_RCD.SEQ_NUM : 返回 排序顺序
     */
    public Short getSeqNum() {
        return seqNum;
    }

    /**
     * @param seqNum 
	 *            排序顺序
     */
    /**
     * @param seqNum of GDS_D_ABLE_RCD : 设置 排序顺序
     */
    public void setSeqNum(Short seqNum) {
        this.seqNum = seqNum;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_ABLE_RCD.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_ABLE_RCD : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_ABLE_RCD.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_ABLE_RCD : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}