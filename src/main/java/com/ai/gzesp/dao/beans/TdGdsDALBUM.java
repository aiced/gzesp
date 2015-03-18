package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdGdsDALBUM
* @Description: GDS_D_ALBUM表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsDALBUM implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 相册标识
     */
    /**
     * @Fields GDS_D_ALBUM.ALBUM_ID :相册标识
     */
    private Long albumId;

    /**
     * 版本号
     */
    /**
     * @Fields GDS_D_ALBUM.VER_NO :版本号
     */
    private Short verNo;

    /**
     * 相册说明
     */
    /**
     * @Fields GDS_D_ALBUM.ALBUM_EXPLAIN :相册说明
     */
    private String albumExplain;

    /**
     * 00－全通道<br>
	 * 10－WEB<br>
	 * 20－WAP
     */
    /**
     * @Fields GDS_D_ALBUM.USED_CHANNEL :00－全通道
10－WEB
20－WAP
     */
    private String usedChannel;

    /**
     * 预留字段1
     */
    /**
     * @Fields GDS_D_ALBUM.VALUES1 :预留字段1
     */
    private String values1;

    /**
     * 预留字段2
     */
    /**
     * @Fields GDS_D_ALBUM.VALUES2 :预留字段2
     */
    private String values2;

    /**
     * @return 相册标识
     */
    /**
     * @return GDS_D_ALBUM.ALBUM_ID : 返回 相册标识
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId 
	 *            相册标识
     */
    /**
     * @param albumId of GDS_D_ALBUM : 设置 相册标识
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return 版本号
     */
    /**
     * @return GDS_D_ALBUM.VER_NO : 返回 版本号
     */
    public Short getVerNo() {
        return verNo;
    }

    /**
     * @param verNo 
	 *            版本号
     */
    /**
     * @param verNo of GDS_D_ALBUM : 设置 版本号
     */
    public void setVerNo(Short verNo) {
        this.verNo = verNo;
    }

    /**
     * @return 相册说明
     */
    /**
     * @return GDS_D_ALBUM.ALBUM_EXPLAIN : 返回 相册说明
     */
    public String getAlbumExplain() {
        return albumExplain;
    }

    /**
     * @param albumExplain 
	 *            相册说明
     */
    /**
     * @param albumExplain of GDS_D_ALBUM : 设置 相册说明
     */
    public void setAlbumExplain(String albumExplain) {
        this.albumExplain = albumExplain == null ? null : albumExplain.trim();
    }

    /**
     * @return 00－全通道<br>
	 *         10－WEB<br>
	 *         20－WAP
     */
    /**
     * @return GDS_D_ALBUM.USED_CHANNEL : 返回 00－全通道
10－WEB
20－WAP
     */
    public String getUsedChannel() {
        return usedChannel;
    }

    /**
     * @param usedChannel 
	 *            00－全通道<br>
	 *            10－WEB<br>
	 *            20－WAP
     */
    /**
     * @param usedChannel of GDS_D_ALBUM : 设置 00－全通道
10－WEB
20－WAP
     */
    public void setUsedChannel(String usedChannel) {
        this.usedChannel = usedChannel == null ? null : usedChannel.trim();
    }

    /**
     * @return 预留字段1
     */
    /**
     * @return GDS_D_ALBUM.VALUES1 : 返回 预留字段1
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 
	 *            预留字段1
     */
    /**
     * @param values1 of GDS_D_ALBUM : 设置 预留字段1
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return 预留字段2
     */
    /**
     * @return GDS_D_ALBUM.VALUES2 : 返回 预留字段2
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 
	 *            预留字段2
     */
    /**
     * @param values2 of GDS_D_ALBUM : 设置 预留字段2
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}