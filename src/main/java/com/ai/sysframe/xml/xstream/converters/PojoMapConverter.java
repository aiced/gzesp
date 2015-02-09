package com.ai.sysframe.xml.xstream.converters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @ClassName: PojoMapConverter
 * @Description: XSream的自定义converter，用于xml和map，list的相互转换解析
 * @author linyl linyuliang.85@gmail.com
 */
public class PojoMapConverter implements Converter {

    /**
     * @Fields LIST_CLASS_SUFFIX : List类的类名结尾
     */
    private static final String LIST_CLASS_SUFFIX = "List";

    /**
     * <p>
     * Title: 默认构造函数
     * </p>
     * <p>
     * Description: 继承Converter
     * </p>
     */
    public PojoMapConverter() {
        super();
    }

    /**
     * @Title: canConvert
     * @Description: 是否可以转换，转换前判断
     * @param clazz 转换的类
     * @return boolean 是否可以转换
     */
    public boolean canConvert(@SuppressWarnings("rawtypes") final Class clazz) {
        final String classname = clazz.getName();
        return classname.indexOf("Map") >= 0 || classname.indexOf(LIST_CLASS_SUFFIX) >= 0 || classname.indexOf("Bean") >= 0;
    }

    /**
     * @Title: map2xml
     * @Description: 将map，list，pojo对象转换成xml
     * @param value 需要转换的对象
     * @param writer 拼node
     * @param context 上下文
     */
    @SuppressWarnings("unchecked")
    protected void map2xml(final Object value, final HierarchicalStreamWriter writer, final MarshallingContext context) {
        boolean bMap = true;
        bMap = value.getClass().getName().indexOf(LIST_CLASS_SUFFIX) < 0;
        Map<String, Object> map;
        List<Object> list;
        String key;
        Object subvalue;
        if (bMap) {
            map = (Map<String, Object>) value;
            for (final Entry<String, Object> entry2 : map.entrySet()) {
                final Entry<String, Object> entry = entry2;
                key = entry.getKey();
                subvalue = entry.getValue();
                writer.startNode(key);
                if(subvalue==null)
                {
                    writer.setValue("");
                }else if (subvalue.getClass().getName().indexOf("String") >= 0) {
                    writer.setValue((String) subvalue);
                }else {
                    map2xml(subvalue, writer, context);
                }
                writer.endNode();
            }
        } else {
            list = (List<Object>) value;
            for (int i = 0; i < list.size(); i = i + 1) {
                subvalue = list.get(i);
                map2xml(subvalue, writer, context);
            }
        }
    }

    /**
     * <p>
     * Title: marshal
     * </p>
     * <p>
     * Description: 转换map list pojo 到xml
     * </p>
     * @param value 需要转换的对象
     * @param writer 拼node
     * @param context 上下文
     * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object,
     *      com.thoughtworks.xstream.io.HierarchicalStreamWriter,
     *      com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public void marshal(final Object value, final HierarchicalStreamWriter writer, final MarshallingContext context) {
        map2xml(value, writer, context);
    }

    /**
     * <p>
     * Title: unmarshal
     * </p>
     * <p>
     * Description: 转换xml 到 map list pojo
     * </p>
     * @param reader 拼node
     * @param context 上下文
     * @return 转换后的对象
     * @see com.thoughtworks.xstream.converters.Converter#unmarshal(java.lang.Object,
     *      com.thoughtworks.xstream.io.HierarchicalStreamWriter,
     *      com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
        boolean bMap = true;
        final Map<String, Object> map = new LinkedHashMap<String, Object>();
        final List<Object> list = new ArrayList<Object>();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            final String key = reader.getNodeName();
            Object value = null;
            if (reader.hasMoreChildren()) {
                value = unmarshal(reader, context);
            } else {
                value = reader.getValue();
            }
            if (bMap) {
                if (map.containsKey(key)) {
                    // convert to list
                    bMap = false;
                    final Iterator<Entry<String, Object>> iter = map.entrySet().iterator();
                    while (iter.hasNext()) {
                        final Entry<String, Object> entry = iter.next();
                        addMap2List(list, entry.getKey(), entry.getValue());
                    }
                    map.clear();
                    // insert into list
                    addMap2List(list, key, value);
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
        if (bMap) {
            return map;
        } else {
            return list;
        }
    }

    /**
     * @Title: addMap2List
     * @Description: 为list添加一个map对象
     * @param list list对象
     * @param key 要添加到map的key
     * @param value 要添加到Map的value
     */
    public static void addMap2List(final List<Object> list, final String key, final Object value) {
        final Map<String, Object> tempMap = new HashMap<String, Object>();
        tempMap.put(key, value);
        list.add(tempMap);
    }

}
