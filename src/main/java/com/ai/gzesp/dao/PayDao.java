package com.ai.gzesp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 支付公共接口dao<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface PayDao {
    

    public Map<Object, Object> queryUserIdByOrderId(@Param("order_id") String order_id);
    

}
