package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 系统菜单表
 */
/**
 * @ClassName: TdSysPMENU
* @Description: SYS_P_MENU表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPMENU implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    /**
     * @Fields SYS_P_MENU.MENU_ID :菜单ID
     */
    private String menuId;

    /**
     * 上级菜单编码
     */
    /**
     * @Fields SYS_P_MENU.PARENT_MENU_ID :上级菜单编码
     */
    private String parentMenuId;

    /**
     * 权限编码
     */
    /**
     * @Fields SYS_P_MENU.RIGHT_CODE :权限编码
     */
    private String rightCode;

    /**
     * 菜单名称
     */
    /**
     * @Fields SYS_P_MENU.MENU_NAME :菜单名称
     */
    private String menuName;

    /**
     * 菜单 URL
     */
    /**
     * @Fields SYS_P_MENU.MENU_URL :菜单 URL
     */
    private String menuUrl;

    /**
     * 菜单排序
     */
    /**
     * @Fields SYS_P_MENU.MENU_SORT :菜单排序
     */
    private Short menuSort;

    /**
     * 菜单编码
     */
    /**
     * @Fields SYS_P_MENU.MENU_CODE :菜单编码
     */
    private String menuCode;

    /**
     * 菜单链接target属性
     */
    /**
     * @Fields SYS_P_MENU.TARGET_ATTR :菜单链接target属性
     */
    private String targetAttr;

    /**
     * 签名标记 0:不需要签名(默认)  1:需要签名
     */
    /**
     * @Fields SYS_P_MENU.AUTHKEY_TAG :签名标记 0:不需要签名(默认)  1:需要签名
     */
    private String authkeyTag;

    /**
     * 菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    /**
     * @Fields SYS_P_MENU.PROJECT_CODE :菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    private String projectCode;

    /**
     * 系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    /**
     * @Fields SYS_P_MENU.PROJECT_TYPE :系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    private String projectType;

    /**
     * @return 菜单ID
     */
    /**
     * @return SYS_P_MENU.MENU_ID : 返回 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId 
	 *            菜单ID
     */
    /**
     * @param menuId of SYS_P_MENU : 设置 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * @return 上级菜单编码
     */
    /**
     * @return SYS_P_MENU.PARENT_MENU_ID : 返回 上级菜单编码
     */
    public String getParentMenuId() {
        return parentMenuId;
    }

    /**
     * @param parentMenuId 
	 *            上级菜单编码
     */
    /**
     * @param parentMenuId of SYS_P_MENU : 设置 上级菜单编码
     */
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId == null ? null : parentMenuId.trim();
    }

    /**
     * @return 权限编码
     */
    /**
     * @return SYS_P_MENU.RIGHT_CODE : 返回 权限编码
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * @param rightCode 
	 *            权限编码
     */
    /**
     * @param rightCode of SYS_P_MENU : 设置 权限编码
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    /**
     * @return 菜单名称
     */
    /**
     * @return SYS_P_MENU.MENU_NAME : 返回 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName 
	 *            菜单名称
     */
    /**
     * @param menuName of SYS_P_MENU : 设置 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * @return 菜单 URL
     */
    /**
     * @return SYS_P_MENU.MENU_URL : 返回 菜单 URL
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl 
	 *            菜单 URL
     */
    /**
     * @param menuUrl of SYS_P_MENU : 设置 菜单 URL
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * @return 菜单排序
     */
    /**
     * @return SYS_P_MENU.MENU_SORT : 返回 菜单排序
     */
    public Short getMenuSort() {
        return menuSort;
    }

    /**
     * @param menuSort 
	 *            菜单排序
     */
    /**
     * @param menuSort of SYS_P_MENU : 设置 菜单排序
     */
    public void setMenuSort(Short menuSort) {
        this.menuSort = menuSort;
    }

    /**
     * @return 菜单编码
     */
    /**
     * @return SYS_P_MENU.MENU_CODE : 返回 菜单编码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode 
	 *            菜单编码
     */
    /**
     * @param menuCode of SYS_P_MENU : 设置 菜单编码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    /**
     * @return 菜单链接target属性
     */
    /**
     * @return SYS_P_MENU.TARGET_ATTR : 返回 菜单链接target属性
     */
    public String getTargetAttr() {
        return targetAttr;
    }

    /**
     * @param targetAttr 
	 *            菜单链接target属性
     */
    /**
     * @param targetAttr of SYS_P_MENU : 设置 菜单链接target属性
     */
    public void setTargetAttr(String targetAttr) {
        this.targetAttr = targetAttr == null ? null : targetAttr.trim();
    }

    /**
     * @return 签名标记 0:不需要签名(默认)  1:需要签名
     */
    /**
     * @return SYS_P_MENU.AUTHKEY_TAG : 返回 签名标记 0:不需要签名(默认)  1:需要签名
     */
    public String getAuthkeyTag() {
        return authkeyTag;
    }

    /**
     * @param authkeyTag 
	 *            签名标记 0:不需要签名(默认)  1:需要签名
     */
    /**
     * @param authkeyTag of SYS_P_MENU : 设置 签名标记 0:不需要签名(默认)  1:需要签名
     */
    public void setAuthkeyTag(String authkeyTag) {
        this.authkeyTag = authkeyTag == null ? null : authkeyTag.trim();
    }

    /**
     * @return 菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    /**
     * @return SYS_P_MENU.PROJECT_CODE : 返回 菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * @param projectCode 
	 *            菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    /**
     * @param projectCode of SYS_P_MENU : 设置 菜单所属工程编码 ADMIN:后台 REPORT:报表 ORDERMGR:订单管理
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    /**
     * @return 系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    /**
     * @return SYS_P_MENU.PROJECT_TYPE : 返回 系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * @param projectType 
	 *            系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    /**
     * @param projectType of SYS_P_MENU : 设置 系统类型 1商城（商城、报表） 2外围（B2B，116114）
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }
}