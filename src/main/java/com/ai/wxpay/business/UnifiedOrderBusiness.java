package com.ai.wxpay.business;

import com.ai.wxpay.common.Configure;
import com.ai.wxpay.common.Log;
import com.ai.wxpay.common.Signature;
import com.ai.wxpay.common.Util;
import com.ai.wxpay.common.report.ReporterFactory;
import com.ai.wxpay.common.report.protocol.ReportReqData;
import com.ai.wxpay.common.report.service.ReportService;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderReqData;
import com.ai.wxpay.protocol.unified_order_protocol.UnifiedOrderResData;
import com.ai.wxpay.service.UnifiedOrderService;

import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class UnifiedOrderBusiness {
	
	private UnifiedOrderService unifiedOrderService;

    public UnifiedOrderBusiness() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
    	unifiedOrderService = new UnifiedOrderService();
    }

    public interface ResultListener {

        //API返回ReturnCode不合法，支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问
        void onFailByReturnCodeError(UnifiedOrderResData resData);

        //API返回ReturnCode为FAIL，支付API系统返回失败，请检测Post给API的数据是否规范合法
        void onFailByReturnCodeFail(UnifiedOrderResData resData);

        //支付请求API返回的数据签名验证失败，有可能数据被篡改了
        void onFailBySignInvalid(UnifiedOrderResData resData);

        //支付失败
        void onFail(UnifiedOrderResData resData);

        //支付成功
        void onSuccess(UnifiedOrderResData resData);

    }

    //打log用
    private static Log log = new Log(LoggerFactory.getLogger(UnifiedOrderBusiness.class));

    public void run(UnifiedOrderReqData reqData, ResultListener resultListener) throws Exception {


        //接受API返回
        String responseString;

        long costTimeStart = System.currentTimeMillis();


        log.d("统一下单API返回的数据如下：");
        responseString = unifiedOrderService.request(reqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.d("api请求总耗时：" + totalTimeCost + "ms");

        //打印回包数据
        log.i(responseString);

        //将从API返回的XML数据映射到Java对象
        UnifiedOrderResData resData = (UnifiedOrderResData) Util.getObjectFromXML(responseString, UnifiedOrderResData.class);

//        //异步发送统计请求
//        //*
//
//        ReportReqData reportReqData = new ReportReqData(
//                scanPayReqData.getDevice_info(),
//                Configure.PAY_API,
//                (int) (totalTimeCost),//本次请求耗时
//                scanPayResData.getReturn_code(),
//                scanPayResData.getReturn_msg(),
//                scanPayResData.getResult_code(),
//                scanPayResData.getErr_code(),
//                scanPayResData.getErr_code_des(),
//                scanPayResData.getOut_trade_no(),
//                scanPayReqData.getSpbill_create_ip()
//        );
//        long timeAfterReport;
//        if (Configure.isUseThreadToDoReport()) {
//            ReporterFactory.getReporter(reportReqData).run();
//            timeAfterReport = System.currentTimeMillis();
//            log.i("pay+report总耗时（异步方式上报）：" + (timeAfterReport - costTimeStart) + "ms");
//        } else {
//            ReportService.request(reportReqData);
//            timeAfterReport = System.currentTimeMillis();
//            log.i("pay+report总耗时（同步方式上报）：" + (timeAfterReport - costTimeStart) + "ms");
//        }

        if (resData == null || resData.getReturn_code() == null) {
            log.e("【统一下单】请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            resultListener.onFailByReturnCodeError(resData);
            return;
        }

        if (resData.getReturn_code().equals("FAIL")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【统一下单】API系统返回失败，请检测Post给API的数据是否规范合法");
            resultListener.onFailByReturnCodeFail(resData);
            return;
        } else {
            log.d("统一下单API系统成功返回数据");
            //--------------------------------------------------------------------
            //收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
            //--------------------------------------------------------------------
            if (!Signature.checkIsSignValidFromResponseString(responseString)) {
                log.e("【统一下单】请求API返回的数据签名验证失败，有可能数据被篡改了");
                resultListener.onFailBySignInvalid(resData);
                return;
            }

            //获取错误码
            String errorCode = resData.getErr_code();
            //获取错误描述
            String errorCodeDes = resData.getErr_code_des();

            if (resData.getResult_code().equals("SUCCESS")) {

                log.d("【统一下单成功】");
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
