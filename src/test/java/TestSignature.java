

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import junit.framework.TestCase;

import org.junit.Test;

import com.ai.gzesp.utils.DateUtils;
import com.ai.wxpay.common.MD5;
import com.ai.wxpay.common.Signature;

public class TestSignature extends TestCase {
    
    @Test
    public void test() throws Exception  {      
    	
    	Map<String, Object> finalpackage = new HashMap<String, Object>();
    	finalpackage.put("appId", "wx52db41a405183edb");  
		finalpackage.put("nonceStr", "u3hergald6gdm97nhwlaceio2jz9tjnl");  
		finalpackage.put("package", "prepay_id=wx20150601143157bb149230ef0041600109");  
		finalpackage.put("signType", "MD5");
		finalpackage.put("timeStamp", "1433140076");  
		String   result = Signature.getSign(finalpackage);
		System.out.println(result);
    	
    	String str = "appId=wx52db41a405183edb&nonceStr=u3hergald6gdm97nhwlaceio2jz9tjnl&package=prepay_id=wx20150601143157bb149230ef0041600109&signType=MD5&timeStamp=1433140076&key=0sbd781d015ca667d6eba25e609fuck3";
    	result = MD5.MD5Encode(str).toUpperCase();
        System.out.println(result);
    }
    
}
