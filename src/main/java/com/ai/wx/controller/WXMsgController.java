package com.ai.wx.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.UserService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.entity.WebAuthAccessTokenModel;
import com.ai.wx.service.CoreService;
import com.ai.wx.service.CustomService;
import com.ai.wx.service.MenuService;
import com.ai.wx.service.PayBillService;
import com.ai.wx.service.WXMsgService;
import com.ai.wx.service.WebAuthService;
import com.ai.wx.util.DateUtils;

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
 	
 	@Resource 
 	CustomService customService;
	
	@Autowired
	private UserService userService;
	
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
//    	 Document doc = XmlUtil.stringToDoc(inputParam, "UTF-8");
//    	 Element rootElt = doc.getRootElement();
//    	 Iterator it = rootElt.elementIterator();
//    	 Map<String, String> info = new HashMap();
//    	 while(it.hasNext()) {
//    		 Element ele = (Element) it.next();
//    		 String name = ele.getName();
//    		 String text = ele.getTextTrim();
//    		 
//    		 logger.info("name----"+name);
//    		 logger.info("text----"+text);
//    		 info.put(name, text);
//    	 }
//    	 service.handleMsg(info, response);
    	 String respMessage = coreService.processRequest(inputParam);  
    	 response.getWriter().write(respMessage);  
    }
    

    /**
     * http://wap.gz10010.xyz/esp/wx/auth?code=CODE&state=STATE
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
    		 
    		 if("custPay".equals(state)) {
    			 mav=new ModelAndView("redirect:/weShop/wxPay?openId="+openId);
    			 return mav;
    		 }
    		 
    		 // 根据openId获取userId
    		 //String userId = service.getUserIdByOpenId(openId);
//    		 String userId = "2015000000000000";
    		 Map<Object, Object> userMap = userService.getUserInfoByOpenId(openId);  //20150526 ximh modify
    		 
    		 //用户已注册，免登录，根据state值跳页面
    		 if( userMap != null) {
    			 Subject subject = SecurityUtils.getSubject();
    			 org.apache.shiro.session.Session session = subject.getSession(true);
    			 if("weShopIndex".equals(state)) {
        			 mav=new ModelAndView("redirect:/weShop/index/"+ userMap.get("USER_ID"));    
        			 session.setAttribute("mchId", userMap.get("MCH_ID"));
        		 } else if("weShopHome".equals(state)) {
        			//调用shiro校验身份，EspRealm.doGetAuthenticationInfo(AuthenticationToken token)
     				UsernamePasswordToken token = new UsernamePasswordToken((String)userMap.get("PHONE_NUMBER"), (String)userMap.get("USER_PASSWORD"));
//     				Subject subject = SecurityUtils.getSubject();
     				session.setAttribute("mchId", userMap.get("MCH_ID"));
     				subject.login(token);
     				
        			 mav=new ModelAndView("redirect:/shopManage/weShopHome?userid="+ userMap.get("USER_ID"));    
        		 } else if("register".equals(state)) {
        			 mav=new ModelAndView("redirect:/auth/register/step1?openId="+openId);    
        		 } else if("queryInfo".equals(state)) {
        			 
        		 }
    			 //用户不存在，跳注册页
    		 } else {
    			 mav=new ModelAndView("redirect:/auth/register/step1?openId="+openId);
    		 }
    	 }
    	 return mav;
    }
    
    
    @Resource
  	public PayBillService billService;

    @RequestMapping("/downloadBill/{trade_day}")
    @ResponseBody
	public Map<String, Object> downloadBill(@PathVariable("trade_day") String tradeDay_YYYYMMDD) {
		Map<String, Object> result = new HashMap();
		DateFormat format = new SimpleDateFormat(DateUtils.PATTERN);
		try {
			format.parse(tradeDay_YYYYMMDD);
		} catch (ParseException e) {
			logger.error(tradeDay_YYYYMMDD + " is not a valid Date String.", e);
			result.put("return_code", "FAIL");
			result.put("return_msg", tradeDay_YYYYMMDD	+ " is not a valid Date String.");
			return result;
		}
		
		try {
			result = billService.downloadBill(tradeDay_YYYYMMDD);
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.put("return_code", "FAIL");
			result.put("return_msg", e.getMessage());
			return result;
		}
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
    	boolean flag  = menuService.createMenu(DataConstants.accessToken, inputParams);
    	return flag;
    }
    
    @RequestMapping("/custServiceSendMsg")
    @ResponseBody
    public void custServiceSendMsg(@RequestBody String inputParams){
    	customService.sendMsg(DataConstants.accessToken, inputParams);
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
//    	HashMap<String, Object> map = new HashMap<String, Object>();  
//        map.put("1", "fds");  
//        map.put("2", "valu");  
//        List<Map<String, Object>> salelist = new ArrayList<Map<String, Object>>();  
//        salelist.add(map);  
    	
        List<Map<String, Object>> salelist = goodsSql.GetSaleAdvanceList(); //根据能人id 查询店长推荐的列表
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

