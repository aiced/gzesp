package com.ai.wx.entity.request;

/**
 * 请求消息之语音消息<br>
 * 〈功能详细描述〉
 * 
 * @author 14040909
 */
public class RequestVoiceMessage extends RequestBaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

}
