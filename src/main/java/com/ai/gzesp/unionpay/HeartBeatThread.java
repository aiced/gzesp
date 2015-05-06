package com.ai.gzesp.unionpay;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;

/**
 * 心跳线程，维持和银联服务器的长连接<br>
 * mina自带的心跳必须设置响应超时时间，超时会自动断开和银联的链接， 但银联对心跳不做处理也不返回报文，所以没法维持长连接，所以只能搞个线程循环维持心跳 esp需要有断连重试机制，保证一方宕机或者网络闪断后能自动再次连上
 * 启动线程过程中，或者任意一次发送心跳时有异常，则要不停进行重试连接，否则就需要重启esp应用才能再次启动心跳线程
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HeartBeatThread implements Runnable {
    private static Logger log = Logger.getLogger(HeartBeatThread.class);
    
    private boolean isStop = false; //线程是否需要终止标志
    
    //private ClientHandler clientHandler;
    
    //private ConnectFuture cf;
    
/*    public HeartBeatThread(ClientHandler clientHandler)
    {
      this.clientHandler = clientHandler;
    }*/
    
/*  public HeartBeatThread(ConnectFuture cf)
    {
      this.cf = cf;
    }
    
    @Override
    public void run() {
        log.debug("【银联支付：esp维持长连接，线程启动，初始化开始。。。】");
        
        String tip = "循环中。。。";
        int times = 0;
        NioSocketConnector connector = new NioSocketConnector();
        ConnectFuture cf = null;
        
        // 循环 如果启动线程过程中，或者任意一次发送心跳时有异常，则要不停进行重试连接，否则就需要重启esp应用才能再次启动心跳线程
        while (true) {
            try {
                log.debug("【银联支付：esp维持长连接，" + tip +"】");

                //如果connector处于不活动状态则重新连接
                if(!connector.isActive()){
                    log.debug("【银联支付：esp维持长连接，connector.isActive()=false,重新创建连接】");
                    connector = new NioSocketConnector();
                    connector.getFilterChain().addLast("logger", new LoggingFilter());
                    connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCodecFactory())); // 设置编码过滤器
                    connector.setHandler(new ClientHandler());// 设置事件处理器
                    cf = connector.connect(new InetSocketAddress(UnionPayCons.SERVER_HOST,
                            UnionPayCons.SERVER_PORT));// 建立连接
                    cf.awaitUninterruptibly();// 等待连接创建完成
                }else{
                    log.debug("【银联支付：esp维持长连接，connector.isActive()=true,连接状态活跃】");
                }

                // 心跳报文0000转换成字节
                byte[] heart = new byte[4];
                heart = String.valueOf(UnionPayCons.HEARTBEAT_REQ).getBytes(UnionPayCons.charCode);

                cf.getSession().write(heart);// 发送消息
                log.debug("【银联支付：esp维持长连接，发送心跳报文0000成功，2分钟后again】");
                Thread.sleep(2 * 60 * 1000); // 2分钟一次
            } catch (UnsupportedEncodingException e) {
                log.debug("【银联支付：ERROR！！！esp维持长连接，生成心跳报文异常，5分钟后retry重新尝试连接！！！】");
                e.printStackTrace();
                try {
                    Thread.sleep(5 * 60 * 1000); // 等待5分钟
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                tip = "重试次数 " + (++times);
                continue;
            } catch (InterruptedException e) {
                log.debug("【银联支付：ERROR！！！esp维持长连接，发送心跳报文异常，5分钟后retry重新尝试连接！！！】");
                e.printStackTrace();
                try {
                    Thread.sleep(5 * 60 * 1000); // 等待5分钟
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                tip = "重试次数 " + (++times);
                continue;
            } catch (Exception e) {
                log.debug("【银联支付：ERROR！！！esp维持长连接，其他异常，5分钟后retry重新尝试连接！！！】");
                e.printStackTrace();
                try {
                    Thread.sleep(5 * 60 * 1000); // 等待5分钟
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                tip = "重试次数 " + (++times);
                continue;
            }
        }

    }*/
    
    public void run()
    {
      log.debug("【银联支付：esp维持长连接，线程启动，初始化开始。。。】");

      String tip = "循环中。。。";
      int times = 0;

      while (!isStop)
      {
        try
        {
          log.debug("【银联支付：esp维持长连接...isStop=" + isStop + "】");

          byte[] heart = new byte[4];
          heart = String.valueOf(UnionPayCons.HEARTBEAT_REQ).getBytes(UnionPayCons.charCode);

          //UnionPayUtil.sendMsg(heart);
          ClientHandler.sendMsg(heart);
          log.debug("【银联支付：esp维持长连接，发送心跳报文0000成功，" + UnionPayCons.HEART_INTERVAL/1000 + "秒钟后again】");
          Thread.sleep(UnionPayCons.HEART_INTERVAL);
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

	public boolean isStop() {
		return isStop;
	}

	/**
	 * 停止心跳线程
	 */
	public void stopHeartBeat() {
		this.isStop = true;
	}
    
/*    private NioSocketConnector getConnector() throws Exception{
        //如果connector处于不活动状态则重新连接
        if (!connector.isActive()) {
            // 设置心跳过滤器链
            // ClientKeepAliveFactoryImpl ckafi = new ClientKeepAliveFactoryImpl();
            // KeepAliveFilter kaf = new KeepAliveFilter(ckafi,
            // IdleStatus.BOTH_IDLE,KeepAliveRequestTimeoutHandler.CLOSE);
            // kaf.setForwardEvent(true); //继续调用 IoHandlerAdapter 中的 sessionIdle时间
            // kaf.setRequestInterval(UnionPayCons.HEART_INTERVAL); //设置当连接的读取通道空闲的时候，心跳包请求时间间隔
            // kaf.setRequestTimeout(UnionPayCons.HEART_TIMEOUT); //设置心跳包请求后 等待反馈超时时间
            // 创建客户端连接器.
            //NioSocketConnector connector = new NioSocketConnector();
            connector = new NioSocketConnector();
            connector.getFilterChain().addLast("logger", new LoggingFilter());
            connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCodecFactory())); // 设置编码过滤器
            // connector.getFilterChain().addLast("heart", kaf); //设置心跳
            connector.setHandler(new ClientHanler());// 设置事件处理器
            ConnectFuture cf = connector.connect(new InetSocketAddress(UnionPayCons.SERVER_HOST,
                    UnionPayCons.SERVER_PORT));// 建立连接
            cf.awaitUninterruptibly();// 等待连接创建完成
            // cf.getSession().write(xmlSend);//发送消息
            // cf.getSession().close(true);
            // cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开
            // connector.dispose(); //断开连接，释放资源
            
        }

        return connector;
    }*/

    

}
