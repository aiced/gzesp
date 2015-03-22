package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 订单商品信息
 */
/**
 * @ClassName: TdOrdDPROD
* @Description: ORD_D_PROD表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdOrdDPROD extends TdOrdDPRODKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 分区标识
     */
    /**
     * @Fields ORD_D_PROD.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 商品名称
     */
    /**
     * @Fields ORD_D_PROD.GOODS_NAME :商品名称
     */
    private String goodsName;

    /**
     * 商品单价
     */
    /**
     * @Fields ORD_D_PROD.UNIT_PRICE :商品单价
     */
    private Long unitPrice;

    /**
     * 销售数量
     */
    /**
     * @Fields ORD_D_PROD.SALE_NUM :销售数量
     */
    private Integer saleNum;

    /**
     * 应收金额
     */
    /**
     * @Fields ORD_D_PROD.TOPAY_FEE :应收金额
     */
    private Long topayFee;

    /**
     * 减免金额
     */
    /**
     * @Fields ORD_D_PROD.DERATE_FEE :减免金额
     */
    private Long derateFee;

    /**
     * 减免原因
     */
    /**
     * @Fields ORD_D_PROD.DERATE_REASON :减免原因
     */
    private String derateReason;

    /**
     * 实收金额
     */
    /**
     * @Fields ORD_D_PROD.RECV_FEE :实收金额
     */
    private Long recvFee;

    /**
     * 预留字段1
     */
    /**
     * @Fields ORD_D_PROD.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields ORD_D_PROD.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 物品信息描述
     */
    /**
     * @Fields ORD_D_PROD.RES_INFO :物品信息描述
     */
    private String resInfo;

    /**
     * @return 分区标识
     */
    /**
     * @return ORD_D_PROD.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of ORD_D_PROD : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 商品名称
     */
    /**
     * @return ORD_D_PROD.GOODS_NAME : 返回 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName 
	 *            商品名称
     */
    /**
     * @param goodsName of ORD_D_PROD : 设置 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return 商品单价
     */
    /**
     * @return ORD_D_PROD.UNIT_PRICE : 返回 商品单价
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice 
	 *            商品单价
     */
    /**
     * @param unitPrice of ORD_D_PROD : 设置 商品单价
     */
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return 销售数量
     */
    /**
     * @return ORD_D_PROD.SALE_NUM : 返回 销售数量
     */
    public Integer getSaleNum() {
        return saleNum;
    }

    /**
     * @param saleNum 
	 *            销售数量
     */
    /**
     * @param saleNum of ORD_D_PROD : 设置 销售数量
     */
    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    /**
     * @return 应收金额
     */
    /**
     * @return ORD_D_PROD.TOPAY_FEE : 返回 应收金额
     */
    public Long getTopayFee() {
        return topayFee;
    }

    /**
     * @param topayFee 
	 *            应收金额
     */
    /**
     * @param topayFee of ORD_D_PROD : 设置 应收金额
     */
    public void setTopayFee(Long topayFee) {
        this.topayFee = topayFee;
    }

    /**
     * @return 减免金额
     */
    /**
     * @return ORD_D_PROD.DERATE_FEE : 返回 减免金额
     */
    public Long getDerateFee() {
        return derateFee;
    }

    /**
     * @param derateFee 
	 *            减免金额
     */
    /**
     * @param derateFee of ORD_D_PROD : 设置 减免金额
     */
    public void setDerateFee(Long derateFee) {
        this.derateFee = derateFee;
    }

    /**
     * @return 减免原因
     */
    /**
     * @return ORD_D_PROD.DERATE_REASON : 返回 减免原因
     */
    public String getDerateReason() {
        return derateReason;
    }

    /**
     * @param derateReason 
	 *            减免原因
     */
    /**
     * @param derateReason of ORD_D_PROD : 设置 减免原因
     */
    public void setDerateReason(String derateReason) {
        this.derateReason = derateReason == null ? null : derateReason.trim();
    }

    /**
     * @return 实收金额
     */
    /**
     * @return ORD_D_PROD.RECV_FEE : 返回 实收金额
     */
    public Long getRecvFee() {
        return recvFee;
    }

    /**
     * @param recvFee 
	 *            实收金额
     */
    /**
     * @param recvFee of ORD_D_PROD : 设置 实收金额
     */
    public void setRecvFee(Long recvFee) {
        this.recvFee = recvFee;
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return ORD_D_PROD.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of ORD_D_PROD : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return ORD_D_PROD.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of ORD_D_PROD : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 物品信息描述
     */
    /**
     * @return ORD_D_PROD.RES_INFO : 返回 物品信息描述
     */
    public String getResInfo() {
        return resInfo;
    }

    /**
     * @param resInfo 
	 *            物品信息描述
     */
    /**
     * @param resInfo of ORD_D_PROD : 设置 物品信息描述
     */
    public void setResInfo(String resInfo) {
        this.resInfo = resInfo == null ? null : resInfo.trim();
    }
}