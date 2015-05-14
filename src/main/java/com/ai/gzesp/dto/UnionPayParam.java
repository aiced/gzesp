package com.ai.gzesp.dto;

/**
 * 支付输入参数界面对应bean<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnionPayParam {
    
    /**
     * 订单号
     */
    private String order_id;

    /**
     * 金额 单位元
     */
    private String fee;
    
    /**
     * 银行卡类型 信用卡:01或借记卡:02
     */
    private String card_type;
    
    /**
     * 银行卡号
     */
    private String bank_card_no;
    
    /**
     * 银行卡有效期(一般信用卡才有)
     */
    private String bank_card_expire_date;   
    
    /**
     * 银行卡cvn(一般信用卡才有)
     */
    private String bank_card_cvn;    
    
    /**
     * 身份证号
     */
    private String id_card_no;
    
    /**
     * 手机号
     */
    private String phone_no;
    
    /**
     * 全名
     */
    private String full_name;
    
    /**
     * 签约号
     */
    private String sign_code;
    
    /**
     * 调用绑定接口的系统跟踪号
     */
    private String bind_sys_trade_no;
    
    /**
     * 调用绑定接口的请求时间戳
     */
    private String bind_time_stamp;
    
    /**
     * 调用绑定接口 业务类型
     */
    private String bind_trade_type;
    
    /**
     * 调用支付接口的系统跟踪号
     */
    private String pay_sys_trade_no;
    
    /**
     * 调用支付接口的请求时间戳
     */
    private String pay_time_stamp;
    
    /**
     * 调用支付接口 业务类型
     */
    private String pay_trade_type;    
    
    /**
     * 调用绑定解除接口的系统跟踪号
     */
    private String bindCacnel_sys_trade_no;
    
    /**
     * 调用绑定解除接口的请求时间戳
     */
    private String bindCacnel_time_stamp;
    
    /**
     * 调用绑定解除接口 业务类型
     */
    private String bindCacnel_trade_type;    
    
    /**
     * 调用支付撤销/支付退款接口 原订单id
     */
    private String orig_order_id;
    /**
     * 调用支付撤销/支付退款接口 原订单时间
     */
    private String orig_timestamp;

    public UnionPayParam(){
        //空构造，spring 转换对象时需要
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getBank_card_no() {
        return bank_card_no;
    }

    public void setBank_card_no(String bank_card_no) {
        this.bank_card_no = bank_card_no;
    }

    public String getBank_card_expire_date() {
        return bank_card_expire_date;
    }

    public void setBank_card_expire_date(String bank_card_expire_date) {
        this.bank_card_expire_date = bank_card_expire_date;
    }

    public String getBank_card_cvn() {
        return bank_card_cvn;
    }

    public void setBank_card_cvn(String bank_card_cvn) {
        this.bank_card_cvn = bank_card_cvn;
    }

    public String getId_card_no() {
        return id_card_no;
    }

    public void setId_card_no(String id_card_no) {
        this.id_card_no = id_card_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSign_code() {
        return sign_code;
    }

    public void setSign_code(String sign_code) {
        this.sign_code = sign_code;
    }

	public String getBind_sys_trade_no() {
		return bind_sys_trade_no;
	}

	public void setBind_sys_trade_no(String bind_sys_trade_no) {
		this.bind_sys_trade_no = bind_sys_trade_no;
	}

	public String getBind_time_stamp() {
		return bind_time_stamp;
	}

	public void setBind_time_stamp(String bind_time_stamp) {
		this.bind_time_stamp = bind_time_stamp;
	}

	public String getPay_sys_trade_no() {
		return pay_sys_trade_no;
	}

	public void setPay_sys_trade_no(String pay_sys_trade_no) {
		this.pay_sys_trade_no = pay_sys_trade_no;
	}

	public String getPay_time_stamp() {
		return pay_time_stamp;
	}

	public void setPay_time_stamp(String pay_time_stamp) {
		this.pay_time_stamp = pay_time_stamp;
	}

	public String getBind_trade_type() {
		return bind_trade_type;
	}

	public void setBind_trade_type(String bind_trade_type) {
		this.bind_trade_type = bind_trade_type;
	}

	public String getPay_trade_type() {
		return pay_trade_type;
	}

	public void setPay_trade_type(String pay_trade_type) {
		this.pay_trade_type = pay_trade_type;
	}

	public String getBindCacnel_sys_trade_no() {
		return bindCacnel_sys_trade_no;
	}

	public void setBindCacnel_sys_trade_no(String bindCacnel_sys_trade_no) {
		this.bindCacnel_sys_trade_no = bindCacnel_sys_trade_no;
	}

	public String getBindCacnel_time_stamp() {
		return bindCacnel_time_stamp;
	}

	public void setBindCacnel_time_stamp(String bindCacnel_time_stamp) {
		this.bindCacnel_time_stamp = bindCacnel_time_stamp;
	}

	public String getBindCacnel_trade_type() {
		return bindCacnel_trade_type;
	}

	public void setBindCacnel_trade_type(String bindCacnel_trade_type) {
		this.bindCacnel_trade_type = bindCacnel_trade_type;
	}

	public String getOrig_order_id() {
		return orig_order_id;
	}

	public void setOrig_order_id(String orig_order_id) {
		this.orig_order_id = orig_order_id;
	}

	public String getOrig_timestamp() {
		return orig_timestamp;
	}

	public void setOrig_timestamp(String orig_timestamp) {
		this.orig_timestamp = orig_timestamp;
	}
	
	

}
