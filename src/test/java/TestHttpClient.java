

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.ai.wxpay.common.HttpRequest;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;

public class TestHttpClient extends TestCase {
    
    @Test
    public void test() throws Exception  {        
    	HttpRequest req = new HttpRequest();
    	Map info = new HashMap();
    	info.put("name", "leoxu");
    	info.put("age", "30");
    	
    	
    	UnifiedOrderReqData reqData = new UnifiedOrderReqData("123","", 1, "", "", "" ,"");
    	
    	String xml = "<xml><appid>wx52db41a405183edb</appid><mch_id>1241798102</mch_id><device_info>WEB</device_info>    <nonce_str>ifs2pjd3354blb149os8oc88jfbgl86a</nonce_str>     <sign>0E7646419B76A97FB79511B3D2484836</sign>     <body>jsapi wx pay from unicom</body>     <detail></detail>     <attach></attach>     <out_trade_no>1671432911033239</out_trade_no>     <fee_type></fee_type>     <total_fee>1</total_fee>     <spbill_create_ip>122.96.42.224</spbill_create_ip><time_start></time_start><time_expire></time_expire>     <goods_tag></goods_tag>     "
    			+ "<notify_url>http://wap.woboss.gz186.com/esp/pay/wxPay/callback</notify_url>  "
    			+ "   <trade_type>JSAPI</trade_type>     <product_id></product_id>     <openid>okhDVstuDQcv9hXYCTwZ2hR6e34s</openid>  </xml>";
    	String result = req.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder", reqData);
    	System.out.println(result);
    	
    }
    
}
