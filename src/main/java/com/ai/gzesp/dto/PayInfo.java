package com.ai.gzesp.dto;

/**
 * 调用 的bean
 * @author xmh
 *
 */
public class PayInfo {

	
	/**
	 * 支付顺序，从1开始
	 */
	private String pay_order; 
	
	/**
	 * 支付类型： 01 在线 02 货到
	 */
	private String pay_type;
	
	/**
	 * 支付方式
     * 10 银联快捷支付
     * 11 银联在线信用卡
     * 12 银联在线储蓄卡
     * 20 支付宝(暂无)
     * 30 微信支付
     * 40 沃支付
     * 51 能人现金可提账户支付
     * 52 能人现金不可提账户支付
     * 53 能人非现金账户支付
	 */
	private String pay_mode;
	
	/**
	 * 支付金额(厘)
	 */
	private String pay_fee;


	public String getPay_order() {
		return pay_order;
	}

	public void setPay_order(String pay_order) {
		this.pay_order = pay_order;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}

	public String getPay_fee() {
		return pay_fee;
	}

	public void setPay_fee(String pay_fee) {
		this.pay_fee = pay_fee;
	}

	
}
