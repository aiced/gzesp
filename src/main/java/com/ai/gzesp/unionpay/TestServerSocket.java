package com.ai.gzesp.unionpay;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class TestServerSocket {
    private static Logger log = Logger.getLogger(TestServerSocket.class);
    
    private static ServerSocket serverSocket ;
    
    private Socket recvSocket;
    
    private static InputStream in;
    
    public void init(){
        TestServerSocketAcceptorThread thread = new TestServerSocketAcceptorThread();
        Thread t = new Thread(thread);
        t.start();
    }

}
