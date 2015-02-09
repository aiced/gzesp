package com.ai.sysframe.utils;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.ai.sysframe.exception.BaseException;

/**
* @ClassName: XmlUtils
* @Description: xml相关的操作工具类
* @author linyl linyuliang.85@gmail.com
*/
public class XmlUtil {
    /**
     * @Title: stringToDoc
     * @Description: 转 XML 到 org.dom4j.Document
     * @param xmlStr 需要转换的xml字符串
     * @param charset xml字符串的原编码
     * @return Document xml的Dom对象
     * @throws BaseException 系统内部异常1,2,3,4
     */
    public static Document stringToDoc(final String xmlStr, final String charset) throws BaseException {
        // 字符串转XML
        //Document doc = null;

        // try {
        String xml = null;
        try {
            xml = new String(xmlStr.getBytes(charset), charset);
        } catch (final UnsupportedEncodingException e) {
            throw new BaseException("1", e, new Object[] { charset });
        }
        final StringReader sr = new StringReader(xml);
        final InputSource is = new InputSource(sr);
        final SAXReader saxReader = new SAXReader();
        try {
            final Document document = saxReader.read(is);
            return document;
        } catch (final DocumentException e) {
            throw new BaseException("3", e, new Object[] { xmlStr });
        }
        /*
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (final ParserConfigurationException e) {
            throw new BaseException("2", e);
        }
        try {
            doc = builder.parse(is);
        } catch (final SAXException e) {
            throw new BaseException("3", e, new Object[] { xmlStr });
        } catch (final IOException e) {
            throw new BaseException("4", e);
        }
        */

    }

    /**
    * @Title: deleteCdataTag
    * @Description: 删除XML中的CDATA标签"<![CDATA[" "]]>"
    * @param xml 需要删除CDATA标签的xml
    * @return String 删除CDATA标签后的xml  "<!\\[CDATA\\[([^\\]]+)\\]\\]>"
    */
    public static String deleteCdataTag(final String xml) {
        final Pattern p = Pattern.compile("<!\\[CDATA\\[([\\s\\S]*?)\\]\\]>");
//        String result = xml;
//        final Matcher m = p.matcher(result);
//        while (m.find()) {
//            result = result.replace(m.group(0), m.group(1));
////            for(int i=0;i<m.groupCount();i++)
////            {
////                result = result.replace(m.group(i), m.group(i).substring(9, m.group(i).length()-3));
////            }
//            //result = result.replace(m.group(0), m.group(1));
//            //m = p.matcher(result);
//        }
//        return result;
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
