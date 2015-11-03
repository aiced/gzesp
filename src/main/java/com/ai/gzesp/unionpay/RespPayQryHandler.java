package com.ai.gzesp.unionpay;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.PayService;
import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 支付结果查询接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespPayQryHandler implements IDealUnionPayResp {

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

    @Override
    public void dealResp(Map<String, String> respMap) {
        //更新PAY_D_UNIONPAY_LOG日志表里的接口调用日志
        int r1 = unionPayService.updateUnionPaylogAfterQry(respMap);
        
        boolean isSuccess = UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode));
        
        //20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
        String orderIdVir = respMap.get(UnionPayAttrs.orderId);
        //根据虚拟订单号，查出原来支付记录里的真实订单号
        Map<String, String> origOrder = unionPayService.queryRealOrderId(orderIdVir); 
        
        //银联支付返回的支付金额，单位是分, 插入表里是厘
        int fee = Integer.parseInt(respMap.get(UnionPayAttrs.txnAmt))*10;
        
        if(r1 > 0 && MapUtils.isNotEmpty(origOrder)){
        	String realOrderId = origOrder.get("REAL_ORDER_ID");
        	
        	//调用公共service，做后续的统一的操作
        	payService.afterPaySuccess("15", isSuccess, realOrderId, fee);
        }
        
    }

}
