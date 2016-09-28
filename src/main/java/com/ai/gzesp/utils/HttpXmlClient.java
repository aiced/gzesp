package com.ai.gzesp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class HttpXmlClient {  

//public static String httpSend2(String url,Map<String,String> propsMap){
//		String strRet="";
//		HttpClient httpClient=new HttpClient();
//		PostMethod postMethod = new PostMethod(url);//POST请求
//		//参数设置
//		Set<String> keySet=propsMap.keySet();
//		NameValuePair[] postData=new NameValuePair[keySet.size()];
//		
//		int index=0;
//		for(String key:keySet){
//			postData[index++]=new NameValuePair(key,propsMap.get(key).toString());
//
//		}
//		postMethod.addParameters(postData);
//		
//		try{
//			httpClient.executeMethod(postMethod);//发送请求
//	      //打印服务器返回的状态
//	      System.out.println(postMethod.getStatusLine());
//	      //打印返回的信息
//	      System.out.println(postMethod.getResponseBodyAsString());
//	      
//	      strRet=postMethod.getResponseBodyAsString();
//		}catch (HttpException e){
//			e.printStackTrace();
//		}catch (IOException e){
//			e.printStackTrace();
//		}finally{
//			postMethod.releaseConnection();//关闭连接
//		}
//		return strRet;
//	}


public static String httpSend(String url,Map<String,String> propsMap) {

	// 6、获取数据
	String responseBody = "";
	CloseableHttpClient httpclient = HttpClients.createDefault();
	HttpPost httppost = new HttpPost(url);
	try {
		httppost.setEntity(new UrlEncodedFormEntity(getPostParam(propsMap), "UTF-8"));
		responseBody = httpclient.execute(httppost, responseHandler);

	      //打印返回的信息
	      System.out.println(responseBody);
	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		try {
			httpclient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return responseBody;
}

/**
 * 获取请求参数
 * 
 * @param params
 * @return
 */
private static List<NameValuePair> getPostParam(Map<String, String> params) {
	List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	if (params != null) {
		for (String key : params.keySet()) {
			nvps.add(new BasicNameValuePair(key, params.get(key) == null ? "" : params.get(key).toString()));
		}
	}
	return nvps;
}

// 返回结果处理
private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
	public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
		int status = response.getStatusLine().getStatusCode();
		if (status >= 200 && status < 300) {
			HttpEntity entity = response.getEntity();
			return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
		} else {
			throw new ClientProtocolException("Unexpected response status: " + status);
		}
	}
};
}  