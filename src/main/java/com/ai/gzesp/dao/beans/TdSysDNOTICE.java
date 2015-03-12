package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告信息
 */
/**
 * @ClassName: TdSysDNOTICE
* @Description: SYS_D_NOTICE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysDNOTICE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields SYS_D_NOTICE.NOTICE_ID :商品标识
     */
    private Long noticeId;

    /**
     * 告知对象<br>
	 * 0 系统管理员<br>
	 * 1 能人<br>
	 * 2 客户
     */
    /**
     * @Fields SYS_D_NOTICE.NOTICE_TARGET :告知对象
0 系统管理员
1 能人
2 客户
     */
    private String noticeTarget;

    /**
     * 公告类型
     */
    /**
     * @Fields SYS_D_NOTICE.NOTICE_TYPE_ID :公告类型
     */
    private String noticeTypeId;

    /**
     * 标题
     */
    /**
     * @Fields SYS_D_NOTICE.DATA_TITLE :标题
     */
    private String dataTitle;

    /**
     * 内容
     */
    /**
     * @Fields SYS_D_NOTICE.CONTENT :内容
     */
    private String content;

    /**
     * 排序
     */
    /**
     * @Fields SYS_D_NOTICE.ORDER_SEQ :排序
     */
    private Short orderSeq;

    /**
     * 状态:<br>
	 * 0 失效，1 生效
     */
    /**
     * @Fields SYS_D_NOTICE.STATUS :状态:
0 失效，1 生效
     */
    private String status;

    /**
     * 更新时间
     */
    /**
     * @Fields SYS_D_NOTICE.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * 员工编码
     */
    /**
     * @Fields SYS_D_NOTICE.STAFF_ID :员工编码
     */
    private String staffId;

    /**
     * @return 商品标识
     */
    /**
     * @return SYS_D_NOTICE.NOTICE_ID : 返回 商品标识
     */
    public Long getNoticeId() {
        return noticeId;
    }

    /**
     * @param noticeId 
	 *            商品标识
     */
    /**
     * @param noticeId of SYS_D_NOTICE : 设置 商品标识
     */
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * @return 告知对象<br>
	 *         0 系统管理员<br>
	 *         1 能人<br>
	 *         2 客户
     */
    /**
     * @return SYS_D_NOTICE.NOTICE_TARGET : 返回 告知对象
0 系统管理员
1 能人
2 客户
     */
    public String getNoticeTarget() {
        return noticeTarget;
    }

    /**
     * @param noticeTarget 
	 *            告知对象<br>
	 *            0 系统管理员<br>
	 *            1 能人<br>
	 *            2 客户
     */
    /**
     * @param noticeTarget of SYS_D_NOTICE : 设置 告知对象
0 系统管理员
1 能人
2 客户
     */
    public void setNoticeTarget(String noticeTarget) {
        this.noticeTarget = noticeTarget == null ? null : noticeTarget.trim();
    }

    /**
     * @return 公告类型
     */
    /**
     * @return SYS_D_NOTICE.NOTICE_TYPE_ID : 返回 公告类型
     */
    public String getNoticeTypeId() {
        return noticeTypeId;
    }

    /**
     * @param noticeTypeId 
	 *            公告类型
     */
    /**
     * @param noticeTypeId of SYS_D_NOTICE : 设置 公告类型
     */
    public void setNoticeTypeId(String noticeTypeId) {
        this.noticeTypeId = noticeTypeId == null ? null : noticeTypeId.trim();
    }

    /**
     * @return 标题
     */
    /**
     * @return SYS_D_NOTICE.DATA_TITLE : 返回 标题
     */
    public String getDataTitle() {
        return dataTitle;
    }

    /**
     * @param dataTitle 
	 *            标题
     */
    /**
     * @param dataTitle of SYS_D_NOTICE : 设置 标题
     */
    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle == null ? null : dataTitle.trim();
    }

    /**
     * @return 内容
     */
    /**
     * @return SYS_D_NOTICE.CONTENT : 返回 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            内容
     */
    /**
     * @param content of SYS_D_NOTICE : 设置 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return 排序
     */
    /**
     * @return SYS_D_NOTICE.ORDER_SEQ : 返回 排序
     */
    public Short getOrderSeq() {
        return orderSeq;
    }

    /**
     * @param orderSeq 
	 *            排序
     */
    /**
     * @param orderSeq of SYS_D_NOTICE : 设置 排序
     */
    public void setOrderSeq(Short orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * @return 状态:<br>
	 *         0 失效，1 生效
     */
    /**
     * @return SYS_D_NOTICE.STATUS : 返回 状态:
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
     * @param status of SYS_D_NOTICE : 设置 状态:
0 失效，1 生效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 更新时间
     */
    /**
     * @return SYS_D_NOTICE.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of SYS_D_NOTICE : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 员工编码
     */
    /**
     * @return SYS_D_NOTICE.STAFF_ID : 返回 员工编码
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 
	 *            员工编码
     */
    /**
     * @param staffId of SYS_D_NOTICE : 设置 员工编码
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
}