package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 能人登陆信息表
 */
/**
 * @ClassName: TdAurDAUTHINFO
* @Description: AUR_D_AUTHINFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdAurDAUTHINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    /**
     * @Fields AUR_D_AUTHINFO.ID :ID
     */
    private Long id;

    /**
     * 用户名
     */
    /**
     * @Fields AUR_D_AUTHINFO.USER_ID :用户名
     */
    private String userId;

    /**
     * 昵称
     */
    /**
     * @Fields AUR_D_AUTHINFO.USER_NAME :昵称
     */
    private String userName;

    /**
     * 头像地址
     */
    /**
     * @Fields AUR_D_AUTHINFO.USER_IMG :头像地址
     */
    private String userImg;

    /**
     * 密码
     */
    /**
     * @Fields AUR_D_AUTHINFO.USER_PASSWORD :密码
     */
    private String userPassword;

    /**
     * 微信号
     */
    /**
     * @Fields AUR_D_AUTHINFO.WEIXIN_ID :微信号
     */
    private String weixinId;

    /**
     * 邮箱
     */
    /**
     * @Fields AUR_D_AUTHINFO.EMAIL :邮箱
     */
    private String email;

    /**
     * 手机号
     */
    /**
     * @Fields AUR_D_AUTHINFO.PHONE_NUMBER :手机号
     */
    private String phoneNumber;

    /**
     * 账号状态<br>
	 * 00:正常<br>
	 * 01:待审核<br>
	 * 02:审核不通过<br>
	 * 03:锁定<br>
	 * 04:预注销<br>
	 * 05:正式注销
     */
    /**
     * @Fields AUR_D_AUTHINFO.STATUS :账号状态
00:正常
01:待审核
02:审核不通过
03:锁定
04:预注销
05:正式注销
     */
    private String status;

    /**
     * 店铺ID
     */
    /**
     * @Fields AUR_D_AUTHINFO.STORE_ID :店铺ID
     */
    private String storeId;

    /**
     * 店铺名称
     */
    /**
     * @Fields AUR_D_AUTHINFO.STORE_NAME :店铺名称
     */
    private String storeName;

    /**
     * @return ID
     */
    /**
     * @return AUR_D_AUTHINFO.ID : 返回 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 
	 *            ID
     */
    /**
     * @param id of AUR_D_AUTHINFO : 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 用户名
     */
    /**
     * @return AUR_D_AUTHINFO.USER_ID : 返回 用户名
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户名
     */
    /**
     * @param userId of AUR_D_AUTHINFO : 设置 用户名
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 昵称
     */
    /**
     * @return AUR_D_AUTHINFO.USER_NAME : 返回 昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 
	 *            昵称
     */
    /**
     * @param userName of AUR_D_AUTHINFO : 设置 昵称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return 头像地址
     */
    /**
     * @return AUR_D_AUTHINFO.USER_IMG : 返回 头像地址
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * @param userImg 
	 *            头像地址
     */
    /**
     * @param userImg of AUR_D_AUTHINFO : 设置 头像地址
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    /**
     * @return 密码
     */
    /**
     * @return AUR_D_AUTHINFO.USER_PASSWORD : 返回 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword 
	 *            密码
     */
    /**
     * @param userPassword of AUR_D_AUTHINFO : 设置 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * @return 微信号
     */
    /**
     * @return AUR_D_AUTHINFO.WEIXIN_ID : 返回 微信号
     */
    public String getWeixinId() {
        return weixinId;
    }

    /**
     * @param weixinId 
	 *            微信号
     */
    /**
     * @param weixinId of AUR_D_AUTHINFO : 设置 微信号
     */
    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId == null ? null : weixinId.trim();
    }

    /**
     * @return 邮箱
     */
    /**
     * @return AUR_D_AUTHINFO.EMAIL : 返回 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            邮箱
     */
    /**
     * @param email of AUR_D_AUTHINFO : 设置 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 手机号
     */
    /**
     * @return AUR_D_AUTHINFO.PHONE_NUMBER : 返回 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            手机号
     */
    /**
     * @param phoneNumber of AUR_D_AUTHINFO : 设置 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return 账号状态<br>
	 *         00:正常<br>
	 *         01:待审核<br>
	 *         02:审核不通过<br>
	 *         03:锁定<br>
	 *         04:预注销<br>
	 *         05:正式注销
     */
    /**
     * @return AUR_D_AUTHINFO.STATUS : 返回 账号状态
00:正常
01:待审核
02:审核不通过
03:锁定
04:预注销
05:正式注销
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            账号状态<br>
	 *            00:正常<br>
	 *            01:待审核<br>
	 *            02:审核不通过<br>
	 *            03:锁定<br>
	 *            04:预注销<br>
	 *            05:正式注销
     */
    /**
     * @param status of AUR_D_AUTHINFO : 设置 账号状态
00:正常
01:待审核
02:审核不通过
03:锁定
04:预注销
05:正式注销
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 店铺ID
     */
    /**
     * @return AUR_D_AUTHINFO.STORE_ID : 返回 店铺ID
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * @param storeId 
	 *            店铺ID
     */
    /**
     * @param storeId of AUR_D_AUTHINFO : 设置 店铺ID
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * @return 店铺名称
     */
    /**
     * @return AUR_D_AUTHINFO.STORE_NAME : 返回 店铺名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName 
	 *            店铺名称
     */
    /**
     * @param storeName of AUR_D_AUTHINFO : 设置 店铺名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }
}