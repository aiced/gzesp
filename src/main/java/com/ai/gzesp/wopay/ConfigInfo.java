package com.ai.gzesp.wopay;

/**
 * 功能：设置基本配置信息 
 * 说明： 该代码是示例代码，供研究和开发联通支付接口使用，商户可以按接口自己编写。
 * 该代码只是提供一个参考，并非一定要使用。
 * 
 * 作者 联通支付平台接口开发团队
 * 版本：1.0 
 * 日期：2011-10-25 
 * 
 */
public interface ConfigInfo {

	// 商户签名密钥
	public String merchantSignKey = "ZFG6OZJ1MKX85QS2J23O7X8LFNSV2K7N";//根据实际的替换
	//商户号
	public String merchantNo = "303001300001639";//根据实际的替换
	//签名方式
	public String signType_MD5="MD5";
	public String signType_SHA="SHA-1";
	
	// 订单支付提交地址
//	public String orderPayUrl = "https://pay.unicompayment.com/servlet/MerOrderPayReqServlte.htm";//(生产环境)
	public String orderPayUrl = "http://123.125.97.238/servlet/MerOrderPayReqServlte.htm";//（测试环境）

	//单笔订单查询url
//	public String singleOrderQueryUrl = "http://123.125.97.248/query/order.htm";//（生成环境）
	public String singleOrderQueryUrl = "http://123.125.97.239/query/order.htm"; //（测试环境）

	// 字符编码格式 目前支持 GBK 或 UTF-8
	public String input_charset = "UTF-8";
}
