package com.ai.gzesp.recharge;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dto.RechargeResp;
import com.ai.gzesp.service.UnionPayService;

/**
 * 一卡充接口 响应处理类  的工厂类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RespHandler implements ApplicationContextAware{
    
    
    /**
     * spring 上下文
     */
    private static ApplicationContext ctx;


    /**
     * 根据resp里不同的接口类型，调用不同的处理类去处理响应
     * @param resp
     */
    public static void handlerResp(RechargeResp resp, byte[] msg){
        IDealRechargeResp respHanler = null;
        
        if(InterfaceType.active.getInterfaceCode().equals(resp.getInterfaceType())){
            respHanler = (IDealRechargeResp) ctx.getBean("respActiveHandler");
        }
        else if(InterfaceType.rechargeCheck.getInterfaceCode().equals(resp.getInterfaceType())){
            respHanler = (IDealRechargeResp) ctx.getBean("respRechargeCheckHandler");
        }
        else if(InterfaceType.recharge.getInterfaceCode().equals(resp.getInterfaceType())){
            respHanler = (IDealRechargeResp) ctx.getBean("respRechargeHandler");
        }
        else if(InterfaceType.check.getInterfaceCode().equals(resp.getInterfaceType())){
            respHanler = (IDealRechargeResp) ctx.getBean("respCheckHandler"); //全要素支付接口的处理函数和 老的支付接口 业务逻辑一致
        }
        else{
            
        }
        
        respHanler.dealResp(resp, msg);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        RespHandler.ctx = context;
    }
}
