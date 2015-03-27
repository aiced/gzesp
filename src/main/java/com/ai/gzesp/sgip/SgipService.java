package com.ai.gzesp.sgip;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.huawei.insa2.comm.sgip.message.SGIPMessage;
import com.huawei.insa2.comm.sgip.message.SGIPSubmitMessage;
import com.huawei.insa2.comm.sgip.message.SGIPSubmitRepMessage;
import com.huawei.insa2.util.Args;
import com.huawei.smproxy.SGIPSMProxy;

/**
 * 联通sgip短信发送服务类，使用华为的smproxy包<br>
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class SgipService {

    private Logger log = Logger.getLogger(this.getClass());

    /**
     * 功能描述: 发送短信至联通短信平台<br>
     * 〈功能详细描述〉
     *
     * @param numbers
     * @param content
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean smsSend(String[] numbers, String content) {
        log.debug("【短信：调用短信发送接口开始......手机号：" + numbers[0] + "，内容：" + content + "】");
        //String[] UserNumber = { "8618686619970","8618686619977"};
        //Args argstr = SgipConfig.getArgs(); // 获取sgip配置参数
        //int srcnode =new BigInteger("3085173112").intValue();    //源节点编号，这一步非常重要，华为包中，该字段类型为int，而接入协议中要求在企业代码前加上30000，这样就超过了int的取值范围，所以需要用BigInteger转一下就可以了
        //argstr.set("source-addr",  srcnode); // SP…ID(最大为六位字符)
        Args argstr = new Args();
        argstr.set("host", SgipConfig.host);
        argstr.set("port", SgipConfig.port);
        argstr.set("transaction-timeout", SgipConfig.transaction_timeout); // 操作超时时间(单位：秒)
        argstr.set("read-timeout", SgipConfig.read_timeout); // 物理连接读操作超时时间(单位：秒)
        argstr.set("source-addr",  SgipConfig.source_addr); // SP…ID(最大为六位字符)
        argstr.set("login-name", SgipConfig.login_Name);
        argstr.set("login-pass", SgipConfig.login_PassWord);
        argstr.set("debug", SgipConfig.debug);
        
        SGIPSMProxy sgipsmproxy = new SGIPSMProxy(argstr);
        
        boolean connectSuccess = getConnect(sgipsmproxy); // 连接登陆
        
        //登陆成功才执行发送消息
        if(connectSuccess){
            byte[] MessageContent = null;
            try {
                MessageContent = content.getBytes("GB2312");
                log.debug("【短信：短信内容转换成byte[]成功】");
            } catch (UnsupportedEncodingException e) {
                log.debug("【短信：短信内容转换gb2312失败】");
                e.printStackTrace();
            }
            //提交短信到联通在信平台
            boolean status = submitMsg(sgipsmproxy, numbers, MessageContent);
            return status;
        }
        
        //断开连接
        disConnect(sgipsmproxy);
        //连接登陆失败则直接返回false
        return connectSuccess;

    }

    private boolean getConnect(SGIPSMProxy sgipsmproxy) {
        
        try {
            // connect表示向SMG登陆,登录名与密码分别是SMG向SP分配的用户名与密码,调用这个接口方法，向SMG发送Bind命令消息。
            // 如果发送消息超时或通信异常则抛出异常，需要调用者捕获处理。
            // 登陆得到true和false
            log.debug("【短信：开始连接登陆......】");
            boolean reslut = sgipsmproxy.connect(SgipConfig.login_Name, SgipConfig.login_PassWord);
            
            if (reslut) {
                log.debug("【短信：登陆联通短信平台成功:" +SgipConfig.login_Name + ", " + SgipConfig.login_PassWord +"】");
                return true;
            } else {
                log.debug("【短信：登陆联通短信平台失败】【用户名或密码错误:" + SgipConfig.login_Name + ", " + SgipConfig.login_PassWord +"】");
                return false;
            }
        } catch (Exception ex) {
            log.debug("【短信：登陆联通短信平台失败】【网络异常】 ");
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean submitMsg(SGIPSMProxy sgipsmproxy, String[] numbers, byte[] messageContent){
        //String ChargeNumber = "000000000000000000000"; // 计费号码，我们是白名单
        //String serviceType = "JXHD";//服务类型
        // 上行短息
        SGIPSubmitMessage sgipsubmit = new SGIPSubmitMessage(
                SgipConfig.SPNumber, // SP的接入号码 
                SgipConfig.ChargeNumber, // 付费号码 string
                numbers, // 接收该短消息的手机号，最多100个号码 string[]
                SgipConfig.CorpId, // 企业代码，取值范围为0～99999 string
                SgipConfig.ServiceType, // 业务代码，由SP定义 stirng
                03, // 计费类型 int
                "0", // 该条短消息的收费值 stirng
                "0", // 赠送用户的话费 string
                0, // 代收费标志0：应收1：实收 int
                0, // 引起MT消息的原因 int
                6, // 优先级0～9从低 到高，默认为0 int
                null, // 短消息寿命的终止时间 date
                null, // 短消息定时发送的时间 date
                1, // 状态报告标记 int
                0, // GSM协议类型 int
                0, // GSM协议类型 int
                15, // 短消息的编码格式 int
                0, // 信息类型 int
                messageContent.length, // 短消息内容长度 int
                messageContent, // 短消息的内容 btye[]
                "0" // 保留，扩展用 string
                );
        
        //发送短信，并收到响应消息
        SGIPMessage msg = null;
        try {
            log.debug("【短信：短信发送submit开始......】");
            msg = sgipsmproxy.send(sgipsubmit);
            log.debug("【短信：短信发送submit结束并且收到响应msg】");
        } catch (IOException e) {
            log.debug("【短信：短信发送submit失败】【IOException】 ");
            e.printStackTrace();
        }
        //收到的响应消息转换成rep
        boolean status = processSubmitRep(msg);
        return status;
    }

    private boolean processSubmitRep(SGIPMessage msg) {
        log.debug("【短信：收到响应msg后开始解析响应状态......】");
        // 收到的响应消息转换成repMsg
        SGIPSubmitRepMessage repMsg = (SGIPSubmitRepMessage) msg;
        //System.out.println(repMsg.getSrcNodeId());
        //System.out.println("status:::::::" + repMsg.getResult());
        if (repMsg != null && repMsg.getResult() == 0) {
            log.debug("【短信：短信发送成功,msg响应状态】" + repMsg.getResult());
            return true;
        }
        else {
            log.debug("【短信：短信发送失败，msg响应状态】" + repMsg.getResult());
            return false;
            
        }
    }
    
    private void disConnect(SGIPSMProxy sgipsmproxy){
        //断开连接
        sgipsmproxy.close();
        log.debug("【短信：断开连接】");
    }
}
