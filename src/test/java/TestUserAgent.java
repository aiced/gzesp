

import junit.framework.TestCase;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

import com.ai.wx.util.RegexUtils;

public class TestUserAgent extends TestCase {
    
    @Test
    public void test() throws Exception  {        
        String iosStr = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9B176 MicroMessenger/4.3.2";
        String androidStr = "Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255";
        String androidStr2 = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; HUAWEI G750-T00 Build/HuaweiG750-T00) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 MicroMessenger/6.1.0.73_r1097298.543 NetType/WIFI";
        System.out.println(RegexUtils.isAndroidWeiXin(iosStr));
        System.out.println(RegexUtils.isAndroidWeiXin(androidStr));
        System.out.println(RegexUtils.isAndroidWeiXin(androidStr2));
    }
    
}
