package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 员工权限关系表
 */
/**
 * @ClassName: TdSysDSTAFFFUNCRIGHT
* @Description: SYS_D_STAFF_FUNCRIGHT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDSTAFFFUNCRIGHT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 员工ID
     */
    /**
     * @Fields SYS_D_STAFF_FUNCRIGHT.STAFF_ID :员工ID
     */
    private Integer staffId;

    /**
     * 权限编码
     */
    /**
     * @Fields SYS_D_STAFF_FUNCRIGHT.RIGHT_CODE :权限编码
     */
    private String rightCode;

    /**
     * 菜单ID
     */
    /**
     * @Fields SYS_D_STAFF_FUNCRIGHT.MENU_ID :菜单ID
     */
    private String menuId;

    /**
     * @Fields SYS_D_STAFF_FUNCRIGHT.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_D_STAFF_FUNCRIGHT.VALUES2 :null
     */
    private String values2;

    /**
     * @return 员工ID
     */
    /**
     * @return SYS_D_STAFF_FUNCRIGHT.STAFF_ID : 返回 员工ID
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 
	 *            员工ID
     */
    /**
     * @param staffId of SYS_D_STAFF_FUNCRIGHT : 设置 员工ID
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return 权限编码
     */
    /**
     * @return SYS_D_STAFF_FUNCRIGHT.RIGHT_CODE : 返回 权限编码
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * @param rightCode 
	 *            权限编码
     */
    /**
     * @param rightCode of SYS_D_STAFF_FUNCRIGHT : 设置 权限编码
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    /**
     * @return 菜单ID
     */
    /**
     * @return SYS_D_STAFF_FUNCRIGHT.MENU_ID : 返回 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId 
	 *            菜单ID
     */
    /**
     * @param menuId of SYS_D_STAFF_FUNCRIGHT : 设置 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * @return SYS_D_STAFF_FUNCRIGHT.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_D_STAFF_FUNCRIGHT : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_D_STAFF_FUNCRIGHT.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_D_STAFF_FUNCRIGHT : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}