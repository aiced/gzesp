package com.ai.sysframe.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CommonUtil {
    
    private static Map mthMap = new HashMap();
    
    public static Locale locale = Locale.getDefault();
    
    public static ResourceBundle commonResource = ResourceBundle.getBundle("mvcmsg", locale);
    
    public static ResourceBundle messagesResource = ResourceBundle.getBundle("messages", locale);
    
    public static int SIGN_SCORE = 10;
    
    public static ResourceBundle appResource = ResourceBundle.getBundle("application", locale);
    
    public static String getClsNam(Object obj)
    {
      if (obj != null)
        return obj.getClass().getSimpleName();

      return null;
    }
    
    public static Integer getInteger(String str)
    {
      return 
        new Integer(str);
    }

    public static Integer getInteger(Object obj)
    {
      if (obj == null)
        return Integer.valueOf(0);

      String s = obj.toString();

      return Integer.valueOf((checkInt(s)) ? new Integer(s).intValue() : 0);
    }
    
    public static String checkNull(String str)
    {
      return (((str == null) || ("null".equals(str))) ? "" : str);
    }

    public static boolean checkInt(String str)
    {
      if ((str == null) || ("".equals(str)))
        return false;

      if (str.matches("[\\d]+")) {
        if (str.length() > 9) {
          if (str.length() >= 10) {
            return false;
          }

          return (new Long(str).longValue() < 2147483647L);
        }
        return true;
      }

      return false;
    }

    public static boolean checkInt(Object obj)
    {
      if (obj == null)
        return false;

      return checkInt(obj.toString());
    }

    
    public static boolean isNull(String str)
    {
      return ((str == null) || ("".equals(str)) || ("null".equals(str)));
    }

    public static boolean isNull(Object o)
    {
      return ((o == null) || ("".equals(o)));
    }
    
    public static Object dealNull(Object o)
    {
      return (((o == null) || ("null".equals(o.toString()))) ? "" : o);
    }
    
    public static Object runMethod(Object obj, String fieldNam)
    {
      StringBuffer sb;
      try
      {
        sb = new StringBuffer("get");
        sb.append(fieldNam.substring(0, 1).toUpperCase()).append(
          fieldNam.substring(1));

        return getMethod(obj, sb.toString()).invoke(obj, null);
      } catch (Exception e) {
      }
      return null;
    }
    
    public static Method getMethod(Object o, String s)
    {
      return getMethod(o, s, null);
    }

    public static Method getMethod(Object o, String s, Class[] cls)
    {
      Class c;
      try
      {
        c = o.getClass();
        Method m = null;

        StringBuffer sb = new StringBuffer();

        sb.append(c.getSimpleName()).append("_").append(s);
        String k = sb.toString();

        if (mthMap.containsKey(k)) {
          m = (Method)mthMap.get(k);
        } else {
          m = c.getMethod(s, cls);
          mthMap.put(k, m);
        }

        m.setAccessible(true);

        return m; } catch (Exception e) {
      }
      return null;
    }
    
    public static Object runObjMethod(Object o, String s)
    {
      try
      {
        return getMethod(o, s).invoke(o, new Object[0]);
      } catch (Exception e) {
        if ((!("getCreateId".equals(s))) && (!("getModifyId".equals(s))))
          e.printStackTrace(); 
      }
      return null;
    }
    
   /*
    public static Map<String,Object> parseJSON2Map(String jsonStr) 
    {
//		Map map=new HashMap();
//		JSONObject json=JSONObject.fromObject(s);
//		Iterator keys=json.keys();
//		while(keys.hasNext()){
//			String key=(String) keys.next();
//			String value=json.get(key).toString();
//			if(value.startsWith("{")&&value.endsWith("}")){
//				map.put(key, parserToMap(value));
//			}else{
//				map.put(key, value);
//			}
//		}
//		return map;
    	
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }*/
    
    public static Map<String,Object> parseJSON2Map(String jsonStr) 
    {
    	
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
    
    public static String getMvcMsg(String key) 
    {
        return commonResource.getString(key);
    }
    
    public static String getAppMsg(String key) 
    {
        return appResource.getString(key);
    }
    
    public static Map<String, Object> parseUrlParams2Map(String param) {  
        Map<String, Object> map = new HashMap();  
        
        if( param == null ||  "".equals(param)) {
        	return map;
        }
        
        String[] params = param.split("&");  
        for (int i = 0; i < params.length; i++) {  
            String[] p = params[i].split("=");  
            if (p.length == 2) {  
                map.put(p[0], p[1]);  
            }  
        }  
        return map;  
    } 
}
