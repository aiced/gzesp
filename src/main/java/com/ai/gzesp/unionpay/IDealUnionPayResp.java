package com.ai.gzesp.unionpay;

import java.util.Map;

/**
 * 处理银联响应返回的接口<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IDealUnionPayResp {
    
    /**
     * 处理返回的报文(已经转换成map格式)<br>
     * 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void dealResp();

}
