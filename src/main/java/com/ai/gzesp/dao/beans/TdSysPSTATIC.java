package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdSysPSTATIC
* @Description: SYS_P_STATIC表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdSysPSTATIC implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields SYS_P_STATIC.TYPE_ID :null
     */
    private String typeId;

    /**
     * @Fields SYS_P_STATIC.DATA_KEY :null
     */
    private String dataKey;

    /**
     * @Fields SYS_P_STATIC.DATA_VALUE :null
     */
    private String dataValue;

    /**
     * 0：不可用<br>
	 * 1：可用
     */
    /**
     * @Fields SYS_P_STATIC.IS_ENABLE :0：不可用
1：可用
     */
    private String isEnable;

    /**
     * @return SYS_P_STATIC.TYPE_ID : 返回 null
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId of SYS_P_STATIC : 设置 null
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * @return SYS_P_STATIC.DATA_KEY : 返回 null
     */
    public String getDataKey() {
        return dataKey;
    }

    /**
     * @param dataKey of SYS_P_STATIC : 设置 null
     */
    public void setDataKey(String dataKey) {
        this.dataKey = dataKey == null ? null : dataKey.trim();
    }

    /**
     * @return SYS_P_STATIC.DATA_VALUE : 返回 null
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * @param dataValue of SYS_P_STATIC : 设置 null
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    /**
     * @return 0：不可用<br>
	 *         1：可用
     */
    /**
     * @return SYS_P_STATIC.IS_ENABLE : 返回 0：不可用
1：可用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * @param isEnable 
	 *            0：不可用<br>
	 *            1：可用
     */
    /**
     * @param isEnable of SYS_P_STATIC : 设置 0：不可用
1：可用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }
}