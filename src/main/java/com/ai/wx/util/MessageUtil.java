package com.ai.wx.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ai.wx.entity.request.RequestTextMessage;


/**
 * 消息工具类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class MessageUtil {

  public static void buildEmptyResponseText(){
/*      ResponseTextMessage resp = new ResponseTextMessage();
      
      resp.setFromUserName(message.getToUserName());
      resp.setToUserName(message.getFromUserName());
      resp.setCreateTime(new Date().getTime());
      resp.setContent(null); //文本内容可以根据需要修改
      resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
      resp.setFuncFlag(0);
      
      return XmlUtils.textMessageToXml(resp);*/
  }
  
  public static Field[] getFields(Class clz) {
	  List<Field> list = new ArrayList();
      while(clz != null) {
    	  Field[] fields = clz.getDeclaredFields();
    	  for(Field f : fields) {
    		  list.add(f);
    	  }
    	  clz = clz.getSuperclass();
      }
      return list.toArray(new Field[list.size()]);
  }
  
}
