package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 号码信息
 */
/**
 * @ClassName: TdNumDNUMINFO
* @Description: NUM_D_NUMINFO表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdNumDNUMINFO implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 电话号码
     */
    /**
     * @Fields NUM_D_NUMINFO.SERIAL_NUMBER :电话号码
     */
    private String serialNumber;

    /**
     * 网别编码：01-3G、02-2G
     */
    /**
     * @Fields NUM_D_NUMINFO.NET_TYPE_CODE :网别编码：01-3G、02-2G
     */
    private String netTypeCode;

    /**
     * IMSI号
     */
    /**
     * @Fields NUM_D_NUMINFO.IMSI :IMSI号
     */
    private String imsi;

    /**
     * SIM卡号
     */
    /**
     * @Fields NUM_D_NUMINFO.SIM_CARD_NO :SIM卡号
     */
    private String simCardNo;

    /**
     * 号码状态<br>
	 * 0－入库<br>
	 * 1－上架/空闲<br>
	 * 2－预占<br>
	 * 4－占用/已销售<br>
	 * 5－下架<br>
	 * 6－出库<br>
	 * 7－预定<br>
	 * 8－付费预定<br>
	 * 9－已回收
     */
    /**
     * @Fields NUM_D_NUMINFO.CODE_STATE :号码状态
0－入库
1－上架/空闲
2－预占
4－占用/已销售
5－下架
6－出库
7－预定
8－付费预定
9－已回收
     */
    private String codeState;

    /**
     * 无线上网卡号码分类：0－公众号码、1－集团号码
     */
    /**
     * @Fields NUM_D_NUMINFO.WIRELESS_CARD_TYPE :无线上网卡号码分类：0－公众号码、1－集团号码
     */
    private String wirelessCardType;

    /**
     * 号码分级
     */
    /**
     * @Fields NUM_D_NUMINFO.CODE_GRADE :号码分级
     */
    private Short codeGrade;

    /**
     * 靓号规则限制标识
     */
    /**
     * @Fields NUM_D_NUMINFO.LIMIT_ID :靓号规则限制标识
     */
    private Long limitId;

    /**
     * 靓号规则
     */
    /**
     * @Fields NUM_D_NUMINFO.NICE_RULE :靓号规则
     */
    private String niceRule;

    /**
     * 靓号费用
     */
    /**
     * @Fields NUM_D_NUMINFO.NICE_FEE :靓号费用
     */
    private Long niceFee;

    /**
     * 归属省分
     */
    /**
     * @Fields NUM_D_NUMINFO.PROVINCE_CODE :归属省分
     */
    private String provinceCode;

    /**
     * 归属地州
     */
    /**
     * @Fields NUM_D_NUMINFO.EPARCHY_CODE :归属地州
     */
    private String eparchyCode;

    /**
     * 归属区县
     */
    /**
     * @Fields NUM_D_NUMINFO.CITY_CODE :归属区县
     */
    private String cityCode;

    /**
     * 归属部门
     */
    /**
     * @Fields NUM_D_NUMINFO.DEPART_ID :归属部门
     */
    private String departId;

    /**
     * 归属渠道
     */
    /**
     * @Fields NUM_D_NUMINFO.CHANNEL_ID :归属渠道
     */
    private String channelId;

    /**
     * 归属员工
     */
    /**
     * @Fields NUM_D_NUMINFO.STAFF_ID :归属员工
     */
    private String staffId;

    /**
     * 入库批次
     */
    /**
     * @Fields NUM_D_NUMINFO.BATCH_ID :入库批次
     */
    private Long batchId;

    /**
     * 入库员工
     */
    /**
     * @Fields NUM_D_NUMINFO.STAFF_IN :入库员工
     */
    private String staffIn;

    /**
     * 入库时间
     */
    /**
     * @Fields NUM_D_NUMINFO.TIME_IN :入库时间
     */
    private Date timeIn;

    /**
     * 冗余字段1
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE1 :冗余字段1
     */
    private String rsvalue1;

    /**
     * 冗余字段2
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE2 :冗余字段2
     */
    private String rsvalue2;

    /**
     * 冗余字段3
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE3 :冗余字段3
     */
    private String rsvalue3;

    /**
     * 冗余字段4
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE4 :冗余字段4
     */
    private String rsvalue4;

    /**
     * 冗余字段5
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE5 :冗余字段5
     */
    private String rsvalue5;

    /**
     * 冗余字段6
     */
    /**
     * @Fields NUM_D_NUMINFO.RSVALUE6 :冗余字段6
     */
    private String rsvalue6;

    /**
     * @return 电话号码
     */
    /**
     * @return NUM_D_NUMINFO.SERIAL_NUMBER : 返回 电话号码
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber 
	 *            电话号码
     */
    /**
     * @param serialNumber of NUM_D_NUMINFO : 设置 电话号码
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * @return 网别编码：01-3G、02-2G
     */
    /**
     * @return NUM_D_NUMINFO.NET_TYPE_CODE : 返回 网别编码：01-3G、02-2G
     */
    public String getNetTypeCode() {
        return netTypeCode;
    }

    /**
     * @param netTypeCode 
	 *            网别编码：01-3G、02-2G
     */
    /**
     * @param netTypeCode of NUM_D_NUMINFO : 设置 网别编码：01-3G、02-2G
     */
    public void setNetTypeCode(String netTypeCode) {
        this.netTypeCode = netTypeCode == null ? null : netTypeCode.trim();
    }

    /**
     * @return IMSI号
     */
    /**
     * @return NUM_D_NUMINFO.IMSI : 返回 IMSI号
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * @param imsi 
	 *            IMSI号
     */
    /**
     * @param imsi of NUM_D_NUMINFO : 设置 IMSI号
     */
    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    /**
     * @return SIM卡号
     */
    /**
     * @return NUM_D_NUMINFO.SIM_CARD_NO : 返回 SIM卡号
     */
    public String getSimCardNo() {
        return simCardNo;
    }

    /**
     * @param simCardNo 
	 *            SIM卡号
     */
    /**
     * @param simCardNo of NUM_D_NUMINFO : 设置 SIM卡号
     */
    public void setSimCardNo(String simCardNo) {
        this.simCardNo = simCardNo == null ? null : simCardNo.trim();
    }

    /**
     * @return 号码状态<br>
	 *         0－入库<br>
	 *         1－上架/空闲<br>
	 *         2－预占<br>
	 *         4－占用/已销售<br>
	 *         5－下架<br>
	 *         6－出库<br>
	 *         7－预定<br>
	 *         8－付费预定<br>
	 *         9－已回收
     */
    /**
     * @return NUM_D_NUMINFO.CODE_STATE : 返回 号码状态
0－入库
1－上架/空闲
2－预占
4－占用/已销售
5－下架
6－出库
7－预定
8－付费预定
9－已回收
     */
    public String getCodeState() {
        return codeState;
    }

    /**
     * @param codeState 
	 *            号码状态<br>
	 *            0－入库<br>
	 *            1－上架/空闲<br>
	 *            2－预占<br>
	 *            4－占用/已销售<br>
	 *            5－下架<br>
	 *            6－出库<br>
	 *            7－预定<br>
	 *            8－付费预定<br>
	 *            9－已回收
     */
    /**
     * @param codeState of NUM_D_NUMINFO : 设置 号码状态
0－入库
1－上架/空闲
2－预占
4－占用/已销售
5－下架
6－出库
7－预定
8－付费预定
9－已回收
     */
    public void setCodeState(String codeState) {
        this.codeState = codeState == null ? null : codeState.trim();
    }

    /**
     * @return 无线上网卡号码分类：0－公众号码、1－集团号码
     */
    /**
     * @return NUM_D_NUMINFO.WIRELESS_CARD_TYPE : 返回 无线上网卡号码分类：0－公众号码、1－集团号码
     */
    public String getWirelessCardType() {
        return wirelessCardType;
    }

    /**
     * @param wirelessCardType 
	 *            无线上网卡号码分类：0－公众号码、1－集团号码
     */
    /**
     * @param wirelessCardType of NUM_D_NUMINFO : 设置 无线上网卡号码分类：0－公众号码、1－集团号码
     */
    public void setWirelessCardType(String wirelessCardType) {
        this.wirelessCardType = wirelessCardType == null ? null : wirelessCardType.trim();
    }

    /**
     * @return 号码分级
     */
    /**
     * @return NUM_D_NUMINFO.CODE_GRADE : 返回 号码分级
     */
    public Short getCodeGrade() {
        return codeGrade;
    }

    /**
     * @param codeGrade 
	 *            号码分级
     */
    /**
     * @param codeGrade of NUM_D_NUMINFO : 设置 号码分级
     */
    public void setCodeGrade(Short codeGrade) {
        this.codeGrade = codeGrade;
    }

    /**
     * @return 靓号规则限制标识
     */
    /**
     * @return NUM_D_NUMINFO.LIMIT_ID : 返回 靓号规则限制标识
     */
    public Long getLimitId() {
        return limitId;
    }

    /**
     * @param limitId 
	 *            靓号规则限制标识
     */
    /**
     * @param limitId of NUM_D_NUMINFO : 设置 靓号规则限制标识
     */
    public void setLimitId(Long limitId) {
        this.limitId = limitId;
    }

    /**
     * @return 靓号规则
     */
    /**
     * @return NUM_D_NUMINFO.NICE_RULE : 返回 靓号规则
     */
    public String getNiceRule() {
        return niceRule;
    }

    /**
     * @param niceRule 
	 *            靓号规则
     */
    /**
     * @param niceRule of NUM_D_NUMINFO : 设置 靓号规则
     */
    public void setNiceRule(String niceRule) {
        this.niceRule = niceRule == null ? null : niceRule.trim();
    }

    /**
     * @return 靓号费用
     */
    /**
     * @return NUM_D_NUMINFO.NICE_FEE : 返回 靓号费用
     */
    public Long getNiceFee() {
        return niceFee;
    }

    /**
     * @param niceFee 
	 *            靓号费用
     */
    /**
     * @param niceFee of NUM_D_NUMINFO : 设置 靓号费用
     */
    public void setNiceFee(Long niceFee) {
        this.niceFee = niceFee;
    }

    /**
     * @return 归属省分
     */
    /**
     * @return NUM_D_NUMINFO.PROVINCE_CODE : 返回 归属省分
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode 
	 *            归属省分
     */
    /**
     * @param provinceCode of NUM_D_NUMINFO : 设置 归属省分
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * @return 归属地州
     */
    /**
     * @return NUM_D_NUMINFO.EPARCHY_CODE : 返回 归属地州
     */
    public String getEparchyCode() {
        return eparchyCode;
    }

    /**
     * @param eparchyCode 
	 *            归属地州
     */
    /**
     * @param eparchyCode of NUM_D_NUMINFO : 设置 归属地州
     */
    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode == null ? null : eparchyCode.trim();
    }

    /**
     * @return 归属区县
     */
    /**
     * @return NUM_D_NUMINFO.CITY_CODE : 返回 归属区县
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode 
	 *            归属区县
     */
    /**
     * @param cityCode of NUM_D_NUMINFO : 设置 归属区县
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return 归属部门
     */
    /**
     * @return NUM_D_NUMINFO.DEPART_ID : 返回 归属部门
     */
    public String getDepartId() {
        return departId;
    }

    /**
     * @param departId 
	 *            归属部门
     */
    /**
     * @param departId of NUM_D_NUMINFO : 设置 归属部门
     */
    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    /**
     * @return 归属渠道
     */
    /**
     * @return NUM_D_NUMINFO.CHANNEL_ID : 返回 归属渠道
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @param channelId 
	 *            归属渠道
     */
    /**
     * @param channelId of NUM_D_NUMINFO : 设置 归属渠道
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * @return 归属员工
     */
    /**
     * @return NUM_D_NUMINFO.STAFF_ID : 返回 归属员工
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 
	 *            归属员工
     */
    /**
     * @param staffId of NUM_D_NUMINFO : 设置 归属员工
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    /**
     * @return 入库批次
     */
    /**
     * @return NUM_D_NUMINFO.BATCH_ID : 返回 入库批次
     */
    public Long getBatchId() {
        return batchId;
    }

    /**
     * @param batchId 
	 *            入库批次
     */
    /**
     * @param batchId of NUM_D_NUMINFO : 设置 入库批次
     */
    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    /**
     * @return 入库员工
     */
    /**
     * @return NUM_D_NUMINFO.STAFF_IN : 返回 入库员工
     */
    public String getStaffIn() {
        return staffIn;
    }

    /**
     * @param staffIn 
	 *            入库员工
     */
    /**
     * @param staffIn of NUM_D_NUMINFO : 设置 入库员工
     */
    public void setStaffIn(String staffIn) {
        this.staffIn = staffIn == null ? null : staffIn.trim();
    }

    /**
     * @return 入库时间
     */
    /**
     * @return NUM_D_NUMINFO.TIME_IN : 返回 入库时间
     */
    public Date getTimeIn() {
        return timeIn;
    }

    /**
     * @param timeIn 
	 *            入库时间
     */
    /**
     * @param timeIn of NUM_D_NUMINFO : 设置 入库时间
     */
    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * @return 冗余字段1
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE1 : 返回 冗余字段1
     */
    public String getRsvalue1() {
        return rsvalue1;
    }

    /**
     * @param rsvalue1 
	 *            冗余字段1
     */
    /**
     * @param rsvalue1 of NUM_D_NUMINFO : 设置 冗余字段1
     */
    public void setRsvalue1(String rsvalue1) {
        this.rsvalue1 = rsvalue1 == null ? null : rsvalue1.trim();
    }

    /**
     * @return 冗余字段2
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE2 : 返回 冗余字段2
     */
    public String getRsvalue2() {
        return rsvalue2;
    }

    /**
     * @param rsvalue2 
	 *            冗余字段2
     */
    /**
     * @param rsvalue2 of NUM_D_NUMINFO : 设置 冗余字段2
     */
    public void setRsvalue2(String rsvalue2) {
        this.rsvalue2 = rsvalue2 == null ? null : rsvalue2.trim();
    }

    /**
     * @return 冗余字段3
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE3 : 返回 冗余字段3
     */
    public String getRsvalue3() {
        return rsvalue3;
    }

    /**
     * @param rsvalue3 
	 *            冗余字段3
     */
    /**
     * @param rsvalue3 of NUM_D_NUMINFO : 设置 冗余字段3
     */
    public void setRsvalue3(String rsvalue3) {
        this.rsvalue3 = rsvalue3 == null ? null : rsvalue3.trim();
    }

    /**
     * @return 冗余字段4
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE4 : 返回 冗余字段4
     */
    public String getRsvalue4() {
        return rsvalue4;
    }

    /**
     * @param rsvalue4 
	 *            冗余字段4
     */
    /**
     * @param rsvalue4 of NUM_D_NUMINFO : 设置 冗余字段4
     */
    public void setRsvalue4(String rsvalue4) {
        this.rsvalue4 = rsvalue4 == null ? null : rsvalue4.trim();
    }

    /**
     * @return 冗余字段5
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE5 : 返回 冗余字段5
     */
    public String getRsvalue5() {
        return rsvalue5;
    }

    /**
     * @param rsvalue5 
	 *            冗余字段5
     */
    /**
     * @param rsvalue5 of NUM_D_NUMINFO : 设置 冗余字段5
     */
    public void setRsvalue5(String rsvalue5) {
        this.rsvalue5 = rsvalue5 == null ? null : rsvalue5.trim();
    }

    /**
     * @return 冗余字段6
     */
    /**
     * @return NUM_D_NUMINFO.RSVALUE6 : 返回 冗余字段6
     */
    public String getRsvalue6() {
        return rsvalue6;
    }

    /**
     * @param rsvalue6 
	 *            冗余字段6
     */
    /**
     * @param rsvalue6 of NUM_D_NUMINFO : 设置 冗余字段6
     */
    public void setRsvalue6(String rsvalue6) {
        this.rsvalue6 = rsvalue6 == null ? null : rsvalue6.trim();
    }
}