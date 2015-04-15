package com.ai.gzesp.unionpay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 自定义map转xml 转换器，根据银联报文规范定制<br>
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyMapConverter implements Converter {

    public MyMapConverter() {
        super();
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(HashMap.class) || type.equals(LinkedHashMap.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Map map = (Map) source;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Entry entry = (Entry) iterator.next();
            ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);
            // writer.addAttribute("key", entry.getKey().toString());
            // writer.addAttribute("value", entry.getValue().toString());
            writer.setValue(entry.getValue().toString());
            writer.endNode();
        }

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        // Map map = (Map) createCollection(context.getRequiredType());
        Map<String, String> map = populateMap(reader, context);
        return map;

    }

    protected Map<String, String> populateMap(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Map<String, String> map = new HashMap<String, String>();

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            // Object key = reader.getAttribute("key");
            // Object value = reader.getAttribute("value");
            String key = reader.getNodeName();
            String value = reader.getValue();
            map.put(key, value);
            reader.moveUp();
        }

        return map;
    }

}
