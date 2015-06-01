package com.ai.gzesp.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.PayDao;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;

/**
 * 支付公共服务类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class PayService {
    
    private static final Logger log = Logger.getLogger(PayService.class); 
    
    @Autowired
    private PayDao payDao;
    
    
    /**
     * 根据orderid查询能人店铺id
     * @param order_id
     * @return
     */
    public Map<Object, Object> queryUserIdByOrderId(String order_id) {
        return payDao.queryUserIdByOrderId(order_id);
    }
    

    
}
