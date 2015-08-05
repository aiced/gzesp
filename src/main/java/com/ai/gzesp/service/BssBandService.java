package com.ai.gzesp.service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.OrderDao;
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
import com.ai.gzesp.utils.HttpUtils;
import com.ai.gzesp.utils.MD5Util;
import com.thoughtworks.xstream.XStream;

@Service
public class BssBandService {

	XStream xStream=new XStream(); 
	
    @Autowired
    private OrderDao orderDao;
    
	//初始化Bss发送请求协议报文：头部
	private String InitBssHead(String strPacket)
	{
		UniBSS uniBSS=new UniBSS();
		uniBSS.setOrigDomain(""); //发起方应用域代码
		uniBSS.setHomeDomain("");//归属方应用域代码
		uniBSS.setBIPCode("");//业务功能代码
		uniBSS.setBIPVer(""); //业务流程版本号
		uniBSS.setActivityCode("");//交易代码
		uniBSS.setActionCode("");//交易动作代码
		uniBSS.setActionRelation(""); //交易关联性
		
		Routing routing=new Routing();
		routing.setRouteType("");//路由类型
		routing.setRouteValue("");//路由关键值
		uniBSS.setRouting(routing);//路由信息
		uniBSS.setProcID("");//发起方业务流水号
		uniBSS.setTransIDO("");//发起方交易流水号
		uniBSS.setProcessTime("");//处理时间
		SPReserve spreserve=new SPReserve();
		spreserve.setTransIDC("");//一级枢纽交易流水
		spreserve.setCutOffDay("");//逻辑交易日
		spreserve.setOSNDUNS("");//发起方交换节点代码
		spreserve.setHSNDUNS("");//归属方交换节点代码
		spreserve.setConvID("");//交换中心处理标识
		uniBSS.setSPReserve(spreserve);
		uniBSS.setTestFlag("");//测试标记
		uniBSS.setMsgSender("");//消息发送方代码
		uniBSS.setMsgReceiver("");//消息直接接收方代码
		uniBSS.setSvcContVer("");//业务内容报文的版本号
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
	private  String getPacket(String packet)
	{
		String sendPacket=InitBssHead(packet);
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
	    return getPacket(xml);
	}
	
	//用户校验及产品查询数据 返回解析
	public UserCheckReq_Res ResCheckUserPacket(String packet)
	{
		packet=DelABC();//自己构造的返回报文，以后要删掉
		packet="<![CDATA["+Constants.xmlhead+packet+"]]>";

		packet=getPacket(packet);
		
		System.out.println("下面解析会报错："+packet);
		
		UniBSS uniBSS= (UniBSS) xStream.fromXML(packet);

		//去掉返回报文头的xml
		System.out.println("去掉返回报文头的xml:"+uniBSS.getSvcCont());
		UserCheckReq_Res userCheckReq_Res=(UserCheckReq_Res) xStream.fromXML(uniBSS.getSvcCont());

		return userCheckReq_Res;

	}
	
	//调用徐总接口落订单，徐总调用奚总的支付接口，奚总调用我的产品变更接口
	//调用Bss的产品变更接口
	//user_id，用户编号
	//num_id，宽带账户
	public String ReqProAndActPacket(String order_id)
	{
		//查询订单数据
		//通过user_id和num_id 查询得到相关的订单的数据
		//为了后面调用产品变更接口
		Map<String, Object> map=orderDao.queryBandProByOrderId(order_id);
		
		//根据md5key对发送报文进行签名：签名的规则为：NumID=XXX$ProductCode=XXX$OrigFee=XXX$RealFee=XXX$optTime=XXX$OldProductCode=XXX$key=XXX
		String strEncrypt="NumID="+map.get("BANDNUMID").toString()+"$ProductCode="+map.get("PRODUCT_ID").toString()+"$OrigFee="+map.get("ORIGINAL_PRICE").toString()+"$RealFee="+map.get("INCOME_MONEY").toString()+"$optTime"+map.get("CREATE_TIME").toString()+"$OldProductCode="+map.get("VALUES1").toString()+"$key="+Constants.md5key_bbs;
		strEncrypt=MD5Util.md5s2(strEncrypt);
		
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
	    xml= getPacket(xml);
		
    	String strUrl="";//未来需要填写的url
		HashMap<String, String> mapxml = new HashMap<String, String>() ;
		mapxml.put("xmlmsg", xml);
		String strRet=HttpPost(strUrl,mapxml);
		
		//解析响应报文
		ProAndActRsp proAndActRsp=	ResProAndActPacket(strRet);
		
		if (proAndActRsp !=null) {
			//插入bss报文请求日志表
			if (true) //插入成功
			{
				
			}
		}
		
		
		return proAndActRsp.getRespDesc();
	}
	
	//处理bss接口：产品变更，根据返回的报文做相应的解析处理
	public ProAndActRsp ResProAndActPacket(String packet)
	{
		packet=DelDEF();//自己构造的返回报文 以后要删掉
		packet="<![CDATA["+Constants.xmlhead+packet+"]]>";

		packet=getPacket(packet);
		
		UniBSS uniBSS= (UniBSS) xStream.fromXML(packet);

		//去掉返回报文头的xml
		System.out.println("去掉返回报文头的xml:"+uniBSS.getSvcCont());
		ProAndActRsp proAndActRsp=(ProAndActRsp) xStream.fromXML(uniBSS.getSvcCont());

		return proAndActRsp;
	}
	
	//调用Bss接口
	//改方法只负责用http工具类发送请求
	public String HttpPost(String strUrl,Map<String, String> map)
	{

		String strRet="";//bss返回结果
//    	//调用Bss接口
    	try {
			HttpUtils.URLPost(strUrl, map,"string");//第三个参数 标识返回结果为字符串
			strRet=URLDecoder.decode(strRet);
			System.out.println(strRet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		return strRet;
	}
	
	private String DelABC()
	{
		 CurrProduct currProduct=new CurrProduct();
		 currProduct.setCurrProductCode("1");
		 currProduct.setCurrProductName("我自己当前的产品1");
		 currProduct.setCurrProductType("当前生效产品");
		 currProduct.setProductActiveTime("20150804");
		 currProduct.setProductInActiveTime("20160804");
		 
		 List<CurrProduct> currProductList=new ArrayList<CurrProduct>();
		 
		 currProductList.add(currProduct);
		 
		 Product product1=new Product();
		 product1.setProductCode("1");
		 product1.setProductFee("2000");
		 product1.setProductName("我是产品1");
		 product1.setProductRate("100M");
		 product1.setProductType("1年产品");
		 
		 DiscntReq discntReq1=new DiscntReq();
		 discntReq1.setDiscntType("折扣");
		 discntReq1.setDiscntValue("1000");
		 product1.setDiscntReq(discntReq1);
		 
		 
		 Product product2=new Product(); 
		 product2.setProductCode("2");
		 product2.setProductFee("3000");
		 product2.setProductName("我是产品2");
		 product2.setProductRate("200M");
		 product2.setProductType("2年产品");
		 DiscntReq discntReq2=new DiscntReq();
		 discntReq2.setDiscntType("赠送");
		 discntReq2.setDiscntValue("2000");
		 product2.setDiscntReq(discntReq2);
		 
		 
		 Product product3=new Product();
		 product3.setProductCode("3");
		 product3.setProductFee("4000");
		 product3.setProductName("我是产品3");
		 product3.setProductRate("300M");
		 product3.setProductType("3年产品");	 
		 DiscntReq discntReq3=new DiscntReq();
		 discntReq3.setDiscntType("折扣");
		 discntReq3.setDiscntValue("3000");
		 product3.setDiscntReq(discntReq3);
		 
		 Product product4=new Product();
		 product4.setProductCode("4");
		 product4.setProductFee("5000");
		 product4.setProductName("我是产品4");
		 product4.setProductRate("400M");
		 product4.setProductType("4年产品");		 
		 DiscntReq discntReq4=new DiscntReq();
		 discntReq4.setDiscntType("赠送");
		 discntReq4.setDiscntValue("4000");
		 product4.setDiscntReq(discntReq4);	 
		 
		 Product product5=new Product();
		 product5.setProductCode("5");
		 product5.setProductFee("5000");
		 product5.setProductName("我是产品5");
		 product5.setProductRate("500M");
		 product5.setProductType("5年产品"); 
		 DiscntReq discntReq5=new DiscntReq();
		 discntReq5.setDiscntType("折扣");
		 discntReq5.setDiscntValue("5000");
		 product5.setDiscntReq(discntReq5);		 
		 
		 Product product6=new Product();
		 product6.setProductCode("6");
		 product6.setProductFee("6000");
		 product6.setProductName("我是产品6");
		 product6.setProductRate("600M");
		 product6.setProductType("6年产品");
		 DiscntReq discntReq6=new DiscntReq();
		 discntReq6.setDiscntType("赠送");
		 discntReq6.setDiscntValue("6000");
		 product6.setDiscntReq(discntReq6);
		 
		 Product product7=new Product();
		 product7.setProductCode("7");
		 product7.setProductFee("7000");
		 product7.setProductName("我是产品7");
		 product7.setProductRate("700M");
		 product7.setProductType("7年产品");
		 DiscntReq discntReq7=new DiscntReq();
		 discntReq7.setDiscntType("赠送");
		 discntReq7.setDiscntValue("7000");

		 product7.setDiscntReq(discntReq7);		 
		 
		 
		 
		 
		 Product product8=new Product();
		 product8.setProductCode("8");
		 product8.setProductFee("8000");
		 product8.setProductName("我是产品8");
		 product8.setProductRate("800M");
		 product8.setProductType("8年产品");
		 DiscntReq discntReq8=new DiscntReq();
		 discntReq8.setDiscntType("折扣");
		 discntReq8.setDiscntValue("8000");
		 product8.setDiscntReq(discntReq8);
		 
		 
		 List<Product> productList=new ArrayList<Product>();
		 productList.add(product1);
		 productList.add(product2);
		 productList.add(product3);
		 productList.add(product4);
		 productList.add(product5);
		 productList.add(product6);
		 productList.add(product7);
		 productList.add(product8);
		 
		 
		 
		 UserCheckReq_Res bandAcctInfo=new UserCheckReq_Res();
		 
		 bandAcctInfo.setRespCode("0000");
		 bandAcctInfo.setRespDesc("ok");
		 bandAcctInfo.setCustName("张三");
		 bandAcctInfo.setProvinceCode("江苏");
		 bandAcctInfo.setCityCode("南京");
		 bandAcctInfo.setNetType("ADSL");
		 bandAcctInfo.setPayType("准预付费");
		 bandAcctInfo.setUserStatus("正常");
		 bandAcctInfo.setUserType("包月用户");
		 bandAcctInfo.setCurrProductList(currProductList);
		 bandAcctInfo.setProductList(productList);
		 
		 
		 //XStream xStream = new XStream();  
        xStream.autodetectAnnotations(true);  
        String xml = xStream.toXML(bandAcctInfo);  
        return xml;
		 
		
	}
	
	
	public String DelDEF()
	{
		ProAndActRsp proAndActRsp=new ProAndActRsp();
		
		proAndActRsp.setRespCode("0000");
		proAndActRsp.setRespDesc("ok");
		proAndActRsp.setProductActiveTime("20150805");
		proAndActRsp.setProductInActiveTime("20150905");
		
        xStream.autodetectAnnotations(true);  
        String xml = xStream.toXML(proAndActRsp);  
        return xml;

	}
	
	
}
