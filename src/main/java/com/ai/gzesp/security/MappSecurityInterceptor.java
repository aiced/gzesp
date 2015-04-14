package com.ai.gzesp.security;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

public class MappSecurityInterceptor extends HandlerInterceptorAdapter {
    
	private List blackListIP;
	private List whiteListIP;
	
	private int openingTime;    
    private int closingTime;
    
    private String mappingURL;
    

	public List getBlackListIP() {
		return blackListIP;
	}

	public void setBlackListIP(List blackListIP) {
		this.blackListIP = blackListIP;
	}

	public List getWhiteListIP() {
		return whiteListIP;
	}

	public void setWhiteListIP(List whiteListIP) {
		this.whiteListIP = whiteListIP;
	}

	public int getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}

	public int getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}

	public String getMappingURL() {
		return mappingURL;
	}

	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}

	
    private static final Logger logger = LoggerFactory.getLogger(MappSecurityInterceptor.class);
    
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception { 
    	logger.info("ControllerInterceptor.postHandle()");
  
        boolean bool;
        bool = ipLimit(request, response);
        bool = bool && timeLimit(request, response);
        return bool;
     }
    
    private boolean ipLimit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		InetAddress inet = null;
		try {
			inet = InetAddress.getByName(request.getRemoteAddr());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		
		if ((blackListIP != null && blackListIP.contains(request.getRemoteHost()))
				|| (whiteListIP != null  && !whiteListIP.contains(request.getRemoteHost()))) {
			logger.info("ipLimit not allowed");
//			request.setAttribute("msg", "ipLimit not allowed");
			Map<String, String> map = new HashMap();
			map.put("rspCode", "9999");
            map.put("message","ipLimit not allowed");
			String text = JSON.toJSONString(map);
	        response.setContentType("text/html");
	        response.getWriter().write(text);
			return false;
		}
		
		return true;
    }
    
    private boolean timeLimit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getRequestURL().toString();
		if (mappingURL != null && url.matches(mappingURL)) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			int now = c.get(Calendar.HOUR_OF_DAY);
			if (now < openingTime || now > closingTime) {
//				request.setAttribute("msg", "req allow time：9：00-12：00");
				// request.getRequestDispatcher("/msg.jsp").forward(request, response);
				logger.info("timeLimit not allowed");
				Map<String, String> map = new HashMap();
				map.put("rspCode", "9999");
	            map.put("message","req allow time："+ openingTime +"-" + closingTime);
				String text = JSON.toJSONString(map);
		        response.setContentType("text/html");
		        response.getWriter().write(text);
				return false;
			}
		}
		return true;
    }
     
     
     
    public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
    }
     
     
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
