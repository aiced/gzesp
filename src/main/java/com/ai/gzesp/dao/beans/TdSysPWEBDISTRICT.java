package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * WEB区县表
 */
/**
 * @ClassName: TdSysPWEBDISTRICT
* @Description: SYS_P_WEB_DISTRICT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPWEBDISTRICT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 区县编码
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.DISTRICT_CODE :区县编码
     */
    private String districtCode;

    /**
     * 区县名称
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.DISTRICT_NAME :区县名称
     */
    private String districtName;

    /**
     * 省份编码
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.PROVINCE_CODE :省份编码
     */
    private String provinceCode;

    /**
     * 地市编码
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.CITY_CODE :地市编码
     */
    private String cityCode;

    /**
     * ESS省份编码
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.ESS_PROVINCE_CODE :ESS省份编码
     */
    private String essProvinceCode;

    /**
     * ESS地市编码
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.ESS_CITY_CODE :ESS地市编码
     */
    private String essCityCode;

    /**
     * 顺序号
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.ORDER_NUMBER :顺序号
     */
    private Short orderNumber;

    /**
     * 预留字段1
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields SYS_P_WEB_DISTRICT.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 区县编码
     */
    /**
     * @return SYS_P_WEB_DISTRICT.DISTRICT_CODE : 返回 区县编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * @param districtCode 
	 *            区县编码
     */
    /**
     * @param districtCode of SYS_P_WEB_DISTRICT : 设置 区县编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * @return 区县名称
     */
    /**
     * @return SYS_P_WEB_DISTRICT.DISTRICT_NAME : 返回 区县名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName 
	 *            区县名称
     */
    /**
     * @param districtName of SYS_P_WEB_DISTRICT : 设置 区县名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * @return 省份编码
     */
    /**
     * @return SYS_P_WEB_DISTRICT.PROVINCE_CODE : 返回 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份编码
     */
    /**
     * @param provinceCode of SYS_P_WEB_DISTRICT : 设置 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 地市编码
     */
    /**
     * @return SYS_P_WEB_DISTRICT.CITY_CODE : 返回 地市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            地市编码
     */
    /**
     * @param cityCode of SYS_P_WEB_DISTRICT : 设置 地市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return ESS省份编码
     */
    /**
     * @return SYS_P_WEB_DISTRICT.ESS_PROVINCE_CODE : 返回 ESS省份编码
     */
    public String getEssProvinceCode() {
        return essProvinceCode;
    }

    /**
     * @param essProvinceCode 
	 *            ESS省份编码
     */
    /**
     * @param essProvinceCode of SYS_P_WEB_DISTRICT : 设置 ESS省份编码
     */
    public void setEssProvinceCode(String essProvinceCode) {
        this.essProvinceCode = essProvinceCode == null ? null : essProvinceCode.trim();
    }

    /**
     * @return ESS地市编码
     */
    /**
     * @return SYS_P_WEB_DISTRICT.ESS_CITY_CODE : 返回 ESS地市编码
     */
    public String getEssCityCode() {
        return essCityCode;
    }

    /**
     * @param essCityCode 
	 *            ESS地市编码
     */
    /**
     * @param essCityCode of SYS_P_WEB_DISTRICT : 设置 ESS地市编码
     */
    public void setEssCityCode(String essCityCode) {
        this.essCityCode = essCityCode == null ? null : essCityCode.trim();
    }

    /**
     * @return 顺序号
     */
    /**
     * @return SYS_P_WEB_DISTRICT.ORDER_NUMBER : 返回 顺序号
     */
    public Short getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber 
	 *            顺序号
     */
    /**
     * @param orderNumber of SYS_P_WEB_DISTRICT : 设置 顺序号
     */
    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return SYS_P_WEB_DISTRICT.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of SYS_P_WEB_DISTRICT : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return SYS_P_WEB_DISTRICT.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of SYS_P_WEB_DISTRICT : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}