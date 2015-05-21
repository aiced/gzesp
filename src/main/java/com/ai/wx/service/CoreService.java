package com.ai.wx.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.sysframe.utils.CommonUtil;
import com.ai.wx.consts.MessageType;
import com.ai.wx.entity.request.RequestClickMessage;
import com.ai.wx.entity.request.RequestEventMessage;
import com.ai.wx.entity.request.RequestTextMessage;
import com.ai.wx.entity.request.RequestTicketMessage;
import com.ai.wx.entity.request.RequestVoiceMessage;
import com.ai.wx.entity.response.Article;
import com.ai.wx.entity.response.ResponseNewsMessage;
import com.ai.wx.entity.response.ResponseTextMessage;
import com.ai.wx.util.MessageUtil;
import com.ai.wx.util.RegexUtils;
import com.ai.wx.util.XmlUtils;



@Service
public class CoreService {
    
    private static Logger log = LoggerFactory.getLogger(CoreService.class);
    
    private final String[][] voice2url = {
    		{"手机营业厅","http://wap.10010.com/t/home.htm"},
    		{"我要开店","http://wap.gz10010.xyz/esp/weShop/index"},
    		{"店铺管理",""},
    		{"业绩查询",""},
    		{"赚钱指南",""},
    };
    
    /**
     * 请求处理总入口<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    public String processRequest(String xml) {

        // 获取请求消息类型
        String reqTypeElement = RegexUtils.getElementBySinglePath(xml, MessageType.XML_ATTR_MSG_TYPE);
        String reqType = RegexUtils.getElementText(XmlUtils.deleteCdataTag(reqTypeElement));
        String respMessage = "消息处理异常";
        
        log.info("reqType---"+reqType);
        // 文本消息
        if (MessageType.REQ_MESSAGE_TYPE_TEXT.equals(reqType)) {
            respMessage = processTextReq(xml);
        }
        // 图片消息
        else if (MessageType.REQ_MESSAGE_TYPE_IMAGE.equals(reqType)) {

        }
        // 链接消息
        else if (MessageType.REQ_MESSAGE_TYPE_LINK.equals(reqType)) {

        }
        // 地理位置消息
        else if (MessageType.REQ_MESSAGE_TYPE_LOCATION.equals(reqType)) {

        }
        // 音频消息
        else if (MessageType.REQ_MESSAGE_TYPE_VOICE.equals(reqType)) {
        	respMessage = processVoiceReq(xml);
        }
        // 事件推送
        else if (MessageType.REQ_MESSAGE_TYPE_EVENT.equals(reqType)) {
            // 事件类型
            String eventTypeElement = RegexUtils.getElementBySinglePath(xml, MessageType.XML_ATTR_EVENT);
            String eventType = RegexUtils.getElementText(XmlUtils.deleteCdataTag(eventTypeElement));
            log.info("eventType---"+eventType);
            // 订阅,关注公众号
            if (MessageType.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
                respMessage = processSubscribeReq(xml);
            }
            // 取消订阅，取消关注
            else if (MessageType.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
                // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
            }
            // 自定义菜单点击事件
            else if (MessageType.EVENT_TYPE_CLICK.equals(eventType)) {
                respMessage = processClickReq(xml);
            } 
            // 扫描带参数二维码事件,当未关注时Event=subscribe,已关注时Event=SCAN
            else if (MessageType.EVENT_TYPE_SCAN.equals(eventType)) {
                respMessage = processScanReq(xml);
            }             
            else {
                log.error("事件推送类型未匹配到");
                respMessage = "eventType had not found!";
            }
        } 
        //其他类型匹配不到的
        else {
            log.error("请求消息类型未匹配到");
            respMessage = "reqType had not found!";
        }

        return respMessage;
    }
    
    /**
     * 处理语音类型消息<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    private String processVoiceReq(String xml) {
        String respMessage = null;
        
        try {
            Field[] fields = MessageUtil.getFields(RequestVoiceMessage.class);
            // 转换成 RequestTextMessage 文本请求
            RequestVoiceMessage message = RegexUtils.xml2bean(xml, fields, RequestVoiceMessage.class);
            //回复文本消息
            ResponseTextMessage resp = new ResponseTextMessage();
            
            resp.setFromUserName(message.getToUserName());
            resp.setToUserName(message.getFromUserName());
            resp.setCreateTime(new Date().getTime());
            //文本内容可以根据用户输入的内容修改，比如输入1,2,3选项回复不同内容
            resp.setContent(MessageUtil.getUrl(voice2url, message.getRecognition())); 
            
            resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
            resp.setFuncFlag(0);
            
            respMessage = XmlUtils.textMessageToXml(resp);
        } catch (Exception e) {
            log.error("处理语音类型消息请求异常", e);
        }
        
        return respMessage;
    }
    
    /**
     * 处理文本类型消息<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    private String processTextReq(String xml) {
        String respMessage = null;
        //String respContent = "处理文本类型消息请求异常";
        
        try {
//            Field[] fields = MessageUtil.getFields(RequestTextMessage.class);
//            // 转换成 RequestTextMessage 文本请求
//            RequestTextMessage message = RegexUtils.xml2bean(xml, fields, RequestTextMessage.class);
//            //回复文本消息
//            ResponseTextMessage resp = new ResponseTextMessage();
//            
//            resp.setFromUserName(message.getToUserName());
//            resp.setToUserName(message.getFromUserName());
//            resp.setCreateTime(new Date().getTime());
//            //文本内容可以根据用户输入的内容修改，比如输入1,2,3选项回复不同内容
//            resp.setContent(message.getContent()+"--你好，再见"); 
//            resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
//            resp.setFuncFlag(0);
//            
//            respMessage = XmlUtils.textMessageToXml(resp);
        	respMessage="";
        } catch (Exception e) {
            log.error("处理文本类型消息请求异常", e);
        }
        
        return respMessage;
    }
    
    /**
     * 处理图文类型消息<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
/*    private String processNewsReq(String xml){
        return xml;
        
    }*/
    
    /**
     * 处理 订阅公众号事件的 请求消息<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    private String processSubscribeReq(String xml){
        String respMessage = "处理订阅事件请求异常";
        try {
            Field[] fields = RequestEventMessage.class.getDeclaredFields();
            // 转换成 RequestEventMessage 订阅事件请求
            RequestEventMessage message = RegexUtils.xml2bean(xml, fields, RequestEventMessage.class);
            //回复文本消息
            ResponseTextMessage resp = new ResponseTextMessage();
            
            resp.setFromUserName(message.getToUserName());
            resp.setToUserName(message.getFromUserName());
            resp.setCreateTime(new Date().getTime());
            resp.setContent(buildWelcomeResp()); //关注的时候主动发送菜单
            resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
            resp.setFuncFlag(0);
            respMessage = XmlUtils.textMessageToXml(resp);
            
//            respMessage = buildWelcomeResp(message);
        } catch (Exception e) {
            log.error("处理订阅事件请求异常", e);
        } 
        
        return respMessage;
        
    }
    
    /**
     * 处理自定义菜单事件消息<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    private String processClickReq(String xml) {
        String respMessage = null;
        //String respContent = "处理文本类型消息请求异常";
        
        try {
//            Field[] fields = RequestClickMessage.class.getDeclaredFields();
        	 Field[] fields = MessageUtil.getFields(RequestClickMessage.class);
            // 转换成 RequestClickMessage 事件请求
            RequestClickMessage message = RegexUtils.xml2bean(xml, fields, RequestClickMessage.class);
            
            //对应 MenuService.buildMenu()创建的菜单里的eventKey值，进行回复内容
            if(message.getEventKey().equals("keyN")){
                ResponseNewsMessage resp = new ResponseNewsMessage();
                resp.setFromUserName(message.getToUserName());
                resp.setToUserName(message.getFromUserName());
                resp.setCreateTime(new Date().getTime());
                resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_NEWS);
                resp.setFuncFlag(0);
                
                List<Article> articleList = new ArrayList<Article>();  
                Article article1 = new Article();
                article1.setTitle("单条图文消息demo");  
                article1.setDescription("奚敏辉");  
                article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg"); //要改 
                article1.setUrl("http://blog.csdn.net/lyq8479");  //要改
                Article article2 = new Article();  
                article2.setTitle("单条图文消息demo");  
                article2.setDescription("奚敏辉");  
                article2.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg"); //要改 
                article2.setUrl("http://blog.csdn.net/lyq8479");  //要改
                articleList.add(article2);
                
                resp.setArticles(articleList);
                resp.setArticleCount(articleList.size());
                
                respMessage = XmlUtils.newsMessageToXml(resp);
            } else {
//                ResponseTextMessage resp = new ResponseTextMessage();
//                resp.setFromUserName(message.getToUserName());
//                resp.setToUserName(message.getFromUserName());
//                resp.setCreateTime(new Date().getTime());
//                resp.setContent("[难过] /得意  /::D"); 
//                resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
//                resp.setFuncFlag(0);
//                respMessage = XmlUtils.textMessageToXml(resp);
            	respMessage = "";
            }

        } catch (Exception e) {
            log.error("处理文本类型消息请求异常", e);
        }
        
        return respMessage;
    }
    
    /**
     * 处理 已经加了关注后扫描二位码时发生的请求事件<br>
     * 〈功能详细描述〉
     *
     * @param xml
     * @return
     */
    private String processScanReq(String xml) {
        String respMessage = null;
        //String respContent = "处理文本类型消息请求异常";
        
        try {
            Field[] fields = RequestTicketMessage.class.getDeclaredFields();
            // 转换成 RequestTicketMessage 扫描二维码事件请求
            RequestTicketMessage message = RegexUtils.xml2bean(xml, fields, RequestTicketMessage.class);
            //回复文本消息
            ResponseTextMessage resp = new ResponseTextMessage();
            
            resp.setFromUserName(message.getToUserName());
            resp.setToUserName(message.getFromUserName());
            resp.setCreateTime(new Date().getTime());
            //文本内容可以根据需要修改
            resp.setContent("[难过] /得意  /::D，您已经关注了我们，谢谢！"); 
            resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
            resp.setFuncFlag(0);
            
            respMessage = XmlUtils.textMessageToXml(resp);
        } catch (Exception e) {
            log.error("处理扫描二维码类型消息请求异常", e);
        }
        
        return respMessage;
    }
    
    /**
     * 关注的时候主动发送菜单，拼装菜单的文本内容<br>
     * 〈功能详细描述〉
     *
     * @return
     */
//    private String buildWelcomeResp(RequestEventMessage message){
//    	
//		ResponseNewsMessage resp = new ResponseNewsMessage();
//		resp.setFromUserName(message.getToUserName());
//		resp.setToUserName(message.getFromUserName());
//		resp.setCreateTime(new Date().getTime());
//		resp.setMsgType(MessageType.RESP_MESSAGE_TYPE_NEWS);
//		resp.setFuncFlag(0);
//
//		List<Article> articleList = new ArrayList<Article>();
//		Article article1 = new Article();
//		article1.setTitle("对不起，我们来晚了！");
//		article1.setDescription("沃掌柜正式上线啦，全城招募ing\n"
//				+"商品优惠、各种惊喜福利一网打尽\n"
//				+"点击关注，免费开店");
//		article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/Ve1ibTr1M7lzzfqdha6LjvbaVOzbBg8bSJz9CaGicCIahuhuKPD0d0VXACV6osibvLgbp5cBM51QIjqW8cogXh0Zg/0?wx_fmt=jpeg");
//		article1.setUrl("http://http://mp.weixin.qq.com/s?__biz=MzAwMDMwNzg1OA==&mid=204516919&idx=1&sn=a39f0503fd979eef6e4adbc9f1c10cf2#rd");
//
//		 Article article2 = new Article();  
//         article2.setTitle("");  
//         article2.setDescription("1.  0元免费开店");  
//         article2.setPicUrl("https://mp.weixin.qq.com/cgi-bin/getimgdata?mode=large&source=file&fileId=204552443%3E&token=1738675317&lang=zh_CN"); //要改 
//         article2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx52db41a405183edb&redirect_uri=http%3A%2F%2Fwap.gz10010.xyz%2Fesp%2Fwx%2Fauth&response_type=code&scope=snsapi_base&state=register#wechat_redirect"); 
//         
//         Article article3 = new Article();  
//         article3.setDescription("2.  入门须知");  
//         article3.setPicUrl("https://mp.weixin.qq.com/cgi-bin/getimgdata?mode=large&source=file&fileId=204552443%3E&token=1738675317&lang=zh_CN"); //要改 
//         article3.setUrl("http://wap.gz10010.xyz/esp/wx/guides"); 
//         
//         Article article4 = new Article();  
//         article4.setDescription("5.  更多咨询，请直接回复【提问：“问题描述”】");  
//         
//         articleList.add(article1);
//         articleList.add(article2);
//         articleList.add(article3);
//         articleList.add(article4);
//         
//		resp.setArticles(articleList);
//		resp.setArticleCount(articleList.size());
//
//		String respMessage = XmlUtils.newsMessageToXml(resp);
//		return respMessage;
//	}
    private String buildWelcomeResp(){
    	
    	String espRoot = CommonUtil.appResource.getString("espRoot");
    	
        StringBuffer buffer = new StringBuffer();
        
        try {
	        buffer.append(" /::D 欢迎来到沃掌柜大本营！").append("\n");  
	        buffer.append("官方保证，正品货源，0元免费轻松当掌柜。在接下来的日子里，让我们领福利、学销售，一起做亮闪闪的大掌柜！").append("\n").append("\n");  
	        buffer.append("1.  0元免费开店").append("\n");  
			buffer.append("<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx52db41a405183edb&redirect_uri=")
				.append(URLEncoder.encode(espRoot, "UTF-8"))
				.append("%2Fesp%2Fwx%2Fauth&response_type=code&scope=snsapi_base&state=register#wechat_redirect\">☞点这立即注册！</a>").append("\n").append("\n");
	        buffer.append("2.  入门须知").append("\n");  
	        buffer.append("<a href=\"").append(espRoot).append("/esp/wx/guides\" >☞点这立即阅读！</a>").append("\n").append("\n");  
	        buffer.append("3.  收益规则").append("\n");  
	        buffer.append("<a href=\"http://mp.weixin.qq.com/s?__biz=MzAwMDMwNzg1OA==&mid=203639832&idx=1&sn=96e317490b1a5d186600646487921312#rd\" >☞点这立即查看！</a>").append("\n").append("\n");  
	        buffer.append("4.  收益发放").append("\n");  
	        buffer.append("<a href=\"http://mp.weixin.qq.com/s?__biz=MzAwMDMwNzg1OA==&mid=204322183&idx=1&sn=cba85430b9e9ef22634dd95992c4d8f6#rd\" >☞点这立即了解！</a>").append("\n").append("\n");  
	    
	        buffer.append("5.  更多咨询，请直接回复【提问：“问题描述”】").append("\n");  
     
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return buffer.toString();        
    }
    

}
