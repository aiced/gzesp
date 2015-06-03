package com.ai.gzesp.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.OrderService;

/**
 * 定时任务pojo类，库存数量销量都要相应返销
 * 每间隔一定时间执行一次，表示超时未支付等情况
 * 如果订单半小时后未支付，释放预占的号码，同时库存数量销量都要相应返销
 * 注意：这里只判断了订单表有记录，但是paylog支付表里没记录的情况，没有考虑paylog里支付失败或者没有收到响应的情况
 * @author xmh
 *
 */
@Service
public class GoodsAmountReverseTask {
	
    @Autowired
    private OrderService orderService;
	
	public void doJob(){
		//List<Map<Object, Object>> list =  orderService.queryOrdersTimeout();
		
		List<Map<Object, Object>> list =  orderService.queryOrdersTimeout2();
		
		if(CollectionUtils.isNotEmpty(list)){
			String[] orderIds = new String[list.size()];
			String[] goodIds = new String[list.size()];
			for(int i = 0; i< list.size(); i++){
				orderIds[i] = (String) list.get(i).get("ORDER_ID");
				goodIds[i] = (String) list.get(i).get("GOODS_ID");
			}
			
			//库存数量加回去，销量减回去，同时几个订单表里数据删掉
		    boolean flag = orderService.ordersTimeoutReverse(orderIds, goodIds);
		}
	}
}
