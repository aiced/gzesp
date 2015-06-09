package com.ai.wx.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdITFDWEIXINLOG;
import com.ai.gzesp.dao.service.TdITFDWEIXINLOGDao;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.wxpay.WXPay;
import com.ai.wxpay.business.DownloadBillBusiness;
import com.ai.wxpay.protocol.downloadbill_protocol.DownloadBillReqData;
import com.ai.wxpay.protocol.downloadbill_protocol.DownloadBillResData;


/**
 * 自定义菜单功能 服务类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
@Service
public class PayBillService {
    
    private static Logger log = LoggerFactory.getLogger(PayBillService.class);
    
    @Resource
    TdITFDWEIXINLOGDao wxBillDao;
    
    public Map<String, Object> downloadBill(String tradeDay_YYYYMMDD) throws Exception{
    	DownloadBillReqData  downloadBillReqData = new DownloadBillReqData("",tradeDay_YYYYMMDD,"ALL");
    	Map<String, Object> resultMap = new HashMap();
    	resultMap.put("tradeDay", tradeDay_YYYYMMDD);
    	DownloadBillResultListener resultListener = new DownloadBillResultListener(resultMap);
    	WXPay.doDownloadBillBusiness(downloadBillReqData, resultListener);
        return resultMap;
    }
    
    
    class DownloadBillResultListener implements DownloadBillBusiness.ResultListener {
    	private Map<String, Object> result;
    	
    	DownloadBillResultListener(Map<String, Object> _result) {
    		if(_result == null) {
    			_result = new HashMap<String, Object>();
    		}
    		result = _result;
    	}

		@Override
		public void onFailByReturnCodeError(
				DownloadBillResData downloadBillResData) {
		}

		@Override
		public void onFailByReturnCodeFail(
				DownloadBillResData downloadBillResData) {
			result.put("return_code", downloadBillResData.getReturn_code());
			result.put("return_msg", downloadBillResData.getReturn_msg());
		}

		@Override
		public void onDownloadBillFail(String response) {
			result.put("return_code", "FAIL");
			result.put("bill", response);
		}

		@Override
		public void onDownloadBillSuccess(String response) {
			result.put("return_code", "SUCCESS");
			result.put("bill", response);
			
			String tradeDay = String.valueOf(result.get("tradeDay"));
			
			String[] records = response.split("\r\n");
			if(records.length >= 4) {
				String head = records[0];
				log.debug(head);
//				System.out.println("--head---"+head);
				int rcdIndex = 1;
				while(rcdIndex < records.length-2) {
					String info = records[rcdIndex];
					log.debug(info);
					info = info.replaceFirst("`", "");
					String[] fields = info.split(",`");
					
					String tradeTime = fields[0];
					String appId = fields[1];
					String mchId = fields[2];
					String subMchId = fields[3];
					String deviceInfo = fields[4];
					String wxOrdId = fields[5];
					String ordId = fields[6];
					String openId = fields[7];
					String tradeType = fields[8];
					String tradeState = fields[9];
					String bankType = fields[10];
					String feeType = fields[11];
					String totalFee = fields[12];
					String coupon = fields[13];
					String wxRefundId = fields[14];
					String refundId = fields[15];
					String refundFee = fields[16];
					String couponRefundFee = fields[17];
					String refundType = fields[18];
					String refundState = fields[19];
					String goodsName = fields[20];
//					String attach = fields[21];
					String serviceFee = fields[22];
					String rate = fields[23];
					
					Criteria example = new Criteria();
					example.createConditon().andEqualTo("TRADE_DAY", tradeDay);
					wxBillDao.deleteByExample(example);
					
					TdITFDWEIXINLOG record = new TdITFDWEIXINLOG();
					record.setAppId(appId);
					record.setBankType(bankType);
					record.setCuponFee(CommonUtil.string2Long(coupon)*10);
					record.setDeviceInfo(deviceInfo);
					record.setFeeType(feeType);
					record.setGoodsName(goodsName);
					record.setMchId(mchId);
					record.setOpenId(openId);
					record.setOuterTradeNo(ordId);
					record.setOutRefundNo(refundId);
					record.setRefundCuponFee(CommonUtil.string2Long(couponRefundFee)*10);
					record.setRefundFee(CommonUtil.string2Long(refundFee)*10);
					record.setRefundState(refundState);
					record.setRefundType(refundType);
					record.setServiceFee(serviceFee);
					record.setServiceFeeRate(rate);
					record.setSubMchId(subMchId);
					record.setTotalFee(CommonUtil.string2Long(totalFee)*10);
					record.setTradeDay(tradeDay);
					record.setTradeState(tradeState);
					record.setTradeTime(tradeTime);
					record.setTradeType(tradeType);
					record.setTransactionId(wxOrdId);
					record.setWxRefundNo(wxRefundId);
					
					wxBillDao.insertSelective(record);
//					for(String field: fields) {
//						System.out.print("---"+field);
//					}
//					System.out.println("");
					rcdIndex++;
				}
//				String totalHead = records[records.length-2];
//				String totalInfo = records[records.length-1];
			}
		}
    	
    }
    
}
