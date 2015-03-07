package com.ai.wx.service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.WeShopDao;
import com.ai.wx.consts.MessageType;

@Service
public class WXMsgService {

	public void handleMsg(Map<String,String> info, HttpServletResponse response) throws IOException {
	    	String msgType = info.get(MessageType.XML_ATTR_MSG_TYPE);
	    	if(MessageType.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {
	    		
	    	} else if(MessageType.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) {
	    	} else if(MessageType.REQ_MESSAGE_TYPE_LINK.equals(msgType)) {
	    	} else if(MessageType.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) {
	    	} else if(MessageType.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) {
	    	} else if(MessageType.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
	    		String event = info.get(MessageType.XML_ATTR_EVENT);
	    		if(MessageType.EVENT_TYPE_SUBSCRIBE.equals(event)) {
	    			
	    		} else if(MessageType.EVENT_TYPE_UNSUBSCRIBE.equals(event)) {
	    		} else if(MessageType.EVENT_TYPE_SCAN.equals(event)) {
	    		} else if(MessageType.EVENT_TYPE_CLICK.equals(event)) {
	    			
	    		}
	    	}
	    	
	    	response.getWriter().write("");  
	    }
	
	    
	 public String Encrypt(String strSrc) {  
	        MessageDigest md = null;  
	        String strDes = null;  
	  
	        byte[] bt = strSrc.getBytes();  
	        try {  
	            md = MessageDigest.getInstance("SHA-1");  
	            md.update(bt);  
	            strDes = bytes2Hex(md.digest()); //to HexString  
	        } catch (NoSuchAlgorithmException e) {  
	            System.out.println("Invalid algorithm.");  
	            return null;  
	        }  
	        return strDes;  
	    }  
	  
	    public String bytes2Hex(byte[] bts) {  
	        String des = "";  
	        String tmp = null;  
	        for (int i = 0; i < bts.length; i++) {  
	            tmp = (Integer.toHexString(bts[i] & 0xFF));  
	            if (tmp.length() == 1) {  
	                des += "0";  
	            }  
	            des += tmp;  
	        }  
	        return des;  
	    }
}
