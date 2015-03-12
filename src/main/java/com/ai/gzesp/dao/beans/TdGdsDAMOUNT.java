package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品数量
 */
/**
 * @ClassName: TdGdsDAMOUNT
* @Description: GDS_D_AMOUNT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDAMOUNT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_AMOUNT.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_AMOUNT.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_AMOUNT.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 数量类型<br>
	 * 1－库存数量<br>
	 * 2－已售数量
     */
    /**
     * @Fields GDS_D_AMOUNT.AMOUNT_TYPE :数量类型
1－库存数量
2－已售数量
     */
    private String amountType;

    /**
     * 商品数量值
     */
    /**
     * @Fields GDS_D_AMOUNT.GOODS_AMOUNT :商品数量值
     */
    private Integer goodsAmount;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_AMOUNT.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_AMOUNT.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_AMOUNT.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_AMOUNT : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_AMOUNT.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_AMOUNT : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_AMOUNT.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_AMOUNT : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 数量类型<br>
	 *         1－库存数量<br>
	 *         2－已售数量
     */
    /**
     * @return GDS_D_AMOUNT.AMOUNT_TYPE : 返回 数量类型
1－库存数量
2－已售数量
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * @param amountType 
	 *            数量类型<br>
	 *            1－库存数量<br>
	 *            2－已售数量
     */
    /**
     * @param amountType of GDS_D_AMOUNT : 设置 数量类型
1－库存数量
2－已售数量
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    /**
     * @return 商品数量值
     */
    /**
     * @return GDS_D_AMOUNT.GOODS_AMOUNT : 返回 商品数量值
     */
    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    /**
     * @param goodsAmount 
	 *            商品数量值
     */
    /**
     * @param goodsAmount of GDS_D_AMOUNT : 设置 商品数量值
     */
    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_AMOUNT.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_AMOUNT : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_AMOUNT.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_AMOUNT : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}