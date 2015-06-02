package com.ai.wxpay.business;

import org.slf4j.LoggerFactory;

import com.ai.wxpay.common.Log;
import com.ai.wxpay.common.Signature;
import com.ai.wxpay.common.Util;
import com.ai.wxpay.protocol.unified_order_protocol.CallbackResData;

public class CallbackBusiness {
	
    public interface ResultListener {
        //支付失败
        void onFail(CallbackResData resData);

        //支付成功
        void onSuccess(CallbackResData resData);

    }

    //打log用
    private static Log log = new Log(LoggerFactory.getLogger(CallbackBusiness.class));

    public void run(String responseString, ResultListener resultListener) throws Exception {

        //打印回包数据
        log.i(responseString);

        //将从API返回的XML数据映射到Java对象
        CallbackResData resData = (CallbackResData) Util.getObjectFromXML(responseString, CallbackResData.class);

        if (resData == null || resData.getReturn_code() == null) {
            log.e("【支付结果通用通知】返回失败");
//            resultListener.onFail(resData);
            return;
        }

        if (resData.getReturn_code().equals("FAIL")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【支付结果通用通知】返回失败");
//            resultListener.onFail(resData);
            return;
        } else {
            log.d("支付结果通用通知API系统成功返回数据");
            //--------------------------------------------------------------------
            //收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
            //--------------------------------------------------------------------
            if (!Signature.checkIsSignValidFromResponseString(responseString)) {
                log.e("【支付结果通用通知】请求API返回的数据签名验证失败，有可能数据被篡改了");
//                resultListener.onFail(resData);
                return;
            }

            //获取错误码
            String errorCode = resData.getErr_code();
            //获取错误描述
            String errorCodeDes = resData.getErr_code_des();

            if (resData.getResult_code().equals("SUCCESS")) {

                log.d("【支付结果通用通知成功】");
                resultListener.onSuccess(resData);
            }else{

                //出现业务错误
                log.d("业务返回失败");
                log.d("err_code:" + errorCode);
                log.d("err_code_des:" + errorCodeDes);

                resultListener.onFail(resData);
            }
        }
    }

}
