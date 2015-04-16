package com.ai.gzesp.unionpay;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.UnionPayService;

/**
 * 银联接口 响应处理类  的工厂类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespHandlerFactory implements ApplicationContextAware{
    
    
    /**
     * spring 上下文
     */
    private static ApplicationContext ctx;


    public static IDealUnionPayResp create(Map<String, String> respMap){
        IDealUnionPayResp respHanler = null;
        
        if(TradeType.bindRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespBindHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respBindHandler");
        }
        else if(TradeType.payRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayHandler");
        }
        else if(TradeType.payProxyRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayProxyHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayProxyHandler");
        }
        else if(TradeType.payCancelRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayCancelHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayCancelHandler");
        }
        else if(TradeType.payRefundRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayRefundHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayRefundHandler");
        }
        else if(TradeType.bindQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespBindQryHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respBindQryHandler");
        }
        else if(TradeType.payQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayQryHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayQryHandler");
        }
        else if(TradeType.payProxyQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayProxyQryHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayProxyQryHandler");
        }
        else if(TradeType.payCancelQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayCancelQryHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayCancelQryHandler");
        }
        else if(TradeType.payRefundQryRsp.getTradeType().equals(respMap.get(UnionPayAttrs.TradeType))){
            //respHanler = new RespPayRefundQryHandler(respMap, unionPayService);
            respHanler = (IDealUnionPayResp) ctx.getBean("respPayRefundQryHandler");
        }
        else{
            
        }
        
        return respHanler;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        RespHandlerFactory.ctx = context;
    }
}
