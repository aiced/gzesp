package com.ai.wx.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本类型请求消息<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class RequestTextMessage extends RequestBaseMessage {
    // 消息内容
	@XStreamAlias("Content")
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
