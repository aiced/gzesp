package com.ai.sysframe.service;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MessageService
 * @Description: 提供Spring的国际化消息输出功能，需要配置MessageSource的bean
 * @author linyl linyuliang.85@gmail.com
 */
@Service("messageService")
@Scope("singleton")
public class MessageService {
    /**
     * @Fields messageSource : 由Spring注入的Message的Bean
     */
    @Resource(name = "messageSource")
    MessageSource messageSource;

    /**
     * @Fields currentLocale : 当前语言环境
     */
    private Locale currentLocale = Locale.getDefault();

    /**
    * @Title: getCurrentLocale
    * @Description: 获取当前语言环境
    * @return 当前语言环境
    */
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    /**
    * @Title: setCurrentLocale
    * @Description: 设置当前语言环境
    * @param locale 语言环境
    */
    public void setCurrentLocale(final Locale locale) {
        currentLocale = locale;
    }

    /**
     * @Title: getMessage
     * @Description: 格式化消息输出
     * @param code 消息编码
     * @param args 格式化参数：Object[] arg = new Object[] {"Erica",
     *        Calendar.getInstance().getTime()};
     * @return String 字符串
     */
    public String getMessage(final String code, final Object[] args) {
        return messageSource.getMessage(code, args, currentLocale);
    }

    /**
     * @Title: getMessageDef
     * @Description: 格式化消息输出,如果没有，则输出默认消息
     * @param code 消息编码
     * @param args 格式化参数：Object[] arg = new Object[] {"Erica",
     *        Calendar.getInstance().getTime()};
     * @param defaultMessage 默认消息
     * @return String 字符串
     */
    public String getMessageDef(final String code, final Object[] args, final String defaultMessage) {
        return messageSource.getMessage(code, args, defaultMessage, currentLocale);
    }

    /**
     * @Title: getSystemBaseConstant
     * @Description: 获取系统基本参数
     * @param key 系统参数名称
     * @return 系统参数值
     */
    @Cacheable("SYSTEM_BASE_CONSTANT")
    public String getSystemBaseConstant(final String key) {
        return messageSource.getMessage(key, new Object[] {}, currentLocale);
    }
}
