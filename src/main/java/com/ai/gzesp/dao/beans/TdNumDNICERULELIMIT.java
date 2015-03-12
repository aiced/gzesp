package com.ai.gzesp.dao.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 入库时匹配相应的靓号规则，主要针对号码，匹配对应的：预存费用、级别、最低消费等级、品牌、产品、靓号规则编码、优先级
 */
/**
 * @ClassName: TdNumDNICERULELIMIT
* @Description: NUM_D_NICERULE_LIMIT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdNumDNICERULELIMIT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 靓号规则限制标识
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.LIMIT_ID :靓号规则限制标识
     */
    private Long limitId;

    /**
     * 用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.NICE_RULE :用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    private Integer niceRule;

    /**
     * 网别编码：01-3G、02-2G、03-4G
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.NET_TYPE_CODE :网别编码：01-3G、02-2G、03-4G
     */
    private String netTypeCode;

    /**
     * 业务类型<br>
	 * 0－个人业务；1－集团业务
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.TRADE_CATE :业务类型
0－个人业务；1－集团业务
     */
    private String tradeCate;

    /**
     * 此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.CODE_GRADE :此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    private Short codeGrade;

    /**
     * 优先级
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.PRIORITY :优先级
     */
    private Short priority;

    /**
     * 限制状态：0－待匹配、1－已匹配
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.LIMIT_STATE :限制状态：0－待匹配、1－已匹配
     */
    private String limitState;

    /**
     * 限制类型<br>
	 * 1－按消费等级(对应靓号消费等级参数表中的rank_money)<br>
	 * 2－按产品(对应靓号规则产品选择表中的产品)
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.LIMIT_TYPE :限制类型
1－按消费等级(对应靓号消费等级参数表中的rank_money)
2－按产品(对应靓号规则产品选择表中的产品)
     */
    private String limitType;

    /**
     * 匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RANK_MONEY_S :匹配对应产品表中的RANK_MONEY字段
     */
    private Integer rankMoneyS;

    /**
     * 匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RANK_MONEY_E :匹配对应产品表中的RANK_MONEY字段
     */
    private Integer rankMoneyE;

    /**
     * 在网时长（月数）
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.MONTH_LIMIT :在网时长（月数）
     */
    private Short monthLimit;

    /**
     * 首次预存话费（不低于）
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.ADVANCE_LIMIT :首次预存话费（不低于）
     */
    private Long advanceLimit;

    /**
     * 每月最低消费要求
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.MONTHFEE_LIMIT :每月最低消费要求
     */
    private Long monthfeeLimit;

    /**
     * 仓库所属业务区编码
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.AREA_CODE :仓库所属业务区编码
     */
    private String areaCode;

    /**
     * 仓库所属地市编码
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.EPARCHY_CODE :仓库所属地市编码
     */
    private String eparchyCode;

    /**
     * 仓库所属省份编码
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.PROVINCE_ID :仓库所属省份编码
     */
    private String provinceId;

    /**
     * 生效时间
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.START_DATE :生效时间
     */
    private Date startDate;

    /**
     * 失效时间
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.END_DATE :失效时间
     */
    private Date endDate;

    /**
     * 更新部门
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.UPDATE_DEPART_ID :更新部门
     */
    private String updateDepartId;

    /**
     * 更新员工
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.UPDATE_STAFF_ID :更新员工
     */
    private String updateStaffId;

    /**
     * 更新时间
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.UPDATE_TIME :更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.REMARK :备注
     */
    private String remark;

    /**
     * 冗余字段1
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE1 :冗余字段1
     */
    private String rsvalue1;

    /**
     * 冗余字段2
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE2 :冗余字段2
     */
    private String rsvalue2;

    /**
     * 冗余字段3
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE3 :冗余字段3
     */
    private String rsvalue3;

    /**
     * 冗余字段4
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE4 :冗余字段4
     */
    private String rsvalue4;

    /**
     * 冗余字段5
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE5 :冗余字段5
     */
    private String rsvalue5;

    /**
     * 冗余字段6
     */
    /**
     * @Fields NUM_D_NICERULE_LIMIT.RSVALUE6 :冗余字段6
     */
    private String rsvalue6;

    /**
     * @return 靓号规则限制标识
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.LIMIT_ID : 返回 靓号规则限制标识
     */
    public Long getLimitId() {
        return limitId;
    }

    /**
     * @param limitId 
	 *            靓号规则限制标识
     */
    /**
     * @param limitId of NUM_D_NICERULE_LIMIT : 设置 靓号规则限制标识
     */
    public void setLimitId(Long limitId) {
        this.limitId = limitId;
    }

    /**
     * @return 用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.NICE_RULE : 返回 用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    public Integer getNiceRule() {
        return niceRule;
    }

    /**
     * @param niceRule 
	 *            用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    /**
     * @param niceRule of NUM_D_NICERULE_LIMIT : 设置 用途，用来区分用途，例如，0-普通营业员可用，1-营业班长可用等等，可以和岗位挂钩
     */
    public void setNiceRule(Integer niceRule) {
        this.niceRule = niceRule;
    }

    /**
     * @return 网别编码：01-3G、02-2G、03-4G
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.NET_TYPE_CODE : 返回 网别编码：01-3G、02-2G、03-4G
     */
    public String getNetTypeCode() {
        return netTypeCode;
    }

    /**
     * @param netTypeCode 
	 *            网别编码：01-3G、02-2G、03-4G
     */
    /**
     * @param netTypeCode of NUM_D_NICERULE_LIMIT : 设置 网别编码：01-3G、02-2G、03-4G
     */
    public void setNetTypeCode(String netTypeCode) {
        this.netTypeCode = netTypeCode == null ? null : netTypeCode.trim();
    }

    /**
     * @return 业务类型<br>
	 *         0－个人业务；1－集团业务
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.TRADE_CATE : 返回 业务类型
0－个人业务；1－集团业务
     */
    public String getTradeCate() {
        return tradeCate;
    }

    /**
     * @param tradeCate 
	 *            业务类型<br>
	 *            0－个人业务；1－集团业务
     */
    /**
     * @param tradeCate of NUM_D_NICERULE_LIMIT : 设置 业务类型
0－个人业务；1－集团业务
     */
    public void setTradeCate(String tradeCate) {
        this.tradeCate = tradeCate == null ? null : tradeCate.trim();
    }

    /**
     * @return 此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.CODE_GRADE : 返回 此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    public Short getCodeGrade() {
        return codeGrade;
    }

    /**
     * @param codeGrade 
	 *            此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    /**
     * @param codeGrade of NUM_D_NICERULE_LIMIT : 设置 此分级编码为实际分级编码，区分省代码等条件，参数表参看TD_R_CODEGRADE
     */
    public void setCodeGrade(Short codeGrade) {
        this.codeGrade = codeGrade;
    }

    /**
     * @return 优先级
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.PRIORITY : 返回 优先级
     */
    public Short getPriority() {
        return priority;
    }

    /**
     * @param priority 
	 *            优先级
     */
    /**
     * @param priority of NUM_D_NICERULE_LIMIT : 设置 优先级
     */
    public void setPriority(Short priority) {
        this.priority = priority;
    }

    /**
     * @return 限制状态：0－待匹配、1－已匹配
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.LIMIT_STATE : 返回 限制状态：0－待匹配、1－已匹配
     */
    public String getLimitState() {
        return limitState;
    }

    /**
     * @param limitState 
	 *            限制状态：0－待匹配、1－已匹配
     */
    /**
     * @param limitState of NUM_D_NICERULE_LIMIT : 设置 限制状态：0－待匹配、1－已匹配
     */
    public void setLimitState(String limitState) {
        this.limitState = limitState == null ? null : limitState.trim();
    }

    /**
     * @return 限制类型<br>
	 *         1－按消费等级(对应靓号消费等级参数表中的rank_money)<br>
	 *         2－按产品(对应靓号规则产品选择表中的产品)
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.LIMIT_TYPE : 返回 限制类型
1－按消费等级(对应靓号消费等级参数表中的rank_money)
2－按产品(对应靓号规则产品选择表中的产品)
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * @param limitType 
	 *            限制类型<br>
	 *            1－按消费等级(对应靓号消费等级参数表中的rank_money)<br>
	 *            2－按产品(对应靓号规则产品选择表中的产品)
     */
    /**
     * @param limitType of NUM_D_NICERULE_LIMIT : 设置 限制类型
1－按消费等级(对应靓号消费等级参数表中的rank_money)
2－按产品(对应靓号规则产品选择表中的产品)
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    /**
     * @return 匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RANK_MONEY_S : 返回 匹配对应产品表中的RANK_MONEY字段
     */
    public Integer getRankMoneyS() {
        return rankMoneyS;
    }

    /**
     * @param rankMoneyS 
	 *            匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @param rankMoneyS of NUM_D_NICERULE_LIMIT : 设置 匹配对应产品表中的RANK_MONEY字段
     */
    public void setRankMoneyS(Integer rankMoneyS) {
        this.rankMoneyS = rankMoneyS;
    }

    /**
     * @return 匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RANK_MONEY_E : 返回 匹配对应产品表中的RANK_MONEY字段
     */
    public Integer getRankMoneyE() {
        return rankMoneyE;
    }

    /**
     * @param rankMoneyE 
	 *            匹配对应产品表中的RANK_MONEY字段
     */
    /**
     * @param rankMoneyE of NUM_D_NICERULE_LIMIT : 设置 匹配对应产品表中的RANK_MONEY字段
     */
    public void setRankMoneyE(Integer rankMoneyE) {
        this.rankMoneyE = rankMoneyE;
    }

    /**
     * @return 在网时长（月数）
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.MONTH_LIMIT : 返回 在网时长（月数）
     */
    public Short getMonthLimit() {
        return monthLimit;
    }

    /**
     * @param monthLimit 
	 *            在网时长（月数）
     */
    /**
     * @param monthLimit of NUM_D_NICERULE_LIMIT : 设置 在网时长（月数）
     */
    public void setMonthLimit(Short monthLimit) {
        this.monthLimit = monthLimit;
    }

    /**
     * @return 首次预存话费（不低于）
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.ADVANCE_LIMIT : 返回 首次预存话费（不低于）
     */
    public Long getAdvanceLimit() {
        return advanceLimit;
    }

    /**
     * @param advanceLimit 
	 *            首次预存话费（不低于）
     */
    /**
     * @param advanceLimit of NUM_D_NICERULE_LIMIT : 设置 首次预存话费（不低于）
     */
    public void setAdvanceLimit(Long advanceLimit) {
        this.advanceLimit = advanceLimit;
    }

    /**
     * @return 每月最低消费要求
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.MONTHFEE_LIMIT : 返回 每月最低消费要求
     */
    public Long getMonthfeeLimit() {
        return monthfeeLimit;
    }

    /**
     * @param monthfeeLimit 
	 *            每月最低消费要求
     */
    /**
     * @param monthfeeLimit of NUM_D_NICERULE_LIMIT : 设置 每月最低消费要求
     */
    public void setMonthfeeLimit(Long monthfeeLimit) {
        this.monthfeeLimit = monthfeeLimit;
    }

    /**
     * @return 仓库所属业务区编码
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.AREA_CODE : 返回 仓库所属业务区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode 
	 *            仓库所属业务区编码
     */
    /**
     * @param areaCode of NUM_D_NICERULE_LIMIT : 设置 仓库所属业务区编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * @return 仓库所属地市编码
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.EPARCHY_CODE : 返回 仓库所属地市编码
     */
    public String getEparchyCode() {
        return eparchyCode;
    }

    /**
     * @param eparchyCode 
	 *            仓库所属地市编码
     */
    /**
     * @param eparchyCode of NUM_D_NICERULE_LIMIT : 设置 仓库所属地市编码
     */
    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode == null ? null : eparchyCode.trim();
    }

    /**
     * @return 仓库所属省份编码
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.PROVINCE_ID : 返回 仓库所属省份编码
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId 
	 *            仓库所属省份编码
     */
    /**
     * @param provinceId of NUM_D_NICERULE_LIMIT : 设置 仓库所属省份编码
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    /**
     * @return 生效时间
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.START_DATE : 返回 生效时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate 
	 *            生效时间
     */
    /**
     * @param startDate of NUM_D_NICERULE_LIMIT : 设置 生效时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return 失效时间
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.END_DATE : 返回 失效时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate 
	 *            失效时间
     */
    /**
     * @param endDate of NUM_D_NICERULE_LIMIT : 设置 失效时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return 更新部门
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.UPDATE_DEPART_ID : 返回 更新部门
     */
    public String getUpdateDepartId() {
        return updateDepartId;
    }

    /**
     * @param updateDepartId 
	 *            更新部门
     */
    /**
     * @param updateDepartId of NUM_D_NICERULE_LIMIT : 设置 更新部门
     */
    public void setUpdateDepartId(String updateDepartId) {
        this.updateDepartId = updateDepartId == null ? null : updateDepartId.trim();
    }

    /**
     * @return 更新员工
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.UPDATE_STAFF_ID : 返回 更新员工
     */
    public String getUpdateStaffId() {
        return updateStaffId;
    }

    /**
     * @param updateStaffId 
	 *            更新员工
     */
    /**
     * @param updateStaffId of NUM_D_NICERULE_LIMIT : 设置 更新员工
     */
    public void setUpdateStaffId(String updateStaffId) {
        this.updateStaffId = updateStaffId == null ? null : updateStaffId.trim();
    }

    /**
     * @return 更新时间
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.UPDATE_TIME : 返回 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 
	 *            更新时间
     */
    /**
     * @param updateTime of NUM_D_NICERULE_LIMIT : 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 备注
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.REMARK : 返回 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    /**
     * @param remark of NUM_D_NICERULE_LIMIT : 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return 冗余字段1
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE1 : 返回 冗余字段1
     */
    public String getRsvalue1() {
        return rsvalue1;
    }

    /**
     * @param rsvalue1 
	 *            冗余字段1
     */
    /**
     * @param rsvalue1 of NUM_D_NICERULE_LIMIT : 设置 冗余字段1
     */
    public void setRsvalue1(String rsvalue1) {
        this.rsvalue1 = rsvalue1 == null ? null : rsvalue1.trim();
    }

    /**
     * @return 冗余字段2
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE2 : 返回 冗余字段2
     */
    public String getRsvalue2() {
        return rsvalue2;
    }

    /**
     * @param rsvalue2 
	 *            冗余字段2
     */
    /**
     * @param rsvalue2 of NUM_D_NICERULE_LIMIT : 设置 冗余字段2
     */
    public void setRsvalue2(String rsvalue2) {
        this.rsvalue2 = rsvalue2 == null ? null : rsvalue2.trim();
    }

    /**
     * @return 冗余字段3
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE3 : 返回 冗余字段3
     */
    public String getRsvalue3() {
        return rsvalue3;
    }

    /**
     * @param rsvalue3 
	 *            冗余字段3
     */
    /**
     * @param rsvalue3 of NUM_D_NICERULE_LIMIT : 设置 冗余字段3
     */
    public void setRsvalue3(String rsvalue3) {
        this.rsvalue3 = rsvalue3 == null ? null : rsvalue3.trim();
    }

    /**
     * @return 冗余字段4
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE4 : 返回 冗余字段4
     */
    public String getRsvalue4() {
        return rsvalue4;
    }

    /**
     * @param rsvalue4 
	 *            冗余字段4
     */
    /**
     * @param rsvalue4 of NUM_D_NICERULE_LIMIT : 设置 冗余字段4
     */
    public void setRsvalue4(String rsvalue4) {
        this.rsvalue4 = rsvalue4 == null ? null : rsvalue4.trim();
    }

    /**
     * @return 冗余字段5
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE5 : 返回 冗余字段5
     */
    public String getRsvalue5() {
        return rsvalue5;
    }

    /**
     * @param rsvalue5 
	 *            冗余字段5
     */
    /**
     * @param rsvalue5 of NUM_D_NICERULE_LIMIT : 设置 冗余字段5
     */
    public void setRsvalue5(String rsvalue5) {
        this.rsvalue5 = rsvalue5 == null ? null : rsvalue5.trim();
    }

    /**
     * @return 冗余字段6
     */
    /**
     * @return NUM_D_NICERULE_LIMIT.RSVALUE6 : 返回 冗余字段6
     */
    public String getRsvalue6() {
        return rsvalue6;
    }

    /**
     * @param rsvalue6 
	 *            冗余字段6
     */
    /**
     * @param rsvalue6 of NUM_D_NICERULE_LIMIT : 设置 冗余字段6
     */
    public void setRsvalue6(String rsvalue6) {
        this.rsvalue6 = rsvalue6 == null ? null : rsvalue6.trim();
    }
}