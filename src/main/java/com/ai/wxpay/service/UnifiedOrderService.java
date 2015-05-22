package com.ai.wxpay.service;

import com.ai.wxpay.common.Configure;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;

public class UnifiedOrderService extends BaseService{

    public UnifiedOrderService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.UNIFIED_PAY_API);
    }

    public String request(UnifiedOrderReqData reqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(reqData);

        return responseString;
    }
}
