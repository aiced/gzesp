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
    public static boolean stopHeartBeat = false;
    
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【银联支付：客户端收到响应 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
      super.messageReceived(session, message);
    }

/*    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.debug("【银联支付：客户端链接关闭 sessionId： " + session.getId() + "】");
        
        stopHeartBeat();
        initConnector();
        startHeartBeat(cf);
      super.sessionClosed(session);
    }*/

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
    
    public void init()
    {
      initConnector();
      startHeartBeat(cf);
    }

    private static void initConnector()
    {
      connector = new NioSocketConnector();
      connector.getFilterChain().addLast("logger", new LoggingFilter());
      connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCodecFactory()));

      connector.setHandler(new ClientHandler());

      cf = connector.connect(new InetSocketAddress(UnionPayCons.SERVER_HOST, UnionPayCons.SERVER_PORT));

      cf.awaitUninterruptibly();
    }

    private void startHeartBeat(ConnectFuture cf)
    {
/*      stopHeartBeat = false;
      HeartBeatThread heartThread = new HeartBeatThread(cf);
      Thread t = new Thread(heartThread);
      t.start();*/
    }

    private void stopHeartBeat() {
      stopHeartBeat = true;
    }

    private static void disconnect() {
      cf.getSession().close(true);
      cf.getSession().getCloseFuture().awaitUninterruptibly();
      connector.dispose();
    }

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

    public static ConnectFuture getConnectFuture()
    {
      checkConnector();
      return cf;
    }

    public static void sendMsg(byte[] xmlSend) {
      checkConnector();
      cf.getSession().write(xmlSend);
    }
    
}
