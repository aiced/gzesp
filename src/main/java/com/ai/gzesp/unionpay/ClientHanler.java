package com.ai.gzesp.unionpay;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端请求端handler<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClientHanler extends IoHandlerAdapter {
    
    private static Logger log = Logger.getLogger(ClientHanler.class); 
    
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【银联支付：客户端收到响应 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
      super.messageReceived(session, message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.debug("【银联支付：客户端链接关闭 sessionId： " + session.getId() + "】");
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
    
}
