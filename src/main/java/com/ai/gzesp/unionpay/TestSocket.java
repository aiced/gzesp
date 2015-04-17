package com.ai.gzesp.unionpay;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class TestSocket {
    
    private static Logger log = Logger.getLogger(TestSocket.class);
    
    private static Socket clientSocket;
    
    public void init(){
        try {
            clientSocket = new Socket(UnionPayCons.SERVER_HOST, UnionPayCons.SERVER_PORT);
        } catch (IOException e) {
            log.debug("【银联支付：创建 clientSocket 异常】");
            e.printStackTrace();
        }
        
/*        try {
            OutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            log.debug("【银联支付：创建 clientSocket 异常】");
            e.printStackTrace();
        }*/
        
        //启动心跳线程
        TestHeartBeatThread heartThread = new TestHeartBeatThread(clientSocket);
        Thread t = new Thread(heartThread);
        t.start();
    }

}
