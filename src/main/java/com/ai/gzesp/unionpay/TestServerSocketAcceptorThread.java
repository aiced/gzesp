package com.ai.gzesp.unionpay;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * 心跳线程，维持和银联服务器的长连接<br>
 * mina自带的心跳必须设置响应超时时间，超时会自动断开和银联的链接， 但银联对心跳不做处理也不返回报文，所以没法维持长连接，所以只能搞个线程循环维持心跳 esp需要有断连重试机制，保证一方宕机或者网络闪断后能自动再次连上
 * 启动线程过程中，或者任意一次发送心跳时有异常，则要不停进行重试连接，否则就需要重启esp应用才能再次启动心跳线程
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestServerSocketAcceptorThread implements Runnable {
    private static Logger log = Logger.getLogger(TestServerSocketAcceptorThread.class);
    
    private static ServerSocket serverSocket ;
    
    private Socket recvSocket;
    
    private static InputStream in;
    
    
    public void run()
    {
        
        try {
            serverSocket = new ServerSocket(8035);
            log.debug("【银联支付：esp开启serversocket服务端监听成功】");
            
            while(true){
                Socket recvSocket = serverSocket.accept();
                in = new BufferedInputStream(
                        recvSocket.getInputStream());
                log.debug("【银联支付：esp收到银联报文】" + in.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 


}
