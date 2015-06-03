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
        //logger.error(exception)只打印一行，logger.error("",exception) 会打印整个堆栈
    	log.error("Handle exception", ex); 
        String path =  CommonUtil.appResource.getString("base");
        
        String userId = String.valueOf(request.getSession(true).getAttribute("userId"));
        
        if(ex instanceof org.apache.shiro.authz.UnauthenticatedException) {
        	return new ModelAndView("forward:"+path+"/notLogin");
        } else if(ex instanceof org.apache.shiro.authz.UnauthorizedException) {
        	return new ModelAndView("forward:"+path+"/unauthorized");
        } else {
        	return new ModelAndView("redirect:/error?userId="+userId+"&code="+ReturnCode.SERVER_RUN_ERR);
        }
    }
}