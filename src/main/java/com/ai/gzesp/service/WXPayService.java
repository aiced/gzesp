package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWEIXINLOG;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.service.TdOrdDPAYDao;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.service.TdOrdLDEALLOGDao;
import com.ai.gzesp.dao.service.TdPayDWEIXINLOGDao;
import com.ai.gzesp.utils.SmsUtils;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.wxpay.WXPay;
import com.ai.wxpay.common.Configure;
import com.ai.wxpay.protocol.refund_protocol.RefundReqData;
import com.ai.wxpay.protocol.refund_protocol.RefundResData;

@Service
public class WXPayService {
    
	@Resource
    TdPayDWEIXINLOGDao tdPayDWEIXINLOGDao;
	
	@Resource
	TdOrdDREFUNDDao tdOrdDREFUNDDao;
	
	@Resource
	TdOrdDBASEDao tdOrdDBASEDao;
	
	@Resource
	TdOrdDPAYDao tdOrdDPAYDao;
	
	@Resource
	TdOrdLDEALLOGDao tdOrdLDEALLOGDao;
	
    @Resource
    PayService payService;
    
    /*
     * 微信退款
     * Map{result_code:"SUCCESS/FAIL ", result_desc:""}
     */
    public Map<String, String> wxRefund(String orderId) throws Exception {
    	Map<String, String> resultMap = new HashMap();
    	// 检索订单是否有退款成功记录, 假如有：不能再发起流程
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("OUTER_TRADE_NO", orderId)
    		.andEqualTo("REQ_TYPE", "04").andEqualTo("RESULT_CODE", "SUCCESS");
    	int count = tdPayDWEIXINLOGDao.countByExample(example);
    	if(count > 0) {
    		resultMap.put("result_code", "FAIL");
    		resultMap.put("result_desc", "已经存在退款记录");
    		return resultMap;
    	}
    	// 检索订单 审核状态 退款流程需要的字段
    	example.clear();
    	example.createConditon().andEqualTo("OUTER_TRADE_NO", orderId).andEqualTo("REQ_TYPE", "01");
    	List<TdPayDWEIXINLOG> list = tdPayDWEIXINLOGDao.selectByExample(example);
    	if(list.size() == 0) {
    		resultMap.put("result_code", "FAIL");
    		resultMap.put("result_desc", "订单未支付成功");
    		return resultMap;
    	}
    	
    	TdPayDWEIXINLOG record = list.get(0);
    	record.setReqType("04");
    	String logId = CommonUtil.generateLogId("2");
    	record.setLogId(CommonUtil.string2Long(logId));
    	record.setPartitionId(Short.parseShort(CommonUtil.getPartitionId(logId)));
    	record.setOutRefundNo(UUID.randomUUID().toString().replaceAll("-", ""));
    	record.setRefundFee(record.getTotalFee());
    	record.setReturnCode("");
    	record.setReturnMsg("");
    	record.setResultCode("");
    	record.setErrCode("");
    	record.setErrCodeDes("");
    	record.setSign("");
    	// 插入退款记录
    	tdPayDWEIXINLOGDao.insertSelective(record);
    	
    	// 发起流程， 等待响应
    	// 响应后更新退款记录
    	RefundReqData req = new RefundReqData(record.getTransactionId(), record.getOuterTradeNo(), "", record.getOutRefundNo(), 
    			record.getTotalFee()/10, record.getRefundFee()/10, Configure.getMchid());
    	WXPay.doRefundBusiness(req, new RefundResultListener(resultMap));
		
		return resultMap;
    }
    
    
    class RefundResultListener implements com.ai.wxpay.business.RefundBusiness.ResultListener {

    	private Map<String, String> map;
    	RefundResultListener(Map<String, String> resultMap) {
    		map = resultMap;
    	}
    	
		@Override
		public void onFailByReturnCodeError(RefundResData refundResData) {
			
		}

		@Override
		public void onFailByReturnCodeFail(RefundResData refundResData) {
			
		}

		@Override
		public void onFailBySignInvalid(RefundResData refundResData) {
			
		}

		@Override
		public void onRefundFail(RefundResData refundResData) {
			Criteria example = new Criteria();
	    	example.createConditon().andEqualTo("OUT_REFUND_NO", refundResData.getOut_refund_no()).andEqualTo("REQ_TYPE", "04");
			TdPayDWEIXINLOG record = new TdPayDWEIXINLOG();
			record.setReturnCode(refundResData.getReturn_code());
			record.setReturnMsg(refundResData.getReturn_msg());
			record.setResultCode(refundResData.getResult_code());
			record.setErrCode(refundResData.getErr_code());
			record.setErrCodeDes(refundResData.getErr_code_des());
	    	tdPayDWEIXINLOGDao.updateByExampleSelective(record, example);
	    	map.put("result_code", "FAIL");
	    	map.put("result_desc", refundResData.getErr_code_des());
		}

		@Override
		public void onRefundSuccess(RefundResData refundResData) {
			Criteria example = new Criteria();
	    	example.createConditon().andEqualTo("OUT_REFUND_NO", refundResData.getOut_refund_no()).andEqualTo("REQ_TYPE", "04");
			TdPayDWEIXINLOG record = new TdPayDWEIXINLOG();
			record.setReturnCode(refundResData.getReturn_code());
			record.setReturnMsg(refundResData.getReturn_msg());
			record.setResultCode(refundResData.getResult_code());
			record.setErrCode(refundResData.getErr_code());
			record.setErrCodeDes(refundResData.getErr_code_des());
	    	tdPayDWEIXINLOGDao.updateByExampleSelective(record, example);
	    	map.put("result_code", "SUCCESS");
	    	map.put("result_desc", "退款申请成功");
	    	
		}
    	
    }

}
