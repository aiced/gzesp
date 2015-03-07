package com.ai.wx.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.wx.entity.AccessTokenModel;
import com.ai.wx.entity.ErrorCode;
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
public class MenuService {
    
    private static Logger log = LoggerFactory.getLogger(MenuService.class);
    
    /**
     * 获取全局返回码
     *
     * @param appid        微信appid
     * @param appsecret    微信appsecret
     * @return
     * @throws Exception
     */
    public String getAccessToken(String appid, String appsecret) {
        log.debug("获取 accessToken");
        
        String accessToken = null;
        
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(appsecret)) {
            log.error("appid 或者 appsecret 为空");
            return accessToken; //返回null
        }
        
        // 拼装 获取 access_token的 https的url
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=");
        url.append(appid);
        url.append("&secret=");
        url.append(appsecret);
        //获取返回的 json，并转换成bean
        String respJson = HttpClientUtil.sendGetSSLRequest(url.toString(), null);
        if(StringUtils.isNotBlank(respJson)){
            log.debug("获取 accessToken 返回json：" + respJson);
            AccessTokenModel accessTokenModel = JsonUtils.parseJson(respJson, AccessTokenModel.class);
            if (StringUtils.isNotBlank(accessTokenModel.getAccess_token())) {
                accessToken = accessTokenModel.getAccess_token();
            } 
        }
        else {
            log.error("获取 accessToken 为空");
        }

        return accessToken;
    }
    
    /**
     * 发送菜单json，https接口post方式创建菜单 <br>
     * 〈功能详细描述〉
     *
     * @param accessToken
     * @return
     */
    public boolean createMenu(String accessToken, List<String> resultInfo){
        resultInfo.add("获取 accessToken 成功，创建菜单");
        log.debug(resultInfo.get(resultInfo.size()-1));
        
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=");
        url.append(accessToken);
        
        Menu menu = buildMenu();//创建菜单bean
        String menuJson = JsonUtils.toJson(menu);
        
        resultInfo.add("创建菜单 menu 实体转换成json：" + menuJson);
        log.debug(resultInfo.get(resultInfo.size()-1));
        
        String respJson = HttpClientUtil.sendPostSSLRequest(url.toString(), menuJson);
        if(StringUtils.isNotBlank(respJson)){
            resultInfo.add("创建菜单 返回json：" + respJson);
            log.debug(resultInfo.get(resultInfo.size()-1));
            
            ErrorCode errorcode = JsonUtils.parseJson(respJson, ErrorCode.class);
            return errorcode.getErrcode().equals("0") ? true : false;//返回0时表示创建成功
        }
        else{
            resultInfo.add("创建菜单 返回json：为空，返回false");
            log.error(resultInfo.get(resultInfo.size()-1));
            return false;
        }
        
    }
    
    private Menu buildMenu(){
        Menu menu = new Menu();
        Button[] buttons = new Button[3];
        
        CommonButton button1 = new CommonButton(); //普通菜单
        button1.setName("普通菜单");
        button1.setType("click");
        button1.setKey("10");

        ComplexButton button2 = new ComplexButton(); //复杂菜单
        button2.setName("图文菜单");
        CommonButton[] sub_button = new CommonButton[2];
        CommonButton subButton21 = new CommonButton();
        subButton21.setName("单条图文");
        subButton21.setType("click");
        subButton21.setKey("21");
        CommonButton subButton22 = new CommonButton();
        subButton22.setName("多条图文");
        subButton22.setType("click");
        subButton22.setKey("22");
        sub_button[0] = subButton21;
        sub_button[1] = subButton22;
        button2.setSub_button(sub_button);
        
        ComplexButton button3 = new ComplexButton(); //复杂菜单
        button3.setName("其他服务");
        CommonButton[] sub_button2 = new CommonButton[2];
        CommonButton subButton31 = new CommonButton();
        subButton31.setName("音乐消息");
        subButton31.setType("click");
        subButton31.setKey("31");
        CommonButton subButton32 = new CommonButton();
        subButton32.setName("推送消息");
        subButton32.setType("click");
        subButton32.setKey("32");
        sub_button[0] = subButton31;
        sub_button[1] = subButton32;
        button3.setSub_button(sub_button2);
        
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        menu.setButton(buttons);     
        
        return menu;
    }

}
