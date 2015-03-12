package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品属性(废弃)
 */
/**
 * @ClassName: TdGdsDATTR
* @Description: GDS_D_ATTR表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDATTR implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_ATTR.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_ATTR.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_ATTR.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 属性编码
     */
    /**
     * @Fields GDS_D_ATTR.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 属性类别:该属性是否为组合属性<br>
	 * 0－普通属性<br>
	 * 1－组合属性<br>
	 * 2－组合属性成员
     */
    /**
     * @Fields GDS_D_ATTR.ATTR_TYPE :属性类别:该属性是否为组合属性
0－普通属性
1－组合属性
2－组合属性成员
     */
    private String attrType;

    /**
     * 属性名称
     */
    /**
     * @Fields GDS_D_ATTR.ATTR_NAME :属性名称
     */
    private String attrName;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_ATTR.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_ATTR.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_ATTR.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_ATTR : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_ATTR.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_ATTR : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_ATTR.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_ATTR : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 属性编码
     */
    /**
     * @return GDS_D_ATTR.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of GDS_D_ATTR : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 属性类别:该属性是否为组合属性<br>
	 *         0－普通属性<br>
	 *         1－组合属性<br>
	 *         2－组合属性成员
     */
    /**
     * @return GDS_D_ATTR.ATTR_TYPE : 返回 属性类别:该属性是否为组合属性
0－普通属性
1－组合属性
2－组合属性成员
     */
    public String getAttrType() {
        return attrType;
    }

    /**
     * @param attrType 
	 *            属性类别:该属性是否为组合属性<br>
	 *            0－普通属性<br>
	 *            1－组合属性<br>
	 *            2－组合属性成员
     */
    /**
     * @param attrType of GDS_D_ATTR : 设置 属性类别:该属性是否为组合属性
0－普通属性
1－组合属性
2－组合属性成员
     */
    public void setAttrType(String attrType) {
        this.attrType = attrType == null ? null : attrType.trim();
    }

    /**
     * @return 属性名称
     */
    /**
     * @return GDS_D_ATTR.ATTR_NAME : 返回 属性名称
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrName 
	 *            属性名称
     */
    /**
     * @param attrName of GDS_D_ATTR : 设置 属性名称
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_ATTR.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_ATTR : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_ATTR.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_ATTR : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}