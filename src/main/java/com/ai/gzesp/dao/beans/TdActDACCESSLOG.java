package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户存取日志表
 */
/**
 * @ClassName: TdActDACCESSLOG
* @Description: ACT_D_ACCESS_LOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdActDACCESSLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 流水id
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.LOG_ID :流水id
     */
    private Long logId;

    /**
     * 分区标识,流水id后2位
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.PARTITION_ID :分区标识,流水id后2位
     */
    private Short partitionId;

    /**
     * 账户id
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.ACCT_ID :账户id
     */
    private String acctId;

    /**
     * 订单id
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.ORDER_ID :订单id
     */
    private Long orderId;

    /**
     * 11：佣金入账户<br>
	 * 12：奖励入账户<br>
	 * 21：账户支付(现金不可提)(钱为负值)<br>
	 * 22：账户支付(现金可提)(钱为负值)<br>
	 * 23：账户支付(非现金)(钱为负值)<br>
	 * 31：现金不可提转可提(转出)(钱为负值)<br>
	 * 32：现金不可提转可提(转入)<br>
	 * 40：非现金奖励<br>
	 * 51：退货佣金回退(钱为负值)<br>
	 * 52：退货账户回退<br>
	 * 53：佣金重算抵销(钱为负值)<br>
	 * 60：佣金提现(钱为负值)
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.TRADE_TYPE :11：佣金入账户
12：奖励入账户
21：账户支付(现金不可提)(钱为负值)
22：账户支付(现金可提)(钱为负值)
23：账户支付(非现金)(钱为负值)
31：现金不可提转可提(转出)(钱为负值)
32：现金不可提转可提(转入)
40：非现金奖励
51：退货佣金回退(钱为负值)
52：退货账户回退
53：佣金重算抵销(钱为负值)
60：佣金提现(钱为负值)
     */
    private String tradeType;

    /**
     * 账户原余额(厘)
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.OLD_BALANCE :账户原余额(厘)
     */
    private Long oldBalance;

    /**
     * 本次变动金额(厘)
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.FEE :本次变动金额(厘)
     */
    private Long fee;

    /**
     * 当前余额(厘)
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.NEW_BALANCE :当前余额(厘)
     */
    private Long newBalance;

    /**
     * 更新时间
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * 返销标志
     */
    /**
     * @Fields ACT_D_ACCESS_LOG.CANCEL_TAG :返销标志
     */
    private String cancelTag;

    /**
     * @return 流水id
     */
    /**
     * @return ACT_D_ACCESS_LOG.LOG_ID : 返回 流水id
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * @param logId 
	 *            流水id
     */
    /**
     * @param logId of ACT_D_ACCESS_LOG : 设置 流水id
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * @return 分区标识,流水id后2位
     */
    /**
     * @return ACT_D_ACCESS_LOG.PARTITION_ID : 返回 分区标识,流水id后2位
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识,流水id后2位
     */
    /**
     * @param partitionId of ACT_D_ACCESS_LOG : 设置 分区标识,流水id后2位
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 账户id
     */
    /**
     * @return ACT_D_ACCESS_LOG.ACCT_ID : 返回 账户id
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * @param acctId 
	 *            账户id
     */
    /**
     * @param acctId of ACT_D_ACCESS_LOG : 设置 账户id
     */
    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    /**
     * @return 订单id
     */
    /**
     * @return ACT_D_ACCESS_LOG.ORDER_ID : 返回 订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    /**
     * @param orderId of ACT_D_ACCESS_LOG : 设置 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 11：佣金入账户<br>
	 *         12：奖励入账户<br>
	 *         21：账户支付(现金不可提)(钱为负值)<br>
	 *         22：账户支付(现金可提)(钱为负值)<br>
	 *         23：账户支付(非现金)(钱为负值)<br>
	 *         31：现金不可提转可提(转出)(钱为负值)<br>
	 *         32：现金不可提转可提(转入)<br>
	 *         40：非现金奖励<br>
	 *         51：退货佣金回退(钱为负值)<br>
	 *         52：退货账户回退<br>
	 *         53：佣金重算抵销(钱为负值)<br>
	 *         60：佣金提现(钱为负值)
     */
    /**
     * @return ACT_D_ACCESS_LOG.TRADE_TYPE : 返回 11：佣金入账户
12：奖励入账户
21：账户支付(现金不可提)(钱为负值)
22：账户支付(现金可提)(钱为负值)
23：账户支付(非现金)(钱为负值)
31：现金不可提转可提(转出)(钱为负值)
32：现金不可提转可提(转入)
40：非现金奖励
51：退货佣金回退(钱为负值)
52：退货账户回退
53：佣金重算抵销(钱为负值)
60：佣金提现(钱为负值)
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType 
	 *            11：佣金入账户<br>
	 *            12：奖励入账户<br>
	 *            21：账户支付(现金不可提)(钱为负值)<br>
	 *            22：账户支付(现金可提)(钱为负值)<br>
	 *            23：账户支付(非现金)(钱为负值)<br>
	 *            31：现金不可提转可提(转出)(钱为负值)<br>
	 *            32：现金不可提转可提(转入)<br>
	 *            40：非现金奖励<br>
	 *            51：退货佣金回退(钱为负值)<br>
	 *            52：退货账户回退<br>
	 *            53：佣金重算抵销(钱为负值)<br>
	 *            60：佣金提现(钱为负值)
     */
    /**
     * @param tradeType of ACT_D_ACCESS_LOG : 设置 11：佣金入账户
12：奖励入账户
21：账户支付(现金不可提)(钱为负值)
22：账户支付(现金可提)(钱为负值)
23：账户支付(非现金)(钱为负值)
31：现金不可提转可提(转出)(钱为负值)
32：现金不可提转可提(转入)
40：非现金奖励
51：退货佣金回退(钱为负值)
52：退货账户回退
53：佣金重算抵销(钱为负值)
60：佣金提现(钱为负值)
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * @return 账户原余额(厘)
     */
    /**
     * @return ACT_D_ACCESS_LOG.OLD_BALANCE : 返回 账户原余额(厘)
     */
    public Long getOldBalance() {
        return oldBalance;
    }

    /**
     * @param oldBalance 
	 *            账户原余额(厘)
     */
    /**
     * @param oldBalance of ACT_D_ACCESS_LOG : 设置 账户原余额(厘)
     */
    public void setOldBalance(Long oldBalance) {
        this.oldBalance = oldBalance;
    }

    /**
     * @return 本次变动金额(厘)
     */
    /**
     * @return ACT_D_ACCESS_LOG.FEE : 返回 本次变动金额(厘)
     */
    public Long getFee() {
        return fee;
    }

    /**
     * @param fee 
	 *            本次变动金额(厘)
     */
    /**
     * @param fee of ACT_D_ACCESS_LOG : 设置 本次变动金额(厘)
     */
    public void setFee(Long fee) {
        this.fee = fee;
    }

    /**
     * @return 当前余额(厘)
     */
    /**
     * @return ACT_D_ACCESS_LOG.NEW_BALANCE : 返回 当前余额(厘)
     */
    public Long getNewBalance() {
        return newBalance;
    }

    /**
     * @param newBalance 
	 *            当前余额(厘)
     */
    /**
     * @param newBalance of ACT_D_ACCESS_LOG : 设置 当前余额(厘)
     */
    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    /**
     * @return 更新时间
     */
    /**
     * @return ACT_D_ACCESS_LOG.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of ACT_D_ACCESS_LOG : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 返销标志
     */
    /**
     * @return ACT_D_ACCESS_LOG.CANCEL_TAG : 返回 返销标志
     */
    public String getCancelTag() {
        return cancelTag;
    }

    /**
     * @param cancelTag 
	 *            返销标志
     */
    /**
     * @param cancelTag of ACT_D_ACCESS_LOG : 设置 返销标志
     */
    public void setCancelTag(String cancelTag) {
        this.cancelTag = cancelTag == null ? null : cancelTag.trim();
    }
}