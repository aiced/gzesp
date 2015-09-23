package com.ai.gzesp.service;

import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBANDBALANCE;
import com.ai.gzesp.dao.beans.TdOrdDBANDPAY;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.beans.TdOrdLDEALLOG;
import com.ai.gzesp.dao.service.TdOrdDBANDBALANCEDao;
import com.ai.gzesp.dao.service.TdOrdDBANDPAYDao;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.service.TdOrdLDEALLOGDao;
import com.ai.gzesp.dao.sql.RefundSql;
import com.ai.gzesp.dto.CurrProduct;
import com.ai.gzesp.dto.DiscntReq;
import com.ai.gzesp.dto.ProAndActReq;
import com.ai.gzesp.dto.ProAndActRsp;
import com.ai.gzesp.dto.Product;
import com.ai.gzesp.dto.Routing;
import com.ai.gzesp.dto.SPReserve;
import com.ai.gzesp.dto.UniBSS;
import com.ai.gzesp.dto.UserCheckReq_Req;
import com.ai.gzesp.dto.UserCheckReq_Res;
import com.ai.gzesp.recharge.FileUtils;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.HttpUtils;
import com.ai.gzesp.utils.HttpXmlClient;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.thoughtworks.xstream.XStream;

@Service
public class BssBandService {

	XStream xStream=new XStream(); 
	
	
    @Autowired
    private OrderDao orderDao;
    
    @Resource
	TdOrdDREFUNDDao tdOrdDREFUNDDao;
    
    @Resource
	TdOrdLDEALLOGDao tdOrdLDEALLOGDao;
    
    @Resource
	TdOrdDBANDPAYDao tdOrdDBANDPAYDao;
    @Resource
    TdOrdDBANDBALANCEDao tdOrdDBANDBALANCEDao;
    
    
    
	//初始化Bss发送请求协议报文：头部
	private String InitBssHead(String strPacket,String NumID,String BIPCode,String ActivityCode)
	{
		UniBSS uniBSS=new UniBSS();
		uniBSS.setOrigDomain("ECIP"); //发起方应用域代码
		uniBSS.setHomeDomain("UCRM");//归属方应用域代码
		uniBSS.setBIPCode(BIPCode);//业务功能代码
		uniBSS.setBIPVer("0100"); //业务流程版本号
		uniBSS.setActivityCode(ActivityCode);//交易代码
		uniBSS.setActionCode("0");//交易动作代码
		uniBSS.setActionRelation("0"); //交易关联性
		
		Routing routing=new Routing();
		routing.setRouteType("01");//路由类型
		routing.setRouteValue(NumID);//路由关键值
		uniBSS.setRouting(routing);//路由信息
		
		String strproceid=CommonUtil.generateBSSLogId("");
		strproceid="procid"+strproceid;
		uniBSS.setProcID(strproceid);//发起方业务流水号
		String transid=CommonUtil.generateBSSLogId("");
		transid="transid"+transid;
		uniBSS.setTransIDO(transid);//发起方交易流水号
		String strprocesstime=DateUtils.getCurentTime();
		uniBSS.setProcessTime(strprocesstime);//处理时间
		//uniBSS.setTransIDH("");
//		SPReserve spreserve=new SPReserve();
//		spreserve.setTransIDC("");//一级枢纽交易流水
//		spreserve.setCutOffDay("");//逻辑交易日
//		spreserve.setOSNDUNS("");//发起方交换节点代码
//		spreserve.setHSNDUNS("");//归属方交换节点代码
//		spreserve.setConvID("");//交换中心处理标识
//		uniBSS.setSPReserve(spreserve);
		uniBSS.setTestFlag("0");//测试标记
		uniBSS.setMsgSender("9800");//消息发送方代码
		uniBSS.setMsgReceiver("9801");//消息直接接收方代码
		uniBSS.setSvcContVer("0100");//业务内容报文的版本号
		uniBSS.setSvcCont(strPacket);//请求/应答内容
		
		//XStream xStream = new XStream();  
	    xStream.autodetectAnnotations(true);  
	    String xml = xStream.toXML(uniBSS); 
	    xml=Constants.xmlhead+xml;
	    
	    xml=xml.replace("&lt;", "<");
	    xml=xml.replace("&gt;", ">");
	    xml=xml.replace("&quot;", "\"");
	    return xml;
	}
	
	//返回当前请求的是报文
	private  String getPacket(String packet,String NumID,String BIPCode,String ActivityCode)
	{
		String sendPacket=InitBssHead(packet,NumID,BIPCode,ActivityCode);
		return sendPacket;
	}
	
	//构造用户校验及产品查询数据
	public String ReqCheckUserPacket(String NumID,String SignMsg)
	{
		UserCheckReq_Req userCheckReq_Req=new UserCheckReq_Req();
		userCheckReq_Req.setNumID(NumID);
		userCheckReq_Req.setSignMsg(SignMsg);
		
	    xStream.autodetectAnnotations(true);  
	    String xml = xStream.toXML(userCheckReq_Req);  
	    xml="<![CDATA["+Constants.xmlhead+xml+"]]>";
	    return getPacket(xml,NumID,"BIP85001","T2014081");
	}
	
	//用户校验及产品查询数据 返回解析
	public UserCheckReq_Res ResCheckUserPacket(String packet,String NumID)
	{
//		packet=DelABC();//自己构造的返回报文，以后要删掉
//		packet="<![CDATA["+Constants.xmlhead+packet+"]]>";
//
//		packet=getPacket(packet,NumID);
//		
		System.out.println("下面解析会报错："+packet);
		
		UniBSS uniBSS= (UniBSS) xStream.fromXML(packet);

		//去掉返回报文头的xml
		System.out.println("去掉返回报文头的xml:"+uniBSS.getSvcCont());
		//指定指定class解析annotations
		xStream.processAnnotations(UserCheckReq_Res.class);
		UserCheckReq_Res userCheckReq_Res=(UserCheckReq_Res)xStream.fromXML(uniBSS.getSvcCont());

		return userCheckReq_Res;

	}
	
	//调用徐总接口落订单，徐总调用奚总的支付接口，奚总调用我的产品变更接口
	//调用Bss的产品变更接口

	public String ReqProAndActPacket(String order_id)
	{
		//查询订单数据
		//通过user_id和num_id 查询得到相关的订单的数据
		//为了后面调用产品变更接口
		Map<String, Object> map=orderDao.queryBandProByOrderId(order_id);
		
		
		//根据md5key对发送报文进行签名：签名的规则为：NumID=XXX$ProductCode=XXX$OrigFee=XXX$RealFee=XXX$optTime=XXX$OldProductCode=XXX$key=XXX
		String strEncrypt="NumID="+map.get("BANDNUMID").toString()+"$ProductCode="+map.get("PRODUCT_ID").toString()+"$OrigFee="+map.get("ORIGINAL_PRICE").toString()+"$RealFee="+map.get("INCOME_MONEY").toString()+"$optTime="+map.get("CREATE_TIME").toString()+"$OldProductCode="+map.get("VALUES1").toString()+"$key="+Constants.md5key_bbs;
		System.out.println("产品变更明文："+strEncrypt);
		
		strEncrypt=MD5Util.md5s2(strEncrypt);
		System.out.println("产品变更密文："+strEncrypt);
		ProAndActReq proAndActReq=new ProAndActReq();
		
		proAndActReq.setNumID(map.get("BANDNUMID").toString());
		proAndActReq.setOldProductCode(map.get("VALUES1").toString());
		proAndActReq.setOptTime(map.get("CREATE_TIME").toString());
		proAndActReq.setOrigFee(map.get("ORIGINAL_PRICE").toString());
		proAndActReq.setProductCode(map.get("PRODUCT_ID").toString());
		proAndActReq.setRealFee(map.get("INCOME_MONEY").toString());
		proAndActReq.setSignMsg(strEncrypt);

		//构造产品变更报文
        xStream.autodetectAnnotations(true);  
        String xml = xStream.toXML(proAndActReq);  
	    xml="<![CDATA["+Constants.xmlhead+xml+"]]>";
	    xml= getPacket(xml,map.get("BANDNUMID").toString(),"BIP85002","T2014082");
		System.out.println("产品变更发送的报文："+xml);
    	String strUrl=Constants.BSS_SERVERURL;;//未来需要填写的url
		HashMap<String, String> mapxml = new HashMap<String, String>() ;
		mapxml.put("xmlmsg", xml);
		String strRet=HttpPost(strUrl,mapxml);
		
		//解析响应报文
		ProAndActRsp proAndActRsp=	ResProAndActPacket(strRet,map.get("BANDNUMID").toString());
		
		String finalproinfo="";
		
		finalproinfo=proAndActRsp.getProductActiveTime()+proAndActRsp.getProductInActiveTime();
		
		if (proAndActRsp !=null) {
			//插入bss报文请求日志表
			
			int iRet=insertBSSLog(
					"产品变更", 
					proAndActRsp.getRespCode()+proAndActRsp.getRespDesc(), 
					map.get("USER_ID").toString(), 
					map.get("BANDNUMID").toString(), 
					map.get("BANDNUMID").toString(), 
					"", 
					"",
					"",
					"",
					"",
					"",
					"", 
					"", 
					finalproinfo, 
					order_id
					);
			if (iRet>0) //插入成功
			{
				//更新宽带续约订单表ord_d_band_pay的 order_state
				//02状态固定写死
				iRet=updateOrdBandPay(order_id,"02");
				if (iRet>0) {
					return 	proAndActRsp.getRespDesc();
				}
			}
		}
		
		//直接放回结果，但是现在遇到的问题是不知道该怎么展示
		return proAndActRsp.getRespDesc();
	}
	
	//处理bss接口：产品变更，根据返回的报文做相应的解析处理
	public ProAndActRsp ResProAndActPacket(String packet,String NumID)
	{
//		packet=DelDEF();//自己构造的返回报文 以后要删掉
//		packet="<![CDATA["+Constants.xmlhead+packet+"]]>";
//
//		packet=getPacket(packet,NumID,"BIP85002","T2014082");
//		
		UniBSS uniBSS= (UniBSS) xStream.fromXML(packet);

		//去掉返回报文头的xml
		System.out.println("去掉返回报文头的xml:"+uniBSS.getSvcCont());
		xStream.processAnnotations(ProAndActRsp.class);
		ProAndActRsp proAndActRsp=(ProAndActRsp)xStream.fromXML(uniBSS.getSvcCont());

		return proAndActRsp;
	}
	
	//调用Bss接口
	//改方法只负责用http工具类发送请求
	public String HttpPost(String strUrl,Map<String, String> map)
	{
		String strRet="";//bss返回结果
    	//调用Bss接口
    	try {
    		System.out.println("values:"+map.get("xmlmsg").toString());
    		//strRet=HttpUtils.URLPost(strUrl, map,"string");//第三个参数 标识返回结果为字符串
    		strRet=HttpXmlClient.httpSend(strUrl, map);
    		//下面这行代码主要是对返回的报文进行转义其主要原因是% 在URL中是特殊字符，需要特殊转义一下，
    		System.out.println("backdata:"+strRet);
    		//strRet="%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3CUniBSS%3E%0A++++%3COrigDomain%3EECIP%3C%2FOrigDomain%3E%0A++++%3CHomeDomain%3EUCRM%3C%2FHomeDomain%3E%0A++++%3CBIPCode%3EBIP85001%3C%2FBIPCode%3E%0A++++%3CBIPVer%3E0100%3C%2FBIPVer%3E%0A++++%3CActivityCode%3ET2014081%3C%2FActivityCode%3E%0A++++%3CActionCode%3E1%3C%2FActionCode%3E%0A++++%3CActionRelation%3E0%3C%2FActionRelation%3E%0A++++%3CRouting%3E%0A++++++++%3CRouteType%3E01%3C%2FRouteType%3E%0A++++++++%3CRouteValue%3E085100386097%3C%2FRouteValue%3E%0A++++%3C%2FRouting%3E%0A++++%3CProcID%3Eprocid1441785525025%3C%2FProcID%3E%0A++++%3CTransIDO%3Etransid1441785525025%3C%2FTransIDO%3E%0A++++%3CTransIDH%3E2015090917170916474531%3C%2FTransIDH%3E%0A++++%3CProcessTime%3E20150909171709%3C%2FProcessTime%3E%0A++++%3CResponse%3E%0A++++++++%3CRspType%3E0%3C%2FRspType%3E%0A++++++++%3CRspCode%3E0000%3C%2FRspCode%3E%0A++++++++%3CRspDesc%3Esuccess%3C%2FRspDesc%3E%0A++++%3C%2FResponse%3E%0A++++%3CTestFlag%3E0%3C%2FTestFlag%3E%0A++++%3CMsgSender%3E8500%3C%2FMsgSender%3E%0A++++%3CMsgReceiver%3E8500%3C%2FMsgReceiver%3E%0A++++%3CSvcContVer%3E0100%3C%2FSvcContVer%3E%0A++++%3CSvcCont%3E%3C%21%5BCDATA%5B%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3CUserCheckReq%3E%0A++++%3CRespCode%3E0000%3C%2FRespCode%3E%0A++++%3CRespDesc%3E%E6%88%90%E5%8A%9F%3C%2FRespDesc%3E%0A++++%3CCustName%3E%E6%9D%A8%E9%87%91%E9%9B%A8%3C%2FCustName%3E%0A++++%3CProvinceCode%3E85%3C%2FProvinceCode%3E%0A++++%3CCityCode%3E850%3C%2FCityCode%3E%0A++++%3CNetType%3E05%3C%2FNetType%3E%0A++++%3CPayType%3E0%3C%2FPayType%3E%0A++++%3CUserStatus%3E01%3C%2FUserStatus%3E%0A++++%3CUserType%3E1%3C%2FUserType%3E%0A++++%3CCurrProductList%3E%0A++++++++%3CCurrProductType%3E1%3C%2FCurrProductType%3E%0A++++++++%3CCurrProductCode%3E96001221%3C%2FCurrProductCode%3E%0A++++++++%3CCurrProductName%3E20M+%E5%AE%BD%E5%B8%A6880%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FCurrProductName%3E%0A++++++++%3CProductActiveTime%3E20150828000000%3C%2FProductActiveTime%3E%0A++++++++%3CProductInActiveTime%3E20160827235959%3C%2FProductInActiveTime%3E%0A++++%3C%2FCurrProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001035%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN960%E5%85%83%E5%8C%8512%E4%B8%AA%E6%9C%88%3C%2FProductName%3E%0A++++++++%3CProductFee%3E96000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E91200%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001221%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A6880%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FProductName%3E%0A++++++++%3CProductFee%3E88000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E88000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E2%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001227%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61620%E5%85%83%E5%8C%85%E4%B8%A4%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E162000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E10%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E153900%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001238%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN%E5%AE%BD%E5%B8%A6960%E5%85%83%E5%8C%85%E5%B9%B4%EF%BC%88%E7%BB%AD%E7%BA%A6%E6%97%A0%E7%BD%91%E9%BE%84%EF%BC%89%3C%2FProductName%3E%0A++++++++%3CProductFee%3E96000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E96000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001036%3C%2FProductCode%3E%0A++++++++%3CProductName%3ELAN1200%E5%85%83%E5%8C%8512%E4%B8%AA%E6%9C%88%3C%2FProductName%3E%0A++++++++%3CProductFee%3E120000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E114000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E2%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001318%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61980%E5%85%83%E5%8C%85%E4%B8%A4%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E198000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E20%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E188100%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001319%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A61880%E5%85%83%E5%8C%85%E5%B9%B4+%3C%2FProductName%3E%0A++++++++%3CProductFee%3E188000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E50%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E188000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A++++%3CProductList%3E%0A++++++++%3CProductType%3E1%3C%2FProductType%3E%0A++++++++%3CProductCode%3E96001321%3C%2FProductCode%3E%0A++++++++%3CProductName%3E%E5%AE%BD%E5%B8%A62280%E5%85%83%E5%8C%85%E5%B9%B4%3C%2FProductName%3E%0A++++++++%3CProductFee%3E228000%3C%2FProductFee%3E%0A++++++++%3CProductRate%3E100%3C%2FProductRate%3E%0A++++++++%3CDiscntReq%3E%0A++++++++++++%3CDiscntType%3E01%3C%2FDiscntType%3E%0A++++++++++++%3CDiscntValue%3E228000%3C%2FDiscntValue%3E%0A++++++++%3C%2FDiscntReq%3E%0A++++%3C%2FProductList%3E%0A%3C%2FUserCheckReq%3E%0A%5D%5D%3E%3C%2FSvcCont%3E%0A%3C%2FUniBSS%3E%0A";
    		//strRet = strRet.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
    		strRet=URLDecoder.decode(strRet,"UTF-8");
			System.out.println("backdata_decode:"+strRet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		return strRet;
	}
	
	
	
	 /**
     * 每天凌晨1点，沃掌柜和bss系统 同步宽带续约状态 任务
     * 每次获取前一整天，产品变更记录，生成txt文件，放到/home/webapp/app/interface/band/req目录下
     */
    public void syncBandStatus2BssJob(){
    	String req_day = DateUtils.getYesterday();
    	List<LinkedHashMap<String, String>> bandList = orderDao.queryBandOrderByDate(req_day);
    	//调用奚总的写文件接口
    	FileUtils.writeBandReqFile(req_day,bandList);

    }
    
    /**
     * bss系统给沃掌柜的回执文件，需要定时任务读取
     * 每天凌晨1点，沃掌柜和bss系统 同步宽带续约状态 任务
     * 每次获取前一整天，产品变更，生成txt文件，放到/home/webapp/app/interface/band/req目录下
     */
    public void syncBandStatus2BssRespJob(){
    	String req_day = DateUtils.getYesterday();
    	//调用奚总的读文件接口
    	List<String[]> result = FileUtils.readBandRespFile(req_day);
    	//这边list数量不固定，就不用 动态sql 一次更新了，怕in太多
    	for(String[] array : result){
    		//array[0];//订单号
    		//array[1];//宽带账户id
    		//array[3];//日期
    		//array[4];//操作结果
    		
    		//这个要到宽带续约的地方去查询消息
			Map<String, Object> refundList=orderDao.queryBandProByOrderId(array[0]);
			   
    		//插入退单表
			//插入ord_l_deallog
			//添加对账日志表
			Insert_refund_log_blance(refundList,array[4]);
    	}
    }
	
    
    //这个地方直接从客户退单的controller复制过来的。比较混乱
    //插入退单表
    //插入ord_l_deallog
    //更新bss宽带续约对账表
    private void Insert_refund_log_blance(Map<String, Object> map,String strResult)
    {
    	
      	String strname=map.get("BANDNUMID").toString();
    	String strphone=map.get("BANDNUMID").toString();
    	String strreason="对账发现错误退款";
    	
    	String order_id=map.get("ORDER_ID").toString();
    	String unit_price=map.get("INCOME_MONEY").toString();
    	String Partition_Id=map.get("PARTITION_ID").toString();
    	String order_no=map.get("ORDER_ID").toString();
    	//String create_time=paramsMap.get("hide_create_time");
    	String order_from=map.get("ORDER_FROM").toString();
    	String order_time=map.get("CREATE_TIME").toString();
    	String order_state=map.get("ORDER_STATE").toString();
    	String REFUND_TYPE="09";//固定写死订单处理退单：09客户拒收退单：10
    	String REFUND_STATE="11";
    	
    	System.out.println(Partition_Id);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date_create_time=DateUtil.getNow();
    	Date date_order_time=DateUtil.getNow();
		try {
			date_order_time = sdf.parse(order_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	if (strResult.equals("0")) {

        	
        	//插入退单表
        	TdOrdDREFUND record_orddrefund=new TdOrdDREFUND();
        	record_orddrefund.setOrderId(Long.valueOf(order_id));
        	record_orddrefund.setPartitionId(Short.valueOf(Partition_Id));
        	record_orddrefund.setOrderNo(order_no);
        	record_orddrefund.setCreateTime(date_create_time);
        	record_orddrefund.setOrderFrom(order_from);
        	record_orddrefund.setOrderTime(date_order_time);
        	record_orddrefund.setCustName(strname);
        	record_orddrefund.setPhoneNumber(strphone);
        	record_orddrefund.setTxnAmt(Long.valueOf(unit_price));
        	record_orddrefund.setOrderState(order_state);
        	record_orddrefund.setRefundType(REFUND_TYPE);
        	record_orddrefund.setRefundReason(strreason);
        	record_orddrefund.setRefundState(REFUND_STATE);
        	
        	tdOrdDREFUNDDao.insertSelective(record_orddrefund);
        	
        	
           	Criteria example = new Criteria();
        	example.createConditon().andEqualTo("ORDER_ID", order_id);
        	//修改订单基本表
        	TdOrdDBANDPAY record_ordbandpay=new TdOrdDBANDPAY();
        	record_ordbandpay.setOrderState(REFUND_STATE);
        	tdOrdDBANDPAYDao.updateByExampleSelective(record_ordbandpay, example);
        	
    		String logId = CommonUtil.generateLogId("4");
        	
        	//插入状态流程日志表
        	TdOrdLDEALLOG record_deallog=new TdOrdLDEALLOG();
        	record_deallog.setOperateLogid(CommonUtil.string2Long(logId));
        	record_deallog.setOrderId(Long.valueOf(order_id));
        	record_deallog.setPartitionId(Short.valueOf(Partition_Id));
        	record_deallog.setOperateTime(date_order_time);
        	record_deallog.setOperatorId(strphone);
        	record_deallog.setOperatorName(strphone);
        	record_deallog.setDealContent("宽带续约：用户发生退单");
        	record_deallog.setResultCode("0");
        	record_deallog.setResultInfo("成功");
        	record_deallog.setOriginalState(order_state);
        	record_deallog.setCurrentState(REFUND_STATE);

        	tdOrdLDEALLOGDao.insertSelective(record_deallog);
        	
        	
		}
 
    	
    	//插入对账日志表
    	TdOrdDBANDBALANCE record_bandbalance=new TdOrdDBANDBALANCE();
    	record_bandbalance.setBandnumid(map.get("BANDNUMID").toString());
    	record_bandbalance.setCreatetime(DateUtil.getNow());
    	record_bandbalance.setLogId(CommonUtil.generateLogId("8"));
    	record_bandbalance.setOrderId(order_id);
    	record_bandbalance.setResult(strResult);
    	
    	tdOrdDBANDBALANCEDao.insertSelective(record_bandbalance);
    	
    	
    	
    	
    	
    }
    
    //宽带续约 用户查询接口：根据不同的返回值显示不同的错误提示，主要用于在界面上展示错误信息
    public String CheckReqCode(String repcode)
    {
//    	0000 成功
//    	0001 用户欠费
//    	0002 用户是黑名单
//    	0003 用户不存在
//    	0004 签名非法
//    	0005 用户产品变更后不能续约
//    	0006 用户有未正式提交工单，请半小时后再操作
//    	9999 其它错误
    	
		if(repcode.equals("0001"))
		{
			return "用户欠费";
		}
		else if(repcode.equals("0002"))
		{
			return "用户是黑名单";
		}
		else if(repcode.equals("0003"))
		{
			 return "用户不存在";
		}
		else if(repcode.equals("0004"))
		{
			return "签名非法";
		}
		else if(repcode.equals("0005"))
		{
			return "用户产品变更后不能续约";
		}	
		else if(repcode.equals("0006"))
		{
			return "用户有未正式提交工单，请半小时后再操作";
		}		
		else if(repcode.equals("9999"))
		{
			 return "其它错误";
		}
    	return "";
    }
    
    //插入Bsslog日志表
    public int insertBSSLog(String interfacename,
    		String result_code,
    		String user_id,
    		String band_numid,
    		String user_name,
    		String actprovince,
    		String actcity,
    		String nettype,
    		String paytype,
    		String userstatus,
    		String usertype,
    		String curproinfo,
    		String proinfo,
    		String finalproinfo,
    		String order_id)
    {
		String log_id=CommonUtil.generateLogId("7");
		String partition_id=log_id.substring(14,16);
    
		
		int iRet=orderDao.insertBSSLog(
				log_id,			//logid
				partition_id,	//分区id
				interfacename,	//接口名称
				DateUtils.getCurentTime(),
				result_code,
				user_id,
				band_numid,
				user_name,
				actprovince,
				actcity,
				nettype,
				paytype,
				userstatus,
				usertype,
				curproinfo,
				proinfo,
				finalproinfo,
				order_id
				);
		
		
		
		return iRet;
    }
    
    //徐总落订单以后 调用奚总支付的接口，之后奚总调用我的产品变更接口，调用成功后修改该订单的状态为02 续约成功
    public int updateOrdBandPay(String order_id,String order_state)
    {
    	int iRet=orderDao.updateOrdBandPay(order_id,order_state);
    	
    	return iRet;
    }
    
    
    
	
//	private String DelABC()
//	{
//		 CurrProduct currProduct=new CurrProduct();
//		 currProduct.setCurrProductCode("1");
//		 currProduct.setCurrProductName("我自己当前的产品1");
//		 currProduct.setCurrProductType("当前生效产品");
//		 currProduct.setProductActiveTime("20150804");
//		 currProduct.setProductInActiveTime("20160804");
//		 
//		 List<CurrProduct> currProductList=new ArrayList<CurrProduct>();
//		 
//		 currProductList.add(currProduct);
//		 
//		 Product product1=new Product();
//		 product1.setProductCode("1");
//		 product1.setProductFee("2000");
//		 product1.setProductName("我是产品1");
//		 product1.setProductRate("100M");
//		 product1.setProductType("1年产品");
//		 
//		 DiscntReq discntReq1=new DiscntReq();
//		 discntReq1.setDiscntType("折扣");
//		 discntReq1.setDiscntValue("1000");
//		 product1.setDiscntReq(discntReq1);
//		 
//		 
//		 Product product2=new Product(); 
//		 product2.setProductCode("2");
//		 product2.setProductFee("3000");
//		 product2.setProductName("我是产品2");
//		 product2.setProductRate("200M");
//		 product2.setProductType("2年产品");
//		 DiscntReq discntReq2=new DiscntReq();
//		 discntReq2.setDiscntType("赠送");
//		 discntReq2.setDiscntValue("2000");
//		 product2.setDiscntReq(discntReq2);
//		 
//		 
//		 Product product3=new Product();
//		 product3.setProductCode("3");
//		 product3.setProductFee("4000");
//		 product3.setProductName("我是产品3");
//		 product3.setProductRate("300M");
//		 product3.setProductType("3年产品");	 
//		 DiscntReq discntReq3=new DiscntReq();
//		 discntReq3.setDiscntType("折扣");
//		 discntReq3.setDiscntValue("3000");
//		 product3.setDiscntReq(discntReq3);
//		 
//		 Product product4=new Product();
//		 product4.setProductCode("4");
//		 product4.setProductFee("5000");
//		 product4.setProductName("我是产品4");
//		 product4.setProductRate("400M");
//		 product4.setProductType("4年产品");		 
//		 DiscntReq discntReq4=new DiscntReq();
//		 discntReq4.setDiscntType("赠送");
//		 discntReq4.setDiscntValue("4000");
//		 product4.setDiscntReq(discntReq4);	 
//		 
//		 Product product5=new Product();
//		 product5.setProductCode("5");
//		 product5.setProductFee("5000");
//		 product5.setProductName("我是产品5");
//		 product5.setProductRate("500M");
//		 product5.setProductType("5年产品"); 
//		 DiscntReq discntReq5=new DiscntReq();
//		 discntReq5.setDiscntType("折扣");
//		 discntReq5.setDiscntValue("5000");
//		 product5.setDiscntReq(discntReq5);		 
//		 
//		 Product product6=new Product();
//		 product6.setProductCode("6");
//		 product6.setProductFee("6000");
//		 product6.setProductName("我是产品6");
//		 product6.setProductRate("600M");
//		 product6.setProductType("6年产品");
//		 DiscntReq discntReq6=new DiscntReq();
//		 discntReq6.setDiscntType("赠送");
//		 discntReq6.setDiscntValue("6000");
//		 product6.setDiscntReq(discntReq6);
//		 
//		 Product product7=new Product();
//		 product7.setProductCode("7");
//		 product7.setProductFee("7000");
//		 product7.setProductName("我是产品7");
//		 product7.setProductRate("700M");
//		 product7.setProductType("7年产品");
//		 DiscntReq discntReq7=new DiscntReq();
//		 discntReq7.setDiscntType("赠送");
//		 discntReq7.setDiscntValue("7000");
//
//		 product7.setDiscntReq(discntReq7);		 
//		 
//		 
//		 
//		 
//		 Product product8=new Product();
//		 product8.setProductCode("8");
//		 product8.setProductFee("8000");
//		 product8.setProductName("我是产品8");
//		 product8.setProductRate("800M");
//		 product8.setProductType("8年产品");
//		 DiscntReq discntReq8=new DiscntReq();
//		 discntReq8.setDiscntType("折扣");
//		 discntReq8.setDiscntValue("8000");
//		 product8.setDiscntReq(discntReq8);
//		 
//		 
//		 List<Product> productList=new ArrayList<Product>();
//		 productList.add(product1);
//		 productList.add(product2);
//		 productList.add(product3);
//		 productList.add(product4);
//		 productList.add(product5);
//		 productList.add(product6);
//		 productList.add(product7);
//		 productList.add(product8);
//		 
//		 
//		 
//		 UserCheckReq_Res bandAcctInfo=new UserCheckReq_Res();
//		 
//		 bandAcctInfo.setRespCode("0000");
//		 bandAcctInfo.setRespDesc("ok");
//		 bandAcctInfo.setCustName("张三");
//		 bandAcctInfo.setProvinceCode("江苏");
//		 bandAcctInfo.setCityCode("南京");
//		 bandAcctInfo.setNetType("04");
//		 bandAcctInfo.setPayType("0");
//		 bandAcctInfo.setUserStatus("01");
//		 bandAcctInfo.setUserType("0");
//		 bandAcctInfo.setCurrProductList(currProductList);
//		 bandAcctInfo.setProductList(productList);
//		 
//		 
//		 //XStream xStream = new XStream();  
//        xStream.autodetectAnnotations(true);  
//        String xml = xStream.toXML(bandAcctInfo);  
//        return xml;
//		 
//		
//	}
	
	
//	public String DelDEF()
//	{
//		ProAndActRsp proAndActRsp=new ProAndActRsp();
//		
//		proAndActRsp.setRespCode("0000");
//		proAndActRsp.setRespDesc("ok");
//		proAndActRsp.setProductActiveTime("20150805");
//		proAndActRsp.setProductInActiveTime("20150905");
//		
//        xStream.autodetectAnnotations(true);  
//        String xml = xStream.toXML(proAndActRsp);  
//        return xml;
//
//	}
	
	
}
