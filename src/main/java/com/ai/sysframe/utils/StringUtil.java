package com.ai.sysframe.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StringUtil
 * @Description: 字符串操作工具类
 * @author linyl linyuliang.85@gmail.com
 */
public class StringUtil {
//    /**
//     * @Title: fillChar
//     * @Description: 字符串右边用指定字符补齐
//     * @param targetStr 需要补齐的字符串
//     * @param strLength 字符串需要的长度
//     * @param fillchar 用来补齐的字符，可以是空格
//     * @return String 返回补齐后的字符串
//     * @throws BaseException 字符串编码错误异常
//     */
//    public static String fillChar(final String targetStr, final int strLength, final char fillchar) throws BaseException {
//        String dealedStr = "";
//        int curLength = 0;
//        int cutLength = 0;
//        final StringBuffer newString = new StringBuffer();
//        try {
//            if (targetStr != null) {
//                curLength = targetStr.getBytes(BaseConstant.CHARSET).length;
//                if (curLength > strLength) {
//                    dealedStr = targetStr.substring(0, strLength);
//                }
//            }
//            cutLength = strLength - dealedStr.getBytes(BaseConstant.CHARSET).length;
//        } catch (final UnsupportedEncodingException e) {
//            throw new BaseException("36", e, new String[] { BaseConstant.CHARSET });
//        }
//        for (int i = 0; i < cutLength; i = i + 1) {
//            newString.append(fillchar);
//        }
//        return dealedStr + newString;
//    }

    /**
     * @Title: stringsToMapList
     * @Description: 将字符串数组转换成指定key的Map的List
     * @param strs 字符串数组
     * @param mapKey 字符串在map中的key名称
     * @return List<Object> 返回类型
     */
    public static List<Object> strs2MapList(final String[] strs, final String mapKey) {
        final List<Object> list = new ArrayList<Object>();
        for (final String record : strs) {
            list.add(new LinkedHashMap<String, Object>().put(mapKey, record));
        }
        return list;
    }
    
    public static Map<String, String> params2Map(String inputParams)  {
    	Map<String, String> map = new HashMap();
    	try {
			inputParams = URLDecoder.decode(inputParams, "UTF8");
		
	        if(inputParams != null ) {
	        	String tmp[] = inputParams.split("&");
	        	for(String keyValStr : tmp) {
	        		String kv[] = keyValStr.split("=");
	        		if(kv.length == 2) {
	        			if(kv[0].endsWith("[]")) {
	        				kv[0] = kv[0].substring(0, kv[0].length()-2);
	        				kv[1] = URLDecoder.decode(kv[1], "UTF8");
	        			}
	        			map.put(kv[0], kv[1]);
	        		} else if(kv.length == 1) {
	        			map.put(kv[0], "");
	        		}
	        	}
	        }
    	} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return map;
    }

    // 根据bit值，获取bit位随机数
    public static String getRandomNum(final int bit) {
        String tmp = "";
        for (int i = 0; i < bit; i++) {
            final int j = (int) Math.round(Math.random() * 5);
            tmp = tmp + Integer.toString(j);
        }
        return tmp;
    }

    /**
     * 还原到大写下划线，将标识采用Camel标记法. 首字母小写,后面每个单词大写字母开头
     * @param src
     * @return
     * @date 2009-1-22
     * @author tz
     */
    public static String unCamelize(final String src) {
        String the = new String(src);
        for (char i = 'A'; i < 'Z'; ++i) {
            the = the.replaceAll(String.valueOf(i), "_" + String.valueOf(i));
        }

        return the.toUpperCase();
    }

    /**
     * 将标识采用Camel标记法. 首字母小写,后面每个单词大写字母开头
     * @param source
     * @return
     * @author tz
     */
    public static String camelize(final String source) {
    	
    	if(source.indexOf('_') == -1) {
    		return source;
    	}

        String the = new String(source);
        the = the.toLowerCase();

        final StringBuffer result = new StringBuffer();

        final String[] theArray = the.split("_");
        result.append(theArray[0]);

        for (int i = 1; i < theArray.length; i++) {
            result.append(Character.toUpperCase(theArray[i].charAt(0)) + theArray[i].substring(1));
        }

        return result.toString();
    }
    
    /**
     * 
     * @Title: toUtf8String
     * @Description: 解决输出文件名中的中文乱码 问题
     * @param 文件名称
     * @return 转码后的文件名称
     */
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    
    public static String paddingLeft(String src, char c, int len) {
    	if(src == null ) {
    		src = "";
    	}
    	
    	if(src.length() < len) {
    		do {
    			src = c + src;
    		} while(src.length() < len);
    	}
    	return src;
    }
}
