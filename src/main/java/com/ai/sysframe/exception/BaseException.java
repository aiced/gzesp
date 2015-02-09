package com.ai.sysframe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.sysframe.service.MessageService;
import com.ai.sysframe.service.SpringBeanService;


/**
* @ClassName: BaseException
* @Description: 自定义异常基础类
* @author linyl linyuliang.85@gmail.com
*/
public class BaseException extends RuntimeException {
    /**
     * @Fields serialVersionUID : 自动生成的序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseException.class);

    /**
    * @Fields messageService : 消息格式化类
    */
    private static final MessageService MESSAGE = (MessageService) SpringBeanService.getBean("messageService");
    /**
    * @Fields classBeanFactory : spring配置的bean工厂类
    */
    // @Autowired
    // private SpringBeanService springBeanService;

    /**
    * @Fields errorCode : 错误码
    */
    private final String errorCode;

    /**
    * @Fields args : 错误信息参数
    */
    private Object[] args;

    /**
    * <p>Title: 构造函数</p>
    * <p>Description: 只有异常码，没有消息参数</p>
    * @param errorCode 错误码
    */
    public BaseException(final String errorCode) {
        super();
        this.errorCode = errorCode;
        LOGGER.error("系统内部自定义异常，错误码[{}]", errorCode);
    }

    /**
     * @param errorCode  错误码
     * @param args @see {@link java.text.MessageFormat#format(Object)}
     */
    public BaseException(final String errorCode, final Object[] args) {
        super();
        this.errorCode = errorCode;
        this.args = args.clone();
        LOGGER.error("系统内部自定义异常，错误码[{}]消息[{}]", errorCode, MESSAGE.getMessageDef(errorCode, args, ""));
    }

    /**
     * @param errorCode 错误码
     * @param cause 源异常
     */
    public BaseException(final String errorCode, final Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        LOGGER.error("系统内部异常，错误码[{}]原异常信息[{}]", new Object[] { errorCode, cause.getMessage() });
    }

    /**
     * @param errorCode 错误码
     * @param cause 源异常
     * @param args @see {@link java.text.MessageFormat#format(Object)}
     */
    public BaseException(final String errorCode, final Throwable cause, final Object[] args) {
        super(cause);
        this.errorCode = errorCode;
        this.args = args.clone();
        LOGGER.error("系统内部异常，错误码[{}]消息[{}]原异常信息[{}]",
            new Object[] { errorCode, MESSAGE.getMessageDef(errorCode, args, ""), cause.getMessage() });
    }

    /**
     * @Title: setSpringBeanService
     * @Description: 注入bean工厂
     * @param beanFactory bean工厂
     */
    // public void setSpringBeanService(final SpringBeanService beanFactory) {
    // springBeanService = beanFactory;
    // }

    /*
     * (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        String message = "";
        message = MESSAGE.getMessageDef(errorCode, args, "");
        return errorCode + ":" + message;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return the args
     */
    public Object[] getArgs() {
        return args.clone();
    }

}
