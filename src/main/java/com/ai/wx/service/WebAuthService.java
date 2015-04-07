package com.ai.wx.service;

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
