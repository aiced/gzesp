package com.ai.wxpay.protocol.unified_order_protocol;

import com.ai.wxpay.common.Configure;
import com.ai.wxpay.common.RandomStringGenerator;
import com.ai.wxpay.common.Signature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:12
 */
public class UnifiedOrderReqData {

    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "";
    private int total_fee  = 0;
    private String spbill_create_ip  = "";
    private String time_start = "";
    private String time_expire  = "";
    private String goods_tag  = "";
    private String notify_url  = "";
    private String trade_type   = "";
    private String product_id  = "";
    private String openid   = "";

    public UnifiedOrderReqData(String _body, String _out_trade_no, int _total_fee,
    		String _spbill_create_ip, String _notify_url, String _trade_type, String _openid ){

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(Configure.getAppid());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());
        
        //微信支付分配的终端设备号，与下单一致
        setDevice_info(Configure.getDeviceInfo());
        
        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        
        this.setBody(_body);
        
        this.setOut_trade_no(_out_trade_no);
        
        this.setTotal_fee(_total_fee);
        
        this.setSpbill_create_ip(_spbill_create_ip);
        
        this.setNotify_url(_notify_url);
        
        this.setTrade_type(_trade_type );
        
        this.setOpenid(_openid);
        
        //根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中
    }


    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
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


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getAttach() {
		return attach;
	}


	public void setAttach(String attach) {
		this.attach = attach;
	}


	public String getOut_trade_no() {
		return out_trade_no;
	}


	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}


	public String getFee_type() {
		return fee_type;
	}


	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}


	public int getTotal_fee() {
		return total_fee;
	}


	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}


	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}


	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}


	public String getTime_start() {
		return time_start;
	}


	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}


	public String getTime_expire() {
		return time_expire;
	}


	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}


	public String getGoods_tag() {
		return goods_tag;
	}


	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}


	public String getNotify_url() {
		return notify_url;
	}


	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}


	public String getTrade_type() {
		return trade_type;
	}


	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}
    
}
