package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdSysDSTFGRMBR
* @Description: SYS_D_STFGR_MBR表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTFGRMBR extends TdSysDSTFGRMBRKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_D_STFGR_MBR.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * @Fields SYS_D_STFGR_MBR.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_STFGR_MBR.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_STFGR_MBR.VALUES2 :null
     */
    private String values2;

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_D_STFGR_MBR.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_D_STFGR_MBR : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return SYS_D_STFGR_MBR.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of SYS_D_STFGR_MBR : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_STFGR_MBR.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_STFGR_MBR : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_STFGR_MBR.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_STFGR_MBR : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}