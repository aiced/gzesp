package com.ai.wx.entity.request;

/**
 * 图片请求消息<br>
 * 〈功能详细描述〉
 * 
 * @author 14040909
 */
public class RequestImageMessage extends RequestBaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

}
