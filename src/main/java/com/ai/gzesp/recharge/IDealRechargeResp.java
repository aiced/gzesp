package com.ai.gzesp.recharge;

import java.util.Map;

import com.ai.gzesp.dto.RechargeResp;

/**
 * 处理一卡充响应返回的接口<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IDealRechargeResp {
    
    /**
     * 处理返回的报文
     * 响应的包头已经转换成RechargeResp
     * 响应的包体还需要从 byte[] msg 里读取，因为不同接口响应包体不一样
     * @param resp
     * @param msg
     */
    public void dealResp(RechargeResp resp, byte[] msg);

}
