package com.ai.gzesp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.dao.sql.RefundSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/customer")
public class WeShopCustRefundController {

    @Resource
	TdOrdDREFUNDDao tdOrdDREFUNDDao;
	
    @Autowired
    private WeShopService weShopService;
	@Resource 
	RefundSql refundSql;
	
	   @RequestMapping("/custRefund")
	    public ModelAndView index(@RequestParam(value = "orderid", required = true)String strOrderID){
	    	
			System.out.println(strOrderID);
			List<Map<String, Object>> refundList=refundSql.getOrderInfoByOrderID(strOrderID);
		   
		   ModelAndView mav = new ModelAndView("custRefund.ftl");
	        //从数据库获取信息赋值
	        
	        mav.addObject("title", "申请退款");
	        mav.addObject("refundInfo", refundList.get(0));
	        
	        return mav;
	    }
	   @RequestMapping("/insertRefund")
	   @ResponseBody
	   public ModelAndView InsertRefund(@RequestBody String inputParams)
	   {
	    	System.out.println(inputParams);
	    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
	    	
	    	
	    	String strname=paramsMap.get("txtname");
	    	String strphone=paramsMap.get("txtphone");
	    	String strreason=paramsMap.get("txtreason");
	    	
	    	String order_id=paramsMap.get("hide_order_id");
	    	String unit_price=paramsMap.get("hide_unit_price");
	    	String Partition_Id=paramsMap.get("hide_Partition_Id");
	    	String order_no=paramsMap.get("hide_order_no");
	    	String create_time=paramsMap.get("hide_create_time");
	    	String order_from=paramsMap.get("hide_order_from");
	    	String order_time=paramsMap.get("hide_order_time");
	    	String order_state=paramsMap.get("hide_order_state");
	    	String REFUND_TYPE="09";//固定写死订单处理退单：09客户拒收退单：10
	    	String REFUND_STATE="00";
//	    	未审核：00
//	    	审核未通过：01
//	    	审核通过未退款：02
//	    	审核通过已退款：03	
	    	System.out.println(Partition_Id);
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	    	Date date_create_time=DateUtil.getNow();
			try {
				date_create_time = sdf.parse(create_time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Date date_order_time=DateUtil.getNow();
			try {
				date_order_time = sdf.parse(order_time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	//插入退单表
	    	TdOrdDREFUND record_orddrefund=new TdOrdDREFUND();
	    	record_orddrefund.setOrderId(Long.valueOf(order_id));
	    	record_orddrefund.setPartitionId(Short.valueOf(Partition_Id));
	    	record_orddrefund.setOrderNo(order_no);

	    	record_orddrefund.setCreateTime(date_create_time);
	    	record_orddrefund.setOrderFrom(order_from);
	    	record_orddrefund.setOrderTime(date_order_time);
	    	record_orddrefund.setCustName(strname);
	    	record_orddrefund.setPhoneNumber(strphone);
	    	record_orddrefund.setTxnAmt(Long.valueOf(unit_price));
	    	record_orddrefund.setOrderState(order_state);
	    	record_orddrefund.setRefundType(REFUND_TYPE);
	    	record_orddrefund.setRefundReason(strreason);
	    	record_orddrefund.setRefundState(REFUND_STATE);
	    	
	    	
	    	tdOrdDREFUNDDao.insertSelective(record_orddrefund);
	    	
	    	
	     	ModelAndView mav = new ModelAndView("redirect:/customer/custRefundSuccess");
	    	
	    	
	    	return mav;
	   }
}
