package com.ai.gzesp.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class SmsUtils {
	private static int connectTimeOut = 5000;
	private static int readTimeOut = 10000;
	private static String requestEncoding = "UTF-8";
	public static int getConnectTimeOut() {
		return connectTimeOut;
	}
	public static void setConnectTimeOut(int connectTimeOut) {
		SmsUtils.connectTimeOut = connectTimeOut;
	}
	public static int getReadTimeOut() {
		return readTimeOut;
	}
	public static void setReadTimeOut(int readTimeOut) {
		SmsUtils.readTimeOut = readTimeOut;
	}
	public static String getRequestEncoding() {
		return requestEncoding;
	}
	public static void setRequestEncoding(String requestEncoding) {
		SmsUtils.requestEncoding = requestEncoding;
	}
	
	public static String doGet(String requrl,Map<?,?> parameters,String recvEndcoding){
		HttpURLConnection url_con=null;
		String responseContent = null;
		String vchartset=recvEndcoding==""?SmsUtils.requestEncoding:recvEndcoding;
		try {
				StringBuffer params=new StringBuffer();
				for (Iterator<?> iter=parameters.entrySet().iterator();iter.hasNext();) {
					Entry<?, ?> element=(Entry<?, ?>) iter.next();
					params.append(element.getKey().toString());
					params.append("=");
					params.append(URLEncoder.encode(element.getValue().toString(),vchartset));
					params.append("&");
				}
				if(params.length()>0){
					params=params.deleteCharAt(params.length()-1);
				}
				URL url=new URL(requrl);
				url_con=(HttpURLConnection) url.openConnection();
				url_con.setRequestMethod("GET");
				System.setProperty("连接超时：", String.valueOf(SmsUtils.connectTimeOut));
				System.setProperty("访问超时：", String.valueOf(SmsUtils.readTimeOut)); 
				url_con.setDoOutput(true);//
				byte[] b=params.toString().getBytes();
				url_con.getOutputStream().write(b, 0,b.length);
				url_con.getOutputStream().flush();
				url_con.getOutputStream().close();
				InputStream in=url_con.getInputStream();
				byte[] echo=new byte[10*1024];
				int len=in.read(echo);
				responseContent=(new String(echo,0,len).trim());
				int code = url_con.getResponseCode();
				
				System.out.println("params:"+ params);
				//System.out.println("url:"+ strwenh);
				System.out.println(url_con.getRequestMethod());
				System.out.println(url_con.getErrorStream());
				System.out.println("responseContent:"+responseContent);
				
				if (code != 200) {
					responseContent = "ERROR" + code;
				}
		} catch (Exception e) {
			System.out.println("网络故障:"+ e.toString());
		}finally{
			if(url_con!=null){
				url_con.disconnect();
			}
		}
		return responseContent;
		
	}
	public static String doGet(String reqUrl, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset=recvEncoding==""?SmsUtils.requestEncoding:recvEncoding;
		try {
				StringBuffer params = new StringBuffer();
				String queryUrl = reqUrl;
				int paramIndex = reqUrl.indexOf("?");
				
				if (paramIndex > 0) {
					queryUrl = reqUrl.substring(0, paramIndex);
					String parameters = reqUrl.substring(paramIndex + 1, reqUrl.length());
					String[] paramArray = parameters.split("&");
					for (int i = 0; i < paramArray.length; i++) {
						String string = paramArray[i];
						int index = string.indexOf("=");
						if (index > 0) {
							String parameter = string.substring(0, index);
							String value = string.substring(index + 1, string.length());
							params.append(parameter);
							params.append("=");
							params.append(URLEncoder.encode(value, vchartset));
							params.append("&");
						}
					}

					params = params.deleteCharAt(params.length() - 1);
				}
				URL url = new URL(queryUrl);
				url_con = (HttpURLConnection) url.openConnection();
				url_con.setRequestMethod("GET");
				System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(SmsUtils.connectTimeOut));
				System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(SmsUtils.readTimeOut));
				url_con.setDoOutput(true);
				byte[] b = params.toString().getBytes();
				url_con.getOutputStream().write(b, 0, b.length);
				url_con.getOutputStream().flush();
				url_con.getOutputStream().close();
				InputStream in = url_con.getInputStream();
				byte[] echo = new byte[10 * 1024];
				int len = in.read(echo);
				responseContent = (new String(echo, 0, len)).trim();
				int code = url_con.getResponseCode();
				if (code != 200) {
					responseContent = "ERROR" + code;
				}
		} catch (Exception e) {
			System.out.println("网络故障:"+ e.toString());
		}finally{
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
		
	}
	public static String doPost(String reqUrl, Map<String, String> parameters, String recvEncoding) {
		HttpURLConnection url_con = null;
 
		String responseContent = null;
		String vchartset=recvEncoding==""?SmsUtils.requestEncoding:recvEncoding;
		try {
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				params.append("&");
			}

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(SmsUtils.connectTimeOut);
			url_con.setReadTimeout(SmsUtils.readTimeOut);
			url_con.setDoOutput(true);
			//url_con.setRequestProperty("Content-Type", "plain/text; charset=utf-8"); 
			//url_con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			byte[] b = params.toString().getBytes(vchartset);
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len)).trim();
			int code = url_con.getResponseCode();
			String strwenh = url_con.getResponseMessage();
			System.out.println("params:"+ params);
			System.out.println("strwenh:"+ strwenh);
			System.out.println(url_con.getRequestMethod());
			System.out.println(url_con.getErrorStream());
			System.out.println("responseContent:"+responseContent);
			if (code != 200) {
				responseContent = "ERROR" + code;
			}

		}
		catch (IOException e) {
			System.out.println("网络故障:"+ e.toString());
		}
		finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}
	/*
	 * 发送号码：strMobile 
	 * 模板编号：strTempid
	 * 短信内容：strContent
	 * 返回值 String类型 具体参考sdk返回码
	 */
	public static String  doSendMessage(String strMobile,String strTempid,String strContent) 
	{
		String strRet = "";
		try {
			StringBuffer strurl=new StringBuffer();
			//http://mssms.cn:8000/msm/sdk/http/sendsms.jsp?content=%401%40%3D701447&username=JSMB260920&tempid=MB-2013102300&scode=593483&mobile=18551855717
			strurl.append("http://mssms.cn:8000/msm/sdk/http/sendsms.jsp?");
			strurl.append("content=");
			strurl.append(URLEncoder.encode(strContent, "gbk")); //URLEncoder.encode(strContent, "utf-8")
			strurl.append("&username=JSMB260920");
			strurl.append("&tempid=");
			strurl.append(strTempid);
			strurl.append("&scode=593483");
			strurl.append("&mobile=");
			strurl.append(strMobile);
			System.out.println("url:" + strurl);//
			//strRet = SmsUtils.doGet(strurl.toString() , "utf-8");
			strRet = httpclientGet(strurl.toString() , "utf-8");
			System.out.println("值:" + strRet);//此处为短信发送的返回值
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return strRet;
	}
	
	private static String httpclientGet(String reqUrl, String recvEncoding){
		BufferedReader in = null;
		String content = null;  
		try {
			// 定义HttpClient  
			HttpClient client = new DefaultHttpClient();  
			// 实例化HTTP方法  
			HttpGet request = new HttpGet();  
			request.setURI(new URI(reqUrl));  
			HttpResponse response = client.execute(request);  
			in = new BufferedReader(new InputStreamReader(response.getEntity()  
			        .getContent()));  
			StringBuffer sb = new StringBuffer();  
			String line = "";  
			String NL = System.getProperty("line.separator");  
			while ((line = in.readLine()) != null) {  
			    sb.append(line + NL);  
			}  
			in.close();  
			content = sb.toString();
			System.out.println("返回content:" + content);
		} catch (Exception e) {
			if (in != null) {  
                try {  
                    in.close();// 最后要关闭BufferedReader  
                } catch (Exception e1) {  
                    e1.printStackTrace();  
                }  
            }  

		}  

       return content;
	}
	
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("username", "JSMB260920");//此处填写用户账号
//		map.put("scode", "593483");//此处填写用户密码
//		map.put("mobile","18551855717");//此处填写发送号码
//		map.put("tempid","MB-2013102300");//此处填写模板短信编号
//		//map.put("extcode","1234");
//		map.put("content","@1@=123456");//此处填写模板短信内容
//		String temp = HttpPost.doPost("http://mssms.cn:8000/msm/sdk/http/sendsms.jsp",map, "utf-8");
//		System.out.println("值:" + temp);//此处为短信发送的返回值
//	}
}

