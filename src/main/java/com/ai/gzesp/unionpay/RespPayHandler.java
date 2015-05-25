package com.ai.gzesp.unionpay;

import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 支付接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespPayHandler implements IDealUnionPayResp {
    
    /**
     * 业务逻辑处理service
     */
    @Autowired
    private UnionPayService unionPayService;
    
    @Autowired
    private SelectNumberService selectNumberService;

    @Override
    public void dealResp(Map<String, String> respMap) {
    	
        //更新paylog日志表里的接口调用日志
        int r1 = unionPayService.updatePaylog(respMap);
        //更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
        int r2 = unionPayService.updatePayStateAndIncomeMoney(respMap);
        
        //先根据返回报文里的order_id 获取到订单当时是否有选择号码
        Map<Object, Object> numberRow = selectNumberService.getNumberByOrderId(respMap.get(UnionPayAttrs.orderId));
        //如果有号码而且返回响应是成功的则删掉号码预占表信息
        if(MapUtils.isNotEmpty(numberRow) && UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
        	//号码预占表删掉号码记录
        	String[] numbers = {(String) numberRow.get("SERIAL_NUMBER")}; 
        	int r3 = selectNumberService.deleteNumberReserve(numbers);
        }
    }

}
