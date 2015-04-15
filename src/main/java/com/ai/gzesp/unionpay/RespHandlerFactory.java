package com.ai.gzesp.unionpay;

import java.util.Map;

import com.ai.gzesp.service.UnionPayService;

/**
 * 银联接口 响应处理类  的工厂类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RespHandlerFactory {

    public static IDealUnionPayResp create(Map<String, String> respMap, UnionPayService unionPayService){
        IDealUnionPayResp respHanler = null;
        
        if(TradeType.bindRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespBindHandler(respMap, unionPayService);
        }
        else if(TradeType.payRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayHandler(respMap, unionPayService);
        }
        else if(TradeType.payProxyRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayProxyHandler(respMap, unionPayService);
        }
        else if(TradeType.payCancelRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayCancelHandler(respMap, unionPayService);
        }
        else if(TradeType.payRefundRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayRefundHandler(respMap, unionPayService);
        }
        else if(TradeType.bindQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespBindQryHandler(respMap, unionPayService);
        }
        else if(TradeType.payQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayQryHandler(respMap, unionPayService);
        }
        else if(TradeType.payProxyQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayProxyQryHandler(respMap, unionPayService);
        }
        else if(TradeType.payCancelQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayCancelQryHandler(respMap, unionPayService);
        }
        else if(TradeType.payRefundQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            respHanler = new RespPayRefundQryHandler(respMap, unionPayService);
        }
        else{
            
        }
        
        return respHanler;
    }
}
