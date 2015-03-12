package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdSysDSTFGRP
* @Description: SYS_D_STFGRP表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTFGRP implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields SYS_D_STFGRP.STFGRP_ID :null
     */
    private Integer stfgrpId;

    /**
     * @Fields SYS_D_STFGRP.STFGRP_NAME :null
     */
    private String stfgrpName;

    /**
     * @Fields SYS_D_STFGRP.MERCHANT_ID :null
     */
    private Integer merchantId;

    /**
     * @Fields SYS_D_STFGRP.UPDATE_STAFF :null
     */
    private Integer updateStaff;

    /**
     * @Fields SYS_D_STFGRP.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_STFGRP.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_STFGRP.VALUES2 :null
     */
    private String values2;

    /**
     * 员工组描述
     */
    /**
     * @Fields SYS_D_STFGRP.STFGRP_DESC :员工组描述
     */
    private String stfgrpDesc;

    /**
     * 员工组状态
     */
    /**
     * @Fields SYS_D_STFGRP.STFGRP_STATE :员工组状态
     */
    private String stfgrpState;

    /**
     * @return SYS_D_STFGRP.STFGRP_ID : 返回 null
     */
    public Integer getStfgrpId() {
        return stfgrpId;
    }

    /**
     * @param stfgrpId of SYS_D_STFGRP : 设置 null
     */
    public void setStfgrpId(Integer stfgrpId) {
        this.stfgrpId = stfgrpId;
    }

    /**
     * @return SYS_D_STFGRP.STFGRP_NAME : 返回 null
     */
    public String getStfgrpName() {
        return stfgrpName;
    }

    /**
     * @param stfgrpName of SYS_D_STFGRP : 设置 null
     */
    public void setStfgrpName(String stfgrpName) {
        this.stfgrpName = stfgrpName == null ? null : stfgrpName.trim();
    }

    /**
     * @return SYS_D_STFGRP.MERCHANT_ID : 返回 null
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId of SYS_D_STFGRP : 设置 null
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return SYS_D_STFGRP.UPDATE_STAFF : 返回 null
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff of SYS_D_STFGRP : 设置 null
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return SYS_D_STFGRP.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of SYS_D_STFGRP : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_STFGRP.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_STFGRP : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_STFGRP.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_STFGRP : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 员工组描述
     */
    /**
     * @return SYS_D_STFGRP.STFGRP_DESC : 返回 员工组描述
     */
    public String getStfgrpDesc() {
        return stfgrpDesc;
    }

    /**
     * @param stfgrpDesc 
	 *            员工组描述
     */
    /**
     * @param stfgrpDesc of SYS_D_STFGRP : 设置 员工组描述
     */
    public void setStfgrpDesc(String stfgrpDesc) {
        this.stfgrpDesc = stfgrpDesc == null ? null : stfgrpDesc.trim();
    }

    /**
     * @return 员工组状态
     */
    /**
     * @return SYS_D_STFGRP.STFGRP_STATE : 返回 员工组状态
     */
    public String getStfgrpState() {
        return stfgrpState;
    }

    /**
     * @param stfgrpState 
	 *            员工组状态
     */
    /**
     * @param stfgrpState of SYS_D_STFGRP : 设置 员工组状态
     */
    public void setStfgrpState(String stfgrpState) {
        this.stfgrpState = stfgrpState == null ? null : stfgrpState.trim();
    }
}