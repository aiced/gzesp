package com.ai.sysframe.utils;

import java.util.Map;
import java.util.ResourceBundle;

import com.google.common.collect.Maps;

/**
 * 全局配置类
 * @author ThinkGem
 * @version 2013-03-23
 */
public class GlobalUtil {
    
    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();
    
    /**
     * 属性文件加载对象
     */
    private static ResourceBundle resource = ResourceBundle.getBundle("application");
    
    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null){
            value = resource.getString(key);
            map.put(key, value);
        }
        return value;
    }

    /////////////////////////////////////////////////////////
    
    /**
     * 获取校验配置
     */
    public static String getAuthConfig() {
        return getConfig("authConfig");
    }    
}