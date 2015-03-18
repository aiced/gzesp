package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息
 */
/**
 * @ClassName: TdGdsDINFO
* @Description: GDS_D_INFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDINFO extends TdGdsDINFOKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 目录编码
     */
    /**
     * @Fields GDS_D_INFO.CTLG_CODE :目录编码
     */
    private Long ctlgCode;

    /**
     * 商品名称
     */
    /**
     * @Fields GDS_D_INFO.GOODS_NAME :商品名称
     */
    private String goodsName;

    /**
     * 相册标识
     */
    /**
     * @Fields GDS_D_INFO.ALBUM_ID :相册标识
     */
    private Long albumId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_INFO.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 商户标识
     */
    /**
     * @Fields GDS_D_INFO.MERCHANT_ID :商户标识
     */
    private Integer merchantId;

    /**
     * 生成时间
     */
    /**
     * @Fields GDS_D_INFO.CREATE_TIME :生成时间
     */
    private Date createTime;

    /**
     * 生成员工
     */
    /**
     * @Fields GDS_D_INFO.CREATE_STAFF_ID :生成员工
     */
    private Long createStaffId;

    /**
     * 商品状态<br>
	 * 1－可售<br>
	 * 2－已下架
     */
    /**
     * @Fields GDS_D_INFO.GOODS_STATE :商品状态
1－可售
2－已下架
     */
    private String goodsState;

    /**
     * 推荐标记
     */
    /**
     * @Fields GDS_D_INFO.RECOM_TAG :推荐标记
     */
    private String recomTag;

    /**
     * 商品的价格是否由多个属性组合决定。<br>
	 * 1－是<br>
	 * 0－否
     */
    /**
     * @Fields GDS_D_INFO.PRICE_RULE :商品的价格是否由多个属性组合决定。
1－是
0－否
     */
    private String priceRule;

    /**
     * 开始时间
     */
    /**
     * @Fields GDS_D_INFO.BEGIN_TIME :开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    /**
     * @Fields GDS_D_INFO.END_TIME :结束时间
     */
    private Date endTime;

    /**
     * 商品简单描述
     */
    /**
     * @Fields GDS_D_INFO.SIMP_DESC :商品简单描述
     */
    private String simpDesc;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_INFO.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_INFO.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * 商品描述
     */
    /**
     * @Fields GDS_D_INFO.CONTENT :商品描述
     */
    private byte[] content;

    /**
     * @return 目录编码
     */
    /**
     * @return GDS_D_INFO.CTLG_CODE : 返回 目录编码
     */
    public Long getCtlgCode() {
        return ctlgCode;
    }

    /**
     * @param ctlgCode 
	 *            目录编码
     */
    /**
     * @param ctlgCode of GDS_D_INFO : 设置 目录编码
     */
    public void setCtlgCode(Long ctlgCode) {
        this.ctlgCode = ctlgCode;
    }

    /**
     * @return 商品名称
     */
    /**
     * @return GDS_D_INFO.GOODS_NAME : 返回 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName 
	 *            商品名称
     */
    /**
     * @param goodsName of GDS_D_INFO : 设置 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return 相册标识
     */
    /**
     * @return GDS_D_INFO.ALBUM_ID : 返回 相册标识
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId 
	 *            相册标识
     */
    /**
     * @param albumId of GDS_D_INFO : 设置 相册标识
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_INFO.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_INFO : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 商户标识
     */
    /**
     * @return GDS_D_INFO.MERCHANT_ID : 返回 商户标识
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId 
	 *            商户标识
     */
    /**
     * @param merchantId of GDS_D_INFO : 设置 商户标识
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 生成时间
     */
    /**
     * @return GDS_D_INFO.CREATE_TIME : 返回 生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            生成时间
     */
    /**
     * @param createTime of GDS_D_INFO : 设置 生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 生成员工
     */
    /**
     * @return GDS_D_INFO.CREATE_STAFF_ID : 返回 生成员工
     */
    public Long getCreateStaffId() {
        return createStaffId;
    }

    /**
     * @param createStaffId 
	 *            生成员工
     */
    /**
     * @param createStaffId of GDS_D_INFO : 设置 生成员工
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
     * @return GDS_D_INFO.GOODS_STATE : 返回 商品状态
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
     * @param goodsState of GDS_D_INFO : 设置 商品状态
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
     * @return GDS_D_INFO.RECOM_TAG : 返回 推荐标记
     */
    public String getRecomTag() {
        return recomTag;
    }

    /**
     * @param recomTag 
	 *            推荐标记
     */
    /**
     * @param recomTag of GDS_D_INFO : 设置 推荐标记
     */
    public void setRecomTag(String recomTag) {
        this.recomTag = recomTag == null ? null : recomTag.trim();
    }

    /**
     * @return 商品的价格是否由多个属性组合决定。<br>
	 *         1－是<br>
	 *         0－否
     */
    /**
     * @return GDS_D_INFO.PRICE_RULE : 返回 商品的价格是否由多个属性组合决定。
1－是
0－否
     */
    public String getPriceRule() {
        return priceRule;
    }

    /**
     * @param priceRule 
	 *            商品的价格是否由多个属性组合决定。<br>
	 *            1－是<br>
	 *            0－否
     */
    /**
     * @param priceRule of GDS_D_INFO : 设置 商品的价格是否由多个属性组合决定。
1－是
0－否
     */
    public void setPriceRule(String priceRule) {
        this.priceRule = priceRule == null ? null : priceRule.trim();
    }

    /**
     * @return 开始时间
     */
    /**
     * @return GDS_D_INFO.BEGIN_TIME : 返回 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime 
	 *            开始时间
     */
    /**
     * @param beginTime of GDS_D_INFO : 设置 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return 结束时间
     */
    /**
     * @return GDS_D_INFO.END_TIME : 返回 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime 
	 *            结束时间
     */
    /**
     * @param endTime of GDS_D_INFO : 设置 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return 商品简单描述
     */
    /**
     * @return GDS_D_INFO.SIMP_DESC : 返回 商品简单描述
     */
    public String getSimpDesc() {
        return simpDesc;
    }

    /**
     * @param simpDesc 
	 *            商品简单描述
     */
    /**
     * @param simpDesc of GDS_D_INFO : 设置 商品简单描述
     */
    public void setSimpDesc(String simpDesc) {
        this.simpDesc = simpDesc == null ? null : simpDesc.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_INFO.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_INFO : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_INFO.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_INFO : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }

    /**
     * @return 商品描述
     */
    /**
     * @return GDS_D_INFO.CONTENT : 返回 商品描述
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * @param content 
	 *            商品描述
     */
    /**
     * @param content of GDS_D_INFO : 设置 商品描述
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
}