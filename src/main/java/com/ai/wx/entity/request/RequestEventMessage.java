package com.ai.wx.entity.request;

/**
 * event类型请求的父类, 订阅和取消订阅也是这个类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class RequestEventMessage {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（event）
    private String MsgType;
    // 事件类型，subscribe(订阅)、unsubscribe(取消订阅) , SCAN, CLICK(自定义菜单事件) 
    private String Event;
    
    
    public String getToUserName() {
        return ToUserName;
    }
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
    public String getFromUserName() {
        return FromUserName;
    }
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
    public long getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }
    public String getMsgType() {
        return MsgType;
    }
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
    public String getEvent() {
        return Event;
    }
    public void setEvent(String event) {
        Event = event;
    }
    
}
