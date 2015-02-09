package com.ai.osapp.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect  
public class LogAspect {  
	Logger logger = LoggerFactory.getLogger(getClass());
  
	@Pointcut("execution(* com.ai.osapp.remote.controller.*.*(..))")  
    private void controllerMethod(){}
	
	@Before("controllerMethod()")  
    public void logRequest(JoinPoint jp) {  
        String className = jp.getTarget().getClass().getName();  
        String methodName = jp.getSignature().getName();  
        Object[] parames = jp.getArgs();
        StringBuffer sbParam = new StringBuffer();
        for(int i=0;i<parames.length;i++){  
        	sbParam.append(parames[i]);
        }
        
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info(req.getRequestURL()+">>>"+className+"_"+methodName+"_"+sbParam);
        
    }
    
    @AfterReturning(pointcut = "controllerMethod()", returning = "result")  
    public void logResponse(JoinPoint jp, Object result) {
    	logger.info("result>>>"+result);
    }
  
    @AfterThrowing(pointcut = "controllerMethod()", throwing = "ex")  
    public void logException(JoinPoint jp, Throwable ex) {       
    	logger.warn(ex.getMessage());
    }  
}
