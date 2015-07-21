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
 * 注意：这里只判断了订单表有记录，但是ord_d_pay表里没记录 或 ord_d_pay里支付失败2的情况，
 *       如果选择了支付方式，但是没进行支付下去，则不会被回收变99
 *       
 * 20150720 ximh 改成：
 * 判断ord_d_base 里 order_state = '00'的。
 * 不再判断ord_d_pay，因为能人代客下单支付ord_d_pay会不只一条记录，会关联出多条
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
