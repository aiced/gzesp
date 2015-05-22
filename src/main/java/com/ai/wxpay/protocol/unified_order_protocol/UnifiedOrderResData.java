package com.ai.wxpay.protocol.unified_order_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:12
 */
public class UnifiedOrderResData {

	/**错误码 
	 * NOAUTH商户无此接口权限商户未开通此接口权限请商户前往申请此接口权限
		NOTENOUGH余额不足	用户帐号余额不足用户帐号余额不足，请用户充值或更换支付卡后再支付
		ORDERPAID商户订单已支付商户订单已支付，无需重复操作商户订单已支付，无需更多操作
		ORDERCLOSED订单已关闭当前订单已关闭，无法支付当前订单已关闭，请重新下单
		SYSTEMERROR系统错误系统超时系统异常，请用相同参数重新调用
		APPID_NOT_EXISTAPPID不存在参数中缺少APPID请检查APPID是否正确
		MCHID_NOT_EXISTMCHID不存在参数中缺少MCHID请检查MCHID是否正确
		APPID_MCHID_NOT_MATCHappid和mch_id不匹配appid和mch_id不匹配请确认appid和mch_id是否匹配
		LACK_PARAMS缺少参数缺少必要的请求参数请检查参数是否齐全
		OUT_TRADE_NO_USED商户订单号重复同一笔交易不能多次提交请核实商户订单号是否重复提交
		SIGNERROR签名错误参数签名结果不正确请检查签名参数和方法是否都符合签名算法要求
		XML_FORMAT_ERRORXML格式错误XML格式错误请检查XML参数格式是否正确
		REQUIRE_POST_METHOD请使用post方法未使用post传递参数请检查请求参数是否通过post方法提交
		POST_DATA_EMPTYpost数据为空post数据不能为空请检查post数据是否为空
		NOT_UTF8编码格式错误未使用指定编码格式请使用NOT_UTF8编码格式 
	 **/
	
    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";
    
    //	以下字段在return_code 和result_code都为SUCCESS的时候有返回 
    private String trade_type  = "";
    private String prepay_id = "";
    private String code_url  = "";
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
    
}
