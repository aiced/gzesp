package com.ai.gzesp.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.gzesp.bssintf.CheckCustRsp;
import com.ai.gzesp.bssintf.ExistedCustomer;
import com.ai.gzesp.bssintf.NumInfo;
import com.ai.gzesp.bssintf.NumQueryRsp;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.dto.UniBSS;
import com.thoughtworks.xstream.XStream;

public class BssIntfServiceTest extends BaseTest  {

	@Autowired 
	private BssIntfService bssIntfService;
	
	@Test
	public void test1(){
      String respXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><UniBSS>    <OrigDomain>UESS</OrigDomain>    <HomeDomain>UCRM</HomeDomain>    <BIPCode>BIP2F201</BIPCode>    <BIPVer>0100</BIPVer>    <ActivityCode>T2000541</ActivityCode>    <ActionCode>1</ActionCode>    <ActionRelation>0</ActionRelation>    <Routing>        <RouteType>00</RouteType>        <RouteValue>85</RouteValue>    </Routing>    <ProcID>MCP2016061210174101</ProcID>    <TransIDO>MCP201606121017410101</TransIDO>    <TransIDH>2016061210482614627890</TransIDH>    <ProcessTime>20160612104825</ProcessTime>    <Response>        <RspType>0</RspType>        <RspCode>0000</RspCode>        <RspDesc>success</RspDesc>    </Response>    <SPReserve>        <TransIDC></TransIDC>        <CutOffDay></CutOffDay>        <OSNDUNS></OSNDUNS>        <HSNDUNS></HSNDUNS>        <ConvID></ConvID>    </SPReserve>    <TestFlag>0</TestFlag>    <MsgSender>8500</MsgSender>    <MsgReceiver>8500</MsgReceiver>    <SvcContVer>0100</SvcContVer>    <SvcCont><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><NumQueryRsp>    <RespCode>0000</RespCode>    <RespDesc>成功</RespDesc>    <NumInfo>        <NumID>15608573904</NumID>    </NumInfo>    <NumInfo>        <NumID>15608574534</NumID>    </NumInfo></NumQueryRsp>]]></SvcCont></UniBSS>";
	
      XStream xstream = new XStream();
      
		//响应报文xml转UniBSS bean
		xstream.processAnnotations(UniBSS.class);
		UniBSS uniBSSResp = (UniBSS) xstream.fromXML(respXml);
      //获取响应的svccont,并转换成 PerNumRsp
		String svcContResp = uniBSSResp.getSvcCont();
		
		xstream.processAnnotations(NumQueryRsp.class);
		NumQueryRsp numQueryRsp = (NumQueryRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<List<NumInfo>> respInfo = new RespInfo<List<NumInfo>>();
		respInfo.setRespCode(numQueryRsp.getRespCode());
		respInfo.setRespCode(numQueryRsp.getRespDesc());
		respInfo.setData(numQueryRsp.getNumInfolist());
		
		int i = 1;
	}
	
	@Test
	public void test2(){
		//发送httpclient请求，并接收响应
		String respXml = "<UniBSS>    <OrigDomain>ECIP</OrigDomain>    <HomeDomain>UCRM</HomeDomain>    <BIPCode>BGZ2F054</BIPCode>    <BIPVer>0100</BIPVer>    <ActivityCode>T2000501</ActivityCode>    <ActionCode>1</ActionCode>    <ActionRelation>0</ActionRelation>    <Routing>        <RouteType>00</RouteType>        <RouteValue>85</RouteValue>    </Routing>    <ProcID>PROC14676133534611366311</ProcID>    <TransIDO>TRAN14676133534617040193</TransIDO>    <TransIDH>2016070414443202705888</TransIDH>    <ProcessTime>20160704144432</ProcessTime>    <Response>        <RspType>2</RspType>        <RspCode>2990</RspCode>        <RspDesc>%E5%86%85%E9%83%A8%E9%94%99%E8%AF%AF</RspDesc>    </Response>    <SPReserve>        <TransIDC>14676133534622240671</TransIDC>        <CutOffDay>20160704</CutOffDay>        <OSNDUNS>0002</OSNDUNS>        <HSNDUNS>8500</HSNDUNS>        <ConvID></ConvID>    </SPReserve>    <TestFlag>0</TestFlag>    <MsgSender>8500</MsgSender>    <MsgReceiver>8500</MsgReceiver>    <SvcContVer>0100</SvcContVer>    <SvcCont><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><CheckCustRsp>    <RespCode>0001</RespCode>    <RespDesc>此前无此客户信息</RespDesc></CheckCustRsp>]]></SvcCont></UniBSS>";
		
		XStream xstream = new XStream();
		
		//响应报文xml转UniBSS bean
		xstream.processAnnotations(UniBSS.class);
		UniBSS uniBSSResp = (UniBSS) xstream.fromXML(respXml);
        //获取响应的svccont,并转换成 PerNumRsp
		String svcContResp = uniBSSResp.getSvcCont();
		System.out.println(svcContResp);
		
		xstream.processAnnotations(CheckCustRsp.class);
		CheckCustRsp checkCustRsp = (CheckCustRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<ExistedCustomer> respInfo = new RespInfo<ExistedCustomer>();
		respInfo.setRespCode(checkCustRsp.getRespCode());
		respInfo.setRespDesc(checkCustRsp.getRespDesc());
		respInfo.setData(checkCustRsp.getExistedCustomer());
		
		System.out.println("0");
	}
}
