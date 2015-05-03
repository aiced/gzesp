package com.ai.gzesp.unionpay;

/**
 * 银联支付接口常量类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnionPayCons {
    
    /**
     * 银联服务端ip
     */
    public static String SERVER_HOST = "58.16.16.10"; // 58.16.16.10  58.16.11.245 127.0.0.1
    
    /**
     * 银联服务端端口
     */
    public static int SERVER_PORT = 10004; //10004  8035
    
    /**
     * 银联接口请求参数:编码方式，推荐用gbk
     */
    public static String charCode = "GBK";    
    
    /**
     * 银联接口请求参数:版本号
     */
    public static String Version = "2.0.1";
    
    /**
     * 银联接口请求参数:发送渠道号
     */
    public static String ChannelID = "7651444882235483";
    
    /**
     * 银联接口请求参数:商户类型 填01表示直连，填02表示转接
     */
    public static String MerType = "01";     
    
    /**
     * 银联接口请求参数:前置平台获批后分配的商户身份ID
     */
    public static String bmMerId = "1000000000009904";    
    
    /**
     * 银联接口请求参数:交易货币代码（156）
     */
    public static String currencyCode = "156";       
    
    /**
     * 银联接口请求参数:支付行业类型
     */
    public static String industryType = "60120851";    
    
    /**
     * 银联接口des加密密钥:，长度为24字节
     */
    public static String desKey = "yvo0sovt414fakqwvchs70b3";   
 
    /**
     * 银联接口md5加密密钥:，长度为32字节，
     * 此秘钥不能随便改，签约表里存放的签约号是通过此秘钥加密的,改了之后解密就不对了
     */
    public static String md5Key = "8396596f6e94b58f03d1cbaa800b2bd0";       
    
    
    /**
     * 心跳发送间隔时间，这边设置2分钟
     */
    public static int HEART_INTERVAL = 2;
    
    /**
     * 心跳包请求后 等待反馈超时时间
     */
    public static int HEART_TIMEOUT = 30;
    
    /**
     * 请求端心跳包内容 
     */
    public static String HEARTBEAT_REQ = "0000";
    
    /**
     * 服务端心跳包内容 
     */
    public static String HEARTBEAT_RESP = "0000";
    
    /**
     * 银联接口调用成功返回00应答码 
     */
    public static String RESULT_CODE_SUCCESS = "00";
    
    /**
     * 银联绑定接口请求发出后，轮询等待结果的间隔时间 毫秒，银联绑定接口返回1-2秒，所以2秒比较合适
     */
    public static int SLEEP_INTERVAL_BIND = 2000;
    
    /**
     * 银联支付接口请求发出后，轮询等待结果的间隔时间 毫秒，银联支付接口要2秒左右才能返回结果，2秒一循环比较合适
     */
    public static int SLEEP_INTERVAL_PAY = 2000;
    
    /**
     * 银联接口请求发出后，轮询等待结果的超时时间 毫秒，银联约定40秒超时
     */
    public static int WAIT_TIMEOUT = 40*1000;

}
