package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.UnionPayDao;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.unionpay.TradeType;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
import com.ai.gzesp.utils.DateUtils;
import com.ai.gzesp.utils.MD5Util;

/**
 * 银联支付服务类，用于申请的商户号，用于需要使用签约号的各种银联接口，
 * 不需要签约号的比如全要素后支付接口则用 UnionPayCons<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UnionPayService2 {
    
    private static final Logger log = Logger.getLogger(UnionPayService2.class); 
    
    @Autowired
    private UnionPayDao unionPayDao;
    
    public Map<String, String> bindCard(UnionPayParam param){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	//UnionPayParam param = new UnionPayParam();
    	//String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
    	//param.setBind_sys_trade_no(sysTradeNo);
        String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
        param.setBind_time_stamp(timeStamp);
        String tradeType = TradeType.bind.getTradeType(); //业务类型
        param.setBind_trade_type(tradeType);
    	
    	insertBindlog2(param, result); //插日志
    	if(!result.isEmpty()){
			return result; 
		}
    	
    	sendBindReq2(param, result);  //调绑定接口
		if(!result.isEmpty()){
			return result; 
		}
		
		waitForBindResp2(param, result); //等待绑定返回签约号
		if(!result.isEmpty()){
			return result; 
		}
		
		return result;
    }
    
    /**
     * 调用银联绑定接口前 先插入绑定日志记录 
     * @param param
     * @return
     */
    private void insertBindlog2(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;

            //String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
            //param.setBind_sys_trade_no(sysTradeNo);
            //String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            //param.setBind_time_stamp(timeStamp);
            //String tradeType = TradeType.bind.getTradeType(); //业务类型
            //param.setBind_trade_type(tradeType);
            
            //调用绑定接口前插订单支付日志表
            int n2 = unionPayDao.insertBindlog2(param.getBind_sys_trade_no(), //log_id
            		param.getBind_sys_trade_no().substring(14, 16), //partition_id
            		param.getBind_time_stamp(), //req_time
            		param.getBind_trade_type(), //req_trade_type
            		param.getBind_sys_trade_no() //sys_trade_no
            		);

            if(n2>0){
            	//成功则result为空
            }
            else{
                result.put("status", "E01");
                result.put("detail", "绑定日志插入失败");
                //return result; //直接返回
            }   
        
        //return result;
    }
    
    /**
     * 发送绑定报文
     * @param param
     * @return
     */
    private void sendBindReq2(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;

            //银行卡绑定接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genBindReq2(param); //新的商户id生成的报文
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            
            //调用mina客户端发送报文
            if(xmlSend != null){
            	isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }
            
            if(!isSuccess){
            	result.put("status", "E02");
            	result.put("detail", "发送绑定接口报文失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 绑定成功发送后等待银联返回签约号
     * @param param
     * @param result
     */
    public void waitForBindResp2(UnionPayParam param, Map<String, String> result){
    	//Map<String, String> result = new HashMap<String, String>();
        //如果绑定接口调用成功就要开始等待银联返回签约号了，如果超时未返回则支付失败
            int timeout = 0;
            while(true){
                if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                    result.put("status", "E03");
                    result.put("detail", "发送绑定接口报文后未接收到银联响应或应答码错误");
                    break;
                }
                try {
                    Thread.sleep(UnionPayCons.SLEEP_INTERVAL_BIND);
                    timeout += UnionPayCons.SLEEP_INTERVAL_BIND;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } //每次轮询等待1秒钟
                Map<String, String> row = unionPayDao.querySignCode2(param.getBind_sys_trade_no()); //查询银行卡表里是否已经有银联返回的结果了
                if(row != null){
                    //param.setSign_code(MD5Util.convertMD5(row.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
                    //result = sendPayReq(param); //调用支付接口
                    //sendPayReq(param, result); //调用支付接口
                	result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
                    result.put("detail", "绑定成功！");
                    break;
                }
            }
        
        
        //return result;
    }

    
}
