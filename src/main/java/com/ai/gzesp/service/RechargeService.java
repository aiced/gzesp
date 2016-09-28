package com.ai.gzesp.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ai.gzesp.dao.RechargeDao;
import com.ai.gzesp.dto.RechargeReq;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.recharge.FileUtils;
import com.ai.gzesp.recharge.InterfaceType;
import com.ai.gzesp.recharge.RechargeClientHandler;
import com.ai.gzesp.recharge.RechargeCons;
import com.ai.gzesp.recharge.RechargeIntfCons;
import com.ai.gzesp.recharge.RechargeUtil;
import com.ai.gzesp.recharge.ResultCode;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.utils.Base64Utils;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.EncryptUtil;
import com.ai.sysframe.utils.CommonUtil;
import com.alibaba.fastjson.JSON;

/**
 * 充值缴费service
 * @author xmh
 *
 */
@Service
public class RechargeService {
	
    private static final Logger log = Logger.getLogger(RechargeService.class); 
    
    private static int CARDS_LIMIT= 100; //每次定时任务激活卡的张数上限，避免一次任务执行时间过长
    
    @Autowired
    private RechargeDao rechargeDao;
    
    @Autowired
    private RechargeClientHandler rechargeClientHandler;
    
    /**
     * 充值前，验证充值号码是否可以被充值
     * @param serial_number
     * @param serial_number_type
     * @return
     */
    public Map<String, String> rechargeCheck(String serial_number, String serial_number_type){
    	log.debug("【一卡充】充值号码验证：" + serial_number);
    	Map<String, String> result = new HashMap<String, String>();
    	
    	String reqTime = RechargeUtil.getCurentTime();
		String logId = RechargeUtil.generateLogId(1); //每张卡插的记录logid不一致
		String partitionId = logId.substring(14, 16);
		
		try {
			//调接口前插日志
			int n1 = insertRechargeCheckLog(logId, partitionId, serial_number, serial_number_type, reqTime);
			
			//拼接口参数，发送请求
			RechargeReq param = new RechargeReq();
			param.setAccountNumber(serial_number);
			param.setSerialNum(logId);
			
			//生成请求报文
			String req = RechargeUtil.genReq(param, InterfaceType.rechargeCheck.getInterfaceCode(), 
					serial_number, serial_number_type, reqTime); 
			
			log.debug("【一卡充】充值号码验证最终请求报文：" + req);
			//发送报文
			rechargeClientHandler.sendMsg(req.getBytes());
			
			waitForRechargeCheckResp(logId, "充值号码验证", result);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", com.ai.gzesp.dto.ResultCode.ERR2010.getResultCode());
            result.put("detail", com.ai.gzesp.dto.ResultCode.ERR2010.getResultName());
		}
		
		return result;
    }
    
    /**
     * 发送充值号码验证接口后等待响应返回
     * @param log_id
     * @param result
     * @return
     */
    public void waitForRechargeCheckResp(String log_id, String log_tip, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= RechargeCons.WAIT_TIMEOUT){
                result.put("status", com.ai.gzesp.dto.ResultCode.ERR2013.getResultCode());
                result.put("detail", "接口调用失败！发送" + log_tip + "报文后未接收到一卡充响应");
                break;
            }
            try {
                Thread.sleep(RechargeCons.SLEEP_INTERVAL_RECHARGE);
                timeout += RechargeCons.SLEEP_INTERVAL_RECHARGE;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待1秒钟
            Map<String, String> row = rechargeDao.queryRechargeResult(log_id, InterfaceType.rechargeCheck.getInterfaceCode()); //查询日志表里是否已经有返回的结果
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                result.put("status", row.get("RESULT_CODE"));
                result.put("detail", ResultCode.find(row.get("RESULT_CODE")));
                break;
            }
        }
        
        //return result;
    } 
    
    /**
     * 发送充值查询接口后等待响应返回
     * 根据原充值流水号查询
     * @param log_id
     * @param result
     * @return
     */
    public void waitForRechargeRqyResp(String log_id, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= RechargeCons.WAIT_TIMEOUT){
                result.put("status", com.ai.gzesp.dto.ResultCode.ERR2013.getResultCode());
                result.put("detail", "接口调用失败！发送充值查询接口报文后未接收到一卡充响应");
                break;
            }
            try {
                Thread.sleep(RechargeCons.SLEEP_INTERVAL_RECHARGE);
                timeout += RechargeCons.SLEEP_INTERVAL_RECHARGE;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待1秒钟
            Map<String, String> row = rechargeDao.queryRechargeRqyResultByLogId(log_id); //查询日志表里是否已经有返回的结果
            if(row != null && StringUtils.isNotBlank(row.get("CHARGE_RESULT"))){
//                result.put("CHARGE_RESULT", row.get("CHARGE_RESULT"));
//                result.put("CHARGE_VALUE", row.get("CHARGE_VALUE"));
            	result.put("status", row.get("CHARGE_RESULT"));
                result.put("detail", row.get("CHARGE_VALUE"));
                break;
            }
        }
        
        //return result;
    } 
    
    
    /**
     * 发送充值接口后等待响应返回
     * @param order_id
     * @param result
     * @return
     */
    public void waitForRechargeResp(String order_id, String log_tip, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= RechargeCons.WAIT_TIMEOUT){
                result.put("status", com.ai.gzesp.dto.ResultCode.ERR2013.getResultCode());
                result.put("detail", "接口调用失败！发送" + log_tip + "报文后未接收到一卡充响应");
                break;
            }
            try {
                Thread.sleep(RechargeCons.SLEEP_INTERVAL_RECHARGE);
                timeout += RechargeCons.SLEEP_INTERVAL_RECHARGE;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待1秒钟
            Map<String, String> row = rechargeDao.queryRechargelogResultByOrderId(order_id); //查询日志表里是否已经有返回的结果
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                result.put("status", row.get("RESULT_CODE")); //这边用的是一卡车的返回码，不是esp自定义的ResultCode
                result.put("detail", ResultCode.find(row.get("RESULT_CODE")));
                //result.put("logId", row.get("LOG_ID")); //充值接口需要返回logid，后续可以查询
                break;
            }
        }
        
        //return result;
    }     
    
    
    /**
     * 激活卡 任务调度方法
     * 一次激活全部卡且<=100张
     */
    public void activeCardsJob(){
    	log.debug("【一卡充】激活卡任务开始。。。");
    	int  cards = 0;
    	while(true){
			if(cards >= CARDS_LIMIT){
				break; //如果已经超过单次任务的上限了，退出循环
			}
			
			List<Map<String, String>> cardList = rechargeDao.getUnActiveCardList(null, null); //每次取20张卡
			if(CollectionUtils.isEmpty(cardList)){
				break; //如果捞不到未激活的卡，退出循环
			}
			
			activeCards(cardList); //激活这批卡
			
			cards += cardList.size(); 
			
			try {
				//等待30秒，保证这次20张卡都收到响应并更新了卡状态后再执行下次循环
				Thread.sleep(30*1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    	log.debug("【一卡充】激活卡任务结束。共激活" + cards + "张卡。");
    }
    
    /**
     * 激活某一面值的卡，比如20面值的没有了，需要激活部分20面值的卡
     * 一次激活全部卡且<=100张
     */
    public void activeCards(String card_value){
    	log.debug("【一卡充】激活面值" + card_value + "元卡开始。。。");
    	int  cards = 0;
    	while(true){
			if(cards >= CARDS_LIMIT){
				break; //如果已经超过单次任务的上限了，退出循环
			}
			
			List<Map<String, String>> cardList = rechargeDao.getUnActiveCardList(card_value, null); //每次取20张卡
			if(CollectionUtils.isEmpty(cardList)){
				break; //如果捞不到未激活的卡，退出循环
			}
			
			activeCards(cardList); //激活这批卡
			
			cards += cardList.size(); 
			
			try {
				//等待30秒，保证这次20张卡都收到响应并更新了卡状态后再执行下次循环
				Thread.sleep(30*1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    	log.debug("【一卡充】激活卡任务结束。共激活" + cards + "张卡。");
    }
    
    /**
     * 激活单张卡 任务
     * card_no不为空时，支持激活单张卡
     * @param card_no
     */
    public void activeCard(String card_no){
    	log.debug("【一卡充】激活卡任务开始。。。");
    	int  cards = 0;
    	List<Map<String, String>> cardList = rechargeDao.getUnActiveCardList(null ,card_no); //每次取20张卡
		if(CollectionUtils.isEmpty(cardList)){
			return; //如果捞不到未激活的卡，退出
		}
		activeCards(cardList); //激活这批卡
		cards += cardList.size(); 
    	
    	log.debug("【一卡充】激活卡任务结束。共激活" + cards + "张卡。");
    }
    
    /**
     * 激活一批卡：循环调用一卡充激活接口
     * @param cardList
     */
    private void activeCards(List<Map<String, String>> cardList){
    	String reqTime = RechargeUtil.getCurentTime();
        //调接口前批量插激活接口日志
    	insertActiveLogBatch(cardList, reqTime);
		
    	//循环调用激活接口，一张张的激活，没有批量激活接口
    	for(Map<String, String> map : cardList){
    		RechargeReq param = new RechargeReq();
    		param.setAgentID(map.get("CARD_NO"));
    		param.setPasword(map.get("CARD_PASSWORD"));
    		param.setSerialNum(map.get("LOG_ID")); //这个不是填手机号，是填流水号，insertActiveLogBatch里生成的
    		
    		activeCard(param);
    	}
    }
    
    /**
     * 激活单张卡
     * @param param
     */
    private void activeCard(RechargeReq param){
    	log.debug("【一卡充】激活卡：" + param.getAgentID());
    	
    	String reqTime = RechargeUtil.getCurentTime();
    	//生成请求报文
		String req = RechargeUtil.genReq(param, InterfaceType.active.getInterfaceCode(), 
				null, null, reqTime);
		
		log.debug("【一卡充】激活卡最终请求报文：" + req);
		//发送报文
		rechargeClientHandler.sendMsg(req.getBytes()); 
    }
	
	/**
	 * 充值接口
	 * 入参total_fee单位元
	 * 返回map 
     * {"status":"00000", "detail":"充值请求成功"}
	 * {"status":"FAIL", "detail":"充值失败，一卡充接口调用异常"}
	 * 
	 * @param order_id
	 * @param serial_number
	 * @param serial_number_type
	 * @param total_fee
	 */
	public Map<String, String> recharge(String order_id, String serial_number, String serial_number_type, int total_fee){
		//l	A4交易类型（6位）： 010202，010203，010204，010205，010206，010201
		//l	A6业务号码:移动电话号码、固话号码、宽带帐号，小灵通/大灵通或固定值
		//l	A7业务号码类型(1位):1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
		//l	A13请求时间（12位）：YYMMDDHHMMSS
		//  A2流水号（20位）：业务流水号，标志每笔具体交易 String logId = generateLogId();
		
		Map<String, String> result = new HashMap<String, String>();
		
		String reqTime = RechargeUtil.getCurentTime();
		
		//锁定对应面额的卡，如果锁定成功了再继续调用充值接口
		boolean lockSuccess = lockCard(total_fee, order_id);
		if(lockSuccess){
			try {
				//获取刚刚update占用的卡号的组合
				List<Map<String, String>> cardList = rechargeDao.getUseCardList(order_id);
				//调接口前批量插日志
				insertRechargeLogBatch(cardList, order_id, reqTime, serial_number, serial_number_type);
				//调用充值接口
				rechargeCards(cardList, serial_number, serial_number_type);
				
				//等待一卡充响应结果
				waitForRechargeResp(order_id, "充值接口", result);
				
			} catch (Exception e) {
				e.printStackTrace();
				result.put("status", com.ai.gzesp.dto.ResultCode.ERR2010.getResultCode());
	            result.put("detail", com.ai.gzesp.dto.ResultCode.ERR2010.getResultName());
			}
		}
		else{
			result.put("status", com.ai.gzesp.dto.ResultCode.ERR2012.getResultCode());
            result.put("detail", com.ai.gzesp.dto.ResultCode.ERR2012.getResultName());
		}
		
		return result;
	}
	
	/**
	 * 根据 输入的充值金额，和订单id，
	 * 1.算出满足充值金额的各种面值组合，并按张数排优先级
	 * 2.根据组合，去卡库存表里 锁定一批卡，因为可能某种面额的卡库存不足，所以循环尝试锁定各种组合，直到锁定为止
	 * @param total_fee
	 * @param order_id
	 */
	private void lockCards(int total_fee, String order_id){
		log.debug("【一卡充】需要充值" + total_fee + "元，开始计算充值卡面额组合");
		//int temp_fee = total_fee/1000; //单位换成元
		//获取所有充值卡面额的组合
		List<Map<Integer, Integer>> groupsList = RechargeUtil.startCompute(total_fee);
		//循环遍历去尝试各种组合，当一种组合库存满足的情况下，退出不再尝试后面的组合
		for(Map<Integer, Integer> map : groupsList){
			int num1 = 0; //应该使用总共num1张充值卡
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				num1 += entry.getValue();
				  }
			int num2 = rechargeDao.lockCardList(map, order_id); //这个组合在实际库存中只取到了num2张充值卡
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
	}
	
	private boolean lockCard(int card_value, String order_id){
		//int temp_fee = total_fee/1000; //单位换成元
		int num1 = rechargeDao.lockCard(card_value, order_id); //实际库存中锁定了num1张充值卡
		log.debug("【一卡充】需要充值" + card_value + "元, 订单id：" + order_id + ",锁定了" + num1 + "张库存卡");
		return num1 == 1 ? true : false;
	}
	
    /**
     * 用一批卡充值话费：循环调用一卡充充值接口
     * @param cardList
     */
    private void rechargeCards(List<Map<String, String>> cardList, String serial_number, String serial_number_type){
    	String reqTime = RechargeUtil.getCurentTime();
		
		//每张卡挨个调用一卡充接口，是否可以for循环调用接口
		for(Map<String, String> card : cardList){
			RechargeReq param = new RechargeReq();
			param.setChargeMoney(card.get("CARD_VALUE"));
			param.setAgentID(card.get("CARD_NO"));
			param.setPasword(card.get("CARD_PASSWORD"));
			param.setSerialNum(card.get("LOG_ID")); //这个不是填手机号，是填流水号，insertRechargeLogBatch里生成的

			rechargeCard(param, serial_number, serial_number_type); //单张卡充值
		}
    }
    
    /**
     * 用单张卡充值
     * @param param
     */
    private void rechargeCard(RechargeReq param, String serial_number, String serial_number_type){
    	log.debug("【一卡充】充值,用户号码:" + serial_number + ",充值卡号:" + param.getAgentID() + "充值金额:" + param.getChargeMoney());
    	
    	String reqTime = RechargeUtil.getCurentTime();
		//生成请求报文
		String req = RechargeUtil.genReq(param, InterfaceType.recharge.getInterfaceCode(), 
				serial_number, serial_number_type, reqTime);
		//发送报文
		rechargeClientHandler.sendMsg(req.getBytes()); 
    }
    
	/**
	 * 批量插激活接口日志
	 * @param cardList
	 * @param interfaceCode
	 * @param order_id
	 * @param reqTime
	 * @param serial_number
	 * @param serial_number_type
	 */
	private int insertRechargeCheckLog(String log_id, String partition_id, String serial_number, String serial_number_type, String reqTime){
		
		//调用一卡充接口前先插入接口日志表，状态等待响应返回再更新
		return rechargeDao.insertRechargeCheckLog(
				log_id,
				partition_id,
				reqTime, 
				InterfaceType.rechargeCheck.getInterfaceCode(),
				serial_number,
				serial_number_type
				);
	}
	
	/**
	 * 批量插激活接口日志
	 * @param cardList
	 * @param interfaceCode
	 * @param order_id
	 * @param reqTime
	 * @param serial_number
	 * @param serial_number_type
	 */
	private int insertRechargeQryLog(String log_id, String partition_id, String serial_number, String serial_number_type, String reqTime, String charge_serial_num){
		
		//调用一卡充接口前先插入接口日志表，状态等待响应返回再更新
		return rechargeDao.insertRechargeQryLog(
				log_id,
				partition_id,
				reqTime, 
				InterfaceType.rechargeQry.getInterfaceCode(),
				serial_number,
				serial_number_type,
				charge_serial_num
				);
	}
	
	/**
	 * 批量插充值接口日志
	 * @param cardList
	 * @param interfaceCode
	 * @param order_id
	 * @param reqTime
	 * @param serial_number
	 * @param serial_number_type
	 */
	private void insertRechargeLogBatch(List<Map<String, String>> cardList, String order_id, String reqTime, String serial_number, String serial_number_type){
		//String reqTime = RechargeUtil.getCurentTime();
		
		for(Map<String, String> card : cardList){
			String logId = RechargeUtil.generateLogId(2); //每张卡插的记录logid不一致
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
	}
	
	/**
	 * 批量插激活接口日志
	 * @param cardList
	 * @param interfaceCode
	 * @param order_id
	 * @param reqTime
	 * @param serial_number
	 * @param serial_number_type
	 */
	private void insertActiveLogBatch(List<Map<String, String>> cardList, String reqTime){
		//String reqTime = RechargeUtil.getCurentTime();
		String logId = RechargeUtil.generateLogId(3); //logid开始初始值，下面每张+1
		
		for(Map<String, String> card : cardList){
			logId = String.valueOf(Long.parseLong(logId) + 1);//RechargeUtil.generateLogId(3); //每张卡插的记录logid不一致
			card.put("LOG_ID", logId); //每张+1
			card.put("PARTITION_ID", logId.substring(14, 16));
		}
		
		//调用一卡充接口前先插入接口日志表，状态等待响应返回再更新
		rechargeDao.insertActiveLogBatch(
				reqTime, 
				InterfaceType.active.getInterfaceCode(),
				"01",   //00为空中充值，01为一卡充业务。目前只填01
				cardList
				);
	}	
	
	
	/**
	 * 根据响应报文里的logid，更新接口日志表里的记录状态
	 * @param log_id
	 * @param success_flag
	 * @param result_code
	 * @param agent_balance
	 * @param unicon_serial_num
	 * @param charge_status
	 * @return
	 */
	public int updateRechargeLog(String log_id, String success_flag, String result_code,
			String agent_balance, String unicon_serial_num, String charge_status){
		return rechargeDao.updateRechargeLog(log_id, success_flag, result_code,
				agent_balance, unicon_serial_num, charge_status);
	}
	
	public int updateRechargeRqyLog(String log_id, String charge_result, String charge_value){
		return rechargeDao.updateRechargeRqyLog(log_id, charge_result, charge_value);
	}
	
	/**
	 * 根据激活接口响应结果更新卡的 激活状态
	 * @param card_no
	 * @param card_status
	 * @return
	 */
	public int updateRechargeCard(String card_no, String card_status){
		return rechargeDao.updateRechargeCard(card_no, card_status);
	}
	
	/**
	 * 根据对账响应报文里的充值流水，更新接口日志表里 原充值记录的 对账结果字段 chekc_status
	 * @param log_id
	 * @param charge_status
	 * @return
	 */
	public int updateCheckStatus(String log_id, String charge_status){
		return rechargeDao.updateCheckStatus(log_id, charge_status);
	}
  
	/**
	 * 激活接口响应返回后，响应包里没有卡号信息，
	 * 只能从已经更新了结果的 itf_d_recharge_log表里根据log_id获取 卡号，来更新inv_d_recharge_card表的状态
	 * @param log_id
	 * @return
	 */
	public Map<String, String> getActiveLog(String log_id){
		return rechargeDao.getActiveLog(log_id);
	}	
	

    /**
     * 对账定时任务入口
     * 如果log_id为null，全部对账，每次取20条未对账的充值记录进行对账，循环获取直到全部充值记录对账完成。
     */
    public void checkBillJob(){
    	log.debug("【一卡充】对账任务开始。。。");
    	int  num = 0;
		while(true){
			
			List<Map<String, String>> logList = rechargeDao.getRechargeLogList(null); //每次取20张卡
			if(CollectionUtils.isEmpty(logList)){
				break; //如果捞不到未对账的卡，退出循环
			}
			
			checkRechargeLogs(logList); //对账
			
			num += logList.size(); 
			
			try {
				//等待30秒，保证这次20张卡都收到响应并更新了数据库表对账结果后再执行下次循环
				Thread.sleep(30*1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    	log.debug("【一卡充】对账任务结束。共对账" + num + "条充值记录。");
    }
    
    /**
     * 对账定时任务入口
     * 如果log_id不为null，则只对账这一条充值记录
     * @param log_id
     */
    public void checkBill(String log_id){
    	log.debug("【一卡充】对账任务开始。。。");
    	int  num = 0;
		List<Map<String, String>> logList = rechargeDao.getRechargeLogList(log_id); //每次取20张卡
		if(CollectionUtils.isEmpty(logList)){
			return; //如果捞不到未对账的卡，退出
		}
		checkRechargeLogs(logList); //对账
		num += logList.size(); 
    	
    	log.debug("【一卡充】对账任务结束。共对账" + num + "条充值记录。");
    }
    
    /**
     * 对账一批充值记录：循环调用一卡充对账接口
     * @param logList
     */
    private void checkRechargeLogs(List<Map<String, String>> logList){
    	String reqTime = RechargeUtil.getCurentTime();
        //调对账接口前，不插接口日志记录，直接等响应回来更新充值记录的check_status字段
    	//insertActiveLogBatch(cardList, reqTime);
    	String logId = RechargeUtil.generateLogId(5); //每张卡插的记录logid不一致,下面每张+1
		for(Map<String, String> log : logList){
			logId = String.valueOf(Long.parseLong(logId) + 1);
			log.put("NEW_LOG_ID", logId);
			//log.put("PARTITION_ID", logId.substring(14, 16));
		}
		
    	//循环调用激活接口，一张张的激活，没有批量激活接口
    	for(Map<String, String> map : logList){
    		RechargeReq param = new RechargeReq();
    		param.setAgentID(map.get("CARD_NO"));
    		param.setAccountNumber(map.get("SERIAL_NUMBER"));
    		param.setSerialNum(map.get("NEW_LOG_ID")); //接口调用流水号
    		param.setChargeSerilNum(map.get("LOG_ID")); //原充值流水号
    		
    		checkRechargeLog(param);
    	}
    }
    
    /**
     * 对账：对单条充值记录
     * @param param
     */
    private void checkRechargeLog(RechargeReq param){
    	log.debug("【一卡充】对账,用户号码:" + param.getAccountNumber() + ",充值卡号:" + param.getAgentID() + "原充值流水:" + param.getChargeSerilNum());
    	
    	String reqTime = RechargeUtil.getCurentTime();
		//生成请求报文
		String req = RechargeUtil.genReq(param, InterfaceType.check.getInterfaceCode(), 
				null, null, reqTime);
		//发送报文
		rechargeClientHandler.sendMsg(req.getBytes()); 
    }
    
    /**
     * 每天凌晨1点，沃掌柜和bss系统 同步一卡充状态 任务
     * 每次获取前一整天，充值过的卡记录，生成txt文件，放到/home/webapp/app/interface/card/req目录下
     * 
     * 20160607 修改，每天传送上一天销售充值过的卡给bss
     */
    public void syncCardStatus2BssJob(){
    	String req_day = DateUtils.getYesterday();
    	List<LinkedHashMap<String, String>> cardList = rechargeDao.getRechargedCardList();
    	FileUtils.writeCardReqFile(req_day, cardList);
    }
    
    /**
     * bss系统给沃掌柜的回执文件，需要定时任务读取
     * 每天凌晨1点，沃掌柜和bss系统 同步一卡充状态 任务
     * 每次获取前一整天，充值过的卡记录，生成txt文件，放到/home/webapp/app/interface/card/req目录下
     */
    public void syncCardStatus2BssRespJob(){
    	String req_day = DateUtils.getYesterday();
    	List<String[]> result = FileUtils.readCardRespFile(req_day);
    	//这边list数量不固定，就不用 动态sql 一次更新了，怕in太多
    	if(result != null){
    		for(String[] array : result){
    			rechargeDao.updateCardResultCode(array[0], array[3]);
    		}
    	}
    }
    
    /**
     * 根据原充值流水号查询充值结果
     * @param log_id
     */
    public Map<String, String> rechargeQry(String log_id){
    	log.debug("【一卡充】充值记录查询开始。。。");
    	Map<String, String> result = new HashMap<String, String>();
    	
    	//根据原接口调用流水号查出充值卡号，手机号，密码
    	Map<String, String> map = rechargeDao.getRechargeLog(log_id);
    	
    	if(MapUtils.isNotEmpty(map)){
    		String logId = RechargeUtil.generateLogId(4); //接口调用流水号
    		//String partitionId = logId.substring(14, 16);
        	String reqTime = RechargeUtil.getCurentTime();
    		
    		//调接口前不插日志
			//int n1 = insertRechargeCheckLog(logId, partitionId, serial_number, serial_number_type, reqTime);
    		
    		RechargeReq param = new RechargeReq();
    		param.setAgentID(map.get("CARD_NO"));
    		param.setPasword(" "); //查询接口文档里写密码暂时填空格
    		param.setChargeSerilNum(log_id); //原充值流水号
    		param.setSerialNum(logId); //接口调用流水号
    		
        	try {
        		//生成请求报文
        		String req = RechargeUtil.genReq(param, InterfaceType.rechargeQry.getInterfaceCode(), 
        				map.get("SERIAL_NUMBER"), map.get("SERIAL_NUMBER_TYPE"), reqTime);
        		//发送报文
        		rechargeClientHandler.sendMsg(req.getBytes());  
            	
    			log.debug("【一卡充】充值流水号查询充值结果最终请求报文：" + req);
        		
    			//等待一卡充响应结果
    			waitForRechargeRqyResp(log_id, result);
    		} catch (Exception e) {
    			e.printStackTrace();
				result.put("status", com.ai.gzesp.dto.ResultCode.ERR2010.getResultCode());
	            result.put("detail", com.ai.gzesp.dto.ResultCode.ERR2010.getResultName());
    		}
    	}
    	else{
			result.put("status", com.ai.gzesp.dto.ResultCode.ERR2015.getResultCode());
            result.put("detail", com.ai.gzesp.dto.ResultCode.ERR2015.getResultName());
    	}
    	
    	return result;
    }
    
    
	/**
	 * 对外围提供充值系统各种接口，这个方法是业务逻辑的总入口，controller做初步参数校验后，这里再解密后，根据业务参数调用不同业务逻辑
	 * @param param
	 * @return
	 */
	public RespInfo<String> intfRecharge(Map<String, String> param){
		RespInfo<String> respInfo = null; 
		
    	//初步校验参数
    	respInfo = checkIntfParamCommon(param);
    	//respInfo == null表示初步校验通过则执行下面业务,验证不通过则直接返回
    	if(respInfo != null){
    		return respInfo;
    	}
    	
    	String reqParam = param.get("reqParam");
        String merId = param.get("merId");
        String md5Desc = param.get("md5Desc");
        
		//通过商户号查找对应的desKey 和md5Key
		String[] keys = RechargeIntfCons.find(merId);
		//没匹配到则直接返回
		if(keys == null){
			log.info("【一卡充外围接口】merId=" + merId + ",未找到对应的秘钥");
			respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2005.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2005.getResultName());
    		return respInfo;
		}
		
		String desKey = keys[0];
        String md5Key = keys[1];
        
    	String paramJson;
		try {
			byte[] desArray = Base64Utils.decode(reqParam); //base64解码
			paramJson = EncryptUtil.decryptByDes(desKey, desArray); //des解密
	    	log.info("【一卡充外围接口】请求参数des解密完reqParam：" + paramJson);
		} catch (Exception e) {
			log.info("【一卡充外围接口】请求参数des解密异常，商户号对应的desKey不正确。");
			respInfo = new RespInfo<String>(); 
			respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2006.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2006.getResultName());
    		return respInfo; //如果解密失败，直接返回错误
		}
    	
    	//校验md5Desc，防篡改
    	String md5DescMy = EncryptUtil.encryptByMd5(md5Key, paramJson);
    	if(!md5Desc.equals(md5DescMy)){
			log.info("【一卡充外围接口】请求参数reqParam md5校验失败。");
			respInfo = new RespInfo<String>(); 
			respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2007.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2007.getResultName());
    		return respInfo; //如果解密失败，直接返回错误
    	}
    	
    	//json转换成LinkedHashMap
    	LinkedHashMap<String, String> param3 = JSON.parseObject(paramJson, LinkedHashMap.class);
		
    	//校验intfType参数，下面要根据这个来路由调用不同接口业务
    	if(StringUtils.isBlank(param3.get("intfType"))){
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2008.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2008.getResultName());
    		return respInfo; //如果intfType为空，直接返回错误
    	} 
    	
    	//插外围接口日志表
    	
    	//根据interface_type 确定调用的是什么业务
    	if(InterfaceType.rechargeCheck.getInterfaceCode().equals(param3.get("intfType"))){
    		//充值号码验证接口
        	String serial_number = param3.get("phoneNumber");
        	String serial_number_type = "1";
    		Map<String, String> result = rechargeCheck(serial_number, serial_number_type); 
        	if("00000".equals(result.get("status"))){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.SUC0000.getResultCode()); 
        		respInfo.setRespDesc(result.get("detail"));
        	}
        	else{
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(result.get("status")); //如果不成功则返回码可能是封装的，也可能是一卡充返回的
        		respInfo.setRespDesc(result.get("detail"));//错误描述取返回的里面的
        	}
        	
        	//按道理应该上面先插日志，这边执行完业务逻辑更新日志状态，这边省事点，最后执行完再插外围接口日志表
    		String logId = RechargeUtil.generateLogId(6); //每张卡插的记录logid不一致
    		rechargeDao.insertIntfRechargeLog(
    				logId,
    				logId.substring(14, 16),
    				param3.get("outTradeId"),
    				param3.get("merId"),
    				param3.get("reqTime"), 
    				param3.get("intfType"),
    				param3.get("phoneNumber"),
    				"1",   //业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
    				null, //fee
    				null, //order_id
    				respInfo.getRespCode(),
    				respInfo.getRespDesc(),
    				null //orig_out_trade_id
    				);
    	}
    	if(InterfaceType.recharge.getInterfaceCode().equals(param3.get("intfType"))){
        	//校验fee参数，目前只支持20,30，50,100 四种固定金额充值
    		String fee = param3.get("fee");
        	if(StringUtils.isBlank(fee) || !("20".equals(fee) || "30".equals(fee) || "50".equals(fee) || "100".equals(fee)) ){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2011.getResultCode()); 
        		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2011.getResultName());
        		return respInfo; //如果intfType为空，直接返回错误
        	}
    		//充值接口
        	//调用原充值逻辑
        	String order_id = CommonUtil.generateOrderId("2"); //外网接口不生成订单，不插订单表，直接调研一卡充平台
        	String serial_number = param3.get("phoneNumber");
        	String serial_number_type = "1";
        	int total_fee = Integer.valueOf(param3.get("fee")); //元
        	Map<String, String> result = recharge(order_id, serial_number, serial_number_type, total_fee); 
    		
        	if("00000".equals(result.get("status"))){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.SUC0000.getResultCode()); 
        		respInfo.setRespDesc(result.get("detail"));
        	}
        	else{
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(result.get("status")); //如果不成功则返回码可能是封装的，也可能是一卡充返回的
        		respInfo.setRespDesc(result.get("detail"));//错误描述取返回的里面的
        	}
        	
        	//按道理应该上面先插日志，这边执行完业务逻辑更新日志状态，这边省事点，最后执行完再插外围接口日志表
    		String logId = RechargeUtil.generateLogId(6); //每张卡插的记录logid不一致
    		rechargeDao.insertIntfRechargeLog(
    				logId,
    				logId.substring(14, 16),
    				param3.get("outTradeId"),
    				param3.get("merId"),
    				param3.get("reqTime"), 
    				param3.get("intfType"),
    				param3.get("phoneNumber"),
    				"1",   //业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
    				param3.get("fee"),
    				order_id,
    				respInfo.getRespCode(),
    				respInfo.getRespDesc(),
    				null //orig_out_trade_id
    				);
    	}
    	if(InterfaceType.rechargeQry.getInterfaceCode().equals(param3.get("intfType"))){
    		//充值记录查询接口
    		String origOutTradeId = param3.get("origOutTradeId");
        	//根据原外围系统接口调用流水号origOutTradeId, 查找原充值记录沃掌柜系统里的流水号 log_id
        	Map<String, String> logMap = rechargeDao.getIntfRechargeLog(origOutTradeId);
        	if(MapUtils.isEmpty(logMap)){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2014.getResultCode()); 
        		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2014.getResultName());
        		return respInfo; //如果outTradeId未找到充值记录直接返回错误
        	}
        	
        	Map<String, String> result = rechargeQry(logMap.get("LOG_ID"));
        	if("00".equals(result.get("status"))){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.SUC0000.getResultCode()); 
        		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.SUC0000.getResultName());
        	}
        	else{
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(result.get("status")); //如果不成功则返回码可能是封装的，也可能是一卡充返回的
        		respInfo.setRespDesc(result.get("detail"));//错误描述取返回的里面的
        	}
        	
        	//添加data返回数据,原充值记录的信息
        	Map<String, Object> dataMap = new HashMap<String, Object>();
        	dataMap.put("chargeResult", result.get("status"));
        	dataMap.put("reqTime", logMap.get("REQ_TIME"));
        	dataMap.put("outTradeId", origOutTradeId);
        	dataMap.put("phoneNumber", logMap.get("SERIAL_NUMBER"));
        	dataMap.put("fee", result.get("detail"));
        	
        	//des加密所有原始业务参数json，加密结果编码方式base64
        	String paramJson2 = JSON.toJSONString(dataMap);
        	byte[] desArray = EncryptUtil.encryptByDes(desKey, paramJson2);
        	String desBase64Str = Base64Utils.encode(desArray);
        	respInfo.setData(desBase64Str);
        	
        	//按道理应该上面先插日志，这边执行完业务逻辑更新日志状态，这边省事点，最后执行完再插外围接口日志表
    		String logId = RechargeUtil.generateLogId(6); //每张卡插的记录logid不一致
    		rechargeDao.insertIntfRechargeLog(
    				logId,
    				logId.substring(14, 16),
    				param3.get("outTradeId"),
    				param3.get("merId"),
    				param3.get("reqTime"), 
    				param3.get("intfType"),
    				null, //号码
    				"1",   //业务号码类型(1位)： 1 GSM；2 固话；3 宽带；4 小灵通或大灵通。
    				null, //fee
    				null, //order_id
    				respInfo.getRespCode(),
    				respInfo.getRespDesc(),
    				origOutTradeId //orig_out_trade_id
    				);
    	}
    	if(InterfaceType.check.getInterfaceCode().equals(param3.get("intfType"))){
    		//充值对账接口
    		String origOutTradeId = param3.get("origOutTradeId");
        	//根据原外围系统接口调用流水号origOutTradeId, 查找原充值记录沃掌柜系统里的流水号 log_id
        	Map<String, String> logMap = rechargeDao.getIntfRechargeLog(origOutTradeId);
        	if(MapUtils.isEmpty(logMap)){
        		respInfo = new RespInfo<String>(); 
        		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2014.getResultCode()); 
        		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2014.getResultName());
        		return respInfo; //如果outTradeId未找到充值记录直接返回错误
        	}
        	
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(logMap.get("CHECK_STATUS")); 
    		respInfo.setRespDesc(logMap.get("CHECK_STATUS"));
    	}
    	else{
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2009.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2009.getResultName());
    		//return respInfo; //如果intfType未匹配到，直接返回错误
    	}
    	

    	//
    	return respInfo;
	}   
	
    /**
     * 请求入参校验
     * @param param
     * @return
     */
    public RespInfo<String> checkIntfParamCommon(Map<String, String> param){
    	RespInfo<String> respInfo = null;
    	
    	//入参为空直接返回
    	if(MapUtils.isEmpty(param)){
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2001.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2001.getResultName());
    		return respInfo;
    	}
    	//reqParam不能为空
    	if(StringUtils.isBlank(param.get("reqParam"))){
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2002.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2002.getResultName());
    		return respInfo;
    	}
    	//merId不能为空
    	if(StringUtils.isBlank(param.get("merId"))){
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2003.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2003.getResultName());
    		return respInfo;
    	}
    	//md5Desc不能为空
    	if(StringUtils.isBlank(param.get("md5Desc"))){
    		respInfo = new RespInfo<String>(); 
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2004.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2004.getResultName());
    		return respInfo;
    	}    
    	
//		//通过商户号查找对应的desKey 和md5Key
//        String merId = param.get("merId");
//        String md5Desc = param.get("md5Desc");
//		String[] keys = RechargeIntfCons.find(merId);
//		//没匹配到则直接返回
//		if(keys == null){
//			//log.info("【一卡充外围接口】merId=" + merId + ",未找到对应的秘钥");
//    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2005.getResultCode()); 
//    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2005.getResultName());
//    		return respInfo;
//		}
    	
    	//校验通过返回null
    	return respInfo;
    }
	
	private RespInfo<String> checkIntfParam(String reqParam, String md5Desc, String desKey, String md5Key){
		RespInfo<String> respInfo = new RespInfo<String>(); 
        
    	String paramJson;
		try {
			byte[] desArray = Base64Utils.decode(reqParam); //base64解码
			paramJson = EncryptUtil.decryptByDes(desKey, desArray); //des解密
	    	log.info("【一卡充外围接口】请求参数des解密完reqParam：" + paramJson);
		} catch (Exception e) {
			log.info("【一卡充外围接口】请求参数des解密异常，商户号对应的desKey不正确。");
			respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2006.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2006.getResultName());
    		return respInfo; //如果解密失败，直接返回错误
		}
    	
    	//校验md5Desc，防篡改
    	String md5DescMy = EncryptUtil.encryptByMd5(md5Key, paramJson);
    	if(!md5Desc.equals(md5DescMy)){
			log.info("【一卡充外围接口】请求参数reqParam md5校验失败。");
			respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2007.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2007.getResultName());
    		return respInfo; //如果解密失败，直接返回错误
    	}
    	
    	//json转换成LinkedHashMap
    	LinkedHashMap<String, String> param3 = JSON.parseObject(paramJson, LinkedHashMap.class);
		
    	//校验intfType参数，下面要根据这个来路由调用不同接口业务
    	if(StringUtils.isBlank(param3.get("intfType"))){
    		respInfo.setRespCode(com.ai.gzesp.dto.ResultCode.ERR2008.getResultCode()); 
    		respInfo.setRespDesc(com.ai.gzesp.dto.ResultCode.ERR2008.getResultName());
    		return respInfo; //如果intfType为空，直接返回错误
    	} 
    	
    	return respInfo;
	}
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		int total_fee = 1000;
	    int[] array = {1000, 500, 300, 100};
	    
/*	    Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
	    
	    compute(total_fee, 0, groups);*/
		
/*		System.out.println(Math.floor(total_fee/array[0]));
		System.out.println((int)Math.floor(total_fee/array[0]));
		
		System.out.println(ResultCode.find("01026"));*/
	    
/*	    char Suffix = 0x1a;
	    StringBuffer sb = new StringBuffer();
	    sb.append("abcd");
	    sb.append(Suffix);
	    
	    System.out.println(Suffix);
	    System.out.println(sb.append(Suffix));
	    System.out.println(sb.toString().getBytes());
	    System.out.println(sb.toString().getBytes("utf-8"));*/
	    
//	    String logId = RechargeUtil.generateLogId(3);
//	    for(int i = 0; i<100; i++){
//	    	
//	    	logId = String.valueOf(Long.parseLong(logId) + 1);
//	    	System.out.println(logId);
//	    }
	    
    	String merId = "A0001"; //5位
    	String md5Key = "0aad781d015ca667d6eba25e"; //24位
    	String desKey = "0aad781d015ca667d6eba25f"; //24位
    	String intfUrl = "http://localhost:8080/esp/recharge/intf/recharge"; //充值接口url
    	
    	//原始业务参数map,注意用LinkedHashMap
    	Map<String, String> param = new LinkedHashMap<String, String>();
    	param.put("phoneNumber", "18651885060");
    	param.put("fee", "100");
    	param.put("merId", merId);
    	param.put("reqTime", "20160824112200");
    	param.put("outOrderId", "1234567890123456");
    	
    	//原始业务参数转换成json字符串
    	String paramJson = JSON.toJSONString(param);
    	System.out.println("--原始业务参数param--");
    	System.out.println(paramJson);
    	
    	//业务参数json 进行 md5加密，生成摘要
    	String md5Desc = EncryptUtil.encryptByMd5(md5Key, paramJson);
    	System.out.println("--原始业务参数json串md5加密--");
    	System.out.println(md5Desc);
    	
    	//des加密所有原始业务参数json，加密结果编码方式base64
    	String paramJson2 = JSON.toJSONString(param);
    	byte[] desArray = EncryptUtil.encryptByDes(desKey, paramJson2);
    	String desBase64Str = Base64Utils.encode(desArray);
    	System.out.println("--原始业务参数base64编码完字符串--");
    	System.out.println(desBase64Str);
    	
    	//封装最终的post请求参数json
    	Map<String, String> postParam = new HashMap<String, String>();
    	postParam.put("reqParam", desBase64Str);
    	postParam.put("merId", merId);
    	postParam.put("md5Desc", md5Desc);//再将md5摘要加入到请求参数里
    	
    	//httpclient 发送请求获取返回
//    	String respJson = HttpXmlClient.httpSend(intfUrl, postParam);
    	
    	//下面是服务端接收到入参后的解析
    	byte[] desArray2 = Base64Utils.decode(desBase64Str);
    	String paramJson3 = EncryptUtil.decryptByDes(desKey, desArray2);
    	System.out.println("--请求参数解析完后的字符串--");
    	System.out.println(paramJson3);
    	//json转换成LinkedHashMap
    	LinkedHashMap<String, String> param3 = JSON.parseObject(paramJson3, LinkedHashMap.class);
    	//校验md5Desc，防篡改
    	String md5DescReq = md5Desc; //请求入参里的md5Desc
    	String md5DescMust = EncryptUtil.encryptByMd5(md5Key, paramJson3);
    	if(md5DescReq.equals(md5DescMust)){
    		System.out.println("md5校验正确");
    	}
    	else{
    		System.out.println("md5校验失败");
    	}
    	
    	
	}
}
