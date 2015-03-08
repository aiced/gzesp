package com.ai.wx.consts;

public class MessageType {
    
    /**
     * 报文节点属性：ToUserName
     */
    public static final String XML_ATTR_TO_USER_NAME = "ToUserName";  
    
    /**
     * 报文节点属性：FromUserName
     */
    public static final String XML_ATTR_FROM_USER_NAME = "FromUserName";  
    
    /**
     * 报文节点属性：CreateTime
     */
    public static final String XML_ATTR_CREATE_TIME = "CreateTime";   
    
    /**
     * 报文节点属性：MsgType
     */
    public static final String XML_ATTR_MSG_TYPE = "MsgType";  
    
    /**
     * 报文节点属性：MsgId
     */
    public static final String XML_ATTR_MSG_ID = "MsgId"; 
    
    /**
     * 报文节点属性：PicUrl
     */
    public static final String XML_ATTR_PIC_URL = "PicUrl";
    
    /**
     * 报文节点属性：Title
     */
    public static final String XML_ATTR_TITLE = "Title"; 
    
    /**
     * 报文节点属性：Description
     */
    public static final String XML_ATTR_DESCRIPTION = "Description";  
    
    /**
     * 报文节点属性：Url
     */
    public static final String XML_ATTR_URL = "Url";  
    
    /**
     * 报文节点属性：Location_X
     */
    public static final String XML_ATTR_LOCATION_X = "Location_X"; 
    
    /**
     * 报文节点属性：Location_Y
     */
    public static final String XML_ATTR_LOCATION_Y = "Location_Y"; 
    
    /**
     * 报文节点属性：Scale
     */
    public static final String XML_ATTR_SCALE = "Scale"; 
    
    /**
     * 报文节点属性：Label
     */
    public static final String XML_ATTR_LABEL = "Label"; 
    
    /**
     * 报文节点属性：Content
     */
    public static final String XML_ATTR_CONTENT = "Content"; 
    
    /**
     * 报文节点属性：MediaId
     */
    public static final String XML_ATTR_MEDIA_ID = "MediaId"; 
    
    /**
     * 报文节点属性：Format
     */
    public static final String XML_ATTR_FORMAT = "Format";
    
    /**
     * 报文节点属性：Event
     */
    public static final String XML_ATTR_EVENT = "Event"; 
    
    /** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    
    /** 
     * 事件类型：SCAN(扫描带参数二维码事件,当未关注时Event=subscribe,已关注时Event=SCAN) 
     */  
    public static final String EVENT_TYPE_SCAN = "SCAN";      
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
    
    
}