package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

/**
 * 一级功能：wap端<br> 
 * 二级功能：店铺主页
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/customer")
public class CustController {
    
	@Resource
    private OrderService orderService;
    
    
    @RequestMapping("/custOrderQuery")
    public ModelAndView custOrderQuery(){
        ModelAndView mav = new ModelAndView("custOrderQuery.ftl");
        mav.addObject("title", "我的订单");
        return mav;
    }
    
    @RequestMapping("/custMyOrder/{cust_phone}/{cust_passport}")
    public ModelAndView custMyOrder(@PathVariable("cust_phone") String cust_phone,
    		@PathVariable("cust_passport") String cust_passport){
    	List custMyOrderList = orderService.getCustMyOrder(cust_passport, cust_phone, null,1);//默认第一页显示4条记录
    	
    	ModelAndView mav = new ModelAndView("custMyOrder.ftl");
    	mav.addObject("custMyOrderList", custMyOrderList);
    	mav.addObject("cust_phone", cust_phone);
    	mav.addObject("cust_passport", cust_passport);
    	
    	return mav;
    }
    

	   @RequestMapping("/custOrderFilterByAjax_Page")
	   public ModelAndView custOrderFilterByAjax_Page(@RequestBody Map<String, String> inputParams){
		   String cust_passport = inputParams.get("cust_passport");
		   String cust_phone = inputParams.get("cust_phone");
		   String keyword = inputParams.get("keyword");
		   String strHidePageIndex=inputParams.get("hidepageindex");
		   
		   
		   System.out.println(cust_passport);
		   System.out.println(cust_phone);
		   System.out.println(keyword);
		   System.out.println(strHidePageIndex);
		   
		   List custMyOrderList = orderService.getCustMyOrder(cust_passport, cust_phone, keyword,Integer.valueOf(strHidePageIndex));
	    	
	    	ModelAndView mav = new ModelAndView("custMyOrderSub.ftl");
	    	mav.addObject("custMyOrderList", custMyOrderList);
		   
		   return mav;
	   }   
    
	   @RequestMapping("/custOrderFilterByAjax")
	   public ModelAndView custOrderFilterByAjax(@RequestBody Map<String, String> inputParams){
		   String cust_passport = inputParams.get("cust_passport");
		   String cust_phone = inputParams.get("cust_phone");
		   String keyword = inputParams.get("keyword");
		   String strHidePageIndex=inputParams.get("hidepageindex");
		   
		   
		   System.out.println(cust_passport);
		   System.out.println(cust_phone);
		   System.out.println(keyword);
		   System.out.println(strHidePageIndex);
		   
		   List custMyOrderList = orderService.getCustMyOrder(cust_passport, cust_phone, keyword,Integer.valueOf(strHidePageIndex));
	    
	       ModelAndView mav = new ModelAndView("custMyOrderSub.ftl");
	       mav.addObject("custMyOrderList", custMyOrderList);
		   
		   return mav;
	   }
    
	   @RequestMapping("/custOrderDetail/{orderId}")
	    public ModelAndView custOrderDetail(@PathVariable("orderId") String orderId){
	    	ModelAndView mav = new ModelAndView("custOrderDetailQuery.ftl");
	        //从数据库获取信息赋值
	    	
	    	Map custOrderDetail = orderService.getCustOrderDetail(orderId);
	        
	        mav.addObject("title", "订单详情");
	        mav.addAllObjects(custOrderDetail);
	//	        mav.addObject("weixin", "1306520198@qq.com"); 
	        
	        return mav;
	    }

	   /*
	    * @auth:wenh
	    * 客户订单查询-订单详情-订单状态
	    * order_id 订单id
	    */
	   
	   @RequestMapping("/custOrderStateDetails/{order_id}")
	   public ModelAndView initCustOrderStateDetails(@PathVariable("order_id") String order_id)
	   {
	    	ModelAndView mav = new ModelAndView("custOrderStateDetails.ftl");
	        //查询数据库：ord_l_deallog
	    	
	    	List<Map<String, Object>> listdealloginfo=orderService.queryOrdersDealLogByOrderId(order_id);
	    	
	    	if (listdealloginfo != null && listdealloginfo.size()>0) {
	    		mav.addObject("listdealloginfo",listdealloginfo);
			}
	    	
	    	mav.addObject("order_id",order_id);
	        return mav;
	   }	   
	   
	   //add by wangxinjun
	    @RequestMapping("/phoneTradRecordList/{cust_phone}")
	    public ModelAndView custMyOrderTopUp(@PathVariable("cust_phone") String cust_phone){
	        ModelAndView mav = new ModelAndView("phoneTradRecordList.ftl");
//	    	List custMyOrderList = orderService.getCustMyOrder(cust_phone, null,1);//默认第一页显示4条记录
//	    	mav.addObject("custMyOrderList", custMyOrderList);
	    	mav.addObject("cust_phone", cust_phone);
	        mav.addObject("title", "一卡充订单");
	        return mav;
	    }	 
	    
	    @RequestMapping("/phoneTradRecordListPagePostData")
	    public ModelAndView phoneTradRecordListPagePostData(@RequestBody String inputParam){  
	    	//收支明细
//			pageNum: 页数，默认第一页
//			pageSize: 每页返回条目数量
			Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
			String user_id = paramsMap.get("user_id");
			String pageNum=paramsMap.get("pageNum");
			String pageSize=paramsMap.get("pageSize");
//		    List<Map<String, Object>> acctlogpagelist=myAcctService.queryAcctBalanceLogPage(user_id,Integer.parseInt(type),Integer.parseInt(pageNum),Integer.parseInt(pageSize),monthKey);
		    
		    ModelAndView mav = new ModelAndView("acctBalanceSub.ftl");
//		    if(acctlogpagelist != null && acctlogpagelist.size()>0)
//		    {
//	          mav.addObject("acctloglist",acctlogpagelist);
//		    }
	    	return mav;
	    }
	    
	    
	   
}
