package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 记录物品被包装成哪些商品信息
 */
/**
 * @ClassName: TdRelGOODSRES
* @Description: REL_GOODS_RES表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdRelGOODSRES implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields REL_GOODS_RES.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields REL_GOODS_RES.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 版本号
     */
    /**
     * @Fields REL_GOODS_RES.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 物品标识
     */
    /**
     * @Fields REL_GOODS_RES.RES_ID :物品标识
     */
    private Long resId;

    /**
     * 预留字段1
     */
    /**
     * @Fields REL_GOODS_RES.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields REL_GOODS_RES.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return REL_GOODS_RES.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of REL_GOODS_RES : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return REL_GOODS_RES.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of REL_GOODS_RES : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return REL_GOODS_RES.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of REL_GOODS_RES : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 物品标识
     */
    /**
     * @return REL_GOODS_RES.RES_ID : 返回 物品标识
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 
	 *            物品标识
     */
    /**
     * @param resId of REL_GOODS_RES : 设置 物品标识
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return REL_GOODS_RES.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of REL_GOODS_RES : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return REL_GOODS_RES.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of REL_GOODS_RES : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}