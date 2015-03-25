package com.ai.gzesp.sgip;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.huawei.insa2.util.Args;
import com.huawei.insa2.util.Cfg;

public class SgipConfig {
    
    public static String host = "58.16.249.70"; // 主机名，网关IP
    public static int port = 8801; // 端口号，这里特别注意下，接入协议中写的是8804，害得我调了很久，后来才知道改了，所以，这个在接入前，建议与网关人员确定
    public static String SPNumber = "10655717";//接入号码
    public static String ChargeNumber = "000000000000000000000"; // 计费号码，我们是白名单
    public static String ServiceType = "ESP";//业务代码，由SP定义，字符
    public static String CorpId = "73112"; // 企业代码
    public static String login_Name = "aiced"; // 登陆名
    public static String login_PassWord = "aiced1234"; // 登陆密码
    public static String source_addr = "3085173112"; 
    public static int transaction_timeout = 10; 
    public static int read_timeout = 15;
    public static String debug =  "true";
    public static int version = 1;
    
/*    private static Logger log = Logger.getLogger(SgipConfig.class);

    *//**
     * sgip链接参数
     *//*
    private static Args args;
    
    static {
        try {
            String thisPath = SgipConfig.class.getResource("").getPath();
            //URI uri = new URI(thisPath);
            //URL url = uri.toURL();
            args = new Cfg("file:///" + thisPath + "sgip_cfg.xml").getArgs("SGIPConnect");
        } catch (IOException e) {
            log.debug("【读取短信配置文件sgip_cfg.xml失败IOException】");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            log.debug("【读取短信配置文件sgip_cfg.xml失败URISyntaxException】");
            e.printStackTrace();
        }
    }

    public static Args getArgs() {
        return args;
    }*/
    
    
}
