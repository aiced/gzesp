package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dto.PayInfo;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.service.MyAcctService;
import com.ai.gzesp.service.PayService;
import com.ai.gzesp.service.UnionPayService;
import com.ai.gzesp.service.UnionPayService2;
import com.ai.gzesp.service.WXPayService;
import com.ai.gzesp.service.WoPayService;
import com.ai.gzesp.utils.MD5Util;

/**
 * 支付入口<br> 
 * 公共的方法入口
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    
    @Autowired
    private PayService payService;
    
	@Autowired
	private WoPayService woPayService;
	
	@Autowired
	private WXPayService wxPayService;
	
	@Autowired
	private UnionPayService unionPayService;
	
	//edit_by_wenh_2015_6_30
    @Autowired
    private MyAcctService myAcctService;
    @Autowired
    private UnionPayService2 unionPayService2;
    /**
     * 选择支付方式(在线支付or货到付款) 以及选择 银联or支付宝 <br>
     * 〈功能详细描述〉
     *
     * @param order_id
     * @param fee
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/selectPayMode/{order_id}/{fee}")
    public ModelAndView selectPayMode(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("selectPayMode.ftl");
        
        mav.addObject("title", "选择支付方式");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        
        //获取商品名称，微信支付和沃支付需要
        Map<String, String> goods = payService.queryGoodsNameByOrderId(order_id);
        mav.addObject("goods_name", MapUtils.isEmpty(goods) ? "" : goods.get("GOODS_NAME"));
        return mav;
    }
    

    /**
     * 支付结束后，选择再去逛逛，回到能人店铺的首页
     * 根据order_id 查询 能人id，然后再跳转
     * @param order_id
     * @param fee
     * @return
     */
    @RequestMapping("/goToWeShopIndex/{order_id}")
    public ModelAndView goToWeShopIndex(@PathVariable("order_id") String order_id){
    	Map<Object, Object> userInfo = payService.queryUserIdByOrderId(order_id);
    	
        ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+userInfo.get("USER_ID"));
    	//ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+"2015000000000000");
        
        return mav;
    }
    
    /**
     * 选择支付模式后，点击确定，在发起各种支付接口前需要先做些操作
     * 1.插入 ord_d_pay 表
     * 2.根据支付模式跳转到不同controller去处理
     * @param order_id
     * @param fee
     * @return
     */
    @RequestMapping("/prePayReq/{order_id}/{order_fee}")
    @ResponseBody
    public Map<String, String> prePayReq(@PathVariable("order_id") String order_id, @PathVariable("order_fee") String order_fee, @RequestBody List<Map<String, String>> paramList){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	List<PayInfo> payInfoList = new ArrayList<PayInfo>();
    	for(int i = 0; i < paramList.size(); i++){
    		PayInfo row = new PayInfo();
    		row.setPay_order(String.valueOf(i+1)); //默认从1开始
    		row.setPay_type(paramList.get(i).get("pay_type")); //线上
    		row.setPay_mode(paramList.get(i).get("pay_mode")); //30 微信支付  40 沃支付
    		row.setPay_fee(paramList.get(i).get("pay_fee")); //单位厘
    		payInfoList.add(row);
    	}
    	payService.beforePayReq(order_id, order_fee, payInfoList);
    	
    	result.put("status", "00");
        result.put("detail", "插入ord_d_pay成功");
        
        return result;
    }    
    
	/**
	 * 退款总入口，提供给后台管理审核通过后调用
     * 返回json 
     * {"result_code":"SUCCESS", "result_desc":"退款请求发送成功"}
	 * {"result_code":"FAIL", "result_desc":"退款请求发送失败"}
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payRefund/{order_id}")
	@ResponseBody
	public Map<String, String> payRefund(@PathVariable("order_id") String order_id) throws Exception
	{
		Map<String, String> mapRet=null;
		
		Map<String, String> payInfo = payService.queryPayModeByOrderId(order_id);
		
		if(MapUtils.isEmpty(payInfo)){
			mapRet.put("result_code", "FAIL") ;
			mapRet.put("result_desc", "ord_d_pay表中不存在此order_id的记录") ;
		}
		
		String pay_mode = payInfo.get("PAY_MODE"); // 15:银联，30：微信支付，40：沃支付
		
		if ("30".equals(pay_mode))  //微信支付
		{
			mapRet = wxPayService.wxRefund(order_id);
		}
		else if("40".equals(pay_mode))//沃支付
		{
			mapRet = woPayService.refundOrder(order_id);
		}
		else if("15".equals(pay_mode))//银联支付
		{
			Map<String, String> result = unionPayService.refundOrder(order_id);
			mapRet = new HashMap<String, String>();
			if("00".equals(result.get("status"))){
				mapRet.put("result_code", "SUCCESS") ;
				mapRet.put("result_desc", "退款请求发送成功") ;
			}
			else{
				mapRet.put("result_code", "FAIL") ;
				mapRet.put("result_desc", result.get("detail")) ;
			}
		}
		
		//退款请求完成后，成功或失败需要做相应的后续操作
		boolean isSuccess = "SUCCESS".equals(mapRet.get("result_code")) ? true : false;
		payService.afterRefundSuccess(pay_mode, isSuccess, order_id);
		
		//返回json
		return mapRet;
	}
    
    @RequestMapping("/test/2")
    public void test2(){
    	payService.afterPaySuccess("30", true, "1171430816469615", 50000);
    }
    
    @RequestMapping("/test/3")
    public void test3(){
    	List<PayInfo> payInfoList = new ArrayList<PayInfo>();
    	
    	PayInfo row = new PayInfo();
    	row.setPay_order("1"); //默认从1开始
    	row.setPay_type("01"); //线上
    	row.setPay_mode("51"); //30 微信支付  40 沃支付
    	row.setPay_fee("1000"); //单位厘
    	payInfoList.add(row);
    	
    	PayInfo row2 = new PayInfo();
    	row2.setPay_order("2"); //默认从1开始
    	row2.setPay_type("01"); //线上
    	row2.setPay_mode("52"); //30 微信支付  40 沃支付
    	row2.setPay_fee("5000"); //单位厘
    	payInfoList.add(row2);
    	
    	PayInfo row3 = new PayInfo();
    	row3.setPay_order("3"); //默认从1开始
    	row3.setPay_type("01"); //线上
    	row3.setPay_mode("30"); //30 微信支付  40 沃支付
    	row3.setPay_fee("6000"); //单位厘
    	payInfoList.add(row3);
    	
    	payService.beforePayReq("1171430816469616", "12000", payInfoList);
    }
    
    @RequestMapping("/test/4/{order_id}")
    public void test4(@PathVariable("order_id") String order_id){
    	payService.afterRefundSuccess("15", true, order_id);
    }
    
    @RequestMapping("/insteadPay/{user_id}/{order_id}")
    public ModelAndView initInsteadPay(@PathVariable("user_id") String user_id,@PathVariable("order_id") String order_id){
    	//代客下单
    	
    	Double dtopaymoney=0.00;
    	Double dacctbanlance=0.00;
    	
        ModelAndView mav = new ModelAndView("insteadPay.ftl");
    	//ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+"2015000000000000");
        
        
    	//查询数据库
    	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
        
    	if (acctinfo != null && acctinfo.size()>0) {
            mav.addObject("acctinfo",acctinfo);
            dacctbanlance=Double.valueOf(acctinfo.get("BALANCE").toString());
            System.out.println(acctinfo);
		}
    
    	
    	//查询数据库
    	Map<String,Object> topay_money=myAcctService.queryToPayMoneyByOrderId(order_id);
    	if (topay_money != null && topay_money.size()>0) {
    		mav.addObject("topay_money",topay_money.get("TOPAY_MONEY"));
    		dtopaymoney=Double.valueOf(topay_money.get("TOPAY_MONEY").toString());
    	}
    	
    	//查询数据库
        List<Map<String, Object>> acctbankinfolist =myAcctService.queryAcctBankByUserId(user_id);

        if(acctbankinfolist != null && acctbankinfolist.size()>0)
        {	
        	mav.addObject("acctbankinfolist",acctbankinfolist);
        }
        
    	mav.addObject("left_money",dtopaymoney-dacctbanlance);
    	mav.addObject("user_id",user_id);
        mav.addObject("order_id",order_id);
        return mav;
    }
    
    @RequestMapping("/insteadPay/postData/{user_id}/{order_id}/{bank_no}")
    @ResponseBody
    public String insteadPayPostData(@PathVariable("user_id") String user_id,@PathVariable("order_id") String order_id,@PathVariable("bank_no") String bank_no)
    {
    	Map<String, String> paramsRet=null;
    	
    	Double dtopaymoney=0.00;
    	Double dacctbanlance=0.00;
    	String left_money="";
    	//查询数据库
    	Map<String, Object> acctinfo =myAcctService.queryAcctByUserId(user_id);
        
    	if (acctinfo != null && acctinfo.size()>0) {
            dacctbanlance=Double.valueOf(acctinfo.get("BALANCE").toString());
            System.out.println(acctinfo);
		}
    
    	//查询数据库
    	Map<String,Object> topay_money=myAcctService.queryToPayMoneyByOrderId(order_id);
    	if (topay_money != null && topay_money.size()>0) {
    		dtopaymoney=Double.valueOf(topay_money.get("TOPAY_MONEY").toString());
    	}
    	
    	//查询数据库
    	Map<String, Object> acctbankinfo=myAcctService.queryAcctBankDetail(user_id, bank_no);
    	
        if(acctbankinfo != null && acctbankinfo.size()>0)
        {	
        	UnionPayParam param = new UnionPayParam();
        	param.setOrder_id(order_id); // 真实order_id
        	left_money=String.valueOf(dtopaymoney-dacctbanlance);
        	param.setFee(left_money); // 单位厘
        	param.setSign_code(MD5Util.convertMD5(acctbankinfo.get("SIGN_CODE").toString())); //md5解密，表里存放的是加密的
        
        	paramsRet=unionPayService2.unionPayPay(param);
        }
        
        
    	if (paramsRet.get("status").equals("00"))//成功
    	{
			return "ok";
		}
    	else {
    		return paramsRet.get("detail").toString();
		}
    }
    
}
