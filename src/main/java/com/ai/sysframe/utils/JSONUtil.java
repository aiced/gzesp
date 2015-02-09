package com.ai.sysframe.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.sysframe.exception.BaseException;
import com.ai.sysframe.json.PropertyStrategyWrapper;

/**
 * @ClassName: JSONUtil
 * @Description: json操作工具类
 * @author sunjl
 */
public class JSONUtil {

    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);

    /**
     * @Title: getStringFromJSONObject
     * @Description: 从json获取指定key的字符串
     * @param jsonObject json对象
     * @param key 字符串的key
     * @return 指定key的字符串值
     */
    public static String getStringFromJSONObject(final JSONObject jsonObject, final String key) {
        try {
            return jsonObject.getString(key);
        } catch (final JSONException e) {
            throw new BaseException("47", e, new Object[] { jsonObject, key });
        }
    }

    /**
     * @Title: toBean
     * @Description: 将json字符串，转换成指定java bean
     * @param jsonStr json串对象
     * @param beanClass 指定的bean
     * @return 转换后的java bean对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBean(String jsonStr, Class<T> beanClass) {
        net.sf.json.JSONObject jo = net.sf.json.JSONObject.fromObject(jsonStr);
        JsonConfig cfg = new JsonConfig();
        cfg.setPropertySetStrategy(new PropertyStrategyWrapper(PropertySetStrategy.DEFAULT));
        cfg.setRootClass(beanClass);
        return (T) net.sf.json.JSONObject.toBean(jo, cfg);
    }

    /**
     * @author sunjl
     * @Description:将一个 JavaBean对象转化为一个 Map
     * @param javaBean 要转化的JavaBean对象
     * @return Map 转化出来的 Map对象
     */
    public static Map<String, String> javaBeanToMap(Object javaBean) {
        Map<String, String> result = new HashMap<String, String>();
        Method[] methods = javaBean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    result.put(propertyToField(field), null == value ? "" : value.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @author sunjl
     * @Description:将map转换成Javabean
     * @param javabean javaBean
     * @param data map数据
     */
    public static Object mapToJavaBean(Object javabean, Map<String, String> data) {
        Method[] methods = javabean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("set")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(javabean, new Object[] { data.get(propertyToField(field)) });
                }
            } catch (Exception e) {
            }
        }

        return javabean;
    }

    /**
     * 对象属性转换为字段 例如：userName to USER_NAME
     * @param property 字段名
     * @return
     */
    public static String propertyToField(String property) {
        if (null == property) {
            return "";
        }
        char[] chars = property.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (CharUtils.isAsciiAlphaUpper(c)) {
                sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
            } else {
                sb.append(c);
            }
        }
        return StringUtils.upperCase(sb.toString());
    }

    /**
     * 将标识采用Camel标记法. 首字母小写,后面每个单词大写字母开头
     * @param source
     * @return
     * @author sunjl
     */
    public static String camelize(String source) {

        String the = new String(source);
        the = the.toLowerCase();
        StringBuffer result = new StringBuffer();
        String[] theArray = the.split("_");
        result.append(theArray[0]);

        for (int i = 1; i < theArray.length; i++) {
            result.append(Character.toUpperCase(theArray[i].charAt(0)) + theArray[i].substring(1));
        }
        return result.toString();
    }

    /**
     * 过滤map中value为空的数据，生成新map，同时key是采用Camel标记法，如：map.put("userName","123")
     * @param source
     * @return
     * @author sunjl
     */
    public static Map<String, Object> filterMap(Map<String, Object> map) {
        Iterator it = map.keySet().iterator();
        Map<String, Object> newMap = new HashMap<String, Object>();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (!"".equals(map.get(key))) {
                newMap.put(camelize(key), map.get(key));
            }
        }
        return newMap;
    }
    
    public static JSONArray fromObjectWithConf(Object object,String[] excludes) 
    {
        JsonConfig conf = new JsonConfig(); 
        conf.setExcludes(excludes); 
        return JSONArray.fromObject(object,conf);
    } 
}
