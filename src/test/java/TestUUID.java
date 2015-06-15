

import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

public class TestUUID extends TestCase {
    
    @Test
    public void test() throws Exception  {    
    	String uuid = UUID.randomUUID().toString();
    	uuid = uuid.replaceAll("-", "");
        System.out.println(uuid);
        System.out.println(uuid.length());
    }
    
}
