package com.ai.gzesp.unionpay;

/**
 * 1.1  银行卡绑定 接口请求<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ReqBind extends ReqBase {

    /**
     * 银行卡号
     */
    private String accNo;
    
    /**
     * CVN2
     */
    private String cvn2; 
    
    /**
     * 交易货币代码（156）
     */
    private String currencyCode; 
    
    /**
     * 手机号
     */
    private String Nbr; 
    
    /**
     * 姓名
     */
    private String Name; 
    
    /**
     * 身份证号
     */
    private String certificateCode; 
    
    /**
     * 有效期
     */
    private String expireDate; 
    
    /**
     * 卡类型（信用卡:01或借记卡:02）
     */
    private String cardType;

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getNbr() {
        return Nbr;
    }

    public void setNbr(String nbr) {
        Nbr = nbr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    } 
    
    
}
