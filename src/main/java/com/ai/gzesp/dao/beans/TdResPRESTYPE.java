package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 物品分类
 */
/**
 * @ClassName: TdResPRESTYPE
* @Description: RES_P_RESTYPE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdResPRESTYPE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 物品类别编码
     */
    /**
     * @Fields RES_P_RESTYPE.RESTYPE_CODE :物品类别编码
     */
    private String restypeCode;

    /**
     * 物品类别名称
     */
    /**
     * @Fields RES_P_RESTYPE.RESTYPE_NAME :物品类别名称
     */
    private String restypeName;

    /**
     * 物品类别状态
     */
    /**
     * @Fields RES_P_RESTYPE.RESTYPE_STATE :物品类别状态
     */
    private String restypeState;

    /**
     * 预留字段1
     */
    /**
     * @Fields RES_P_RESTYPE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields RES_P_RESTYPE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 物品类别编码
     */
    /**
     * @return RES_P_RESTYPE.RESTYPE_CODE : 返回 物品类别编码
     */
    public String getRestypeCode() {
        return restypeCode;
    }

    /**
     * @param restypeCode 
	 *            物品类别编码
     */
    /**
     * @param restypeCode of RES_P_RESTYPE : 设置 物品类别编码
     */
    public void setRestypeCode(String restypeCode) {
        this.restypeCode = restypeCode == null ? null : restypeCode.trim();
    }

    /**
     * @return 物品类别名称
     */
    /**
     * @return RES_P_RESTYPE.RESTYPE_NAME : 返回 物品类别名称
     */
    public String getRestypeName() {
        return restypeName;
    }

    /**
     * @param restypeName 
	 *            物品类别名称
     */
    /**
     * @param restypeName of RES_P_RESTYPE : 设置 物品类别名称
     */
    public void setRestypeName(String restypeName) {
        this.restypeName = restypeName == null ? null : restypeName.trim();
    }

    /**
     * @return 物品类别状态
     */
    /**
     * @return RES_P_RESTYPE.RESTYPE_STATE : 返回 物品类别状态
     */
    public String getRestypeState() {
        return restypeState;
    }

    /**
     * @param restypeState 
	 *            物品类别状态
     */
    /**
     * @param restypeState of RES_P_RESTYPE : 设置 物品类别状态
     */
    public void setRestypeState(String restypeState) {
        this.restypeState = restypeState == null ? null : restypeState.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return RES_P_RESTYPE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of RES_P_RESTYPE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return RES_P_RESTYPE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of RES_P_RESTYPE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}