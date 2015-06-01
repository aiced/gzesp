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
    

    /**
     * 微信支付，沃支付，银联支付成功收到返回后，除了更新各自的log日志表外，还有一系列后续操作
     * 1.更新订单基本表里的 订单状态 和 实收总金额 INCOME_MONEY
     * 2.如果有号码预占而且支付返回响应是成功的则删掉号码预占表信息
     * @param param
     * @param result
     * @return
     */
    public void afterPaySuccess(UnionPayParam param, Map<String, String> result){

    }
    
    /**
     * 支付收到响应后更新订单基本表里订单状态
     * @param respMap
     * @return
     */
/*    public int updatePayStateAndIncomeMoney(boolean isSuccess, String orderId, String fee) {
    	int r2 = 0;
        if(isSuccess){
        	String order_state = "01"; //下单时是00，支付成功改成01，支付失败则不更新还是00
        	int income_money = Integer.parseInt(respMap.get(UnionPayAttrs.txnAmt))*10; //银联是分，表里是厘
        	//20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
        	String realOrderId = UnionPayUtil.newOrderId2OrderId(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.sysTradeNo));
        	//r2 = unionPayDao.updatePayStateAndIncomeMoney(respMap.get(UnionPayAttrs.orderId), order_state, income_money);
        	r2 = unionPayDao.updatePayStateAndIncomeMoney(realOrderId, order_state, income_money);
        }
        return r2;
    }*/
    
}
