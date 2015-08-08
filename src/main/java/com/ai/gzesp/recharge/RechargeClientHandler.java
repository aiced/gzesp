package com.ai.gzesp.recharge;

import java.net.InetSocketAddress;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.RechargeDao;
import com.ai.gzesp.dto.RechargeResp;

/**
 * 客户端请求端handler<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RechargeClientHandler extends IoHandlerAdapter {
    
    private static Logger log = Logger.getLogger(RechargeClientHandler.class); 
    
//    @Autowired
//    private RechargeService rechargeService;
    
    @Autowired
    private RechargeDao rechargeDao;
    
	private NioSocketConnector connector; 
	
    private ConnectFuture cf;
    
//    @Autowired
//    private RechargeClient rechargeClient;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        byte[] m = (byte[])message;
        log.debug("【一卡充：客户端收到响应 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
        recvMsg(m); //处理响应报文
        //super.messageReceived(session, message);
    }

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.debug("【一卡充：客户端链接关闭 sessionId： " + session.getId() + "】");

		disconnect(); // 断开原有socket连接，并释放资源
		initConnector(); // esp客户端如果断链了要重连
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
    
    @Override  
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.debug("【一卡充：捕捉到异常 sessionId： " + session.getId() + cause.toString() + "】");
    }

    /**
     * 初始化socket连接
     * 启动(在listener中启动是需要新建一个线程来连接Server，否则web容器会阻塞而无法启动。) 
     * 对象初始化之后执行初始化socket客户端连接
     */
    @PostConstruct
	public void initConnector() {
		log.debug("【一卡充：esp初始化socket客户端连接...】");
		connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new RechargeCodecFactory()));
		connector.setHandler(this); //connector.setHandler(new ClientHandler());
		//connector.setHandler(new RechargeClientHandler());
		
		// 设置心跳过滤器链
		ClientKeepAliveFactoryImpl ckafi = new ClientKeepAliveFactoryImpl();
		KeepAliveFilter kaf = new KeepAliveFilter(ckafi, IdleStatus.WRITER_IDLE, KeepAliveRequestTimeoutHandler.DEAF_SPEAKER);
		kaf.setForwardEvent(true); // 继续调用 IoHandlerAdapter 中的 sessionIdle时间
		kaf.setRequestInterval(RechargeCons.HEART_INTERVAL); // 设置当连接的读取通道空闲的时候，心跳包请求时间间隔
		kaf.setRequestTimeout(RechargeCons.HEART_TIMEOUT); // 设置心跳包请求后 等待反馈超时时间
		connector.getFilterChain().addLast("heart", kaf); // 设置心跳

		cf = connector.connect(new InetSocketAddress(RechargeCons.SERVER_1_HOST, RechargeCons.SERVER_1_PORT));
		cf.awaitUninterruptibly();

		log.debug("【一卡充：esp创建连接成功】");
	}
	


    /**
     * 断开socket连接，并释放资源
     */
	public void disconnect() {
      cf.getSession().close(true);
      cf.getSession().getCloseFuture().awaitUninterruptibly();
      connector.dispose();
      log.debug("【一卡充：esp断开原有连接】");
    }

    /**
     * 检查socket连接是否正常，如果断掉了需要重连
     */
    private void checkConnector()
    {
      if (!connector.isActive()) {
        log.debug("【一卡充：connector.isActive()=false,断开原有连接重新创建连接】");
        disconnect();
        initConnector();
      } else {
        log.debug("【一卡充：connector.isActive()=true,连接状态活跃】");
      }
    }
    
    /**
     * 获取ConnectFuture
     * @return
     */
    public ConnectFuture getConnectFuture()
    {
      checkConnector();
      return cf;
    }
    
    /**
     * 发送报文
     * @param xmlSend
     */
    public void sendMsg(String xmlSend) {
        checkConnector();
        cf.getSession().write(xmlSend);
      }
    
    /**
     * 发送报文
     * @param xmlSend
     */
    public void sendMsg(byte[] xmlSend) {
        checkConnector();
        cf.getSession().write(xmlSend);
      }

    /**
     * 收到响应后的处理
     * @param msg
     */
    private void recvMsg(byte[] msg){
          
  		  if(Arrays.equals(msg, (RechargeCons.prefix + RechargeCons.HEARTBEAT_REQ + RechargeCons.Suffix).getBytes())){
  			log.debug("【一卡充：esp收到数据包， recvMsg里判断是响应心跳包】");
  			return;
  		  }
          
          //下面是响应报文包头部分，截取报文里固定位数的byte，转换成string，赋值给bean的属性，位数参考接口文档
          //int len = msg.length;
          byte [] logId = new byte[20];
          System.arraycopy(msg, 5, logId, 0, 20); //获取响应报文logId部分
          
          byte [] successFlag = new byte[1];
          System.arraycopy(msg, 5+20, successFlag, 0, 1); //获取响应报文successFlag部分
          
          byte [] interfaceType = new byte[6];
          System.arraycopy(msg, 5+20+1, interfaceType, 0, 6); //获取响应报文interfaceType部分
          
          byte [] busiType = new byte[2];
          System.arraycopy(msg, 5+20+1+6, busiType, 0, 2); //获取响应报文busiType部分
          
          byte [] serialNum = new byte[20];
          System.arraycopy(msg, 5+20+1+6+2, serialNum, 0, 20); //获取响应报文serialNum部分
          
          byte [] serialNumType = new byte[1];
          System.arraycopy(msg, 5+20+1+6+2+20, serialNumType, 0, 1); //获取响应报文serialNumType部分
          
          byte [] resultCode = new byte[5];
          System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1, resultCode, 0, 5); //获取响应报文resultCode部分
          
          //校验码暂时没取
          
          byte [] reqTime = new byte[12];
          System.arraycopy(msg, 5+20+1+6+2+20+1+3+32+5+1+5, reqTime, 0, 12); //获取响应报文reqTime部分
          
          RechargeResp resp = new RechargeResp();
          resp.setLogId(new String(logId).trim());
          resp.setSuccessFlag(new String(successFlag));
          resp.setInterfaceType(new String(interfaceType));
          resp.setBusiType(new String(busiType));
          resp.setSerialNum(new String(serialNum).trim());
          resp.setSerialNumType(new String(serialNumType));
          resp.setResultCode(new String(resultCode));
          resp.setReqTime(new String(reqTime));
          
          log.debug("【一卡充：收到的响应报文转换成bean," + resp.toString() +" 】");
          
          //因为不同接口的响应包体不一样，包头是固定的，所以包体部分放各自的响应处理类里面去处理
          //根据resp里交易类型进行业务处理
          RespHandler.handlerResp(resp, msg);
          
          //更新ITF_D_RECHARGE_LOG日志记录里的结果
//          rechargeService.updateRechargeLog(resp.getLogId(), resp.getSuccessFlag(), resp.getResultCode(),
//        		  resp.getAgentBalance(), resp.getUniconSerilNum());
          
//          rechargeDao.updateRechargeLog(resp.getLogId(), resp.getSuccessFlag(), resp.getResultCode(),
//        		  resp.getAgentBalance(), resp.getUniconSerilNum());
      }
    
    
    public static void main(String[] args) {
    	RechargeResp resp = new RechargeResp();
		System.out.println(resp.toString());
	}
    
}
