

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.wx.task.WxTimeTask;

public class TestWXBill extends TestCase {
    
	
    @Test
    public void test() throws Exception  {    
    	System.err.println("test");
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
    			"spring/applicationContext.xml", "spring/applicationContext-task.xml");
    	System.err.println("applicationContext");
    	WxTimeTask service = applicationContext.getBean(WxTimeTask.class);
    	System.err.println(service);
//    	WxTimeTask task = new WxTimeTask();
//    	task.runBill();
    	service.runBill();
    	System.err.println("runBill");
    }
    
    
//    class DownloadBillResultListener implements DownloadBillBusiness.ResultListener {
//    	private Map<String, Object> result;
//    	
//    	DownloadBillResultListener(Map<String, Object> _result) {
//    		if(_result == null) {
//    			_result = new HashMap<String, Object>();
//    		}
//    		result = _result;
//    	}
//
//		@Override
//		public void onFailByReturnCodeError(
//				DownloadBillResData downloadBillResData) {
//		}
//
//		@Override
//		public void onFailByReturnCodeFail(
//				DownloadBillResData downloadBillResData) {
//			result.put("return_code", downloadBillResData.getReturn_code());
//			result.put("return_msg", downloadBillResData.getReturn_msg());
//		}
//
//		@Override
//		public void onDownloadBillFail(String response) {
//			result.put("return_code", "FAIL");
//			result.put("bill", response);
//		}
//
//		@Override
//		public void onDownloadBillSuccess(String response) {
//			result.put("return_code", "SUCCESS");
//			result.put("bill", response);
//			
//			String[] records = response.split("\r\n");
//			if(records.length >= 4) {
//				String head = records[0];
//				System.out.println("--head---"+head);
//				int rcdIndex = 1;
//				while(rcdIndex < records.length-2) {
//					String info = records[rcdIndex];
//					info = info.replaceFirst("`", "");
//					String[] fields = info.split(",`");
//					
//					String tradeTime = fields[0];
//					String appId = fields[1];
//					String mchId = fields[2];
//					String subMchId = fields[3];
//					String deviceInfo = fields[4];
//					String wxOrdId = fields[5];
//					String ordId = fields[6];
//					String openId = fields[7];
//					String tradeType = fields[8];
//					String tradeState = fields[9];
//					String bankType = fields[10];
//					String feeType = fields[11];
//					String totalFee = fields[12];
//					String coupon = fields[13];
//					String wxRefundId = fields[14];
//					String refundId = fields[15];
//					String refundFee = fields[16];
//					String couponRefundFee = fields[17];
//					String refundType = fields[18];
//					String refundState = fields[19];
//					String goodsName = fields[20];
////					String attach = fields[21];
//					String serviceFee = fields[22];
//					String rate = fields[23];
//					
//					
//					TdITFDWEIXINLOG record = new TdITFDWEIXINLOG();
//					for(String field: fields) {
//						System.out.print("---"+field);
//					}
//					System.out.println("");
//					rcdIndex++;
//				}
//				String totalHead = records[records.length-2];
//				String totalInfo = records[records.length-1];
//			}
//		}
//    	
//    }
}
