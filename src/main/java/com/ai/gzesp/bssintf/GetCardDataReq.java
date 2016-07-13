package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.1	获取写卡数据 接口 请求类
 * @author xmh
 *
 */
@XStreamAlias("GetCardDataReq")
public class GetCardDataReq {
	
	private String UserNum;
	
	private String SimCard;
	
	private String EparchyCode;
	
	private String CustName;
	
	private String PsptId;
	
	private String ProductId;
	
	private String BusiType;
	
	private String CardType;
	
	private String UserType;
	
	private String ProcId;
	
	private String StaffId;
	
	private String DepartId;

	public String getUserNum() {
		return UserNum;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public String getSimCard() {
		return SimCard;
	}

	public void setSimCard(String simCard) {
		SimCard = simCard;
	}

	public String getEparchyCode() {
		return EparchyCode;
	}

	public void setEparchyCode(String eparchyCode) {
		EparchyCode = eparchyCode;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getPsptId() {
		return PsptId;
	}

	public void setPsptId(String psptId) {
		PsptId = psptId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public String getBusiType() {
		return BusiType;
	}

	public void setBusiType(String busiType) {
		BusiType = busiType;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public String getProcId() {
		return ProcId;
	}

	public void setProcId(String procId) {
		ProcId = procId;
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
