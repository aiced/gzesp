package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 订单物流信息
 */
/**
 * @ClassName: TdOrdDPOST
* @Description: ORD_D_POST表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPOST implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_POST.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_POST.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 配送方式<br>
	 * 00 不需要配送<br>
	 * 01 送货<br>
	 * 02 自提
     */
    /**
     * @Fields ORD_D_POST.DELIVER_TYPE_CODE :配送方式
00 不需要配送
01 送货
02 自提
     */
    private String deliverTypeCode;

    /**
     * 配送时间<br>
	 * 00 工作日<br>
	 * 01 周末<br>
	 * 02 工作日、周末<br>
	 * 
     */
    /**
     * @Fields ORD_D_POST.DELIVER_TIME_CODE :配送时间
00 工作日
01 周末
02 工作日、周末

     */
    private String deliverTimeCode;

    /**
     * 收件人姓名
     */
    /**
     * @Fields ORD_D_POST.RECEIVER_NAME :收件人姓名
     */
    private String receiverName;

    /**
     * 收件人证件类型
     */
    /**
     * @Fields ORD_D_POST.RECEIVER_PSPT_TYPE :收件人证件类型
     */
    private String receiverPsptType;

    /**
     * 收件人证件号码
     */
    /**
     * @Fields ORD_D_POST.RECEIVER_PSPT_NO :收件人证件号码
     */
    private String receiverPsptNo;

    /**
     * 手机号码
     */
    /**
     * @Fields ORD_D_POST.MOBILE_PHONE :手机号码
     */
    private String mobilePhone;

    /**
     * 固定电话
     */
    /**
     * @Fields ORD_D_POST.FIX_PHONE :固定电话
     */
    private String fixPhone;

    /**
     * EMAIL
     */
    /**
     * @Fields ORD_D_POST.EMAIL :EMAIL
     */
    private String email;

    /**
     * 省份编码
     */
    /**
     * @Fields ORD_D_POST.PROVINCE_CODE :省份编码
     */
    private String provinceCode;

    /**
     * 地市编码
     */
    /**
     * @Fields ORD_D_POST.CITY_CODE :地市编码
     */
    private String cityCode;

    /**
     * 区县编码
     */
    /**
     * @Fields ORD_D_POST.DISTRICT_CODE :区县编码
     */
    private String districtCode;

    /**
     * 邮政编码
     */
    /**
     * @Fields ORD_D_POST.POST_CODE :邮政编码
     */
    private String postCode;

    /**
     * 详细地址
     */
    /**
     * @Fields ORD_D_POST.POST_ADDR :详细地址
     */
    private String postAddr;

    /**
     * 邮寄备选
     */
    /**
     * @Fields ORD_D_POST.POST_REMARK :邮寄备选
     */
    private String postRemark;

    /**
     * 物流单号
     */
    /**
     * @Fields ORD_D_POST.EXPRESS_ID :物流单号
     */
    private String expressId;

    /**
     * 物流公司
     */
    /**
     * @Fields ORD_D_POST.EXPRESS_COMPNAY :物流公司
     */
    private String expressCompnay;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_POST.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_POST.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_POST.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_POST : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_POST.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_POST : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 配送方式<br>
	 *         00 不需要配送<br>
	 *         01 送货<br>
	 *         02 自提
     */
    /**
     * @return ORD_D_POST.DELIVER_TYPE_CODE : 返回 配送方式
00 不需要配送
01 送货
02 自提
     */
    public String getDeliverTypeCode() {
        return deliverTypeCode;
    }

    /**
     * @param deliverTypeCode 
	 *            配送方式<br>
	 *            00 不需要配送<br>
	 *            01 送货<br>
	 *            02 自提
     */
    /**
     * @param deliverTypeCode of ORD_D_POST : 设置 配送方式
00 不需要配送
01 送货
02 自提
     */
    public void setDeliverTypeCode(String deliverTypeCode) {
        this.deliverTypeCode = deliverTypeCode == null ? null : deliverTypeCode.trim();
    }

    /**
     * @return 配送时间<br>
	 *         00 工作日<br>
	 *         01 周末<br>
	 *         02 工作日、周末<br>
	 *         
     */
    /**
     * @return ORD_D_POST.DELIVER_TIME_CODE : 返回 配送时间
00 工作日
01 周末
02 工作日、周末

     */
    public String getDeliverTimeCode() {
        return deliverTimeCode;
    }

    /**
     * @param deliverTimeCode 
	 *            配送时间<br>
	 *            00 工作日<br>
	 *            01 周末<br>
	 *            02 工作日、周末<br>
	 *            
     */
    /**
     * @param deliverTimeCode of ORD_D_POST : 设置 配送时间
00 工作日
01 周末
02 工作日、周末

     */
    public void setDeliverTimeCode(String deliverTimeCode) {
        this.deliverTimeCode = deliverTimeCode == null ? null : deliverTimeCode.trim();
    }

    /**
     * @return 收件人姓名
     */
    /**
     * @return ORD_D_POST.RECEIVER_NAME : 返回 收件人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName 
	 *            收件人姓名
     */
    /**
     * @param receiverName of ORD_D_POST : 设置 收件人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * @return 收件人证件类型
     */
    /**
     * @return ORD_D_POST.RECEIVER_PSPT_TYPE : 返回 收件人证件类型
     */
    public String getReceiverPsptType() {
        return receiverPsptType;
    }

    /**
     * @param receiverPsptType 
	 *            收件人证件类型
     */
    /**
     * @param receiverPsptType of ORD_D_POST : 设置 收件人证件类型
     */
    public void setReceiverPsptType(String receiverPsptType) {
        this.receiverPsptType = receiverPsptType == null ? null : receiverPsptType.trim();
    }

    /**
     * @return 收件人证件号码
     */
    /**
     * @return ORD_D_POST.RECEIVER_PSPT_NO : 返回 收件人证件号码
     */
    public String getReceiverPsptNo() {
        return receiverPsptNo;
    }

    /**
     * @param receiverPsptNo 
	 *            收件人证件号码
     */
    /**
     * @param receiverPsptNo of ORD_D_POST : 设置 收件人证件号码
     */
    public void setReceiverPsptNo(String receiverPsptNo) {
        this.receiverPsptNo = receiverPsptNo == null ? null : receiverPsptNo.trim();
    }

    /**
     * @return 手机号码
     */
    /**
     * @return ORD_D_POST.MOBILE_PHONE : 返回 手机号码
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone 
	 *            手机号码
     */
    /**
     * @param mobilePhone of ORD_D_POST : 设置 手机号码
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * @return 固定电话
     */
    /**
     * @return ORD_D_POST.FIX_PHONE : 返回 固定电话
     */
    public String getFixPhone() {
        return fixPhone;
    }

    /**
     * @param fixPhone 
	 *            固定电话
     */
    /**
     * @param fixPhone of ORD_D_POST : 设置 固定电话
     */
    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone == null ? null : fixPhone.trim();
    }

    /**
     * @return EMAIL
     */
    /**
     * @return ORD_D_POST.EMAIL : 返回 EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            EMAIL
     */
    /**
     * @param email of ORD_D_POST : 设置 EMAIL
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 省份编码
     */
    /**
     * @return ORD_D_POST.PROVINCE_CODE : 返回 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份编码
     */
    /**
     * @param provinceCode of ORD_D_POST : 设置 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 地市编码
     */
    /**
     * @return ORD_D_POST.CITY_CODE : 返回 地市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            地市编码
     */
    /**
     * @param cityCode of ORD_D_POST : 设置 地市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return 区县编码
     */
    /**
     * @return ORD_D_POST.DISTRICT_CODE : 返回 区县编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * @param districtCode 
	 *            区县编码
     */
    /**
     * @param districtCode of ORD_D_POST : 设置 区县编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * @return 邮政编码
     */
    /**
     * @return ORD_D_POST.POST_CODE : 返回 邮政编码
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode 
	 *            邮政编码
     */
    /**
     * @param postCode of ORD_D_POST : 设置 邮政编码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * @return 详细地址
     */
    /**
     * @return ORD_D_POST.POST_ADDR : 返回 详细地址
     */
    public String getPostAddr() {
        return postAddr;
    }

    /**
     * @param postAddr 
	 *            详细地址
     */
    /**
     * @param postAddr of ORD_D_POST : 设置 详细地址
     */
    public void setPostAddr(String postAddr) {
        this.postAddr = postAddr == null ? null : postAddr.trim();
    }

    /**
     * @return 邮寄备选
     */
    /**
     * @return ORD_D_POST.POST_REMARK : 返回 邮寄备选
     */
    public String getPostRemark() {
        return postRemark;
    }

    /**
     * @param postRemark 
	 *            邮寄备选
     */
    /**
     * @param postRemark of ORD_D_POST : 设置 邮寄备选
     */
    public void setPostRemark(String postRemark) {
        this.postRemark = postRemark == null ? null : postRemark.trim();
    }

    /**
     * @return 物流单号
     */
    /**
     * @return ORD_D_POST.EXPRESS_ID : 返回 物流单号
     */
    public String getExpressId() {
        return expressId;
    }

    /**
     * @param expressId 
	 *            物流单号
     */
    /**
     * @param expressId of ORD_D_POST : 设置 物流单号
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    /**
     * @return 物流公司
     */
    /**
     * @return ORD_D_POST.EXPRESS_COMPNAY : 返回 物流公司
     */
    public String getExpressCompnay() {
        return expressCompnay;
    }

    /**
     * @param expressCompnay 
	 *            物流公司
     */
    /**
     * @param expressCompnay of ORD_D_POST : 设置 物流公司
     */
    public void setExpressCompnay(String expressCompnay) {
        this.expressCompnay = expressCompnay == null ? null : expressCompnay.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_POST.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_POST : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_POST.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_POST : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}