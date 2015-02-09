package com.ai.sysframe.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ai.sysframe.utils.CommonUtil;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    private Log log = LogFactory.getLog(getClass());

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        log.warn("Handle exception: " + ex.getClass().getName());
        String path =  CommonUtil.appResource.getString("adminPath");
        
        if(ex instanceof org.apache.shiro.authz.UnauthenticatedException) {
        	return new ModelAndView("forward:"+path+"/notLogin");
        } else if(ex instanceof org.apache.shiro.authz.UnauthorizedException) {
        	return new ModelAndView("forward:"+path+"/unauthorized");
        } else {
        	return new ModelAndView("forward:"+path+"/error");
        }
        
//        Map<String, String> model = new HashMap();
//        model.put("ex", ex.getClass().getSimpleName());
//        model.put("error", ex.getMessage());
//        model.put("adminPath", path);
//        return new ModelAndView("redirect:http://baidu.com", model);
//        return new ModelAndView("forward:"+path+"/unauthorized", model);
//        return new ModelAndView("redirect:"+path+"/unauthorized", model);
    }
}