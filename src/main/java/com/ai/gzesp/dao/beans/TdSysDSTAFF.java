package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdSysDSTAFF
* @Description: SYS_D_STAFF表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTAFF implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields SYS_D_STAFF.STAFF_ID :null
     */
    private Integer staffId;

    /**
     * @Fields SYS_D_STAFF.STAFF_CODE :null
     */
    private String staffCode;

    /**
     * @Fields SYS_D_STAFF.MERCHANT_ID :null
     */
    private Integer merchantId;

    /**
     * @Fields SYS_D_STAFF.STAFF_NAME :null
     */
    private String staffName;

    /**
     * @Fields SYS_D_STAFF.PASSWD :null
     */
    private String passwd;

    /**
     * @Fields SYS_D_STAFF.STAFF_STATUS :null
     */
    private String staffStatus;

    /**
     * @Fields SYS_D_STAFF.LINK_PHONE :null
     */
    private String linkPhone;

    /**
     * @Fields SYS_D_STAFF.EMAIL :null
     */
    private String email;

    /**
     * @Fields SYS_D_STAFF.PROVINCE_CODE :null
     */
    private String provinceCode;

    /**
     * @Fields SYS_D_STAFF.ESS_STAFF_ID :null
     */
    private String essStaffId;

    /**
     * @Fields SYS_D_STAFF.CHANNEL_CODE :null
     */
    private String channelCode;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_D_STAFF.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * @Fields SYS_D_STAFF.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_STAFF.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_STAFF.VALUES2 :null
     */
    private String values2;

    /**
     * 渠道类型
     */
    /**
     * @Fields SYS_D_STAFF.CHANNEL_TYPE :渠道类型
     */
    private String channelType;

    /**
     * 渠道编码描述
     */
    /**
     * @Fields SYS_D_STAFF.CHANNEL_DESC :渠道编码描述
     */
    private String channelDesc;

    /**
     * 初始密码标记 1:是初始密码 0:非初始密码
     */
    /**
     * @Fields SYS_D_STAFF.INIT_PASSWORD_TAG :初始密码标记 1:是初始密码 0:非初始密码
     */
    private String initPasswordTag;

    /**
     * @Fields SYS_D_STAFF.SYS_CODE :null
     */
    private String sysCode;

    /**
     * 员工归属描述
     */
    /**
     * @Fields SYS_D_STAFF.STAFF_BELONG_DESC :员工归属描述
     */
    private String staffBelongDesc;

    /**
     * 员工归属区域编码
     */
    /**
     * @Fields SYS_D_STAFF.AREA_CODE :员工归属区域编码
     */
    private String areaCode;

    /**
     * 默认00为商城员工，01为网格经理，02为渠道经理
     */
    /**
     * @Fields SYS_D_STAFF.STAFF_TYPE :默认00为商城员工，01为网格经理，02为渠道经理
     */
    private String staffType;

    /**
     * 密码盐值
     */
    /**
     * @Fields SYS_D_STAFF.SALT :密码盐值
     */
    private String salt;

    /**
     * @return SYS_D_STAFF.STAFF_ID : 返回 null
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId of SYS_D_STAFF : 设置 null
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return SYS_D_STAFF.STAFF_CODE : 返回 null
     */
    public String getStaffCode() {
        return staffCode;
    }

    /**
     * @param staffCode of SYS_D_STAFF : 设置 null
     */
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    /**
     * @return SYS_D_STAFF.MERCHANT_ID : 返回 null
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId of SYS_D_STAFF : 设置 null
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return SYS_D_STAFF.STAFF_NAME : 返回 null
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName of SYS_D_STAFF : 设置 null
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * @return SYS_D_STAFF.PASSWD : 返回 null
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd of SYS_D_STAFF : 设置 null
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * @return SYS_D_STAFF.STAFF_STATUS : 返回 null
     */
    public String getStaffStatus() {
        return staffStatus;
    }

    /**
     * @param staffStatus of SYS_D_STAFF : 设置 null
     */
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus == null ? null : staffStatus.trim();
    }

    /**
     * @return SYS_D_STAFF.LINK_PHONE : 返回 null
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * @param linkPhone of SYS_D_STAFF : 设置 null
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    /**
     * @return SYS_D_STAFF.EMAIL : 返回 null
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email of SYS_D_STAFF : 设置 null
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return SYS_D_STAFF.PROVINCE_CODE : 返回 null
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode of SYS_D_STAFF : 设置 null
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return SYS_D_STAFF.ESS_STAFF_ID : 返回 null
     */
    public String getEssStaffId() {
        return essStaffId;
    }

    /**
     * @param essStaffId of SYS_D_STAFF : 设置 null
     */
    public void setEssStaffId(String essStaffId) {
        this.essStaffId = essStaffId == null ? null : essStaffId.trim();
    }

    /**
     * @return SYS_D_STAFF.CHANNEL_CODE : 返回 null
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * @param channelCode of SYS_D_STAFF : 设置 null
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_D_STAFF.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_D_STAFF : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return SYS_D_STAFF.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of SYS_D_STAFF : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_STAFF.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_STAFF : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_STAFF.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_STAFF : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 渠道类型
     */
    /**
     * @return SYS_D_STAFF.CHANNEL_TYPE : 返回 渠道类型
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * @param channelType 
	 *            渠道类型
     */
    /**
     * @param channelType of SYS_D_STAFF : 设置 渠道类型
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    /**
     * @return 渠道编码描述
     */
    /**
     * @return SYS_D_STAFF.CHANNEL_DESC : 返回 渠道编码描述
     */
    public String getChannelDesc() {
        return channelDesc;
    }

    /**
     * @param channelDesc 
	 *            渠道编码描述
     */
    /**
     * @param channelDesc of SYS_D_STAFF : 设置 渠道编码描述
     */
    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc == null ? null : channelDesc.trim();
    }

    /**
     * @return 初始密码标记 1:是初始密码 0:非初始密码
     */
    /**
     * @return SYS_D_STAFF.INIT_PASSWORD_TAG : 返回 初始密码标记 1:是初始密码 0:非初始密码
     */
    public String getInitPasswordTag() {
        return initPasswordTag;
    }

    /**
     * @param initPasswordTag 
	 *            初始密码标记 1:是初始密码 0:非初始密码
     */
    /**
     * @param initPasswordTag of SYS_D_STAFF : 设置 初始密码标记 1:是初始密码 0:非初始密码
     */
    public void setInitPasswordTag(String initPasswordTag) {
        this.initPasswordTag = initPasswordTag == null ? null : initPasswordTag.trim();
    }

    /**
     * @return SYS_D_STAFF.SYS_CODE : 返回 null
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * @param sysCode of SYS_D_STAFF : 设置 null
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    /**
     * @return 员工归属描述
     */
    /**
     * @return SYS_D_STAFF.STAFF_BELONG_DESC : 返回 员工归属描述
     */
    public String getStaffBelongDesc() {
        return staffBelongDesc;
    }

    /**
     * @param staffBelongDesc 
	 *            员工归属描述
     */
    /**
     * @param staffBelongDesc of SYS_D_STAFF : 设置 员工归属描述
     */
    public void setStaffBelongDesc(String staffBelongDesc) {
        this.staffBelongDesc = staffBelongDesc == null ? null : staffBelongDesc.trim();
    }

    /**
     * @return 员工归属区域编码
     */
    /**
     * @return SYS_D_STAFF.AREA_CODE : 返回 员工归属区域编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode 
	 *            员工归属区域编码
     */
    /**
     * @param areaCode of SYS_D_STAFF : 设置 员工归属区域编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * @return 默认00为商城员工，01为网格经理，02为渠道经理
     */
    /**
     * @return SYS_D_STAFF.STAFF_TYPE : 返回 默认00为商城员工，01为网格经理，02为渠道经理
     */
    public String getStaffType() {
        return staffType;
    }

    /**
     * @param staffType 
	 *            默认00为商城员工，01为网格经理，02为渠道经理
     */
    /**
     * @param staffType of SYS_D_STAFF : 设置 默认00为商城员工，01为网格经理，02为渠道经理
     */
    public void setStaffType(String staffType) {
        this.staffType = staffType == null ? null : staffType.trim();
    }

    /**
     * @return 密码盐值
     */
    /**
     * @return SYS_D_STAFF.SALT : 返回 密码盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt 
	 *            密码盐值
     */
    /**
     * @param salt of SYS_D_STAFF : 设置 密码盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}