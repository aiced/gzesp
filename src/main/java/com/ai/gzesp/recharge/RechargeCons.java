package com.ai.gzesp.recharge;

/**
 * 一卡充系统接口常量类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RechargeCons {
    
    /**
     * 一卡充系统 主接入服务器ip
     */
    public static String SERVER_1_HOST = "10.34.6.167"; // 测试：135.33.3.180  正式：135.33.3.180 本机：127.0.0.1
    
    /**
     * 一卡充系统 主接入服务器端口
     */
    public static int SERVER_1_PORT = 8001; //测试：8003 正式：8001 
    
    /**
     * 一卡充系统 备接入服务器ip
     */
    public static String SERVER_2_HOST = "127.0.0.1"; // 测试：58.16.16.10  正式：144.180.70.53 本机：127.0.0.1
    
    /**
     * 一卡充系统 备接入服务器端口
     */
    public static int SERVER_2_PORT = 10012; //测试：10004 正式(任选一个连接)：10012 10013

    /**
     * 接入ID
     */
    public static String ID = "011"; //测试：011 正式：011   
    
    
    /**
     * des加密密钥:，密钥长度128位（16个字符）
     */
    public static String desKey = "1234567890123456";  //测试：1234567890123456 正式：e036hlqtculakx38tjw2u9gs

    /**
     * 心跳发送间隔时间
     */
    public static int HEART_INTERVAL = 50*1000;
    
    /**
     * 心跳包请求后 等待反馈超时时间
     */
    public static int HEART_TIMEOUT = 50*1000;
    
    /**
     * 请求端心跳包内容 
     */
    public static String HEARTBEAT_REQ = "GWHEARTBEATTEST";
    
    /**
     * 服务端心跳包内容 
     */
    public static String HEARTBEAT_RESP = "GWHEARTBEATTEST";
    
    /**
     * 接口调用成功返回00000应答码 
     */
    public static String RESULT_CODE_SUCCESS = "00000";
    
    /**
     * 编码方式
     */
    public static String charCode = "utf-8";  
    
    /**
     * 所有数据包前增加”@”为包的开始标志，数据包尾加“0x1a”为包的结束标志
     */
    public static char prefix = '@';
    
    /**
     * 所有数据包前增加”@”为包的开始标志，数据包尾加“0x1a”为包的结束标志
     */
    public static char Suffix = 0x1a;
    
    public static char keyPadChar = 0x0;
    
    /**
     * 一卡充接口请求发出后，轮询等待结果的超时时间 毫秒，一卡充约定10秒超时
     */
    public static int WAIT_TIMEOUT = 10*1000;
    
    /**
     * 一卡充接口请求发出后，轮询等待结果的间隔时间 毫秒，
     */
    public static int SLEEP_INTERVAL_RECHARGE = 1000;

}
