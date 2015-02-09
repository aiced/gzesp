package com.ai.sysframe.json;

import net.sf.json.JSONException;
import net.sf.json.util.PropertySetStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: PropertyStrategyWrapper
 * @Description: json对象转java，属性转换策略包装类
 *               bean时候使用的属性转换策略，本类，作用是忽略json对象中多余的属性，使json有比bean更多的属性时，不报错
 * @author linyl linyuliang.85@gmail.com
 */
public class PropertyStrategyWrapper extends PropertySetStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyStrategyWrapper.class);
    private final PropertySetStrategy original;

    /**
     * <p>
     * Title: 构造函数
     * </p>
     * <p>
     * Description: 转换策略
     * </p>
     * @param original 一般使用默认转换策略
     */
    public PropertyStrategyWrapper(PropertySetStrategy original) {
        this.original = original;
    }

    @Override
    public void setProperty(Object o, String string, Object o1) {
        try {
            original.setProperty(o, string, o1);
        } catch (JSONException e) {
            LOGGER.warn("JSONObject to Bean error:" + e.getMessage());
        }
    }
}
