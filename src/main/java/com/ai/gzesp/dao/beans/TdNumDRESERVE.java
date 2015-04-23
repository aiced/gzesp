package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TdNumDRESERVE
* @Description: NUM_D_RESERVE表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdNumDRESERVE implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields NUM_D_RESERVE.SERIAL_NUMBER :null
     */
    private String serialNumber;

    /**
     * @Fields NUM_D_RESERVE.CODE_STATE :null
     */
    private String codeState;

    /**
     * @Fields NUM_D_RESERVE.ADD_TIME :null
     */
    private Date addTime;

    /**
     * @return NUM_D_RESERVE.SERIAL_NUMBER : 返回 null
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber of NUM_D_RESERVE : 设置 null
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * @return NUM_D_RESERVE.CODE_STATE : 返回 null
     */
    public String getCodeState() {
        return codeState;
    }

    /**
     * @param codeState of NUM_D_RESERVE : 设置 null
     */
    public void setCodeState(String codeState) {
        this.codeState = codeState == null ? null : codeState.trim();
    }

    /**
     * @return NUM_D_RESERVE.ADD_TIME : 返回 null
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime of NUM_D_RESERVE : 设置 null
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}