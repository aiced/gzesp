package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品佣金规则关联表
 */
/**
 * @ClassName: TdCmsPGOODSRULE
* @Description: CMS_P_GOODS_RULE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdCmsPGOODSRULE extends TdCmsPGOODSRULEKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields CMS_P_GOODS_RULE.ADD_DATE :null
     */
    private Date addDate;

    /**
     * 起始时间
     */
    /**
     * @Fields CMS_P_GOODS_RULE.BEGIN_DATE :起始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    /**
     * @Fields CMS_P_GOODS_RULE.END_DATE :结束时间
     */
    private Date endDate;

    /**
     * @Fields CMS_P_GOODS_RULE.STAFF_ID :null
     */
    private Integer staffId;

    /**
     * @return CMS_P_GOODS_RULE.ADD_DATE : 返回 null
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * @param addDate of CMS_P_GOODS_RULE : 设置 null
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * @return 起始时间
     */
    /**
     * @return CMS_P_GOODS_RULE.BEGIN_DATE : 返回 起始时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * @param beginDate 
	 *            起始时间
     */
    /**
     * @param beginDate of CMS_P_GOODS_RULE : 设置 起始时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * @return 结束时间
     */
    /**
     * @return CMS_P_GOODS_RULE.END_DATE : 返回 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate 
	 *            结束时间
     */
    /**
     * @param endDate of CMS_P_GOODS_RULE : 设置 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return CMS_P_GOODS_RULE.STAFF_ID : 返回 null
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId of CMS_P_GOODS_RULE : 设置 null
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}