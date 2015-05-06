package com.ai.gzesp.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.unionpay.ServerHandler;

/**
 * 定时任务pojo类，释放预占超时的号码
 * 每间隔一定时间执行一次，查询号码预占表里有超过半小时的记录，表示超时未支付等情况
 * 根据号码恢复号码信息表里的状态为上架空闲，然后删除预占表的这些记录
 * @author xmh
 *
 */
@Service
public class ReleaseNumberTask {
	
    @Autowired
    private SelectNumberService selectNumberService;
	
	public void doJob(){
		List<Map<Object, Object>> list =  selectNumberService.queryNumbersTimeout();
		
		if(CollectionUtils.isNotEmpty(list)){
			String[] numbers = new String[list.size()];
			for(int i = 0; i< list.size(); i++){
				numbers[i] = (String) list.get(i).get("SERIAL_NUMBER");
			}
			//释放动作，操作两个表，事务控制 
			boolean flag = selectNumberService.releaseNumberState(numbers);
		}
	}

}
