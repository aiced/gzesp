package com.ai.gzesp.unionpay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

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
//        String classname = type.getName();
//        if (classname.indexOf("Map") >= 0 
//                || classname.indexOf("List") >= 0
//                || classname.indexOf("Bean") >= 0)
//            return true;
//        else
//            return false;
        
        return type.equals(HashMap.class) || type.equals(LinkedHashMap.class);
        

    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
//        Map map = (Map) source;
//        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
//            Entry entry = (Entry) iterator.next();
//            ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);
//            // writer.addAttribute("key", entry.getKey().toString());
//            // writer.addAttribute("value", entry.getValue().toString());
//            writer.setValue(entry.getValue().toString());
//            writer.endNode();
//        }
    	
    	map2xml(source, writer, context);

    }
    
    protected void map2xml(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        boolean bMap = true;
        String classname = value.getClass().getName();

        bMap = (classname.indexOf("List") < 0); //true是map，false 是list, 这边只转
        Map<String, Object> map;
        List<Object> list;
        String key;
        Object subvalue;
        if (bMap) {
            map = (Map<String, Object>) value;
            for (Iterator<Entry<String, Object>> iterator = map.entrySet()
                    .iterator(); iterator.hasNext();) {
                Entry<String, Object> entry = (Entry<String, Object>) iterator
                        .next();
                key = (String) entry.getKey();
                subvalue = entry.getValue();
                writer.startNode(key);
                if (subvalue.getClass().getName().indexOf("String") >= 0) {
                    writer.setValue((String) subvalue);
                } else {
                    map2xml(subvalue, writer, context);
                }
                writer.endNode();
            }

        } else {
            list = (List<Object>) value;
            for (Object subval : list) {
                subvalue = subval;
                writer.startNode("child");
                if (subvalue.getClass().getName().indexOf("String") >= 0) {
                    writer.setValue((String) subvalue);
                } else {
                    map2xml(subvalue, writer, context);
                }
                writer.endNode();
            }
        }
    }
    

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        // Map map = (Map) createCollection(context.getRequiredType());
    	Object map = populateMap(reader, context);
        return map;

    }

    protected Object populateMap(HierarchicalStreamReader reader, UnmarshallingContext context) {
//        Map<String, String> map = new HashMap<String, String>();
//
//        while (reader.hasMoreChildren()) {
//            reader.moveDown();
//            // Object key = reader.getAttribute("key");
//            // Object value = reader.getAttribute("value");
//            String key = reader.getNodeName();
//            String value = reader.getValue();
//            map.put(key, value);
//            reader.moveUp();
//        }
//
//        return map;
    	
        boolean bMap = true;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        String tempKey = null; //用于判断是不是有重复的key，用于判断是否生成list
        Map<String, Object> tempMap = new HashMap<String, Object>(); //如果有重复的key，而且已经放到map里了，后面发现又
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            String key = reader.getNodeName();
            Object value = null;
            if (reader.hasMoreChildren()) {
                value = populateMap(reader, context);
            } else {
                value = reader.getValue();
            }
            if (bMap) {
                if (map.containsKey(key)) {
//                    // convert to list
//                    bMap = false;
//                    Iterator<Entry<String, Object>> iter = map.entrySet()
//                            .iterator();
//                    while (iter.hasNext())
//                        list.add(iter.next().getValue());
                	//如果有重复的key，而且前面一次循环已经放到map里了，后面又出现这个key，表示下面开始是应该生成list了，这边不考虑顺序混乱的情况
                	tempKey = key;
                	tempMap.put(key, map.get(key));
                    // insert into list
                    list.add(value);
                } else {
                    // insert into map
                    map.put(key, value);
                }
            } else {
                // insert into list
                list.add(value);
            }
            reader.moveUp();
        }
        
        if(StringUtils.isNotBlank(tempKey)){
        	tempMap.put(tempKey, map.get(tempKey));
        	list.add(tempMap);
        	map.remove(tempKey);
        }
        
        if(MapUtils.isNotEmpty(map)){
        	//如果map不为空，list不为空，表示该节点下既有普通属性，又有几个同名的节点，作为list
        	if(CollectionUtils.isNotEmpty(list)){
        		map.put("list", list); //
        	}
        	return map;
        }
        else{
        	return list;
        }
        
//        if (bMap)
//            return map;
//        else
//            return list;
    }

}
