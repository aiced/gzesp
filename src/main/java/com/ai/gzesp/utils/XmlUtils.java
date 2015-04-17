package com.ai.gzesp.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TimeZone;

import com.ai.gzesp.unionpay.MyMapConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;


/**
 * xstream转换xml和bean工具<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class XmlUtils {
    //因为请求和响应报文头结点不一样，map转换xml 和 xml转map 要区分
    public static final XStream XSTREAMREQ = new XStream(); //请求
    public static final XStream XSTREAMRSP = new XStream(); //响应

    private static final String CHINA_TIME_ZONE = "Asia/Shanghai";

    static {
        // 时区处理
        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE);
        XSTREAMREQ.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
        XSTREAMREQ.registerConverter(new MyMapConverter());  //自定义map转换器   
        //XSTREAM.registerConverter(new MyDateConverter(), XStream.PRIORITY_VERY_HIGH);
        //XSTREAM.registerConverter(new MyTimeConverter(), XStream.PRIORITY_VERY_HIGH);
        XSTREAMREQ.autodetectAnnotations(true);
        //XSTREAMREQ.alias("requestData", LinkedHashMap.class);
        XSTREAMREQ.alias("responseData", LinkedHashMap.class); //本机测试用
        
        XSTREAMRSP.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
        XSTREAMRSP.registerConverter(new MyMapConverter());  //自定义map转换器   
        XSTREAMRSP.autodetectAnnotations(true);        
        XSTREAMRSP.alias("responseData", HashMap.class);
        //XSTREAMRSP.alias("requestData", HashMap.class); //本机测试用
    }

    /**
     * 别名设值 适用请求报文
     * 
     * @param name
     * @param type
     */
    @SuppressWarnings("rawtypes")
    public static void aliasReq(String name, Class type) {
        XSTREAMREQ.alias(name, type);
    }
    
    /**
     * 别名设值 适用响应报文
     * 
     * @param name
     * @param type
     */
    @SuppressWarnings("rawtypes")
    public static void aliasRsp(String name, Class type) {
        XSTREAMRSP.alias(name, type);
    }

    /**
     * xml报文转对象 适用响应xml报文转map
     * 
     * @param xml
     * @return Object
     */
    public static Object fromXML(String xml) {
        return XSTREAMRSP.fromXML(xml);
    }

    /**
     * 对象转xml报文 适用请求map对象转xml
     * 
     * @param obj
     * @return String
     */
    public static String toXML(Object obj) {
        return XSTREAMREQ.toXML(obj);
    }

}