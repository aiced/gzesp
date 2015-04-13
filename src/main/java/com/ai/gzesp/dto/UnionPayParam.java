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
    
    

}
