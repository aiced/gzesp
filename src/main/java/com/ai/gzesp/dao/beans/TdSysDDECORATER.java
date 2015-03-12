package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 页面装修表
 */
/**
 * @ClassName: TdSysDDECORATER
* @Description: SYS_D_DECORATER表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDDECORATER implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面类型
     */
    /**
     * @Fields SYS_D_DECORATER.TYPE_ID :页面类型
     */
    private String typeId;

    /**
     * 参数编码
     */
    /**
     * @Fields SYS_D_DECORATER.DATA_KEY :参数编码
     */
    private String dataKey;

    /**
     * 标题
     */
    /**
     * @Fields SYS_D_DECORATER.DATA_TITLE :标题
     */
    private String dataTitle;

    /**
     * 内容
     */
    /**
     * @Fields SYS_D_DECORATER.CONTENT :内容
     */
    private String content;

    /**
     * 排序
     */
    /**
     * @Fields SYS_D_DECORATER.ORDER_SEQ :排序
     */
    private BigDecimal orderSeq;

    /**
     * 状态:<br>
	 * 0 失效，1 生效
     */
    /**
     * @Fields SYS_D_DECORATER.STATUS :状态:
0 失效，1 生效
     */
    private String status;

    /**
     * 更新时间
     */
    /**
     * @Fields SYS_D_DECORATER.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * 员工编码
     */
    /**
     * @Fields SYS_D_DECORATER.STAFF_ID :员工编码
     */
    private String staffId;

    /**
     * @return 页面类型
     */
    /**
     * @return SYS_D_DECORATER.TYPE_ID : 返回 页面类型
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId 
	 *            页面类型
     */
    /**
     * @param typeId of SYS_D_DECORATER : 设置 页面类型
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * @return 参数编码
     */
    /**
     * @return SYS_D_DECORATER.DATA_KEY : 返回 参数编码
     */
    public String getDataKey() {
        return dataKey;
    }

    /**
     * @param dataKey 
	 *            参数编码
     */
    /**
     * @param dataKey of SYS_D_DECORATER : 设置 参数编码
     */
    public void setDataKey(String dataKey) {
        this.dataKey = dataKey == null ? null : dataKey.trim();
    }

    /**
     * @return 标题
     */
    /**
     * @return SYS_D_DECORATER.DATA_TITLE : 返回 标题
     */
    public String getDataTitle() {
        return dataTitle;
    }

    /**
     * @param dataTitle 
	 *            标题
     */
    /**
     * @param dataTitle of SYS_D_DECORATER : 设置 标题
     */
    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle == null ? null : dataTitle.trim();
    }

    /**
     * @return 内容
     */
    /**
     * @return SYS_D_DECORATER.CONTENT : 返回 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            内容
     */
    /**
     * @param content of SYS_D_DECORATER : 设置 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return 排序
     */
    /**
     * @return SYS_D_DECORATER.ORDER_SEQ : 返回 排序
     */
    public BigDecimal getOrderSeq() {
        return orderSeq;
    }

    /**
     * @param orderSeq 
	 *            排序
     */
    /**
     * @param orderSeq of SYS_D_DECORATER : 设置 排序
     */
    public void setOrderSeq(BigDecimal orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * @return 状态:<br>
	 *         0 失效，1 生效
     */
    /**
     * @return SYS_D_DECORATER.STATUS : 返回 状态:
0 失效，1 生效
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态:<br>
	 *            0 失效，1 生效
     */
    /**
     * @param status of SYS_D_DECORATER : 设置 状态:
0 失效，1 生效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 更新时间
     */
    /**
     * @return SYS_D_DECORATER.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of SYS_D_DECORATER : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 员工编码
     */
    /**
     * @return SYS_D_DECORATER.STAFF_ID : 返回 员工编码
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 
	 *            员工编码
     */
    /**
     * @param staffId of SYS_D_DECORATER : 设置 员工编码
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
}