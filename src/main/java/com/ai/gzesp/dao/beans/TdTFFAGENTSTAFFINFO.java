package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdTFFAGENTSTAFFINFO
* @Description: TF_F_AGENT_STAFF_INFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdTFFAGENTSTAFFINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.ID :null
     */
    private Integer id;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.USER_TYPE :null
     */
    private String userType;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.USER_LEVEL :null
     */
    private String userLevel;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AGENTNAME :null
     */
    private String agentname;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.SALE_MODE :null
     */
    private String saleMode;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.NATURE :null
     */
    private String nature;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.SUPERIOR_ID :null
     */
    private Integer superiorId;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.USERNAME :null
     */
    private String username;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.PASSWORD :null
     */
    private String password;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.HIERARCHY :null
     */
    private String hierarchy;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AREANO :null
     */
    private String areano;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.REALNAME :null
     */
    private String realname;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.IDENTITY_TYPE :null
     */
    private String identityType;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.IDENTITY_NUM :null
     */
    private String identityNum;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.SEX :null
     */
    private String sex;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.MOBILE :null
     */
    private String mobile;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.OPEN_BANK :null
     */
    private String openBank;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.ACCOUNT_HOLDER :null
     */
    private String accountHolder;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.ACCOUNT_NUMBER :null
     */
    private String accountNumber;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.EMAIL :null
     */
    private String email;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.QQ :null
     */
    private String qq;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.ADDRESS :null
     */
    private String address;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.CHANNEL_MGR :null
     */
    private String channelMgr;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.CHANNEL_MGR_PHONE :null
     */
    private String channelMgrPhone;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.IS_STORE :null
     */
    private String isStore;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.REGISTERDATE :null
     */
    private Date registerdate;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.STATUS :null
     */
    private String status;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AGENTLINK :null
     */
    private String agentlink;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.SALT :null
     */
    private String salt;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.UPDATE_OPERATOR :null
     */
    private String updateOperator;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.OUT_TIME :null
     */
    private Date outTime;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.OUT_OPERATOR :null
     */
    private String outOperator;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.OUT_DESC :null
     */
    private String outDesc;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AUDIT_TIME :null
     */
    private Date auditTime;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AUDIT_OPERATOR :null
     */
    private String auditOperator;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.AUDIT_DESC :null
     */
    private String auditDesc;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.FILL_FLAG :null
     */
    private String fillFlag;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.SMS_FLAG :null
     */
    private String smsFlag;

    /**
     * 1、客户经理<br>
	 * 2、自然人<br>
	 * 3、普通代理商<br>
	 * 4、协议代理商
     */
    /**
     * @Fields TF_F_AGENT_STAFF_INFO.CHANNEL_TYPE :1、客户经理
2、自然人
3、普通代理商
4、协议代理商
     */
    private String channelType;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.BELONG_AREA :null
     */
    private String belongArea;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.IDENTITY_PIC1 :null
     */
    private String identityPic1;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.IDENTITY_PIC2 :null
     */
    private String identityPic2;

    /**
     * @Fields TF_F_AGENT_STAFF_INFO.CHANNEL_CODE :null
     */
    private String channelCode;

    /**
     * @return TF_F_AGENT_STAFF_INFO.ID : 返回 null
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.USER_TYPE : 返回 null
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.USER_LEVEL : 返回 null
     */
    public String getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel == null ? null : userLevel.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AGENTNAME : 返回 null
     */
    public String getAgentname() {
        return agentname;
    }

    /**
     * @param agentname of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAgentname(String agentname) {
        this.agentname = agentname == null ? null : agentname.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.SALE_MODE : 返回 null
     */
    public String getSaleMode() {
        return saleMode;
    }

    /**
     * @param saleMode of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setSaleMode(String saleMode) {
        this.saleMode = saleMode == null ? null : saleMode.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.NATURE : 返回 null
     */
    public String getNature() {
        return nature;
    }

    /**
     * @param nature of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.SUPERIOR_ID : 返回 null
     */
    public Integer getSuperiorId() {
        return superiorId;
    }

    /**
     * @param superiorId of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.USERNAME : 返回 null
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.PASSWORD : 返回 null
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.HIERARCHY : 返回 null
     */
    public String getHierarchy() {
        return hierarchy;
    }

    /**
     * @param hierarchy of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy == null ? null : hierarchy.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AREANO : 返回 null
     */
    public String getAreano() {
        return areano;
    }

    /**
     * @param areano of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAreano(String areano) {
        this.areano = areano == null ? null : areano.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.REALNAME : 返回 null
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.IDENTITY_TYPE : 返回 null
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * @param identityType of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.IDENTITY_NUM : 返回 null
     */
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     * @param identityNum of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.SEX : 返回 null
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.MOBILE : 返回 null
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.OPEN_BANK : 返回 null
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * @param openBank of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.ACCOUNT_HOLDER : 返回 null
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * @param accountHolder of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder == null ? null : accountHolder.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.ACCOUNT_NUMBER : 返回 null
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.EMAIL : 返回 null
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.QQ : 返回 null
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.ADDRESS : 返回 null
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.CHANNEL_MGR : 返回 null
     */
    public String getChannelMgr() {
        return channelMgr;
    }

    /**
     * @param channelMgr of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setChannelMgr(String channelMgr) {
        this.channelMgr = channelMgr == null ? null : channelMgr.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.CHANNEL_MGR_PHONE : 返回 null
     */
    public String getChannelMgrPhone() {
        return channelMgrPhone;
    }

    /**
     * @param channelMgrPhone of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setChannelMgrPhone(String channelMgrPhone) {
        this.channelMgrPhone = channelMgrPhone == null ? null : channelMgrPhone.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.IS_STORE : 返回 null
     */
    public String getIsStore() {
        return isStore;
    }

    /**
     * @param isStore of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setIsStore(String isStore) {
        this.isStore = isStore == null ? null : isStore.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.REGISTERDATE : 返回 null
     */
    public Date getRegisterdate() {
        return registerdate;
    }

    /**
     * @param registerdate of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.STATUS : 返回 null
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AGENTLINK : 返回 null
     */
    public String getAgentlink() {
        return agentlink;
    }

    /**
     * @param agentlink of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAgentlink(String agentlink) {
        this.agentlink = agentlink == null ? null : agentlink.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.SALT : 返回 null
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.UPDATE_OPERATOR : 返回 null
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * @param updateOperator of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.OUT_TIME : 返回 null
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * @param outTime of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.OUT_OPERATOR : 返回 null
     */
    public String getOutOperator() {
        return outOperator;
    }

    /**
     * @param outOperator of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setOutOperator(String outOperator) {
        this.outOperator = outOperator == null ? null : outOperator.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.OUT_DESC : 返回 null
     */
    public String getOutDesc() {
        return outDesc;
    }

    /**
     * @param outDesc of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setOutDesc(String outDesc) {
        this.outDesc = outDesc == null ? null : outDesc.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AUDIT_TIME : 返回 null
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AUDIT_OPERATOR : 返回 null
     */
    public String getAuditOperator() {
        return auditOperator;
    }

    /**
     * @param auditOperator of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAuditOperator(String auditOperator) {
        this.auditOperator = auditOperator == null ? null : auditOperator.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.AUDIT_DESC : 返回 null
     */
    public String getAuditDesc() {
        return auditDesc;
    }

    /**
     * @param auditDesc of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.FILL_FLAG : 返回 null
     */
    public String getFillFlag() {
        return fillFlag;
    }

    /**
     * @param fillFlag of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setFillFlag(String fillFlag) {
        this.fillFlag = fillFlag == null ? null : fillFlag.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.SMS_FLAG : 返回 null
     */
    public String getSmsFlag() {
        return smsFlag;
    }

    /**
     * @param smsFlag of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setSmsFlag(String smsFlag) {
        this.smsFlag = smsFlag == null ? null : smsFlag.trim();
    }

    /**
     * @return 1、客户经理<br>
	 *         2、自然人<br>
	 *         3、普通代理商<br>
	 *         4、协议代理商
     */
    /**
     * @return TF_F_AGENT_STAFF_INFO.CHANNEL_TYPE : 返回 1、客户经理
2、自然人
3、普通代理商
4、协议代理商
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * @param channelType 
	 *            1、客户经理<br>
	 *            2、自然人<br>
	 *            3、普通代理商<br>
	 *            4、协议代理商
     */
    /**
     * @param channelType of TF_F_AGENT_STAFF_INFO : 设置 1、客户经理
2、自然人
3、普通代理商
4、协议代理商
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.BELONG_AREA : 返回 null
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * @param belongArea of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea == null ? null : belongArea.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.IDENTITY_PIC1 : 返回 null
     */
    public String getIdentityPic1() {
        return identityPic1;
    }

    /**
     * @param identityPic1 of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setIdentityPic1(String identityPic1) {
        this.identityPic1 = identityPic1 == null ? null : identityPic1.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.IDENTITY_PIC2 : 返回 null
     */
    public String getIdentityPic2() {
        return identityPic2;
    }

    /**
     * @param identityPic2 of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setIdentityPic2(String identityPic2) {
        this.identityPic2 = identityPic2 == null ? null : identityPic2.trim();
    }

    /**
     * @return TF_F_AGENT_STAFF_INFO.CHANNEL_CODE : 返回 null
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * @param channelCode of TF_F_AGENT_STAFF_INFO : 设置 null
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }
}