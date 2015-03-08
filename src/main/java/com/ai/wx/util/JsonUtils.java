package com.ai.wx.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * json处理工具类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class JsonUtils {
    
    private static Logger log = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * Jackson方式实现Json-Bean之间的转换
     */
    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();

    /** 错误信息 */
    private static final String FAIL_MSG_1 = "Json串转对象失败！";

    /** 错误信息 */
    private static final String FAIL_MSG_2 = "对象转json失败！";

    /**
     * Description: 对象列表转json字符串
     * 
     * @param list 对象列表
     * @return json字符串
     * */
    public static <T> String convertObjectListToString(List<T> list) {
        if(CollectionUtils.isEmpty(list)){
            return "list is null";
        }
        return convertObjectToString(list);
    }

    /**
     * json转集合<br>
     * 此方法根据Json串和集合泛型类型，逐个解析每个对象，最终返回集合
     * 
     * @param jsonString Json字符串
     * @param classOfT 集合的泛型类型
     * @return List<T> 目标类型的集合
     */
    public static <T> List<T> parseJson2List(String jsonString, Class<T> tClazz) {
        List<T> t = null;
        try {
            List<Object> jStrList;
            jStrList = JACKSON_MAPPER.readValue(jsonString, new TypeReference<List<Object>>() {
            });
            // 当缓存的Json列表非空时，要逐个解析Json的list，转换为入参传入的tClazz类型
            if (!CollectionUtils.isEmpty(jStrList)) {
                t = new ArrayList<T>();
                for (Object jStr : jStrList) {
                    t.add(JACKSON_MAPPER.readValue(JACKSON_MAPPER.writeValueAsString(jStr), tClazz));
                }
            }
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (JsonGenerationException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        }
        return t;
    }

    /**
     * Description: json字符串转对象列表
     * 
     * @param jsonstr json字符串
     * @param classType 对象类型
     * @return 对象列表
     * */
    public static <T> List<T> convertStringToObjectList(String jsonstr, Class<T> classType) {

        List<T> t = null;
        try {
            List<Object> jStrList = JACKSON_MAPPER.readValue(jsonstr, new TypeReference<List<Object>>() {
            });
            // 当缓存的Json列表非空时，要逐个解析Json的list，转换为入参传入的tClazz类型
            if (!CollectionUtils.isEmpty(jStrList)) {
                t = new ArrayList<T>();
                for (Object jStr : jStrList) {
                    t.add(JACKSON_MAPPER.readValue(JACKSON_MAPPER.writeValueAsString(jStr), classType));
                }
            }
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonstr, e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonstr, e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonstr, e);
        }
        return t;
    }

    /**
     * json转对象<br>
     * 若需要转换为List，请调用parseJsonToList方法
     * 
     * @param jsonString
     * @param classOfT
     * @return T
     */
    public static <T> T parseJson(String jsonString, Class<T> classOfT) {
        T t = null;
        try {
            t = JACKSON_MAPPER.readValue(jsonString, classOfT);
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        }
        return t;
    }

    /**
     * Description: json字符串转对象
     * 
     * @param jsonstr json字符串
     * @param classType 对象类型
     * @return json 字符串
     * */
    public static <T> T convertStringToObject(String jsonstr, Class<T> classType) {

        if (StringUtils.isEmpty(jsonstr)) {
            throw new IllegalArgumentException("json字符串不能为空");
        } else {
            T t = null;
            try {
                t = JACKSON_MAPPER.readValue(jsonstr, classType);
            } catch (JsonParseException e) {
                // 异常时，记录日志，不中断程序
                log.error(FAIL_MSG_1 + jsonstr, e);
            } catch (JsonMappingException e) {
                // 异常时，记录日志，不中断程序
                log.error(FAIL_MSG_1 + jsonstr, e);
            } catch (IOException e) {
                // 异常时，记录日志，不中断程序
                log.error(FAIL_MSG_1 + jsonstr, e);
            }

            return t;
        }
    }

    /**
     * json转集合<br>
     * 此方法支持简单对象转化的同时，支持集合类对象的Json转换功能
     * 
     * @param jsonString 待转换的Json字符串
     * @param typeOfT 需要转换的目标对象类型
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String jsonString, TypeReference<T> typeOfT) {
        T t = null;
        try {
            t = (T) JACKSON_MAPPER.readValue(jsonString, typeOfT);
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_1 + jsonString, e);
        }

        return t;
    }

    /**
     * 对象转json串
     * 
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        StringWriter w = new StringWriter();
        String jsonValue = null;
        try {
            JACKSON_MAPPER.writeValue(w, obj);
            jsonValue = w.toString();
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_2 + obj.toString(), e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_2 + obj.toString(), e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error(FAIL_MSG_2 + obj.toString(), e);
        }
        return jsonValue;
    }

    /**
     * Description: 对象转json字符串
     * 
     * @param obj 对象实例
     * @return jsonValue 字符串
     * */
    public static String convertObjectToString(Object obj) {
        StringWriter w = new StringWriter();
        String jsonValue = null;
        try {
            JACKSON_MAPPER.writeValue(w, obj);
            jsonValue = w.toString();
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error("对象转Json失败！", e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error("对象转Json失败！", e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error("对象转Json失败！", e);
        }
        return jsonValue;
    }

    /**
     * 字符串转成对象列表
     * 
     * @param jsonStr
     * @param 传入指定类型
     * @return
     */
    public static <T> List<T> str2list(String jsonStr, Class<T> cls) {
        List<T> objList = null;
        try {
            JavaType t = JACKSON_MAPPER.getTypeFactory().constructParametricType(List.class, cls);
            objList = JACKSON_MAPPER.readValue(jsonStr, t);
        } catch (JsonParseException e) {
            // 异常时，记录日志，不中断程序
            log.error("字符串转成对象列表失败！", e);
        } catch (JsonMappingException e) {
            // 异常时，记录日志，不中断程序
            log.error("字符串转成对象列表失败！", e);
        } catch (IOException e) {
            // 异常时，记录日志，不中断程序
            log.error("字符串转成对象列表失败！", e);
        }
        return objList;
    }

    /**
     * 集合转json串<br>
     * 此方法可使用toJson(Object obj)方法替代
     * 
     * @param list
     * @return String
     */
    public static <T> String toJsonArray(List<T> list) {
        return toJson(list);
    }
}
