package com.ai.gzesp.recharge;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

/**
 * 客户端心跳请求实现类<br> 
 * 客户端会定时发送心跳请求（注意定时时间必须小于，服务器端的IDLE监控时间）,
 * 同时需要监听心跳反馈，以此来判断是否与服务器丢失连接。对于服务器的心跳请求不给与反馈。
 * 如果一卡充不返回心跳的响应，而mina的心跳机制需要判断心跳是否响应超时，超时了就会自动断链
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClientKeepAliveFactoryImpl implements KeepAliveMessageFactory {
    
    private static Logger log = Logger.getLogger(ClientKeepAliveFactoryImpl.class); 

    @Override
    public boolean isRequest(IoSession session, Object message) {
        // 服务器不会给客户端发送请求包，因此不关注请求包，直接返回false 
        byte[] m = (byte[])message;
        log.debug("【一卡充：客户端收到服务端心跳请求 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
        return false;
    }

    @Override
    public boolean isResponse(IoSession session, Object message) {
        // 客户端关注请求反馈，因此判断mesaage是否是反馈包
        byte[] m = (byte[])message;
        log.debug("【一卡充：客户端发送心跳后收到服务端反馈 sessionId： " + session.getId() + "， message：" + new String(m) + "】");
        if (message.equals(RechargeCons.HEARTBEAT_RESP)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object getRequest(IoSession session) {
        // 获取心跳请求包
        try {
            return RechargeCons.HEARTBEAT_REQ.getBytes(RechargeCons.charCode);
        } catch (UnsupportedEncodingException e) {
            log.debug("【一卡充：客户端心跳0000转换byte异常 sessionId： " + session.getId()  + "】");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getResponse(IoSession session, Object request) {
        // 服务器不会给客户端发送心跳请求，客户端当然也不用反馈  该方法返回null
        return null;
    }

}
