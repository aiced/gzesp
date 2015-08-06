package com.ai.sysframe.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
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
    
//    public static Map<String, Object> parseUrlParams2Map(String param) {  
//        Map<String, Object> map = new HashMap();  
//        
//        if( param == null ||  "".equals(param)) {
//        	return map;
//        }
//        
//        String[] params = param.split("&");  
//        for (int i = 0; i < params.length; i++) {  
//            String[] p = params[i].split("=");  
//            if (p.length == 2) {  
//                map.put(p[0], p[1]);  
//            }  
//        }  
//        return map;  
//    } 
    
    
    public static String generateOrderId() {
    	String idType = "1";
    	return generateOrderId(idType);
    }
    
    /**
     * ordType 1:普通订单； 2：充值卡缴费; 3:宽带续约
     * 
     * @param ordType
     * @return
     */
    public static String generateOrderId(String ordType) {
    	long time =  System.currentTimeMillis();
    	Random r = new Random();
    	int rint = r.nextInt(99);
    	String rStr = StringUtil.paddingLeft(String.valueOf(rint), '0', 2);
    	return ordType + rStr + time;
    }
    
    /**
     * payType 2:微信支付； 3：银联; 4：沃支付； 5：deal_log_id
     * edit_by_wenh
     * 7:bss 调用日志表
     * 6:ACT_D_ACCESS_LOG调用日志表
     * @param payType
     * @return
     */
    public static String generateLogId(String payType) {
//    	String idType = "2";
    	long time =  System.currentTimeMillis();
    	Random r = new Random();
    	int rint = r.nextInt(99);
    	String rStr = StringUtil.paddingLeft(String.valueOf(rint), '0', 2);
    	return payType + rStr + time;
    }
    
    public static String getPartitionId(String str) { 
    	if(str == null || str.length() < 2) {
    		return str;
    	}
    	String partitionId = str.substring(str.length()-2);
    	return partitionId;
    }
    
    public static Long string2Long(String str) {
    	if(str == null || "".equals(str.trim())) {
    		return null;
    	}
    	Long l;
    	try {
    		l = Long.parseLong(str);
    	} catch(NumberFormatException e) {
    		l = null;
    	}
    	return l;
    }
    
    public static Float string2Float(String str) {
    	if(str == null || "".equals(str.trim())) {
    		return null;
    	}
    	Float f;
    	try {
    		f = Float.parseFloat(str);
    	} catch(NumberFormatException e) {
    		f = null;
    	}
    	return f;
    }
    
    public static Integer string2Int(String str) {
    	if(str == null || "".equals(str.trim())) {
    		return null;
    	}
    	Integer i;
    	try {
    		i = Integer.parseInt(str);
    	} catch(NumberFormatException e) {
    		i = null;
    	}
    	return i;
    }
    
    public static Long toDbPrice(Long l) {
    	if(l != null) {
    		l = l * 1000;
    	}
    	return l;
    }
    
    public static Long toDbPrice(Float f) {
    	if(f != null) {
    		f = f * 1000;
    	}
    	return f==null?null:f.longValue();
    }
    /*
     * @author wenhui 
     * @param strBankCard 银行卡号
     * @decs 判断银行卡号是否正确
     * @date 2015_3_12 11:25看
     */
    public static Boolean checkBankCard(String strBankCard)
    {	  
  	  int sumOdd = 0;
  	  int sumEven = 0;
	  int length = strBankCard.length();
	  System.out.println(strBankCard);
	  System.out.println(length);
	  int[] wei = new int[length];
	  for (int i = 0; i < strBankCard.length(); i++) {
    	  wei[i] = Integer.parseInt(strBankCard.substring(length - i - 1, length- i));// 从最末一位开始提取，每一位上的数值
    	  System.out.println("第" + i + "位数字是：" + wei[i]);
	  }
	  for (int i = 0; i < length / 2; i++) {
    	  sumOdd += wei[2 * i];
    	  if ((wei[2 * i + 1] * 2) > 9)
    		  wei[2 * i + 1] = wei[2 * i + 1] * 2 - 9;
    	  else
    		  wei[2 * i + 1] *= 2;
    	  sumEven += wei[2 * i + 1];
	  }
	  System.out.println("奇数位的和是：" + sumOdd);
	  System.out.println("偶数位的和是：" + sumEven);
	  if ((sumOdd + sumEven) % 10 == 0)
	  {
       	  System.out.println("Recept.");
       	  return true;
	  }

	  else
	  {
    	  System.out.println("Can not recept.");
    	  return false; 
	  }
    }
    
    //BSS接口调用需要使用13位的流水号
    public static String generateBSSLogId(String payType) {
//    	String idType = "2";
    	long time =  System.currentTimeMillis();
    	Random r = new Random();
    	int rint = r.nextInt(99);
    	String rStr = StringUtil.paddingLeft(String.valueOf(rint), '0', 2);
    	//return payType + rStr + time;
    	String strlogid=String.valueOf(time);
    	return strlogid;
    }    
}
