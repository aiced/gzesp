package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单佣金规则表
 */
/**
 * @ClassName: TdCmsPRULE
* @Description: CMS_P_RULE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdCmsPRULE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    /**
     * @Fields CMS_P_RULE.ID :ID
     */
    private Long id;

    /**
     * 佣金规则
     */
    /**
     * @Fields CMS_P_RULE.COMMISSION_RULE :佣金规则
     */
    private String commissionRule;

    /**
     * 0：失效<br>
	 * 1：生效
     */
    /**
     * @Fields CMS_P_RULE.STATUS :0：失效
1：生效
     */
    private String status;

    /**
     * @Fields CMS_P_RULE.ADD_DATE :null
     */
    private Date addDate;

    /**
     * @Fields CMS_P_RULE.STAFF_ID :null
     */
    private Integer staffId;

    /**
     * @return ID
     */
    /**
     * @return CMS_P_RULE.ID : 返回 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 
	 *            ID
     */
    /**
     * @param id of CMS_P_RULE : 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 佣金规则
     */
    /**
     * @return CMS_P_RULE.COMMISSION_RULE : 返回 佣金规则
     */
    public String getCommissionRule() {
        return commissionRule;
    }

    /**
     * @param commissionRule 
	 *            佣金规则
     */
    /**
     * @param commissionRule of CMS_P_RULE : 设置 佣金规则
     */
    public void setCommissionRule(String commissionRule) {
        this.commissionRule = commissionRule == null ? null : commissionRule.trim();
    }

    /**
     * @return 0：失效<br>
	 *         1：生效
     */
    /**
     * @return CMS_P_RULE.STATUS : 返回 0：失效
1：生效
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            0：失效<br>
	 *            1：生效
     */
    /**
     * @param status of CMS_P_RULE : 设置 0：失效
1：生效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return CMS_P_RULE.ADD_DATE : 返回 null
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * @param addDate of CMS_P_RULE : 设置 null
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * @return CMS_P_RULE.STAFF_ID : 返回 null
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId of CMS_P_RULE : 设置 null
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}