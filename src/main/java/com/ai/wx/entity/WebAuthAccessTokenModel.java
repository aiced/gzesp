package com.ai.wx.entity;

/**
 * access_token的api调用后返回的json封装类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class WebAuthAccessTokenModel extends AccessTokenModel {
    
    private String refresh_token; // 用户刷新access_token 
    private String openid; // 用户唯一标识
    private String scope; // 用户授权的作用域
    private String unionid; // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
    
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
