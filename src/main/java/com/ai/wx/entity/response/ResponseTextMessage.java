package com.ai.wx.entity.response;

/**
 * 响应消息之文本消息<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class ResponseTextMessage extends ResponseBaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
