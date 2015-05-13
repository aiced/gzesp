package com.ai.wx.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.wx.util.HttpClientUtil;


/**
 * 自定义菜单功能 服务类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
@Service
public class CustomService {
    
    private static Logger log = LoggerFactory.getLogger(CustomService.class);
    
    /**
     * sendMsg
     *
     */
    public String sendMsg(String accessToken, String jsonMsg) {
    	log.error("发送客服消息");
        if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(jsonMsg) ) {
            log.error("accessToken ||jsonMsg 为空");
            return ""; 
        }
        
        // 拼装 获取 access_token的 https的url
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=");
        url.append(accessToken);
        //获取返回的 json，并转换成bean
        String respJson = HttpClientUtil.sendPostRequestByJava(url.toString(), jsonMsg);
//        String respJson = HttpClientUtil.sendPostSSLRequest(url, jsonMsg);
//        ErrorCode resultModel = null;
        if(StringUtils.isNotBlank(respJson)){
            log.debug("客服 sendMsg 返回json：" + respJson);
//            resultModel = JsonUtils.parseJson(respJson, ErrorCode.class);
        } else {
            log.error("客服消息失败");
        }

        return respJson;
    }
    
}
