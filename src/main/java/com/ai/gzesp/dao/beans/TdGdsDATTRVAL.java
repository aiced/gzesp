package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品属性值(废弃)
 */
/**
 * @ClassName: TdGdsDATTRVAL
* @Description: GDS_D_ATTRVAL表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDATTRVAL implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_ATTRVAL.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_ATTRVAL.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_ATTRVAL.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 属性编码
     */
    /**
     * @Fields GDS_D_ATTRVAL.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 属性值编码
     */
    /**
     * @Fields GDS_D_ATTRVAL.ATTR_VALUE_CODE :属性值编码
     */
    private String attrValueCode;

    /**
     * 属性值名称
     */
    /**
     * @Fields GDS_D_ATTRVAL.ATTR_VALUE_NAME :属性值名称
     */
    private String attrValueName;

    /**
     * 属性值状态<br>
	 * 0－停用<br>
	 * 1－在用<br>
	 * 默认为1（在用）
     */
    /**
     * @Fields GDS_D_ATTRVAL.ATTR_VALUE_STATE :属性值状态
0－停用
1－在用
默认为1（在用）
     */
    private String attrValueState;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_ATTRVAL.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_ATTRVAL.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_ATTRVAL.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_ATTRVAL : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_ATTRVAL.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_ATTRVAL : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_ATTRVAL.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_ATTRVAL : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 属性编码
     */
    /**
     * @return GDS_D_ATTRVAL.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of GDS_D_ATTRVAL : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 属性值编码
     */
    /**
     * @return GDS_D_ATTRVAL.ATTR_VALUE_CODE : 返回 属性值编码
     */
    public String getAttrValueCode() {
        return attrValueCode;
    }

    /**
     * @param attrValueCode 
	 *            属性值编码
     */
    /**
     * @param attrValueCode of GDS_D_ATTRVAL : 设置 属性值编码
     */
    public void setAttrValueCode(String attrValueCode) {
        this.attrValueCode = attrValueCode == null ? null : attrValueCode.trim();
    }

    /**
     * @return 属性值名称
     */
    /**
     * @return GDS_D_ATTRVAL.ATTR_VALUE_NAME : 返回 属性值名称
     */
    public String getAttrValueName() {
        return attrValueName;
    }

    /**
     * @param attrValueName 
	 *            属性值名称
     */
    /**
     * @param attrValueName of GDS_D_ATTRVAL : 设置 属性值名称
     */
    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName == null ? null : attrValueName.trim();
    }

    /**
     * @return 属性值状态<br>
	 *         0－停用<br>
	 *         1－在用<br>
	 *         默认为1（在用）
     */
    /**
     * @return GDS_D_ATTRVAL.ATTR_VALUE_STATE : 返回 属性值状态
0－停用
1－在用
默认为1（在用）
     */
    public String getAttrValueState() {
        return attrValueState;
    }

    /**
     * @param attrValueState 
	 *            属性值状态<br>
	 *            0－停用<br>
	 *            1－在用<br>
	 *            默认为1（在用）
     */
    /**
     * @param attrValueState of GDS_D_ATTRVAL : 设置 属性值状态
0－停用
1－在用
默认为1（在用）
     */
    public void setAttrValueState(String attrValueState) {
        this.attrValueState = attrValueState == null ? null : attrValueState.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_ATTRVAL.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_ATTRVAL : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_ATTRVAL.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_ATTRVAL : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}