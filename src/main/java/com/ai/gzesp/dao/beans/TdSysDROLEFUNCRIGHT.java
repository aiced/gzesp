package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限关系表
 */
/**
 * @ClassName: TdSysDROLEFUNCRIGHT
* @Description: SYS_D_ROLE_FUNCRIGHT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDROLEFUNCRIGHT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.ROLE_ID :null
     */
    private Integer roleId;

    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.RIGHT_CODE :null
     */
    private String rightCode;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.UPDATE_TIME :null
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_ROLE_FUNCRIGHT.VALUES2 :null
     */
    private String values2;

    /**
     * @return SYS_D_ROLE_FUNCRIGHT.ROLE_ID : 返回 null
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId of SYS_D_ROLE_FUNCRIGHT : 设置 null
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return SYS_D_ROLE_FUNCRIGHT.RIGHT_CODE : 返回 null
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * @param rightCode of SYS_D_ROLE_FUNCRIGHT : 设置 null
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_D_ROLE_FUNCRIGHT.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_D_ROLE_FUNCRIGHT : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return SYS_D_ROLE_FUNCRIGHT.UPDATE_TIME : 返回 null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of SYS_D_ROLE_FUNCRIGHT : 设置 null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_ROLE_FUNCRIGHT.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_ROLE_FUNCRIGHT : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_ROLE_FUNCRIGHT.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_ROLE_FUNCRIGHT : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}