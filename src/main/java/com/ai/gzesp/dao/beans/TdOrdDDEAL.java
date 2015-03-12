package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 订单运营信息
 */
/**
 * @ClassName: TdOrdDDEAL
* @Description: ORD_D_DEAL表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDDEAL implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_D_DEAL.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_DEAL.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 能人编码
     */
    /**
     * @Fields ORD_D_DEAL.USER_ID :能人编码
     */
    private Long userId;

    /**
     * 能人名称
     */
    /**
     * @Fields ORD_D_DEAL.USER_NAME :能人名称
     */
    private String userName;

    /**
     * 发展人编码
     */
    /**
     * @Fields ORD_D_DEAL.DEVLOP_ID :发展人编码
     */
    private String devlopId;

    /**
     * 发展人名称
     */
    /**
     * @Fields ORD_D_DEAL.DEVLOP_NAME :发展人名称
     */
    private String devlopName;

    /**
     * SIMCARD
     */
    /**
     * @Fields ORD_D_DEAL.SIMCARD :SIMCARD
     */
    private String simcard;

    /**
     * 终端串号
     */
    /**
     * @Fields ORD_D_DEAL.TERM_ID :终端串号
     */
    private String termId;

    /**
     * 手机号
     */
    /**
     * @Fields ORD_D_DEAL.PHONE_NUMBER :手机号
     */
    private String phoneNumber;

    /**
     * IMSI
     */
    /**
     * @Fields ORD_D_DEAL.IMSI :IMSI
     */
    private String imsi;

    /**
     * 发票抬头
     */
    /**
     * @Fields ORD_D_DEAL.INVOCE_TITLE :发票抬头
     */
    private String invoceTitle;

    /**
     * 发票内容
     */
    /**
     * @Fields ORD_D_DEAL.INVOCE_CONTENT :发票内容
     */
    private String invoceContent;

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_D_DEAL.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_D_DEAL : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_DEAL.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_DEAL : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 能人编码
     */
    /**
     * @return ORD_D_DEAL.USER_ID : 返回 能人编码
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人编码
     */
    /**
     * @param userId of ORD_D_DEAL : 设置 能人编码
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return 能人名称
     */
    /**
     * @return ORD_D_DEAL.USER_NAME : 返回 能人名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 
	 *            能人名称
     */
    /**
     * @param userName of ORD_D_DEAL : 设置 能人名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return 发展人编码
     */
    /**
     * @return ORD_D_DEAL.DEVLOP_ID : 返回 发展人编码
     */
    public String getDevlopId() {
        return devlopId;
    }

    /**
     * @param devlopId 
	 *            发展人编码
     */
    /**
     * @param devlopId of ORD_D_DEAL : 设置 发展人编码
     */
    public void setDevlopId(String devlopId) {
        this.devlopId = devlopId == null ? null : devlopId.trim();
    }

    /**
     * @return 发展人名称
     */
    /**
     * @return ORD_D_DEAL.DEVLOP_NAME : 返回 发展人名称
     */
    public String getDevlopName() {
        return devlopName;
    }

    /**
     * @param devlopName 
	 *            发展人名称
     */
    /**
     * @param devlopName of ORD_D_DEAL : 设置 发展人名称
     */
    public void setDevlopName(String devlopName) {
        this.devlopName = devlopName == null ? null : devlopName.trim();
    }

    /**
     * @return SIMCARD
     */
    /**
     * @return ORD_D_DEAL.SIMCARD : 返回 SIMCARD
     */
    public String getSimcard() {
        return simcard;
    }

    /**
     * @param simcard 
	 *            SIMCARD
     */
    /**
     * @param simcard of ORD_D_DEAL : 设置 SIMCARD
     */
    public void setSimcard(String simcard) {
        this.simcard = simcard == null ? null : simcard.trim();
    }

    /**
     * @return 终端串号
     */
    /**
     * @return ORD_D_DEAL.TERM_ID : 返回 终端串号
     */
    public String getTermId() {
        return termId;
    }

    /**
     * @param termId 
	 *            终端串号
     */
    /**
     * @param termId of ORD_D_DEAL : 设置 终端串号
     */
    public void setTermId(String termId) {
        this.termId = termId == null ? null : termId.trim();
    }

    /**
     * @return 手机号
     */
    /**
     * @return ORD_D_DEAL.PHONE_NUMBER : 返回 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            手机号
     */
    /**
     * @param phoneNumber of ORD_D_DEAL : 设置 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return IMSI
     */
    /**
     * @return ORD_D_DEAL.IMSI : 返回 IMSI
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * @param imsi 
	 *            IMSI
     */
    /**
     * @param imsi of ORD_D_DEAL : 设置 IMSI
     */
    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    /**
     * @return 发票抬头
     */
    /**
     * @return ORD_D_DEAL.INVOCE_TITLE : 返回 发票抬头
     */
    public String getInvoceTitle() {
        return invoceTitle;
    }

    /**
     * @param invoceTitle 
	 *            发票抬头
     */
    /**
     * @param invoceTitle of ORD_D_DEAL : 设置 发票抬头
     */
    public void setInvoceTitle(String invoceTitle) {
        this.invoceTitle = invoceTitle == null ? null : invoceTitle.trim();
    }

    /**
     * @return 发票内容
     */
    /**
     * @return ORD_D_DEAL.INVOCE_CONTENT : 返回 发票内容
     */
    public String getInvoceContent() {
        return invoceContent;
    }

    /**
     * @param invoceContent 
	 *            发票内容
     */
    /**
     * @param invoceContent of ORD_D_DEAL : 设置 发票内容
     */
    public void setInvoceContent(String invoceContent) {
        this.invoceContent = invoceContent == null ? null : invoceContent.trim();
    }
}