package com.ai.sysframe.xml.xstream.converters;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
* @ClassName: PojoMapListMarshaller
* @Description: xml和java对象转换类
* @author linyl linyuliang.85@gmail.com
*/
public class PojoMapListMarshaller extends org.springframework.oxm.xstream.XStreamMarshaller {
    /**
    * @Fields xstream : 重载，解决_和&的处理
    */
    private final XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));

    @Override
    public XStream getXStream() {
        xstream.alias("list", ArrayList.class);
        xstream.alias("map", LinkedHashMap.class);
        return this.xstream;
    }
}
