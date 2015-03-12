package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdTFAAGENTACCOUNT
* @Description: TF_A_AGENT_ACCOUNT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdTFAAGENTACCOUNT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.AGENT_ID :null
     */
    private Integer agentId;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.TOTAL_BALANCE :null
     */
    private Long totalBalance;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.AVAILABLE_BALANCE :null
     */
    private Long availableBalance;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.FREEZE_MONEY :null
     */
    private Long freezeMoney;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.REFUND_FREEZE_MONEY :null
     */
    private Long refundFreezeMoney;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.CREDIT_LIMIT :null
     */
    private Long creditLimit;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.USED_LIMIT :null
     */
    private Long usedLimit;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.PAYMENT_CODE :null
     */
    private String paymentCode;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.SALT :null
     */
    private String salt;

    /**
     * @Fields TF_A_AGENT_ACCOUNT.ADD_DATE :null
     */
    private Date addDate;

    /**
     * 0：独立账户，1：合帐账户
     */
    /**
     * @Fields TF_A_AGENT_ACCOUNT.ACCOUNT_NATURE :0：独立账户，1：合帐账户
     */
    private String accountNature;

    /**
     * @return TF_A_AGENT_ACCOUNT.AGENT_ID : 返回 null
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * @param agentId of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.TOTAL_BALANCE : 返回 null
     */
    public Long getTotalBalance() {
        return totalBalance;
    }

    /**
     * @param totalBalance of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setTotalBalance(Long totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.AVAILABLE_BALANCE : 返回 null
     */
    public Long getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.FREEZE_MONEY : 返回 null
     */
    public Long getFreezeMoney() {
        return freezeMoney;
    }

    /**
     * @param freezeMoney of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setFreezeMoney(Long freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.REFUND_FREEZE_MONEY : 返回 null
     */
    public Long getRefundFreezeMoney() {
        return refundFreezeMoney;
    }

    /**
     * @param refundFreezeMoney of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setRefundFreezeMoney(Long refundFreezeMoney) {
        this.refundFreezeMoney = refundFreezeMoney;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.CREDIT_LIMIT : 返回 null
     */
    public Long getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.USED_LIMIT : 返回 null
     */
    public Long getUsedLimit() {
        return usedLimit;
    }

    /**
     * @param usedLimit of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setUsedLimit(Long usedLimit) {
        this.usedLimit = usedLimit;
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.PAYMENT_CODE : 返回 null
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * @param paymentCode of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.SALT : 返回 null
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return TF_A_AGENT_ACCOUNT.ADD_DATE : 返回 null
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * @param addDate of TF_A_AGENT_ACCOUNT : 设置 null
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * @return 0：独立账户，1：合帐账户
     */
    /**
     * @return TF_A_AGENT_ACCOUNT.ACCOUNT_NATURE : 返回 0：独立账户，1：合帐账户
     */
    public String getAccountNature() {
        return accountNature;
    }

    /**
     * @param accountNature 
	 *            0：独立账户，1：合帐账户
     */
    /**
     * @param accountNature of TF_A_AGENT_ACCOUNT : 设置 0：独立账户，1：合帐账户
     */
    public void setAccountNature(String accountNature) {
        this.accountNature = accountNature == null ? null : accountNature.trim();
    }
}