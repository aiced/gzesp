package com.ai.sysframe.utils.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: hongbing.zhang Date: 11-5-30 Time: 下午4:22 To
 * change this template use File | Settings | File Templates.
 */
/**
* @ClassName: WeekCnEnum
* @Description: 星期枚举类
* @author linyl linyuliang.85@gmail.com
*/
public enum WeekCnEnum {
    /**
    * @Fields MON : TODO(用一句话描述这个变量表示什么)
    */
    MON("2", "星期一"), /**
    * @Fields TUE : TODO(用一句话描述这个变量表示什么)
    */
    TUE("3", "星期二"), /**
    * @Fields WED : TODO(用一句话描述这个变量表示什么)
    */
    WED("4", "星期三"), /**
    * @Fields THU : TODO(用一句话描述这个变量表示什么)
    */
    THU("5", "星期四"), /**
    * @Fields FRI : TODO(用一句话描述这个变量表示什么)
    */
    FRI("6", "星期五"), /**
    * @Fields SAT : TODO(用一句话描述这个变量表示什么)
    */
    SAT("7", "星期六"), /**
    * @Fields SUN : TODO(用一句话描述这个变量表示什么)
    */
    SUN("1", "星期日");
    /**
    * @Fields value : 值
    */
    private String value;
    /**
    * @Fields key : key
    */
    private String key;

    /**
    * <p>Title: 构造函数</p>
    * <p>Description: 无参默认 </p>
    */
    WeekCnEnum() {
    }

    /**
    * <p>Title: </p>
    * <p>Description: </p>
    * @param key 第几天
    * @param value 星期几
    */
    WeekCnEnum(final String key, final String value) {
        this.value = value;
        this.key = key;
    }

    /**
    * @Title: getValue
    * @Description: 获取星期几
    * @return 星期几
    */
    public String getValue() {
        return value;
    }

    /**
    * @Title: setValue
    * @Description: 设置星期几
    * @param value 星期几
    */
    public void setValue(final String value) {
        this.value = value;
    }

    /**
    * @Title: getKey
    * @Description: 获取key，数字字符串
    * @return 星期的第几天
    */
    public String getKey() {
        return key;
    }

    /**
    * @Title: setKey
    * @Description: 设置key
    * @param key key
    */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
    * @Title: getVal
    * @Description: 根据星期的数字，获取星期的中文输出
    * @param key 星期的数字
    * @return 星期的中文输出
    */
    public static String getVal(final String key) {
        String result = null;
        for (final WeekCnEnum c : WeekCnEnum.values()) {
            if (c.getKey().equals(key)) {
                result = c.getValue();
                break;
            }
        }
        return result;
    }

    /**
    * @Title: getKeyVal
    * @Description: 根据值，获取key
    * @param value 星期几
    * @return 星期的int值，从星期天 为1开始
    */
    public static Integer getKeyVal(final String value) {
        Integer result = 0;
        for (final WeekCnEnum c : WeekCnEnum.values()) {
            if (c.getValue().equals(value)) {
                result = Integer.valueOf(c.getKey());
                break;
            }
        }
        return result;
    }

    /**
    * @Title: getCategories
    * @Description: 返回星期的Map
    * @return 第几天，星期几 类似的Map
    */
    public static Map<String, String> getCategories() {
        final Map<String, String> map = new HashMap<String, String>();
        for (final WeekCnEnum c : WeekCnEnum.values()) {
            map.put(c.getKey(), c.getValue());
        }
        return map;
    }
}
