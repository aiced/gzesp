package com.ai.gzesp.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.gzesp.wopay.ConfigInfo;



/**
 * 
*   
* 项目名称：UnicomPayDemos_V1  
* 类名称：HttpUtils  
* 类描述：  
* 创建人：wenh  
* 创建时间：Aug 21, 2014 1:01:45 PM  
* 修改人：Administrator  
* 修改时间：Aug 21, 2014 1:01:45 PM  
* 修改备注：  
* @version   
*
 */
public class HttpUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class
			.getClass());

	/**
	 * HTTP协议 POST 方法
	 * 
	 * @param url
	 * @param map
	 * @return List
	 * @throws Exception
	 */
	public static List URLPost(String url, Map map) throws Exception {
		URL sendurl = new URL(url);

		HttpURLConnection httpURLConnection = (HttpURLConnection) sendurl
				.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset="
						+ ConfigInfo.input_charset);

		StringBuffer sb = new StringBuffer();

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			sb.append(pairs.getKey()).append("=").append(
					URLEncoder.encode(pairs.getValue().toString(),
							ConfigInfo.input_charset)).append("&");
		}
		if (sb.length() > 0)// delete last & char
		{
			sb.setLength(sb.length() - 1);
		}

		// send data
		String sendData = sb.toString();

		OutputStream out = httpURLConnection.getOutputStream();
		out.write(sendData.getBytes("iso8859-1"));
		out.flush();
		out.close();

		InputStream in = httpURLConnection.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				ConfigInfo.input_charset));

		List<String> result = new ArrayList<String>();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			} else {
				result.add(line);
			}
		}

		reader.close();
		in.close();

		return result;
	}
	/**
	 * HTTP协议 POST 方法
	 * 
	 * @param url
	 * @param map
	 * @return String
	 * @throws Exception
	 */
	public static String URLPost(String urlAddress, Map<String, String> paramMap,String flag) throws Exception {
		if (paramMap == null) {
			paramMap = new HashMap<String, String>();
		}
		String[] params = new String[paramMap.size()];
		int i = 0;
		for (String paramKey : paramMap.keySet()) {
			String param = paramKey + "=" + paramMap.get(paramKey);
			params[i] = param;
			i++;
		}
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			url = new URL(urlAddress);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			String paramsTemp = "";
			for (String param : params) {
				if (param != null && !"".equals(param.trim())) {
					paramsTemp += "&" + param;
				}
			}
			byte[] b = paramsTemp.getBytes();
			con.getOutputStream().write(b, 0, b.length);
			con.getOutputStream().flush();
			con.getOutputStream().close();
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				} else {
					result.append(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (con != null) {
					con.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result.toString();
		
//		URL sendurl = new URL(url);
//
//		HttpURLConnection httpURLConnection = (HttpURLConnection) sendurl
//				.openConnection();
//		httpURLConnection.setRequestMethod("POST");
////		httpURLConnection.setDoInput(true);
////		httpURLConnection.setDoOutput(true);
////		httpURLConnection.setUseCaches(false);
////		httpURLConnection.setRequestProperty("Content-Type",
////				"application/x-www-form-urlencoded;charset="
////						+ ConfigInfo.input_charset);
//
//		StringBuffer sb = new StringBuffer();
//
//		Iterator it = map.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry pairs = (Map.Entry) it.next();
//			sb.append(pairs.getKey()).append("=").append(
//					URLEncoder.encode(pairs.getValue().toString(),
//							ConfigInfo.input_charset)).append("&");
//		}
//		if (sb.length() > 0)// delete last & char
//		{
//			sb.setLength(sb.length() - 1);
//		}
//
//		// send data
//		String sendData = sb.toString();
//
//		OutputStream out = httpURLConnection.getOutputStream();
//		out.write(sendData.getBytes("iso8859-1"));
//		out.flush();
//		out.close();
//
//		InputStream in = httpURLConnection.getInputStream();
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
//				ConfigInfo.input_charset));
//
//		StringBuffer result = new StringBuffer();
//		while (true) {
//			String line = reader.readLine();
//			if (line == null) {
//				break;
//			} else {
//				result.append(line);
//			}
//		}
//
//		reader.close();
//		in.close();
//		return result.toString();
	}
	/**
	 * HTTPS 协议 
	 * @param url
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static List HTTPSURLPost(String url, Map map) throws Exception {

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
				new java.security.SecureRandom());
		URL console = new URL(url);

		StringBuffer postData = new StringBuffer();

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			postData.append(pairs.getKey()).append("=").append(
					URLEncoder.encode(pairs.getValue().toString(),
							ConfigInfo.input_charset)).append("&");
		}
		logger.info("请求参数：" + postData);
		HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
		conn.setSSLSocketFactory(sc.getSocketFactory());
		conn.setHostnameVerifier(new TrustAnyHostnameVerifier());

		conn.setDoInput(true);
		conn.setDoOutput(true);
		BufferedOutputStream hurlBufOus = new BufferedOutputStream(conn
				.getOutputStream());
		hurlBufOus.write(postData.toString().getBytes("iso8859-1"));// 这里面已经将RequestMethod设置为POST.前面设置无效
		hurlBufOus.flush();

		conn.connect();
		logger.info("返回结果状态码：" + conn.getResponseCode());
		InputStream in = conn.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				ConfigInfo.input_charset));

		List<String> result = new ArrayList<String>();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			} else {
				result.add(line);
			}
		}

		reader.close();
		in.close();

		return result;
	}

	
	
	
	
	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ms.S");
		HttpUtils h = new HttpUtils();
		try {
			for (int i = 0; i < 20; i++) {
				
				System.out.println("i:" + i + sdf.format(new Date()) +"--->>" + h.HTTPSURLPost(
						"https://epay.10010.com/pay/query/order.htm?reqCharSet=UTF-8",
						new HashMap()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
