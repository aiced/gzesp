package com.ai.gzesp.unionpay;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.ai.gzesp.service.UnionPayService;
import com.ai.gzesp.utils.XmlUtils;

/**
 * 自定义服务端handler<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ServerHandler extends IoHandlerAdapter {
    
    private static Logger log = Logger.getLogger(ServerHandler.class); 
    
    //@Autowired //写在配置文件里了
    private UnionPayService unionPayService;
    
    private HashMap<String, IoSession> sessionMap = new HashMap();
    
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.debug("【银联支付：服务端esp sessionCreated sessionId： " + session.getId() + "】");
        // Empty handler
    }

    @Override   
    public void sessionOpened(IoSession session) throws Exception {
        log.debug("【银联支付：服务端esp sessionOpened sessionId： " + session.getId() + "，sessionMap里原来有" + sessionMap.entrySet().size() + "个；链接】");
        for (Map.Entry entry : this.sessionMap.entrySet()) {
            IoSession s = ((IoSession) entry.getValue());
            log.debug("【银联支付：服务端esp sessionMap里原来有: " + s.getId() +"】");
            s.close(true);
        }
        this.sessionMap.clear();
        this.sessionMap.put(String.valueOf(session.getId()), session);
    }
    
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.debug("【银联支付：服务端esp关闭链接 sessionId： " + session.getId() + "】");
      super.sessionClosed(session);
    }

    @Override 
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }
    
    @Override  
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.debug("【银联支付：服务端esp收到消息异常 sessionId： " + session.getId() + cause.toString() + "】");
    }

    
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        log.debug("【银联支付：服务端esp收到消息 sessionId： " + session.getId() + "】");
        byte[] msg = (byte[])message;
        //String msgStr = new String(msg);
        log.debug("【银联支付：服务端esp收到消息 sessionId： " + session.getId() + "， message：" + new String(msg) + "】");
        //super.messageReceived(session, message);
        //先从返回数据包里解密获取xml报文
        String xmlResp = UnionPayUtil.getXmlFromMsg(msg);
        //根据返回的交易类型更新数据库记录状态
        
        //返回响应报文给请求端 ,此处只有心跳返回，其实心跳报文银联也不需要我返回
/*        if(rspHeart != null){
            log.debug("【银联支付：服务端esp收到心跳后，返回心跳 sessionId： " + session.getId() + "， message：" + rspHeart + "】");
            session.write(rspHeart.getBytes(UnionPayCons.charCode));
        }*/
        
        //根据respMap里交易类型进行业务处理
        if (xmlResp != null) {
            Map<String, String> respMap = (Map<String, String>) XmlUtils.fromXML(xmlResp);
            //IDealUnionPayResp respHanler = RespHandlerFactory.create(respMap, unionPayService);
            IDealUnionPayResp respHanler = RespHandlerFactory.create(respMap);
            respHanler.dealResp(respMap);
        }
    }

    public UnionPayService getUnionPayService() {
        return unionPayService;
    }

    public void setUnionPayService(UnionPayService unionPayService) {
        this.unionPayService = unionPayService;
    }
    
    /**
     * 客户端向银联服务端发送心跳维持长连接<br>
     * init()方法在bean配置里通过 init-method 属性初始化执行
     * 2分钟发送一次心跳
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
/*    public void init(){
        HeartBeatThread heartThread = new HeartBeatThread();
        Thread t = new Thread(heartThread);
        t.start();
    }*/
    
}
