package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录我的店铺访问量
 */
/**
 * @ClassName: TdAurDCOUNT
* @Description: AUR_D_COUNT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdAurDCOUNT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields AUR_D_COUNT.ID :null
     */
    private Long id;

    /**
     * @Fields AUR_D_COUNT.STORE_ID :null
     */
    private String storeId;

    /**
     * @Fields AUR_D_COUNT.USER_ID :null
     */
    private String userId;

    /**
     * @Fields AUR_D_COUNT.VISIT_DAY :null
     */
    private Long visitDay;

    /**
     * @Fields AUR_D_COUNT.VISIT_MONTH :null
     */
    private Long visitMonth;

    /**
     * @Fields AUR_D_COUNT.VISIT_TOTAL :null
     */
    private Long visitTotal;

    /**
     * @Fields AUR_D_COUNT.VERSION_NO :null
     */
    private Long versionNo;

    /**
     * @Fields AUR_D_COUNT.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @return AUR_D_COUNT.ID : 返回 null
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id of AUR_D_COUNT : 设置 null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return AUR_D_COUNT.STORE_ID : 返回 null
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * @param storeId of AUR_D_COUNT : 设置 null
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * @return AUR_D_COUNT.USER_ID : 返回 null
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId of AUR_D_COUNT : 设置 null
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return AUR_D_COUNT.VISIT_DAY : 返回 null
     */
    public Long getVisitDay() {
        return visitDay;
    }

    /**
     * @param visitDay of AUR_D_COUNT : 设置 null
     */
    public void setVisitDay(Long visitDay) {
        this.visitDay = visitDay;
    }

    /**
     * @return AUR_D_COUNT.VISIT_MONTH : 返回 null
     */
    public Long getVisitMonth() {
        return visitMonth;
    }

    /**
     * @param visitMonth of AUR_D_COUNT : 设置 null
     */
    public void setVisitMonth(Long visitMonth) {
        this.visitMonth = visitMonth;
    }

    /**
     * @return AUR_D_COUNT.VISIT_TOTAL : 返回 null
     */
    public Long getVisitTotal() {
        return visitTotal;
    }

    /**
     * @param visitTotal of AUR_D_COUNT : 设置 null
     */
    public void setVisitTotal(Long visitTotal) {
        this.visitTotal = visitTotal;
    }

    /**
     * @return AUR_D_COUNT.VERSION_NO : 返回 null
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     * @param versionNo of AUR_D_COUNT : 设置 null
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * @return AUR_D_COUNT.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of AUR_D_COUNT : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}