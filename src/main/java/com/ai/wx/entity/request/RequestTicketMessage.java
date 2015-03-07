package com.ai.wx.entity.request;

/**
 * 扫描带参数二维码事件 请求<br> 
 * 用户扫描带场景值二维码时，可能推送以下两种事件： 
 * 1. 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。 Event事件类型:subscribe
 * 2. 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。Event事件类型:SCAN
 *
 * @author 14040909
 */
public class RequestTicketMessage extends RequestEventMessage {
    //  Event 事件类型，subscribe 或 SCAN

    // 事件KEY值，未关注时 qrscene_为前缀，后面为二维码的参数值
    // 事件KEY值，已关注时是一个32位无符号整数，即创建二维码时的二维码scene_id 
    private String EventKey;
    // 二维码的ticket，可用来换取二维码图片 
    private String Ticket;
    
    public String getEventKey() {
        return EventKey;
    }
    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
    public String getTicket() {
        return Ticket;
    }
    public void setTicket(String ticket) {
        Ticket = ticket;
    }
    
}
