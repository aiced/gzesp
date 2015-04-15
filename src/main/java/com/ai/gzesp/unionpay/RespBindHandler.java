package com.ai.gzesp.unionpay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.UnionPayService;

/**
 * 处理 银行卡绑定 接口 响应报文<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespBindHandler implements IDealUnionPayResp {
    
    /**
     * 业务逻辑处理service
     */
    @Autowired
    private UnionPayService unionPayService;

    @Override
    public void dealResp(Map<String, String> respMap) {
        //更新paylog日志表里的接口调用日志
        int r1 = unionPayService.updateBindlog(respMap);
        //如果应答码是00表示接口调用成功，需要插签约信息表，其他应答码都是有问题，直接返回报错信息给页面
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
            int r2 = unionPayService.updateSignCode(respMap);
        }
        else{
            
        }
    }

}
