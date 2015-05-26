package com.ai.wx.entity;

/**
 * access_token的api调用后返回的json封装类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class JsApiTicketModel extends ErrorCode {
    
    private String ticket; // 获取到的凭证
    private String expires_in; // 凭证有效时间，单位：秒

    public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

}
