package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.15	路由查询  响应类
 * @author xmh
 *
 */
@XStreamAlias("UserRouteRsp")
public class RouteRsp {
	
	private String RespCode; //0000 成功
	
	private String RespDesc;
	
	private String SubsysCode;
	
	private String NetType;
	
	private String UserNum;
	
	private String EparchyCode;
	
	private String UserState;

	public String getRespCode() {
		return RespCode;
	}

	public String getRespDesc() {
		return RespDesc;
	}

	public String getSubsysCode() {
		return SubsysCode;
	}

	public String getNetType() {
		return NetType;
	}

	public String getUserNum() {
		return UserNum;
	}

	public String getEparchyCode() {
		return EparchyCode;
	}

	public String getUserState() {
		return UserState;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public void setRespDesc(String respDesc) {
		RespDesc = respDesc;
	}

	public void setSubsysCode(String subsysCode) {
		SubsysCode = subsysCode;
	}

	public void setNetType(String netType) {
		NetType = netType;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public void setEparchyCode(String eparchyCode) {
		EparchyCode = eparchyCode;
	}

	public void setUserState(String userState) {
		UserState = userState;
	}

}
