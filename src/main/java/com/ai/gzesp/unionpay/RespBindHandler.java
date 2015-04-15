package com.ai.gzesp.unionpay;

import java.util.Map;

import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 银行卡绑定 接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RespBindHandler implements IDealUnionPayResp {
    
    /**
     * 响应报文的map格式
     */
    private Map<String, String> respMap;
    
    /**
     * 业务逻辑处理service
     */
    private UnionPayService unionPayService;
    
    public RespBindHandler(Map<String, String> respMap, UnionPayService unionPayService){
        this.respMap = respMap;
        this.unionPayService = unionPayService;
    }

    @Override
    public void dealResp() {
        //如果应答码是00表示接口调用成功，其他应答码都是有问题，直接返回报错信息给页面
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
            //unionPayService
        }
        else{
            
        }
    }

}
