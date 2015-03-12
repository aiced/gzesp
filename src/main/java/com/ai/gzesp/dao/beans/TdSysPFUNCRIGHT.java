package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 */
/**
 * @ClassName: TdSysPFUNCRIGHT
* @Description: SYS_P_FUNCRIGHT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPFUNCRIGHT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限编码
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.RIGHT_CODE :权限编码
     */
    private String rightCode;

    /**
     * 权限名称
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.RIGHT_NAME :权限名称
     */
    private String rightName;

    /**
     * 权限说明
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.RIGHT_DESC :权限说明
     */
    private String rightDesc;

    /**
     * 权限状态：0无效，1有效
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.RIGHT_STATE :权限状态：0无效，1有效
     */
    private String rightState;

    /**
     * 更新员工
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.UPDATE_STAFF :更新员工
     */
    private Integer updateStaff;

    /**
     * 更新时间
     */
    /**
     * @Fields SYS_P_FUNCRIGHT.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * @Fields SYS_P_FUNCRIGHT.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields SYS_P_FUNCRIGHT.VALUES2 :null
     */
    private String values2;

    /**
     * @return 权限编码
     */
    /**
     * @return SYS_P_FUNCRIGHT.RIGHT_CODE : 返回 权限编码
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * @param rightCode 
	 *            权限编码
     */
    /**
     * @param rightCode of SYS_P_FUNCRIGHT : 设置 权限编码
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    /**
     * @return 权限名称
     */
    /**
     * @return SYS_P_FUNCRIGHT.RIGHT_NAME : 返回 权限名称
     */
    public String getRightName() {
        return rightName;
    }

    /**
     * @param rightName 
	 *            权限名称
     */
    /**
     * @param rightName of SYS_P_FUNCRIGHT : 设置 权限名称
     */
    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    /**
     * @return 权限说明
     */
    /**
     * @return SYS_P_FUNCRIGHT.RIGHT_DESC : 返回 权限说明
     */
    public String getRightDesc() {
        return rightDesc;
    }

    /**
     * @param rightDesc 
	 *            权限说明
     */
    /**
     * @param rightDesc of SYS_P_FUNCRIGHT : 设置 权限说明
     */
    public void setRightDesc(String rightDesc) {
        this.rightDesc = rightDesc == null ? null : rightDesc.trim();
    }

    /**
     * @return 权限状态：0无效，1有效
     */
    /**
     * @return SYS_P_FUNCRIGHT.RIGHT_STATE : 返回 权限状态：0无效，1有效
     */
    public String getRightState() {
        return rightState;
    }

    /**
     * @param rightState 
	 *            权限状态：0无效，1有效
     */
    /**
     * @param rightState of SYS_P_FUNCRIGHT : 设置 权限状态：0无效，1有效
     */
    public void setRightState(String rightState) {
        this.rightState = rightState == null ? null : rightState.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return SYS_P_FUNCRIGHT.UPDATE_STAFF : 返回 更新员工
     */
    public Integer getUpdateStaff() {
        return updateStaff;
    }

    /**
     * @param updateStaff 
	 *            更新员工
     */
    /**
     * @param updateStaff of SYS_P_FUNCRIGHT : 设置 更新员工
     */
    public void setUpdateStaff(Integer updateStaff) {
        this.updateStaff = updateStaff;
    }

    /**
     * @return 更新时间
     */
    /**
     * @return SYS_P_FUNCRIGHT.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of SYS_P_FUNCRIGHT : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return SYS_P_FUNCRIGHT.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of SYS_P_FUNCRIGHT : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return SYS_P_FUNCRIGHT.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of SYS_P_FUNCRIGHT : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}