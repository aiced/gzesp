package com.ai.wx.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.sysframe.utils.XmlUtil;
import com.ai.wx.consts.DataConstants;
import com.ai.wx.service.CoreService;
import com.ai.wx.service.WXMsgService;

@Controller
@RequestMapping("/wx")
public class WXMsgController {
//     final String Token = "asiainfo";
     
     protected Logger logger = LoggerFactory.getLogger(getClass());
     
 	@Resource 
 	WXMsgService service;
 	
 	@Resource 
 	CoreService coreService;
	
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
    
   
    
}

