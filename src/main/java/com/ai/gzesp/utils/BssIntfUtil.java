package com.ai.gzesp.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.httpclient.NoHttpResponseException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;


public class BssIntfUtil {
	
	protected static Logger log = LoggerFactory.getLogger(BssIntfUtil.class);

	public static final XStream UNIBSS = new XStream();
	
	private static final String CHINA_TIME_ZONE = "Asia/Shanghai";
	
    //BSS调用接口——测试：http://130.85.50.34:7772/XMLReceiver 正式：http://130.85.50.77:7008/XMLReceiver
    public static final String BSS_SERVERURL = "http://130.85.50.77:7008/XMLReceiver";
	
    //BSS接口xml头
    public static final String xmlhead="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    
	/** GBK编码 */
    public static final String GBK = "GBK";

	/** UTF-8编码 */
    public static final String UTF8 = "UTF-8";
	
	static {
        // 时区处理
        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE);

        UNIBSS.autodetectAnnotations(true);
        //UNIBSS.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
//        UNIBSS.alias("UniBSS", UniBSS.class);
//        UNIBSS.alias("SvcCont", SvcContPerNumResp.class);
//        UNIBSS.alias("PerNumRsp", PerNumRsp.class);
        
//        UNIBSS.processAnnotations(UniBSS.class) ;
//        UNIBSS.processAnnotations(SvcContPerNumResp.class) ;
//        UNIBSS.processAnnotations(PerNumRsp.class) ;
    }
	
    /**
     * xml报文转对象 适用响应xml报文转map
     * 
     * @param xml
     * @return Object
     */
    public static Object fromXML(String xml) {
        return UNIBSS.fromXML(xml);
    }

    /**
     * 对象转xml报文 适用请求map对象转xml
     * 
     * @param obj
     * @return String
     */
    public static String toXML(Object obj) {
        return UNIBSS.toXML(obj);
    }
    
    /**
     * 生成bss接口流水号
     * prefix: 前缀
     * @param interfaceType
     * @return
     */
    public static String generateLogId(String prefix) {
    	StringBuffer sb = new StringBuffer(16);
        Random random = new Random();
        sb.append(prefix); //
        sb.append(System.currentTimeMillis()); //13位
        //加7位随机数
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        sb.append(random.nextInt(10)); //
        //加2位随机整数 0-99之间的随机整数，不足2位左补一位随机数
        //sb.append(StringUtils.leftPad(String.valueOf(random.nextInt(100)), 2, String.valueOf(random.nextInt(10)).charAt(0))); 
        return sb.toString();
    }
    
    /**
     * 获取当前时间戳 yyyyMMddHHmmss<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCurentTime(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
    }
    
    /**
     * 获取当前日期 yyyyMMdd<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCurentDay(){
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }
    
    
    /**
     * httpclient 发送xml报文到webservice服务端，并接收返回
     * esp里httpclient 版本低，不适合这个方法
     * @param url
     * @param propsMap
     * @return
     */
    public static String httpSend(String url,Map<String,String> propsMap){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		
		//获取数据
		String respXml = "";
		try{
			httppost.setEntity(new UrlEncodedFormEntity(getPostParam(propsMap), UTF8));
			String responseBody = httpclient.execute(httppost, responseHandler);//发送请求
//			httppost.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, true);
//			httppost.getParams().setParameter(CoreProtocolPNames.WAIT_FOR_CONTINUE, 5000);
	        //打印
			//log.debug("【请求参数 】", propsMap);
			//log.debug("【返回报文】", responseBody);
			respXml = URLDecoder.decode(responseBody, UTF8); //原始是%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%
	      
		}catch (Exception e){
			log.error("【bss接口调用异常】", e);
			return "bss接口调用异常";
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		return respXml;
	}
    
    /**
     * httpclient 发送xml报文到webservice服务端，并接收返回
     * @param url
     * @param propsMap
     * @return
     */
//    public static String httpSend3(String url,Map<String,String> propsMap){
//		String strRet="";
//		String respXml = "";
//		HttpClient httpClient = new HttpClient();
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
////	      //打印服务器返回的状态
////	      System.out.println(postMethod.getStatusLine());
////	      //打印返回的信息
////	      System.out.println(postMethod.getResponseBodyAsString());
//	      
//	      strRet=postMethod.getResponseBodyAsString();
//	      respXml = URLDecoder.decode(strRet, UTF8);
//		}catch (Exception e){
//			log.error("【bss接口调用异常】", e);
//			return "bss接口调用异常";
//		}finally{
//			postMethod.releaseConnection();//关闭连接
//		}
//		return respXml;
//	}     
    
    /**
     * httpclient 发送xml报文到webservice服务端，并接收返回
     * @param url
     * @param propsMap
     * @return
     */
//    public static String httpSend(String url,Map<String,String> propsMap){
//		String strRet="";
//		String respXml = "";
//
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		httpclient.setHttpRequestRetryHandler(retryHandler);
//
//		HttpPost httpPost = new HttpPost(url);
//
//		//参数设置
//		Set<String> keySet=propsMap.keySet();
//		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//		
//		int index=0;
//		for(String key:keySet){
//			nvps.add(new BasicNameValuePair(key,propsMap.get(key).toString()));
//		}
//		
//		try{
//			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//			//httpClient.executeMethod(postMethod);//发送请求
//			HttpResponse response = httpclient.execute(httpPost);
//			strRet = EntityUtils.toString(response.getEntity());
//	      
//	        respXml = URLDecoder.decode(strRet, UTF8);
//		}catch (Exception e){
//			log.error("【bss接口调用异常】", e);
//			httpPost.abort();
//			return "bss接口调用异常";
//		}finally{
//			httpPost.abort();
//			httpclient.getConnectionManager().shutdown();  
//		}
//		return respXml;
//	}    
    
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
				return entity != null ? EntityUtils.toString(entity, UTF8) : null;
			} else {
				throw new ClientProtocolException("Unexpected response status: " + status);
			}
		}
	};
	
	//为解决 broken pipe 报错
	private static HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {  
	    @Override  
	    public boolean retryRequest(IOException arg0, int arg1, HttpContext arg2) {  
	    	// 如果超过最大重试次数，那么就不要继续了 
	        if (arg1 >= 5) {  
	            return false;  
	        }  
	        // 如果服务器丢掉了连接，那么就重试
	        if (arg0 instanceof NoHttpResponseException) {  
	            return true;  
	        }
	        if (arg0 instanceof ClientProtocolException){
                return true;
            }
	        if (arg0 instanceof SSLHandshakeException) {
	            // 不要重试SSL握手异常
	            return false;
	        }
	        return false;  
	    }  
	}; 	
	
	//调用Bss接口
	//改方法只负责用http工具类发送请求
//	public String HttpPost(String strUrl,Map<String, String> map)
//	{
//		String strRet="";//bss返回结果
//    	//调用Bss接口
//    	try {
//    		log.debug("【请求参数 】", propsMap);
//    		System.out.println("values:"+map.get("xmlmsg").toString());
//    		//strRet=HttpUtils.URLPost(strUrl, map,"string");//第三个参数 标识返回结果为字符串
//    		strRet=HttpXmlClient.httpSend(strUrl, map);
//    		//下面这行代码主要是对返回的报文进行转义其主要原因是% 在URL中是特殊字符，需要特殊转义一下，
//    		System.out.println("backdata:"+strRet);
//    		//strRet="%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3CUniBSS%3E%0A++++%3COrigDomain%3EECIP%3C%2FOrigDomain%3E%0A++++%3CHomeDomain%3EUCRM%3C%2FHomeDomain%3E%0A++++%3CBIPCode%3EBIP85001%3C%2FBIPCode%3E%0A++++%3CBIPVer%3E0100%3C%2FBIPVer%3E%0A++++%3CActivityCode%3ET2014081%3C%2FActivityCode%3E%0A++++%3CActionCode%3E1%3C%2FActionCode%3E%0A++++%3CActionRelation%3E0%3C%2FActionRelation%3E%0A++++%3CRouting%3E%0A++++++++%3CRouteType%3E01%3C%2FRouteType%3E%0A++++++++%3CRouteValue%3E085100386097%3C%2FRouteValue%3E%0A++++%3C%2FRouting%3E%0A++++%3CProcID%3Eprocid1441785525025%3C%2FProcID%3E%0A++++%3CTransIDO%3Etransid1441785525025%3C%2FTransIDO%3E%0A++++%3CTransIDH%3E2015090917170916474531%3C%2FTransIDH%3E%0A++++%3CProcessTime%3E20150909171709%3C%2FProcessTime%3E%0A++++%3CResponse%3E%0A++++++++%3CRspType%3E0%3C%2FRspType%3E%0A++++++++%3CRspCode%3E0000%3C%2FRspCode%3E%0A++++++++%3CRspDesc%3Esuccess%3C%2FRspDesc%3E%0A++++%3C%2FResponse%3E%0A++++%3CTestFlag%3E0%3C%2FTestFlag%3E%0A++++%3CMsgSender%3E8500%3C%2FMsgSender%3E%0A++++%3CMsgReceiver%3E8500%3C%2FMsgReceiver%3E%0A++++%3CSvcContVer%3E0100%3C%2FSvcContVer%3E%0A++++%3CSvcCont%3E%3C%21%5BCDATA%5B%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3CUserCheckReq%3E%0A++++%3CRespCode%3E0000%3C%2FRespCode%3E%0A++++%3CRespDesc%3E%E6%88%90%E5%8A%9F%3C%2FRespDesc%3E%0A++++%3CCustName%3E%E6%9D%A8%E9%87%91%E9%9B%A8%3C%2FCustName%3E%0A++++%3CProvinceCode%3E85%3C%2FProvinceCode%3E%0A++++%3CCityCode%3E850%3C%2FCityCode%3E%0A++++%3CNetType%3E05%3C%2FNetType%3E%0A++++%3CPayType%3E0%3C%2FPayType%3E%0A++++%3CUserStatus%3E01%3C%2FUserStatus%3E%0A++++%3CUserType%3E1%3C%2FUserType%3E%0A++++%3CCurrProductList%3E%0A++++++++%3CCurrProductType%3E1%3C%2FCurrProductType%3E%0A++++++++%3CCurrProductCode%3E96001221%3C%2FCurrProductCode%3E%0A++++++++%3CCurrProductName%3E20M+%E5%AE%BD%E5%B8%A6880%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FCurrProductName%3E%0A++++++++%3CProductActiveTime%3E20150828000000%3C%2FProductActiveTime%3E%0A++++++++%3CProductInActiveTime%3E20160827235959%3C%2FProductInActiveTime%3E%0A++++%3C%2FCurrProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001035%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN960%E5%85%83%E5%8C%8512%E4%B8%AA%E6%9C%88%3C%2FProductName%3E%0A++++++++%3CProductFee%3E96000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E91200%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001221%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A6880%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FProductName%3E%0A++++++++%3CProductFee%3E88000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E88000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E2%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001227%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61620%E5%85%83%E5%8C%85%E4%B8%A4%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E162000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E153900%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001238%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN%E5%AE%BD%E5%B8%A6960%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FProductName%3E%0A++++++++%3CProductFee%3E96000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E96000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001036%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN1200%E5%85%83%E5%8C%8512%E4%B8%AA%E6%9C%88%3C%2FProductName%3E%0A++++++++%3CProductFee%3E120000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E114000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E2%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001318%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61980%E5%85%83%E5%8C%85%E4%B8%A4%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E198000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E188100%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001319%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61880%E5%85%83%E5%8C%85%E5%B9%B4+%3C%2FProductName%3E%0A++++++++%3CProductFee%3E188000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E50%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E188000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001321%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A62280%E5%85%83%E5%8C%85%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E228000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E100%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E228000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A%3C%2FUserCheckReq%3E%0A%5D%5D%3E%3C%2FSvcCont%3E%0A%3C%2FUniBSS%3E%0A";
//    		//strRet = strRet.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
//    		strRet=URLDecoder.decode(strRet,"UTF-8");
//			System.out.println("backdata_decode:"+strRet);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "";
//		}
//		
//		return strRet;
//	}

//	public static void main(String[] args) {
//		Class clazz = PerNumReq.class;
//		System.out.println(clazz.getSimpleName());
//		Type[] types = clazz.getGenericInterfaces();
//		for(Type t : types){
//			System.out.print(t);
//			System.out.print(" : ");
//			System.out.print(t.equals(IReqResp.class));
//			System.out.println();
//		}
//		System.out.println(PerNumResp.class.isAssignableFrom(IReqResp.class));
//		System.out.println(Response.class.isAssignableFrom(IReqResp.class));
//	}
}
