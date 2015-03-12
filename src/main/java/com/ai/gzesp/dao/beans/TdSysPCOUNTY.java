package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 区县编码表
 */
/**
 * @ClassName: TdSysPCOUNTY
* @Description: SYS_P_COUNTY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPCOUNTY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 区县编码
     */
    /**
     * @Fields SYS_P_COUNTY.COUNTY_CODE :区县编码
     */
    private String countyCode;

    /**
     * 区县名称
     */
    /**
     * @Fields SYS_P_COUNTY.COUNTY_NAME :区县名称
     */
    private String countyName;

    /**
     * 地市编码
     */
    /**
     * @Fields SYS_P_COUNTY.EPARCHY_CODE :地市编码
     */
    private String eparchyCode;

    /**
     * 统一支付平台省份编码
     */
    /**
     * @Fields SYS_P_COUNTY.PLATFORM_CODE :统一支付平台省份编码
     */
    private String platformCode;

    /**
     * 顺序号
     */
    /**
     * @Fields SYS_P_COUNTY.ORDER_NUMBER :顺序号
     */
    private Short orderNumber;

    /**
     * 预留字段1
     */
    /**
     * @Fields SYS_P_COUNTY.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields SYS_P_COUNTY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 区县编码
     */
    /**
     * @return SYS_P_COUNTY.COUNTY_CODE : 返回 区县编码
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * @param countyCode 
	 *            区县编码
     */
    /**
     * @param countyCode of SYS_P_COUNTY : 设置 区县编码
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    /**
     * @return 区县名称
     */
    /**
     * @return SYS_P_COUNTY.COUNTY_NAME : 返回 区县名称
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * @param countyName 
	 *            区县名称
     */
    /**
     * @param countyName of SYS_P_COUNTY : 设置 区县名称
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    /**
     * @return 地市编码
     */
    /**
     * @return SYS_P_COUNTY.EPARCHY_CODE : 返回 地市编码
     */
    public String getEparchyCode() {
        return eparchyCode;
    }

    /**
     * @param eparchyCode 
	 *            地市编码
     */
    /**
     * @param eparchyCode of SYS_P_COUNTY : 设置 地市编码
     */
    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode == null ? null : eparchyCode.trim();
    }

    /**
     * @return 统一支付平台省份编码
     */
    /**
     * @return SYS_P_COUNTY.PLATFORM_CODE : 返回 统一支付平台省份编码
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * @param platformCode 
	 *            统一支付平台省份编码
     */
    /**
     * @param platformCode of SYS_P_COUNTY : 设置 统一支付平台省份编码
     */
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode == null ? null : platformCode.trim();
    }

    /**
     * @return 顺序号
     */
    /**
     * @return SYS_P_COUNTY.ORDER_NUMBER : 返回 顺序号
     */
    public Short getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber 
	 *            顺序号
     */
    /**
     * @param orderNumber of SYS_P_COUNTY : 设置 顺序号
     */
    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return SYS_P_COUNTY.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of SYS_P_COUNTY : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return SYS_P_COUNTY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of SYS_P_COUNTY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}