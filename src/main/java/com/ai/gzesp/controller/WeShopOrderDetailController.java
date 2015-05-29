package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.service.TdAurDBASEINFODao;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class WeShopOrderDetailController {
    @Autowired
    private WeShopService weShopService;
	@Resource 
	OrdersSql ordersSql;
	@Resource
	TdOrdDREFUNDDao tdOrdDREFUNDDao;
	@Resource
	TdOrdDBASEDao tdOrdDBASEDao;
	
	
    @RequestMapping("/orderDetail")
    public ModelAndView index(@RequestBody String inputParams){
    	
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	System.out.println(paramsMap);
        String strOrderid=paramsMap.get("ORDER_ID");
        System.out.println("ORDER_ID:"+strOrderid);

    	ModelAndView mav = new ModelAndView("orderDetail.ftl");


        //从数据库获取信息赋值
    	List<Map<String, Object>> orderList=ordersSql.getOrderInfobyOrderID(strOrderid);
    	
        if (orderList.size()<=0) {
            mav.addObject("title", "订单详情");
            mav.addObject("ORDER_ID","没有数据");
            mav.addObject("GOODS_NAME","没有数据");
            mav.addObject("TOPAY_FEE",0);
            mav.addObject("Order_Time","没有数据");
            mav.addObject("RECEIVER_NAME","没有数据");
            mav.addObject("POST_ADDR","没有数据");
            mav.addObject("MOBILE_PHONE","没有数据");
            mav.addObject("DELIVER_TIME_CODE","没有数据");
            mav.addObject("PAY_MODE","没有数据");
            mav.addObject("ORDER_STATE","没有数据");      
            //mav.addObject("PAY_REMARK","没有数据");
            mav.addObject("RES_ATTR_VAL_1","没有数据"); 
            mav.addObject("RES_ATTR_VAL_2","没有数据"); 
            mav.addObject("RES_ATTR_VAL_3","没有数据"); 
            mav.addObject("RES_ATTR_VAL_4","没有数据"); 
            mav.addObject("REFUND_STATE","未知");
            mav.addObject("REFUND_REASON","无");
            mav.addObject("ORDER_STATE_REFUND","无");
		}
        else {
            mav.addObject("title", "订单详情");
            mav.addObject("ORDER_ID",strOrderid);
            mav.addObject("GOODS_NAME",orderList.get(0).get("GOODS_NAME"));
            mav.addObject("TOPAY_FEE",orderList.get(0).get("TOPAY_FEE"));
            mav.addObject("Order_Time",orderList.get(0).get("Order_Time"));
            mav.addObject("RECEIVER_NAME",orderList.get(0).get("RECEIVER_NAME"));
            mav.addObject("POST_ADDR",orderList.get(0).get("POST_ADDR"));
            mav.addObject("MOBILE_PHONE",orderList.get(0).get("MOBILE_PHONE"));
            mav.addObject("DELIVER_TIME_CODE",orderList.get(0).get("DELIVER_TIME_CODE"));
            mav.addObject("PAY_MODE",orderList.get(0).get("PAY_MODE"));
            mav.addObject("ORDER_STATE",orderList.get(0).get("ORDER_STATE")); 
            mav.addObject("RES_ATTR_VAL_1",orderList.get(0).get("RES_ATTR_VAL_1")); 
            mav.addObject("RES_ATTR_VAL_2",orderList.get(0).get("RES_ATTR_VAL_2")); 
            mav.addObject("RES_ATTR_VAL_3",orderList.get(0).get("RES_ATTR_VAL_3")); 
            mav.addObject("RES_ATTR_VAL_4",orderList.get(0).get("RES_ATTR_VAL_4")); 
            mav.addObject("REFUND_STATE",orderList.get(0).get("REFUND_STATE"));
            mav.addObject("REFUND_REASON",orderList.get(0).get("REFUND_REASON"));
            mav.addObject("ORDER_STATE_REFUND",orderList.get(0).get("ORDER_STATE_REFUND"));
		}
        
        return mav;
    }
    

    
    
    
    
    @RequestMapping("/orderStatusUpdate")
    @ResponseBody
    public String updateOrderStatus(@RequestBody String Params)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(Params);
    	String strorder_id=paramsMap.get("ORDER_ID");
    	String strstatus=paramsMap.get("status");
    	
    	System.out.println(strorder_id);
    	System.out.println(strstatus);
    	
    	Criteria example_refund = new Criteria();
    	example_refund.createConditon().andEqualTo("ORDER_ID", strorder_id);
    	
    	TdOrdDREFUND record_refund = new TdOrdDREFUND();
    	record_refund.setRefundState(strstatus);
    	int icount=tdOrdDREFUNDDao.updateByExampleSelective(record_refund, example_refund);
    	System.out.println("icount_refund="+icount);
    	
    	
    	Criteria example_base=new Criteria();
    	example_base.createConditon().andEqualTo("ORDER_ID", strorder_id);
    	TdOrdDBASE record_base = new TdOrdDBASE();
        record_base.setOrderState(strstatus);

    	icount=tdOrdDBASEDao.updateByExampleSelective(record_base, example_base);
    	System.out.println("icount_base="+icount);

    	if (icount>0)
    	{
    		return "操作成功";
		}
    	else {
			return "操作失败";
		}
    }
    
}
