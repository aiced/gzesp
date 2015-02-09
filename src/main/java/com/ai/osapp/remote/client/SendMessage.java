package com.ai.osapp.remote.client;

import org.jivesoftware.smack.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.*;

/**
 * SendMessage
 * 
 * @Description: XMPP实时消息发送函數
 * @author shenbx
 */
public class SendMessage {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SendMessage.class);
	private XMPPConnection con;
	public static XMPPConnection xmppc;
	private static SendMessage SINGLE = null;

	public static String serverDomain;
	public static String messageProducer;
	public static String messageProducerPassword;
	public static Integer port;
	private static int deal_times = 0;

	/**
	 * 单例模式，由于用户不能重复登录,获取单个登录连接
	 * 
	 * @param serverDomain
	 * @param messageProducer
	 * @param messageProducerPassword
	 * @return
	 */
	public static SendMessage getInstance(String serverDomain,
			String messageProducer, String messageProducerPassword,Integer port) {
		SendMessage.serverDomain = serverDomain;
		SendMessage.messageProducer = messageProducer;
		SendMessage.messageProducerPassword = messageProducerPassword;
		SendMessage.port = port;

		if (SINGLE == null) {
			SINGLE = new SendMessage(serverDomain, messageProducer,
					messageProducerPassword,port);
		}
		return SINGLE;
	}

	/**
	 * 初始化，发送主用户登录,xmpp登录
	 * 
	 * @param serverDomain
	 * @param messageProducer
	 * @param messageProducerPassword
	 */
	public SendMessage(String serverDomain, String messageProducer,
			String messageProducerPassword,Integer port) {
		this.connect(serverDomain, messageProducer,
				messageProducerPassword,port);
	}

	/**
	 * xmpp登录 參數(地址,用户名,密码)
	 * 
	 * @param serverDomain
	 * @param messageProducer
	 * @param messageProducerPassword
	 * @return
	 */
	public XMPPConnection connect(String serverDomain, String messageProducer,
			String messageProducerPassword,Integer port) {
		ConnectionConfiguration config = new ConnectionConfiguration(serverDomain, port);
		xmppc = new XMPPConnection(config);
		//xmppc = new XMPPConnection(serverDomain);

		try {
			xmppc.connect();
			Thread.sleep(10);
		} catch (XMPPException e) {
			System.out.println("连接服务端" + serverDomain + "失败:" + e.toString());
			LOGGER.debug("连接服务端" + serverDomain + "失败:" + e.toString());
			throw new RuntimeException("Connect xmpp server", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			xmppc.login(SendMessage.messageProducer, SendMessage.messageProducerPassword);
		
		} catch (XMPPException e) {
			System.out.println("用户" + messageProducer + "登录失败:" + e.toString());
			LOGGER.debug("用户" + messageProducer + "登录失败:" + e.toString());
			throw new RuntimeException("login failed: " + e.getMessage()
					+ " with " + messageProducer + ":"
					+ messageProducerPassword);
		}
		return xmppc;

	}

	/**
	 * 发送xmpp消息 参数（登录连接，对方用户名，发送的报文）
	 * 
	 * @param con
	 * @param to
	 * @param message
	 */
	public void sendMessage(XMPPConnection con, String to, String message) {
		try {
			Chat newChat = con.getChatManager().createChat(to,
					new MessageListener() {
						public void processMessage(Chat chat, Message message) {
						}
					});
			newChat.sendMessage(message);
		} catch (XMPPException e) {
			LOGGER.debug("Got error while sending message to" + to
					+ e.toString());
		} catch (IllegalStateException e) {
			deal_times++;
			if (deal_times < 4) {
				LOGGER
						.debug("IllegalStateException,then send xmppmessage again ,error message is "
								+ e.toString());
				layout();
				SINGLE = null;
				SendMessage.getInstance(SendMessage.serverDomain,
						SendMessage.messageProducer,
						SendMessage.messageProducerPassword,SendMessage.port);
				sendMessage(con, to, message);
			} else {
				LOGGER.debug("need to login again: " + e.toString());
				return;
			}
		}
	}

	/**
	 * xmpp登出
	 */
	public void layout() {
		if (con != null && con.isConnected()) {
			con.disconnect();

		}
	}

}
