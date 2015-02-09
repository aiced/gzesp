package com.ai.sysframe.utils.jpush;

public class PushMsgInfo {

	private String userAlias;
	
	private String alter;
	
	private String title;
	
	private String msgContent;

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getAlter() {
		return alter;
	}

	public void setAlter(String alter) {
		this.alter = alter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		return buffer.append("PushMsgInfo [alter=").append(alter).append(", msgContent=").append(msgContent
				).append(", title=").append(title).append(", userAlias=").append(userAlias).append("]").toString();
	}
}
