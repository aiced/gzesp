package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单佣金状态信息表
 */
/**
 * @ClassName: TdOrdDCMSSTATE
* @Description: ORD_D_CMSSTATE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDCMSSTATE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields ORD_D_CMSSTATE.ORDER_ID :null
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_CMSSTATE.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 佣金类型<br>
	 * 0：比例
     */
    /**
     * @Fields ORD_D_CMSSTATE.CMS_TYPE :佣金类型
0：比例
     */
    private String cmsType;

    /**
     * 佣金状态<br>
	 * 00：未激活<br>
	 * 01：结算中<br>
	 * 02：已到帐<br>
	 * 03：已退货<br>
	 * 04：已失效
     */
    /**
     * @Fields ORD_D_CMSSTATE.CMS_STATE :佣金状态
00：未激活
01：结算中
02：已到帐
03：已退货
04：已失效
     */
    private String cmsState;

    /**
     * 添加时间
     */
    /**
     * @Fields ORD_D_CMSSTATE.ADD_TIME :添加时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    /**
     * @Fields ORD_D_CMSSTATE.UPDATE_TIME :修改时间
     */
    private Date updateTime;

    /**
     * @return ORD_D_CMSSTATE.ORDER_ID : 返回 null
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId of ORD_D_CMSSTATE : 设置 null
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_CMSSTATE.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_CMSSTATE : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 佣金类型<br>
	 *         0：比例
     */
    /**
     * @return ORD_D_CMSSTATE.CMS_TYPE : 返回 佣金类型
0：比例
     */
    public String getCmsType() {
        return cmsType;
    }

    /**
     * @param cmsType 
	 *            佣金类型<br>
	 *            0：比例
     */
    /**
     * @param cmsType of ORD_D_CMSSTATE : 设置 佣金类型
0：比例
     */
    public void setCmsType(String cmsType) {
        this.cmsType = cmsType == null ? null : cmsType.trim();
    }

    /**
     * @return 佣金状态<br>
	 *         00：未激活<br>
	 *         01：结算中<br>
	 *         02：已到帐<br>
	 *         03：已退货<br>
	 *         04：已失效
     */
    /**
     * @return ORD_D_CMSSTATE.CMS_STATE : 返回 佣金状态
00：未激活
01：结算中
02：已到帐
03：已退货
04：已失效
     */
    public String getCmsState() {
        return cmsState;
    }

    /**
     * @param cmsState 
	 *            佣金状态<br>
	 *            00：未激活<br>
	 *            01：结算中<br>
	 *            02：已到帐<br>
	 *            03：已退货<br>
	 *            04：已失效
     */
    /**
     * @param cmsState of ORD_D_CMSSTATE : 设置 佣金状态
00：未激活
01：结算中
02：已到帐
03：已退货
04：已失效
     */
    public void setCmsState(String cmsState) {
        this.cmsState = cmsState == null ? null : cmsState.trim();
    }

    /**
     * @return 添加时间
     */
    /**
     * @return ORD_D_CMSSTATE.ADD_TIME : 返回 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime 
	 *            添加时间
     */
    /**
     * @param addTime of ORD_D_CMSSTATE : 设置 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * @return 修改时间
     */
    /**
     * @return ORD_D_CMSSTATE.UPDATE_TIME : 返回 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            修改时间
     */
    /**
     * @param updateTime of ORD_D_CMSSTATE : 设置 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}