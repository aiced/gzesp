import org.junit.Test;

import com.ai.gzesp.dto.Sms;
import com.ai.gzesp.service.BaseTest;
import com.thoughtworks.xstream.XStream;


public class TestSms extends BaseTest {
	
	public static final XStream XSTREAM = new XStream();
	
	@Test
	public void test1(){
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sms><mt><status>0</status><msgid>4d392b8f39564f6d9d5a2971f62424cb</msgid></mt></sms>";
		XSTREAM.processAnnotations(Sms.class); // // 识别obj类中的注解
		//XSTREAM.autodetectAnnotations(true);//反序列化的时候无法使用autodetectAnnotations（）方法通知XStream对象去识别annotation
		Sms sms = (Sms) XSTREAM.fromXML(xml);
		System.out.print("-----------" + sms.getMt().getStatus());
	}
}
