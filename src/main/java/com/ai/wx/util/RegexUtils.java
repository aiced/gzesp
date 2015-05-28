package com.ai.wx.util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.ai.wx.consts.DataConstants;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 正则表达式解析xml报文工具类<br>
 * 
 * @author 14040909
 */
public class RegexUtils {

    
    /**
     * 右括号
     */
    public static final String RIGHT_BRACE = ">";

    /**
     * 在给定的元素中搜索指定的元素,返回符合条件的元素数组.对于不同级别的同名元素限制作用,即可以 搜索元素A中的子元素C.而对于元素B中子元素C则过虑,通过多级限定可以准确定位.
     * 
     * @param parentElementString String
     * @param tagName String
     * @return String[]
     */
    public static String[] getElementsByTag(String parentElementString, String tagName) {
        Pattern p = Pattern.compile("<" + tagName + "[^>]*?((>.*?</" + tagName + ">)|(/>))");
        Matcher m = p.matcher(parentElementString);
        List<String> al = new ArrayList<String>();
        while (m.find()) {
            al.add(m.group());
        }
        String[] arr = al.toArray(new String[al.size()]);
        al.clear();
        return arr;
    }

    /**
     * 从指定的父元素中根据xpath模式获取子元素,singlePath以#为分隔符 如 ROOT#PARENT#CHILD表示提取ROOT元素下的PARENT元素下的CHILD元素
     * 
     * @param parentElementString String
     * @param singlePath String
     * @return String
     */
    public static String getElementBySinglePath(String parentElementString, String singlePath) {

        String[] path = singlePath.split("#");
        String lastTag = path[path.length - 1];
        String tmp = "(<" + lastTag + "[^>]*?((>.*?</" + lastTag + ">)|(/>)))";
        // 最后一个元素,可能是<x>v</x>形式或<x/>形式
        for (int i = path.length - DataConstants.TWO; i >= 0; i--) {
            lastTag = path[i];
            tmp = "<" + lastTag + ".*>.*" + tmp + ".*</" + lastTag + RIGHT_BRACE;
        }
        Pattern p = Pattern.compile(tmp);

        // 替换报文里的空白字符,回车,换行,tab
        Pattern pat = Pattern.compile("\n|\r|\t");
        Matcher mat = pat.matcher(parentElementString);
        Matcher m = p.matcher(mat.replaceAll(""));
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * 获取指定元素的文本内容
     * 
     * @param elementString String
     * @return String
     */
    public static String getElementText(String elementString) {
        Pattern p = Pattern.compile(">([^<>]*)<");
        Matcher m = p.matcher(elementString);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * 在给定的元素中获取指定属性的值.该元素应该从getElementsByTag方法中获取
     * 
     * @param elementString String
     * @param attributeName String
     * @return String
     */
    public static String getAttribute(String elementString, String attributeName) {
        Pattern p = Pattern.compile("<[^>]+>");
        Matcher m = p.matcher(elementString);
        String tmp = m.find() ? m.group() : "";
        p = Pattern.compile("(\\w+)\\s*=\\s*\"([^\"]+)\"");
        m = p.matcher(tmp);
        while (m.find()) {
            if (m.group(1).trim().equals(attributeName)) {
                return m.group(DataConstants.TWO).trim();
            }
        }
        return "";
    }

    /**
     * 功能描述: 报文中相同节点解析成数组
     * 
     * @param tagName
     * @param xmlString
     */
    public static String[] getElementsByTagForXml(String tagName, String xmlString) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("<").append(tagName).append(RIGHT_BRACE).append("((?s:.)*?)").append("</").append(tagName)
                .append(RIGHT_BRACE);
        Pattern p = Pattern.compile(sbf.toString());
        Matcher m = p.matcher(xmlString);
        List<String> al = new ArrayList<String>();
        while (m.find()) {
            if (!StringUtils.isBlank(m.group(1))) {
                al.add(m.group(0));
            }
        }
        String[] arr = al.toArray(new String[al.size()]);
        al.clear();
        return arr;
    }

    /**
     * 
     * 通过正则表达式匹配得到xml字符串中的节点值 <br>
     * 
     * @param msg xml格式请求字符串
     * @param paramKey 节点名称
     * @return 根据paramKey通过正则表达式得到的节点值
     */
    public static String matchStr(String msg, String paramKey) {

        String paramStr = "";

        StringBuffer sbf = new StringBuffer(DataConstants.FIFTY);
        sbf.append("<").append(paramKey).append(RIGHT_BRACE).append("(.*?)").append("</").append(paramKey)
                .append(RIGHT_BRACE);
        Pattern pattern = Pattern.compile(sbf.toString());

        Matcher matcher = pattern.matcher(msg);

        if (matcher.find()) {
            paramStr = matcher.group(1);
        }

        return paramStr;
    }

    /**
     * 功能描述: xml报文转换成对应的bean<br>
     * 〈功能详细描述〉
     * 
     * @param xml
     * @param fields
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ParseException
     */
    public static <T> T xml2bean(String xml, Field[] fields, Class<T> clazz) throws InstantiationException,
            IllegalAccessException, ParseException {

        // xml需要 转换成的 请求 bean
        T req = clazz.newInstance();

        XStreamAlias xsa = null;
        // 每个field的注解
        String anno = null;
        String attrXml = null;

        for (Field field : fields) {
            // 判断如果是private static final，不用set值
            if (DataConstants.TWENTY_SIX == field.getModifiers()) {
                continue;
            }
            // 可以修改private
            field.setAccessible(true);
            xsa = field.getAnnotation(XStreamAlias.class);
            if(xsa != null) {
            	anno = xsa.value();
            } else {
            	anno = field.getName();
            }
            // 根据注解value获取xml里的节点内容
            attrXml = RegexUtils.getElementBySinglePath(xml, anno);
            attrXml = XmlUtils.deleteCdataTag(attrXml);

            String date = "java.util.Date";
            String time = "java.sql.Time";
            if (field.getType().getName().equals(date)) {
                field.set(req, DateUtils.parseDate(RegexUtils.getElementText(attrXml).trim()));
            } else if (field.getType().getName().equals(time)) {
                field.set(req, DateUtils.parseTime4Sql(RegexUtils.getElementText(attrXml).trim()));
            } else if (field.getType().getSimpleName().equals("long")) {
            	field.set(req, Long.parseLong((RegexUtils.getElementText(attrXml).trim())));
            } else {
                field.set(req, RegexUtils.getElementText(attrXml).trim());
            }

        }

        return req;
    }

    /**
     * 
     * 功能描述: 去空格、回车、tab
     */
    public static String getStringNoBlank(String str) {
        if (str != null && !"".equals(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            return m.replaceAll("");
        } else {
            return str;
        }
    }
    
    public static boolean isAndroidWeiXin(String userAgent) {
    	 if (userAgent != null && !"".equals(userAgent)) {
    		 Pattern p = Pattern.compile(".*(Android).*(MicroMessenger)");
//             Pattern p = Pattern.compile(".*(Android).*(HUAWEI).*(MicroMessenger)");
             Matcher m = p.matcher(userAgent);
             return m.find();
         } else {
             return false;
         }
    }

}
