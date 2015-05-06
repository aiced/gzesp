package com.ai.gzesp.sgip;

//import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
//import com.huawei.insa2.comm.sgip.message.SGIPMessage;
//import com.huawei.insa2.comm.sgip.message.SGIPSubmitMessage;
//import com.huawei.insa2.comm.sgip.message.SGIPSubmitRepMessage;
//import com.huawei.insa2.util.Args;
//import com.huawei.smproxy.SGIPSMProxy;

/**
 * 短信上行：esp系统发送内容给联通短信中心<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Mt {

/*    private static String SPNumber = "1065579112";//接入号码
    private static String ChargeNumber = "000000000000000000000"; // 计费号码，我们是白名单
    private static String ServiceType = "JXHD";//服务类型
    private static String host = "192.168.88.156"; // 主机名，网关IP
    private static int port = 8801; // 端口号，这里特别注意下，接入协议中写的是8804，害得我调了很久，后来才知道改了，所以，这个在接入前，建议与网关人员确定
    private static String CorpId = "52322"; // 企业代码
    private static String login_Name = "fslt"; // 登陆名
    private static String login_PassWord = "fslt"; // 登陆密码

    public static void main(String[] args) throws UnsupportedEncodingException {
        int srcnode =new BigInteger("82322").intValue();    //源节点编号，这一步非常重要，华为包中，该字段类型为int，而接入协议中要求在企业代码前加上30000，这样就超过了int的取值范围，所以需要用BigInteger转一下就可以了
        Args argstr = new Args();
        argstr.set("host", host);
        argstr.set("port", port);
        argstr.set("transaction-timeout", 10); // 操作超时时间(单位：秒)
        argstr.set("read-timeout", 15); // 物理连接读操作超时时间(单位：秒)
        argstr.set("source-addr",  srcnode); // SP…ID(最大为六位字符)
        argstr.set("login-name", login_Name);
        argstr.set("login-pass", login_PassWord);
        argstr.set("debug", "false");
        
        // 连接登陆
        SGIPSMProxy sgipsmp = new SGIPSMProxy(argstr); // 这里
        try {
            //connect表示向SMG登陆,登录名与密码分别是SMG向SP分配的用户名与密码,调用这个接口方法，向SMG发送Bind命令消息。
            //如果发送消息超时或通信异常则抛出异常，需要调用者捕获处理。
            boolean reslut = sgipsmp.connect(login_Name, login_PassWord); // 登陆得到true和false

            if (reslut) {
                System.out.println("连接成功...........");
            } else {
                System.out.println("连接失败(用户名或密码错误)...........");
                return;
            }
        } catch (Exception ex) {
            System.out.println("网络异常...........");
            ex.printStackTrace();
            return;
        }

        String[] UserNumber = { "8618686619970","8618686619977"};//接收短信的手机号码，前边要加上86

        String content = "抚松联通家校互动项目已成功启动，发送一个测试信息给您！";
        byte[] MessageContent = content.getBytes("GB2312");

        try {
            // 下发短息
            SGIPSubmitMessage sgipsubmit = new SGIPSubmitMessage(
                    SPNumber, // SP的接入号码
                    ChargeNumber, // 付费号码 string
                    UserNumber, // 接收该短消息的手机号，最多100个号码 string[]
                    CorpId, // 企业代码，取值范围为0～99999 string
                    ServiceType, // 业务代码，由SP定义 stirng
                    03, // 计费类型 int
                    "0", // 该条短消息的收费值 stirng
                    "0", // 赠送用户的话费 string
                    0, // 代收费标志0：应收1：实收 int
                    0, // 引起MT消息的原因 int
                    06, // 优先级0～9从低 到高，默认为0 int
                    null, // 短消息寿命的终止时间 date
                    null, // 短消息定时发送的时间 date
                    1, // 状态报告标记 int
                    0, // GSM协议类型 int
                    0, // GSM协议类型 int
                    15, // 短消息的编码格式 int
                    0, // 信息类型 int
                    MessageContent.length, // 短消息内容长度 int
                    MessageContent, // 短消息的内容 btye[]
                    "0" // 保留，扩展用 string
            );
            // 收到的响应消息转换成rep
            int status = ProcessSubmitRep(sgipsmp.send(sgipsubmit));
            System.out.println(status);
            if (status == 0) {
                System.out.println("消息发送成功..........");
            } else {
                System.out.println("消息发送失败..........");
            }
        } catch (Exception ex) {
            ex.printStackTrace();            
        }

    }

    private static int ProcessSubmitRep(SGIPMessage msg) {
        // 收到的响应消息转换成repMsg
        SGIPSubmitRepMessage repMsg = (SGIPSubmitRepMessage) msg;
        System.out.println(repMsg.getSrcNodeId());
        System.out.println("status:::::::" + repMsg.getResult());
        if (repMsg != null && repMsg.getResult() == 0) {
            System.out.println("发送成功：：：");
        }
        return repMsg.getResult();
    }*/

}