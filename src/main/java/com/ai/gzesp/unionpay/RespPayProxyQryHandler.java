package com.ai.gzesp.unionpay;

import java.util.Map;

import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 代付结果查询接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RespPayProxyQryHandler implements IDealUnionPayResp {
    
    /**
     * 响应报文的map格式
     */
    private Map<String, String> respMap;
    
    /**
     * 业务逻辑处理service
     */
    private UnionPayService unionPayService;
    
    public RespPayProxyQryHandler(Map<String, String> respMap, UnionPayService unionPayService){
        this.respMap = respMap;
        this.unionPayService = unionPayService;
    }

    @Override
    public void dealResp() {

    }

}
