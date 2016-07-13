package com.ai.gzesp.bssintf;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 2.1	获取写卡数据  响应类
 * @author xmh
 *
 */
@XStreamAlias("GetCardDataRsp")
public class GetCardDataRsp {
	
	private String AnswerCode;
	
	private String Desc;
	
	private String ReservStatus;
	
	private String Comments;
	
	private String ICCID;
	
	private String IMSI;
	
	private String ScriptSeq;
	
	private String CardData;
	
	private String ProcId;

	public String getAnswerCode() {
		return AnswerCode;
	}

	public void setAnswerCode(String answerCode) {
		AnswerCode = answerCode;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getReservStatus() {
		return ReservStatus;
	}

	public void setReservStatus(String reservStatus) {
		ReservStatus = reservStatus;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getICCID() {
		return ICCID;
	}

	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public String getScriptSeq() {
		return ScriptSeq;
	}

	public void setScriptSeq(String scriptSeq) {
		ScriptSeq = scriptSeq;
	}

	public String getCardData() {
		return CardData;
	}

	public void setCardData(String cardData) {
		CardData = cardData;
	}

	public String getProcId() {
		return ProcId;
	}

	public void setProcId(String procId) {
		ProcId = procId;
	}



}
