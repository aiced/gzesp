package com.ai.gzesp.bssintf;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 2.12	移网应缴费用查询  响应类
 * 2.13	移网缴费  响应类
 * 2.14	缴费记录查询接口 响应类
 * 三个响应类共用此类，把三个响应类里的属性都加到这里，因为这3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误，
 * 代码里手动重新xstream5.alias("Resp", PayQryRsp.class); 也不起作用
 * @author xmh
 *
 */
@XStreamAlias("Resp")
public class PayCommonRsp {
	
	//这2个是通用的属性
	private String RespCode; //0000 成功
	
	private String RespDesc;
	
	//2.12移网应缴费用查询  响应类
	private String UserName;
	
	private String EparchyCode;
	
	private String EparchyNme;
	
	private String ProductName;
	
	private String Amount; //实时话费
	
	private String Balance; //可用余额（账本余额-实时话费）
	
	//2.13	移网缴费  响应类
	private String TradeId;
	
    //2.14	缴费记录查询接口 响应类
//	@XStreamImplicit(itemFieldName="PayRecord")
	private List<PayRecord> PayRecordList;

	public String getRespCode() {
		return RespCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public String getUserName() {
		return UserName;
	}

	public String getEparchyCode() {
		return EparchyCode;
	}

	public String getEparchyNme() {
		return EparchyNme;
	}

	public String getProductName() {
		return ProductName;
	}

	public String getAmount() {
		return Amount;
	}

	public String getBalance() {
		return Balance;
	}

	public String getTradeId() {
		return TradeId;
	}

	public List<PayRecord> getPayRecordList() {
		return PayRecordList;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setEparchyCode(String eparchyCode) {
		EparchyCode = eparchyCode;
	}

	public void setEparchyNme(String eparchyNme) {
		EparchyNme = eparchyNme;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}

	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}

	public void setPayRecordList(List<PayRecord> payRecordList) {
		PayRecordList = payRecordList;
	}



	
}
