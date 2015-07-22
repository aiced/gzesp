package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    
	@Autowired
	private UnionPayService unionPayService;
    
    /**
     * 银行卡绑定 服务类，调用银联第二套商户号参数 调用 绑定接口
     * 银行卡 几大要素 + 系统跟踪号 SysTradeNo 由文辉生成并传过来
     * @param param
     * @return
     */
    public Map<String, String> bindCard(UnionPayParam param){
    	Map<String, String> result = new HashMap<String, String>();
    	
//    	UnionPayParam param = new UnionPayParam();
//    	String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
//    	param.setBind_sys_trade_no(sysTradeNo);  //接口日志流水号
//    	param.setBank_card_no(bank_card_no);   //银行卡号
//    	param.setBank_card_cvn(bank_card_cvn);  //cvn2
//    	param.setBank_card_expire_date(bank_card_expire_date); //有效期 1501
//    	param.setCard_type(card_type);  //卡类型 信用卡:01或借记卡:02
//    	param.setFull_name(full_name);   //姓名
//    	param.setId_card_no(id_card_no); //身份证
//    	param.setPhone_no(phone_no); //手机号
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
    private void waitForBindResp2(UnionPayParam param, Map<String, String> result){
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

    
    /**
     * 收到银联绑定接口的返回后，更新 PAY_D_UNIONPAY_LOG 日志表<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateBindlog2(Map<String, String> respMap) {
        return unionPayDao.updateBindlog2(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                respMap.get(UnionPayAttrs.sysTradeNo));
    } 
    
    /**
     * 收到银联绑定接口的返回后,如果绑定成功，需要更新 能人账户银行卡关系表 里的签约号 和有效标志<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateBankCardSignCode(Map<String, String> respMap) {
        String sign_code = MD5Util.convertMD5(respMap.get(UnionPayAttrs.signCode)); //表里存放md5加密的签约号
        String valid_flag;
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
        	valid_flag = "1"; //0：未绑定 1：绑定成功 2：绑定失败 3：解绑成功
        }
        else{
        	valid_flag = "2";
        }
        return unionPayDao.updateBankCardSignCode(sign_code, valid_flag, respMap.get(UnionPayAttrs.sysTradeNo));
    }
    
    
    /**
     * 用签约号进行支付，调用银联支付接口，非全要素支付接口
     * 商户号用第二套参数
     * 文辉传 order_id, fee, sign_code过来
     * @param param
     * @return
     */
    public Map<String, String> unionPayPay(UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        
/*        String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.pay.getTradeType()); //系统跟踪号
        param.setPay_sys_trade_no(sysTradeNo);
        String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
        param.setPay_time_stamp(timeStamp);
        String tradeType = TradeType.pay.getTradeType(); //业务类型
        param.setPay_trade_type(tradeType);
        String orderIdVir = UnionPayUtil.orderId2newOrderId(param.getOrder_id(), param.getPay_sys_trade_no()); //虚拟订单号，每次支付不重复
        param.setOrder_id_vir(orderIdVir);*/
        
        //判断校验参数
        
        //逻辑放controller是因为service里都有事务控制，没法分开
        insertUnionPaylog2(param, result);
		if(!result.isEmpty()){
			return result; 
		}
			
		sendPayReq2(param, result);
		if(!result.isEmpty()){
			return result; 
		}
			
		waitForPayResp2(param, result);
		if(!result.isEmpty()){
			return result; 
		}
			
        return result;
    }
    
    /**
     * 调用银联支付接口前 先插入支付日志记录 
     * @param param
     * @return
     */
    public void insertUnionPaylog2(UnionPayParam param, Map<String, String> result){
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
             
            //调用全要素支付接口前插订单支付日志表
            int n2 = unionPayDao.insertUnionPaylog2(param.getPay_sys_trade_no(), //log_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
            		param.getOrder_id(), // real_order_id
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getPay_trade_type(), //req_trade_type
                                    param.getPay_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id_vir(),  //order_id 这边是虚拟order_id
                                    param.getFee()
                    );
            //sqlSession.commit(); //手动提交
            
            if(n2 <= 0){
            	//都成功则result为空
            	result.put("status", "E04");
            	result.put("detail", "支付失败！支付日志流水插入失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 获取到签约号后发送支付接口
     * @param param
     * @param result
     * @return
     */
    public void sendPayReq2(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayReq2(param); //第二套参数
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }    
            
            if(!isSuccess){
            	result.put("status", "E05");
            	result.put("detail", "支付失败！发送支付接口报文失败");
            	//return result; //直接返回
            }
            
        //return result;
    }
    
    /**
     * 支付改造后：发送支付接口后等待支付结果返回
     * 区别是查询的 新银联日志表 PAY_D_UNIONPAY_LOG
     * 只返回错误，成功result为空
     * @param param
     * @param result
     * @return
     */
    public void waitForPayResp2(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                result.put("status", "E06");
                result.put("detail", "支付失败！发送支付接口报文后未接收到银联响应");
                break;
            }
            try {
                Thread.sleep(UnionPayCons.SLEEP_INTERVAL_PAY);
                timeout += UnionPayCons.SLEEP_INTERVAL_PAY;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待4秒钟
            Map<String, String> row = unionPayDao.queryUnionPaylog(param.getPay_sys_trade_no()); //查询银联日志表里是否已经有银联返回的结果了
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                if(UnionPayCons.RESULT_CODE_SUCCESS.equals(row.get("RESULT_CODE"))){
//                    result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
//                    result.put("detail", "支付成功！");
                }
                else{
                    result.put("status", row.get("RESULT_CODE"));
                    result.put("detail", "支付失败！" + row.get("RESULT_DESC"));
                }
                break;
            }
        }
        
        //return result;
    }
    
    /**
     * 银联签约号支付 退款 用第二套商户号
     * 银联退款调用接口service，没有单独controller，controller入口是在payController里面
     * @param order_id
     * @return
     */
    public Map<String, String> refundOrder(String order_id){
    	Map<String, String> result = new HashMap<String, String>();
    	
    	Map<String, String> origUnionPayLog = unionPayDao.queryUnionPaylogByOrderId(order_id); //先查出原来支付成功的订单信息
    	
    	//组装原支付成功订单部分请求参数
    	UnionPayParam param = new UnionPayParam();
    	param.setOrder_id(order_id);
    	param.setOrig_order_id(origUnionPayLog.get("ORDER_ID")); //这边插入原支付记录里的虚拟的order_id,因为支付时发送的是虚拟order_id的
    	param.setOrig_sys_trade_no(origUnionPayLog.get("SYS_TRADE_NO"));
    	param.setOrig_timestamp(origUnionPayLog.get("REQ_TIME"));
    	param.setOrig_txn_amt(origUnionPayLog.get("TXN_AMT"));
    	//组装退款请求当前时间等请求参数
    	String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
    	param.setPayCalcel_time_stamp(timeStamp);
    	//判断当前退款时间和支付成功时间 是否同一天，接口类型不一样，其他参数都一致
    	if(StringUtils.equals(timeStamp.subSequence(0, 8), param.getOrig_timestamp().subSequence(0, 8))){
    		String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payCancel.getTradeType()); //系统跟踪号
    		param.setPayCalcel_sys_trade_no(sysTradeNo);
    		String tradeType = TradeType.payCancel.getTradeType(); //业务类型
    		param.setPayCalcel_trade_type(tradeType);
    	}
    	else{
    		String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payRefund.getTradeType()); //系统跟踪号
    		param.setPayCalcel_sys_trade_no(sysTradeNo);
    		String tradeType = TradeType.payRefund.getTradeType(); //业务类型
    		param.setPayCalcel_trade_type(tradeType);    		
    	}
    	
        try {
        	unionPayService.insertPayCancellog(param, result); //插银联日志
			if(!result.isEmpty()){
				return result; 
			}
			sendPayCancelReq(param, result); //发送接口请求，第二套商户号
			if(!result.isEmpty()){
				return result; 
			}
			unionPayService.waitForPayCancelResp(param, result); //等待银联响应
			if(!result.isEmpty()){
				return result; 
			}
			
			result.put("status", "E11");
            result.put("detail", "退款请求失败！");
		} catch (Exception e1) {
			e1.printStackTrace();
			result.put("status", "E12");
            result.put("detail", "退款请求失败！");
		}  
        
    	
    	return result;
    }  
    
    /**
     * 签约号支付是用第二套商户号的，所以相应退款也需要用第二套商户号  发送请求。
     * 所以这边重写，其他插日志，等待响应逻辑相同
     * 
     * @param param
     * @param result
     * @return
     */
    public void sendPayCancelReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayCancelReq2(param); //第二套商户
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }    
            
            if(!isSuccess){
            	result.put("status", "E05");
            	result.put("detail", "撤销失败！发送支付接口报文失败");
            	//return result; //直接返回
            }
            
        //return result;
    }    
    
}
