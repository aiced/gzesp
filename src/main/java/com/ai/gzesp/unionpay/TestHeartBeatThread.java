package com.ai.gzesp.unionpay;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
public class TestHeartBeatThread implements Runnable {
    private static Logger log = Logger.getLogger(TestHeartBeatThread.class);
    
    private static Socket socket;
    
    public TestHeartBeatThread(Socket socket)
    {
      this.socket = socket;
    }
    

    
    public void run()
    {
      log.debug("【银联支付：esp开始心跳。。。】");

      String tip = "循环中。。。";
      int times = 0;

      while (!ClientHandler.stopHeartBeat)
      {
        try
        {
          log.debug("【银联支付：esp心跳，次数:" + tip + "】");

          byte[] heart = new byte[4];
          heart = String.valueOf(UnionPayCons.HEARTBEAT_REQ).getBytes(UnionPayCons.charCode);
          OutputStream out = new BufferedOutputStream(socket.getOutputStream());
          out.write(heart); //发送心跳报文
          log.debug("【银联支付：esp发送心跳报文0000成功，2分钟后again】");
          Thread.sleep(120000L);
        } catch (UnsupportedEncodingException e) {
          log.debug("【银联支付：ERROR！！！esp维持长连接，生成心跳报文异常，5分钟后retry重新尝试连接！！！】");
          e.printStackTrace();
          try {
            Thread.sleep(300000L);
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
          times++; tip = "重试次数 " + times;
        }
        catch (InterruptedException e) {
          log.debug("【银联支付：ERROR！！！esp维持长连接，发送心跳报文异常，5分钟后retry重新尝试连接！！！】");
          e.printStackTrace();
          try {
            Thread.sleep(300000L);
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
          times++; tip = "重试次数 " + times;
        }
        catch (IOException e) {
            log.debug("【银联支付：ERROR！！！  发送心跳时io异常】");
            e.printStackTrace();
        }
        catch (Exception e) {
          log.debug("【银联支付：ERROR！！！esp维持长连接，其他异常，5分钟后retry重新尝试连接！！！】");
          e.printStackTrace();
          try {
            Thread.sleep(300000L);
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
          times++; tip = "重试次数 " + times;
        }
      }
    }
 


}
