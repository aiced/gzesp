package com.ai.gzesp.unionpay;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestReq {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("192.168.1.109", 8035);
            byte[] heart = new byte[4];
            heart = String.valueOf("0000").getBytes("GBK");
            OutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());
            out.write(heart); //发送报文
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
