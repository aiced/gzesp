package com.ai.sysframe.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: RegexHelper
* @Description: java正则表达式工具类
* @author linyl linyuliang.85@gmail.com
*/
public class RegexUtil {

    /**
    * @Title: isMatch
    * @Description: 检查字符串是否匹配正则表达式
    * @param value 需要判断的字符串
    * @param regex 判断使用的正则表达式
    * @return boolean    返回类型
    */
    public static boolean isMatch(final String value, final String regex) {
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(value);
        return m.find();
    }
    
    /**
     *  cms pre fee rule
     * @param elementString
     * @return
     */
    public static String[] getCMSRule(String elementString) {
    	String[] result = null;
        Pattern p = Pattern.compile("=MUL\\(([\\S]*),([0-9.]*)\\)");
        Matcher m = p.matcher(elementString);
        if (m.find()) {
        	result = new String[2];
        	result[0] = m.group(1);
        	result[1] = m.group(2);
        }
        return result;
    }
    
    /**
     *  money
     * @param elementString
     * @return
     */
    public static String getMoney(String elementString) {
    	Pattern p = Pattern.compile("([0-9]*)");
    	Matcher m = p.matcher(elementString);
    	if (m.find()) {
    		return m.group();
    	}
    	return "";
    }
}
