

import junit.framework.TestCase;

import org.junit.Test;

import com.ai.gzesp.utils.DateUtils;

public class TestDate extends TestCase {
    
    @Test
    public void test() throws Exception  {        
    	String time1 = "2015-12-20 20:10:30";
        System.out.println(DateUtils.parse(time1, DateUtils.TIMESTAMP_FORMAT));
    }
    
}
