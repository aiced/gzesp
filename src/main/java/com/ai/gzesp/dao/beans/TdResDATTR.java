package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 物品属性
 */
/**
 * @ClassName: TdResDATTR
* @Description: RES_D_ATTR表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdResDATTR implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 物品标识
     */
    /**
     * @Fields RES_D_ATTR.RES_ID :物品标识
     */
    private Long resId;

    /**
     * 属性编码
     */
    /**
     * @Fields RES_D_ATTR.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 该属性是否可搜索<br>
	 * 1－可搜索
     */
    /**
     * @Fields RES_D_ATTR.SERACH_TAG :该属性是否可搜索
1－可搜索
     */
    private String serachTag;

    /**
     * 预留字段1
     */
    /**
     * @Fields RES_D_ATTR.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields RES_D_ATTR.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 物品标识
     */
    /**
     * @return RES_D_ATTR.RES_ID : 返回 物品标识
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 
	 *            物品标识
     */
    /**
     * @param resId of RES_D_ATTR : 设置 物品标识
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 属性编码
     */
    /**
     * @return RES_D_ATTR.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of RES_D_ATTR : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 该属性是否可搜索<br>
	 *         1－可搜索
     */
    /**
     * @return RES_D_ATTR.SERACH_TAG : 返回 该属性是否可搜索
1－可搜索
     */
    public String getSerachTag() {
        return serachTag;
    }

    /**
     * @param serachTag 
	 *            该属性是否可搜索<br>
	 *            1－可搜索
     */
    /**
     * @param serachTag of RES_D_ATTR : 设置 该属性是否可搜索
1－可搜索
     */
    public void setSerachTag(String serachTag) {
        this.serachTag = serachTag == null ? null : serachTag.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return RES_D_ATTR.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of RES_D_ATTR : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return RES_D_ATTR.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of RES_D_ATTR : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}