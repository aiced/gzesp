package com.ai.wx.entity.request;

/**
 * 自定义菜单事件请求<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class RequestClickMessage extends RequestEventMessage {
    //Event事件类型，CLICK
    
    // 事件KEY值，与自定义菜单接口中KEY值对应 
    private String EventKey;
    
    public String getEventKey() {
        return EventKey;
    }
    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
