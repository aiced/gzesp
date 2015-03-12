package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品属性类别(废弃)
 */
/**
 * @ClassName: TdGdsPATTRTYPE
* @Description: GDS_P_ATTRTYPE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsPATTRTYPE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 属性编码
     */
    /**
     * @Fields GDS_P_ATTRTYPE.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 属性名称
     */
    /**
     * @Fields GDS_P_ATTRTYPE.ATTR_NAME :属性名称
     */
    private String attrName;

    /**
     * 类别编码
     */
    /**
     * @Fields GDS_P_ATTRTYPE.RESTYPE_CODE :类别编码
     */
    private String restypeCode;

    /**
     * 属性说明
     */
    /**
     * @Fields GDS_P_ATTRTYPE.ATTR_DESC :属性说明
     */
    private String attrDesc;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_P_ATTRTYPE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_P_ATTRTYPE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 属性编码
     */
    /**
     * @return GDS_P_ATTRTYPE.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of GDS_P_ATTRTYPE : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 属性名称
     */
    /**
     * @return GDS_P_ATTRTYPE.ATTR_NAME : 返回 属性名称
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrName 
	 *            属性名称
     */
    /**
     * @param attrName of GDS_P_ATTRTYPE : 设置 属性名称
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * @return 类别编码
     */
    /**
     * @return GDS_P_ATTRTYPE.RESTYPE_CODE : 返回 类别编码
     */
    public String getRestypeCode() {
        return restypeCode;
    }

    /**
     * @param restypeCode 
	 *            类别编码
     */
    /**
     * @param restypeCode of GDS_P_ATTRTYPE : 设置 类别编码
     */
    public void setRestypeCode(String restypeCode) {
        this.restypeCode = restypeCode == null ? null : restypeCode.trim();
    }

    /**
     * @return 属性说明
     */
    /**
     * @return GDS_P_ATTRTYPE.ATTR_DESC : 返回 属性说明
     */
    public String getAttrDesc() {
        return attrDesc;
    }

    /**
     * @param attrDesc 
	 *            属性说明
     */
    /**
     * @param attrDesc of GDS_P_ATTRTYPE : 设置 属性说明
     */
    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? null : attrDesc.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_P_ATTRTYPE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_P_ATTRTYPE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_P_ATTRTYPE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_P_ATTRTYPE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}