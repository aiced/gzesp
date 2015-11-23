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
 * 银联支付服务类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UnionPayService {
    
    private static final Logger log = Logger.getLogger(UnionPayService.class); 
    
    @Autowired
    private UnionPayDao unionPayDao;
    
/*    @Autowired
    private ClientHandler clientHandler;*/
    
    
/*    public Map<Object, Object> getSignCode(String bank_card_no, String bank_card_expire_date, String bank_card_cvn,
            String id_card_no, String phone_no, String full_name) {
        return unionPayDao.getSignCode(bank_card_no, bank_card_expire_date, bank_card_cvn, id_card_no, phone_no,
                full_name);
    }
*/
    
/*    public Map<String, String> bindAndPay(UnionPayParam param){
        Map<String, String> result;
        //查询是否有签约号，如果有直接用来调支付接口，没有则调绑定接口获取签约号，然后再支付接口
        Map<String, String> signCodeRow = unionPayDao.querySignCode(param.getBank_card_no());
        
        if(signCodeRow == null){
            result = sendBindReq(param);
        }
        else{
            //如果根据卡号捞到记录，则要校验输入的值和表里的信息是否都一致
            //boolean flag = checkParam(param, signCodeRow, result);
            
            param.setSign_code(MD5Util.convertMD5(signCodeRow.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
            result = sendPayReq(param);
        }      
        
        return result;
    }*/
    
    /**
     * 插入绑定日志记录和签约信息表，签约号先空着等待更新
     * @param param
     * @return
     */
    public void insertBindlogAndSignCodeTx(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;

            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
            param.setBind_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setBind_time_stamp(timeStamp);
            String tradeType = TradeType.bind.getTradeType(); //业务类型
            param.setBind_trade_type(tradeType);
             
            //调用绑定接口前插签约信息表，sign_code 空着，后面等待银联返回后根据sys_trade_no更新sign_code
            int n1 = unionPayDao.insertSignCode(param.getBank_card_no(), 
                    param.getBank_card_cvn(), param.getPhone_no(), param.getFull_name(), 
                    param.getId_card_no(), param.getBank_card_expire_date(), 
                    UnionPayCons.currencyCode, param.getBind_sys_trade_no(), "0"); //签约状态默认填0未绑定
            
            //调用绑定接口前插订单支付日志表
            int n2 = unionPayDao.insertBindlog(param.getBind_sys_trade_no(), //pay_id
            		param.getBind_sys_trade_no().substring(14, 16), //partition_id
            		"01",  //pay_type
            		param.getCard_type().equals("01") ? "11" : "12", //pay_mode
            				"0", //pay_state 初始0已发起支付
            				param.getBind_time_stamp(), //req_time
            				"00", //isSuccess ? "00" : "01",  //req_status  这边有点问题，其实还没发送出去，就写了发送成功状态
            						param.getBind_trade_type(), //req_trade_type
            						param.getBind_sys_trade_no(), //sys_trade_no
            						param.getOrder_id(),
            						param.getFee()  //订单传过来是厘，传给银联单位是分 需要乘以10
            		);

            if(n1>0 && n2>0){
            	//都成功则result为空
            }
            else{
                result.put("status", "E01");
                result.put("detail", "支付失败！绑定日志插入失败 或 签约信息表插入失败");
                //return result; //直接返回
            }   
        
        //return result;
    }
    
    /**
     * 发送绑定报文并记录日志，事务控制，不能捕捉异常
     * @param param
     * @return
     */
    public void sendBindReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;

            //银行卡绑定接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genBindReq(param);
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            
            //调用mina客户端发送报文
            if(xmlSend != null){
            	isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }
            
            if(!isSuccess){
            	result.put("status", "E02");
            	result.put("detail", "支付失败！发送绑定接口报文失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 绑定成功发送后等待银联返回签约号
     * @param param
     * @param result
     */
    public void waitForBindResp(UnionPayParam param, Map<String, String> result){
    	//Map<String, String> result = new HashMap<String, String>();
        //如果绑定接口调用成功就要开始等待银联返回签约号了，如果超时未返回则支付失败
            int timeout = 0;
            while(true){
                if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                    result.put("status", "E03");
                    result.put("detail", "支付失败！发送绑定接口报文后未接收到银联响应或应答码错误");
                    break;
                }
                try {
                    Thread.sleep(UnionPayCons.SLEEP_INTERVAL_BIND);
                    timeout += UnionPayCons.SLEEP_INTERVAL_BIND;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } //每次轮询等待1秒钟
                Map<String, String> row = unionPayDao.querySignCode(param.getBank_card_no()); //查询签约表里是否已经有银联返回的结果了
                if(row != null){
                    param.setSign_code(MD5Util.convertMD5(row.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
                    //result = sendPayReq(param); //调用支付接口
                    //sendPayReq(param, result); //调用支付接口
                    break;
                }
            }
        
        
        //return result;
    }

    /**
     * 调用支付接口前插支付日志表
     * @param param
     * @param result
     * @return
     */
    public void insertPaylog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        
            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.pay.getTradeType()); //系统跟踪号
            param.setPay_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setPay_time_stamp(timeStamp);
            String tradeType = TradeType.pay.getTradeType(); //业务类型
            param.setPay_trade_type(tradeType);
             
            //调用支付接口前插订单支付日志表
            int n2 = unionPayDao.insertPaylog(param.getPay_sys_trade_no(), //pay_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
                    "01",  //pay_type
                    param.getCard_type().equals("01") ? "11" : "12", //pay_mode
                            "0", //pay_state 初始0已发起支付
                            MD5Util.convertMD5(param.getSign_code()), //银联支付接口时插入md5 加密后的签约号,用于退款时知道退到哪个账户
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getPay_trade_type(), //req_trade_type
                                    param.getPay_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id(),
                                    param.getFee()
                    );
            
            if(n2 <= 0){
            	//都成功则result为空
            	result.put("status", "E04");
            	result.put("detail", "支付失败！支付日志流水插入失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 调用全要素支付接口前插支付日志表
     * @param param
     * @param result
     * @return
     */
    public void insertPayNewlog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        
            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payNew.getTradeType()); //系统跟踪号
            param.setPay_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setPay_time_stamp(timeStamp);
            String tradeType = TradeType.payNew.getTradeType(); //业务类型
            param.setPay_trade_type(tradeType);
             
            //调用全要素支付接口前插订单支付日志表
            int n2 = unionPayDao.insertPaylog(param.getPay_sys_trade_no(), //pay_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
                    "01",  //pay_type
                    param.getCard_type().equals("01") ? "11" : "12", //pay_mode
                            "0", //pay_state 初始0已发起支付
                            null, //银联支付接口时插入md5 加密后的签约号,用于退款时知道退到哪个账户, 全要素支付接口不需要传签约号
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getPay_trade_type(), //req_trade_type
                                    param.getPay_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id(),
                                    param.getFee()
                    );
            
            if(n2 <= 0){
            	//都成功则result为空
            	result.put("status", "E04");
            	result.put("detail", "支付失败！全要素支付日志流水插入失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 调用全要素支付接口前插银联日志表 PAY_D_UNIONPAY_LOG
     * @param param
     * @param result
     * @return
     */
    public void insertUnionPaylog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        
            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payNew.getTradeType()); //系统跟踪号
            param.setPay_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setPay_time_stamp(timeStamp);
            String tradeType = TradeType.payNew.getTradeType(); //业务类型
            param.setPay_trade_type(tradeType);
            String orderIdVir = UnionPayUtil.orderId2newOrderId(param.getOrder_id(), param.getPay_sys_trade_no()); //虚拟订单号，每次支付不重复
            param.setOrder_id_vir(orderIdVir);
             
            //调用全要素支付接口前插订单支付日志表
            int n2 = unionPayDao.insertUnionPaylog(param.getPay_sys_trade_no(), //log_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
            		param.getOrder_id(), // real_order_id
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getPay_trade_type(), //req_trade_type
                                    param.getPay_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id_vir(),  //order_id 这边是虚拟order_id
                                    param.getFee()
                    );
            
            if(n2 <= 0){
            	//都成功则result为空
            	result.put("status", "E04");
            	result.put("detail", "支付失败！全要素支付日志流水插入失败");
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
    public void sendPayReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayReq(param);
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
     * 发送全要素支付接口
     * @param param
     * @param result
     * @return
     */
    public void sendPayNewReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayNewReq(param);
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
     * 发送全要素支付接口
     * 和 sendPayNewReq 区别为调用的是 UnionPayUtil.genPayNewReq2 方法
     * @param param
     * @param result
     * @return
     */
    public void sendPayNewReq2(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayNewReq2(param); 
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
     * 发送支付接口后等待支付结果返回
     * @param param
     * @param result
     * @return
     */
    public void waitForPayResp(UnionPayParam param, Map<String, String> result){
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
            Map<String, String> row = unionPayDao.queryPaylog(param.getPay_sys_trade_no()); //查询支付日志表里是否已经有银联返回的结果了
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                if(UnionPayCons.RESULT_CODE_SUCCESS.equals(row.get("RESULT_CODE"))){
                    result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
                    result.put("detail", "支付成功！");
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
     * 支付改造后：发送支付接口后等待支付结果返回
     * 区别是查询的 新银联日志表 PAY_D_UNIONPAY_LOG
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
                    result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
                    result.put("detail", "支付成功！");
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
    
    private void checkParam(UnionPayParam param, Map<String, String> signCodeRow, Map<String, String> result) {

    }
    
    /**
     * 根据银行卡号查询是否有绑定成功的签约号
     * @param bank_card_no
     * @return
     */
    public Map<String, String> querySignCode(String bank_card_no) {
        //查询是否有签约号，如果有直接用来调支付接口，没有则调绑定接口获取签约号，然后再支付接口
        Map<String, String> signCodeRow = unionPayDao.querySignCode(bank_card_no);
        return signCodeRow;
    }

    
    /**
     * 收到银联绑定接口的返回后，更新paylog日志表<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateBindlog(Map<String, String> respMap) {
        return unionPayDao.updateBindlog(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                respMap.get(UnionPayAttrs.sysTradeNo));
    } 
    
    /**
     * 收到银联绑定接口的返回后，更新paylog日志表<br>
     * 此为银联改造后新的逻辑方法，绑定接口返回后不再更新 签约信息表，只更新绑定接口日志，并且把签约号字段pay_acunt_no更新上
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateBindlogNew(Map<String, String> respMap) {
    	String sign_code = null; //表里存放md5加密的签约号,如果返回成功需要更新，返回失败更新成null
    	if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
    		sign_code = MD5Util.convertMD5(respMap.get(UnionPayAttrs.signCode)); //表里存放md5加密的签约号
        }
        return unionPayDao.updateBindlogNew(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                respMap.get(UnionPayAttrs.sysTradeNo), sign_code);
    } 
    
    /**
     * 收到银联支付接口的返回后，更新paylog日志表<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updatePaylog(Map<String, String> respMap) {
        String pay_state = "2"; //默认支付失败
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
            pay_state = "1"; // 支付成功
        }
        else{
            pay_state = "2"; 
        }
        return unionPayDao.updatePaylog(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                pay_state, respMap.get(UnionPayAttrs.sysTradeNo));
    }
    
    
    /**
     * 收到银联全要素支付接口的返回后，更新PAY_D_UNIONPAY_LOG日志表<br>
     * 和updateUnionPaylog区别：返回无签约号
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateUnionPaylog(Map<String, String> respMap) {
        return unionPayDao.updateUnionPaylog(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                 respMap.get(UnionPayAttrs.sysTradeNo));
    }
    
    /**
     * 根据支付查询接口 获得的结果 更新PAY_D_UNIONPAY_LOG日志表
     * @param respMap
     * @return
     */
    public int updateUnionPaylogAfterQry(Map<String, String> respMap) {
        return unionPayDao.updateUnionPaylogAfterQry(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp));
    } 
    
    /**
     * 支付收到响应后更新订单基本表里订单状态
     * @param respMap
     * @return
     */
    public int updatePayStateAndIncomeMoney(Map<String, String> respMap) {
    	int r2 = 0;
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
        	String order_state = "01"; //下单时是00，支付成功改成01，支付失败则不更新还是00
        	int income_money = Integer.parseInt(respMap.get(UnionPayAttrs.txnAmt))*10; //银联是分，表里是厘
        	//20150522修改，发给银联的是真实的orderId+sysTradeNo的最后2位
        	String realOrderId = UnionPayUtil.newOrderId2OrderId(respMap.get(UnionPayAttrs.orderId), respMap.get(UnionPayAttrs.sysTradeNo));
        	//r2 = unionPayDao.updatePayStateAndIncomeMoney(respMap.get(UnionPayAttrs.orderId), order_state, income_money);
        	r2 = unionPayDao.updatePayStateAndIncomeMoney(realOrderId, order_state, income_money);
        }
        return r2;
    }
    
    
    /**
     * 收到银联绑定接口的返回后,如果绑定成功，需要更新签约信息表<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateSignCode(Map<String, String> respMap) {
        String sign_code = MD5Util.convertMD5(respMap.get(UnionPayAttrs.signCode)); //表里存放md5加密的签约号
        String valid_flag;
        if(UnionPayCons.RESULT_CODE_SUCCESS.equals(respMap.get(UnionPayAttrs.resultCode))){
        	valid_flag = "1"; //0:还未绑定 1:绑定成功 2:绑定失败 3:绑定解除
        }
        else{
        	valid_flag = "2";
        }
        return unionPayDao.updateSignCode(sign_code, valid_flag, respMap.get(UnionPayAttrs.sysTradeNo));
    }
    
    /**
     * 绑定解除 日志记录
     * @param param
     * @param result
     */
    public void insertBindCancellog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        
            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bindCancel.getTradeType()); //系统跟踪号
            param.setBindCacnel_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setBindCacnel_time_stamp(timeStamp);
            String tradeType = TradeType.bindCancel.getTradeType(); //业务类型
            param.setBindCacnel_trade_type(tradeType);
             
            //调用绑定解除接口前插日志表
            int n1 = unionPayDao.insertBindCancellog(param.getPay_sys_trade_no(), //pay_id
            		param.getPay_sys_trade_no().substring(14, 16), //partition_id
                            MD5Util.convertMD5(param.getSign_code()), //银联支付接口时插入md5 加密后的签约号,用于退款时知道退到哪个账户
                            param.getPay_time_stamp(), //req_time
                            "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                    param.getBindCacnel_trade_type(), //req_trade_type
                                    param.getBindCacnel_sys_trade_no(), //sys_trade_no
                                    param.getOrder_id()
                    );
            
            if(n1 <= 0){
            	//都成功则result为空
            	result.put("status", "E07");
            	result.put("detail", "支付失败！银行卡绑定解除日志流水插入失败");
            	//return result; //直接返回
            }
        
        //return result;
    }
    
    /**
     * 发送绑定解除接口
     * @param param
     * @param result
     * @return
     */
    public void sendBindCancelReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genBindCancelReq(param);
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }    
            
            if(!isSuccess){
            	result.put("status", "E08");
            	result.put("detail", "支付失败！发送绑定解除接口报文失败");
            	//return result; //直接返回
            }
            
        //return result;
    }
    
    /**
     * 等待绑定解除接口的返回
     * @param param
     * @param result
     */
    public void waitForBindCancelResp(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                result.put("status", "E09");
                result.put("detail", "支付失败！发送解除绑定接口报文后未接收到银联响应");
                break;
            }
            try {
                Thread.sleep(UnionPayCons.SLEEP_INTERVAL_BIND);
                timeout += UnionPayCons.SLEEP_INTERVAL_BIND;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待4秒钟
            Map<String, String> row = unionPayDao.queryPaylog(param.getBindCacnel_sys_trade_no()); //查询支付日志表里是否已经有银联返回的结果了
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                if(UnionPayCons.RESULT_CODE_SUCCESS.equals(row.get("RESULT_CODE"))){
                    result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
                    result.put("detail", "绑定解除成功！");
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
     * 收到银联绑定解除接口的返回后，更新paylog日志表<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateBindCancellog(Map<String, String> respMap) {
        return unionPayDao.updateBindCancellog(respMap.get(UnionPayAttrs.TradeType), respMap.get(UnionPayAttrs.resultCode),
                respMap.get(UnionPayAttrs.resultDesc), respMap.get(UnionPayAttrs.timeStamp),
                respMap.get(UnionPayAttrs.sysTradeNo));
    }  
    
    /**
     * 收到银联绑定解除接口的返回后,如果解除成功，需要更新签约信息表的valid_flag为3<br>
     * 〈功能详细描述〉
     *
     * @param respMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateSignCodeValidFlag(Map<String, String> respMap) {
        String sign_code = MD5Util.convertMD5(respMap.get(UnionPayAttrs.signCode)); //表里存放md5加密的签约号
        return unionPayDao.updateSignCodeValidFlag(sign_code, "3"); //0:还未绑定 1:绑定成功 2:绑定失败 3:绑定解除
    }
    
    
    /**
     * 插入绑定日志记录 签约号先空着等待绑定接口返回后更新，
     * 此方法为银联改造后新的逻辑，发送绑定接口前不再插签约信息表
     * @param param
     * @return
     */
    public void insertBindlog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;

            String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.bind.getTradeType()); //系统跟踪号
            param.setBind_sys_trade_no(sysTradeNo);
            String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
            param.setBind_time_stamp(timeStamp);
            String tradeType = TradeType.bind.getTradeType(); //业务类型
            param.setBind_trade_type(tradeType);
            
            //调用绑定接口前插订单支付日志表
            int n2 = unionPayDao.insertBindlog(param.getBind_sys_trade_no(), //pay_id
            		param.getBind_sys_trade_no().substring(14, 16), //partition_id
            		"01",  //pay_type
            		param.getCard_type().equals("01") ? "11" : "12", //pay_mode
            				"0", //pay_state 初始0已发起支付
            				param.getBind_time_stamp(), //req_time
            				"00", //isSuccess ? "00" : "01",  //req_status  这边有点问题，其实还没发送出去，就写了发送成功状态
            						param.getBind_trade_type(), //req_trade_type
            						param.getBind_sys_trade_no(), //sys_trade_no
            						param.getOrder_id(),
            						param.getFee()  //订单传过来是厘，传给银联单位是分 需要乘以10
            		);

            if(n2>0){
            	//成功则result为空
            }
            else{
                result.put("status", "E01");
                result.put("detail", "支付失败！绑定日志插入失败");
                //return result; //直接返回
            }   
        
        //return result;
    }
    
    /**
     * 绑定成功发送后等待银联返回签约号
     * 此方法为银联改造后新的逻辑
     * @param param
     * @param result
     */
    public void waitForBindRespNew(UnionPayParam param, Map<String, String> result){
    	//Map<String, String> result = new HashMap<String, String>();
        //如果绑定接口调用成功就要开始等待银联返回签约号了，如果超时未返回则支付失败
            int timeout = 0;
            while(true){
                if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                    result.put("status", "E03");
                    result.put("detail", "支付失败！发送绑定接口报文后未接收到银联响应");
                    break;
                }
                try {
                    Thread.sleep(UnionPayCons.SLEEP_INTERVAL_BIND);
                    timeout += UnionPayCons.SLEEP_INTERVAL_BIND;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } //每次轮询等待1秒钟
                //Map<String, String> row = unionPayDao.querySignCode(param.getBank_card_no()); //查询签约表里是否已经有银联返回的结果了
                //查询绑定接口日志表里是否已经有银联返回的结果了
                Map<String, String> bindResultRow = unionPayDao.queryBindResultRow(param.getBind_sys_trade_no()); 
                if(bindResultRow != null){
                	//如果绑定返回码是00成功,如果失败则返回错误码和错误提示
                	if(UnionPayCons.RESULT_CODE_SUCCESS.equals(bindResultRow.get("RESULT_CODE"))){
                		param.setSign_code(MD5Util.convertMD5(bindResultRow.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
                	}
                	else{
                		result.put("status", bindResultRow.get("RESULT_CODE"));
                        result.put("detail", bindResultRow.get("RESULT_DESC"));
                	}
                    break;
                }
            }
        
        //return result;
    }
    
    
    /**
     * 支付交易撤销（指当日交易撤消）
     * @param param
     * @param result
     * @return
     */
    public void insertPayCancellog(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        
    	//下面这段挪到 refundOrder 里面
/*	    String sysTradeNo = UnionPayUtil.genSysTradeNo(TradeType.payCancel.getTradeType()); //系统跟踪号
	    param.setPayCalcel_sys_trade_no(sysTradeNo);
	    String timeStamp = DateUtils.getCurentTime(); //当前请求时间戳
	    param.setPayCalcel_time_stamp(timeStamp);
	    String tradeType = TradeType.payCancel.getTradeType(); //业务类型
	    param.setPayCalcel_trade_type(tradeType);*/
	    
	    //String orderIdVir = UnionPayUtil.orderId2newOrderId(param.getOrder_id(), param.getPay_sys_trade_no()); //虚拟订单号，每次支付不重复
        //param.setOrder_id_vir(orderIdVir);
         
        //调用 退款 接口前插订单支付日志表
        int n2 = unionPayDao.insertPayCancellog(
        		param.getPayCalcel_sys_trade_no(), //log_id
        		param.getPayCalcel_sys_trade_no().substring(14, 16), //partition_id
        		param.getOrder_id(), // real_order_id
                param.getPayCalcel_time_stamp(), //req_time
                        "00", //isSuccess ? "00" : "01",  //req_status  这边其实有点问题，还没发送，就写发送成功状态
                                param.getPayCalcel_trade_type(), //req_trade_type
                                param.getPayCalcel_sys_trade_no(), //sys_trade_no
                                param.getPayCalcel_sys_trade_no(),  //退款时 虚拟order_id 直接填的sys_trade_no
                                param.getOrig_txn_amt(),      //txn_amt 退款时填的是原来支付成功的金额
                                //null, //orig_pay_id 这个字段作废，插null
                                param.getOrig_timestamp(),   // orig_timestamp
                                param.getOrig_sys_trade_no(), //orig_sys_trade_no
                                param.getOrig_order_id(),  //orig_order_id 其实插的是原来支付日志里的虚拟order_id
                                param.getOrig_txn_amt()  //orig_txn_amt
                );
	     
	    if(n2 <= 0){
	    	//都成功则result为空
	    	result.put("status", "E04");
	    	result.put("detail", "退款失败！退款日志流水插入失败");
	    	//return result; //直接返回
	    }
        
        //return result;
    }
    
    
    /**
     * 发送退单 wenh 发送请求
     * @param param
     * @param result
     * @return
     */
    public void sendPayCancelReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayCancelReq(param);
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
        
    /**
     * 等待银联返回数据 wenh
     * @param param
     * @param result
     * @return
     */
    public void waitForPayCancelResp(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        int timeout = 0;
        while(true){
            if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                result.put("status", "E06");
                result.put("detail", "退款失败！发送退款接口报文后未接收到银联响应");
                break;
            }
            try {
                Thread.sleep(UnionPayCons.SLEEP_INTERVAL_PAY);
                timeout += UnionPayCons.SLEEP_INTERVAL_PAY;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //每次轮询等待4秒钟
            Map<String, String> row = unionPayDao.queryUnionPaylog(param.getPayCalcel_sys_trade_no()); //查询支付日志表里是否已经有银联返回的结果了
            if(row != null && StringUtils.isNotBlank(row.get("RESULT_CODE"))){
                if(UnionPayCons.RESULT_CODE_SUCCESS.equals(row.get("RESULT_CODE"))){
                    result.put("status", UnionPayCons.RESULT_CODE_SUCCESS);
                    result.put("detail", "退款请求成功！");
                }
                else{
                    result.put("status", row.get("RESULT_CODE"));
                    result.put("detail", "退款请求失败！" + row.get("RESULT_DESC"));
                }
                break;
            }
        }
        
        //return result;
    }    
    
    
    /**
     * 银联全要素支付 退款 用第一套商户号
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
			insertPayCancellog(param, result); //插银联日志
			if(!result.isEmpty()){
				return result; 
			}
			sendPayCancelReq(param, result); //发送接口请求
			if(!result.isEmpty()){
				return result; 
			}
			waitForPayCancelResp(param, result); //等待银联响应
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
     * 发送支付结果查询接口请求
     * @param param
     * @param result
     * @return
     */
    public void sendPayQryReq(UnionPayParam param, Map<String, String> result){
        //Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayQryReq(param); 
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            	//isSuccess = ClientHandler.sendMsg(xmlSend);
            }    
            
            if(!isSuccess){
            	result.put("status", "E05");
            	result.put("detail", "支付查询失败！发送支付查询接口报文失败");
            	//return result; //直接返回
            }
            
        //return result;
    } 
    
    /**
     * 根据虚拟的orderId 到 pay_d_unionpay_log 查出真实orderId
     * @param orderIdVir
     * @return
     */
    public Map<String, String> queryRealOrderId(String orderIdVir) {
        //
        Map<String, String> reealOrderId = unionPayDao.queryRealOrderId(orderIdVir);
        return reealOrderId;
    }
    
}
