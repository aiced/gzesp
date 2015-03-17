package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/order")
public class OrderController {
    
	private static String pageName1 = "";
	private static String pageName2 = "selectContract";
	private static String pageName3 = "selectNumber";
	
    @Resource
    private WeShopService weShopService;
    
    @Resource 
    TdOrdDBASEDao tdOrdDBASEDao;
    
    @Resource 
    GoodsSql goodsSql;
    
    @Resource 
    OrderService orderService;
    
    @RequestMapping("/newNumberJoin")
    public ModelAndView newNumberJoin(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String goods_id = paramsMap.containsKey("goods_id")?paramsMap.get("goods_id"):"";
    	String goods_name = paramsMap.containsKey("goods_name")?paramsMap.get("goods_name"):"";
    	String goods_price = paramsMap.containsKey("goods_price")?paramsMap.get("goods_price"):"";
    	String user_id = paramsMap.containsKey("user_id")?paramsMap.get("user_id"):"";
//    	String selectState = paramsMap.containsKey("selectState")?paramsMap.get("selectState"):"0";
    	String fromPage = paramsMap.containsKey("fromPage")?paramsMap.get("fromPage"):"";
    	
    	  ModelAndView mav = new ModelAndView("newNumberJoin.ftl");
    	  
    	int selectState = 0;
    	if(pageName2.equalsIgnoreCase(fromPage)) {
    		selectState = 1;
    	} else if(pageName3.equalsIgnoreCase(fromPage)) {
    		selectState = 2;
    	}
    	
      
        //从数据库获取信息赋值
        mav.addObject("selectedPhone", goods_name);
        mav.addObject("selectedContract", "4G 106元套餐 12月合约 </br> 电话 短信 流量 </br> 合约价6999"); 
        mav.addObject("selectedNumber", "1306520198"); 
        mav.addObject("goods_price", goods_price); 
        mav.addObject("selectState", selectState); 
        mav.addObject("title", "新号入网"); 
        return mav;
    }
    
    @RequestMapping(value="/selectContract")
    public ModelAndView selectContract(@RequestBody String inputParams){
//    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
//    	String name = paramsMap.get("name");
//    	
//    	TdOrdDBASE record = new TdOrdDBASE();
//    	record.setOrderId(123456l);
//    	record.setCreateTime(DateUtil.getNow());
//    	tdOrdDBASEDao.insertSelective(record);
//    
//    	Criteria example = new Criteria();
//    	example.createConditon().andEqualTo("ORDER_ID", "123456");
//    	List<TdOrdDBASE> list = tdOrdDBASEDao.selectByExample(example);
//    	
//    	tdOrdDBASEDao.updateByExampleSelective(record, example);
//    	
//    	List<Map<String, Object>> list = goodsSql.getGoodsList();

    	
    	
    	List<Map<String, String>> pkgList = new ArrayList();
    	Map pkg = new HashMap();
    	pkg.put("price", "106元");
    	pkg.put("type", "1");
    	pkg.put("nationalminutes", "300分钟");
    	pkg.put("nationalthroughtput", "400MB");
    	pkg.put("period", new int[]{12,24,36});
    	pkg.put("returnDesc", new String[]{
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分12个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分24个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分36个月返完。"});
    	pkg.put("totalFee", "4699元");
    	pkg.put("returnFee", "3499元");
    	pkg.put("monthRtnFee", "25元");
    	pkgList.add(pkg);
    	
    	pkg = new HashMap();
    	pkg.put("price", "206元");
    	pkg.put("type", "2");
    	pkg.put("nationalminutes", "500分钟");
    	pkg.put("nationalthroughtput", "600MB");
    	pkg.put("period", new int[]{12,24,36});
    	pkg.put("returnDesc", new String[]{
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分12个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分24个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分36个月返完。"});
    	pkg.put("totalFee", "4699元");
    	pkg.put("returnFee", "3499元");
    	pkg.put("monthRtnFee", "25元");
    	pkgList.add(pkg);
    	
    	pkg = new HashMap();
    	pkg.put("price", "306元");
    	pkg.put("type", "3");
    	pkg.put("nationalminutes", "600分钟");
    	pkg.put("nationalthroughtput", "600MB");
    	pkg.put("period", new int[]{12,24,36});
    	pkg.put("returnDesc", new String[]{
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分12个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分24个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分36个月返完。"});
    	pkg.put("totalFee", "4699元");
    	pkg.put("returnFee", "3499元");
    	pkg.put("monthRtnFee", "25元");
    	pkgList.add(pkg);
    	
    	pkg = new HashMap();
    	pkg.put("price", "406元");
    	pkg.put("type", "4");
    	pkg.put("nationalminutes", "800分钟");
    	pkg.put("nationalthroughtput", "600MB");
    	pkg.put("period", new int[]{12,24,36});
    	pkg.put("returnDesc", new String[]{
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分12个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分24个月返完。",
    	"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分36个月返完。"});
    	pkg.put("totalFee", "4699元");
    	pkg.put("returnFee", "3499元");
    	pkg.put("monthRtnFee", "25元");
    	pkgList.add(pkg);
    	
    	pkg = new HashMap();
    	pkg.put("price", "506元");
    	pkg.put("type", "5");
    	pkg.put("nationalminutes", "1600分钟");
    	pkg.put("nationalthroughtput", "600MB");
    	pkg.put("period", new int[]{12,24,36});
    	pkg.put("returnDesc", new String[]{
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分12个月返完。",
    			"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分24个月返完。",
    	"所赠3499元话费，当月即返还1999元，剩余部分每月返款200元，分36个月返完。"});
    	pkg.put("totalFee", "4699元");
    	pkg.put("returnFee", "3499元");
    	pkg.put("monthRtnFee", "25元");
    	pkgList.add(pkg);
    	
    	Map model = new HashMap();
    	model.put("pkgList", pkgList);
    	ModelAndView mav = new ModelAndView("selectContract.ftl", model);
    	//从数据库获取信息赋值
    	mav.addObject("selectedPhone", "Iphone6 plus(5.5英寸) 16G深空灰色");
    	mav.addObject("selectedContract", "4G 106元套餐 12月合约 </br> 电话 短信 流量 </br> 合约价6999"); 
    	mav.addObject("selectedNumber", "1306520198"); 
    	mav.addObject("title", "选择合约"); 
    	return mav;
    }
    
    @RequestMapping("/fillOrderMain")
    public ModelAndView fillOrderMain(){
        ModelAndView mav = new ModelAndView("fillOrderMain.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "订单填写");
        return mav;
    }
    
    @RequestMapping("/submitFilledOrder")
    public ModelAndView submitFilledOrder(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	
    	String orderId = CommonUtil.generateOrderId();
    	paramsMap.put("orderId", orderId);
    	
    	orderService.insertOrder(paramsMap);
    	
    	ModelAndView mav = new ModelAndView("payFee.ftl");
    	//从数据库获取信息赋值
    	mav.addObject("title", "订单支付");
    	
    	return mav;
    }
}
