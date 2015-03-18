package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 订单物品信息
 */
/**
 * @ClassName: TdOrdDRES
* @Description: ORD_D_RES表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDRES implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_RES.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_RES.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 物品标识
     */
    /**
     * @Fields ORD_D_RES.RES_ID :物品标识
     */
    private Long resId;

    /**
     * 物品属性编码
     */
    /**
     * @Fields ORD_D_RES.RES_ATTR_CODE :物品属性编码
     */
    private String resAttrCode;

    /**
     * 物品属性值
     */
    /**
     * @Fields ORD_D_RES.RES_ATTR_VAL :物品属性值
     */
    private String resAttrVal;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_RES.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_RES.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_RES.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_RES : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_RES.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_RES : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 物品标识
     */
    /**
     * @return ORD_D_RES.RES_ID : 返回 物品标识
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 
	 *            物品标识
     */
    /**
     * @param resId of ORD_D_RES : 设置 物品标识
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 物品属性编码
     */
    /**
     * @return ORD_D_RES.RES_ATTR_CODE : 返回 物品属性编码
     */
    public String getResAttrCode() {
        return resAttrCode;
    }

    /**
     * @param resAttrCode 
	 *            物品属性编码
     */
    /**
     * @param resAttrCode of ORD_D_RES : 设置 物品属性编码
     */
    public void setResAttrCode(String resAttrCode) {
        this.resAttrCode = resAttrCode == null ? null : resAttrCode.trim();
    }

    /**
     * @return 物品属性值
     */
    /**
     * @return ORD_D_RES.RES_ATTR_VAL : 返回 物品属性值
     */
    public String getResAttrVal() {
        return resAttrVal;
    }

    /**
     * @param resAttrVal 
	 *            物品属性值
     */
    /**
     * @param resAttrVal of ORD_D_RES : 设置 物品属性值
     */
    public void setResAttrVal(String resAttrVal) {
        this.resAttrVal = resAttrVal == null ? null : resAttrVal.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_RES.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_RES : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_RES.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_RES : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}