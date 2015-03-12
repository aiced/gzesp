package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdSysDSTAFFBUSIAREARES
* @Description: SYS_D_STAFF_BUSIAREA_RES表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTAFFBUSIAREARES implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 员工标识
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.STAFF_ID :员工标识
     */
    private Integer staffId;

    /**
     * 业务区域编码
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_CODE :业务区域编码
     */
    private String busiareaCode;

    /**
     * 业务区域名称
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_NAME :业务区域名称
     */
    private String busiareaName;

    /**
     * 业务区域类型，1、省份，2、地市，3、区县
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_TYPE :业务区域类型，1、省份，2、地市，3、区县
     */
    private String busiareaType;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * 更新时间
     */
    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_STAFF_BUSIAREA_RES.VALUES2 :null
     */
    private String values2;

    /**
     * @return 员工标识
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.STAFF_ID : 返回 员工标识
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 
	 *            员工标识
     */
    /**
     * @param staffId of SYS_D_STAFF_BUSIAREA_RES : 设置 员工标识
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return 业务区域编码
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_CODE : 返回 业务区域编码
     */
    public String getBusiareaCode() {
        return busiareaCode;
    }

    /**
     * @param busiareaCode 
	 *            业务区域编码
     */
    /**
     * @param busiareaCode of SYS_D_STAFF_BUSIAREA_RES : 设置 业务区域编码
     */
    public void setBusiareaCode(String busiareaCode) {
        this.busiareaCode = busiareaCode == null ? null : busiareaCode.trim();
    }

    /**
     * @return 业务区域名称
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_NAME : 返回 业务区域名称
     */
    public String getBusiareaName() {
        return busiareaName;
    }

    /**
     * @param busiareaName 
	 *            业务区域名称
     */
    /**
     * @param busiareaName of SYS_D_STAFF_BUSIAREA_RES : 设置 业务区域名称
     */
    public void setBusiareaName(String busiareaName) {
        this.busiareaName = busiareaName == null ? null : busiareaName.trim();
    }

    /**
     * @return 业务区域类型，1、省份，2、地市，3、区县
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.BUSIAREA_TYPE : 返回 业务区域类型，1、省份，2、地市，3、区县
     */
    public String getBusiareaType() {
        return busiareaType;
    }

    /**
     * @param busiareaType 
	 *            业务区域类型，1、省份，2、地市，3、区县
     */
    /**
     * @param busiareaType of SYS_D_STAFF_BUSIAREA_RES : 设置 业务区域类型，1、省份，2、地市，3、区县
     */
    public void setBusiareaType(String busiareaType) {
        this.busiareaType = busiareaType == null ? null : busiareaType.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_D_STAFF_BUSIAREA_RES : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return 更新时间
     */
    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of SYS_D_STAFF_BUSIAREA_RES : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_STAFF_BUSIAREA_RES : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_STAFF_BUSIAREA_RES.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_STAFF_BUSIAREA_RES : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}