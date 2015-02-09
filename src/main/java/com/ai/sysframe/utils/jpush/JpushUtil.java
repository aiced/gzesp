package com.ai.sysframe.utils.jpush;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.sysframe.utils.CommonUtil;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JpushUtil {

	/**
	 * @Fields LOGGER : 日志操作类
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(JpushUtil.class);

	/**
	 * 向andriod客户端推送消息
	 * 
	 * @param pushMsgInfo
	 *            推送的消息信息
	 * @return PushResult 推送结果
	 */
	public static void pushAdriodMSG(PushMsgInfo pushMsgInfo) {

		// 入口参数检验
		if (pushMsgInfo == null) {
			LOGGER.error("JpushUtil.pushAdriodMSG param pushMsgInfo is null.");
			return;
		}

		// 校验用户别名
		if (StringUtils.isEmpty(pushMsgInfo.getUserAlias())) {
			LOGGER.error("JpushUtil.pushAdriodMSG param userAlias is null or empty string.");
			return;
		}

		if (StringUtils.isEmpty(pushMsgInfo.getMsgContent())) {
			LOGGER.error("JpushUtil.pushAdriodMSG param msgContent is null or empty string.");
			return;
		}

		if (pushMsgInfo.getAlter() == null) {
			LOGGER.error("JpushUtil.pushAdriodMSG param alert is null.");
			return;
		}

		final String appKey = CommonUtil.getAppMsg("appKey");
		final String masterSecret = CommonUtil.getAppMsg("masterSecret");

		// 保存离线的时长。秒为单位。最多支持10天（864000秒）。
		// 表示该消息不保存离线。即：用户在线马上发出，当前不在线用户将不会收到此消息。
		// 此参数不设置则表示默认，默认为保存1天的离线消息（86400秒)。
		final int timeToLive = 60 * 60 * 24 * (Integer.valueOf(CommonUtil
				.getAppMsg("timeToLive")));

		// 获取jpush客户端
		JPushClient jpush = new JPushClient(masterSecret, appKey, timeToLive);

		PushPayload payload = buildPushObject_android(pushMsgInfo);

		// 推送结果
		PushResult result = null;
		try {
			result = jpush.sendPush(payload);
			LOGGER.debug("The server returns data: " + result.toString());
			
			if (result.isResultOK()) {
				LOGGER.info("Notification or message pushing success, " + "msgContent is " + pushMsgInfo.getMsgContent());
			}

		} catch (APIConnectionException e) {
			LOGGER.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOGGER.error("Error response from JPush server. Should review and fix it. ",
							e);
			LOGGER.error("HTTP Status: " + e.getStatus());
			LOGGER.error("Error Code: " + e.getErrorCode());
			LOGGER.error("Error Message: " + e.getErrorMessage());
		}
	}

	/**
	 * 构建推荐消息体
	 * 
	 * @param pushMsgInfo
	 *            推送消息信息
	 * @return PushPayload
	 */
	private static PushPayload buildPushObject_android(PushMsgInfo pushMsgInfo) {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(
						Audience.alias(new String[] { pushMsgInfo
								.getUserAlias() })).setNotification(
						Notification.android(pushMsgInfo.getAlter(),
								pushMsgInfo.getTitle(), null)).setMessage(
						Message.content(pushMsgInfo.getMsgContent())).build();
	}
}
