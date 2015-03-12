package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 地市编码表
 */
/**
 * @ClassName: TdSysPCITY
* @Description: SYS_P_CITY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPCITY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 地市编码
     */
    /**
     * @Fields SYS_P_CITY.CITY_CODE :地市编码
     */
    private String cityCode;

    /**
     * 地市名称
     */
    /**
     * @Fields SYS_P_CITY.CITY_NAME :地市名称
     */
    private String cityName;

    /**
     * 省份编码
     */
    /**
     * @Fields SYS_P_CITY.PROVINCE_CODE :省份编码
     */
    private String provinceCode;

    /**
     * 统一支付平台省份编码
     */
    /**
     * @Fields SYS_P_CITY.PLATFORM_CODE :统一支付平台省份编码
     */
    private String platformCode;

    /**
     * 顺序号
     */
    /**
     * @Fields SYS_P_CITY.ORDER_NUMBER :顺序号
     */
    private Short orderNumber;

    /**
     * 预留字段1
     */
    /**
     * @Fields SYS_P_CITY.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields SYS_P_CITY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 商城1省编码
     */
    /**
     * @Fields SYS_P_CITY.ECS_PROVINCE_CODE :商城1省编码
     */
    private String ecsProvinceCode;

    /**
     * 商城1地市编码
     */
    /**
     * @Fields SYS_P_CITY.ECS_CITY_CODE :商城1地市编码
     */
    private String ecsCityCode;

    /**
     * 区号
     */
    /**
     * @Fields SYS_P_CITY.AREA_CODE :区号
     */
    private String areaCode;

    /**
     * @return 地市编码
     */
    /**
     * @return SYS_P_CITY.CITY_CODE : 返回 地市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            地市编码
     */
    /**
     * @param cityCode of SYS_P_CITY : 设置 地市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return 地市名称
     */
    /**
     * @return SYS_P_CITY.CITY_NAME : 返回 地市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName 
	 *            地市名称
     */
    /**
     * @param cityName of SYS_P_CITY : 设置 地市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * @return 省份编码
     */
    /**
     * @return SYS_P_CITY.PROVINCE_CODE : 返回 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份编码
     */
    /**
     * @param provinceCode of SYS_P_CITY : 设置 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 统一支付平台省份编码
     */
    /**
     * @return SYS_P_CITY.PLATFORM_CODE : 返回 统一支付平台省份编码
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * @param platformCode 
	 *            统一支付平台省份编码
     */
    /**
     * @param platformCode of SYS_P_CITY : 设置 统一支付平台省份编码
     */
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode == null ? null : platformCode.trim();
    }

    /**
     * @return 顺序号
     */
    /**
     * @return SYS_P_CITY.ORDER_NUMBER : 返回 顺序号
     */
    public Short getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber 
	 *            顺序号
     */
    /**
     * @param orderNumber of SYS_P_CITY : 设置 顺序号
     */
    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return SYS_P_CITY.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of SYS_P_CITY : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return SYS_P_CITY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of SYS_P_CITY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 商城1省编码
     */
    /**
     * @return SYS_P_CITY.ECS_PROVINCE_CODE : 返回 商城1省编码
     */
    public String getEcsProvinceCode() {
        return ecsProvinceCode;
    }

    /**
     * @param ecsProvinceCode 
	 *            商城1省编码
     */
    /**
     * @param ecsProvinceCode of SYS_P_CITY : 设置 商城1省编码
     */
    public void setEcsProvinceCode(String ecsProvinceCode) {
        this.ecsProvinceCode = ecsProvinceCode == null ? null : ecsProvinceCode.trim();
    }

    /**
     * @return 商城1地市编码
     */
    /**
     * @return SYS_P_CITY.ECS_CITY_CODE : 返回 商城1地市编码
     */
    public String getEcsCityCode() {
        return ecsCityCode;
    }

    /**
     * @param ecsCityCode 
	 *            商城1地市编码
     */
    /**
     * @param ecsCityCode of SYS_P_CITY : 设置 商城1地市编码
     */
    public void setEcsCityCode(String ecsCityCode) {
        this.ecsCityCode = ecsCityCode == null ? null : ecsCityCode.trim();
    }

    /**
     * @return 区号
     */
    /**
     * @return SYS_P_CITY.AREA_CODE : 返回 区号
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode 
	 *            区号
     */
    /**
     * @param areaCode of SYS_P_CITY : 设置 区号
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
}