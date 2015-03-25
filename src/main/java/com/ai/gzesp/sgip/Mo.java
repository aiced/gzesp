package com.ai.gzesp.sgip;

import com.huawei.insa2.comm.sgip.message.SGIPDeliverMessage;
import com.huawei.insa2.comm.sgip.message.SGIPMessage;
import com.huawei.insa2.comm.sgip.message.SGIPSubmitRepMessage;
import com.huawei.insa2.util.Args;
import com.huawei.smproxy.SGIPSMProxy;

/**
 *  短信下行：联通短信中心发送给esp<br> 
 *  目前不需要下行功能，即esp不接收短信
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Mo extends SGIPSMProxy {

    //SMG服务器信息
    private static String serHost = "192.168.88.156";
    private static int serviceport = 8801;
    
    //本机信息
    private static String localhost = "192.168.88.156";
    private static int localport = 8805;
    
    //private static String login_Name="huanghai";
    //private static String login_PassWord="123456";
    
    public Mo(Args args) {
        super(args);
        System.out.println("进入启动监听........");
        startService(localhost, localport); //我想知道这里传递的host和port是本地的还是那的
    }
    public static void main(String[] args)
    {
        Args argstr = new Args();
        argstr.set("serHost", serHost);
        argstr.set("serviceport", serviceport);
        argstr.set("localhost", localhost);
        argstr.set("localport", localport);
        argstr.set("transaction-timeout", 10); // 操作超时时间(单位：秒)
        argstr.set("read-timeout", 15); // 物理连接读操作超时时间(单位：秒)
        //这里的安全认证问题如何解决?
        
        Mo mymo=new Mo(argstr);        
    }
    /**
     * 收到用户回复的短信(上行)。
     * 
     * @param msg
     *            收到的消息
     * @return 返回的相应消息。
     */
    public SGIPMessage onDeliver(SGIPDeliverMessage msg) {
        /** @todo do some thing to handle this message. then return a response */

        ProcessRecvDeliverMsg(msg);
        System.out.println("正在等待接收.......");
        return super.onDeliver(msg);
    }

    /**
     * 对收到短讯中心下发的短消息的处理。 收到用户信息
     * 
     * @param msg
     *            短讯中心下发的短消息
     */
    public void ProcessRecvDeliverMsg(SGIPMessage msg) {
        if (msg instanceof SGIPSubmitRepMessage) {
            System.out.println("返回下发短信的相应消息");
        }
        if (msg instanceof SGIPDeliverMessage) {
            // 收到用户发送的短信(上行)
            SGIPDeliverMessage deliverMsg = (SGIPDeliverMessage) msg;
            String userNumber = deliverMsg.getUserNumber(); // 手机号码
            String msgContent = deliverMsg.toString(); // 短信内容
            // byte[] msgId = deliverMsg.getMsgContent();
            System.out.println("userNumber::::::" + deliverMsg.getUserNumber());
            System.out.println("msgcontent:::::::" + deliverMsg.toString());
            System.out.println("spNumber::::::::" + deliverMsg.getSPNumber());

            //log.info("收到消息:" + deliverMsg);
            System.out.println("收到消息 ："+deliverMsg);
            
            int commandId = deliverMsg.getCommandId(); // 响应类型
            System.out.println("commandId:::::::::" + commandId);
            if (commandId == 0) { //上传短信（接收）
                System.out.println("dstaddr::::::" + deliverMsg.getSPNumber());
                try {

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
