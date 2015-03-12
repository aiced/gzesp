package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 能人基础信息表
 */
/**
 * @ClassName: TdAurDBASEINFO
* @Description: AUR_D_BASEINFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdAurDBASEINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    /**
     * @Fields AUR_D_BASEINFO.ID :ID
     */
    private Long id;

    /**
     * 能人编码
     */
    /**
     * @Fields AUR_D_BASEINFO.USER_ID :能人编码
     */
    private String userId;

    /**
     * 能人名称
     */
    /**
     * @Fields AUR_D_BASEINFO.USER_NAME :能人名称
     */
    private String userName;

    /**
     * 地址
     */
    /**
     * @Fields AUR_D_BASEINFO.ADDRESS :地址
     */
    private String address;

    /**
     * 类型<br>
	 * 04=有成卡代客下单<br>
	 * 05=无成卡代客下单<br>
	 * 06=宣传链接
     */
    /**
     * @Fields AUR_D_BASEINFO.CHANNEL_TYPE :类型
04=有成卡代客下单
05=无成卡代客下单
06=宣传链接
     */
    private String channelType;

    /**
     * 级别<br>
	 * 00： 一级能人<br>
	 * 01：二级能人<br>
	 * 
     */
    /**
     * @Fields AUR_D_BASEINFO.CHANNEL_LEVEL :级别
00： 一级能人
01：二级能人

     */
    private String channelLevel;

    /**
     * 省份
     */
    /**
     * @Fields AUR_D_BASEINFO.PROVINCE_CODE :省份
     */
    private String provinceCode;

    /**
     * 省份
     */
    /**
     * @Fields AUR_D_BASEINFO.EPARCHY_CODE :省份
     */
    private String eparchyCode;

    /**
     * 归属区县
     */
    /**
     * @Fields AUR_D_BASEINFO.CITY_CODE :归属区县
     */
    private String cityCode;

    /**
     * 销售区域
     */
    /**
     * @Fields AUR_D_BASEINFO.SALES_AREA :销售区域
     */
    private String salesArea;

    /**
     * @Fields AUR_D_BASEINFO.USER_DESC :null
     */
    private String userDesc;

    /**
     * @Fields AUR_D_BASEINFO.CREATE_DATE :null
     */
    private Date createDate;

    /**
     * 00=待审核<br>
	 * 01=正常<br>
	 * 02=暂停<br>
	 * 03=注销<br>
	 * 04=待激活<br>
	 * 09=审核未通过
     */
    /**
     * @Fields AUR_D_BASEINFO.STATUS :00=待审核
01=正常
02=暂停
03=注销
04=待激活
09=审核未通过
     */
    private String status;

    /**
     * @Fields AUR_D_BASEINFO.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields AUR_D_BASEINFO.UPDATE_STAFF :null
     */
    private String updateStaff;

    /**
     * @Fields AUR_D_BASEINFO.OUT_TIME :null
     */
    private Date outTime;

    /**
     * @Fields AUR_D_BASEINFO.OUT_DESC :null
     */
    private String outDesc;

    /**
     * @Fields AUR_D_BASEINFO.OUT_STAFF :null
     */
    private String outStaff;

    /**
     * 网络营销团队
     */
    /**
     * @Fields AUR_D_BASEINFO.MANAGER_ID :网络营销团队
     */
    private String managerId;

    /**
     * 能人推荐人信息
     */
    /**
     * @Fields AUR_D_BASEINFO.MANAGER_NAME :能人推荐人信息
     */
    private String managerName;

    /**
     * @Fields AUR_D_BASEINFO.MANAGER_CONTACT :null
     */
    private String managerContact;

    /**
     * @Fields AUR_D_BASEINFO.IDENTITY_TYPE :null
     */
    private String identityType;

    /**
     * @Fields AUR_D_BASEINFO.IDENTITY_NUM :null
     */
    private String identityNum;

    /**
     * @Fields AUR_D_BASEINFO.MOBILE :null
     */
    private String mobile;

    /**
     * @Fields AUR_D_BASEINFO.FIX_PHONE :null
     */
    private String fixPhone;

    /**
     * @Fields AUR_D_BASEINFO.EMAIL :null
     */
    private String email;

    /**
     * @Fields AUR_D_BASEINFO.CONTACT_QQ :null
     */
    private String contactQq;

    /**
     * @Fields AUR_D_BASEINFO.POST_CODE :null
     */
    private String postCode;

    /**
     * 能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    /**
     * @Fields AUR_D_BASEINFO.BANK_NAME :能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    private String bankName;

    /**
     * 能人开户工号
     */
    /**
     * @Fields AUR_D_BASEINFO.BANK_ACCT :能人开户工号
     */
    private String bankAcct;

    /**
     * @Fields AUR_D_BASEINFO.RESERVED1 :null
     */
    private String reserved1;

    /**
     * @Fields AUR_D_BASEINFO.RESERVED2 :null
     */
    private String reserved2;

    /**
     * @return ID
     */
    /**
     * @return AUR_D_BASEINFO.ID : 返回 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 
	 *            ID
     */
    /**
     * @param id of AUR_D_BASEINFO : 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 能人编码
     */
    /**
     * @return AUR_D_BASEINFO.USER_ID : 返回 能人编码
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人编码
     */
    /**
     * @param userId of AUR_D_BASEINFO : 设置 能人编码
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 能人名称
     */
    /**
     * @return AUR_D_BASEINFO.USER_NAME : 返回 能人名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 
	 *            能人名称
     */
    /**
     * @param userName of AUR_D_BASEINFO : 设置 能人名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return 地址
     */
    /**
     * @return AUR_D_BASEINFO.ADDRESS : 返回 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            地址
     */
    /**
     * @param address of AUR_D_BASEINFO : 设置 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 类型<br>
	 *         04=有成卡代客下单<br>
	 *         05=无成卡代客下单<br>
	 *         06=宣传链接
     */
    /**
     * @return AUR_D_BASEINFO.CHANNEL_TYPE : 返回 类型
04=有成卡代客下单
05=无成卡代客下单
06=宣传链接
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * @param channelType 
	 *            类型<br>
	 *            04=有成卡代客下单<br>
	 *            05=无成卡代客下单<br>
	 *            06=宣传链接
     */
    /**
     * @param channelType of AUR_D_BASEINFO : 设置 类型
04=有成卡代客下单
05=无成卡代客下单
06=宣传链接
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    /**
     * @return 级别<br>
	 *         00： 一级能人<br>
	 *         01：二级能人<br>
	 *         
     */
    /**
     * @return AUR_D_BASEINFO.CHANNEL_LEVEL : 返回 级别
00： 一级能人
01：二级能人

     */
    public String getChannelLevel() {
        return channelLevel;
    }

    /**
     * @param channelLevel 
	 *            级别<br>
	 *            00： 一级能人<br>
	 *            01：二级能人<br>
	 *            
     */
    /**
     * @param channelLevel of AUR_D_BASEINFO : 设置 级别
00： 一级能人
01：二级能人

     */
    public void setChannelLevel(String channelLevel) {
        this.channelLevel = channelLevel == null ? null : channelLevel.trim();
    }

    /**
     * @return 省份
     */
    /**
     * @return AUR_D_BASEINFO.PROVINCE_CODE : 返回 省份
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            省份
     */
    /**
     * @param provinceCode of AUR_D_BASEINFO : 设置 省份
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 省份
     */
    /**
     * @return AUR_D_BASEINFO.EPARCHY_CODE : 返回 省份
     */
    public String getEparchyCode() {
        return eparchyCode;
    }

    /**
     * @param eparchyCode 
	 *            省份
     */
    /**
     * @param eparchyCode of AUR_D_BASEINFO : 设置 省份
     */
    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode == null ? null : eparchyCode.trim();
    }

    /**
     * @return 归属区县
     */
    /**
     * @return AUR_D_BASEINFO.CITY_CODE : 返回 归属区县
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            归属区县
     */
    /**
     * @param cityCode of AUR_D_BASEINFO : 设置 归属区县
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return 销售区域
     */
    /**
     * @return AUR_D_BASEINFO.SALES_AREA : 返回 销售区域
     */
    public String getSalesArea() {
        return salesArea;
    }

    /**
     * @param salesArea 
	 *            销售区域
     */
    /**
     * @param salesArea of AUR_D_BASEINFO : 设置 销售区域
     */
    public void setSalesArea(String salesArea) {
        this.salesArea = salesArea == null ? null : salesArea.trim();
    }

    /**
     * @return AUR_D_BASEINFO.USER_DESC : 返回 null
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * @param userDesc of AUR_D_BASEINFO : 设置 null
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    /**
     * @return AUR_D_BASEINFO.CREATE_DATE : 返回 null
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate of AUR_D_BASEINFO : 设置 null
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return 00=待审核<br>
	 *         01=正常<br>
	 *         02=暂停<br>
	 *         03=注销<br>
	 *         04=待激活<br>
	 *         09=审核未通过
     */
    /**
     * @return AUR_D_BASEINFO.STATUS : 返回 00=待审核
01=正常
02=暂停
03=注销
04=待激活
09=审核未通过
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            00=待审核<br>
	 *            01=正常<br>
	 *            02=暂停<br>
	 *            03=注销<br>
	 *            04=待激活<br>
	 *            09=审核未通过
     */
    /**
     * @param status of AUR_D_BASEINFO : 设置 00=待审核
01=正常
02=暂停
03=注销
04=待激活
09=审核未通过
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return AUR_D_BASEINFO.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of AUR_D_BASEINFO : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return AUR_D_BASEINFO.UPDATE_STAFF : 返回 null
     */
    public String getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff of AUR_D_BASEINFO : 设置 null
     */
    public void setUpdateStaff(String updateStaff) {
        this.updateStaff = updateStaff == null ? null : updateStaff.trim();
    }

    /**
     * @return AUR_D_BASEINFO.OUT_TIME : 返回 null
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * @param outTime of AUR_D_BASEINFO : 设置 null
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * @return AUR_D_BASEINFO.OUT_DESC : 返回 null
     */
    public String getOutDesc() {
        return outDesc;
    }

    /**
     * @param outDesc of AUR_D_BASEINFO : 设置 null
     */
    public void setOutDesc(String outDesc) {
        this.outDesc = outDesc == null ? null : outDesc.trim();
    }

    /**
     * @return AUR_D_BASEINFO.OUT_STAFF : 返回 null
     */
    public String getOutStaff() {
        return outStaff;
    }

    /**
     * @param outStaff of AUR_D_BASEINFO : 设置 null
     */
    public void setOutStaff(String outStaff) {
        this.outStaff = outStaff == null ? null : outStaff.trim();
    }

    /**
     * @return 网络营销团队
     */
    /**
     * @return AUR_D_BASEINFO.MANAGER_ID : 返回 网络营销团队
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * @param managerId 
	 *            网络营销团队
     */
    /**
     * @param managerId of AUR_D_BASEINFO : 设置 网络营销团队
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    /**
     * @return 能人推荐人信息
     */
    /**
     * @return AUR_D_BASEINFO.MANAGER_NAME : 返回 能人推荐人信息
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName 
	 *            能人推荐人信息
     */
    /**
     * @param managerName of AUR_D_BASEINFO : 设置 能人推荐人信息
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    /**
     * @return AUR_D_BASEINFO.MANAGER_CONTACT : 返回 null
     */
    public String getManagerContact() {
        return managerContact;
    }

    /**
     * @param managerContact of AUR_D_BASEINFO : 设置 null
     */
    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact == null ? null : managerContact.trim();
    }

    /**
     * @return AUR_D_BASEINFO.IDENTITY_TYPE : 返回 null
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * @param identityType of AUR_D_BASEINFO : 设置 null
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * @return AUR_D_BASEINFO.IDENTITY_NUM : 返回 null
     */
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     * @param identityNum of AUR_D_BASEINFO : 设置 null
     */
    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }

    /**
     * @return AUR_D_BASEINFO.MOBILE : 返回 null
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile of AUR_D_BASEINFO : 设置 null
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * @return AUR_D_BASEINFO.FIX_PHONE : 返回 null
     */
    public String getFixPhone() {
        return fixPhone;
    }

    /**
     * @param fixPhone of AUR_D_BASEINFO : 设置 null
     */
    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone == null ? null : fixPhone.trim();
    }

    /**
     * @return AUR_D_BASEINFO.EMAIL : 返回 null
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email of AUR_D_BASEINFO : 设置 null
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return AUR_D_BASEINFO.CONTACT_QQ : 返回 null
     */
    public String getContactQq() {
        return contactQq;
    }

    /**
     * @param contactQq of AUR_D_BASEINFO : 设置 null
     */
    public void setContactQq(String contactQq) {
        this.contactQq = contactQq == null ? null : contactQq.trim();
    }

    /**
     * @return AUR_D_BASEINFO.POST_CODE : 返回 null
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode of AUR_D_BASEINFO : 设置 null
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * @return 能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    /**
     * @return AUR_D_BASEINFO.BANK_NAME : 返回 能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName 
	 *            能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    /**
     * @param bankName of AUR_D_BASEINFO : 设置 能人资金账户：易宝账户/支付宝账户 /银联账户
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * @return 能人开户工号
     */
    /**
     * @return AUR_D_BASEINFO.BANK_ACCT : 返回 能人开户工号
     */
    public String getBankAcct() {
        return bankAcct;
    }

    /**
     * @param bankAcct 
	 *            能人开户工号
     */
    /**
     * @param bankAcct of AUR_D_BASEINFO : 设置 能人开户工号
     */
    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct == null ? null : bankAcct.trim();
    }

    /**
     * @return AUR_D_BASEINFO.RESERVED1 : 返回 null
     */
    public String getReserved1() {
        return reserved1;
    }

    /**
     * @param reserved1 of AUR_D_BASEINFO : 设置 null
     */
    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1 == null ? null : reserved1.trim();
    }

    /**
     * @return AUR_D_BASEINFO.RESERVED2 : 返回 null
     */
    public String getReserved2() {
        return reserved2;
    }

    /**
     * @param reserved2 of AUR_D_BASEINFO : 设置 null
     */
    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2 == null ? null : reserved2.trim();
    }
}