package com.ai.gzesp.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class ManageAuthenticationFilter extends FormAuthenticationFilter{
	protected final Logger logger = Logger.getLogger(ManageAuthenticationFilter.class);
//    private final String successUrl = "config.jsp"; 
    private final String loginUrl = "/mvc/manage"; 
//    private final String unAuthUrl = "unAuth.jsp"; 
    
    ManageAuthenticationFilter() {
    	super();
    	
    }
    
	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return super.executeLogin(request, response);
	}


	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) {
		// TODO Auto-generated method stub
		return super.isAccessAllowed(request, response, mappedValue);
	}


	@Override
	protected boolean isLoginRequest(ServletRequest request,
			ServletResponse response) {
		// TODO Auto-generated method stub
		return super.isLoginRequest(request, response);
	}


	@Override
	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		String tmpUrl = this.getLoginUrl();
//		this.setLoginUrl(loginUrl);
		super.redirectToLogin(request, response);
//		this.setLoginUrl(tmpUrl);
	}



    @Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
    	accessDeniedResponse(request, response);
    	return false;
		//return super.onAccessDenied(request, response);
	}
    private void accessDeniedResponse(ServletRequest request,
            ServletResponse response) throws Exception {
	    HttpServletResponse httpResponse = (HttpServletResponse)response;
	   // httpResponse.addHeader("WWW-Authentication", "ACME-AUTH");
	    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
} 


	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		// TODO Auto-generated method stub
		return super.onLoginFailure(token, e, request, response);
	}


     
 
//    @Override
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
//            throws Exception {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        logger.debug("redirect to page"+ successUrl);
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + successUrl);   
//        return false;
//    }
}