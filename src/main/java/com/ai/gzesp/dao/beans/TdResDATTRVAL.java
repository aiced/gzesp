package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 物品属性值
 */
/**
 * @ClassName: TdResDATTRVAL
* @Description: RES_D_ATTRVAL表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdResDATTRVAL implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 物品标识
     */
    /**
     * @Fields RES_D_ATTRVAL.RES_ID :物品标识
     */
    private Long resId;

    /**
     * 属性编码
     */
    /**
     * @Fields RES_D_ATTRVAL.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 属性值名称
     */
    /**
     * @Fields RES_D_ATTRVAL.ATTR_VAL_NAME :属性值名称
     */
    private String attrValName;

    /**
     * 属性值编码
     */
    /**
     * @Fields RES_D_ATTRVAL.ATTR_VAL_CODE :属性值编码
     */
    private String attrValCode;

    /**
     * 预留字段1
     */
    /**
     * @Fields RES_D_ATTRVAL.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields RES_D_ATTRVAL.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 排序字段
     */
    /**
     * @Fields RES_D_ATTRVAL.SEQ_NUM :排序字段
     */
    private Short seqNum;

    /**
     * @return 物品标识
     */
    /**
     * @return RES_D_ATTRVAL.RES_ID : 返回 物品标识
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 
	 *            物品标识
     */
    /**
     * @param resId of RES_D_ATTRVAL : 设置 物品标识
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 属性编码
     */
    /**
     * @return RES_D_ATTRVAL.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of RES_D_ATTRVAL : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 属性值名称
     */
    /**
     * @return RES_D_ATTRVAL.ATTR_VAL_NAME : 返回 属性值名称
     */
    public String getAttrValName() {
        return attrValName;
    }

    /**
     * @param attrValName 
	 *            属性值名称
     */
    /**
     * @param attrValName of RES_D_ATTRVAL : 设置 属性值名称
     */
    public void setAttrValName(String attrValName) {
        this.attrValName = attrValName == null ? null : attrValName.trim();
    }

    /**
     * @return 属性值编码
     */
    /**
     * @return RES_D_ATTRVAL.ATTR_VAL_CODE : 返回 属性值编码
     */
    public String getAttrValCode() {
        return attrValCode;
    }

    /**
     * @param attrValCode 
	 *            属性值编码
     */
    /**
     * @param attrValCode of RES_D_ATTRVAL : 设置 属性值编码
     */
    public void setAttrValCode(String attrValCode) {
        this.attrValCode = attrValCode == null ? null : attrValCode.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return RES_D_ATTRVAL.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of RES_D_ATTRVAL : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return RES_D_ATTRVAL.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of RES_D_ATTRVAL : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 排序字段
     */
    /**
     * @return RES_D_ATTRVAL.SEQ_NUM : 返回 排序字段
     */
    public Short getSeqNum() {
        return seqNum;
    }

    /**
     * @param seqNum 
	 *            排序字段
     */
    /**
     * @param seqNum of RES_D_ATTRVAL : 设置 排序字段
     */
    public void setSeqNum(Short seqNum) {
        this.seqNum = seqNum;
    }
}