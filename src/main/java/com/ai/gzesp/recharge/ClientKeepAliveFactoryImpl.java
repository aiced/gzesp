package com.ai.gzesp.recharge;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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
    public Object getRequest(IoSession session) {
    	log.debug("【一卡充：esp发送心跳getRequest...】");
        // 返回给对方的心跳包数据
    	return (RechargeCons.prefix + RechargeCons.HEARTBEAT_REQ + RechargeCons.Suffix).getBytes();
    }

    @Override
    public Object getResponse(IoSession session, Object request) {
    	log.debug("【一卡充：esp返回心跳getResponse...】" + new String((byte[])request));
    	//接受到对方的数据包
        // 一卡充服务器给esp客户端发送心跳请求，esp客户端不用反馈  该方法返回null
        return null;
    }

    @Override
    public boolean isRequest(IoSession session, Object message) {
    	log.debug("【一卡充：isRequest报文：】"  + new String((byte[])message));
    	//判断是否是对方发送来的的心跳包此判断影响 KeepAliveRequestTimeoutHandler实现类，判断是否心跳包发送超时
        // esp发送心跳后，一卡充服务器会给esp客户端返回相同的心跳包
	    return isHeart((byte[])message);
    }

    @Override
    public boolean isResponse(IoSession session, Object message) {
    	log.debug("【一卡充：isResponse报文:】" + new String((byte[])message));
    	//esp客户端关注一卡充的心跳反馈，以此判断mesaage是否是反馈包
    	//判断发送信息是否是心跳数据包此判断影响 KeepAliveRequestTimeoutHandler实现类,判断是否心跳包发送超时
        return isHeart((byte[])message);
    }


    
    /**
     * 判断是否是心跳
     * @param message
     * @return
     */
    private boolean isHeart(byte[] message){
    	
		if(Arrays.equals(message, (RechargeCons.prefix + RechargeCons.HEARTBEAT_REQ + RechargeCons.Suffix).getBytes())){
			return true;
		}
		else{
			return false;
		}	
    }

}
