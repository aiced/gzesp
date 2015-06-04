package com.ai.gzesp.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.beans.TdPayDWOPAYLOG;
import com.ai.gzesp.dao.service.TdPayDWOPAYLOGDao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.utils.HttpUtils;
import com.ai.gzesp.utils.UniPaySignUtils;
import com.ai.gzesp.wopay.ConfigInfo;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;
import com.sinovatech.unicom.util.sign.CryptUtil;
import com.sinovatech.unicom.util.sign.PayRequestBean;
import com.sinovatech.unicom.util.sign.StoreCommon;
import com.unicompay.util.Encrypt;







@Service
public class WoPayService {
	
	@Resource 
	OrdersSql ordersSql;
	@Resource
	TdPayDWOPAYLOGDao tdPayDWOPAYLOGDao;
	@Resource
	PayService payService;
	
    private static final Logger log = Logger.getLogger(UnionPayService.class); 
    
	public  String payOrder(String url,String order_id,String fee,String flag)
	{
		
		List<Map<String, Object>> lsOrderforPay=getOrderinfoByOrerId(order_id,1);
		if (lsOrderforPay == null) {
			return "";
		}


		//String merUserId="9999999999999999";
		//String expand="18551855717";
		//以下构造支付参数
		PayRequestBean payRequest=new PayRequestBean();
		payRequest.setVersion("2.2.2");//版本号 可空
		payRequest.setLoginName("admin");//现在可以随便填写，后面要根据实际情况来填写
		payRequest.setMerNo(ConfigInfo.merchantNo);//商户号
		payRequest.setGoodsName(lsOrderforPay.get(0).get("GOODS_NAME").toString());//商品名称 可空  		lsOrderforPay.get(0).get("GOODS_NAME");
		payRequest.setStoreOrderId(order_id);//商品订单号
		payRequest.setOrderBalance(fee);//订单金额
		payRequest.setPayBalance(fee);//应付金额
		payRequest.setMerUserId(lsOrderforPay.get(0).get("USER_ID").toString());//付款用户id	可空  		lsOrderforPay.get(0).get("USER_ID");
		payRequest.setExpand(lsOrderforPay.get(0).get("PHONE_NUMBER").toString());//订单描述信息 可空 lsOrderforPay.get(0).get("PHONE_NUMBER");
        Date date = new Date();  
        System.out.println(date);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");  
        String wostoreTime = sdf.format(date);   
        payRequest.setWostoreTime(wostoreTime.substring(0,14));//商户时间
        payRequest.setRespMode("1");//应答机制
        payRequest.setCallbackUrl("http://wap.woboss.gz186.com/esp/payResult/woPay");//回调url
        //payRequest.setCallbackUrl("http://172.20.10.5/esp/payResult/woPay");//回调url
        payRequest.setServerCallUrl("http://wap.woboss.gz186.com/esp/payResult/woPayAsyn");//后台通知url
        payRequest.setStoreIndex("http://wap.woboss.gz186.com/esp/weShop/index/"+lsOrderforPay.get(0).get("USER_ID").toString());//返回商户地址	
//        payRequest.setServerCallUrl("http://172.20.10.5/esp/payResult/woPayAsyn");//后台通知url
//        payRequest.setStoreIndex("http://172.20.10.5/esp/weShop/index/"+merUserId);//返回商户地址	
// 

        payRequest.setLoginName(lsOrderforPay.get(0).get("CUST_NAME").toString());//付款用户名 可空 lsOrderforPay.get(0).get("CUST_NAME");
        payRequest.setMp("2");//标记字段
        payRequest.setStoreName("沃掌柜");//商户名称
        
        if (flag.equals("1")) //借记卡
        {
            payRequest.setStraightType("0018");//直连工具类别 可空
            payRequest.setAssignType("0018");//指定工具类别	可空

		}
        else if(flag.equals("2"))//信用卡
        {
            payRequest.setStraightType("0019");//直连工具类别 可空
            payRequest.setAssignType("0019");//指定工具类别	可空
        	payRequest.setExpandOne(lsOrderforPay.get(0).get("CUST_NAME")+"_"+lsOrderforPay.get(0).get("PSPT_NO").toString());
        }

        
        //payRequest.setBankType("");//指定银行	可空
        payRequest.setIdNo(Encrypt.crypToDes(lsOrderforPay.get(0).get("PSPT_NO").toString(), ConfigInfo.merchantSignKey));//身份证号  lsOrderforPay.get(0).get("PSPT_NO");
        payRequest.setName(Encrypt.crypToDes(lsOrderforPay.get(0).get("CUST_NAME").toString(), ConfigInfo.merchantSignKey));//真实姓名  lsOrderforPay.get(0).get("CUST_NAME");
        payRequest.setModifyDesc("00");//身份证和姓名都不可以修改
        //payRequest.setExpandOne("文辉_370402198707172514");

        String sign=StoreCommon.generateHmac(ConfigInfo.merchantSignKey, payRequest);
        System.out.println("sign="+sign);
        payRequest.setSignMsg(sign);//商户签名
		String encryptContent=CryptUtil.encryptBeanNokey(payRequest);
		System.out.println("encryptContent="+encryptContent);
		HashMap<String, String> poParams = new HashMap<String, String>();
		poParams.put("param", payRequest.getMerNo()+encryptContent);
		System.out.println("最后提交的数据："+poParams.get("param"));
		List ls = null;
		try {
			System.out.println(url);
			ls = HttpUtils.URLPost(url, poParams);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < ls.size(); i++) {
		
			String currentResult = ls.get(i).toString().trim();
			if (currentResult=="")
			{
				continue;
			}
			sb.append(currentResult);
		}
		System.out.println("ls="+ls);
		return poParams.get("param");
	}
	
	public static String queryOrder(String url,String order_id)
	{
		order_id="WSY_1432793921551";

		//以下构造查询参数
		HashMap<String, String> qoParams = new HashMap<String, String>();
		qoParams.put("merNo", ConfigInfo.merchantNo); //商户号
		qoParams.put("orderNo", order_id);//商户订单号
		qoParams.put("orderDate", "20150528");//商户订单日期
		qoParams.put("charSet", ConfigInfo.input_charset);//字符集
		qoParams.put("signType", ConfigInfo.signType_MD5);//签名方式
		
		String signMsg=UniPaySignUtils.getMd5SignMsg(qoParams, ConfigInfo.merchantSignKey, ConfigInfo.input_charset);
		qoParams.put("signMsg", signMsg);//商户签名

		List ls = null;
		try {
			System.out.println(url);
			ls = HttpUtils.HTTPSURLPost(url, qoParams);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		if (ls.size() == 0) {
			throw new RuntimeException("No response.");
		}
		System.out.println(ls);
		
		return "";
	}


	public  HashMap<String, String> refundOrder(String url,String order_id)
	{
		List<Map<String, Object>> lsOrderforRefund=getOrderinfoByOrerId(order_id,2);
		
		order_id="WSY_1432793921551"; //后面直接删除 不要犹豫
		String amount="1";// 不过感觉会有个退款的规则 1 全额退款 单位为分
		String reason="购买错误";  
		String payJournl="20131017020154365921";
		//以下构造退款参数
		HashMap<String, String> roParams = new HashMap<String, String>();
		roParams.put("refundReqJournl", payJournl); //商户退款申请单号    		lsOrderforRefund.get(0).get("PAY_FLOOD_ID");
		roParams.put("merNo", ConfigInfo.merchantNo);//商户号
		roParams.put("orderNo", order_id);//原商户订单号
		roParams.put("orderDate", "20150528");//原商户订单日期	lsOrderforRefund.get(0).get("CREATE_TIME");
		roParams.put("payJournl", payJournl);//原支付系统交易流水号 		lsOrderforRefund.get(0).get("PAY_FLOOD_ID");
		
        Date date = new Date();  
        System.out.println(date);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");  
        String dateNowStr = sdf.format(date);   
		roParams.put("merReqTime", dateNowStr.substring(0, 14));//退款申请时间
		roParams.put("amount", amount);//退款金额	lsOrderforRefund.get(0).get("PAY_BALANCE");
		roParams.put("reason", reason);//退款原因     lsOrderforRefund.get(0).get("REFUND_REASON");
		roParams.put("signType", ConfigInfo.signType_MD5);//签名方式
		
		String signMsg=UniPaySignUtils.getMd5SignMsg(roParams, ConfigInfo.merchantSignKey, ConfigInfo.input_charset);
		roParams.put("signMsg", signMsg);//商户签名

		List<String> ls = null;
		try {
			System.out.println(url);
			ls = HttpUtils.HTTPSURLPost(url, roParams);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		if (ls.size() == 0) {
			throw new RuntimeException("No response.");
		}
		
		
		if (ls.size() == 0) {
			throw new RuntimeException("No response.");
		}
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		for (int i = 0; i < ls.size(); i++) {
			String[] arrayStrings = ls.get(i).split("=",-1);
			map.put(arrayStrings[0], arrayStrings[1]);
		}

		//用于二次校验
		HashMap<String, String> mapTemp=new HashMap<String, String>();
		String reCheckSign=""; //做二次校验
		
		mapTemp.putAll(map);
		mapTemp.remove("signMsg");
		
		System.out.println("map="+map);
		System.out.println("mapTemp="+mapTemp);


		if("MD5".equalsIgnoreCase(map.get("signType"))){
			reCheckSign = UniPaySignUtils.getMd5SignMsg(mapTemp, ConfigInfo.merchantSignKey, ConfigInfo.input_charset);
		}else if("SHA-1".equalsIgnoreCase(map.get("signType"))){
			reCheckSign = UniPaySignUtils.getSha1SignMsg(mapTemp, ConfigInfo.merchantSignKey, ConfigInfo.input_charset);
		}
		
		HashMap<String, String> retMap = new HashMap<String, String>();
		
		if (map.get("signMsg") == null || !map.get("signMsg").equalsIgnoreCase(reCheckSign)) {
			System.out.println("签名验证失败！");
			return null;
		}
		
		
		System.out.println("验证签名成功！");
		return map;
	}
	
	
	//根据订单号获得相关信息_退单_支付
	private  List<Map<String, Object>> getOrderinfoByOrerId(String order_id,int flag)
	{
		//1 支付  2 退单
        //从数据库获取信息赋值
		List<Map<String, Object>> ls=null;
		switch (flag) {
		case 1:	//支付
			ls=ordersSql.getOrderforPay(order_id);
			break;
		case 2://退单
			ls=ordersSql.getOrderforRefund(order_id);
			break;
		default:
			break;
		}
		return ls;
	}
	
	
	public String callBackResultAsyn(String inputParams)
	{
		Map<String, String> paramsMap = StringUtil.params2MapForWoPay(inputParams);
		
    	System.out.println("异步回调："+paramsMap);
        //{paymentbalancedetail=, mp=2, payfloodid=20131017000932092830, 
    	//payresult=1, userid=9999999999999999, paybalance=200, 
    	//signmsg=, resptime=20150602164307, retype=1, 
    	//hmac=0eadafc0791f1073078d0349e417432b, 
    	//ss=123456789, orderid=1111111111111151, passport=}

        String orderId=paramsMap.get("orderid");//商户订单号
        String mp=paramsMap.get("mp");//将请求的参数保持不变返回
        String payfloodid=paramsMap.get("payfloodid");//交易流水号
        String payresult=paramsMap.get("payresult");//支付结果
        Boolean bpayresult=false;
        if (payresult.equals("1"))
        {
        	bpayresult=true;
		}
        else if(payresult.equals("2"))
        {
        	bpayresult=false;
		}
        String userid=paramsMap.get("userid");//商户用户id
        String paybalance=paramsMap.get("paybalance");//支付金额
        String resptime=paramsMap.get("resptime");//支付时间
        String retype=paramsMap.get("retype");//返回类型
        String hmac=paramsMap.get("hmac");//签名      

		String logId = CommonUtil.generateLogId("4");
        
        TdPayDWOPAYLOG record_payDwopaylog=new TdPayDWOPAYLOG();
        
        record_payDwopaylog.setLogId(Long.valueOf(logId));//接口调用id
        record_payDwopaylog.setPartitionId(Short.valueOf(logId.substring(logId.length()-2, logId.length())));//分区标识
        record_payDwopaylog.setPayFloodId(payfloodid);//支付交易流水号
        record_payDwopaylog.setPayResult(payresult);//支付结果
        BigDecimal bd=new BigDecimal(paybalance);
        BigDecimal bd10=new BigDecimal("10");
        record_payDwopaylog.setPayBalance(bd.multiply(bd10));//支付金额（厘）
        record_payDwopaylog.setPaymentBalanceDetail("");//金额明细
        record_payDwopaylog.setRespTime(resptime);//支付时间
        record_payDwopaylog.setReType(retype);//返回类型
        record_payDwopaylog.setUserId(userid);//商户用户id
        record_payDwopaylog.setPassport("");//沃支付账户号
        record_payDwopaylog.setMp(mp);//标识字段

        int iRet= tdPayDWOPAYLOGDao.insertSelective(record_payDwopaylog);
        
        if (iRet>0) {
        	payService.afterPaySuccess("40",bpayresult,orderId,Integer.valueOf(paybalance)*10);
	    	return "操作成功";
		}
        else {
			return "操作失败";
		}
	}
	
}
