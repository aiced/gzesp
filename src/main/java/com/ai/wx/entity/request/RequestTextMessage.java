package com.ai.wx.entity.request;

/**
 * 文本类型请求消息<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class RequestTextMessage extends RequestBaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
