package com.ai.gzesp.dto;

/**
 * order_d_pay 的bean
 * @author xmh
 *
 */
public class OrderDPay {

	private String order_id;
	
	private String partition_id;
	
	//private String pay_id;
	
	private String pay_order;
	
	private String pay_type;
	
	private String pay_mode;
	
	private String pay_state;
	
	private String order_fee;
	
	private String pay_fee;
	
	private String pay_time;
	
	private String halt_tag;
	
	private String halt_time;
	
	private String settle_date;
	
	private String refund_tag;
	
	private String refund_time;
	
	private String refund_logid;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPartition_id() {
		return partition_id;
	}

	public void setPartition_id(String partition_id) {
		this.partition_id = partition_id;
	}

/*	public String getPay_id() {
		return pay_id;
	}

	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}*/

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

	public String getPay_state() {
		return pay_state;
	}

	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}

	public String getOrder_fee() {
		return order_fee;
	}

	public void setOrder_fee(String order_fee) {
		this.order_fee = order_fee;
	}

	public String getPay_fee() {
		return pay_fee;
	}

	public void setPay_fee(String pay_fee) {
		this.pay_fee = pay_fee;
	}

	public String getPay_time() {
		return pay_time;
	}

	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}

	public String getHalt_tag() {
		return halt_tag;
	}

	public void setHalt_tag(String halt_tag) {
		this.halt_tag = halt_tag;
	}

	public String getHalt_time() {
		return halt_time;
	}

	public void setHalt_time(String halt_time) {
		this.halt_time = halt_time;
	}

	public String getSettle_date() {
		return settle_date;
	}

	public void setSettle_date(String settle_date) {
		this.settle_date = settle_date;
	}

	public String getRefund_tag() {
		return refund_tag;
	}

	public void setRefund_tag(String refund_tag) {
		this.refund_tag = refund_tag;
	}

	public String getRefund_time() {
		return refund_time;
	}

	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}

	public String getRefund_logid() {
		return refund_logid;
	}

	public void setRefund_logid(String refund_logid) {
		this.refund_logid = refund_logid;
	}
	
	
	
}
