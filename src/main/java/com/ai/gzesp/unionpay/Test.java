package com.ai.gzesp.unionpay;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ai.gzesp.utils.XmlUtils;

public class Test {

    public static void main(String[] args) {
/*        //设置心跳过滤器链
        ClientKeepAliveFactoryImpl ckafi = new ClientKeepAliveFactoryImpl(); 
        KeepAliveFilter kaf = new KeepAliveFilter(ckafi, IdleStatus.BOTH_IDLE,KeepAliveRequestTimeoutHandler.CLOSE); 
        kaf.setForwardEvent(true); //继续调用 IoHandlerAdapter 中的 sessionIdle时间 
        kaf.setRequestInterval(UnionPayCons.HEART_INTERVAL); //设置当连接的读取通道空闲的时候，心跳包请求时间间隔 
        kaf.setRequestTimeout(UnionPayCons.HEART_TIMEOUT); //设置心跳包请求后 等待反馈超时时间

        // 创建客户端连接器. 
        NioSocketConnector connector = new NioSocketConnector(); 
        connector.getFilterChain().addLast("logger", new LoggingFilter() ); 
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "GBK" )))); //设置编码过滤器 
        connector.getFilterChain().addLast("heart", kaf);  //设置心跳
        connector.setHandler(new ClientHanler());//设置事件处理器 
        ConnectFuture cf = connector.connect( 
        new InetSocketAddress(UnionPayCons.SERVER_HOST, UnionPayCons.SERVER_PORT));//建立连接 
        cf.awaitUninterruptibly();//等待连接创建完成 
        cf.getSession().write("知识");//发送消息 
        cf.getSession().close(true);
        cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开 
        connector.dispose(); */
        
/*        byte[] head = "0123".getBytes();
        System.out.println(new String(head));
        System.out.println(new String(head).trim());
        System.out.println(Integer.parseInt(new String(head)));
        
        System.out.println("1142883333799600".substring(14));
        System.out.println("1142883333799600".substring(14,16));*/
        
/*        Map xmlMap = new LinkedHashMap();
        xmlMap.put(UnionPayAttrs.charCode, "1");
        xmlMap.put(UnionPayAttrs.Version, "2");
        xmlMap.put(UnionPayAttrs.TradeType, "3");
        xmlMap.put(UnionPayAttrs.ChannelID, "4");
        xmlMap.put(UnionPayAttrs.MerType, "5");
        xmlMap.put(UnionPayAttrs.bmMerId, "6");
        xmlMap.put(UnionPayAttrs.timeStamp, "7");
        xmlMap.put(UnionPayAttrs.sysTradeNo, "8");
        xmlMap.put(UnionPayAttrs.accNo, "9");
        xmlMap.put(UnionPayAttrs.cvn2, "10");
        xmlMap.put(UnionPayAttrs.currencyCode, "11");
        xmlMap.put(UnionPayAttrs.Nbr, "12");
        xmlMap.put(UnionPayAttrs.Name, "13");
        xmlMap.put(UnionPayAttrs.certificateCode, "14");
        xmlMap.put(UnionPayAttrs.expireDate, "15");
        xmlMap.put(UnionPayAttrs.cardType, "16");

        String xmlStr1 = XmlUtils.toXML(xmlMap);

        System.out.println(xmlStr1);

        String data = UnionPayUtil.getDataFromxmlMap(xmlMap);

        System.out.println(data);*/
    	
    	byte[] heart = new byte[4];
        try {
			heart = String.valueOf("0000").getBytes("GBK");
			int len = Integer.valueOf(new String(heart,"GBK").trim());
			
			System.out.println(new String(heart));
			System.out.println(Arrays.toString(heart));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
/*        byte [] header = new byte[4];
		int len=0;
		try{
			int tempLen=0;//读取实际的字节数
			int tempI=4;//
			while(tempI>0){
				tempLen=in.read(header, 4-tempI, tempI);
				tempI=tempI-tempLen;
			}
		}catch(IOException io){
			throw io;
		}
		
		try{
			try{
				len=Integer.valueOf(new String(header,"GBK").trim());
			}catch(NumberFormatException ee){
				log.error("线程【" + this.getThreadNumber() + "】读取报文消息长度错误" + ee.getMessage());
				throw ee;
			}*/

    }

}
