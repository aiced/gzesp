package com.ai.gzesp.recharge;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.unionpay.ByteArrayCodecFactory;
import com.ai.gzesp.unionpay.ClientHandler;
import com.ai.gzesp.unionpay.UnionPayCons;

@Service
public class RechargeClient {

	private static Logger log = Logger.getLogger(RechargeClient.class); 
	
//	private NioSocketConnector connector; 
//	
//    private ConnectFuture cf;
    
    @Autowired
    private RechargeClientHandler rechargeClientHandler;
	
	/**
	 * RechargeClient对象初始化之后执行初始化socket客户端连接
	 */
	@PostConstruct
	public void init(){
		rechargeClientHandler.initConnector();
	}
	
//    /**
//     * 初始化socket连接
//     * 启动(在listener中启动是需要新建一个线程来连接Server，否则web容器会阻塞而无法启动。) 
//     */
//	public void initConnector() {
//		connector = new NioSocketConnector();
//		connector.getFilterChain().addLast("logger", new LoggingFilter());
//		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new RechargeCodecFactory()));
//		connector.setHandler(rechargeClientHandler); //connector.setHandler(new ClientHandler());
//
//		// 设置心跳过滤器链
//		ClientKeepAliveFactoryImpl ckafi = new ClientKeepAliveFactoryImpl();
//		KeepAliveFilter kaf = new KeepAliveFilter(ckafi, IdleStatus.BOTH_IDLE, KeepAliveRequestTimeoutHandler.CLOSE);
//		kaf.setForwardEvent(true); // 继续调用 IoHandlerAdapter 中的 sessionIdle时间
//		kaf.setRequestInterval(RechargeCons.HEART_INTERVAL); // 设置当连接的读取通道空闲的时候，心跳包请求时间间隔
//		kaf.setRequestTimeout(RechargeCons.HEART_TIMEOUT); // 设置心跳包请求后 等待反馈超时时间
//		connector.getFilterChain().addLast("heart", kaf); // 设置心跳
//
//		cf = connector.connect(new InetSocketAddress(RechargeCons.SERVER_1_HOST, RechargeCons.SERVER_1_PORT));
//		cf.awaitUninterruptibly();
//
//		log.debug("【一卡充：esp创建连接成功】");
//	}
//	
//
//
//    /**
//     * 断开socket连接，并释放资源
//     */
//	public void disconnect() {
//      cf.getSession().close(true);
//      cf.getSession().getCloseFuture().awaitUninterruptibly();
//      connector.dispose();
//      log.debug("【一卡充：esp断开原有连接】");
//    }
//
//    /**
//     * 检查socket连接是否正常，如果断掉了需要重连
//     */
//    private void checkConnector()
//    {
//      if (!connector.isActive()) {
//        log.debug("【一卡充：connector.isActive()=false,断开原有连接重新创建连接】");
//        disconnect();
//        initConnector();
//      } else {
//        log.debug("【一卡充：connector.isActive()=true,连接状态活跃】");
//      }
//    }
//    
//    /**
//     * 获取ConnectFuture
//     * @return
//     */
//    public ConnectFuture getConnectFuture()
//    {
//      checkConnector();
//      return cf;
//    }
//    
//    /**
//     * 发送报文
//     * @param xmlSend
//     */
//    public void sendMsg(String xmlSend) {
//        checkConnector();
//        cf.getSession().write(xmlSend);
//      }
//    
//    public void sendMsg(byte[] xmlSend) {
//        checkConnector();
//        cf.getSession().write(xmlSend);
//      }
}
