package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 能人关系信息表
 */
/**
 * @ClassName: TdAurDRELINFO
* @Description: AUR_D_RELINFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdAurDRELINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields AUR_D_RELINFO.ID :null
     */
    private Long id;

    /**
     * @Fields AUR_D_RELINFO.USER_ID :null
     */
    private String userId;

    /**
     * @Fields AUR_D_RELINFO.DEVLOP_ID :null
     */
    private String devlopId;

    /**
     * @Fields AUR_D_RELINFO.DEVLOP_NAME :null
     */
    private String devlopName;

    /**
     * @return AUR_D_RELINFO.ID : 返回 null
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id of AUR_D_RELINFO : 设置 null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return AUR_D_RELINFO.USER_ID : 返回 null
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId of AUR_D_RELINFO : 设置 null
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return AUR_D_RELINFO.DEVLOP_ID : 返回 null
     */
    public String getDevlopId() {
        return devlopId;
    }

    /**
     * @param devlopId of AUR_D_RELINFO : 设置 null
     */
    public void setDevlopId(String devlopId) {
        this.devlopId = devlopId == null ? null : devlopId.trim();
    }

    /**
     * @return AUR_D_RELINFO.DEVLOP_NAME : 返回 null
     */
    public String getDevlopName() {
        return devlopName;
    }

    /**
     * @param devlopName of AUR_D_RELINFO : 设置 null
     */
    public void setDevlopName(String devlopName) {
        this.devlopName = devlopName == null ? null : devlopName.trim();
    }
}