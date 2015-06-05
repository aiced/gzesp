package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单支付信息<br>
	 * 如果下单后未发起支付，则表里pay_state=0，pay_mode=null，<br>
	 * 如果订单全部由一种方式支付，则一条订单一条支付记录，<br>
	 * 如果多种方式组合支付，则一条订单多条支付记录。
 */
/**
 * @ClassName: TdOrdDPAY
* @Description: ORD_D_PAY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPAY extends TdOrdDPAYKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 分区标识,订单id后2位
     */
    /**
     * @Fields ORD_D_PAY.PARTITION_ID :分区标识,订单id后2位
     */
    private Short partitionId;

    /**
     * 支付类型<br>
	 * 01 在线<br>
	 * 02 货到
     */
    /**
     * @Fields ORD_D_PAY.PAY_TYPE :支付类型
01 在线
02 货到
     */
    private String payType;

    /**
     * 支付方式<br>
	 * 10 银联快捷支付<br>
	 * 11 银联在线信用卡<br>
	 * 12 银联在线储蓄卡<br>
	 * 20 支付宝(暂无)<br>
	 * 30 微信支付<br>
	 * 40 沃支付<br>
	 * 51 能人现金可提账户支付<br>
	 * 52 能人现金不可提账户支付<br>
	 * 53 能人非现金账户支付<br>
	 * 
     */
    /**
     * @Fields ORD_D_PAY.PAY_MODE :支付方式
10 银联快捷支付
11 银联在线信用卡
12 银联在线储蓄卡
20 支付宝(暂无)
30 微信支付
40 沃支付
51 能人现金可提账户支付
52 能人现金不可提账户支付
53 能人非现金账户支付

     */
    private String payMode;

    /**
     * 支付状态<br>
	 * 0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款<br>
	 * 
     */
    /**
     * @Fields ORD_D_PAY.PAY_STATE :支付状态
0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款

     */
    private String payState;

    /**
     * 订单金额(厘)
     */
    /**
     * @Fields ORD_D_PAY.ORDER_FEE :订单金额(厘)
     */
    private Long orderFee;

    /**
     * 支付金额(厘)
     */
    /**
     * @Fields ORD_D_PAY.PAY_FEE :支付金额(厘)
     */
    private Long payFee;

    /**
     * 支付时间
     */
    /**
     * @Fields ORD_D_PAY.PAY_TIME :支付时间
     */
    private Date payTime;

    /**
     * 冲正标记
     */
    /**
     * @Fields ORD_D_PAY.HALT_TAG :冲正标记
     */
    private String haltTag;

    /**
     * 清算日期
     */
    /**
     * @Fields ORD_D_PAY.SETTLE_DATE :清算日期
     */
    private String settleDate;

    /**
     * 冲正时间
     */
    /**
     * @Fields ORD_D_PAY.HALT_TIME :冲正时间
     */
    private Date haltTime;

    /**
     * 退款标志<br>
	 * 0-未退款<br>
	 * 1-需要退款<br>
	 * 2-已退款
     */
    /**
     * @Fields ORD_D_PAY.REFUND_TAG :退款标志
0-未退款
1-需要退款
2-已退款
     */
    private String refundTag;

    /**
     * 退款时间
     */
    /**
     * @Fields ORD_D_PAY.REFUND_TIME :退款时间
     */
    private Date refundTime;

    /**
     * 退款流水
     */
    /**
     * @Fields ORD_D_PAY.REFUND_LOGID :退款流水
     */
    private Long refundLogid;

    /**
     * @return 分区标识,订单id后2位
     */
    /**
     * @return ORD_D_PAY.PARTITION_ID : 返回 分区标识,订单id后2位
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识,订单id后2位
     */
    /**
     * @param partitionId of ORD_D_PAY : 设置 分区标识,订单id后2位
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 支付类型<br>
	 *         01 在线<br>
	 *         02 货到
     */
    /**
     * @return ORD_D_PAY.PAY_TYPE : 返回 支付类型
01 在线
02 货到
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType 
	 *            支付类型<br>
	 *            01 在线<br>
	 *            02 货到
     */
    /**
     * @param payType of ORD_D_PAY : 设置 支付类型
01 在线
02 货到
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * @return 支付方式<br>
	 *         10 银联快捷支付<br>
	 *         11 银联在线信用卡<br>
	 *         12 银联在线储蓄卡<br>
	 *         20 支付宝(暂无)<br>
	 *         30 微信支付<br>
	 *         40 沃支付<br>
	 *         51 能人现金可提账户支付<br>
	 *         52 能人现金不可提账户支付<br>
	 *         53 能人非现金账户支付<br>
	 *         
     */
    /**
     * @return ORD_D_PAY.PAY_MODE : 返回 支付方式
10 银联快捷支付
11 银联在线信用卡
12 银联在线储蓄卡
20 支付宝(暂无)
30 微信支付
40 沃支付
51 能人现金可提账户支付
52 能人现金不可提账户支付
53 能人非现金账户支付

     */
    public String getPayMode() {
        return payMode;
    }

    /**
     * @param payMode 
	 *            支付方式<br>
	 *            10 银联快捷支付<br>
	 *            11 银联在线信用卡<br>
	 *            12 银联在线储蓄卡<br>
	 *            20 支付宝(暂无)<br>
	 *            30 微信支付<br>
	 *            40 沃支付<br>
	 *            51 能人现金可提账户支付<br>
	 *            52 能人现金不可提账户支付<br>
	 *            53 能人非现金账户支付<br>
	 *            
     */
    /**
     * @param payMode of ORD_D_PAY : 设置 支付方式
10 银联快捷支付
11 银联在线信用卡
12 银联在线储蓄卡
20 支付宝(暂无)
30 微信支付
40 沃支付
51 能人现金可提账户支付
52 能人现金不可提账户支付
53 能人非现金账户支付

     */
    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    /**
     * @return 支付状态<br>
	 *         0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款<br>
	 *         
     */
    /**
     * @return ORD_D_PAY.PAY_STATE : 返回 支付状态
0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款

     */
    public String getPayState() {
        return payState;
    }

    /**
     * @param payState 
	 *            支付状态<br>
	 *            0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款<br>
	 *            
     */
    /**
     * @param payState of ORD_D_PAY : 设置 支付状态
0-未支付，9-已发起支付请求未收到响应，1-支付成功，2-支付失败，3-已冲正，4-冲正失败 5-已退款

     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    /**
     * @return 订单金额(厘)
     */
    /**
     * @return ORD_D_PAY.ORDER_FEE : 返回 订单金额(厘)
     */
    public Long getOrderFee() {
        return orderFee;
    }

    /**
     * @param orderFee 
	 *            订单金额(厘)
     */
    /**
     * @param orderFee of ORD_D_PAY : 设置 订单金额(厘)
     */
    public void setOrderFee(Long orderFee) {
        this.orderFee = orderFee;
    }

    /**
     * @return 支付金额(厘)
     */
    /**
     * @return ORD_D_PAY.PAY_FEE : 返回 支付金额(厘)
     */
    public Long getPayFee() {
        return payFee;
    }

    /**
     * @param payFee 
	 *            支付金额(厘)
     */
    /**
     * @param payFee of ORD_D_PAY : 设置 支付金额(厘)
     */
    public void setPayFee(Long payFee) {
        this.payFee = payFee;
    }

    /**
     * @return 支付时间
     */
    /**
     * @return ORD_D_PAY.PAY_TIME : 返回 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime 
	 *            支付时间
     */
    /**
     * @param payTime of ORD_D_PAY : 设置 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return 冲正标记
     */
    /**
     * @return ORD_D_PAY.HALT_TAG : 返回 冲正标记
     */
    public String getHaltTag() {
        return haltTag;
    }

    /**
     * @param haltTag 
	 *            冲正标记
     */
    /**
     * @param haltTag of ORD_D_PAY : 设置 冲正标记
     */
    public void setHaltTag(String haltTag) {
        this.haltTag = haltTag == null ? null : haltTag.trim();
    }

    /**
     * @return 清算日期
     */
    /**
     * @return ORD_D_PAY.SETTLE_DATE : 返回 清算日期
     */
    public String getSettleDate() {
        return settleDate;
    }

    /**
     * @param settleDate 
	 *            清算日期
     */
    /**
     * @param settleDate of ORD_D_PAY : 设置 清算日期
     */
    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate == null ? null : settleDate.trim();
    }

    /**
     * @return 冲正时间
     */
    /**
     * @return ORD_D_PAY.HALT_TIME : 返回 冲正时间
     */
    public Date getHaltTime() {
        return haltTime;
    }

    /**
     * @param haltTime 
	 *            冲正时间
     */
    /**
     * @param haltTime of ORD_D_PAY : 设置 冲正时间
     */
    public void setHaltTime(Date haltTime) {
        this.haltTime = haltTime;
    }

    /**
     * @return 退款标志<br>
	 *         0-未退款<br>
	 *         1-需要退款<br>
	 *         2-已退款
     */
    /**
     * @return ORD_D_PAY.REFUND_TAG : 返回 退款标志
0-未退款
1-需要退款
2-已退款
     */
    public String getRefundTag() {
        return refundTag;
    }

    /**
     * @param refundTag 
	 *            退款标志<br>
	 *            0-未退款<br>
	 *            1-需要退款<br>
	 *            2-已退款
     */
    /**
     * @param refundTag of ORD_D_PAY : 设置 退款标志
0-未退款
1-需要退款
2-已退款
     */
    public void setRefundTag(String refundTag) {
        this.refundTag = refundTag == null ? null : refundTag.trim();
    }

    /**
     * @return 退款时间
     */
    /**
     * @return ORD_D_PAY.REFUND_TIME : 返回 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * @param refundTime 
	 *            退款时间
     */
    /**
     * @param refundTime of ORD_D_PAY : 设置 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * @return 退款流水
     */
    /**
     * @return ORD_D_PAY.REFUND_LOGID : 返回 退款流水
     */
    public Long getRefundLogid() {
        return refundLogid;
    }

    /**
     * @param refundLogid 
	 *            退款流水
     */
    /**
     * @param refundLogid of ORD_D_PAY : 设置 退款流水
     */
    public void setRefundLogid(Long refundLogid) {
        this.refundLogid = refundLogid;
    }
}