

import junit.framework.TestCase;

import org.junit.Test;

import com.ai.wxpay.common.HttpsRequest;

public class TestHttpsClient extends TestCase {
    
    @Test
    public void test() throws Exception  {        
    	
//    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("web.xml");
    	
    	HttpsRequest req = new HttpsRequest();
    	String xmlStr = "<xml>   <appid>wx52db41a405183edb</appid>   <mch_id>1241798102</mch_id>   <nonce_str>6cefdb308e1e2e8aabd48cf79e546a02</nonce_str>   <op_user_id>10000100</op_user_id>   <out_refund_no>1415701182</out_refund_no>   <out_trade_no>1415757673</out_trade_no>   <refund_fee>1</refund_fee>   <total_fee>1</total_fee>   <transaction_id></transaction_id>   <sign>FE56DD4AA85C0EECA82C35595A69E153</sign></xml> ";
    	String result = req.sendPost("https://api.mch.weixin.qq.com/secapi/pay/refund", xmlStr);
    	System.out.println(result);
    }
    
}