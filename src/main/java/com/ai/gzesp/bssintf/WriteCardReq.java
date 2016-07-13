package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.1	写卡结果通知 请求类
 * @author xmh
 *
 */
@XStreamAlias("WriteCardReq")
public class WriteCardReq {
	
	private String UserNum;
	
	private String Iccid;
	
	private String Imsi;
	
	private String EparchyCode;
	
	private String UpdateTime;
	
	private String ProcId2;
	
	private String OperRst;
	
	private String OperComm;
	
	private String StaffId;
	
	private String DepartId;

	public String getUserNum() {
		return UserNum;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public String getIccid() {
		return Iccid;
	}

	public void setIccid(String iccid) {
		Iccid = iccid;
	}

	public String getImsi() {
		return Imsi;
	}

	public void setImsi(String imsi) {
		Imsi = imsi;
	}

	public String getEparchyCode() {
		return EparchyCode;
	}

	public void setEparchyCode(String eparchyCode) {
		EparchyCode = eparchyCode;
	}

	public String getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}

	public String getProcId2() {
		return ProcId2;
	}

	public void setProcId2(String procId2) {
		ProcId2 = procId2;
	}

	public String getOperRst() {
		return OperRst;
	}

	public void setOperRst(String operRst) {
		OperRst = operRst;
	}

	public String getOperComm() {
		return OperComm;
	}

	public void setOperComm(String operComm) {
		OperComm = operComm;
	}

	public String getStaffId() {
		return StaffId;
	}

	public void setStaffId(String staffId) {
		StaffId = staffId;
	}

	public String getDepartId() {
		return DepartId;
	}

	public void setDepartId(String departId) {
		DepartId = departId;
	}
	

}
