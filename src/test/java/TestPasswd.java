

import junit.framework.TestCase;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

public class TestPasswd extends TestCase {
    
    @Test
    public void testPasswd() throws Exception
    {        
        String passwd = new Sha256Hash("111111","13770305471",1).toBase64();
        passwd = new Sha256Hash("admin","admin",1).toBase64();
        //6bJwcZAYhKmRGHRXKSyP9+oaR0imCLlvBgta9rU/D+M=
        System.out.println("@@@@@@--------------------" + passwd);
        
    }
    
}
