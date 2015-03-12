package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 物品属性类别
 */
/**
 * @ClassName: TdResPATTRTYPE
* @Description: RES_P_ATTRTYPE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdResPATTRTYPE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 属性编码
     */
    /**
     * @Fields RES_P_ATTRTYPE.ATTR_CODE :属性编码
     */
    private String attrCode;

    /**
     * 属性名称
     */
    /**
     * @Fields RES_P_ATTRTYPE.ATTR_NAME :属性名称
     */
    private String attrName;

    /**
     * 物品类别编码
     */
    /**
     * @Fields RES_P_ATTRTYPE.RESTYPE_CODE :物品类别编码
     */
    private String restypeCode;

    /**
     * 属性说明
     */
    /**
     * @Fields RES_P_ATTRTYPE.ATTR_DESC :属性说明
     */
    private String attrDesc;

    /**
     * 属性值的数据类型<br>
	 * 10－定长字串<br>
	 * 20－变长字串<br>
	 * 30－数值
     */
    /**
     * @Fields RES_P_ATTRTYPE.DATA_TYPE :属性值的数据类型
10－定长字串
20－变长字串
30－数值
     */
    private String dataType;

    /**
     * 取值方式<br>
	 * 1－手写<br>
	 * 2－表数据<br>
	 * 3－正则表达式<br>
	 * 4－接口获取
     */
    /**
     * @Fields RES_P_ATTRTYPE.VAL_GET_TYPE :取值方式
1－手写
2－表数据
3－正则表达式
4－接口获取
     */
    private String valGetType;

    /**
     * 取值规则
     */
    /**
     * @Fields RES_P_ATTRTYPE.VAL_GET_RULE :取值规则
     */
    private String valGetRule;

    /**
     * 校验规则<br>
	 * 属性值的校验规则
     */
    /**
     * @Fields RES_P_ATTRTYPE.VAL_CHK_RULE :校验规则
属性值的校验规则
     */
    private String valChkRule;

    /**
     * 预留字段1
     */
    /**
     * @Fields RES_P_ATTRTYPE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields RES_P_ATTRTYPE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 属性编码
     */
    /**
     * @return RES_P_ATTRTYPE.ATTR_CODE : 返回 属性编码
     */
    public String getAttrCode() {
        return attrCode;
    }

    /**
     * @param attrCode 
	 *            属性编码
     */
    /**
     * @param attrCode of RES_P_ATTRTYPE : 设置 属性编码
     */
    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    /**
     * @return 属性名称
     */
    /**
     * @return RES_P_ATTRTYPE.ATTR_NAME : 返回 属性名称
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrName 
	 *            属性名称
     */
    /**
     * @param attrName of RES_P_ATTRTYPE : 设置 属性名称
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * @return 物品类别编码
     */
    /**
     * @return RES_P_ATTRTYPE.RESTYPE_CODE : 返回 物品类别编码
     */
    public String getRestypeCode() {
        return restypeCode;
    }

    /**
     * @param restypeCode 
	 *            物品类别编码
     */
    /**
     * @param restypeCode of RES_P_ATTRTYPE : 设置 物品类别编码
     */
    public void setRestypeCode(String restypeCode) {
        this.restypeCode = restypeCode == null ? null : restypeCode.trim();
    }

    /**
     * @return 属性说明
     */
    /**
     * @return RES_P_ATTRTYPE.ATTR_DESC : 返回 属性说明
     */
    public String getAttrDesc() {
        return attrDesc;
    }

    /**
     * @param attrDesc 
	 *            属性说明
     */
    /**
     * @param attrDesc of RES_P_ATTRTYPE : 设置 属性说明
     */
    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? null : attrDesc.trim();
    }

    /**
     * @return 属性值的数据类型<br>
	 *         10－定长字串<br>
	 *         20－变长字串<br>
	 *         30－数值
     */
    /**
     * @return RES_P_ATTRTYPE.DATA_TYPE : 返回 属性值的数据类型
10－定长字串
20－变长字串
30－数值
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType 
	 *            属性值的数据类型<br>
	 *            10－定长字串<br>
	 *            20－变长字串<br>
	 *            30－数值
     */
    /**
     * @param dataType of RES_P_ATTRTYPE : 设置 属性值的数据类型
10－定长字串
20－变长字串
30－数值
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * @return 取值方式<br>
	 *         1－手写<br>
	 *         2－表数据<br>
	 *         3－正则表达式<br>
	 *         4－接口获取
     */
    /**
     * @return RES_P_ATTRTYPE.VAL_GET_TYPE : 返回 取值方式
1－手写
2－表数据
3－正则表达式
4－接口获取
     */
    public String getValGetType() {
        return valGetType;
    }

    /**
     * @param valGetType 
	 *            取值方式<br>
	 *            1－手写<br>
	 *            2－表数据<br>
	 *            3－正则表达式<br>
	 *            4－接口获取
     */
    /**
     * @param valGetType of RES_P_ATTRTYPE : 设置 取值方式
1－手写
2－表数据
3－正则表达式
4－接口获取
     */
    public void setValGetType(String valGetType) {
        this.valGetType = valGetType == null ? null : valGetType.trim();
    }

    /**
     * @return 取值规则
     */
    /**
     * @return RES_P_ATTRTYPE.VAL_GET_RULE : 返回 取值规则
     */
    public String getValGetRule() {
        return valGetRule;
    }

    /**
     * @param valGetRule 
	 *            取值规则
     */
    /**
     * @param valGetRule of RES_P_ATTRTYPE : 设置 取值规则
     */
    public void setValGetRule(String valGetRule) {
        this.valGetRule = valGetRule == null ? null : valGetRule.trim();
    }

    /**
     * @return 校验规则<br>
	 *         属性值的校验规则
     */
    /**
     * @return RES_P_ATTRTYPE.VAL_CHK_RULE : 返回 校验规则
属性值的校验规则
     */
    public String getValChkRule() {
        return valChkRule;
    }

    /**
     * @param valChkRule 
	 *            校验规则<br>
	 *            属性值的校验规则
     */
    /**
     * @param valChkRule of RES_P_ATTRTYPE : 设置 校验规则
属性值的校验规则
     */
    public void setValChkRule(String valChkRule) {
        this.valChkRule = valChkRule == null ? null : valChkRule.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return RES_P_ATTRTYPE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of RES_P_ATTRTYPE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return RES_P_ATTRTYPE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of RES_P_ATTRTYPE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}