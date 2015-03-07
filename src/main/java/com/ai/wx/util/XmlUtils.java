package com.ai.wx.util;

import java.io.Writer;
import java.util.TimeZone;

import com.ai.wx.entity.response.Article;
import com.ai.wx.entity.response.ResponseMusicMessage;
import com.ai.wx.entity.response.ResponseNewsMessage;
import com.ai.wx.entity.response.ResponseTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * xml 工具类 <br>
 * 〈功能详细描述〉
 * 
 * @author 14040909
 */
public class XmlUtils {

    //public static final XStream XSTREAM = new XStream();

    /**
     * 扩展xstream，使其支持CDATA块, 需要xpp3 jar
     */
    private static XStream XSTREAM = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });    

    private static final String CHINA_TIME_ZONE = "Asia/Shanghai";

    static {
        // 时区处理
        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE);
        XSTREAM.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
        // XSTREAM.registerConverter(new MyDateConverter(), XStream.PRIORITY_VERY_HIGH);
        // XSTREAM.registerConverter(new MyTimeConverter(), XStream.PRIORITY_VERY_HIGH);
        XSTREAM.autodetectAnnotations(true);
    }

    /**
     * 别名设值
     * 
     * @param name
     * @param type
     */
    @SuppressWarnings("rawtypes")
    public static void alias(String name, Class type) {
        XSTREAM.alias(name, type);
    }

    /**
     * 报文转对象
     * 
     * @param xml
     * @return Object
     */
    public static Object fromXML(String xml) {
        return XSTREAM.fromXML(xml);
    }

    /**
     * 对象转报文
     * 
     * @param obj
     * @return String
     */
    public static String toXML(Object obj) {
        return XSTREAM.toXML(obj);
    }
    
    /** 
     * 文本消息对象转换成xml 
     *  
     * @param textMessage 文本消息对象 
     * @return xml 
     */  
    public static String textMessageToXml(ResponseTextMessage textMessage) {  
        XSTREAM.alias("xml", textMessage.getClass());  
        return toXML(textMessage);  
    }  
      
    /** 
     * 音乐消息对象转换成xml 
     *  
     * @param musicMessage 音乐消息对象 
     * @return xml 
     */  
    public static String musicMessageToXml(ResponseMusicMessage musicMessage) {  
        XSTREAM.alias("xml", musicMessage.getClass());  
        return toXML(musicMessage);  
    }  
      
    /** 
     * 图文消息对象转换成xml 
     *  
     * @param newsMessage 图文消息对象 
     * @return xml 
     */  
    public static String newsMessageToXml(ResponseNewsMessage newsMessage) {  
        XSTREAM.alias("xml", newsMessage.getClass());  
        XSTREAM.alias("item", new Article().getClass());  
        return toXML(newsMessage);  
    }  


}