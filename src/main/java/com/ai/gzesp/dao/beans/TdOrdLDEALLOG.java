package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单处理日志
 */
/**
 * @ClassName: TdOrdLDEALLOG
* @Description: ORD_L_DEALLOG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdLDEALLOG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 操作流水
     */
    /**
     * @Fields ORD_L_DEALLOG.OPERATE_LOGID :操作流水
     */
    private Long operateLogid;

    /**
     * 订单标识
     */
    /**
     * @Fields ORD_L_DEALLOG.ORDER_ID :订单标识
     */
    private Long orderId;

    /**
     * 订单的分区，而非日志分区
     */
    /**
     * @Fields ORD_L_DEALLOG.PARTITION_ID :订单的分区，而非日志分区
     */
    private Short partitionId;

    /**
     * 操作时间
     */
    /**
     * @Fields ORD_L_DEALLOG.OPERATE_TIME :操作时间
     */
    private Date operateTime;

    /**
     * 操作人标识
     */
    /**
     * @Fields ORD_L_DEALLOG.OPERATOR_ID :操作人标识
     */
    private String operatorId;

    /**
     * 操作人姓名
     */
    /**
     * @Fields ORD_L_DEALLOG.OPERATOR_NAME :操作人姓名
     */
    private String operatorName;

    /**
     * 处理内容的编码
     */
    /**
     * @Fields ORD_L_DEALLOG.DEAL_CONTENT :处理内容的编码
     */
    private String dealContent;

    /**
     * 处理结果编码
     */
    /**
     * @Fields ORD_L_DEALLOG.RESULT_CODE :处理结果编码
     */
    private String resultCode;

    /**
     * 结果说明
     */
    /**
     * @Fields ORD_L_DEALLOG.RESULT_INFO :结果说明
     */
    private String resultInfo;

    /**
     * 处理前订单状态
     */
    /**
     * @Fields ORD_L_DEALLOG.ORIGINAL_STATE :处理前订单状态
     */
    private String originalState;

    /**
     * 处理后订单状态
     */
    /**
     * @Fields ORD_L_DEALLOG.CURRENT_STATE :处理后订单状态
     */
    private String currentState;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_L_DEALLOG.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_L_DEALLOG.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 操作流水
     */
    /**
     * @return ORD_L_DEALLOG.OPERATE_LOGID : 返回 操作流水
     */
    public Long getOperateLogid() {
        return operateLogid;
    }

    /**
     * @param operateLogid 
	 *            操作流水
     */
    /**
     * @param operateLogid of ORD_L_DEALLOG : 设置 操作流水
     */
    public void setOperateLogid(Long operateLogid) {
        this.operateLogid = operateLogid;
    }

    /**
     * @return 订单标识
     */
    /**
     * @return ORD_L_DEALLOG.ORDER_ID : 返回 订单标识
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单标识
     */
    /**
     * @param orderId of ORD_L_DEALLOG : 设置 订单标识
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 订单的分区，而非日志分区
     */
    /**
     * @return ORD_L_DEALLOG.PARTITION_ID : 返回 订单的分区，而非日志分区
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            订单的分区，而非日志分区
     */
    /**
     * @param partitionId of ORD_L_DEALLOG : 设置 订单的分区，而非日志分区
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 操作时间
     */
    /**
     * @return ORD_L_DEALLOG.OPERATE_TIME : 返回 操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime 
	 *            操作时间
     */
    /**
     * @param operateTime of ORD_L_DEALLOG : 设置 操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return 操作人标识
     */
    /**
     * @return ORD_L_DEALLOG.OPERATOR_ID : 返回 操作人标识
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId 
	 *            操作人标识
     */
    /**
     * @param operatorId of ORD_L_DEALLOG : 设置 操作人标识
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * @return 操作人姓名
     */
    /**
     * @return ORD_L_DEALLOG.OPERATOR_NAME : 返回 操作人姓名
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName 
	 *            操作人姓名
     */
    /**
     * @param operatorName of ORD_L_DEALLOG : 设置 操作人姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * @return 处理内容的编码
     */
    /**
     * @return ORD_L_DEALLOG.DEAL_CONTENT : 返回 处理内容的编码
     */
    public String getDealContent() {
        return dealContent;
    }

    /**
     * @param dealContent 
	 *            处理内容的编码
     */
    /**
     * @param dealContent of ORD_L_DEALLOG : 设置 处理内容的编码
     */
    public void setDealContent(String dealContent) {
        this.dealContent = dealContent == null ? null : dealContent.trim();
    }

    /**
     * @return 处理结果编码
     */
    /**
     * @return ORD_L_DEALLOG.RESULT_CODE : 返回 处理结果编码
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode 
	 *            处理结果编码
     */
    /**
     * @param resultCode of ORD_L_DEALLOG : 设置 处理结果编码
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    /**
     * @return 结果说明
     */
    /**
     * @return ORD_L_DEALLOG.RESULT_INFO : 返回 结果说明
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * @param resultInfo 
	 *            结果说明
     */
    /**
     * @param resultInfo of ORD_L_DEALLOG : 设置 结果说明
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo == null ? null : resultInfo.trim();
    }

    /**
     * @return 处理前订单状态
     */
    /**
     * @return ORD_L_DEALLOG.ORIGINAL_STATE : 返回 处理前订单状态
     */
    public String getOriginalState() {
        return originalState;
    }

    /**
     * @param originalState 
	 *            处理前订单状态
     */
    /**
     * @param originalState of ORD_L_DEALLOG : 设置 处理前订单状态
     */
    public void setOriginalState(String originalState) {
        this.originalState = originalState == null ? null : originalState.trim();
    }

    /**
     * @return 处理后订单状态
     */
    /**
     * @return ORD_L_DEALLOG.CURRENT_STATE : 返回 处理后订单状态
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState 
	 *            处理后订单状态
     */
    /**
     * @param currentState of ORD_L_DEALLOG : 设置 处理后订单状态
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState == null ? null : currentState.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_L_DEALLOG.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_L_DEALLOG : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_L_DEALLOG.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_L_DEALLOG : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}