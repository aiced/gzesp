package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 省份编码表
 */
/**
 * @ClassName: TdSysPPROVINCE
* @Description: SYS_P_PROVINCE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPPROVINCE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 省份编码
     */
    /**
     * @Fields SYS_P_PROVINCE.PROVINCE_CODE :省份编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    /**
     * @Fields SYS_P_PROVINCE.PROVINCE_NAME :省份名称
     */
    private String provinceName;

    /**
     * 统一支付平台省份编码
     */
    /**
     * @Fields SYS_P_PROVINCE.PLATFORM_CODE :统一支付平台省份编码
     */
    private String platformCode;

    /**
     * 顺序号
     */
    /**
     * @Fields SYS_P_PROVINCE.ORDER_NUMBER :顺序号
     */
    private Short orderNumber;

    /**
     * 预留字段1
     */
    /**
     * @Fields SYS_P_PROVINCE.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields SYS_P_PROVINCE.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @Fields SYS_P_PROVINCE.PROV_SIMPLE :null
     */
    private String provSimple;

    /**
     * ecs省编码
     */
    /**
     * @Fields SYS_P_PROVINCE.ECS_PROVINCE_CODE :ecs省编码
     */
    private String ecsProvinceCode;

    /**
     * @return 省份编码
     */
    /**
     * @return SYS_P_PROVINCE.PROVINCE_CODE : 返回 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份编码
     */
    /**
     * @param provinceCode of SYS_P_PROVINCE : 设置 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 省份名称
     */
    /**
     * @return SYS_P_PROVINCE.PROVINCE_NAME : 返回 省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName 
	 *            省份名称
     */
    /**
     * @param provinceName of SYS_P_PROVINCE : 设置 省份名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * @return 统一支付平台省份编码
     */
    /**
     * @return SYS_P_PROVINCE.PLATFORM_CODE : 返回 统一支付平台省份编码
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * @param platformCode 
	 *            统一支付平台省份编码
     */
    /**
     * @param platformCode of SYS_P_PROVINCE : 设置 统一支付平台省份编码
     */
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode == null ? null : platformCode.trim();
    }

    /**
     * @return 顺序号
     */
    /**
     * @return SYS_P_PROVINCE.ORDER_NUMBER : 返回 顺序号
     */
    public Short getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber 
	 *            顺序号
     */
    /**
     * @param orderNumber of SYS_P_PROVINCE : 设置 顺序号
     */
    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return SYS_P_PROVINCE.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of SYS_P_PROVINCE : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return SYS_P_PROVINCE.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of SYS_P_PROVINCE : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return SYS_P_PROVINCE.PROV_SIMPLE : 返回 null
     */
    public String getProvSimple() {
        return provSimple;
    }

    /**
     * @param provSimple of SYS_P_PROVINCE : 设置 null
     */
    public void setProvSimple(String provSimple) {
        this.provSimple = provSimple == null ? null : provSimple.trim();
    }

    /**
     * @return ecs省编码
     */
    /**
     * @return SYS_P_PROVINCE.ECS_PROVINCE_CODE : 返回 ecs省编码
     */
    public String getEcsProvinceCode() {
        return ecsProvinceCode;
    }

    /**
     * @param ecsProvinceCode 
	 *            ecs省编码
     */
    /**
     * @param ecsProvinceCode of SYS_P_PROVINCE : 设置 ecs省编码
     */
    public void setEcsProvinceCode(String ecsProvinceCode) {
        this.ecsProvinceCode = ecsProvinceCode == null ? null : ecsProvinceCode.trim();
    }
}