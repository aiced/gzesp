//package com.ai.sysframe.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//
//
//import com.ai.sysframe.utils.jpush.JpushUtil;
//import com.ai.sysframe.utils.jpush.PushMsgInfo;
//
//import javapns.devices.Device;
//import javapns.devices.implementations.basic.BasicDevice;
//import javapns.notification.AppleNotificationServerBasicImpl;
//import javapns.notification.Payload;
//import javapns.notification.PushNotificationManager;
//import javapns.notification.PushNotificationPayload;
//import javapns.notification.PushedNotification;
//
//public class PushUtil {
//
//	public final static String FROM_ANDROID = "ANDROID";
//	
//	public final static String IOS = "IOS";
//	
//	public static void push(PushMsgInfo pushMsgInfo,String fromSystem) 
//	{
//		if(fromSystem.equals(FROM_ANDROID)) 
//		{
//			JpushUtil.pushAdriodMSG(pushMsgInfo);
//		}else 
//		{
//			String p12File = CommonUtil.getAppMsg("p12file");
//			String p12Pass = CommonUtil.getAppMsg("p12pass");
//			
//			push2One(p12File,p12Pass,pushMsgInfo.getUserAlias(),pushMsgInfo.getMsgContent());
//		}
//	} 
//	
//	/** 
//	   * 向单个iphone手机推送消息. 
//	   * @param deviceToken iphone手机获取的token 
//	   * @param p12File .p12格式的文件路径 
//	   * @param p12Pass .p12格式的文件密码 
//	   * @param customDictionarys CustomDictionary字典组 
//	   * @param content 推送内容 
//	   */  
//	  public static int push2One(String p12File, String p12Pass, String deviceToken, String content) {  
//		  try
//	        {
//	            PushNotificationPayload payLoad = new PushNotificationPayload();
//	            payLoad.addAlert(content); // 消息内容
//	            payLoad.addBadge(1); // iphone应用图标上小红圈上的数值
//	            String sound="default";
//	            if (!StringUtils.isBlank(sound))
//	            {
//	                payLoad.addSound(sound);//铃音
//	            }
//	            PushNotificationManager pushManager = new PushNotificationManager();
//	            //true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
//	            pushManager.initializeConnection(new AppleNotificationServerBasicImpl(p12File, p12Pass, true));
//	            List<PushedNotification> notifications = new ArrayList<PushedNotification>();
//	            // 发送push消息
//	                Device device = new BasicDevice();
//	                device.setToken(deviceToken);
//	                PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
//	                notifications.add(notification);
//	                
//	            List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
//	            List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
//	            int iFailed = failedNotifications.size();
//	            int iSuccessful = successfulNotifications.size();
//	            pushManager.stopConnection();
//	            return iSuccessful;
//	        }
//	        catch (Exception e)
//	        {
//	            e.printStackTrace();
//	            return -1;
//	        }
//	  }
//	  
//	  /** 
//	   * 向iphone群组推送消息. 
//	   * @param deviceTokens iphone手机获取的token 
//	   * @param p12File .p12格式的文件路径 
//	   * @param p12Pass .p12格式的文件密码 
//	   * @param customDictionarys CustomDictionary字典 
//	   * @param content 推送内容 
//	   */  
//	  public static int push2More(String p12File, String p12Pass, List<String> deviceTokens, String content) {
//		  try
//	        {
//	            PushNotificationPayload payLoad = new PushNotificationPayload();
//	            payLoad.addAlert(content); // 消息内容
//	            payLoad.addBadge(1); // iphone应用图标上小红圈上的数值
//	            String sound="default";
//	            if (!StringUtils.isBlank(sound))
//	            {
//	                payLoad.addSound(sound);//铃音
//	            }
//	            PushNotificationManager pushManager = new PushNotificationManager();
//	            //true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
//	            pushManager.initializeConnection(new AppleNotificationServerBasicImpl(p12File, p12Pass, true));
//	            List<PushedNotification> notifications = new ArrayList<PushedNotification>();
//	            // 发送push消息
//
//              List<Device> device = new ArrayList<Device>();
//              for (String token : deviceTokens)
//              {
//                  device.add(new BasicDevice(token));
//              }
//              notifications = pushManager.sendNotifications(payLoad, device);
//	                
//	            List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
//	            List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
//	            int iFailed = failedNotifications.size();
//	            int iSuccessful = successfulNotifications.size();
//	            pushManager.stopConnection();
//	            return iSuccessful;
//	        }
//	        catch (Exception e)
//	        {
//	            e.printStackTrace();
//	            return -1;
//	        }
//	  }
//	  
//	  
//		public static void main(String[] args) throws Exception
//	    {
//	        String deviceToken = "f24e06dbe8142ee29d73af32973fa9febdef0a9624895e742217ec0fb654ebb6";
//	        String alert = "我的push测试";//push的内容
//	        int badge = 100;//图标小红圈的数值
//	        String sound = "default";//铃音
//
//	        List<String> tokens = new ArrayList<String>();
//	        tokens.add(deviceToken);
//
//			String p12File = CommonUtil.getAppMsg("p12file");
//			String p12Pass = CommonUtil.getAppMsg("p12pass");
//	        push2One(p12File,p12Pass,deviceToken,alert);
//	        
//			
////			PushMsgInfo pushMsgInfo = new PushMsgInfo();
////			pushMsgInfo.setMsgContent("我的push测试");
////			pushMsgInfo.setTitle("ceshi");
////			pushMsgInfo.setUserAlias("8145819a7d476190");
////			pushMsgInfo.setAlter("测试");
////			JpushUtil.pushAdriodMSG(pushMsgInfo);
//	    }
//}
