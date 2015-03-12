package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品图片
 */
/**
 * @ClassName: TdGdsDPHOTO
* @Description: GDS_D_PHOTO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDPHOTO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 相册标识
     */
    /**
     * @Fields GDS_D_PHOTO.ALBUM_ID :相册标识
     */
    private Long albumId;

    /**
     * 相片地址
     */
    /**
     * @Fields GDS_D_PHOTO.PHOTO_LINKS :相片地址
     */
    private String photoLinks;

    /**
     * 相片编号
     */
    /**
     * @Fields GDS_D_PHOTO.PHOTO_NO :相片编号
     */
    private Short photoNo;

    /**
     * 默认标记
     */
    /**
     * @Fields GDS_D_PHOTO.DEFAULT_TAG :默认标记
     */
    private String defaultTag;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_PHOTO.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_PHOTO.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 相册标识
     */
    /**
     * @return GDS_D_PHOTO.ALBUM_ID : 返回 相册标识
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId 
	 *            相册标识
     */
    /**
     * @param albumId of GDS_D_PHOTO : 设置 相册标识
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return 相片地址
     */
    /**
     * @return GDS_D_PHOTO.PHOTO_LINKS : 返回 相片地址
     */
    public String getPhotoLinks() {
        return photoLinks;
    }

    /**
     * @param photoLinks 
	 *            相片地址
     */
    /**
     * @param photoLinks of GDS_D_PHOTO : 设置 相片地址
     */
    public void setPhotoLinks(String photoLinks) {
        this.photoLinks = photoLinks == null ? null : photoLinks.trim();
    }

    /**
     * @return 相片编号
     */
    /**
     * @return GDS_D_PHOTO.PHOTO_NO : 返回 相片编号
     */
    public Short getPhotoNo() {
        return photoNo;
    }

    /**
     * @param photoNo 
	 *            相片编号
     */
    /**
     * @param photoNo of GDS_D_PHOTO : 设置 相片编号
     */
    public void setPhotoNo(Short photoNo) {
        this.photoNo = photoNo;
    }

    /**
     * @return 默认标记
     */
    /**
     * @return GDS_D_PHOTO.DEFAULT_TAG : 返回 默认标记
     */
    public String getDefaultTag() {
        return defaultTag;
    }

    /**
     * @param defaultTag 
	 *            默认标记
     */
    /**
     * @param defaultTag of GDS_D_PHOTO : 设置 默认标记
     */
    public void setDefaultTag(String defaultTag) {
        this.defaultTag = defaultTag == null ? null : defaultTag.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_PHOTO.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_PHOTO : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_PHOTO.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_PHOTO : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}