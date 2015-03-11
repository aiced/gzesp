package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/newNumberJoin")
    public ModelAndView newNumberJoin(@RequestBody String inputParam){
        ModelAndView mav = new ModelAndView("newNumberJoin.ftl");
        //从数据库获取信息赋值
        mav.addObject("selectedPhone", "Iphone6 plus(5.5英寸) 16G深空灰色");
        mav.addObject("selectedContract", "4G 106元套餐 12月合约 </br> 电话 短信 流量 </br> 合约价6999"); 
        mav.addObject("selectedNumber", "1306520198"); 
        return mav;
    }
    
    @RequestMapping(value="/selectContract")
    public ModelAndView selectContract(@RequestBody String inputParams){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	String name = paramsMap.get("name");
    	
    
    
    	
    	List<Map<String, String>> pkgList = new ArrayList();
    	Map pkg = new HashMap();
    	pkg.put("price", "106元");
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
    	pkg.put("price", "306元");
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
    	pkg.put("price", "506元");
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
}
