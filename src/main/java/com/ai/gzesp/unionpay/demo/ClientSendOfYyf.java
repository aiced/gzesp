package com.lyhf.client.test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lyhf.tools.ACSDKUtil;
import com.lyhf.tools.ACXmlUtils;
import com.lyhf.tools.DesCrypt;
import com.lyhf.work.BusinessBase;

public class ClientSendOfYyf extends BusinessBase implements Runnable {
	protected  Socket sendSocket = null;
	protected OutputStream out;
	protected String xmlStr;//待发送XML串
	protected byte[] xmlHeader;
	protected byte[] xmlBody;
	protected  java.util.Date sendDate;//最后一次发送消息时间
	protected Date curDate; //当前时间，用于与最后一次发送时间比较 
	public Map<String,String> clientConfig ;


	@Override
	public void run() {
		this.sendDate = new Date();
		
		while(true){
			try{
				this.sendSocket = new Socket(this.clientConfig.get("forwardAddress"),
						Integer.valueOf(this.clientConfig.get("forwardListenPort")));
				out = new BufferedOutputStream(this.sendSocket.getOutputStream());
				log.info("模拟程序，建立到云捷付发送SOCKET通道成功，对方端口：" + Integer.valueOf(this.clientConfig.get("forwardListenPort")));
				//下面的程序不断从数据库中取出待发送数据，然后发送,如无数据，2分钟发送一次心跳包
				while(true){
					if(readMsgFromDbAndSend()){
						this.sendDate = new Date();
					}else{
						//发送心跳包
						this.curDate = new Date();
						if(( ( this.curDate.getTime() - this.sendDate.getTime() )/( 1000 * 60 ) ) > 1){
							try{
								byte[] xmlByte = String.valueOf("0000").getBytes("GBK");
								out.write(xmlByte);
								out.flush();
								this.sendDate = new Date();
								
							}
							catch(IOException io){
								log.error("发送心跳包出错，重新连接云捷付端，错误消息：" + io.getMessage());
								out = null;
								this.sendSocket.close();
								break;
							}
							catch(Exception e){
								log.error("发送心跳包到云捷付平台出错：" + e.getMessage());
							}
						}else{
							//休眠0.1秒
							try
			        		{
			        			Thread.currentThread();
			            		Thread.sleep(100L);   
			        		}
			        		catch(Exception e){
			        			log.error(e.getMessage());
			        		} 
						} 
				}
				}
			}catch(Exception e){
				log.error("建立到云捷付的连接失败或发送报文失败，原因：" + e.getMessage());
				try
        		{
        			Thread.currentThread();
            		Thread.sleep(10000L);   
        		}
        		catch(Exception ee){
        			//log.error(ee.getMessage());
        		} 
			}
		}
	}
	
	private Boolean readMsgFromDbAndSend() throws Exception{
		Boolean flag = false;
		String ifSend = this.clientConfig.get("ifSend");
		if(ifSend.equals("0"))
			return flag;
		int countOfSecond = Integer.valueOf(this.clientConfig.get("countOfSecond"));
		int index = 0;
		String channelId;
		while(index++ < countOfSecond){
			flag = true;
			Map<String,String> xmlMap = new HashMap<String,String>();
			xmlMap.put("charCode", "GBK");
			xmlMap.put("Version", "2.0.1");
			xmlMap.put("TradeType", this.clientConfig.get("TradeType"));
			xmlMap.put("ChannelID", this.clientConfig.get("ChannelID"));
			xmlMap.put("MerType", this.clientConfig.get("MerType"));
			xmlMap.put("bmMerId", this.clientConfig.get("bmMerId"));
			xmlMap.put("timeStamp", ACSDKUtil.generateTxnTime());
			xmlMap.put("sysTradeNo", ACSDKUtil.generateOrderId2());
			xmlMap.put("accNo", this.clientConfig.get("accNo"));
			xmlMap.put("currencyCode", this.clientConfig.get("currencyCode"));
			xmlMap.put("Nbr", this.clientConfig.get("Nbr"));
			xmlMap.put("Name", this.clientConfig.get("Name"));
			xmlMap.put("certificateCode", this.clientConfig.get("certificateCode"));
			xmlMap.put("expireDate", this.clientConfig.get("expireDate"));
			xmlMap.put("cardType", this.clientConfig.get("cardType"));
			xmlMap.put("BusiType", this.clientConfig.get("BusiType"));
			xmlMap.put("AccountID", this.clientConfig.get("AccountID"));
			xmlMap.put("txnAmt", this.clientConfig.get("txnAmt"));
			xmlMap.put("origsignCode", this.clientConfig.get("origsignCode"));
			xmlMap.put("origtimeStamp", this.clientConfig.get("origtimeStamp"));
			xmlMap.put("origsysTradeNo", this.clientConfig.get("origsysTradeNo"));
			xmlMap.put("origOrderId", this.clientConfig.get("origOrderId"));
			xmlMap.put("origtxnAmt", this.clientConfig.get("origtxnAmt"));
			xmlMap.put("orderId", this.clientConfig.get("preOrderId") + ACSDKUtil.generateOrderId2());
			xmlMap.put("qqdNo", this.clientConfig.get("qqdNo"));
			xmlMap.put("industryType", this.clientConfig.get("industryType"));
			xmlMap.put("signCode", this.clientConfig.get("signCode"));
			xmlMap.put("faMerId", this.clientConfig.get("faMerId"));
			xmlMap.put("chMerId", this.clientConfig.get("chMerId"));
			xmlMap.put("thMerId", this.clientConfig.get("thMerId"));
			xmlMap.put("transChannel", this.clientConfig.get("transChannel"));
			xmlMap.put("acceptime", this.clientConfig.get("acceptime"));
			xmlMap.put("AreaCode", this.clientConfig.get("AreaCode"));
			xmlMap.put("localOrderId", ACSDKUtil.generateTxnTime());
			channelId = this.clientConfig.get("ChannelID");
			String xmlStr = ACXmlUtils.genXmlFromMapAndSign2("charCode,Version,TradeType,ChannelID,MerType,bmMerId,"
					+ "timeStamp,sysTradeNo,accNo,currencyCode,Nbr,Name,certificateCode,expireDate,"
					+ "cardType,BusiType,AccountID,txnAmt,origsignCode,origtimeStamp,origsysTradeNo,"
					+ "origOrderId,origtxnAmt,orderId,qqdNo,industryType,signCode,faMerId,chMerId,thMerId,"
					+ "transChannel,acceptime,AreaCode,AccountID,localOrderId",
					xmlMap,"89d8aeb09f214eef9b6fb3447e6b44f9","requestData");
			if(this.clientConfig.get("ifWriteMessage").equals("1"))
				log.info("模拟客户端生成XML串成功：" + ACXmlUtils.formatXml(xmlStr));
//			log.info("模拟客户端生成XML串成功：" + new String(xmlStr.getBytes(),"GBK"));
			//加密
			byte[] xmlByte = DesCrypt.encrypt(xmlStr.getBytes("GBK"),"e143cc8236aed7f7786da932");
			if(xmlByte == null)
			{
				log.error("加密XML失败,xmlStr = " + xmlStr);
				continue;
			}
			byte[] xmlHead = new byte[4];
			byte[] xmlHeadLen = String.valueOf(xmlByte.length + 16).getBytes("GBK");
			//转化为4位长度字节数据以供另一端读取
			System.arraycopy(xmlHeadLen, 0, xmlHead, xmlHead.length - xmlHeadLen.length, xmlHeadLen.length);
			byte[] xmlSend = new byte[20 + xmlByte.length];
			System.arraycopy(xmlHead, 0, xmlSend, 0, 4);
			System.arraycopy(channelId.getBytes("GBK"), 0, xmlSend, 4, 16);
			System.arraycopy(xmlByte, 0, xmlSend, 20, xmlByte.length);
//			out.write(xmlHead);
//			out.write(channelId.getBytes("GBK"));
//			out.write(xmlByte);
			out.write(xmlSend);
			out.flush();//这个地方还要有一个出错重发机制，即如果发送失
		}
		try{
			Thread.sleep(1000L);
		}catch(Exception e){
			
		}
		return flag;
	}
	

	public  ClientSendOfYyf(Map<String,String> clientConfig1){
		this.clientConfig = clientConfig1;
	}
}
