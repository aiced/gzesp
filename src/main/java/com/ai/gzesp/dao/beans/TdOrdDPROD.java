package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

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
     * 商品单价(销售价格)
     */
    /**
     * @Fields ORD_D_PROD.UNIT_PRICE :商品单价(销售价格)
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
     * 相册标识
     */
    /**
     * @Fields ORD_D_PROD.ALBUM_ID :相册标识
     */
    private Long albumId;

    /**
     * 版本号
     */
    /**
     * @Fields ORD_D_PROD.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 商户标识
     */
    /**
     * @Fields ORD_D_PROD.MERCHANT_ID :商户标识
     */
    private Integer merchantId;

    /**
     * 生成时间
     */
    /**
     * @Fields ORD_D_PROD.CREATE_TIME :生成时间
     */
    private Date createTime;

    /**
     * 生成员工
     */
    /**
     * @Fields ORD_D_PROD.CREATE_STAFF_ID :生成员工
     */
    private Long createStaffId;

    /**
     * 商品状态<br>
	 * 1－可售<br>
	 * 2－已下架
     */
    /**
     * @Fields ORD_D_PROD.GOODS_STATE :商品状态
1－可售
2－已下架
     */
    private String goodsState;

    /**
     * 推荐标记
     */
    /**
     * @Fields ORD_D_PROD.RECOM_TAG :推荐标记
     */
    private String recomTag;

    /**
     * 定价规则
     */
    /**
     * @Fields ORD_D_PROD.PRICE_RULE :定价规则
     */
    private String priceRule;

    /**
     * 开始时间
     */
    /**
     * @Fields ORD_D_PROD.BEGIN_TIME :开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    /**
     * @Fields ORD_D_PROD.END_TIME :结束时间
     */
    private Date endTime;

    /**
     * 商品简单描述
     */
    /**
     * @Fields ORD_D_PROD.SIMP_DESC :商品简单描述
     */
    private String simpDesc;

    /**
     * 目录编码
     */
    /**
     * @Fields ORD_D_PROD.CTLG_CODE :目录编码
     */
    private Long ctlgCode;

    /**
     * 原始价格
     */
    /**
     * @Fields ORD_D_PROD.ORIGINAL_PRICE :原始价格
     */
    private Long originalPrice;

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
     * @return 商品单价(销售价格)
     */
    /**
     * @return ORD_D_PROD.UNIT_PRICE : 返回 商品单价(销售价格)
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice 
	 *            商品单价(销售价格)
     */
    /**
     * @param unitPrice of ORD_D_PROD : 设置 商品单价(销售价格)
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

    /**
     * @return 相册标识
     */
    /**
     * @return ORD_D_PROD.ALBUM_ID : 返回 相册标识
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId 
	 *            相册标识
     */
    /**
     * @param albumId of ORD_D_PROD : 设置 相册标识
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return ORD_D_PROD.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of ORD_D_PROD : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 商户标识
     */
    /**
     * @return ORD_D_PROD.MERCHANT_ID : 返回 商户标识
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId 
	 *            商户标识
     */
    /**
     * @param merchantId of ORD_D_PROD : 设置 商户标识
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 生成时间
     */
    /**
     * @return ORD_D_PROD.CREATE_TIME : 返回 生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            生成时间
     */
    /**
     * @param createTime of ORD_D_PROD : 设置 生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 生成员工
     */
    /**
     * @return ORD_D_PROD.CREATE_STAFF_ID : 返回 生成员工
     */
    public Long getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId 
	 *            生成员工
     */
    /**
     * @param createStaffId of ORD_D_PROD : 设置 生成员工
     */
    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
    }

    /**
     * @return 商品状态<br>
	 *         1－可售<br>
	 *         2－已下架
     */
    /**
     * @return ORD_D_PROD.GOODS_STATE : 返回 商品状态
1－可售
2－已下架
     */
    public String getGoodsState() {
        return goodsState;
    }

    /**
     * @param goodsState 
	 *            商品状态<br>
	 *            1－可售<br>
	 *            2－已下架
     */
    /**
     * @param goodsState of ORD_D_PROD : 设置 商品状态
1－可售
2－已下架
     */
    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState == null ? null : goodsState.trim();
    }

    /**
     * @return 推荐标记
     */
    /**
     * @return ORD_D_PROD.RECOM_TAG : 返回 推荐标记
     */
    public String getRecomTag() {
        return recomTag;
    }

    /**
     * @param recomTag 
	 *            推荐标记
     */
    /**
     * @param recomTag of ORD_D_PROD : 设置 推荐标记
     */
    public void setRecomTag(String recomTag) {
        this.recomTag = recomTag == null ? null : recomTag.trim();
    }

    /**
     * @return 定价规则
     */
    /**
     * @return ORD_D_PROD.PRICE_RULE : 返回 定价规则
     */
    public String getPriceRule() {
        return priceRule;
    }

    /**
     * @param priceRule 
	 *            定价规则
     */
    /**
     * @param priceRule of ORD_D_PROD : 设置 定价规则
     */
    public void setPriceRule(String priceRule) {
        this.priceRule = priceRule == null ? null : priceRule.trim();
    }

    /**
     * @return 开始时间
     */
    /**
     * @return ORD_D_PROD.BEGIN_TIME : 返回 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime 
	 *            开始时间
     */
    /**
     * @param beginTime of ORD_D_PROD : 设置 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return 结束时间
     */
    /**
     * @return ORD_D_PROD.END_TIME : 返回 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 
	 *            结束时间
     */
    /**
     * @param endTime of ORD_D_PROD : 设置 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return 商品简单描述
     */
    /**
     * @return ORD_D_PROD.SIMP_DESC : 返回 商品简单描述
     */
    public String getSimpDesc() {
        return simpDesc;
    }

    /**
     * @param simpDesc 
	 *            商品简单描述
     */
    /**
     * @param simpDesc of ORD_D_PROD : 设置 商品简单描述
     */
    public void setSimpDesc(String simpDesc) {
        this.simpDesc = simpDesc == null ? null : simpDesc.trim();
    }

    /**
     * @return 目录编码
     */
    /**
     * @return ORD_D_PROD.CTLG_CODE : 返回 目录编码
     */
    public Long getCtlgCode() {
        return ctlgCode;
    }

    /**
     * @param ctlgCode 
	 *            目录编码
     */
    /**
     * @param ctlgCode of ORD_D_PROD : 设置 目录编码
     */
    public void setCtlgCode(Long ctlgCode) {
        this.ctlgCode = ctlgCode;
    }

    /**
     * @return 原始价格
     */
    /**
     * @return ORD_D_PROD.ORIGINAL_PRICE : 返回 原始价格
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice 
	 *            原始价格
     */
    /**
     * @param originalPrice of ORD_D_PROD : 设置 原始价格
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }
}