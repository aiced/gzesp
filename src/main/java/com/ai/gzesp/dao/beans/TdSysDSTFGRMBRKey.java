package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdSysDSTFGRMBRKey
* @Description: SYS_D_STFGR_MBR表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTFGRMBRKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields SYS_D_STFGR_MBR.STAFF_ID :null
     */
    private Integer staffId;

    /**
     * @Fields SYS_D_STFGR_MBR.STFGRP_ID :null
     */
    private Integer stfgrpId;

    /**
     * @return SYS_D_STFGR_MBR.STAFF_ID : 返回 null
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId of SYS_D_STFGR_MBR : 设置 null
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return SYS_D_STFGR_MBR.STFGRP_ID : 返回 null
     */
    public Integer getStfgrpId() {
        return stfgrpId;
    }

    /**
     * @param stfgrpId of SYS_D_STFGR_MBR : 设置 null
     */
    public void setStfgrpId(Integer stfgrpId) {
        this.stfgrpId = stfgrpId;
    }
}