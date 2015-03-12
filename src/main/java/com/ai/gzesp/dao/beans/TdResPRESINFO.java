package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 物品信息
 */
/**
 * @ClassName: TdResPRESINFO
* @Description: RES_P_RESINFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdResPRESINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 物品标识
     */
    /**
     * @Fields RES_P_RESINFO.RES_ID :物品标识
     */
    private Long resId;

    /**
     * 物品名称
     */
    /**
     * @Fields RES_P_RESINFO.RES_NAME :物品名称
     */
    private String resName;

    /**
     * 物品类别编码
     */
    /**
     * @Fields RES_P_RESINFO.RESTYPE_CODE :物品类别编码
     */
    private String restypeCode;

    /**
     * 创建人
     */
    /**
     * @Fields RES_P_RESINFO.CREATE_STAFF_ID :创建人
     */
    private String createStaffId;

    /**
     * 创建时间
     */
    /**
     * @Fields RES_P_RESINFO.CREATE_TIME :创建时间
     */
    private Date createTime;

    /**
     * 审核状态<br>
	 * 1－已审核<br>
	 * 
     */
    /**
     * @Fields RES_P_RESINFO.VERIFY_TAG :审核状态
1－已审核

     */
    private String verifyTag;

    /**
     * 审核人
     */
    /**
     * @Fields RES_P_RESINFO.VERIFY_STAFF_ID :审核人
     */
    private String verifyStaffId;

    /**
     * 审核时间
     */
    /**
     * @Fields RES_P_RESINFO.VERIFY_TIME :审核时间
     */
    private Date verifyTime;

    /**
     * 预留字段1
     */
    /**
     * @Fields RES_P_RESINFO.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields RES_P_RESINFO.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 物品标识
     */
    /**
     * @return RES_P_RESINFO.RES_ID : 返回 物品标识
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 
	 *            物品标识
     */
    /**
     * @param resId of RES_P_RESINFO : 设置 物品标识
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 物品名称
     */
    /**
     * @return RES_P_RESINFO.RES_NAME : 返回 物品名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * @param resName 
	 *            物品名称
     */
    /**
     * @param resName of RES_P_RESINFO : 设置 物品名称
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * @return 物品类别编码
     */
    /**
     * @return RES_P_RESINFO.RESTYPE_CODE : 返回 物品类别编码
     */
    public String getRestypeCode() {
        return restypeCode;
    }

    /**
     * @param restypeCode 
	 *            物品类别编码
     */
    /**
     * @param restypeCode of RES_P_RESINFO : 设置 物品类别编码
     */
    public void setRestypeCode(String restypeCode) {
        this.restypeCode = restypeCode == null ? null : restypeCode.trim();
    }

    /**
     * @return 创建人
     */
    /**
     * @return RES_P_RESINFO.CREATE_STAFF_ID : 返回 创建人
     */
    public String getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId 
	 *            创建人
     */
    /**
     * @param createStaffId of RES_P_RESINFO : 设置 创建人
     */
    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    /**
     * @return 创建时间
     */
    /**
     * @return RES_P_RESINFO.CREATE_TIME : 返回 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            创建时间
     */
    /**
     * @param createTime of RES_P_RESINFO : 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 审核状态<br>
	 *         1－已审核<br>
	 *         
     */
    /**
     * @return RES_P_RESINFO.VERIFY_TAG : 返回 审核状态
1－已审核

     */
    public String getVerifyTag() {
        return verifyTag;
    }

    /**
     * @param verifyTag 
	 *            审核状态<br>
	 *            1－已审核<br>
	 *            
     */
    /**
     * @param verifyTag of RES_P_RESINFO : 设置 审核状态
1－已审核

     */
    public void setVerifyTag(String verifyTag) {
        this.verifyTag = verifyTag == null ? null : verifyTag.trim();
    }

    /**
     * @return 审核人
     */
    /**
     * @return RES_P_RESINFO.VERIFY_STAFF_ID : 返回 审核人
     */
    public String getVerifyStaffId() {
        return verifyStaffId;
    }

    /**
     * @param verifyStaffId 
	 *            审核人
     */
    /**
     * @param verifyStaffId of RES_P_RESINFO : 设置 审核人
     */
    public void setVerifyStaffId(String verifyStaffId) {
        this.verifyStaffId = verifyStaffId == null ? null : verifyStaffId.trim();
    }

    /**
     * @return 审核时间
     */
    /**
     * @return RES_P_RESINFO.VERIFY_TIME : 返回 审核时间
     */
    public Date getVerifyTime() {
        return verifyTime;
    }

    /**
     * @param verifyTime 
	 *            审核时间
     */
    /**
     * @param verifyTime of RES_P_RESINFO : 设置 审核时间
     */
    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return RES_P_RESINFO.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of RES_P_RESINFO : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return RES_P_RESINFO.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of RES_P_RESINFO : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}