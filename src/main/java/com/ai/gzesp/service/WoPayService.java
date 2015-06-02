package com.ai.gzesp.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import oracle.net.aso.k;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.utils.HttpUtils;
import com.ai.gzesp.utils.UniPaySignUtils;
import com.ai.gzesp.wopay.ConfigInfo;
import com.sinovatech.unicom.util.sign.CryptUtil;
import com.sinovatech.unicom.util.sign.PayRequestBean;
import com.sinovatech.unicom.util.sign.StoreCommon;
import com.unicompay.util.Encrypt;







@Service
public class WoPayService {
	
	@Resource 
	OrdersSql ordersSql;
	
    private static final Logger log = Logger.getLogger(UnionPayService.class); 
    
	public static String payOrder(String url,String order_id,String fee)
	{
		String merUserId="9999999999999999";
		String expand="18551855717";
		//以下构造支付参数

		PayRequestBean payRequest=new PayRequestBean();
		payRequest.setVersion("2.2.2");//版本号 可空
		payRequest.setLoginName("admin");//现在可以随便填写，后面要根据实际情况来填写
		payRequest.setMerNo(ConfigInfo.merchantNo);//商户号
		payRequest.setGoodsName("测试商品iphone6");//商品名称 可空
		payRequest.setStoreOrderId(order_id);//商品订单号
		payRequest.setOrderBalance(fee);//订单金额
		payRequest.setPayBalance(fee);//应付金额
		payRequest.setMerUserId(merUserId);//付款用户id	可空
		payRequest.setExpand(expand);//订单描述信息 可空
        Date date = new Date();  
        System.out.println(date);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");  
        String wostoreTime = sdf.format(date);   
        payRequest.setWostoreTime(wostoreTime.substring(0,14));//商户时间
        payRequest.setRespMode("1");//应答机制
        payRequest.setCallbackUrl("http://wap.woboss.gz186.com/esp/payResult/woPay");//回调url
        payRequest.setServerCallUrl("http://wap.woboss.gz186.com/esp/payResult/woPay");//后台通知url
        payRequest.setStoreIndex("http://wap.woboss.gz186.com/esp/weShop/index/"+merUserId);//返回商户地址	
        payRequest.setLoginName("文辉");//付款用户名 可空
        payRequest.setMp("2");//标记字段
        payRequest.setStoreName("沃掌柜");//商户名称
        payRequest.setStraightType("0018");//直连工具类别 可空
//        payRequest.setBankType("");//指定银行	可空
        payRequest.setAssignType("0018");//指定工具类别	可空

        payRequest.setIdNo(Encrypt.crypToDes("370402198707172514", ConfigInfo.merchantSignKey));//身份证号
        payRequest.setName(Encrypt.crypToDes("文辉", ConfigInfo.merchantSignKey));//真实姓名
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
		return sb.toString();
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
		//order_id="WSY_1432258066490";
		
		List<Map<String, Object>> lsOrderforRefund=getOrderinfoByOrerId(order_id);
		
		
		

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
		
		if (map.get("signMsg") == null || !map.get("signMsg").equalsIgnoreCase(reCheckSign)) {
			System.out.println("签名验证失败！");
			return null;
		}
		System.out.println("验证签名成功！");
		return map;

	}
	
	
	//根据订单号获得相关信息_退单
	private  List<Map<String, Object>> getOrderinfoByOrerId(String order_id)
	{
        //从数据库获取信息赋值
    	List<Map<String, Object>> ls=ordersSql.getOrderforRefund(order_id);
		return ls;
	}
	
}
