package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 地市WEB编码表
 */
/**
 * @ClassName: TdSysPWEBCITY
* @Description: SYS_P_WEB_CITY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPWEBCITY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 地市编码
     */
    /**
     * @Fields SYS_P_WEB_CITY.CITY_CODE :地市编码
     */
    private String cityCode;

    /**
     * 地市名称
     */
    /**
     * @Fields SYS_P_WEB_CITY.CITY_NAME :地市名称
     */
    private String cityName;

    /**
     * 省份编码
     */
    /**
     * @Fields SYS_P_WEB_CITY.PROVINCE_CODE :省份编码
     */
    private String provinceCode;

    /**
     * ESS省份编码
     */
    /**
     * @Fields SYS_P_WEB_CITY.ESS_PROVINCE_CODE :ESS省份编码
     */
    private String essProvinceCode;

    /**
     * ESS地市编码
     */
    /**
     * @Fields SYS_P_WEB_CITY.ESS_CITY_CODE :ESS地市编码
     */
    private String essCityCode;

    /**
     * 顺序号
     */
    /**
     * @Fields SYS_P_WEB_CITY.ORDER_NUMBER :顺序号
     */
    private Short orderNumber;

    /**
     * 预留字段1
     */
    /**
     * @Fields SYS_P_WEB_CITY.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields SYS_P_WEB_CITY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 地市编码
     */
    /**
     * @return SYS_P_WEB_CITY.CITY_CODE : 返回 地市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            地市编码
     */
    /**
     * @param cityCode of SYS_P_WEB_CITY : 设置 地市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return 地市名称
     */
    /**
     * @return SYS_P_WEB_CITY.CITY_NAME : 返回 地市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName 
	 *            地市名称
     */
    /**
     * @param cityName of SYS_P_WEB_CITY : 设置 地市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * @return 省份编码
     */
    /**
     * @return SYS_P_WEB_CITY.PROVINCE_CODE : 返回 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份编码
     */
    /**
     * @param provinceCode of SYS_P_WEB_CITY : 设置 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return ESS省份编码
     */
    /**
     * @return SYS_P_WEB_CITY.ESS_PROVINCE_CODE : 返回 ESS省份编码
     */
    public String getEssProvinceCode() {
        return essProvinceCode;
    }

    /**
     * @param essProvinceCode 
	 *            ESS省份编码
     */
    /**
     * @param essProvinceCode of SYS_P_WEB_CITY : 设置 ESS省份编码
     */
    public void setEssProvinceCode(String essProvinceCode) {
        this.essProvinceCode = essProvinceCode == null ? null : essProvinceCode.trim();
    }

    /**
     * @return ESS地市编码
     */
    /**
     * @return SYS_P_WEB_CITY.ESS_CITY_CODE : 返回 ESS地市编码
     */
    public String getEssCityCode() {
        return essCityCode;
    }

    /**
     * @param essCityCode 
	 *            ESS地市编码
     */
    /**
     * @param essCityCode of SYS_P_WEB_CITY : 设置 ESS地市编码
     */
    public void setEssCityCode(String essCityCode) {
        this.essCityCode = essCityCode == null ? null : essCityCode.trim();
    }

    /**
     * @return 顺序号
     */
    /**
     * @return SYS_P_WEB_CITY.ORDER_NUMBER : 返回 顺序号
     */
    public Short getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber 
	 *            顺序号
     */
    /**
     * @param orderNumber of SYS_P_WEB_CITY : 设置 顺序号
     */
    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return SYS_P_WEB_CITY.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of SYS_P_WEB_CITY : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return SYS_P_WEB_CITY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of SYS_P_WEB_CITY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}