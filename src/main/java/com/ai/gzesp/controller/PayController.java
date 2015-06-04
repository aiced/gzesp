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
import com.ai.gzesp.service.PayService;
import com.ai.gzesp.service.WoPayService;

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
     * 返回json {"result_code":"SUCCESS", "result_desc":"请求发送成功"}
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payRefund/{order_id}")
	@ResponseBody
	public Map<String, String> payRefund(@PathVariable("order_id") String order_id) throws Exception
	{
		Map<String, String> MapRet=null;
		
		Map<String, String> payInfo = payService.queryPayModeByOrderId(order_id);
		
		String pay_mode = payInfo.get("PAY_MODE"); // 15:银联，30：微信支付，40：沃支付
		
		if ("30".equals(pay_mode))  //微信支付
		{
			MapRet = payService.wxRefund(order_id);
		}
		else if("40".equals(pay_mode))//沃支付
		{
			String url="https://123.125.97.66:8085/pay/trade/singleRefund.htm?reqCharSet=UTF-8";
			MapRet=woPayService.refundOrder(url, order_id);
			if (MapRet == null)
			{
				System.out.println("签名错误！");
			}
			System.out.println("沃支付返回："+MapRet);

		}
		else if("15".equals(pay_mode))//银联支付
		{
			System.out.println("银联支付返回："+MapRet);
		}
		return MapRet;
	}
    
    @RequestMapping("/test/2")
    public void test2(){
    	payService.afterPaySuccess("30", true, "1171430816469615", 50000);
    }
    
    @RequestMapping("/test/5")
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
    
}
