package com.lyhf.client.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;

import com.lyhf.tools.Base;
import com.lyhf.tools.DesCrypt;
import com.lyhf.work.BusinessBase;

public class ClientRecvOfYyf extends BusinessBase implements Runnable {
	
	
	public Map<String,String> clientConfig ;

	protected  ServerSocket serverSocket = null;
	protected  Socket recvSocket = null;
	protected InputStream in;
	private Date curDate;
	private Date recvDate;
	
	public ClientRecvOfYyf(Map<String,String> clientConfig1){
		this.clientConfig = clientConfig1;
	}
	@Override
	public void run() {
		while(true){
			try{
				serverSocket = new ServerSocket(Integer.valueOf(this.clientConfig.get("clientListenPort")));
				log.info("模拟程序，建立到云捷付的侦听，端口：" + Integer.valueOf(this.clientConfig.get("clientListenPort")));
				while(true){
					try{
						recvSocket = serverSocket.accept();
						in = new BufferedInputStream(
								recvSocket.getInputStream());
						log.info("云捷付端接入，开始接收信息");
						this.curDate = this.recvDate = new Date();
						while(true){
							if (in.available() > 0  ) {
								
								this.recvMessage();
								this.recvDate = new Date();
							}else{
								this.curDate = new Date();
								if (((this.curDate.getTime() - this.recvDate
										.getTime()) / (1000 * 60)) > 2) {
									try{
										in.close();
										recvSocket.close();
										recvSocket = null;
										in = null;
									}catch(Exception e){
										
									}
									log.info("3分钟之内未收到心跳包，断开连接");
									// 跳出本次循环，重新接收连接
									break;
								} else {
									// 休眠1毫秒
									try {
										Thread.currentThread();
										Thread.sleep(1L);
									} catch (Exception e) {
										log.info(e.getMessage());
									}
								}
							}
						}

					}catch(Exception e){	
						log.error("处理来自全渠道的消息出错，原因：" + e.getMessage());
					}
				}

			}catch(Exception e){
				log.error("建立到全渠道侦听通道失败，原因：" + e.getMessage());;
			}	
			finally{
				try{
					in.close();
					in = null;
					serverSocket.close();
					serverSocket = null;
				}catch(Exception e){
					
				}
			}
		}

	}

	private void recvMessage() throws Exception{
		byte [] header = new byte[4];
		int len=0;
		try{
			len=in.read(header);
			if(len==-1||len!=4){
				log.error("接收消息长度不对 ,消息长度应为4，实为" + len);
				return;
			}
		}catch(IOException io){
			log.error(io.getMessage());;
		}
		
		try{
			len=Base.Translate(new String(header).trim(), 0);
			if(len<0){
				log.error("消息包长度定义不对 ,消息长度应大于0，实际为" + len);
				return ;
			}else if(len==0){
				log.info("接收到全渠道端心跳包");
				this.recvDate = new Date();
				return;
			}
		}catch(Exception ee){
			log.error("错误的包长度信息"+ee);
			return ;
		}
		len = len - 16;
		byte [] cache = new byte [len];
		byte [] channel = new byte[16];
		in.read(channel);
		System.arraycopy(header, 0, cache, 0, header.length);
		try{
			int tempLen=0;//读取实际的字节数
			int tempI=len;//
			while(tempI>0){
				tempLen=in.read(cache, len-tempI, tempI);
				tempI=tempI-tempLen;
			}
		}catch(Exception ee){
			log.error("未能读取完整的包体部分"+ee.getMessage());
			return;
		}
		//转换为XML字串，入队列供后续程序处理
		try{
			byte[] byteStr = DesCrypt.decrypt(cache,"e143cc8236aed7f7786da932");
			String xmlStr = new String(byteStr,"GBK");
			this.recvDate = new Date();
			if(this.clientConfig.get("ifWriteMessage").equals("1"))
				log.info("模拟接收云捷付XML串为：" + xmlStr);
		}catch(Exception e){
			log.error("转换字串出错："  + e.getMessage());
			return;
		}
	}

}
