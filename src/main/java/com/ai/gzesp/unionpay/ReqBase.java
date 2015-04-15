package com.ai.gzesp.unionpay;

/**
 *  银联接口请求基类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ReqBase {
    
    /**
     * 参数编码方式，推荐用gbk
     */
    private String charCode;
    
    /**
     * 接口版本号（2.0.1）
     */
    private String Version;
    
    /**
     * 交易类型
     */
    private String TradeType;   
    
    /**
     * 发送渠道号
     */
    private String ChannelID;  
    
    /**
     * 商户类型（填01表示直连，填02表示转接）
     */
    private String MerType;  
    
    /**
     * 前置平台获批后分配的商户身份ID
     */
    private String bmMerId;  
    
    /**
     * 时间戳，当前接口调用时间，具体格式: yyyyMMddHHmmss
     */
    private String timeStamp; 
    
    /**
     * 受卡方系统跟踪号，作为对应请求交易的编号
     */
    private String sysTradeNo;  

    /**
     * 加密后的摘要
     */
    private String md5ConSec;

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getTradeType() {
        return TradeType;
    }

    public void setTradeType(String tradeType) {
        TradeType = tradeType;
    }

    public String getChannelID() {
        return ChannelID;
    }

    public void setChannelID(String channelID) {
        ChannelID = channelID;
    }

    public String getMerType() {
        return MerType;
    }

    public void setMerType(String merType) {
        MerType = merType;
    }

    public String getBmMerId() {
        return bmMerId;
    }

    public void setBmMerId(String bmMerId) {
        this.bmMerId = bmMerId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSysTradeNo() {
        return sysTradeNo;
    }

    public void setSysTradeNo(String sysTradeNo) {
        this.sysTradeNo = sysTradeNo;
    }

    public String getMd5ConSec() {
        return md5ConSec;
    }

    public void setMd5ConSec(String md5ConSec) {
        this.md5ConSec = md5ConSec;
    }  
    
}
