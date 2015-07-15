package com.ai.gzesp.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ai.gzesp.dao.RechargeDao;
import com.ai.gzesp.dto.RechargeBodyParam;
import com.ai.gzesp.recharge.InterfaceType;
import com.ai.gzesp.recharge.RechargeClientHandler;
import com.ai.gzesp.recharge.RechargeUtil;

/**
 * 充值缴费service
 * @author xmh
 *
 */
@Service
public class RechargeService {
	
    private static final Logger log = Logger.getLogger(RechargeService.class); 
    
    @Autowired
    private RechargeDao rechargeDao;
    
    @Autowired
    private RechargeClientHandler rechargeClientHandler;
	
	public void rechargeTx(String order_id, String serial_number, String serial_number_type, int total_fee){
		//l	A4交易类型（6位）： 010202，010203，010204，010205，010206，010201
		//l	A6业务号码:移动电话号码、固话号码、宽带帐号，小灵通/大灵通或固定值
		//l	A7业务号码类型(1位):1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
		//l	A13请求时间（12位）：YYMMDDHHMMSS
		//  A2流水号（20位）：业务流水号，标志每笔具体交易 String logId = generateLogId();
		log.debug("【一卡充】需要充值" + total_fee + "厘，开始计算充值卡面额组合");
		int temp_fee = total_fee/1000; //单位换成元
		//String logId = RechargeUtil.generateLogId();
		//String partitionId = logId.substring(14, 16);
		String reqTime = RechargeUtil.getCurentTime();
		
		//获取所有充值卡面额的组合
		List<Map<Integer, Integer>> groupsList = RechargeUtil.startCompute(temp_fee);
		//循环遍历去尝试各种组合，当一种组合库存满足的情况下，退出不再尝试后面的组合
		for(Map<Integer, Integer> map : groupsList){
			int num1 = 0; //应该使用总共num1张充值卡
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				num1 += entry.getValue();
				  }
			int num2 = rechargeDao.updateCardList(map, order_id); //这个组合在实际库存中只取到了num2张充值卡
			if(num2 == num1){
				log.debug("【一卡充】面额组合" + map + "需要使用" + num1 + "张，库存张数" + num2 + "满足要求");
				break;
			}
			else{
				log.debug("【一卡充】面额组合" + map + "，库存张数" + num2 + "不够，数据库回滚，尝试下一个组合");
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
				continue;
			}
		}
		
		//获取刚刚update占用的卡号的组合
		List<Map<String, String>> cardList = rechargeDao.getUseCardList(order_id);
		for(Map<String, String> card : cardList){
			String logId = RechargeUtil.generateLogId(); //每张卡插的记录logid不一致
			card.put("LOG_ID", logId);
			card.put("PARTITION_ID", logId.substring(14, 16));
		}
		
		//调用一卡充接口前先插入接口日志表，状态等待响应返回再更新
		rechargeDao.insertRechargeLogBatch(
				order_id, 
				reqTime, 
				InterfaceType.recharge.getInterfaceCode(),
				"01",   //00为空中充值，01为一卡充业务。目前只填01
				serial_number,
				serial_number_type,  //业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
				cardList
				);
		
		//每张卡挨个调用一卡充接口，是否可以for循环调用接口
		for(Map<String, String> card : cardList){
			RechargeBodyParam param = new RechargeBodyParam();
			param.setChargeMoney(card.get("CARD_VALUE"));
			param.setAgentID(card.get("CARD_NO"));
			param.setPasword(card.get("CARD_PASSWORD"));
			param.setSerialNum(card.get("LOG_ID")); //这个不是填手机号，是填流水号
			//生成请求报文
			String req = RechargeUtil.genReq(param, 
					card.get("LOG_ID"), InterfaceType.recharge.getInterfaceCode(), 
					serial_number, serial_number_type, reqTime);
			//发送报文
			rechargeClientHandler.sendMsg(req.getBytes()); 
		}
	}
	
	
	/**
	 * 根据响应报文里的logid，更新接口日志表里的记录状态
	 * @param logId
	 * @return
	 */
	public int updateRechargeLog(String log_id, String success_flag, String result_code,
			String agent_balance, String unicon_serial_num){
		return rechargeDao.updateRechargeLog(log_id, success_flag, result_code,
				agent_balance, unicon_serial_num);
	}
  
	
	
	
	public static void main(String[] args) {
		int total_fee = 1000;
	    int[] array = {1000, 500, 300, 100};
	    
/*	    Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
	    
	    compute(total_fee, 0, groups);*/
		
		System.out.println(Math.floor(total_fee/array[0]));
		System.out.println((int)Math.floor(total_fee/array[0]));
	}
}
