package com.ai.gzesp.recharge;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 客户端请求端handler<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class RechargeClientHandler extends IoHandlerAdapter {
    
    private static Logger log = Logger.getLogger(RechargeClientHandler.class); 
    
    @Autowired
    private RechargeClient rechargeClient;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【一卡充：客户端收到响应 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
      super.messageReceived(session, message);
    }

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.debug("【一卡充：客户端链接关闭 sessionId： " + session.getId() + "】");

		rechargeClient.disconnect(); // 断开原有socket连接，并释放资源
		rechargeClient.initConnector(); // esp客户端如果断链了要重连
		super.sessionClosed(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		super.sessionIdle(session, status);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		byte[] m = (byte[]) message;
		log.debug("【一卡充：客户端发送消息 sessionId： " + session.getId() + "， message："
				+ new String(m) + "】");
		super.messageSent(session, message);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		log.debug("【一卡充：客户端创建连接 sessionId： " + session.getId() + "】");
		super.sessionCreated(session);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.debug("【一卡充：客户端打开链接 sessionId： " + session.getId() + "】");
		super.sessionOpened(session);
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
    

    
    
}
