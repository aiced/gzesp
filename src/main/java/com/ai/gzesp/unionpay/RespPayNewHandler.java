package com.ai.gzesp.unionpay;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.PayService;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 全要素支付接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespPayNewHandler implements IDealUnionPayResp {
    
    /**
     * 业务逻辑处理service
     */
    @Autowired
    private UnionPayService unionPayService;
    
    /**
     * 支付公共service
     */
    @Autowired
    private PayService payService;
    
    @Autowired
    private SelectNumberService selectNumberService;

    @Override
/*    public void dealResp(Map<String, String> respMap) {
    	
        //更新paylog日志表里的接口调用日志
        int r1 = unionPayService.updatePaylog(respMap);
        //更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
        int r2 = unionPayService.updatePayStateAndIncomeMoney(respMap);
        
        //20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
    	String realOrderId = UnionPayUtil.newOrderId2OrderId(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.sysTradeNo));
        //先根据返回报文里的order_id 获取到订单当时是否有选择号码
        //Map<Object, Object> numberRow = selectNumberService.getNumberByOrderId(respMap.get(UnionPayAttrs.orderId));
    	Map<Object, Object> numberRow = selectNumberService.getNumberByOrderId(realOrderId);
        //如果有号码而且返回响应是成功的则删掉号码预占表信息
        if(MapUtils.isNotEmpty(numberRow) && UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
        	//号码预占表删掉号码记录
        	String[] numbers = {(String) numberRow.get("SERIAL_NUMBER")}; 
        	int r3 = selectNumberService.deleteNumberReserve(numbers);
        }
    }*/
    
    public void dealResp(Map<String, String> respMap) {
    	
        //更新PAY_D_UNIONPAY_LOG日志表里的接口调用日志
        int r1 = unionPayService.updateUnionPaylog(respMap);
        
        boolean isSuccess = UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode));
        //20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
        String realOrderId = UnionPayUtil.newOrderId2OrderId(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.sysTradeNo));
        //银联支付返回的支付金额，单位是分, 插入表里是厘
        int fee = Integer.parseInt(respMap.get(UnionPayAttrs.txnAmt))*10;
        
        //调用公共service，做后续的统一的操作
        payService.afterPaySuccess("15", isSuccess, realOrderId, fee);
    }

}
