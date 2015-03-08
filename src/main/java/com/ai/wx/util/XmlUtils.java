package com.ai.wx.util;

import java.io.Writer;
import java.lang.reflect.Field;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ai.wx.consts.XStreamIgnoreCDATA;
import com.ai.wx.entity.response.Article;
import com.ai.wx.entity.response.ResponseMusicMessage;
import com.ai.wx.entity.response.ResponseNewsMessage;
import com.ai.wx.entity.response.ResponseTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
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
//            return new PrettyPrintWriter(out) {
//                // 对所有xml节点的转换都增加CDATA标记
//                boolean cdata = true;
//
//                @SuppressWarnings("unchecked")
//                public void startNode(String name, Class clazz) {
//                    super.startNode(name, clazz);
//                }
//
//                protected void writeText(QuickWriter writer, String text) {
//                    if (cdata) {
//                        writer.write("<![CDATA[");
//                        writer.write(text);
//                        writer.write("]]>");
//                    } else {
//                        writer.write(text);
//                    }
//                }
//            };
        	return new PrettyPrintWriter(out) {
                boolean ignoreCdata = false;
                Class<?> targetClass = null;
                @Override
                public void startNode(String name,
                    @SuppressWarnings("rawtypes") Class clazz) {
                  super.startNode(name, clazz);
                  //业务处理，对于用XStreamCDATA标记的Field，需要加上CDATA标签
                  if(!name.equals("xml")){
                	  ignoreCdata = ignoreCDATA(targetClass, name);
                  }else{
                    targetClass = clazz;
                  }
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                  if (ignoreCdata) {
                	  writer.write(text);
                  } else {
                	  writer.write("<![CDATA[");
	                  writer.write(text);
	                  writer.write("]]>");
                    
                  }
                }
              };
        }
    }); 
    
    private static boolean ignoreCDATA(Class<?> targetClass, String fieldAlias){
        boolean cdata = false;
        //first, scan self
        cdata = existsIgnoreTag(targetClass, fieldAlias);
        if(cdata) return cdata;
        //if cdata is false, scan supperClass until java.lang.Object
        Class<?> superClass = targetClass.getSuperclass();
        while(!superClass.equals(Object.class)){
          cdata = existsIgnoreTag(superClass, fieldAlias);
          if(cdata) return cdata;
          superClass = superClass.getClass().getSuperclass();
        }
        return false;
      }
    
    private static boolean existsIgnoreTag(Class<?> clazz, String fieldAlias){
        //scan fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          //1. exists XStreamCDATA
          if(field.getAnnotation(XStreamIgnoreCDATA.class) != null ){
            XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
            //2. exists XStreamAlias
            if(null != xStreamAlias){
              if(fieldAlias.equals(xStreamAlias.value()))//matched
                return true;
            }else{// not exists XStreamAlias
              if(fieldAlias.equals(field.getName()))
                return true;
            }
          }
        }
        return false;
      }

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
    
    /**
     * @Title: deleteCdataTag
     * @Description: 删除XML中的CDATA标签"<![CDATA[" "]]>"
     * @param xml 需要删除CDATA标签的xml
     * @return String 删除CDATA标签后的xml  "<!\\[CDATA\\[([^\\]]+)\\]\\]>"
     */
     public static String deleteCdataTag(final String xml) {
         final Pattern p = Pattern.compile("<!\\[CDATA\\[([\\s\\S]*?)\\]\\]>");
//         String result = xml;
//         final Matcher m = p.matcher(result);
//         while (m.find()) {
//             result = result.replace(m.group(0), m.group(1));
////             for(int i=0;i<m.groupCount();i++)
////             {
////                 result = result.replace(m.group(i), m.group(i).substring(9, m.group(i).length()-3));
////             }
//             //result = result.replace(m.group(0), m.group(1));
//             //m = p.matcher(result);
//         }
//         return result;
 		StringBuffer result = new StringBuffer(xml);
 		final Matcher m = p.matcher(xml);
 		while (m.find()) {
 			String group0 = m.group(0);
 			String group1 = m.group(1);
 			replace(result, group0, group1);
 		}
 		return result.toString();
     }
     /**
      * @Title: deleteBodyVersionHead
      * @Description: 删除XML文档中的文档头，例如"<?xml version= "1.0 " encoding= "UTF-8 "?>"
      * @param xml 需要删除CDATA标签的xml
      * @return String 删除CDATA标签后的xml
      */
      public static String deleteBodyVersionHead(final String xml) {
          //return xml.replaceAll("<\\?xml[^\\?]+\\?>", "");
          
  		final Pattern p = Pattern.compile("<\\?xml[^\\?]+\\?>");
  		StringBuffer result = new StringBuffer(xml);
  		final Matcher m = p.matcher(xml);
  		while (m.find()) {
  			String group0 = m.group(0);
  			replace(result, group0, "");
  		}
  		return result.toString();
      }
      /*
       * public static String xPathSearch(String input, String expression) throws Exception {
       * XPath xPath = XPathFactory.newInstance().newXPath();
       * XPathExpression xPathExpression = xPath.compile(expression);
       * Document document = documentBuilder.parse(new ByteArrayInputStream(input.getBytes("UTF-8")));
       * return (String) xPathExpression.evaluate(document, XPathConstants.STRING);
       * }
       */
      public static StringBuffer replace(StringBuffer sb, String oldStr, String newStr) {

  		int i = sb.indexOf(oldStr);
  		int oldLen = oldStr.length();
  		if (i > -1) {
  			sb.delete(i, i + oldLen);
  			sb.insert(i, newStr);
  		}
  		return sb;
  	}

}