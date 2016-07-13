package com.ai.gzesp.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
import com.ai.gzesp.dao.service.TdSysPWEBDISTRICTDao;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.service.AppService;
import com.ai.gzesp.service.BssIntfService;
import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.exception.ReturnCode;
import com.ai.sysframe.token.Token;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.PathUtil;
import com.ai.sysframe.utils.StringUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.service.MaterialService;
import com.ai.wx.util.RegexUtils;
import com.ai.wx.util.SignUtils;


@Controller
@RequestMapping("/order")
public class OrderController {
    
	private static Logger log = Logger.getLogger(OrderController.class); 
	
    @Resource
    private WeShopService weShopService;
    
    @Resource
    private SelectNumberService selectNumberService;
    
    @Resource 
    OrderService orderService;
    
	@Resource
	MaterialService materialService;
	
	@Resource
	private BssIntfService bssIntfService;
	
	@Resource
	private AppService appService;
    
    @Resource
    TdSysPWEBDISTRICTDao tdSysPWEBDISTRICTDao;
    
    @Resource
    TdGdsDINFODao tdGdsDINFODao;
    
    @RequestMapping("/newNumberJoin")
    public ModelAndView newNumberJoin(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String goods_id = paramsMap.containsKey("goods_id")?paramsMap.get("goods_id"):"";
    	
    	String num_resId = orderService.GetGoodsNumAttr(goods_id);
    	 ModelAndView mav = new ModelAndView("newNumberJoin.ftl");
        mav.getModel().putAll(paramsMap);
        mav.addObject("title", "新号入网"); 
        mav.addObject("num_resId", num_resId); 
        
        selectNumberData(mav, goods_id);
        selectContractData(mav, goods_id);
        
        return mav;
    }
    
    private void selectNumberData(ModelAndView mav, String goods_id){
    	 //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        //20150421 ximh 修改 ，选号码页面下拉地市加 全省选项
        //ess_city_code city_code, city_name, ess_province_code province_code
/*        Map<Object, Object> all = new HashMap<Object, Object>(); //加入全省选项
        all.put("CITY_CODE", "%");
        all.put("CITY_NAME", "全省");
        all.put("PROVINCE_CODE", "85");
        citys.add(0, all);*/
        mav.addObject("citys", citys);
        
        //获取靓号规则下拉框
        List<Map<Object, Object>> rules = selectNumberService.getNumberRules();
        mav.addObject("rules", rules);
        
        //先根据商品id获取网络类型
        Map<Object, Object> netTypeRow =  selectNumberService.getNetTypeByGoodsId(goods_id);
        String net_type = (String) netTypeRow.get("ATTR_CODE"); //物品属性表里的 NETTYPE属性的值是 2G/3G/4G/CARD
        //数据库分页获取号码列表，默认归属贵阳,预存0-10000，第一页,一页20个,
//        List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(null, null, 0, 10000, 1, 20, null, null, null, net_type);
//        mav.addObject("numbers", numbers);
        mav.addObject("net_type", net_type);	//加入网络类型变量
    }
    
    private void selectContractData(ModelAndView mav,String goodsId){
    	List<Map>[] contractList = orderService.getContractByGoodsID(goodsId);
    	mav.addObject("pkgList", contractList[0]);
    	mav.addObject("peroidList", contractList[1]);
    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("GOODS_ID", goodsId);
    	List<TdGdsDINFO> dataList = tdGdsDINFODao.selectByExample(example);
    	if(dataList != null && dataList.size() > 0) {
    		mav.addObject("simpDesc", dataList.get(0).getSimpDesc());
    	}
    }
    
    @RequestMapping("/getDistrictListByCityCode")
//    @ResponseBody
    public ModelAndView getDistrictListByCityCode(@RequestBody Map<String, String> paramsMap) {
    	String cityCode =  paramsMap.get("cityCode");
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("ESS_CITY_CODE", cityCode);
    	List dataList =  tdSysPWEBDISTRICTDao.selectByExample(example);
    	ModelAndView mav = new ModelAndView("selectDistrictSub.ftl");
        mav.addObject("districts", dataList);
        return mav;
    }
    
    @RequestMapping("/fillOrderMain")
    public ModelAndView fillOrderMain(@RequestBody String inputParams, HttpServletRequest req){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	boolean showFMonthD = true;
    	String fromPage = paramsMap.get("fromPage");
    	if(fromPage != null &&
    			("planDetail".equals(fromPage) || "cardGoodDetail".equals(fromPage) )) {
    		paramsMap = convertKey(paramsMap);
    	}
    	
    	String goodsId = paramsMap.get("goodsId");
    	String fMonthDResId = "";
    	List fMonthDList = null;
    	if("cardGoodDetail".equals(fromPage)) {
    		showFMonthD = false;
    	} else {
    		fMonthDResId = orderService.GetGoodsFMonthDAttr(goodsId);
    		fMonthDList = orderService.GetGoodsFMonthDList(fMonthDResId);
    	}
    	
    	
    	Map info = orderService.getGoodsDefaultPhoto(goodsId);
    	
    	List<Map<Object, Object>> citys = weShopService.getCitys();
       
    	String userAgent = req.getHeader("user-agent");
    	boolean isAndroidWeiXin = RegexUtils.isAndroidWeiXin(userAgent);
    	
        ModelAndView mav = new ModelAndView("fillOrderMain.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "订单填写");
        mav.getModel().putAll(info);
        mav.getModel().putAll(paramsMap);
        mav.addObject("citys", citys);
        mav.addObject("showFMonthD", showFMonthD);
        mav.addObject("fMonthDResId", fMonthDResId);
        mav.addObject("fMonthDList", fMonthDList);
        mav.addObject("isAndroidWeiXin", isAndroidWeiXin);
        
        if(isAndroidWeiXin) {
        	int port = req.getServerPort();
        	String portStr = (80==port || 443 == port) ? "" : ":"+port;
    		String url =  req.getScheme() + "://" + req.getServerName() + portStr + req.getRequestURI();
    		Map<String, String> signInfo = SignUtils.jsApiSign(DataConstants.jsApiTicket, url);
    		signInfo.put("appId",  DataConstants.appid);
    		mav.addAllObjects(signInfo);
        }
        
    	//根据session里是否有 instead属性，来区分是代客下单或者普通用户下单
    	boolean isInstead = req.getSession(false).getAttribute("instead") == null ? false : true;
    	//代客下单时，身份证，物流等信息允许不填，
    	//因为集客需求，要支持线下当场写卡，不用快递，所以允许下单时身份证不必传，由另外app读卡器读二代证，再补身份证信息
    	mav.addObject("offline_flag", isInstead ? "1" : "0"); //允许线下写卡补录标志1允许 0不允许
        
        return mav;
    }
    
    @Token(remove=true)
    @RequestMapping("/submitFilledOrder")
    public ModelAndView submitFilledOrder(HttpServletRequest request, @RequestBody String inputParams) throws UnsupportedEncodingException{
    	
    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，ord_d_base里插订单类型
    	boolean isInstead = request.getSession(false).getAttribute("instead") == null ? false : true;
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String orderId = CommonUtil.generateOrderId();
//    	String payLogId = CommonUtil.generatePayLogId();
//    	String originalPrice = paramsMap.get("originalPrice");
    	String topayMoney = paramsMap.get("topayMoney");
    	String isAndroidWeiXin = paramsMap.get("isAndroidWeiXin");
    	if(Boolean.parseBoolean(isAndroidWeiXin)) {
    		log.debug("create thread download image from wxServer--" + isAndroidWeiXin);
    		String cardPic1 = paramsMap.get("cardPic1");
    		String cardPic2 = paramsMap.get("cardPic2");
    		String idCardNum = paramsMap.get("idCardNum");
    		String pic1Url = downloadImgFromWxServer(idCardNum, cardPic1);
    		String pic2Url = downloadImgFromWxServer(idCardNum, cardPic2);
    		paramsMap.put("cardPic1", pic1Url);
    		paramsMap.put("cardPic2", pic2Url);
    	}
    	
    	long fee  = CommonUtil.toDbPrice(CommonUtil.string2Float(topayMoney));
    	paramsMap.put("orderId", orderId);
//    	paramsMap.put("payLogId", payLogId);
    	
    	//20150703 ximh modify区分是代客下单或者普通用户下单，ord_d_base里插订单类型
    	//1：普通用户订单 2：店长代客下单 3：充值卡缴费 4：充值卡售卖
    	paramsMap.put("orderType", isInstead ? "2" : "1");
    	
    	//20160622 ximh 修改，支撑bss本地产品，提交订单的时候，要区分待客下单和普通用户下单，开户流程不一样，主要是身份证读取的时间不一样，客户认证这个接口在什么时候调用的区别
    	//普通下单：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口， 4插沃掌柜本地预订单表 ，7.跳转到支付页面
    	//待客下单：4插沃掌柜本地预订单表 ，7.跳转到支付页面，app端：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口
    	String ctlg_code = paramsMap.get("ctlgCode"); //10省内新号入网 ，11省内上网卡
    	//20160628 ximh 修改，以后所有上网卡都是省内卡，都需要现场写卡，所以上网卡不管是不是待客下单还是普通下单统一调用bss接口选号占号
    	if("11".equals(ctlg_code)){
    		//如果号码查询接口+号码预占接口都成功，需要把号码加到订单提交参数里，后面插沃掌柜订单表需要用到
    		RespInfo<Map<String, String>> respInfo = bssIntfService.callBssSelectNumAll(paramsMap);
    		//如果bss接口有一个不成功，则跳转到错误页面，全都成功了才继续下面 沃掌柜插订单的动作
    		if(!"0000".equals(respInfo.getRespCode())){
    			String url = "error2.ftl";
    	    	ModelAndView mav = new ModelAndView(url);
    	    	mav.addObject("respCode", respInfo.getRespCode());
    	    	mav.addObject("respDesc", respInfo.getRespDesc());
    	    	mav.addObject("user_id", paramsMap.get("userId"));
    	    	return mav; //退出    	
    		}
    	}
    	
    	//插订单表
    	orderService.insertOrder(paramsMap);
    	//20150420 ximh add，订单生成成功后需要库存数量-1，销量+1，用于后面判断有货无货
    	orderService.updateGoodsAmount(paramsMap.get("goodsId"));
    	
    	//10省内新号入网 ，11省内上网卡 ,都统一走bss接口提交订单
    	if("10".equals(ctlg_code) || "11".equals(ctlg_code)){
    		//如果是普通下单的，表示身份证照片已经上传，就当做实名过，需要调用bss接口走开户流程，最后现场写卡
        	if(!isInstead){
        		RespInfo<Map<String, String>> respInfo = bssIntfService.callBssOpenAll(paramsMap);
        		//如果bss接口有一个不成功，则跳转到错误页面，全都成功了才继续下面 沃掌柜插订单的动作
        		if(!"0000".equals(respInfo.getRespCode())){
        			String url = "error2.ftl";
        	    	ModelAndView mav = new ModelAndView(url);
        	    	mav.addObject("respCode", respInfo.getRespCode());
        	    	mav.addObject("respDesc", respInfo.getRespDesc());
        	    	mav.addObject("user_id", paramsMap.get("userId"));
        	    	return mav; //退出
        		}
        		
        		//如果是上网卡，且开户成功，修改 订单主表 intf_order_status 字段为0，失败则不更新
        		if("11".equals(ctlg_code) && "0000".equals(respInfo.getRespCode())){
        			Map<String, String> param = new HashMap<String, String>();
        			param.put("phone_number", paramsMap.get("bssSerialNumber"));
        			param.put("intf_order_status", "0");
    	    		int i = appService.updateOrderIntfStatus(param);
        		}
        	}
        	//如果是代客下单的，沃掌柜下单未上传身份证，这边不调用bss接口开户，只预定单，后面app读身份证后，调用bss开户
    	}
    	
    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，跳转到不同的支付页面
    	String url = null;
    	if(isInstead){
    		//url = "redirect:/pay/insteadPay/" + paramsMap.get("userId") + "/" + orderId;
    		url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee; //20151026 临时修改 集客线下需求，银联快捷支付走不通
    	}
    	else{
    		url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee;
    	}
    	
    	ModelAndView mav = new ModelAndView(url);
    	return mav;
    }
    
    private Map<String, String> convertKey(Map<String, String> paramsMap) {
    	Map<String, String> result = new HashMap();
    	Iterator<Entry<String, String>> it = paramsMap.entrySet().iterator();
    	while(it.hasNext()) {
    		Map.Entry<String, String> en = (Entry) it.next();
    		String key = en.getKey();
    		String val = en.getValue();
    		String camKey = StringUtil.camelize(key);
    		result.put(camKey, val);
    	}
    	return result;
    }
    
    private String downloadImgFromWxServer(final String idCardNum, final String mediaId)  {
		String fileUrl = File.separator + PathUtil.WEB_UPLOAD_PATH
    			   + DateUtil.getCurrentYearMonth()  + File.separator+ idCardNum 
    			   + File.separator + mediaId;
    	   
    	   
//    	   String mediaId = "p1CWLaO3MRjrSj5tKgwCfXw6GUoBJUkmEuSvfhiH_4VVNR4WqpFCphMl9j7sAmvm";
		new Thread() {
			public void run() {
				String upToPath = PathUtil.WEB_ROOT_PARENT_PATH
    		 	    		  + "uploadfile"
    		 	    		  + File.separator
    		 	    		  + PathUtil.WEB_UPLOAD_PATH 
    		 	    		  + DateUtil.getCurrentYearMonth()
    		 	    		  + File.separator
    		 	    		  + idCardNum 
    		 	    		  + File.separator;
				byte[] content = materialService.getTempMedia(DataConstants.accessToken, mediaId);

				File upFile = new File(upToPath);
				if (!upFile.exists()) {
					upFile.mkdirs();
				}
    		   	      
				try {
					FileCopyUtils.copy(content, new File(upToPath + mediaId));
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
    	}.start();
       	
		return fileUrl;
    }
    
    @RequestMapping("/downloadMedia/{idCardNum}/{mediaId}")
    @ResponseBody
    public String downloadMedia(@PathVariable("idCardNum") String idCardNum,
    		@PathVariable("mediaId") String mediaId){
    	return downloadImgFromWxServer(idCardNum,  mediaId);
    }
    
    @RequestMapping("/submitRecharge")
    public ModelAndView submitRecharge(HttpServletRequest request, @RequestBody String inputParams) throws UnsupportedEncodingException{
    	boolean isInstead = request.getSession(false).getAttribute("instead") == null ? false : true;
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	paramsMap = convertKey(paramsMap);
    	
    	String orderType = isInstead?"2":"1";
    	paramsMap.put("orderType", orderType);
    	
    	String orderId = CommonUtil.generateOrderId("2");
    	String topayMoney = paramsMap.get("topayMoney");
    	
    	long fee  = CommonUtil.toDbPrice(CommonUtil.string2Float(topayMoney));
    	paramsMap.put("orderId", orderId);
    	
    	orderService.insertRechargeOrder(paramsMap);
    	
    	//20150420 ximh add，订单生成成功后需要库存数量-1，销量+1，用于后面判断有货无货
//    	orderService.updateGoodsAmount(paramsMap.get("goodsId"));
    	
    	
    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，跳转到不同的支付页面
    	String url = null;
    	if(isInstead){
    		url = "redirect:/pay/insteadPay/" + paramsMap.get("userId") + "/" + orderId;
    	}
    	else{
    		url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee;
    	}
    	
    	ModelAndView mav = new ModelAndView(url);
    	return mav;
    }
    
    @RequestMapping("/submitBand")
    public ModelAndView submitBand(HttpServletRequest request, @RequestBody String inputParams) throws UnsupportedEncodingException{
    	boolean isInstead = request.getSession(false).getAttribute("instead") == null ? false : true;
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	paramsMap = convertKey(paramsMap);
    	
    	String orderType = isInstead?"2":"1";
    	paramsMap.put("orderType", orderType);
    	
    	String orderId = CommonUtil.generateOrderId("3");
    	String topayMoney = paramsMap.get("topayMoney");
    	
    	long fee  = CommonUtil.toDbPrice(CommonUtil.string2Float(topayMoney));
    	paramsMap.put("orderId", orderId);
    	
    	orderService.insertBandOrder(paramsMap);
    	
    	
    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，跳转到不同的支付页面
    	String url = null;
    	if(isInstead){
    		url = "redirect:/pay/insteadPay/" + paramsMap.get("userId") + "/" + orderId;
    	}
    	else{
    		url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee;
    	}
    	
    	ModelAndView mav = new ModelAndView(url);
    	return mav;
    }
    
    public static void main(String[] args) {
		System.out.println(CommonUtil.string2Float(".01"));
	}
    

}
