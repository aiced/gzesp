package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.bssintf.AccountInfo;
import com.ai.gzesp.bssintf.AccountReq;
import com.ai.gzesp.bssintf.AccountRsp;
import com.ai.gzesp.bssintf.CheckCustReq;
import com.ai.gzesp.bssintf.CheckCustRsp;
import com.ai.gzesp.bssintf.CheckResReq;
import com.ai.gzesp.bssintf.CheckResRsp;
import com.ai.gzesp.bssintf.CheckRuleReq;
import com.ai.gzesp.bssintf.CheckRuleRsp;
import com.ai.gzesp.bssintf.ExistedCustomer;
import com.ai.gzesp.bssintf.FeeInfo;
import com.ai.gzesp.bssintf.FeeQryReq;
import com.ai.gzesp.bssintf.FeeQryRsp;
import com.ai.gzesp.bssintf.GetCardDataReq;
import com.ai.gzesp.bssintf.GetCardDataRsp;
import com.ai.gzesp.bssintf.NewCustomerInfo;
import com.ai.gzesp.bssintf.NumInfo;
import com.ai.gzesp.bssintf.NumQueryReq;
import com.ai.gzesp.bssintf.NumQueryRsp;
import com.ai.gzesp.bssintf.OrderSubReq;
import com.ai.gzesp.bssintf.OrderSubRsp;
import com.ai.gzesp.bssintf.PayCommonRsp;
import com.ai.gzesp.bssintf.PayInfo;
import com.ai.gzesp.bssintf.PayQryReq;
import com.ai.gzesp.bssintf.PayQryRsp;
import com.ai.gzesp.bssintf.PayRecord;
import com.ai.gzesp.bssintf.PayReq;
import com.ai.gzesp.bssintf.PayRsp;
import com.ai.gzesp.bssintf.ProCompInfo;
import com.ai.gzesp.bssintf.ProductInfo;
import com.ai.gzesp.bssintf.QueryParas;
import com.ai.gzesp.bssintf.ResourcesInfo;
import com.ai.gzesp.bssintf.RouteReq;
import com.ai.gzesp.bssintf.RouteRsp;
import com.ai.gzesp.bssintf.UserCheckReq;
import com.ai.gzesp.bssintf.UserCheckRsp;
import com.ai.gzesp.bssintf.UserInfo;
import com.ai.gzesp.bssintf.WriteCardPreReq;
import com.ai.gzesp.bssintf.WriteCardPreRsp;
import com.ai.gzesp.bssintf.WriteCardReq;
import com.ai.gzesp.bssintf.WriteCardRsp;
import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.dao.UserDao;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.dto.Routing;
import com.ai.gzesp.dto.SPReserve;
import com.ai.gzesp.dto.UniBSS;
import com.ai.gzesp.utils.BssIntfUtil;
import com.ai.gzesp.utils.RegexUtil;
import com.thoughtworks.xstream.XStream;

/**
 * bss 本地webservice接口 调用
 * @author xmh
 *
 */
@Service
public class BssIntfService {
	
	protected static Logger log = LoggerFactory.getLogger(BssIntfService.class);
	
	private XStream xstream = new XStream();
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OsnService osnService;
	
	/**
	 * 2.3	客户资料验证接口
	 * @param param
	 * @return
	 */
	public RespInfo<List<ExistedCustomer>> callIntfCheckCust(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContCheckCust(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000501", svcCont, null);
		xstream.processAnnotations(CheckCustRsp.class);
		CheckCustRsp checkCustRsp = (CheckCustRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<List<ExistedCustomer>> respInfo = new RespInfo<List<ExistedCustomer>>();
		respInfo.setRespCode(checkCustRsp.getRespCode());
		respInfo.setRespDesc(checkCustRsp.getRespDesc());
		respInfo.setData(checkCustRsp.getListExistedCustomer());
		return respInfo;
	}
	
	/**
	 * 生成客户资料验证接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContCheckCust(Map<String, Object> param){
		CheckCustReq checkCustReq = genCheckCustReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(checkCustReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 CheckCustReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private CheckCustReq genCheckCustReq(Map<String, Object> param){
		CheckCustReq checkCustReq = new CheckCustReq();
		
		checkCustReq.setOperatorID((String)param.get("OperatorID"));
		checkCustReq.setProvince((String)param.get("Province"));
		checkCustReq.setCity((String)param.get("City"));
		checkCustReq.setDistrict((String)param.get("District"));
		checkCustReq.setChannelID((String)param.get("ChannelID"));
		checkCustReq.setChannelType((String)param.get("ChannelType"));
		checkCustReq.setAccessType((String)param.get("AccessType"));
		checkCustReq.setCertType((String)param.get("CertType"));
		checkCustReq.setCertNum((String)param.get("CertNum"));
		checkCustReq.setServiceType((String)param.get("ServiceType"));
		//checkCustReq.setAreaCode(param.get("AreaCode"));
		//checkCustReq.setNumID(param.get("NumID"));
		
		return checkCustReq;
	}
	
	/**
	 * 用户验证接口
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfUserCheck(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContUserCheck(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2030509", svcCont, null);
		xstream.processAnnotations(UserCheckRsp.class);
		UserCheckRsp userCheckRsp = (UserCheckRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(userCheckRsp.getRespCode());
		respInfo.setRespDesc(userCheckRsp.getRespDesc());
		return respInfo;
	}
	
	/**
	 * 生成用户验证接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContUserCheck(Map<String, Object> param){
		UserCheckReq userCheckReq = genUserCheckReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(userCheckReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 UserCheckReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private UserCheckReq genUserCheckReq(Map<String, Object> param){
		UserCheckReq userCheckReq = new UserCheckReq();
		
		userCheckReq.setOperatorID((String)param.get("OperatorID"));
		userCheckReq.setProvince((String)param.get("Province"));
		userCheckReq.setCity((String)param.get("City"));
		userCheckReq.setDistrict((String)param.get("District"));
		userCheckReq.setChannelID((String)param.get("ChannelID"));
		userCheckReq.setChannelType((String)param.get("ChannelType"));
		userCheckReq.setAccessType((String)param.get("AccessType"));
		//userCheckReq.setCertType(param.get("CertType"));
		//userCheckReq.setCertNum(param.get("CertNum"));
		userCheckReq.setServiceType((String)param.get("ServiceType"));
		//checkCustReq.setAreaCode(param.get("AreaCode"));
		//userCheckReq.setNumID(param.get("NumID")); //是否需要待测试再确定
		
		return userCheckReq;
	}
	
	/**
	 * 2.4	移动号码查询接口
	 * @param param
	 * @return
	 */
	public RespInfo<List<NumInfo>> callIntfNumQuery(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContNumQuery(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000541", svcCont, null);
		xstream.processAnnotations(NumQueryRsp.class);
		NumQueryRsp numQueryRsp = (NumQueryRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<List<NumInfo>> respInfo = new RespInfo<List<NumInfo>>();
		respInfo.setRespCode(numQueryRsp.getRespCode());
		respInfo.setRespDesc(numQueryRsp.getRespDesc());
		respInfo.setData(numQueryRsp.getNumInfolist());
		return respInfo;
	}
	
	/**
	 * 生成移动号码查询接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContNumQuery(Map<String, Object> param){
		NumQueryReq numQueryReq = genNumQueryReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(numQueryReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 NumQueryReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private NumQueryReq genNumQueryReq(Map<String, Object> param){
		NumQueryReq numQueryReq = new NumQueryReq();
		
		numQueryReq.setOperatorID((String)param.get("OperatorID"));
		numQueryReq.setProvince((String)param.get("Province"));
		numQueryReq.setCity((String)param.get("City"));
		numQueryReq.setDistrict((String)param.get("District"));
		numQueryReq.setChannelID((String)param.get("ChannelID"));
		numQueryReq.setChannelType((String)param.get("ChannelType"));
		numQueryReq.setAccessType((String)param.get("AccessType"));
		numQueryReq.setSerType((String)param.get("SerType"));
		
		QueryParas queryParas = new QueryParas();
		queryParas.setQueryType((String)param.get("QueryType"));
		queryParas.setQueryPara1((String)param.get("QueryPara1"));
		numQueryReq.setQueryParas(queryParas);
		
		numQueryReq.setProductID((String)param.get("ProductID"));
		
		return numQueryReq;
	}	
	
	/**
	 * 2.5	资源操作接口
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfCheckRes(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContCheckRes(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000502", svcCont, null);
		xstream.processAnnotations(CheckResRsp.class);
		CheckResRsp checkResRsp = (CheckResRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(checkResRsp.getResourcesRsp().getRscStateCode());
		respInfo.setRespDesc(checkResRsp.getResourcesRsp().getRscStateDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("ResourcesCode", checkResRsp.getResourcesRsp().getResourcesCode());
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成资源操作接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContCheckRes(Map<String, Object> param){
		CheckResReq checkResReq = genCheckResReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(checkResReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 CheckResReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private CheckResReq genCheckResReq(Map<String, Object> param){
		CheckResReq checkResReq = new CheckResReq();
		
		checkResReq.setOperatorID((String)param.get("OperatorID"));
		checkResReq.setProvince((String)param.get("Province"));
		checkResReq.setCity((String)param.get("City"));
		checkResReq.setDistrict((String)param.get("District"));
		checkResReq.setChannelID((String)param.get("ChannelID"));
		checkResReq.setChannelType((String)param.get("ChannelType"));
		checkResReq.setAccessType((String)param.get("AccessType"));
		
		ResourcesInfo resourcesInfo = new ResourcesInfo();
		resourcesInfo.setResourcesType((String)param.get("ResourcesType"));
		resourcesInfo.setResourcesCode((String)param.get("ResourcesCode"));
		resourcesInfo.setOccupiedFlag((String)param.get("OccupiedFlag"));
		checkResReq.setResourcesInfo(resourcesInfo);
		
		return checkResReq;
	}	
	
	/**
	 * 2.6	订购信息合法性验证与费用计算
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, Object>> callIntfCheckRule(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContCheckRule(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000543", svcCont, null);
		xstream.processAnnotations(CheckRuleRsp.class);
		CheckRuleRsp checkRuleRsp = (CheckRuleRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, Object>> respInfo = new RespInfo<Map<String, Object>>();
		respInfo.setRespCode(checkRuleRsp.getRspCode());
		respInfo.setRespDesc(checkRuleRsp.getRspDesc());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("TotalFee", checkRuleRsp.getTotalFee());
		data.put("listFeeInfo", checkRuleRsp.getListFeeInfo());
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成订购信息合法性验证与费用计算接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContCheckRule(Map<String, Object> param){
		CheckRuleReq checkRuleReq = genCheckRuleReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(checkRuleReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 CheckRuleReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private CheckRuleReq genCheckRuleReq(Map<String, Object> param){
		CheckRuleReq checkRuleReq = new CheckRuleReq();
		
		checkRuleReq.setOperatorID((String)param.get("OperatorID"));
		checkRuleReq.setProvince((String)param.get("Province"));
		checkRuleReq.setCity((String)param.get("City"));
		checkRuleReq.setDistrict((String)param.get("District"));
		checkRuleReq.setChannelID((String)param.get("ChannelID"));
		checkRuleReq.setChannelType((String)param.get("ChannelType"));
		checkRuleReq.setAccessType((String)param.get("AccessType"));
		checkRuleReq.setNumID((String)param.get("NumID"));
//		NumberInfo numberInfo = new NumberInfo();
//		numberInfo.setNumID(param.get("NumID"));
//		checkRuleReq.setNumberInfo(numberInfo);
		
		//checkRuleReq.setServiceType(serviceType);
		checkRuleReq.setGuarantorType((String)param.get("GuarantorType"));
		checkRuleReq.setGuaratorID((String)param.get("GuaratorID")); //填0
		checkRuleReq.setGroupFlag((String)param.get("GroupFlag"));
		checkRuleReq.setSerType((String)param.get("SerType"));
		
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductID((String)param.get("ProductID"));
		List<ProCompInfo> list = new ArrayList<ProCompInfo>();
		List<String> discountList = (List<String>)param.get("discountList");
		for(String discount : discountList){
			ProCompInfo proCompInfo = new ProCompInfo();
			proCompInfo.setProFinanceID(discount);
			list.add(proCompInfo); 
		}
		productInfo.setProCompInfoList(list);
		
		checkRuleReq.setProductInfo(productInfo);
		
		
		return checkRuleReq;
	}
	
	/**
	 * 2.7	开户信息预提交接口
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfAccount(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContAccount(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2030544", svcCont, null);
		xstream.processAnnotations(AccountRsp.class);
		AccountRsp accountRsp = (AccountRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(accountRsp.getRespCode());
		respInfo.setRespDesc(accountRsp.getRespDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("ProvOrderID", accountRsp.getProvOrderID());
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成开户信息预提交接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContAccount(Map<String, Object> param){
		AccountReq accountReq = genAccountReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(accountReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 AccountReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private AccountReq genAccountReq(Map<String, Object> param){
		AccountReq accountReq = new AccountReq();
		
		accountReq.setOperatorID((String)param.get("OperatorID"));
		accountReq.setProvince((String)param.get("Province"));
		accountReq.setCity((String)param.get("City"));
		accountReq.setDistrict((String)param.get("District"));
		accountReq.setChannelID((String)param.get("ChannelID"));
		accountReq.setChannelType((String)param.get("ChannelType"));
		accountReq.setAccessType((String)param.get("AccessType"));
		accountReq.setOrdersID((String)param.get("OrdersID"));
		accountReq.setNumID((String)param.get("NumID"));
		accountReq.setCertTag((String)param.get("CertTag"));
		accountReq.setSerType((String)param.get("SerType"));
		//accountReq.setSerType(param.get("CustomerID"));
		accountReq.setFirstMonBillMode((String)param.get("FirstMonBillMode"));
		accountReq.setRealNameType((String)param.get("RealNameType"));
		
		//如果参数里 有CustomerID，表示之前客户验证接口返回了CustomerID，不需要创建新客户
		//后来陈伟说，新规范里，不管有没有客户，都需要传最新的客户信息
		if(StringUtils.isNotEmpty((String)param.get("CustomerID"))){
			//accountReq.setSerType((String)param.get("CustomerID"));
			accountReq.setCustomerID((String)param.get("CustomerID"));
		}
//		else{
			NewCustomerInfo newCustomerInfo = new NewCustomerInfo();
			newCustomerInfo.setCustomerType((String)param.get("CustomerType"));
			newCustomerInfo.setCustomerLevel((String)param.get("CustomerLevel"));
			newCustomerInfo.setCustomerLoc((String)param.get("CustomerLoc"));
			newCustomerInfo.setCertType((String)param.get("CertType"));
			newCustomerInfo.setCertNum((String)param.get("CertNum"));
			newCustomerInfo.setCustomerName((String)param.get("CustomerName"));
			newCustomerInfo.setCustomerPasswd((String)param.get("CustomerPasswd"));
			newCustomerInfo.setReleOfficeID((String)param.get("ReleOfficeID"));
			newCustomerInfo.setCertExpireDate((String)param.get("CertExpireDate"));
			newCustomerInfo.setCustomerZip((String)param.get("CustomerZip"));
			newCustomerInfo.setCustomerAddr((String)param.get("CustomerAddr"));
			newCustomerInfo.setContactPerson((String)param.get("ContactPerson"));
			newCustomerInfo.setContactPhone((String)param.get("ContactPhone"));
			newCustomerInfo.setContactAddr((String)param.get("ContactAddr"));
			newCustomerInfo.setCustomerSex((String)param.get("CustomerSex"));
			newCustomerInfo.setCustomerBirth((String)param.get("CustomerBirth"));
			newCustomerInfo.setCertAddr((String)param.get("CertAddr"));
			newCustomerInfo.setCustStatus((String)param.get("CustStatus"));
			accountReq.setNewCustomerInfo(newCustomerInfo);			
//		}
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName((String)param.get("CustomerName")); //(String)param.get("UserName")
		userInfo.setUserPasswd((String)param.get("CustomerPasswd"));//(String)param.get("UserPasswd")
//		userInfo.setCreditVale((String)param.get("CreditVale"));
//		userInfo.setCheckCreditVale((String)param.get("CheckCreditVale"));
		userInfo.setPackID((String)param.get("ProductID")); //(String)param.get("PackID")
		userInfo.setUserAddr((String)param.get("CustomerAddr")); //(String)param.get("UserAddr")
//		userInfo.setGuarantorType((String)param.get("GuarantorType"));
//		userInfo.setGuaratorID((String)param.get("GuaratorID"));
//		userInfo.setGroupFlag((String)param.get("GroupFlag"));
		userInfo.setRecomDeparID((String)param.get("channelCode"));
		userInfo.setRecomDeparName((String)param.get("channelName"));
		userInfo.setRecomPersonID((String)param.get("developerCode"));
		userInfo.setRecomPersonName((String)param.get("developerName"));
		userInfo.setBrandID("04"); //(String)param.get("BrandID") 04 沃
//		userInfo.setUserType((String)param.get("UserType"));
//		userInfo.setCertExpireDate((String)param.get("CertExpireDate"));
//		userInfo.setCertAddr((String)param.get("CertAddr"));
//		userInfo.setContactAddr((String)param.get("ContactAddr"));
//		userInfo.setContactPhone((String)param.get("ContactPhone"));
//		userInfo.setBillSendType((String)param.get("BillSendType"));
		accountReq.setUserInfo(userInfo);
		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountName((String)param.get("CustomerName")); //(String)param.get("AccountName")
		accountInfo.setAccountPasswd((String)param.get("CustomerPasswd")); //(String)param.get("AccountPasswd")
		accountInfo.setAccountPayType("10"); //(String)param.get("AccountPayType") 10 现金
		accountInfo.setAcctType((String)param.get("AcctType")); //(String)param.get("AcctType")
		accountInfo.setAccountAddr((String)param.get("CustomerAddr")); //(String)param.get("AccountAddr")
		accountInfo.setAccountZip("550000"); //(String)param.get("AccountZip")
//		accountInfo.setAccountPhone((String)param.get("AccountPhone"));
//		accountInfo.setContactPhone((String)param.get("ContactPhone"));
//		accountInfo.setContactAddr((String)param.get("ContactAddr"));
//		accountInfo.setPaymentAddr((String)param.get("PaymentAddr"));
//		accountInfo.setBillRecvAddr((String)param.get("BillRecvAddr"));
		accountInfo.setBillSendCont("01"); //(String)param.get("BillSendCont") 01-账单
		accountInfo.setSendBillFlag("2"); //(String)param.get("SendBillFlag") 1-寄送，2-不寄送
		accountReq.setAccountInfo(accountInfo);
		
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductID((String)param.get("ProductID"));
		
		//下面这段是资费
		List<ProCompInfo> list = new ArrayList<ProCompInfo>();
		//discountList 如果界面没选必选叠加包和可选叠加包，则为null
		if(param.get("discountList") != null){
			List<String> discountList = (List<String>)param.get("discountList");
			for(String discount : discountList){
				ProCompInfo proCompInfo = new ProCompInfo();
				proCompInfo.setProFinanceID(discount);
				list.add(proCompInfo); 
			}
		}
		if(CollectionUtils.isNotEmpty(list)){
			productInfo.setProCompInfoList(list);
		}
		
		accountReq.setProductInfo(productInfo);
		
		accountReq.setOrigTotalFee((String)param.get("OrigTotalFee"));
		
		PayInfo payInfo = new PayInfo();
		payInfo.setPayType("10"); //10：现金
		accountReq.setPayInfo(payInfo);
		
//		FeeInfo feeInfo = new FeeInfo();
//		feeInfo.setFeeID("100056"); //这边写死预存款 存50送100，韩德勇和秦锡娟说以后存100送200也配置成这个
//		feeInfo.setFeeCategory("2"); //2:预存费用
//		feeInfo.setOrigFee((String)param.get("OrigTotalFee"));
//		feeInfo.setReliefFee("0"); //减免金额默认0
//		feeInfo.setReliefResult("无减免原因");
//		feeInfo.setRealFee((String)param.get("OrigTotalFee"));
//		accountReq.setFeeInfo(feeInfo);
		
		List<FeeInfo> listFeeInfo = (List<FeeInfo>) param.get("listFeeInfo");
		List<FeeInfo> newListFeeInfo = new ArrayList<FeeInfo>();
		for(FeeInfo oldFeeInfo : listFeeInfo){
			FeeInfo feeInfo = new FeeInfo();
			feeInfo.setFeeID(oldFeeInfo.getFeeID()); 
			feeInfo.setFeeCategory("2"); //2:预存费用
			//feeInfo.setFeeDes(oldFeeInfo.getFeeDes());
			feeInfo.setOrigFee(oldFeeInfo.getOrigFee()); //应收
			feeInfo.setReliefFee("0"); //减免金额默认0 
			feeInfo.setReliefResult("无减免原因");
			feeInfo.setRealFee(oldFeeInfo.getOrigFee()); //因为减免是0，所以实收=应收
			newListFeeInfo.add(feeInfo);		
		}
		accountReq.setListFeeInfo(newListFeeInfo);
		
		return accountReq;
	}	
	
	/**
	 * 2.8	订单提交接口
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfOrderSub(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContOrderSub(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2031505", svcCont, null);
		xstream.processAnnotations(OrderSubRsp.class);
		OrderSubRsp orderSubRsp = (OrderSubRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(orderSubRsp.getRespCode());
		respInfo.setRespDesc(orderSubRsp.getRespDesc());
		return respInfo;
	}
	
	/**
	 * 生成订单提交接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContOrderSub(Map<String, Object> param){
		OrderSubReq orderSubReq = genOrderSubReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(orderSubReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 OrderSubReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private OrderSubReq genOrderSubReq(Map<String, Object> param){
		OrderSubReq orderSubReq = new OrderSubReq();
		
		orderSubReq.setOperatorID((String)param.get("OperatorID"));
		orderSubReq.setProvince((String)param.get("Province"));
		orderSubReq.setCity((String)param.get("City"));
		orderSubReq.setDistrict((String)param.get("District"));
		orderSubReq.setChannelID((String)param.get("ChannelID"));
		orderSubReq.setChannelType((String)param.get("ChannelType"));
		orderSubReq.setAccessType((String)param.get("AccessType"));
		orderSubReq.setOrderType("0"); //0、	提交订单 1取消订单
		orderSubReq.setProvOrderID((String)param.get("ProvOrderID"));
		orderSubReq.setEcsOrderID((String)param.get("orderID")); //传esp自己的订单id
		orderSubReq.setTaxType("3"); //3	不打发票
		
		//2.9 订单提交接口 和 2.11	卡处理结果提交接口 都是 orderSubReq，但是 2.9没有下面的节点
		if(param.containsKey("OrigTotalFee")){
			orderSubReq.setOrigTotalFee((String)param.get("OrigTotalFee"));
			
			PayInfo payInfo = new PayInfo();
			payInfo.setPayType("10"); //10：现金
			orderSubReq.setPayInfo(payInfo);
		}
		
		return orderSubReq;
	}	
	
	/**
	 * 2.1	获取写卡数据
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfGetCardData(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContGetCardData(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000607", svcCont, null);
		xstream.processAnnotations(GetCardDataRsp.class);
		GetCardDataRsp getCardDataRsp = (GetCardDataRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		//这个接口特别，成功不是0000，而是00
		if("00".equals(getCardDataRsp.getAnswerCode())){
			respInfo.setRespCode("0000");
		}
		else{
			respInfo.setRespCode(getCardDataRsp.getAnswerCode());
		}
		respInfo.setRespDesc(getCardDataRsp.getDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("ICCID", getCardDataRsp.getICCID());
		data.put("IMSI", getCardDataRsp.getIMSI());
		data.put("ProcId", getCardDataRsp.getProcId());
		data.put("CardData", getCardDataRsp.getCardData());
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 获取写卡数据接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContGetCardData(Map<String, Object> param){
		GetCardDataReq getCardDataReq = genGetCardDataReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(getCardDataReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 GetCardDataReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private GetCardDataReq genGetCardDataReq(Map<String, Object> param){
		GetCardDataReq getCardDataReq = new GetCardDataReq();
		
		getCardDataReq.setUserNum((String)param.get("UserNum"));
		getCardDataReq.setSimCard((String)param.get("SimCard"));
		getCardDataReq.setEparchyCode((String)param.get("EparchyCode"));
		getCardDataReq.setCustName((String)param.get("CustName"));
		getCardDataReq.setPsptId((String)param.get("PsptId"));
		getCardDataReq.setProductId((String)param.get("ProductId"));
		getCardDataReq.setBusiType((String)param.get("BusiType"));
		getCardDataReq.setCardType((String)param.get("CardType"));
		getCardDataReq.setUserType((String)param.get("UserType"));
		getCardDataReq.setProcId((String)param.get("ProcId"));
		getCardDataReq.setStaffId((String)param.get("StaffId"));
		getCardDataReq.setDepartId((String)param.get("DepartId"));
		
		return getCardDataReq;
	}
	
	/**
	 * 2.1	写卡结果通知
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfWriteCard(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContWriteCard(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000606", svcCont, (String)param.get("ProcId2"));
		xstream.processAnnotations(WriteCardRsp.class);
		WriteCardRsp writeCardRsp = (WriteCardRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(writeCardRsp.getRespCode());
		respInfo.setRespDesc(writeCardRsp.getRespDesc());
		return respInfo;
	}
	
	/**
	 * 写卡结果通知接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContWriteCard(Map<String, Object> param){
		WriteCardReq writeCardReq = genWriteCardReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(writeCardReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 GetCardDataReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private WriteCardReq genWriteCardReq(Map<String, Object> param){
		WriteCardReq writeCardReq = new WriteCardReq();
		
		writeCardReq.setUserNum((String)param.get("UserNum"));
		writeCardReq.setIccid((String)param.get("Iccid"));
		writeCardReq.setImsi((String)param.get("Imsi"));
		writeCardReq.setEparchyCode((String)param.get("EparchyCode"));
		writeCardReq.setUpdateTime((String)param.get("UpdateTime"));
		writeCardReq.setProcId2((String)param.get("ProcId2"));
		writeCardReq.setOperRst((String)param.get("OperRst"));
		writeCardReq.setOperComm((String)param.get("OperComm"));
		writeCardReq.setStaffId((String)param.get("StaffId"));
		writeCardReq.setDepartId((String)param.get("DepartId"));
		
		return writeCardReq;
	}
	
	/**
	 * 2.10 卡数据同步接口
	 * 这个接口在 写卡结果通知接口 之后调用，而且是写卡成功才调用，写卡失败不调用
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfWriteCardPre(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContWriteCardPre(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000540", svcCont, null);
		xstream.processAnnotations(WriteCardPreRsp.class);
		WriteCardPreRsp writeCardPreRsp = (WriteCardPreRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(writeCardPreRsp.getRespCode());
		respInfo.setRespDesc(writeCardPreRsp.getRespDesc());
		return respInfo;
	}
	
	/**
	 * 卡数据同步接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContWriteCardPre(Map<String, Object> param){
		WriteCardPreReq writeCardPreReq = genWriteCardPreReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(writeCardPreReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 WriteCardPreReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private WriteCardPreReq genWriteCardPreReq(Map<String, Object> param){
		WriteCardPreReq writeCardPreReq = new WriteCardPreReq();
		
		writeCardPreReq.setOperatorID((String)param.get("OperatorID"));
		writeCardPreReq.setProvince((String)param.get("Province"));
		writeCardPreReq.setCity((String)param.get("City"));
		writeCardPreReq.setDistrict((String)param.get("District"));
		writeCardPreReq.setChannelID((String)param.get("ChannelID"));
		writeCardPreReq.setChannelType((String)param.get("ChannelType"));
		writeCardPreReq.setAccessType((String)param.get("AccessType"));
		writeCardPreReq.setOrderID((String)param.get("OrderID"));
		writeCardPreReq.setProvOrderID((String)param.get("ProvOrderID"));
		writeCardPreReq.setNumID((String)param.get("NumID"));
		writeCardPreReq.setSimID((String)param.get("SimID"));
		writeCardPreReq.setIMSI((String)param.get("IMSI"));
		writeCardPreReq.setCardData((String)param.get("CardData"));
		
		return writeCardPreReq;
	}
	
	/**
	 * 2.11	卡处理结果提交接口
	 * 报文节点和 订单提交接口 一样都是 OrderSubReq
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfOrderSub2(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContOrderSub(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BGZ2F054", "T2000542", svcCont, null);
		xstream.processAnnotations(OrderSubRsp.class);
		OrderSubRsp orderSubRsp = (OrderSubRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(orderSubRsp.getRespCode());
		respInfo.setRespDesc(orderSubRsp.getRespDesc());
		return respInfo;
	}
	

	
	/**
	 * 2.12	移网应缴费用查询
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfFeeQry(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContFeeQry(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BAPPA001", "T1000001", svcCont, null);
//		xstream.processAnnotations(FeeQryRsp.class);
//		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
//		xstream.alias("Resp", FeeQryRsp.class);
//		FeeQryRsp feeQryRsp = (FeeQryRsp) xstream.fromXML(svcContResp);
		
		//2.12,2.13,2.14三个响应类共用此类，把三个响应类里的属性都加到这里，因为这3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误，
		xstream.processAnnotations(PayCommonRsp.class);
		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
		xstream.alias("Resp", PayCommonRsp.class);
		PayCommonRsp feeQryRsp = (PayCommonRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(feeQryRsp.getRespCode());
		respInfo.setRespDesc(feeQryRsp.getRespDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("UserName", feeQryRsp.getUserName());
		data.put("EparchyCode", feeQryRsp.getEparchyCode());
		data.put("EparchyNme", feeQryRsp.getEparchyNme());
		data.put("ProductName", feeQryRsp.getProductName());
		data.put("Amount", feeQryRsp.getAmount());//实时话费
		data.put("Balance", feeQryRsp.getBalance());//可用余额（账本余额-实时话费）
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成移网应缴费用查询接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContFeeQry(Map<String, Object> param){
		FeeQryReq feeQryReq = genFeeQryReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(feeQryReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 FeeQryReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private FeeQryReq genFeeQryReq(Map<String, Object> param){
		FeeQryReq feeQryReq = new FeeQryReq();
		
		feeQryReq.setUserNumber((String)param.get("UserNumber"));
		
		return feeQryReq;
	}	
	
	/**
	 * 2.13	移网缴费
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfPay(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContPay(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommonPay("BAPPA001", "T1001001", svcCont, null, (String)param.get("UserNumber"));
//		xstream.processAnnotations(PayRsp.class);
//		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
//		xstream.alias("Resp", PayRsp.class);
//		PayRsp payRsp = (PayRsp) xstream.fromXML(svcContResp);
		
		//2.12,2.13,2.14三个响应类共用此类，把三个响应类里的属性都加到这里，因为这3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误，
		xstream.processAnnotations(PayCommonRsp.class);
		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
		xstream.alias("Resp", PayCommonRsp.class);
		PayCommonRsp payRsp = (PayCommonRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(payRsp.getRespCode());
		respInfo.setRespDesc(payRsp.getRespDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("TradeId", payRsp.getTradeId());
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成移网缴费接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContPay(Map<String, Object> param){
		PayReq payReq = genPayReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(payReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 FeeQryReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private PayReq genPayReq(Map<String, Object> param){
		PayReq payReq = new PayReq();
		
		payReq.setUserNumber((String)param.get("UserNumber"));
		payReq.setMoney((String)param.get("Money"));
		
		return payReq;
	}	
	
	/**
	 * 2.14	缴费记录查询接口
	 * @param param
	 * @return
	 */
	public RespInfo<List<PayRecord>> callIntfPayQry(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContPayQry(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BAPPA001", "T1000002", svcCont, null);
//		xstream.processAnnotations(PayQryRsp.class);
//		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
//		xstream.alias("Resp", PayQryRsp.class);
//		PayQryRsp payQryRsp = (PayQryRsp) xstream.fromXML(svcContResp);
		
		//2.12,2.13,2.14三个响应类共用此类，把三个响应类里的属性都加到这里，因为这3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误，
		xstream.processAnnotations(PayCommonRsp.class);
		//因为有3个接口的resp类都是Resp,测试发现第一个调用成功了，后面的接口会解析错误,这边每次都手动重新映射别名
		xstream.alias("Resp", PayCommonRsp.class);
		PayCommonRsp payQryRsp = (PayCommonRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<List<PayRecord>> respInfo = new RespInfo<List<PayRecord>>();
		respInfo.setRespCode(payQryRsp.getRespCode());
		respInfo.setRespDesc(payQryRsp.getRespDesc());
		respInfo.setData(payQryRsp.getPayRecordList());
		return respInfo;
	}
	
	/**
	 * 生成缴费记录查询接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContPayQry(Map<String, Object> param){
		PayQryReq payQryReq = genPayQryReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(payQryReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 PayQryReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private PayQryReq genPayQryReq(Map<String, Object> param){
		PayQryReq payQryReq = new PayQryReq();
		
		payQryReq.setUserNumber((String)param.get("UserNumber"));
		payQryReq.setStartDate((String)param.get("StartDate"));//yyyymmdd
		payQryReq.setEndDate((String)param.get("EndDate"));//yyyymmdd
		
		return payQryReq;
	}
	
	/**
	 * 2.15	路由查询接口
	 * @param param
	 * @return
	 */
	public RespInfo<Map<String, String>> callIntfRoute(Map<String, Object> param){
		
		//生成请求报文里的 string形式的svcCont节点内容
		String svcCont = genSvcContRoute(param);
		//生成全部请求报文,并调用bss接口，获取返回报文里的 svcCont 节点内容
		String svcContResp = callIntfCommon("BIPHB031", "THB00005", svcCont, null);
		xstream.processAnnotations(RouteRsp.class);
		RouteRsp routeRsp = (RouteRsp) xstream.fromXML(svcContResp);
		
		//拼装返回
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		respInfo.setRespCode(routeRsp.getRespCode());
		respInfo.setRespDesc(routeRsp.getRespDesc());
		Map<String, String> data = new HashMap<String, String>();
		data.put("SubsysCode", routeRsp.getSubsysCode());//SubsysCode只有CBS和 BSS
		data.put("NetType", routeRsp.getNetType());
		data.put("UserNum", routeRsp.getUserNum());
		data.put("EparchyCode", routeRsp.getEparchyCode());
		data.put("UserState", routeRsp.getUserState());
		
		respInfo.setData(data);
		return respInfo;
	}
	
	/**
	 * 生成路由查询接口的 SvcCont 节点 报文，string 形式的
	 * @param param
	 * @return
	 */
	private String genSvcContRoute(Map<String, Object> param){
		RouteReq routeReq = genRouteReq(param);
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(routeReq);
		
		return "<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>";
	}
	
	/**
	 * 生成 RouteReq 节点对应的 bean
	 * @param param
	 * @return
	 */
	private RouteReq genRouteReq(Map<String, Object> param){
		RouteReq routeReq = new RouteReq();
		
		routeReq.setUserNumber((String)param.get("UserNumber"));
		
		return routeReq;
	}	
	
	/**
	 * 封装了 bss选号 的2个顺序调用的接口：1移动号码查询接口，2资源操作接口
	 * @param paramsMap
	 * @return
	 */
	public RespInfo<Map<String, String>> callBssSelectNumAll(Map<String, String> paramsMap){
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		
		//先拼装所有bss请求需要用到的公共参数，比如工号，省市区县
		Map<String, Object> param = addCommonParam(paramsMap.get("userId"));
		//从订单提交页面的参数map里 找出属性字符串 resAttr ，并从中找到 选择的号码,付费类型 等需要的参数
		addParamFromAttr(param, paramsMap.get("resAttr"), paramsMap.get("orderId"));
		
    	param.put("QueryType", "01"); //选号条件 01：随机 ,03：号码关键字
    	//param.put("QueryPara1", con.getKeyword());      
	    //param.put("ProductID", con.getProduct_id());  
    	
    	log.debug("【bss接口】callBssSelectNumAll,param=" + param);
    	
		//1移动号码查询接口， 0000可以继续下一步接口，其他的错误得返回页面，终止流程
    	RespInfo<List<NumInfo>> respInfo1 = callIntfNumQuery(param);
		if(!"0000".equals(respInfo1.getRespCode())){
			respInfo.setRespCode(respInfo1.getRespCode());
			respInfo.setRespDesc("【移动号码查询接口】" + respInfo1.getRespDesc());
			return respInfo;
		}
		else{
			for(NumInfo numInfo : respInfo1.getData()){
				//过滤掉靓号
				if(RegexUtil.isPhoneNumRule(numInfo.getNumID())){
					continue;
				}
				else{
		        	param.put("ResourcesType", "02"); //02  手机号码
		        	param.put("ResourcesCode", numInfo.getNumID());//不是靓号就占用这个号码
		        	param.put("OccupiedFlag", "1"); //1	预占	
		        	break;
				}
			}

		}
		
		//2资源操作接口， 0000可以继续下一步接口，其他的错误得返回页面，终止流程
		//默认号码占用上一步查询出的list里的第一个号码
		RespInfo<Map<String, String>> respInfo2 = callIntfCheckRes(param);
		if("0000".equals(respInfo2.getRespCode())){
			//如果号码查询接口+号码预占接口都成功，需要把号码加到订单提交参数里，后面插沃掌柜订单表需要用到
			//orderService.insertOrderResInfo 方法里会用到
			paramsMap.put("bssSerialNumber", (String) param.get("ResourcesCode"));//占用成功的号码
		}
		else{
			respInfo.setRespCode(respInfo2.getRespCode());
			respInfo.setRespDesc("【资源操作接口】" + respInfo2.getRespDesc());
			return respInfo;
		}
		
		//走到这里表示以上接口都成功
		respInfo.setRespCode("0000"); 
		respInfo.setRespDesc("bss上网卡选号并且预占成功");
		return respInfo;
	}
	
	/**
	 * 封装了 bss开户 的几个顺序调用的接口：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口
	 * @param paramsMap
	 * @return
	 */
	public RespInfo<Map<String, String>> callBssOpenAll(Map<String, String> paramsMap){
    	//20160622 ximh 修改，支撑bss本地产品，提交订单的时候，要区分待客下单和普通用户下单，开户流程不一样，主要是身份证读取的时间不一样，客户认证这个接口在什么时候调用的区别
    	//普通下单：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口， 4插沃掌柜本地预订单表 ，7.跳转到支付页面
    	//待客下单：4插沃掌柜本地预订单表 ，7.跳转到支付页面，app端：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		
		//先拼装所有bss请求需要用到的公共参数，比如工号，省市区县
		Map<String, Object> param = addCommonParam(paramsMap.get("userId"));
		//再添加其他业务参数
		addOtherParam(param, paramsMap);
		//从订单提交页面的参数map里 找出属性字符串 resAttr ，并从中找到 选择的号码,付费类型 ，product_id, orderid等需要的参数
		addParamFromAttr(param, paramsMap.get("resAttr"), paramsMap.get("orderId"));
		//从必选叠加包 和 可选叠加包list 的中文名称 查出 优惠id
		addBssPkeParam(param);
		
		//20170206 add, 在开户前添加1证5户校验
		RespInfo<String> respInfo6 = osnService.callIntfOsn(param);
		if(!"0000".equals(respInfo6.getRespCode())){
			respInfo.setRespCode(respInfo6.getRespCode());
			respInfo.setRespDesc("一证五户接口校验失败,已经超过限制,请到沃掌柜申请退款！" + respInfo6.getRespDesc());
			return respInfo;
		}
		
		log.debug("【bss接口】callBssOpenAll,param=" + param);
		
		//1客户资料验证接口， 0000和 0001都可以继续下一步接口，其他的错误得返回页面，终止流程
		RespInfo<List<ExistedCustomer>> respInfo1 = callIntfCheckCust(param);
		if("0000".equals(respInfo1.getRespCode())){
			//如果0000，表示已有此客户资料，后续订单预提交接口只需回传CustomerID,但bss一个身份证会返回多个 客户节点，这边只取第一个
			param.put("CustomerID", respInfo1.getData().get(0).getCustomerID());
			
			param.put("CustomerType", "01");
			param.put("CustomerLevel", "1");
			param.put("CustomerLoc", param.get("City")); //？？身份证上没有城市,陈伟说就传工号地市
			param.put("CustomerName", paramsMap.get("custName"));
			param.put("CustomerPasswd", "123456"); //默认密码123456
			param.put("ReleOfficeID", param.get("ChannelID"));  //同ChannelID
			param.put("CertExpireDate", paramsMap.get("custExpiredate")==null ? "20501231":paramsMap.get("custExpiredate")); //？？随便填的固定值，因为普通下单没读取身份证
			param.put("ContactPhone", paramsMap.get("phoneNum"));
			param.put("CustomerSex", paramsMap.get("custSex")==null ? "1":paramsMap.get("custSex")); //？？女 0 男 1 ，随便填的固定值，因为普通下单没读取身份证
			param.put("CustomerAddr", paramsMap.get("custAddr")); //身份证地址
			param.put("CustomerBirth", paramsMap.get("custBirth")); //身份证生日
		}
		else if("0001".equals(respInfo1.getRespCode())){
			//如果0001，表示无此客户资料，后续订单预提交接口需要传很多客户字段新建客户
			param.put("CustomerType", "01");
			param.put("CustomerLevel", "1");
			param.put("CustomerLoc", param.get("City")); //？？身份证上没有城市,陈伟说就传工号地市
			param.put("CustomerName", paramsMap.get("custName"));
			param.put("CustomerPasswd", "123456"); //默认密码123456
			param.put("ReleOfficeID", param.get("ChannelID"));  //同ChannelID
			param.put("CertExpireDate", paramsMap.get("custExpiredate")==null ? "20501231":paramsMap.get("custExpiredate")); //？？随便填的固定值，因为普通下单没读取身份证
			param.put("ContactPhone", paramsMap.get("phoneNum"));
			param.put("CustomerSex", paramsMap.get("custSex")==null ? "1":paramsMap.get("custSex")); //？？女 0 男 1 ，随便填的固定值，因为普通下单没读取身份证
			param.put("CustomerAddr", paramsMap.get("custAddr")); //身份证地址
			param.put("CustomerBirth", paramsMap.get("custBirth")); //身份证生日
		}
		else{
			respInfo.setRespCode(respInfo1.getRespCode());
			respInfo.setRespDesc("【客户资料验证接口】" + respInfo1.getRespDesc());
			return respInfo;
		}
		
		//2用户校验接口 , 只有0000 才可以继续下一步接口
//		RespInfo<Map<String, String>> respInfo2 = callIntfUserCheck(param);
//		if(!"0000".equals(respInfo2.getRespCode())){
//			respInfo.setRespCode(respInfo2.getRespCode());
//			respInfo.setRespDesc("【用户校验接口】" + respInfo2.getRespDesc());
//			return respInfo;
//		}
		
		//3订购信息合法性验证与费用计算接口, 这个接口会返回TotalFee 和 List<FeeInfo>，预提交接口里要用
		RespInfo<Map<String, Object>> respInfo3 = callIntfCheckRule(param);
		if("0000".equals(respInfo3.getRespCode())){
			param.put("OrigTotalFee", respInfo3.getData().get("TotalFee")); //开户预提交接口要用这个金额
			param.put("listFeeInfo", respInfo3.getData().get("listFeeInfo"));//开户预提交接口要用这个
		}
		else{
			respInfo.setRespCode(respInfo3.getRespCode());
			respInfo.setRespDesc("【订购信息合法性验证与费用计算接口】" + respInfo3.getRespDesc());
			return respInfo;
		}
			
		
		//5.开户信息预提交接口 ，0000的时候会返回一个 省分订单ID  为正式提交时使用
		RespInfo<Map<String, String>> respInfo4 = callIntfAccount(param);
		if("0000".equals(respInfo4.getRespCode())){
			param.put("ProvOrderID", respInfo4.getData().get("ProvOrderID")); //正式提交接口要用这个id
		}
		else{
			respInfo.setRespCode(respInfo4.getRespCode());
			respInfo.setRespDesc("【开户信息预提交接口接口】" + respInfo4.getRespDesc()); 
			return respInfo;
		}
		
		// 6.订单提交接口
		RespInfo<Map<String, String>> respInfo5 = callIntfOrderSub(param);
		if(!"0000".equals(respInfo5.getRespCode())){
			respInfo.setRespCode(respInfo5.getRespCode());
			respInfo.setRespDesc("【订单提交接口】" + respInfo5.getRespDesc());
			return respInfo;
		}
		
		//走到这里表示以上接口都成功
		respInfo.setRespCode("0000"); 
		respInfo.setRespDesc("订单提交到bss成功");
		//后期改造，写卡通知接口里需要用到 ProvOrderID，只能这边先返回给app，后面app再传进来
		//后面 2.11卡处理结果提交接口 要用到实收金额
		Map<String, String> data = new HashMap<String, String>();
		data.put("ProvOrderID", respInfo4.getData().get("ProvOrderID")); //
		data.put("OrigTotalFee", (String) respInfo3.getData().get("TotalFee")); //
		respInfo.setData(data);
		
		return respInfo;
	}
	
	/**
	 * 调用bss 接口 公共方法，返回响应的svcCont 节点里的内容，是个xml 字符串
	 * 写卡结果通知接口特殊，贵州bss，获取写卡数据接口返回svccont里的ProcId，
	 * 要和写卡结果通知请求里的ProcId2以及报文头里的ProcId ，3个值要一致，
	 * 所以最后一个参数procId，只有写卡结果通知接口会传值，其他接口都传null
	 * @param BIPCode
	 * @param ActivityCode
	 * @param serialNum
	 * @param svcCont
	 * @param procId
	 * @return
	 */
	private String callIntfCommon(String BIPCode, String ActivityCode, String svcCont, String procId){
		//生成全部请求报文
		String uniBSSReqXml = genUniBSS(BIPCode, ActivityCode, svcCont, procId);
		log.debug("【请求报文】" + uniBSSReqXml); 
		//拼装post参数
		HashMap<String, String> mapxml = new HashMap<String, String>() ;
		mapxml.put("xmlmsg", uniBSSReqXml);
		//发送httpclient请求，并接收响应
		String respXml = BssIntfUtil.httpSend(BssIntfUtil.BSS_SERVERURL, mapxml);
		log.debug("【返回报文】" + respXml); 
		//响应报文xml转UniBSS bean
		xstream.processAnnotations(UniBSS.class);
		UniBSS uniBSSResp = (UniBSS) xstream.fromXML(respXml);
        //获取响应的svccont,并转换成 PerNumRsp
		String svcContResp = uniBSSResp.getSvcCont();
		
		return svcContResp;
	}
	
	/**
	 * 缴费相关的接口 RouteType用01， RouteValue填手机号
	 * @param BIPCode
	 * @param ActivityCode
	 * @param svcCont
	 * @param procId
	 * @return
	 */
	private String callIntfCommonPay(String BIPCode, String ActivityCode, String svcCont, String procId, String serial_number){
		//生成全部请求报文
		String uniBSSReqXml = genUniBSSPay(BIPCode, ActivityCode, svcCont, procId, serial_number);
		log.debug("【请求报文】" + uniBSSReqXml); 
		//拼装post参数
		HashMap<String, String> mapxml = new HashMap<String, String>() ;
		mapxml.put("xmlmsg", uniBSSReqXml);
		//发送httpclient请求，并接收响应
		String respXml = BssIntfUtil.httpSend(BssIntfUtil.BSS_SERVERURL, mapxml);
		log.debug("【返回报文】" + respXml); 
		//响应报文xml转UniBSS bean
		xstream.processAnnotations(UniBSS.class);
		UniBSS uniBSSResp = (UniBSS) xstream.fromXML(respXml);
        //获取响应的svccont,并转换成 PerNumRsp
		String svcContResp = uniBSSResp.getSvcCont();
		
		return svcContResp;
	}
	

	/**
	 * 生成完整的请求报文
	 * @param BIPCode
	 * @param ActivityCode
	 * @param serialNum
	 * @param svcCont
	 * @param procId
	 * @return
	 */
	private String genUniBSS(String BIPCode, String ActivityCode, String svcCont, String procId){
		UniBSS uniBSS = new UniBSS();
		//genUniBSSComm(uniBSS, "BIPHB032", "THB00010", serialNum); //通用的属性节点设置值
		uniBSS.setOrigDomain("ECIP"); //发起方应用域代码
		uniBSS.setHomeDomain("UCRM");//归属方应用域代码
		uniBSS.setBIPCode(BIPCode);//业务功能代码
		uniBSS.setBIPVer("0100"); //业务流程版本号
		uniBSS.setActivityCode(ActivityCode);//交易代码
		uniBSS.setActionCode("0");//交易动作代码
		uniBSS.setActionRelation("0"); //交易关联性
		
		Routing routing=new Routing();
		routing.setRouteType("00");//路由类型
		routing.setRouteValue("85");//路由关键值
		uniBSS.setRouting(routing);//路由信息
		
		if(StringUtils.isNotBlank(procId)){
			uniBSS.setProcID(procId);//发起方业务流水号，写卡结果通知接口特殊，需要用获取写卡接口里返回的流水
		}
		else{
			uniBSS.setProcID(BssIntfUtil.generateLogId("PROC"));//发起方业务流水号
		}
		uniBSS.setTransIDO(BssIntfUtil.generateLogId("TRAN"));//发起方交易流水号
		uniBSS.setTransIDH(BssIntfUtil.getCurentTime());
		uniBSS.setProcessTime(BssIntfUtil.getCurentTime());//处理时间
		
		SPReserve spreserve=new SPReserve();
		spreserve.setTransIDC(BssIntfUtil.generateLogId(""));//一级枢纽交易流水
		spreserve.setCutOffDay(BssIntfUtil.getCurentDay());//逻辑交易日
		spreserve.setOSNDUNS("0002");//发起方交换节点代码
		spreserve.setHSNDUNS("8500");//归属方交换节点代码
		spreserve.setConvID("");//交换中心处理标识
		uniBSS.setSPReserve(spreserve);
		
		uniBSS.setTestFlag("0");//测试标记
		uniBSS.setMsgSender("9801");//消息发送方代码
		uniBSS.setMsgReceiver("9800");//消息直接接收方代码
		uniBSS.setSvcContVer("0100");//业务内容报文的版本号
		
		uniBSS.setSvcCont(svcCont);
		
		String xml = xstream.toXML(uniBSS);
		
	    xml=xml.replaceAll("&lt;", "<");
	    xml=xml.replaceAll("&gt;", ">");
	    xml=xml.replaceAll("&quot;", "\"");
		
		return xml;
	}
	
	private String genUniBSSPay(String BIPCode, String ActivityCode, String svcCont, String procId, String serial_number){
		UniBSS uniBSS = new UniBSS();
		//genUniBSSComm(uniBSS, "BIPHB032", "THB00010", serialNum); //通用的属性节点设置值
		uniBSS.setOrigDomain("ECIP"); //发起方应用域代码
		uniBSS.setHomeDomain("UCRM");//归属方应用域代码
		uniBSS.setBIPCode(BIPCode);//业务功能代码
		uniBSS.setBIPVer("0100"); //业务流程版本号
		uniBSS.setActivityCode(ActivityCode);//交易代码
		uniBSS.setActionCode("0");//交易动作代码
		uniBSS.setActionRelation("0"); //交易关联性
		
		Routing routing=new Routing();
		routing.setRouteType("01");//路由类型， 缴费相关的用 01
		routing.setRouteValue(serial_number);//路由关键值, 缴费相关的用 手机号
		uniBSS.setRouting(routing);//路由信息
		
		if(StringUtils.isNotBlank(procId)){
			uniBSS.setProcID(procId);//发起方业务流水号，写卡结果通知接口特殊，需要用获取写卡接口里返回的流水
		}
		else{
			uniBSS.setProcID(BssIntfUtil.generateLogId("PROC"));//发起方业务流水号
		}
		uniBSS.setTransIDO(BssIntfUtil.generateLogId("TRAN"));//发起方交易流水号
		uniBSS.setTransIDH(BssIntfUtil.getCurentTime());
		uniBSS.setProcessTime(BssIntfUtil.getCurentTime());//处理时间
		
		SPReserve spreserve=new SPReserve();
		spreserve.setTransIDC(BssIntfUtil.generateLogId(""));//一级枢纽交易流水
		spreserve.setCutOffDay(BssIntfUtil.getCurentDay());//逻辑交易日
		spreserve.setOSNDUNS("0002");//发起方交换节点代码
		spreserve.setHSNDUNS("8500");//归属方交换节点代码
		spreserve.setConvID("");//交换中心处理标识
		uniBSS.setSPReserve(spreserve);
		
		uniBSS.setTestFlag("0");//测试标记
		uniBSS.setMsgSender("9801");//消息发送方代码
		uniBSS.setMsgReceiver("9800");//消息直接接收方代码
		uniBSS.setSvcContVer("0100");//业务内容报文的版本号
		
		uniBSS.setSvcCont(svcCont);
		
		String xml = xstream.toXML(uniBSS);
		
	    xml=xml.replaceAll("&lt;", "<");
	    xml=xml.replaceAll("&gt;", ">");
	    xml=xml.replaceAll("&quot;", "\"");
		
		return xml;
	}
	
	/**
	 * 根据能人id，查出该能人归属地市，然后获取该地市用于bss接口的公用省市区，渠道id，渠道类型信息
	 * @param user_id
	 * @return
	 */
	public Map<String, Object> addCommonParam(String user_id){
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> commonParam = userDao.getBssIntfInfo(user_id);
		param.put("OperatorID", commonParam.get("OPERATE_ID"));
		param.put("Province", commonParam.get("PROVINCE"));
		param.put("City", commonParam.get("CITY"));
		param.put("District", commonParam.get("DISTRICT"));
		param.put("ChannelID", commonParam.get("CHANNEL_ID"));
		param.put("ChannelType", commonParam.get("CHANNEL_TYPE"));
		param.put("AccessType", "03"); //01 WEB； 02 短信； 03 WAP； 99 其他
		
		//以下参数是获取写卡数据 接口里用到的
		param.put("StaffId", commonParam.get("OPERATE_ID"));
		param.put("EparchyCode", commonParam.get("EPARCHY_CODE"));
		param.put("DepartId", commonParam.get("CHANNEL_ID"));
		
		return param;
	}
	

	/**
	 * 沃掌柜订单提交页面提交的参数 ，添加到 bss接口调用的请求参数里，用于接口调用
	 * @param param
	 * @param paramsMap
	 * @return
	 */
	public void addOtherParam(Map<String, Object> param, Map<String, String> paramsMap){
		
		param.put("CertType", "02"); //02	18位身份证
		param.put("CertNum", paramsMap.get("idCardNum")); //身份证号码
		param.put("CertName", paramsMap.get("custName")); //身份证名字
		param.put("ServiceType", "01"); //01:移动业务
		//param.put("NumID", getParamAttrStr(param, paramsMap.get("resAttr"))); //选中的号码
		param.put("GuarantorType", "04"); //04 无担保
		param.put("GuaratorID", "0"); 
		param.put("GroupFlag", "0"); //0：非集团用户
		param.put("CertTag", "0"); //0：实名-二代
		param.put("RealNameType", "0"); //0-	实名
		param.put("CertAddr", paramsMap.get("custAddr")); //证件地址
		
		//下面是发展人，发展渠道信息
		param.put("developerCode", paramsMap.get("developerCode")); //发展渠道
		param.put("developerName", paramsMap.get("developerName")); //发展渠道姓名
		param.put("channelCode", paramsMap.get("channelCode")); //发展人id
		param.put("channelName", paramsMap.get("channelName")); //发展人姓名
	}
	

    /**
     * 从订单提交页面的参数map里 找出属性字符串 resAttr ，并从中找到选择的号码,付费类型 ，product_id，沃掌柜订单id 等需要的参数
     * 如果不是从订单提交页面过来的，是从app里过来的，则没有paramsMap.get("resAttr")为空，表示订单已落表，需要查询数据库
     * @param param
     * @param resAttrStr
     * @param order_id
     */
    private void addParamFromAttr(Map<String, Object> param, String resAttrStr, String order_id) {
//    	String resAttrStr = paramsMap.get("resAttr");
//    	String serialNumber = "";
    	List<String> addpcke = new ArrayList<String>();
    	
		//订单id
		param.put("OrdersID", order_id);
		param.put("orderID", order_id);
		
    	//如果resAttrStr空，则根据order_id 从数据库取
    	if(StringUtils.isBlank(resAttrStr)) {
    		log.debug("【bss接口】resAttrStr 为空，从数据库查询订单属性");
    		if(StringUtils.isBlank(order_id)){
    			log.debug("【bss接口】resAttrStr 和 order_id 都为空，不再继续执行，直接返回");
    			return;
    		}
    		
    		Map<String, String> orderAttr = orderDao.getOrderAttr(order_id);
    		param.put("NumID", orderAttr.get("SERIAL_NUMBER"));
    		param.put("SerType", orderAttr.get("SER_TYPE"));
    		param.put("ProductID", orderAttr.get("PRODUCT_ID"));
    		
    		//一条订单可能会插0或多条ADDPCKE，1或多条MUSTPCK，0或一条ONEPCKE 属性，所以上面sql里不好写，这里单独获取一次
    		//获取必选叠加包,可选叠加包，多选一叠加包的名字
    		List<String> orderALLPCKE = orderDao.getOrderAllPcke(order_id);
    		if(CollectionUtils.isNotEmpty(orderALLPCKE)){
    			param.put("ALLPCKE", orderALLPCKE);
    		}
    		
    		//首月资费，bss预提交接口参数首月付费方式 01:标准资费（免首月月租）02:全月套餐 03:套餐减半
    		param.put("FirstMonBillMode", orderAttr.get("FMONTHD"));
    		
    	}
    	//下面这个分支废弃无用，可能会报错，因为都是从app进入的
    	else{
        	String[] rows = resAttrStr.split("\\^", -1);
        	for(String row : rows) {
        		String[] col = row.split("\\|", -1);
        		if(col.length < 3) {
        			continue;
        		}
        		
        		String resId = col[0];
        		String resAttrCode = col[1];
        		String resAttrVal = col[2];
        		String values1 = "";
        		if(col.length > 3) {
        			values1 = col[3];
        		}
        		
        		//如果属性是 NUMBERS ，就是页面上选择的号码, 如果是上网卡，此时是没有选择号码的
        		if("NUMBERS".equals(resAttrCode)){
//        			serialNumber = resAttrVal;
//        			break;
        			param.put("NumID", resAttrVal);
        		}
        		//付费类型
        		else if("SERTYPE".equals(resAttrCode)){
        	    	if("预付费".equals(resAttrVal)){
        	    		param.put("SerType", "2");
        	    		param.put("AcctType", "1"); //预提交接口里用到，跟SerType 反的
        	    	}
        	    	else{
        	    		param.put("SerType", "1"); //1-后付费 2-预付费
        	    		param.put("AcctType", "2");

        	    	}
        		}
        		//套餐里面取 bss 产品id,配置物品属性时，限制values1里填写bss产品id，新号入网的和上网卡的都要配这个属性
        		else if("PACKRES".equals(resAttrCode)){
        			param.put("ProductID", values1);
        		}  
        		//取必选叠加包的中文名称
        		else if("MUSTPCK".equals(resAttrCode)){
        			param.put("MUSTPCK", values1);
        		} 
        		//取可选叠加包的中文名称  可以多选
        		else if("ADDPCKE".equals(resAttrCode)){
        			addpcke.add(values1);
        		}
        		
        		//首月资费，bss预提交接口参数首月付费方式 01:标准资费（免首月月租）02:全月套餐 03:套餐减半
        		else if("FMONTHD".equals(resAttrCode)){
        			if("立即生效".equals(resAttrVal)){
        	    		param.put("FirstMonBillMode", "02");
        	    	}
        	    	else if("半月生效".equals(resAttrVal)) {
        	    		param.put("FirstMonBillMode", "03"); 
        	    	}
        	    	else if("下月生效".equals(resAttrVal) || "次月生效".equals(resAttrVal)) {
        	    		param.put("FirstMonBillMode", "01"); 
        	    	}
        		}
        	}
        	param.put("ADDPCKE", addpcke);    		
    	}
    	

    	
//    	return serialNumber;
    }
    
	/**
	 * 如果不是从订单提交页面过来的，是从app里过来的，则没有paramsMap.get("resAttr")为空，表示订单已落标，需要查询数据库
	 * 获取 选择的号码,付费类型 ，product_id 参数
	 * @param order_id
	 */
//	public void addParamFromAttr(Map<String, Object> param, String order_id){
//		//省内新号入网时，配置商品的物品属性时必须有必选包和可选包，
//		//省内上网卡时，商品的物品属性里不需要配必选包和可选包，只需要根据产品id来获取pke
//		
//		if(StringUtils.isBlank(order_id)){
//			return;
//		}
//		
//		Map<String, String> orderAttr = orderDao.getOrderAttr(order_id);
//		param.put("NumID", orderAttr.get("SERIAL_NUMBER"));
//		param.put("SerType", orderAttr.get("SER_TYPE"));
//		param.put("ProductID", orderAttr.get("PRODUCT_ID"));
//		
//	}
	
	/**
	 * 必选叠加包名称 和 可选叠加包名称，多选一叠加包 list 获取 优惠id的列表
	 * @param param
	 * @return
	 */
	public void addBssPkeParam(Map<String, Object> param){
		String product_id = (String)param.get("ProductID"); 
//		List<String> addpcke = new ArrayList<String>();
//		//省内新号入网时，配置商品的物品属性时必须有必选包，可能有可选包，可能有多选一叠加包，
//		if(param.containsKey("MUSTPCK")) {
//			String mustpck = (String)param.get("MUSTPCK"); //必选叠加包名称
//			addpcke.add(mustpck);
//		}
//		if(param.containsKey("ADDPCKE")) {
//			//addpcke = (List<String>)param.get("ADDPCKE"); //可选叠加包名称list
//			addpcke.addAll((List<String>)param.get("ADDPCKE"));
//		}
		
		//addParamFromAttr方法里已经把所有叠加包查询出来list了
		List<String> allpcke = null;
		if(param.containsKey("ALLPCKE")) {
			allpcke = (List<String>)param.get("ALLPCKE"); 
		}
		//省内上网卡时，商品的物品属性里不需要配必选包和可选包，只需要根据产品id来获取pke
		
//		List<String> discountList = userDao.getBssPkeParam(product_id, CollectionUtils.isEmpty(addpcke) ? null : addpcke);
		List<String> discountList = userDao.getBssPkeParam(product_id, allpcke);
		param.put("discountList", discountList);
	}
	
	/**
	 * bss接口返回的List<NumInfo> 转换为ftl页面里能读取的 List<Map<Object, Object>>
	 * @param list
	 * @return
	 */
	public List<Map<String, Object>> listNumInfo2list(List<NumInfo> list){
		Map<String, String> param = new HashMap<String, String>();
		
		List<Map<String, Object>> numbers = new ArrayList<Map<String, Object>>();
		
		for(NumInfo numInfo : list){
			//过滤掉靓号
			if(RegexUtil.isPhoneNumRule(numInfo.getNumID())){
				continue;
			}
			
			Map<String, Object> number = new HashMap<String, Object>();
			number.put("SERIAL_NUMBER", numInfo.getNumID());
			number.put("NICE_FEE", 0);
			numbers.add(number);
		}

		return numbers;
	}

	public static void main(String[] args) {
//		String svcContResp = "<CheckRuleRsp>    <RspCode>0000</RspCode>    <RspDesc>%E6%88%90%E5%8A%9F</RspDesc>    <FeeInfo>        <FeeID>100000</FeeID>        <FeeCategory>2</FeeCategory>        <FeeDes>[预存]营业厅收入(营业缴费)_普通预存款</FeeDes>        <MaxRelief>0</MaxRelief>        <OrigFee>99990</OrigFee>    </FeeInfo>    <FeeInfo>        <FeeID>100056</FeeID>        <FeeCategory>2</FeeCategory>        <FeeDes>[预存]2014秋季沃派缴费计划预存款不可减免不可清退</FeeDes>        <MaxRelief>0</MaxRelief>        <OrigFee>50000</OrigFee>    </FeeInfo>    <TotalFee>149990</TotalFee>    <Para>        <ParaID>0</ParaID>        <ParaValue>0</ParaValue>    </Para></CheckRuleRsp>";
//		XStream xstream2 = new XStream();
//		xstream2.processAnnotations(CheckRuleRsp.class);
//		CheckRuleRsp checkRuleRsp = (CheckRuleRsp) xstream2.fromXML(svcContResp);
//		
//		System.out.println(checkRuleRsp.getRspCode());
		
//		AccountReq accountReq = new AccountReq();
//		
//		List<FeeInfo> listFeeInfo = new ArrayList<FeeInfo>();
//		FeeInfo feeInfo1 = new FeeInfo();
//		feeInfo1.setFeeID("100056"); //这边写死预存款 存50送100，韩德勇和秦锡娟说以后存100送200也配置成这个
//		feeInfo1.setFeeCategory("2"); //2:预存费用
//		feeInfo1.setOrigFee("100");
//		feeInfo1.setReliefFee("0"); //减免金额默认0
//		feeInfo1.setReliefResult("无减免原因");
//		feeInfo1.setRealFee("100");
//		listFeeInfo.add(feeInfo1);
//		
//		FeeInfo feeInfo2 = new FeeInfo();
//		feeInfo2.setFeeID("100056"); //这边写死预存款 存50送100，韩德勇和秦锡娟说以后存100送200也配置成这个
//		feeInfo2.setFeeCategory("2"); //2:预存费用
//		feeInfo2.setOrigFee("200");
//		feeInfo2.setReliefFee("0"); //减免金额默认0
//		feeInfo2.setReliefResult("无adf原因");
//		feeInfo2.setRealFee("200");
//		listFeeInfo.add(feeInfo2);
//		
//		accountReq.setListFeeInfo(listFeeInfo);
//		
//		XStream xstream3 = new XStream();
//		xstream3.autodetectAnnotations(true);
//		String xml = xstream3.toXML(accountReq);
//		
//		System.out.println("<![CDATA[" + BssIntfUtil.xmlhead + xml + "]]>");
		
		
//		String svcContResp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><CheckCustRsp>    <RespCode>0000</RespCode>    <RespDesc>成功，原联通客户</RespDesc>    <ExistedCustomer>        <CustomerID>9416050558951255</CustomerID>        <BlackListFlag>0</BlackListFlag>        <ArrearageFlag>0</ArrearageFlag>        <CustomerType>01</CustomerType>        <CustomerLoc>0854</CustomerLoc>        <CustomerName>张培浩</CustomerName>        <CustomerAddr>0</CustomerAddr>        <ContactPerson>张培浩</ContactPerson>        <ContactPhone>15685026702</ContactPhone>        <ContactAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</ContactAddr>        <CertType>02</CertType>        <CertNum>532923199501121573</CertNum>        <CertAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</CertAddr>        <CertExpireDate>20230101</CertExpireDate>        <ReleOfficeID>JD00</ReleOfficeID>        <CustomerSex>1</CustomerSex>        <StatusChgTime>20160519134623</StatusChgTime>        <CustLoc>0</CustLoc>    </ExistedCustomer>    <ExistedCustomer>        <CustomerID>9416062759354222</CustomerID>        <BlackListFlag>0</BlackListFlag>        <ArrearageFlag>0</ArrearageFlag>        <CustomerType>01</CustomerType>        <CustomerLoc>0854</CustomerLoc>        <CustomerName>张培浩</CustomerName>        <CustomerAddr>0</CustomerAddr>        <ContactPerson>张培浩</ContactPerson>        <ContactPhone>15685026702</ContactPhone>        <ContactAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</ContactAddr>        <CertType>02</CertType>        <CertNum>532923199501121573</CertNum>        <CertAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</CertAddr>        <CertExpireDate>20230101</CertExpireDate>        <ReleOfficeID>JD00</ReleOfficeID>        <CustomerSex>1</CustomerSex>        <StatusChgTime>20160630090622</StatusChgTime>        <CustLoc>0</CustLoc>    </ExistedCustomer>    <ExistedCustomer>        <CustomerID>9416062759354136</CustomerID>        <BlackListFlag>0</BlackListFlag>        <ArrearageFlag>0</ArrearageFlag>        <CustomerType>01</CustomerType>        <CustomerLoc>0854</CustomerLoc>        <CustomerName>张培浩</CustomerName>        <CustomerAddr>0</CustomerAddr>        <ContactPerson>张培浩</ContactPerson>        <ContactPhone>15685026702</ContactPhone>        <ContactAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</ContactAddr>        <CertType>02</CertType>        <CertNum>532923199501121573</CertNum>        <CertAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</CertAddr>        <CertExpireDate>20230101</CertExpireDate>        <ReleOfficeID>JD00</ReleOfficeID>        <CustomerSex>1</CustomerSex>        <StatusChgTime>20160705173222</StatusChgTime>        <CustLoc>0</CustLoc>    </ExistedCustomer>    <ExistedCustomer>        <CustomerID>9415110357746698</CustomerID>        <BlackListFlag>0</BlackListFlag>        <ArrearageFlag>0</ArrearageFlag>        <CustomerType>01</CustomerType>        <CustomerLoc>0854</CustomerLoc>        <CustomerName>张培浩</CustomerName>        <CustomerAddr>0</CustomerAddr>        <ContactPerson>张培浩</ContactPerson>        <ContactPhone>15685026702</ContactPhone>        <ContactAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</ContactAddr>        <CertType>02</CertType>        <CertNum>532923199501121573</CertNum>        <CertAddr>云南省大理白族自治州祥云县下庄镇老张营村214号</CertAddr>        <CertExpireDate>20230101</CertExpireDate>        <ReleOfficeID>JD00</ReleOfficeID>        <CustomerSex>1</CustomerSex>        <StatusChgTime>20151128160216</StatusChgTime>        <CustLoc>0</CustLoc>    </ExistedCustomer></CheckCustRsp>";
//		XStream xstream4 = new XStream();
//		xstream4.processAnnotations(CheckCustRsp.class);
//		CheckCustRsp checkCustRsp = (CheckCustRsp) xstream4.fromXML(svcContResp);
//		System.out.println(checkCustRsp.getListExistedCustomer().get(0).getCustomerID());
		
		String svcContResp = "<Resp>    <RespCode>0000</RespCode>    <RespDesc>aaa</RespDesc>    <PayRecordList>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>        <PayRecord>            <chargeId>9116122092958282</chargeId>            <acctId>9115010977203547</acctId>            <payName>日</payName>            <channelId>15015</channelId>            <recvFee>500</recvFee>            <recvDepartId>76D91</recvDepartId>            <redvStaffId>AGYDZSW5</redvStaffId>            <cancelTag>0</cancelTag>        </PayRecord>    </PayRecordList></Resp>";
		XStream xstream5 = new XStream();

		
		String svcContResp2 = "<Resp>    <RespCode>0000</RespCode>    <RespDesc>成功</RespDesc>    <TradeId>9116123062978990</TradeId></Resp>";
		xstream5.processAnnotations(PayCommonRsp.class);
		PayCommonRsp payRsp = (PayCommonRsp) xstream5.fromXML(svcContResp2);
		System.out.println(payRsp.getTradeId());
		
		xstream5.processAnnotations(PayCommonRsp.class);
		PayCommonRsp payQryRsp = (PayCommonRsp) xstream5.fromXML(svcContResp);
		System.out.println(payQryRsp.getPayRecordList().size());
	}
}
