package com.ai.wx.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.wx.entity.ErrorCode;
import com.ai.wx.entity.WebAuthAccessTokenModel;
import com.ai.wx.entity.menu.Button;
import com.ai.wx.entity.menu.CommonButton;
import com.ai.wx.entity.menu.ComplexButton;
import com.ai.wx.entity.menu.Menu;
import com.ai.wx.util.HttpClientUtil;
import com.ai.wx.util.JsonUtils;


/**
 * 自定义菜单功能 服务类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
@Service
public class WebAuthService {
    
    private static Logger log = LoggerFactory.getLogger(WebAuthService.class);
    
    /**
     *  https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx52db41a405183edb&redirect_uri=http%3A%2F%2Fwap.gz10010.xyz%2Fesp%2Fwx%2Fauth&response_type=code&scope=snsapi_base&state=weShopIndex#wechat_redirect
     * @param appid
     * @param appsecret
     * @param code
     * @return
     */
	 public String getRedirectUrl(String appid, String redirect_uri, String state) {
	        
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(redirect_uri)) {
            log.error("appid ||redirect_uri");
            return null; //返回null
        }
        
	 	StringBuilder url = new StringBuilder();
        url.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        url.append(appid);
        url.append("&redirect_uri=");
        try {
			url.append(URLEncoder.encode(redirect_uri,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        url.append("&response_type=code");
        url.append("&scope=snsapi_base");
//        url.append("&scope=snsapi_userinfo");
        url.append("&state=");
        url.append(state);
        url.append("#wechat_redirect");
        
//        String respJson = HttpClientUtil.sendGetSSLRequest(url.toString(), null);
//        WebAuthAccessTokenModel accessTokenModel = null;
//        if(StringUtils.isNotBlank(respJson)){
//            log.debug("获取 accessToken 返回json：" + respJson);
//            accessTokenModel = JsonUtils.parseJson(respJson, WebAuthAccessTokenModel.class);
//            if (StringUtils.isNotBlank(accessTokenModel.getAccess_token())) {
//                accessToken = accessTokenModel.getAccess_token();
//            } 
//        }
//        else {
//            log.error("获取 accessToken 为空");
//        }

        return url.toString();
	 }
 
 
    /**
     * 获取全局返回码
     *
     * @param appid        微信appid
     * @param appsecret    微信appsecret
     *  @param code    redirect_uri/?code=CODE&state=STATE
     * @return
     * @throws Exception
     */
    public WebAuthAccessTokenModel getAccessToken(String appid, String appsecret, String code) {
        log.debug("获取 accessToken");
        
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(appsecret)  || StringUtils.isEmpty(code)) {
            log.error("appid ||appsecret || code 为空");
            return null; //返回null
        }
        
        // 拼装 获取 access_token的 https的url
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        url.append(appid);
        url.append("&secret=");
        url.append(appsecret);
        url.append("&code=");
        url.append(code);
        url.append("&grant_type=authorization_code");
        //获取返回的 json，并转换成bean
        String respJson = HttpClientUtil.sendGetSSLRequest(url.toString(), null);
        WebAuthAccessTokenModel accessTokenModel = null;
        if(StringUtils.isNotBlank(respJson)){
            log.debug("获取 accessToken 返回json：" + respJson);
            accessTokenModel = JsonUtils.parseJson(respJson, WebAuthAccessTokenModel.class);
//            if (StringUtils.isNotBlank(accessTokenModel.getAccess_token())) {
//                accessToken = accessTokenModel.getAccess_token();
//            } 
        }
        else {
            log.error("获取 accessToken 为空");
        }

        return accessTokenModel;
    }
    
    public String refreshAccessToken(String appid, String refreshToken) {
    	log.debug("刷新 accessToken");
        
        String accessToken = null;
        
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(refreshToken) ) {
            log.error("appid ||refreshToken ");
            return accessToken; //返回null
        }
        
        // 拼装 获取 access_token的 https的url
        StringBuilder url = new StringBuilder();
        url.append("api.weixin.qq.com/sns/oauth2/refresh_token?appid=");
        url.append(appid);
        url.append("&grant_type=refresh_token");
        url.append("&refresh_token=");
        url.append(refreshToken);
        //获取返回的 json，并转换成bean
        String respJson = HttpClientUtil.sendGetSSLRequest(url.toString(), null);
        if(StringUtils.isNotBlank(respJson)){
            log.debug("刷新 accessToken 返回json：" + respJson);
            WebAuthAccessTokenModel accessTokenModel = JsonUtils.parseJson(respJson, WebAuthAccessTokenModel.class);
            if (StringUtils.isNotBlank(accessTokenModel.getAccess_token())) {
                accessToken = accessTokenModel.getAccess_token();
            } 
        }
        else {
            log.error("刷新 accessToken 为空");
        }

        return accessToken;
    }
    
}
