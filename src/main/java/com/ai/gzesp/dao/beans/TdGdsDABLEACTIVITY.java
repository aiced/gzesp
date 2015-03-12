package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 能人商品活动信息
 */
/**
 * @ClassName: TdGdsDABLEACTIVITY
* @Description: GDS_D_ABLE_ACTIVITY表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDABLEACTIVITY implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品标识
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.GOODS_ID :商品标识
     */
    private Long goodsId;

    /**
     * 分区标识
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.PARTITION_ID :分区标识
     */
    private Short partitionId;

    /**
     * 能人ID
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.USER_ID :能人ID
     */
    private String userId;

    /**
     * 活动标题
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.ATY_TITLE :活动标题
     */
    private String atyTitle;

    /**
     * 活动内容
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.ATY_CONTENT :活动内容
     */
    private String atyContent;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_ABLE_ACTIVITY.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 商品标识
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.GOODS_ID : 返回 商品标识
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品标识
     */
    /**
     * @param goodsId of GDS_D_ABLE_ACTIVITY : 设置 商品标识
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 分区标识
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.PARTITION_ID : 返回 分区标识
     */
    public Short getPartitionId() {
        return partitionId;
    }

    /**
     * @param partitionId 
	 *            分区标识
     */
    /**
     * @param partitionId of GDS_D_ABLE_ACTIVITY : 设置 分区标识
     */
    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }

    /**
     * @return 能人ID
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.USER_ID : 返回 能人ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人ID
     */
    /**
     * @param userId of GDS_D_ABLE_ACTIVITY : 设置 能人ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 活动标题
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.ATY_TITLE : 返回 活动标题
     */
    public String getAtyTitle() {
        return atyTitle;
    }

    /**
     * @param atyTitle 
	 *            活动标题
     */
    /**
     * @param atyTitle of GDS_D_ABLE_ACTIVITY : 设置 活动标题
     */
    public void setAtyTitle(String atyTitle) {
        this.atyTitle = atyTitle == null ? null : atyTitle.trim();
    }

    /**
     * @return 活动内容
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.ATY_CONTENT : 返回 活动内容
     */
    public String getAtyContent() {
        return atyContent;
    }

    /**
     * @param atyContent 
	 *            活动内容
     */
    /**
     * @param atyContent of GDS_D_ABLE_ACTIVITY : 设置 活动内容
     */
    public void setAtyContent(String atyContent) {
        this.atyContent = atyContent == null ? null : atyContent.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_ABLE_ACTIVITY : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_ABLE_ACTIVITY.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_ABLE_ACTIVITY : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}