package com.ai.gzesp.unionpay;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * 客户端请求端handler<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClientHandler extends IoHandlerAdapter {
    
    private static Logger log = Logger.getLogger(ClientHandler.class); 
    
    private static NioSocketConnector connector;
    private static ConnectFuture cf;
    private static HeartBeatThread heartBeatThread; //当前的心跳线程
    
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【银联支付：客户端收到响应 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
      super.messageReceived(session, message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.debug("【银联支付：客户端链接关闭 sessionId： " + session.getId() + "】");
        
        stopHeartBeat(heartBeatThread);  //停止原有socket链接的心跳线程
        disconnect(); //断开原有socket连接，并释放资源
        initConnector(); //esp客户端如果断链了要重连
        startHeartBeat(); //开启新socket链接的心跳线程
      super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
      super.sessionIdle(session, status);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【银联支付：客户端发送消息 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
        super.messageSent(session, message);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.debug("【银联支付：客户端创建连接 sessionId： " + session.getId() + "】");
      super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        log.debug("【银联支付：客户端打开链接 sessionId： " + session.getId() + "】");
      super.sessionOpened(session);
    }  
    
    /**
     * 初始化，在applicationContext-mina.xml 里创建客户端clientHandler的bean后调用
     * 先初始化连接，然后启动心跳线程
     */
    public void init()
    {
      initConnector();
      startHeartBeat();
    }

    /**
     * 初始化socket连接
     */
    private static void initConnector()
    {
      connector = new NioSocketConnector();
      connector.getFilterChain().addLast("logger", new LoggingFilter());
      connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCodecFactory()));

      connector.setHandler(new ClientHandler());

      cf = connector.connect(new InetSocketAddress(UnionPayCons.SERVER_HOST, UnionPayCons.SERVER_PORT));

      cf.awaitUninterruptibly();
      log.debug("【银联支付：esp创建连接成功】");
    }

    /**
     * 开启心跳线程
     */
    private static void startHeartBeat()
    {
      //stopHeartBeat = false;
      //HeartBeatThread heartThread = new HeartBeatThread(cf);
      //HeartBeatThread heartThread = new HeartBeatThread(this);
      HeartBeatThread heartThread = new HeartBeatThread();
      heartBeatThread = heartThread;
      Thread t = new Thread(heartThread);
      t.start();
      log.debug("【银联支付：esp开启新socket链接的心跳线程】");
    }

    /**
     * 停止原有socket连接的心跳线程
     * @param heartBeatThread
     */
    private static void stopHeartBeat(HeartBeatThread heartBeatThread) {
    	heartBeatThread.stopHeartBeat(); 
    	log.debug("【银联支付：esp停止原有socket链接的心跳线程】");
    }

    /**
     * 断开socket连接，并释放资源
     */
    private static void disconnect() {
      cf.getSession().close(true);
      cf.getSession().getCloseFuture().awaitUninterruptibly();
      connector.dispose();
      log.debug("【银联支付：esp断开原有连接】");
    }

    /**
     * 检查socket连接是否正常，如果断掉了需要重连
     */
    private static void checkConnector()
    {
      if (!connector.isActive()) {
        log.debug("【银联支付：connector.isActive()=false,断开原有连接重新创建连接】");
        disconnect();
        initConnector();
      } else {
        log.debug("【银联支付：connector.isActive()=true,连接状态活跃】");
      }
    }

    public ConnectFuture getConnectFuture()
    {
      checkConnector();
      return cf;
    }

    /**
     * 发送byte[] 报文至银联服务端
     * @param xmlSend
     * @return
     */
/*    public static boolean sendMsg(byte[] xmlSend) {
      checkConnector();
      //cf.getSession().write(xmlSend);
      boolean isSuccess = true;
      try {
      cf.getSession().write(xmlSend);
      return isSuccess;
      } catch (Exception e) {
          log.debug("【银联支付：生成最终请求报文后发送异常！！！】");
          isSuccess = false;
          e.printStackTrace();
          return isSuccess;
      }
    }*/
    
    public static void sendMsg(byte[] xmlSend) {
        checkConnector();
        cf.getSession().write(xmlSend);
      }
    
    
}
