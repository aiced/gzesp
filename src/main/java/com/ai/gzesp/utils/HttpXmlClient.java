package com.ai.gzesp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class HttpXmlClient {  

public static String httpSend(String url,Map<String,String> propsMap){
		String strRet="";
		HttpClient httpClient=new HttpClient();
		PostMethod postMethod = new PostMethod(url);//POST请求
		//参数设置
		Set<String> keySet=propsMap.keySet();
		NameValuePair[] postData=new NameValuePair[keySet.size()];
		
		int index=0;
		for(String key:keySet){
			postData[index++]=new NameValuePair(key,propsMap.get(key).toString());

		}
		postMethod.addParameters(postData);
		
		try{
			httpClient.executeMethod(postMethod);//发送请求
	      //打印服务器返回的状态
	      System.out.println(postMethod.getStatusLine());
	      //打印返回的信息
	      System.out.println(postMethod.getResponseBodyAsString());
	      
	      strRet=postMethod.getResponseBodyAsString();
		}catch (HttpException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			postMethod.releaseConnection();//关闭连接
		}
		return strRet;
	}
}  