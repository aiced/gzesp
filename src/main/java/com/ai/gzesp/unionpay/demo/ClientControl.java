package com.lyhf.client.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.lyhf.work.BusinessBase;

public class ClientControl extends BusinessBase implements Runnable {

	public Map<String,String> clientConfig = new HashMap<String,String>();
	@Override
	public void run() {
		loadApplicationData();
		new Thread(new ClientSendOfYyf(clientConfig)).start();
		new Thread(new ClientRecvOfYyf(clientConfig)).start();
		while(true){
			//每10秒钟重载一次配置文件
			loadApplicationData();
			try{
				Thread.sleep(1000L);
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new ClientControl()).start();
	}
	
	protected void loadApplicationData(){
		Properties properties = new Properties();
        try  
        {  
//        	log.info("加载应用程序全局变量...............................");
            InputStream inputStream = new FileInputStream("clientConfig.ini");  
            properties.load(inputStream);  
            inputStream.close(); //关闭流  
        }  
        catch (IOException e)  
        {  
            log.error("加载应用程序全局变量出错：" + e.getMessage()); 
        }  
        Enumeration<Object> proEnu = properties.keys();
        while(proEnu.hasMoreElements()){
        	String key = (String) proEnu.nextElement();
        	clientConfig.put(key, properties.getProperty(key));
//        	System.out.println(key + "=" + properties.getProperty(key));        	
        }
//        log.info("应用程序全局变量加载完毕...........................");
	}
	
}
