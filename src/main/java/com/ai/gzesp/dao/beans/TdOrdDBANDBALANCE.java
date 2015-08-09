package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 宽带续约对账表
 */
/**
 * @ClassName: TdOrdDBANDBALANCE
* @Description: ORD_D_BANDBALANCE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDBANDBALANCE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * logid
     */
    /**
     * @Fields ORD_D_BANDBALANCE.LOG_ID :logid
     */
    private String logId;

    /**
     * 订单编号
     */
    /**
     * @Fields ORD_D_BANDBALANCE.ORDER_ID :订单编号
     */
    private String orderId;

    /**
     * 宽带账号
     */
    /**
     * @Fields ORD_D_BANDBALANCE.BANDNUMID :宽带账号
     */
    private String bandnumid;

    /**
     * 对账结果
     */
    /**
     * @Fields ORD_D_BANDBALANCE.RESULT :对账结果
     */
    private String result;

    /**
     * 创建时间
     */
    /**
     * @Fields ORD_D_BANDBALANCE.CREATETIME :创建时间
     */
    private Date createtime;

    /**
     * @return logid
     */
    /**
     * @return ORD_D_BANDBALANCE.LOG_ID : 返回 logid
     */
    public String getLogId() {
        return logId;
    }

    /**
     * @param logId 
	 *            logid
     */
    /**
     * @param logId of ORD_D_BANDBALANCE : 设置 logid
     */
    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    /**
     * @return 订单编号
     */
    /**
     * @return ORD_D_BANDBALANCE.ORDER_ID : 返回 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单编号
     */
    /**
     * @param orderId of ORD_D_BANDBALANCE : 设置 订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return 宽带账号
     */
    /**
     * @return ORD_D_BANDBALANCE.BANDNUMID : 返回 宽带账号
     */
    public String getBandnumid() {
        return bandnumid;
    }

    /**
     * @param bandnumid 
	 *            宽带账号
     */
    /**
     * @param bandnumid of ORD_D_BANDBALANCE : 设置 宽带账号
     */
    public void setBandnumid(String bandnumid) {
        this.bandnumid = bandnumid == null ? null : bandnumid.trim();
    }

    /**
     * @return 对账结果
     */
    /**
     * @return ORD_D_BANDBALANCE.RESULT : 返回 对账结果
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result 
	 *            对账结果
     */
    /**
     * @param result of ORD_D_BANDBALANCE : 设置 对账结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * @return 创建时间
     */
    /**
     * @return ORD_D_BANDBALANCE.CREATETIME : 返回 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime 
	 *            创建时间
     */
    /**
     * @param createtime of ORD_D_BANDBALANCE : 设置 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}