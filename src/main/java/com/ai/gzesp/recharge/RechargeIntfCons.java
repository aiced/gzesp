package com.ai.gzesp.recharge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.ResultCode;

/**
 * esp对外网系统提供充值接口，属性常量类，主要是商户号，desKey，md5Key等
 * @author xmh
 *
 */

public enum RechargeIntfCons {
	
	/**
	 * "A0001"
	 */
	A0001("A0001", "0aad781d015ca667d6eba25f", "0aad781d015ca667d6eba25e"),
	
	/**
	 * "默认", "0000"
	 */
	A9999("A0001", "0aad781d015ca667d6eba25f", "0aad781d015ca667d6eba25e");
	
    private RechargeIntfCons(String merId, String desKey, String md5Key){
        this.merId = merId;
        this.desKey = desKey;
        this.md5Key = md5Key;
    }
	
    private String merId;
    
    private String desKey;
    
    private String md5Key;

	public String getMerId() {
		return merId;
	}

	public String getDesKey() {
		return desKey;
	}

	public String getMd5Key() {
		return md5Key;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public void setDesKey(String desKey) {
		this.desKey = desKey;
	}

	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
    
	  // 普通方法, 根据 4位返回码，查找返回
	public static String[] find(String merId) {
		for (RechargeIntfCons i : RechargeIntfCons.values()) {
			if (i.merId.equals(merId)) {
				String[] a = {i.desKey, i.md5Key};
				return a;
			}
		}
		return null; //找不到返回null
	}
}
