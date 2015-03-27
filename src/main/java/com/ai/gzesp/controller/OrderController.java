package com.ai.gzesp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.service.TdSysPWEBDISTRICTDao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Resource
    private WeShopService weShopService;
    
    @Resource
    private SelectNumberService selectNumberService;
    
    @Resource 
    OrderService orderService;
    
    @Resource
    TdSysPWEBDISTRICTDao tdSysPWEBDISTRICTDao;
    
    @RequestMapping("/newNumberJoin")
    public ModelAndView newNumberJoin(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String goods_id = paramsMap.containsKey("goods_id")?paramsMap.get("goods_id"):"";
//    	String goods_name = paramsMap.containsKey("goods_name")?paramsMap.get("goods_name"):"";
//    	String goods_price = paramsMap.containsKey("goods_price")?paramsMap.get("goods_price"):"";
//    	String user_id = paramsMap.containsKey("user_id")?paramsMap.get("user_id"):"";
//    	String goods_disc = paramsMap.containsKey("goods_disc")?paramsMap.get("goods_disc"):"";
//    	String attr_val = paramsMap.containsKey("attr_val")?paramsMap.get("attr_val"):"";
//    	String fromPage = paramsMap.containsKey("fromPage")?paramsMap.get("fromPage"):"";
    	
    	 ModelAndView mav = new ModelAndView("newNumberJoin.ftl");
//        mav.addObject("selectedPhone", goods_name);
//        mav.addObject("selectedContract", "4G 106元套餐 12月合约 </br> 电话 短信 流量 </br> 合约价6999"); 
//        mav.addObject("selectedNumber", "1306520198"); 
//        mav.addObject("goods_price", goods_price); 
        mav.getModel().putAll(paramsMap);
        mav.addObject("title", "新号入网"); 
        
        selectNumberData(mav);
        selectContractData(mav, goods_id);
        
        return mav;
    }
    
    private void selectNumberData(ModelAndView mav){
    	 //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        mav.addObject("citys", citys);
        
        //获取靓号规则下拉框
        List<Map<Object, Object>> rules = selectNumberService.getNumberRules();
        mav.addObject("rules", rules);
        
        //数据库分页获取号码列表，默认归属贵阳,预存0-10000，第一页,一页20个,
        List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(null, null, 0, 10000, 1, 20, null, null, null);
        mav.addObject("numbers", numbers);	
    }
    
    private void selectContractData(ModelAndView mav,String goodsId){
    	List<Map>[] contractList = orderService.getContractByGoodsID(goodsId);
    	mav.addObject("pkgList", contractList[0]);
    	mav.addObject("peroidList", contractList[1]);
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
    public ModelAndView fillOrderMain(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String fromPage = paramsMap.get("fromPage");
    	if(fromPage != null &&
    			("planDetail".equals(fromPage) || "cardGoodDetail".equals(fromPage) )) {
    		paramsMap = convertKey(paramsMap);
    	}
    	
    	String goodsId = paramsMap.get("goodsId");
    	Map info = orderService.getGoodsDefaultPhoto(goodsId);
    	
    	List<Map<Object, Object>> citys = weShopService.getCitys();
       
    	
        ModelAndView mav = new ModelAndView("fillOrderMain.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "订单填写");
//        mav.addObject("originalPrice", "998");
//        mav.addObject("userId", "1234567890");
        mav.getModel().putAll(info);
        mav.getModel().putAll(paramsMap);
        mav.addObject("citys", citys);
        return mav;
    }
    
    @RequestMapping("/submitFilledOrder")
    public ModelAndView submitFilledOrder(@RequestBody String inputParams) throws UnsupportedEncodingException{
//    	inputParams = URLDecoder.decode(inputParams);		
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String orderId = CommonUtil.generateOrderId();
    	String payLogId = CommonUtil.generatePayLogId();
    	paramsMap.put("orderId", orderId);
    	paramsMap.put("payLogId", payLogId);
    	
    	orderService.insertOrder(paramsMap);
    	
    	ModelAndView mav = new ModelAndView("redirect:/shopManage/ordersQuery");
    	//从数据库获取信息赋值
    	mav.addObject("title", "订单支付");
    	mav.addObject("userid", paramsMap.get("userId"));
    	
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
    
}
