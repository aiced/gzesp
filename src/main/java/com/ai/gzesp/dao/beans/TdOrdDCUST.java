package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单客户信息
 */
/**
 * @ClassName: TdOrdDCUST
* @Description: ORD_D_CUST表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDCUST implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_CUST.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_CUST.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 客户姓名
     */
    /**
     * @Fields ORD_D_CUST.CUST_NAME :客户姓名
     */
    private String custName;

    /**
     * 证件类型
     */
    /**
     * @Fields ORD_D_CUST.PSPT_TYPE_CODE :证件类型
     */
    private String psptTypeCode;

    /**
     * 证件号码
     */
    /**
     * @Fields ORD_D_CUST.PSPT_NO :证件号码
     */
    private String psptNo;

    /**
     * 证件失效日期
     */
    /**
     * @Fields ORD_D_CUST.PSPT_EXPIRE_DATE :证件失效日期
     */
    private Date psptExpireDate;

    /**
     * 证件照片地址1
     */
    /**
     * @Fields ORD_D_CUST.PSPT_IMG1 :证件照片地址1
     */
    private String psptImg1;

    /**
     * 证件照片地址2
     */
    /**
     * @Fields ORD_D_CUST.PSPT_IMG2 :证件照片地址2
     */
    private String psptImg2;

    /**
     * 客户联系号码
     */
    /**
     * @Fields ORD_D_CUST.PHONE_NUMBER :客户联系号码
     */
    private String phoneNumber;

    /**
     * AUTH_TAG
     */
    /**
     * @Fields ORD_D_CUST.AUTH_TAG :AUTH_TAG
     */
    private String authTag;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_CUST.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_CUST.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_CUST.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_CUST : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_CUST.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_CUST : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 客户姓名
     */
    /**
     * @return ORD_D_CUST.CUST_NAME : 返回 客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName 
	 *            客户姓名
     */
    /**
     * @param custName of ORD_D_CUST : 设置 客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * @return 证件类型
     */
    /**
     * @return ORD_D_CUST.PSPT_TYPE_CODE : 返回 证件类型
     */
    public String getPsptTypeCode() {
        return psptTypeCode;
    }

    /**
     * @param psptTypeCode 
	 *            证件类型
     */
    /**
     * @param psptTypeCode of ORD_D_CUST : 设置 证件类型
     */
    public void setPsptTypeCode(String psptTypeCode) {
        this.psptTypeCode = psptTypeCode == null ? null : psptTypeCode.trim();
    }

    /**
     * @return 证件号码
     */
    /**
     * @return ORD_D_CUST.PSPT_NO : 返回 证件号码
     */
    public String getPsptNo() {
        return psptNo;
    }

    /**
     * @param psptNo 
	 *            证件号码
     */
    /**
     * @param psptNo of ORD_D_CUST : 设置 证件号码
     */
    public void setPsptNo(String psptNo) {
        this.psptNo = psptNo == null ? null : psptNo.trim();
    }

    /**
     * @return 证件失效日期
     */
    /**
     * @return ORD_D_CUST.PSPT_EXPIRE_DATE : 返回 证件失效日期
     */
    public Date getPsptExpireDate() {
        return psptExpireDate;
    }

    /**
     * @param psptExpireDate 
	 *            证件失效日期
     */
    /**
     * @param psptExpireDate of ORD_D_CUST : 设置 证件失效日期
     */
    public void setPsptExpireDate(Date psptExpireDate) {
        this.psptExpireDate = psptExpireDate;
    }

    /**
     * @return 证件照片地址1
     */
    /**
     * @return ORD_D_CUST.PSPT_IMG1 : 返回 证件照片地址1
     */
    public String getPsptImg1() {
        return psptImg1;
    }

    /**
     * @param psptImg1 
	 *            证件照片地址1
     */
    /**
     * @param psptImg1 of ORD_D_CUST : 设置 证件照片地址1
     */
    public void setPsptImg1(String psptImg1) {
        this.psptImg1 = psptImg1 == null ? null : psptImg1.trim();
    }

    /**
     * @return 证件照片地址2
     */
    /**
     * @return ORD_D_CUST.PSPT_IMG2 : 返回 证件照片地址2
     */
    public String getPsptImg2() {
        return psptImg2;
    }

    /**
     * @param psptImg2 
	 *            证件照片地址2
     */
    /**
     * @param psptImg2 of ORD_D_CUST : 设置 证件照片地址2
     */
    public void setPsptImg2(String psptImg2) {
        this.psptImg2 = psptImg2 == null ? null : psptImg2.trim();
    }

    /**
     * @return 客户联系号码
     */
    /**
     * @return ORD_D_CUST.PHONE_NUMBER : 返回 客户联系号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            客户联系号码
     */
    /**
     * @param phoneNumber of ORD_D_CUST : 设置 客户联系号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return AUTH_TAG
     */
    /**
     * @return ORD_D_CUST.AUTH_TAG : 返回 AUTH_TAG
     */
    public String getAuthTag() {
        return authTag;
    }

    /**
     * @param authTag 
	 *            AUTH_TAG
     */
    /**
     * @param authTag of ORD_D_CUST : 设置 AUTH_TAG
     */
    public void setAuthTag(String authTag) {
        this.authTag = authTag == null ? null : authTag.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_CUST.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_CUST : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_CUST.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_CUST : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}