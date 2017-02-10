package com.ai.gzesp.service;

import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.unionpay.MyMapConverter;
import com.ai.gzesp.utils.BssIntfUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 调用总部OSN webservice 接口业务类
 * @author xmh
 *
 */

@Service
public class OsnService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	XStream xstream = new XStream(new XppDriver(new NoNameCoder()) {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
//                boolean cdata = true;

//                @Override
//                @SuppressWarnings("rawtypes")
//                public void startNode(String name, Class clazz) {
//                    super.startNode(name, clazz);
//                }

            	//解决节点双下划线的问题
                @Override
                public String encodeNode(String name) {
                    return name;
                }

//                @Override
//                protected void writeText(QuickWriter writer, String text) {
//                    if (cdata) {
//                        writer.write("<![CDATA[");
//                        writer.write(text);
//                        writer.write("]]>");
//                    } else {
//                        writer.write(text);
//                    }
//                }
            };
        }
    });
	
	/**
	 * 调用总部osn webservice接口，校验1证5户
	 * @param param
	 * @return
	 */
	public RespInfo<String> callIntfOsn(Map<String, Object> param){
		//生成全部请求报文
		String reqXml = genEnvelope(param);
		logger.debug("【请求报文】" + reqXml); 
		//拼装post参数
		HashMap<String, String> mapxml = new HashMap<String, String>() ;
		mapxml.put("xmlmsg", reqXml);
		//发送httpclient请求，并接收响应
		String respXml = BssIntfUtil.httpSend(BssIntfUtil.OSN_SERVERURL, mapxml);
		logger.debug("【返回报文】" + respXml); 
		
		Map<String, Object> resp = (Map<String, Object>) xstream.fromXML(respXml);
		System.out.println(resp.toString());
		Map<String, Object> respBody = (Map<String, Object>) resp.get("soapenv:Body");
		Map<String, Object> respOutput = (Map<String, Object>) respBody.get("ns1218:QRY_USER_NUMBER_OUTPUT");
		Map<String, Object> respUniBssBody = (Map<String, Object>) respOutput.get("ns1218:UNI_BSS_BODY");
		Map<String, Object> respQryUserNumberRsp = (Map<String, Object>) respUniBssBody.get("ns1217:QRY_USER_NUMBER_RSP");
		String respCode = (String) respQryUserNumberRsp.get("ns1217:RESP_CODE");
		Map<String, Object> respInfo = (Map<String, Object>) respQryUserNumberRsp.get("ns1217:RESP_INFO");
		String respAmount = (String) respInfo.get("ns1217:USER_AMOUNT");
		//logger.debug(respCode + "|" + respAmount);
		
		//拼装返回
		RespInfo<String> result = new RespInfo<String>();
		result.setRespCode(Integer.parseInt(respAmount) < 5 ? "0000" : "0001"); //小于5户返回成功，其他返回失败
		result.setRespDesc(respAmount); 
		return result;
	}
	
	/**
	 * 生成一证5户webservice请求报文
	 * @param param
	 * @return
	 */
	private String genEnvelope(Map<String, Object> param){
		Map<String, Object> envelope = new LinkedHashMap<String, Object>();
		
		Map<String, Object> header = new LinkedHashMap<String, Object>();
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		
		Map<String, Object> qryUserNumberInput = new LinkedHashMap<String, Object>();
		
		Map<String, Object> uniBssHead = new LinkedHashMap<String, Object>();
		uniBssHead.put("unib1:ORIG_DOMAIN", "UCRM");
		uniBssHead.put("unib1:SERVICE_NAME", "OneCardFiveUserSer"); //
		uniBssHead.put("unib1:OPERATE_NAME", "QryUserNumber"); //
		uniBssHead.put("unib1:ACTION_CODE", "0");
		uniBssHead.put("unib1:ACTION_RELATION", "0");
		Map<String, Object> routing = new LinkedHashMap<String, Object>();
		routing.put("unib1:ROUTE_TYPE", "00");
		routing.put("unib1:ROUTE_VALUE", "28");
		uniBssHead.put("unib1:ROUTING", routing);
		uniBssHead.put("unib1:PROC_ID", BssIntfUtil.generateLogId("PROC")); //可以写死，没有用
		uniBssHead.put("unib1:TRANS_IDO", BssIntfUtil.generateLogId("TRAN")); //
		uniBssHead.put("unib1:PROCESS_TIME", BssIntfUtil.getCurentTime());  //
		Map<String, Object> comBusInfo = new LinkedHashMap<String, Object>();
		comBusInfo.put("unib1:OPER_ID", param.get("OperatorID")); //工号
		comBusInfo.put("unib1:PROVINCE_CODE", "85");
		comBusInfo.put("unib1:EPARCHY_CODE", "000");  //
		comBusInfo.put("unib1:CITY_CODE", "000000"); //
		comBusInfo.put("unib1:CHANNEL_ID", param.get("ChannelID"));  //
		comBusInfo.put("unib1:CHANNEL_TYPE", param.get("ChannelType"));  //
		comBusInfo.put("unib1:ACCESS_TYPE", "01"); 
		comBusInfo.put("unib1:ORDER_TYPE", "01"); 
		uniBssHead.put("unib1:COM_BUS_INFO", comBusInfo);
		Map<String, Object> spReserve = new LinkedHashMap<String, Object>();
		spReserve.put("unib1:TRANS_IDC", BssIntfUtil.generateLogId("")); //
		spReserve.put("unib1:CUTOFFDAY", BssIntfUtil.getCurentDay()); //
		spReserve.put("unib1:OSNDUNS", "8500"); 
		spReserve.put("unib1:HSNDUNS", "2800"); 
		spReserve.put("unib1:CONV_ID", ""); //?
		uniBssHead.put("unib1:SP_RESERVE", spReserve);
		uniBssHead.put("unib1:TEST_FLAG", "0");
		uniBssHead.put("unib1:MSG_SENDER", "8500");
		uniBssHead.put("unib1:MSG_RECEIVER", "2800");
		qryUserNumberInput.put("unib1:UNI_BSS_HEAD", uniBssHead);
		
		Map<String, Object> uniBssBody = new LinkedHashMap<String, Object>();
		Map<String, Object> qryUserNumberReq = new LinkedHashMap<String, Object>();
		qryUserNumberReq.put("qry:CHECK_TYPE", "0");
		qryUserNumberReq.put("qry:CERT_TYPE", "01");
		qryUserNumberReq.put("qry:CERT_NAME", param.get("CertName")); //
		qryUserNumberReq.put("qry:CERT_NUM", param.get("CertNum")); //
		uniBssBody.put("qry:QRY_USER_NUMBER_REQ", qryUserNumberReq);
		qryUserNumberInput.put("unib:UNI_BSS_BODY", uniBssBody);
		
		Map<String, Object> uniBssAttached = new LinkedHashMap<String, Object>();
		uniBssAttached.put("unib2:MEDIA_INFO", "");
		qryUserNumberInput.put("unib2:UNI_BSS_ATTACHED", uniBssAttached);
		
		body.put("unib:QRY_USER_NUMBER_INPUT", qryUserNumberInput);
		envelope.put("soapenv:Header", header);
		envelope.put("soapenv:Body", body);
		
		xstream.registerConverter(new MyMapConverter());  //自定义map转换器   
		xstream.alias("soapenv:Envelope", LinkedHashMap.class);
//		xstream.alias("soapenv:Header", LinkedHashMap.class);
//		xstream.alias("soapenv:Body", LinkedHashMap.class);
//		xstream.alias("unib:QRY_USER_NUMBER_INPUT", LinkedHashMap.class);
//		xstream.alias("unib1:UNI_BSS_HEAD", LinkedHashMap.class);
//		xstream.alias("unib1:ROUTING", LinkedHashMap.class);
//		xstream.alias("unib1:COM_BUS_INFO", LinkedHashMap.class);
//		xstream.alias("unib1:SP_RESERVE", LinkedHashMap.class);
//		xstream.alias("unib:UNI_BSS_BODY", LinkedHashMap.class);
//		xstream.alias("qry:QRY_USER_NUMBER_REQ", LinkedHashMap.class);
//		xstream.alias("unib2:UNI_BSS_ATTACHED", LinkedHashMap.class);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(envelope);
		//替换头部namespace
		String reqXml = xml.replace("<soapenv:Envelope>", "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:qry=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody/QryUserNumberReq\" xmlns:unib=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody\" xmlns:unib1=\"http://ws.chinaunicom.cn/unibssHead\" xmlns:unib2=\"http://ws.chinaunicom.cn/unibssAttached\">");
		//logger.debug(reqXml);
		
		return reqXml;
	}
	
	public static void main(String[] args){
		Map<String, Object> envelope = new LinkedHashMap<String, Object>();
		
		Map<String, Object> header = new LinkedHashMap<String, Object>();
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		
		Map<String, Object> qryUserNumberInput = new LinkedHashMap<String, Object>();
		
		Map<String, Object> uniBssHead = new LinkedHashMap<String, Object>();
		uniBssHead.put("unib1:ORIG_DOMAIN", "UCRM");
		uniBssHead.put("unib1:SERVICE_NAME", "OneCardFiveUserSer"); //?
		uniBssHead.put("unib1:OPERATE_NAME", "QryUserNumber"); //?
		uniBssHead.put("unib1:ACTION_CODE", "0");
		uniBssHead.put("unib1:ACTION_RELATION", "0");
		Map<String, Object> routing = new LinkedHashMap<String, Object>();
		routing.put("unib1:ROUTE_TYPE", "00");
		routing.put("unib1:ROUTE_VALUE", "28");
		uniBssHead.put("unib1:ROUTING", routing);
		uniBssHead.put("unib1:PROC_ID", "0700_29942348"); //可以写死，没有用
		uniBssHead.put("unib1:TRANS_IDO", "yl20161227160519572169"); //?
		uniBssHead.put("unib1:PROCESS_TIME", "20161227160519");  //?
		Map<String, Object> comBusInfo = new LinkedHashMap<String, Object>();
		comBusInfo.put("unib1:OPER_ID", "BSDM"); //工号
		comBusInfo.put("unib1:PROVINCE_CODE", "85");
		comBusInfo.put("unib1:EPARCHY_CODE", "000");  //
		comBusInfo.put("unib1:CITY_CODE", "000000"); //
		comBusInfo.put("unib1:CHANNEL_ID", "A1000");  //?
		comBusInfo.put("unib1:CHANNEL_TYPE", "2010101");  //?
		comBusInfo.put("unib1:ACCESS_TYPE", "01"); 
		comBusInfo.put("unib1:ORDER_TYPE", "01"); 
		uniBssHead.put("unib1:COM_BUS_INFO", comBusInfo);
		Map<String, Object> spReserve = new LinkedHashMap<String, Object>();
		spReserve.put("unib1:TRANS_IDC", "BSDM_0700_29942348SEDB01"); //?
		spReserve.put("unib1:CUTOFFDAY", "20120424"); //?
		spReserve.put("unib1:OSNDUNS", "8500"); 
		spReserve.put("unib1:HSNDUNS", "2800"); 
		spReserve.put("unib1:CONV_ID", "BSDMpsns0092AREA_94234820120424224115653"); //?
		uniBssHead.put("unib1:SP_RESERVE", spReserve);
		uniBssHead.put("unib1:TEST_FLAG", "0");
		uniBssHead.put("unib1:MSG_SENDER", "8500");
		uniBssHead.put("unib1:MSG_RECEIVER", "2800");
		qryUserNumberInput.put("unib1:UNI_BSS_HEAD", uniBssHead);
		
		Map<String, Object> uniBssBody = new LinkedHashMap<String, Object>();
		Map<String, Object> qryUserNumberReq = new LinkedHashMap<String, Object>();
		qryUserNumberReq.put("qry:CHECK_TYPE", "0");
		qryUserNumberReq.put("qry:CERT_TYPE", "01");
		qryUserNumberReq.put("qry:CERT_NAME", "曾维瑶"); //
		qryUserNumberReq.put("qry:CERT_NUM", "430822199310080863"); //
		uniBssBody.put("qry:QRY_USER_NUMBER_REQ", qryUserNumberReq);
		qryUserNumberInput.put("unib:UNI_BSS_BODY", uniBssBody);
		
		Map<String, Object> uniBssAttached = new LinkedHashMap<String, Object>();
		uniBssAttached.put("unib2:MEDIA_INFO", "");
		qryUserNumberInput.put("unib2:UNI_BSS_ATTACHED", uniBssAttached);
		
		body.put("unib:QRY_USER_NUMBER_INPUT", qryUserNumberInput);
		envelope.put("soapenv:Header", header);
		envelope.put("soapenv:Body", body);
		
	XStream xstream = new XStream(new XppDriver(new NoNameCoder()) {

        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
//                boolean cdata = true;

//                @Override
//                @SuppressWarnings("rawtypes")
//                public void startNode(String name, Class clazz) {
//                    super.startNode(name, clazz);
//                }

            	//解决节点双下划线的问题
                @Override
                public String encodeNode(String name) {
                    return name;
                }


//                @Override
//                protected void writeText(QuickWriter writer, String text) {
//                    if (cdata) {
//                        writer.write("<![CDATA[");
//                        writer.write(text);
//                        writer.write("]]>");
//                    } else {
//                        writer.write(text);
//                    }
//                }
            };
        }
    });
		xstream.registerConverter(new MyMapConverter());  //自定义map转换器   
		xstream.alias("soapenv:Envelope", LinkedHashMap.class);
//		xstream.alias("soapenv:Header", LinkedHashMap.class);
//		xstream.alias("soapenv:Body", LinkedHashMap.class);
//		xstream.alias("unib:QRY_USER_NUMBER_INPUT", LinkedHashMap.class);
//		xstream.alias("unib1:UNI_BSS_HEAD", LinkedHashMap.class);
//		xstream.alias("unib1:ROUTING", LinkedHashMap.class);
//		xstream.alias("unib1:COM_BUS_INFO", LinkedHashMap.class);
//		xstream.alias("unib1:SP_RESERVE", LinkedHashMap.class);
//		xstream.alias("unib:UNI_BSS_BODY", LinkedHashMap.class);
//		xstream.alias("qry:QRY_USER_NUMBER_REQ", LinkedHashMap.class);
//		xstream.alias("unib2:UNI_BSS_ATTACHED", LinkedHashMap.class);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(envelope);
		String reqXml = xml.replace("<soapenv:Envelope>", "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:qry=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody/QryUserNumberReq\" xmlns:unib=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody\" xmlns:unib1=\"http://ws.chinaunicom.cn/unibssHead\" xmlns:unib2=\"http://ws.chinaunicom.cn/unibssAttached\">");
		System.out.println(reqXml);
		
		String respXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><ns1218:QRY_USER_NUMBER_OUTPUT xmlns:ns1218=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody\"><ns1:UNI_BSS_HEAD xmlns:ns1=\"http://ws.chinaunicom.cn/unibssHead\"><ns1:ORIG_DOMAIN>UCRM</ns1:ORIG_DOMAIN><ns1:SERVICE_NAME>OneCardFiveUserSer</ns1:SERVICE_NAME><ns1:OPERATE_NAME>QryUserNumber</ns1:OPERATE_NAME><ns1:ACTION_CODE>1</ns1:ACTION_CODE><ns1:ACTION_RELATION>0</ns1:ACTION_RELATION><ns1:ROUTING><ns1:ROUTE_TYPE>00</ns1:ROUTE_TYPE><ns1:ROUTE_VALUE>28</ns1:ROUTE_VALUE></ns1:ROUTING><ns1:PROC_ID>0700_29942348</ns1:PROC_ID><ns1:TRANS_IDO>yl20161227160519572169</ns1:TRANS_IDO><ns1:PROCESS_TIME>20161227160519</ns1:PROCESS_TIME><ns1:RESPONSE><ns1:RSP_TYPE>0</ns1:RSP_TYPE><ns1:RSP_CODE>0000</ns1:RSP_CODE><ns1:RSP_DESC>ok</ns1:RSP_DESC></ns1:RESPONSE><ns1:COM_BUS_INFO><ns1:OPER_ID>BSDM</ns1:OPER_ID><ns1:PROVINCE_CODE>85</ns1:PROVINCE_CODE><ns1:EPARCHY_CODE>000</ns1:EPARCHY_CODE><ns1:CITY_CODE>000000</ns1:CITY_CODE><ns1:CHANNEL_ID>A1000</ns1:CHANNEL_ID><ns1:CHANNEL_TYPE>2010101</ns1:CHANNEL_TYPE><ns1:ACCESS_TYPE>01</ns1:ACCESS_TYPE><ns1:ORDER_TYPE>01</ns1:ORDER_TYPE></ns1:COM_BUS_INFO><ns1:SP_RESERVE><ns1:TRANS_IDC>201612271605197125553016808101</ns1:TRANS_IDC><ns1:CUTOFFDAY>20161227</ns1:CUTOFFDAY><ns1:OSNDUNS>8500</ns1:OSNDUNS><ns1:HSNDUNS>2800</ns1:HSNDUNS><ns1:CONV_ID>yl2016122716051957216920161227160519752</ns1:CONV_ID></ns1:SP_RESERVE><ns1:TEST_FLAG>0</ns1:TEST_FLAG><ns1:MSG_SENDER>2800</ns1:MSG_SENDER><ns1:MSG_RECEIVER>8500</ns1:MSG_RECEIVER></ns1:UNI_BSS_HEAD><ns1218:UNI_BSS_BODY><ns1217:QRY_USER_NUMBER_RSP xmlns:ns1217=\"http://ws.chinaunicom.cn/OneCardFiveUserSer/unibssBody/QryUserNumberRsp\"><ns1217:RESP_CODE>0000</ns1217:RESP_CODE><ns1217:RESP_DESC>查询客户下号码</ns1217:RESP_DESC><ns1217:RESP_INFO><ns1217:USER_AMOUNT>2</ns1217:USER_AMOUNT><ns1217:DATA_INFO><ns1217:DATA_CODE>00</ns1217:DATA_CODE><ns1217:DATA_VALUE>0</ns1217:DATA_VALUE></ns1217:DATA_INFO><ns1217:NUMBER_INFO><ns1217:SERIAL_NUMBER>18645383825</ns1217:SERIAL_NUMBER></ns1217:NUMBER_INFO><ns1217:NUMBER_INFO><ns1217:SERIAL_NUMBER>18645385486</ns1217:SERIAL_NUMBER></ns1217:NUMBER_INFO></ns1217:RESP_INFO></ns1217:QRY_USER_NUMBER_RSP></ns1218:UNI_BSS_BODY><ns2:UNI_BSS_ATTACHED xmlns:ns2=\"http://ws.chinaunicom.cn/unibssAttached\"><ns2:MEDIA_INFO>?</ns2:MEDIA_INFO></ns2:UNI_BSS_ATTACHED></ns1218:QRY_USER_NUMBER_OUTPUT></soapenv:Body></soapenv:Envelope>";
		Map<String, Object> resp = (Map<String, Object>) xstream.fromXML(respXml);
		System.out.println(resp.toString());
		Map<String, Object> respBody = (Map<String, Object>) resp.get("soapenv:Body");
		Map<String, Object> respOutput = (Map<String, Object>) respBody.get("ns1218:QRY_USER_NUMBER_OUTPUT");
		Map<String, Object> respUniBssBody = (Map<String, Object>) respOutput.get("ns1218:UNI_BSS_BODY");
		Map<String, Object> respQryUserNumberRsp = (Map<String, Object>) respUniBssBody.get("ns1217:QRY_USER_NUMBER_RSP");
		String respCode = (String) respQryUserNumberRsp.get("ns1217:RESP_CODE");
		Map<String, Object> respInfo = (Map<String, Object>) respQryUserNumberRsp.get("ns1217:RESP_INFO");
		String respAmount = (String) respInfo.get("ns1217:USER_AMOUNT");
		
		System.out.println(respCode + "|" + respAmount);
	}
	

}
