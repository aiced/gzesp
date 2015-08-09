package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 能人账户信息表<br>
	 * 每个能人有3个子账户：<br>
	 * 现金可提现账户，<br>
	 * 现金不可提现账户，<br>
	 * 非现金账户
 */
/**
 * @ClassName: TdActDACCOUNT
* @Description: ACT_D_ACCOUNT表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdActDACCOUNT implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 子账户id=能人id+1位序号(序号和账户类型一样)<br>
	 * 能人id+1：现金不可提，<br>
	 * 能人id+2：现金可提，<br>
	 * 能人id+3：非现金<br>
	 * <br>
	 * 
     */
    /**
     * @Fields ACT_D_ACCOUNT.ACCT_ID :子账户id=能人id+1位序号(序号和账户类型一样)
能人id+1：现金不可提，
能人id+2：现金可提，
能人id+3：非现金


     */
    private String acctId;

    /**
     * 能人id
     */
    /**
     * @Fields ACT_D_ACCOUNT.USER_ID :能人id
     */
    private String userId;

    /**
     * 当前余额
     */
    /**
     * @Fields ACT_D_ACCOUNT.BALANCE :当前余额
     */
    private Long balance;

    /**
     * 账户类型：<br>
	 * 1：现金不可提，<br>
	 * 2：现金可提，<br>
	 * 3：非现金
     */
    /**
     * @Fields ACT_D_ACCOUNT.ACCT_TYPE :账户类型：
1：现金不可提，
2：现金可提，
3：非现金
     */
    private String acctType;

    /**
     * 账户状态：<br>
	 * 1：有效<br>
	 * 0：失效
     */
    /**
     * @Fields ACT_D_ACCOUNT.ACCT_STATUS :账户状态：
1：有效
0：失效
     */
    private String acctStatus;

    /**
     * 版本号，8位字符串<br>
	 * 从 00000001 开始到 99999999
     */
    /**
     * @Fields ACT_D_ACCOUNT.VERSION :版本号，8位字符串
从 00000001 开始到 99999999
     */
    private String version;

    /**
     * @return 子账户id=能人id+1位序号(序号和账户类型一样)<br>
	 *         能人id+1：现金不可提，<br>
	 *         能人id+2：现金可提，<br>
	 *         能人id+3：非现金<br>
	 *         <br>
	 *         
     */
    /**
     * @return ACT_D_ACCOUNT.ACCT_ID : 返回 子账户id=能人id+1位序号(序号和账户类型一样)
能人id+1：现金不可提，
能人id+2：现金可提，
能人id+3：非现金


     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * @param acctId 
	 *            子账户id=能人id+1位序号(序号和账户类型一样)<br>
	 *            能人id+1：现金不可提，<br>
	 *            能人id+2：现金可提，<br>
	 *            能人id+3：非现金<br>
	 *            <br>
	 *            
     */
    /**
     * @param acctId of ACT_D_ACCOUNT : 设置 子账户id=能人id+1位序号(序号和账户类型一样)
能人id+1：现金不可提，
能人id+2：现金可提，
能人id+3：非现金


     */
    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    /**
     * @return 能人id
     */
    /**
     * @return ACT_D_ACCOUNT.USER_ID : 返回 能人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            能人id
     */
    /**
     * @param userId of ACT_D_ACCOUNT : 设置 能人id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return 当前余额
     */
    /**
     * @return ACT_D_ACCOUNT.BALANCE : 返回 当前余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * @param balance 
	 *            当前余额
     */
    /**
     * @param balance of ACT_D_ACCOUNT : 设置 当前余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * @return 账户类型：<br>
	 *         1：现金不可提，<br>
	 *         2：现金可提，<br>
	 *         3：非现金
     */
    /**
     * @return ACT_D_ACCOUNT.ACCT_TYPE : 返回 账户类型：
1：现金不可提，
2：现金可提，
3：非现金
     */
    public String getAcctType() {
        return acctType;
    }

    /**
     * @param acctType 
	 *            账户类型：<br>
	 *            1：现金不可提，<br>
	 *            2：现金可提，<br>
	 *            3：非现金
     */
    /**
     * @param acctType of ACT_D_ACCOUNT : 设置 账户类型：
1：现金不可提，
2：现金可提，
3：非现金
     */
    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    /**
     * @return 账户状态：<br>
	 *         1：有效<br>
	 *         0：失效
     */
    /**
     * @return ACT_D_ACCOUNT.ACCT_STATUS : 返回 账户状态：
1：有效
0：失效
     */
    public String getAcctStatus() {
        return acctStatus;
    }

    /**
     * @param acctStatus 
	 *            账户状态：<br>
	 *            1：有效<br>
	 *            0：失效
     */
    /**
     * @param acctStatus of ACT_D_ACCOUNT : 设置 账户状态：
1：有效
0：失效
     */
    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus == null ? null : acctStatus.trim();
    }

    /**
     * @return 版本号，8位字符串<br>
	 *         从 00000001 开始到 99999999
     */
    /**
     * @return ACT_D_ACCOUNT.VERSION : 返回 版本号，8位字符串
从 00000001 开始到 99999999
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version 
	 *            版本号，8位字符串<br>
	 *            从 00000001 开始到 99999999
     */
    /**
     * @param version of ACT_D_ACCOUNT : 设置 版本号，8位字符串
从 00000001 开始到 99999999
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}