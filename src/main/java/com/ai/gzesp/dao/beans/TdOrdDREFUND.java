package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单退款信息
 */
/**
 * @ClassName: TdOrdDREFUND
* @Description: ORD_D_REFUND表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDREFUND extends TdOrdDREFUNDKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @Fields ORD_D_REFUND.ORDER_NO :展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    private String orderNo;

    /**
     * 订单填写数据库时间
     */
    /**
     * @Fields ORD_D_REFUND.CREATE_TIME :订单填写数据库时间
     */
    private Date createTime;

    /**
     * 订单来源<br>
	 * 00:WEB<br>
	 * 01:微信<br>
	 * 
     */
    /**
     * @Fields ORD_D_REFUND.ORDER_FROM :订单来源
00:WEB
01:微信

     */
    private String orderFrom;

    /**
     * 客户实际订购时间
     */
    /**
     * @Fields ORD_D_REFUND.ORDER_TIME :客户实际订购时间
     */
    private Date orderTime;

    /**
     * 客户姓名
     */
    /**
     * @Fields ORD_D_REFUND.CUST_NAME :客户姓名
     */
    private String custName;

    /**
     * 客户联系号码
     */
    /**
     * @Fields ORD_D_REFUND.PHONE_NUMBER :客户联系号码
     */
    private String phoneNumber;

    /**
     * 交易金额(分)
     */
    /**
     * @Fields ORD_D_REFUND.TXN_AMT :交易金额(分)
     */
    private Long txnAmt;

    /**
     * <br>
	 * 
     */
    /**
     * @Fields ORD_D_REFUND.ORDER_STATE :

     */
    private String orderState;

    /**
     * 订单处理退单：09<br>
	 * 客户拒收退单：10<br>
	 * 
     */
    /**
     * @Fields ORD_D_REFUND.REFUND_TYPE :订单处理退单：09
客户拒收退单：10

     */
    private String refundType;

    /**
     * 买家留言
     */
    /**
     * @Fields ORD_D_REFUND.REFUND_REASON :买家留言
     */
    private String refundReason;

    /**
     * 未审核：00<br>
	 * 审核未通过：01<br>
	 * 审核通过未退款：02<br>
	 * 审核通过已退款：03
     */
    /**
     * @Fields ORD_D_REFUND.REFUND_STATE :未审核：00
审核未通过：01
审核通过未退款：02
审核通过已退款：03
     */
    private String refundState;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_REFUND.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_REFUND.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @return ORD_D_REFUND.ORDER_NO : 返回 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo 
	 *            展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    /**
     * @param orderNo of ORD_D_REFUND : 设置 展现给客户使用，系统内唯一。具体创建可参见相关文档
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * @return 订单填写数据库时间
     */
    /**
     * @return ORD_D_REFUND.CREATE_TIME : 返回 订单填写数据库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            订单填写数据库时间
     */
    /**
     * @param createTime of ORD_D_REFUND : 设置 订单填写数据库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 订单来源<br>
	 *         00:WEB<br>
	 *         01:微信<br>
	 *         
     */
    /**
     * @return ORD_D_REFUND.ORDER_FROM : 返回 订单来源
00:WEB
01:微信

     */
    public String getOrderFrom() {
        return orderFrom;
    }

    /**
     * @param orderFrom 
	 *            订单来源<br>
	 *            00:WEB<br>
	 *            01:微信<br>
	 *            
     */
    /**
     * @param orderFrom of ORD_D_REFUND : 设置 订单来源
00:WEB
01:微信

     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom == null ? null : orderFrom.trim();
    }

    /**
     * @return 客户实际订购时间
     */
    /**
     * @return ORD_D_REFUND.ORDER_TIME : 返回 客户实际订购时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime 
	 *            客户实际订购时间
     */
    /**
     * @param orderTime of ORD_D_REFUND : 设置 客户实际订购时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @return 客户姓名
     */
    /**
     * @return ORD_D_REFUND.CUST_NAME : 返回 客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName 
	 *            客户姓名
     */
    /**
     * @param custName of ORD_D_REFUND : 设置 客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * @return 客户联系号码
     */
    /**
     * @return ORD_D_REFUND.PHONE_NUMBER : 返回 客户联系号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            客户联系号码
     */
    /**
     * @param phoneNumber of ORD_D_REFUND : 设置 客户联系号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return 交易金额(分)
     */
    /**
     * @return ORD_D_REFUND.TXN_AMT : 返回 交易金额(分)
     */
    public Long getTxnAmt() {
        return txnAmt;
    }

    /**
     * @param txnAmt 
	 *            交易金额(分)
     */
    /**
     * @param txnAmt of ORD_D_REFUND : 设置 交易金额(分)
     */
    public void setTxnAmt(Long txnAmt) {
        this.txnAmt = txnAmt;
    }

    /**
     * @return <br>
	 *         
     */
    /**
     * @return ORD_D_REFUND.ORDER_STATE : 返回 

     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState 
	 *            <br>
	 *            
     */
    /**
     * @param orderState of ORD_D_REFUND : 设置 

     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * @return 订单处理退单：09<br>
	 *         客户拒收退单：10<br>
	 *         
     */
    /**
     * @return ORD_D_REFUND.REFUND_TYPE : 返回 订单处理退单：09
客户拒收退单：10

     */
    public String getRefundType() {
        return refundType;
    }

    /**
     * @param refundType 
	 *            订单处理退单：09<br>
	 *            客户拒收退单：10<br>
	 *            
     */
    /**
     * @param refundType of ORD_D_REFUND : 设置 订单处理退单：09
客户拒收退单：10

     */
    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    /**
     * @return 买家留言
     */
    /**
     * @return ORD_D_REFUND.REFUND_REASON : 返回 买家留言
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * @param refundReason 
	 *            买家留言
     */
    /**
     * @param refundReason of ORD_D_REFUND : 设置 买家留言
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    /**
     * @return 未审核：00<br>
	 *         审核未通过：01<br>
	 *         审核通过未退款：02<br>
	 *         审核通过已退款：03
     */
    /**
     * @return ORD_D_REFUND.REFUND_STATE : 返回 未审核：00
审核未通过：01
审核通过未退款：02
审核通过已退款：03
     */
    public String getRefundState() {
        return refundState;
    }

    /**
     * @param refundState 
	 *            未审核：00<br>
	 *            审核未通过：01<br>
	 *            审核通过未退款：02<br>
	 *            审核通过已退款：03
     */
    /**
     * @param refundState of ORD_D_REFUND : 设置 未审核：00
审核未通过：01
审核通过未退款：02
审核通过已退款：03
     */
    public void setRefundState(String refundState) {
        this.refundState = refundState == null ? null : refundState.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_REFUND.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_REFUND : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_REFUND.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_REFUND : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}