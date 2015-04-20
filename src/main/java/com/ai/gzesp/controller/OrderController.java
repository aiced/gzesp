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
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
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
        mav.getModel().putAll(info);
        mav.getModel().putAll(paramsMap);
        mav.addObject("citys", citys);
        return mav;
    }
    
    @RequestMapping("/submitFilledOrder")
    public ModelAndView submitFilledOrder(@RequestBody String inputParams) throws UnsupportedEncodingException{
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String orderId = CommonUtil.generateOrderId();
    	String payLogId = CommonUtil.generatePayLogId();
    	String originalPrice = paramsMap.get("originalPrice");
    	long fee  = CommonUtil.toDbPrice(CommonUtil.string2Long(originalPrice));
    	paramsMap.put("orderId", orderId);
    	paramsMap.put("payLogId", payLogId);
    	
    	orderService.insertOrder(paramsMap);
    	
    	String url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee;
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
    
}
