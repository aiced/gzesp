package com.ai.wx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;
import com.ai.sysframe.utils.XmlUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.entity.WebAuthAccessTokenModel;
import com.ai.wx.service.CoreService;
import com.ai.wx.service.MenuService;
import com.ai.wx.service.WXMsgService;
import com.ai.wx.service.WebAuthService;
import com.ai.wx.util.RegexUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/wx")
public class WXMsgController {
//     final String Token = "asiainfo";
     
     protected Logger logger = LoggerFactory.getLogger(getClass());
     
 	@Resource 
 	WXMsgService service;
 	
 	@Resource 
 	CoreService coreService;
 	
 	@Resource 
 	MenuService menuService;
 	
 	@Resource 
 	WebAuthService webAuthService;
	
    @RequestMapping(value="/access",method = RequestMethod.GET)
    public void access(@RequestParam(value = "signature", required = true)String signature,
    		@RequestParam(value = "timestamp", required = true)String timestamp,
    		@RequestParam(value = "nonce", required = true)String nonce,
    		@RequestParam(value = "echostr", required = true)String echostr,
    		HttpServletResponse response) throws IOException{
    	
    	 String[] ArrTmp = { DataConstants.TOKEN, timestamp, nonce };  
         Arrays.sort(ArrTmp);  
         StringBuffer sb = new StringBuffer();  
         for (int i = 0; i < ArrTmp.length; i++) {  
             sb.append(ArrTmp[i]);  
         }  
         String pwd = service.Encrypt(sb.toString());  
            
         logger.info("signature:"+signature+"timestamp:"+timestamp+"nonce:"+nonce+"pwd:"+pwd+"echostr:"+echostr);  
           
         if (pwd.equals(signature)) {  
             response.getWriter().write(echostr);  
         }
    }
    
    @RequestMapping(value="/access",method = RequestMethod.POST)
    public void access_post(@RequestBody String inputParam, HttpServletResponse response) throws IOException {
    	 logger.info(inputParam);
    	 Document doc = XmlUtil.stringToDoc(inputParam, "UTF-8");
    	 Element rootElt = doc.getRootElement();
    	 Iterator it = rootElt.elementIterator();
    	 Map<String, String> info = new HashMap();
    	 while(it.hasNext()) {
    		 Element ele = (Element) it.next();
    		 String name = ele.getName();
    		 String text = ele.getTextTrim();
    		 
    		 logger.info("name----"+name);
    		 logger.info("text----"+text);
    		 info.put(name, text);
    	 }
//    	 service.handleMsg(info, response);
    	 String respMessage = coreService.processRequest(inputParam);  
    	 response.getWriter().write(respMessage);  
    }
    

    /**
     * http://wap.gz10010.xyz/wx/auth?code=CODE&state=STATE
     * state 参数表示跳转页面（weShopIndex, weShopHome, queryInfo..）
     * code 用于获取openId
     * @param state
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/auth")
    public ModelAndView auth(@RequestParam(value="code", required=true) String code, 
    		@RequestParam(value="state", required=true) String state, HttpServletResponse response) throws IOException {
    	 logger.info("params:" + code + "," +state);
    	 WebAuthAccessTokenModel webToken =  webAuthService.getAccessToken(DataConstants.appid, DataConstants.appsecret, code);
    	 ModelAndView mav = null;
    	 if(webToken != null) {
    		 String openId = webToken.getOpenid();
    		 if(openId == null) {
    			 mav=new ModelAndView("redirect:/error");
    			 return mav;
    		 }
    		 
    		 // 根据openId获取userId
    		 String userId = service.getUserIdByOpenId(openId);
//    		 String userId = "2015000000000000";
    		 //用户已注册，免登录，根据state值跳页面
    		 if( userId != null) {
    			 if("weShopIndex".equals(state)) {
        			 mav=new ModelAndView("redirect:/shopManage/weShopHome?userid="+userId);    
        		 } else if("weShopHome".equals(state)) {
        			 mav=new ModelAndView("redirect:/weShop/index/"+userId);    
        		 } else if("queryInfo".equals(state)) {
        			 
        		 }
    			 //用户不存在，跳注册页
    		 } else {
    			 mav=new ModelAndView("redirect:/auth/register/step1");
    		 }
    	 }
    	 return mav;
    }
    
    @RequestMapping("/createMenu")
    public ModelAndView createMenu(){
        ModelAndView mav = new ModelAndView("wxCreateMenu.ftl");
        mav.addObject("title", "创建菜单");
        return mav;
    }
    
    
    @RequestMapping("/createMenuSubmit")
    @ResponseBody
    public boolean createMenuSubmit(@RequestBody String inputParams){
//    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
//    	String menuTxt = paramsMap.containsKey("menuTxt")?paramsMap.get("menuTxt"):"";
//    	inputParams = RegexUtils.getStringNoBlank(inputParams);
    	boolean flag  = menuService.createMenu(DataConstants.accessToken, inputParams);
    	
    	return flag;
    	
//    	JSONObject obj = JSON.parseObject(inputParams);
//    	menuService.createMenu(DataConstants.accessToken, obj.toJSONString());
    	
//    	ModelAndView mav = new ModelAndView("wxCreateMenu.ftl");
//    	mav.addObject("title", "创建菜单");
    }
    
    
    @RequestMapping("/incomeNote")
    public ModelAndView incomeNote(){
        ModelAndView mav = new ModelAndView("wxIncomeNote.ftl");
        mav.addObject("title", "收益说明");
        return mav;
    }
    
    @RequestMapping("/cashRule")
    public ModelAndView cashRule(){
    	ModelAndView mav = new ModelAndView("wxCashRule.ftl");
    	mav.addObject("title", "提现规则");
    	return mav;
    }
    @Resource 
    GoodsSql goodsSql;
    @RequestMapping("/saleAdvance")
    public ModelAndView saleAdvance(){
    	
//        List<Map<String, Object>> salelist = goodsSql.GetRcdList("11"); //根据能人id 查询店长推荐的列表
    	HashMap<String, Object> map = new HashMap<String, Object>();  
        map.put("1", "fds");  
        map.put("2", "valu");  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        list.add(map);  
    	
        List<Map<String, Object>> salelist = goodsSql.GetRcdList("11"); //根据能人id 查询店长推荐的列表
    	Map<String, Object> rspMap =  new HashMap<String, Object>();   
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("salelist", salelist);  
    	rspMap.put("title", "销售进阶"); 
    	return new ModelAndView("wxSaleAdvance.ftl", rspMap);
    	
    	
    	
//    	ModelAndView mav = new ModelAndView("wxSaleAdvance.ftl");
//    	mav.addObject("title", "销售进阶");
//    	return mav;
    }
    
    @RequestMapping("/more")
    public ModelAndView more(){
    	ModelAndView mav = new ModelAndView("wxMore.ftl");
    	mav.addObject("title", "更多互动咨询");
    	return mav;
    }
    
    @RequestMapping("/guides")
    public ModelAndView guides(){
    	ModelAndView mav = new ModelAndView("wxGuides.ftl");
    	mav.addObject("title", "入门须知");
    	return mav;
    }
    
}

