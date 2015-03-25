package com.ai.gzesp.sgip;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
        //String[] UserNumber = { "8618686619970","8618686619977"};
        Args argstr = SgipConfig.getArgs(); // 获取sgip配置参数
        SGIPSMProxy sgipsmproxy = new SGIPSMProxy(argstr);
        
        boolean connectSuccess = getConnect(sgipsmproxy, argstr); // 连接登陆
        
        //登陆成功才执行发送消息
        if(connectSuccess){
            byte[] MessageContent = null;
            try {
                MessageContent = content.getBytes("GB2312");
            } catch (UnsupportedEncodingException e) {
                log.debug("【短信内容转换gb2312失败】");
                e.printStackTrace();
            }
            //提交短信到联通在信平台
            boolean status = submitMsg(sgipsmproxy, argstr, numbers, MessageContent);
            return status;
        }
        
        //连接登陆失败则直接返回false
        return false;

    }

    private boolean getConnect(SGIPSMProxy sgipsmproxy, Args argstr) {
        
        try {
            // connect表示向SMG登陆,登录名与密码分别是SMG向SP分配的用户名与密码,调用这个接口方法，向SMG发送Bind命令消息。
            // 如果发送消息超时或通信异常则抛出异常，需要调用者捕获处理。
            // 登陆得到true和false
            boolean reslut = sgipsmproxy.connect(argstr.get("login-name", ""), argstr.get("login-pass", ""));

            if (reslut) {
                log.debug("【登陆联通短信平台成功:" +argstr.get("login-name", "") + ", " + argstr.get("login-pass", "") +"】");
                return true;
            } else {
                log.debug("【登陆联通短信平台失败】【用户名或密码错误:" +argstr.get("login-name", "") + ", " + argstr.get("login-pass", "") +"】");
                return false;
            }
        } catch (Exception ex) {
            log.debug("【登陆联通短信平台失败】【网络异常】 ");
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean submitMsg(SGIPSMProxy sgipsmproxy, Args argstr, String[] numbers, byte[] messageContent){
        //String ChargeNumber = "000000000000000000000"; // 计费号码，我们是白名单
        //String serviceType = "JXHD";//服务类型
        // 上行短息
        SGIPSubmitMessage sgipsubmit = new SGIPSubmitMessage(
                argstr.get("SPNumber", ""), // SP的接入号码 
                argstr.get("ChargeNumber", ""), // 付费号码 string
                numbers, // 接收该短消息的手机号，最多100个号码 string[]
                argstr.get("CorpId", ""), // 企业代码，取值范围为0～99999 string
                argstr.get("ServiceType", ""), // 业务代码，由SP定义 stirng
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
            msg = sgipsmproxy.send(sgipsubmit);
        } catch (IOException e) {
            log.debug("【短信发送submit失败】【IOException】 ");
            e.printStackTrace();
        }
        //收到的响应消息转换成rep
        boolean status = processSubmitRep(msg);
        return status;
    }

    private boolean processSubmitRep(SGIPMessage msg) {
        // 收到的响应消息转换成repMsg
        SGIPSubmitRepMessage repMsg = (SGIPSubmitRepMessage) msg;
        //System.out.println(repMsg.getSrcNodeId());
        //System.out.println("status:::::::" + repMsg.getResult());
        if (repMsg != null && repMsg.getResult() == 0) {
            log.debug("【短信发送成功,状态】" + repMsg.getResult());
            return true;
        }
        else {
            log.debug("【短信发送失败，状态】" + repMsg.getResult());
            return false;
            
        }
    }
}
