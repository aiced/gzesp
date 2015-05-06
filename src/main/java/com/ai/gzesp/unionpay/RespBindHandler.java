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

    //此方法作废，因为后来银联根据我们的要求改造代码
    //改造前esp系统单独有个签约信息表，每次支付前先查询是否曾经绑定成功过，有就直接取出签约号支付，没有则先绑定接口再支付接口，重复绑定会返回错误码
    //改造后每次支付我们都先绑定然后支付，不管是否曾经绑定成功，只要5要素都正确，绑定接口银联都返回成功和签约号，然后再用返回的签约号调支付接口
    @Override
/*    public void dealResp(Map<String, String> respMap) {
        //更新paylog日志表里的接口调用日志
        int r1 = unionPayService.updateBindlog(respMap);
        //如果应答码是00表示接口调用成功，需要插签约信息表，其他应答码都是有问题，直接返回报错信息给页面
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
            int r2 = unionPayService.updateSignCode(respMap);
        }
        else{
            
        }
    }*/
    
    //此为银联改造后新的逻辑方法，绑定接口返回后不再更新 签约信息表，只更新绑定接口日志，并且把签约号字段pay_acunt_no更新上
    public void dealResp(Map<String, String> respMap) {
    	
        //更新paylog日志表里的接口调用日志, 此处调用了new 的方法
        int r1 = unionPayService.updateBindlogNew(respMap);
    }

}
