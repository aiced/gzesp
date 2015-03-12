package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品价格
 */
/**
 * @ClassName: TdGdsDPRICE
* @Description: GDS_D_PRICE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDPRICE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_PRICE.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_PRICE.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_PRICE.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 价格
     */
    /**
     * @Fields GDS_D_PRICE.ADD_PRICE :价格
     */
    private Long addPrice;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_PRICE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_PRICE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_PRICE.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_PRICE : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_PRICE.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_PRICE : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_PRICE.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_PRICE : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 价格
     */
    /**
     * @return GDS_D_PRICE.ADD_PRICE : 返回 价格
     */
    public Long getAddPrice() {
        return addPrice;
    }

    /**
     * @param addPrice 
	 *            价格
     */
    /**
     * @param addPrice of GDS_D_PRICE : 设置 价格
     */
    public void setAddPrice(Long addPrice) {
        this.addPrice = addPrice;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_PRICE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_PRICE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_PRICE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_PRICE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}