package com.ai.gzesp.unionpay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void dealResp(Map<String, String> respMap) {
        //更新paylog日志表里的接口调用日志
        int r1 = unionPayService.updatePaylog(respMap);
        //更新订单基本表里的 订单状态
        int r2 = unionPayService.updatePayState(respMap);
    }

}