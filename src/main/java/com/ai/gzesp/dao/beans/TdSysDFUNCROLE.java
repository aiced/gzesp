package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 */
/**
 * @ClassName: TdSysDFUNCROLE
* @Description: SYS_D_FUNCROLE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDFUNCROLE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    /**
     * @Fields SYS_D_FUNCROLE.ROLE_ID :角色编码
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    /**
     * @Fields SYS_D_FUNCROLE.ROLE_NAME :角色名称
     */
    private String roleName;

    /**
     * @Fields SYS_D_FUNCROLE.MERCHANT_ID :null
     */
    private Integer merchantId;

    /**
     * 角色说明
     */
    /**
     * @Fields SYS_D_FUNCROLE.ROLE_DESC :角色说明
     */
    private String roleDesc;

    /**
     * 角色状态：有效1 ，无效0
     */
    /**
     * @Fields SYS_D_FUNCROLE.ROLE_STATE :角色状态：有效1 ，无效0
     */
    private String roleState;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_D_FUNCROLE.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * 更新时间
     */
    /**
     * @Fields SYS_D_FUNCROLE.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * @Fields SYS_D_FUNCROLE.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_FUNCROLE.VALUES2 :null
     */
    private String values2;

    /**
     * @return 角色编码
     */
    /**
     * @return SYS_D_FUNCROLE.ROLE_ID : 返回 角色编码
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId 
	 *            角色编码
     */
    /**
     * @param roleId of SYS_D_FUNCROLE : 设置 角色编码
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return 角色名称
     */
    /**
     * @return SYS_D_FUNCROLE.ROLE_NAME : 返回 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName 
	 *            角色名称
     */
    /**
     * @param roleName of SYS_D_FUNCROLE : 设置 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * @return SYS_D_FUNCROLE.MERCHANT_ID : 返回 null
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId of SYS_D_FUNCROLE : 设置 null
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 角色说明
     */
    /**
     * @return SYS_D_FUNCROLE.ROLE_DESC : 返回 角色说明
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc 
	 *            角色说明
     */
    /**
     * @param roleDesc of SYS_D_FUNCROLE : 设置 角色说明
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * @return 角色状态：有效1 ，无效0
     */
    /**
     * @return SYS_D_FUNCROLE.ROLE_STATE : 返回 角色状态：有效1 ，无效0
     */
    public String getRoleState() {
        return roleState;
    }

    /**
     * @param roleState 
	 *            角色状态：有效1 ，无效0
     */
    /**
     * @param roleState of SYS_D_FUNCROLE : 设置 角色状态：有效1 ，无效0
     */
    public void setRoleState(String roleState) {
        this.roleState = roleState == null ? null : roleState.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_D_FUNCROLE.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_D_FUNCROLE : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return 更新时间
     */
    /**
     * @return SYS_D_FUNCROLE.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of SYS_D_FUNCROLE : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_D_FUNCROLE.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_FUNCROLE : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_FUNCROLE.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_FUNCROLE : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}