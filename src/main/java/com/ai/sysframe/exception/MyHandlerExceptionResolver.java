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
        String path =  CommonUtil.appResource.getString("base");
        
        if(ex instanceof org.apache.shiro.authz.UnauthenticatedException) {
        	return new ModelAndView("forward:"+path+"/notLogin");
        } else if(ex instanceof org.apache.shiro.authz.UnauthorizedException) {
        	return new ModelAndView("forward:"+path+"/unauthorized");
        } else {
        	return new ModelAndView("redirect:/error");
        }
    }
}