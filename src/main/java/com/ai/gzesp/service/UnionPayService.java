package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.UnionPayDao;
import com.ai.gzesp.dto.UnionPayParam;
import com.ai.gzesp.unionpay.UnionPayAttrs;
import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.unionpay.UnionPayUtil;
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
    
    
/*    public Map<Object, Object> getSignCode(String bank_card_no, String bank_card_expire_date, String bank_card_cvn,
            String id_card_no, String phone_no, String full_name) {
        return unionPayDao.getSignCode(bank_card_no, bank_card_expire_date, bank_card_cvn, id_card_no, phone_no,
                full_name);
    }
*/
    
    public Map<String, String> bindAndPay(UnionPayParam param){
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
    }
    
    private Map<String, String> sendBindReq(UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        try {
            //银行卡绑定接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genBindReq(param);
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            
/*            //调用绑定接口前插签约信息表，sign_code 空着，后面等待银联返回后根据sys_trade_no更新sign_code
            int n1 = unionPayDao.insertSignCode(xmlMap.get(UnionPayAttrs.accNo), 
                    xmlMap.get(UnionPayAttrs.cvn2), xmlMap.get(UnionPayAttrs.Nbr), xmlMap.get(UnionPayAttrs.Name), 
                    xmlMap.get(UnionPayAttrs.certificateCode), xmlMap.get(UnionPayAttrs.expireDate), 
                    xmlMap.get(UnionPayAttrs.currencyCode), xmlMap.get(UnionPayAttrs.sysTradeNo));*/
            
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            }
            
            //调用绑定接口后插订单支付日志表
            int n2 = unionPayDao.insertBindlog(xmlMap.get(UnionPayAttrs.sysTradeNo), //pay_id
                    xmlMap.get(UnionPayAttrs.sysTradeNo).substring(14, 16), //partition_id
                    "01",  //pay_type
                    xmlMap.get(UnionPayAttrs.cardType).equals("01") ? "11" : "12", //pay_mode
                            "0", //pay_state 初始0已发起支付
                            xmlMap.get(UnionPayAttrs.timeStamp), //req_time
                            isSuccess ? "00" : "01",  //req_status
                                    xmlMap.get(UnionPayAttrs.TradeType), //req_trade_type
                                    xmlMap.get(UnionPayAttrs.sysTradeNo), //sys_trade_no
                                    param.getOrder_id(),
                                    param.getFee(),
                                    xmlMap.get(UnionPayAttrs.accNo),     
                                    xmlMap.get(UnionPayAttrs.cvn2),
                                    xmlMap.get(UnionPayAttrs.Nbr),
                                    xmlMap.get(UnionPayAttrs.Name), 
                                    xmlMap.get(UnionPayAttrs.certificateCode),
                                    xmlMap.get(UnionPayAttrs.expireDate)
                    );
            
            //如果绑定接口调用成功就要开始等待银联返回签约号了，如果超时未返回则支付失败
            if(isSuccess && n2>0){
                int timeout = 0;
                while(true){
                    if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                        result.put("status", "E11");
                        result.put("detail", "支付失败！发送绑定接口报文后未接收到银联响应");
                        break;
                    }
                    try {
                        Thread.sleep(UnionPayCons.SLEEP_INTERVAL);
                        timeout += UnionPayCons.SLEEP_INTERVAL;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } //每次轮询等待5秒钟
                    Map<String, String> row = unionPayDao.querySignCode(param.getBank_card_no()); //查询签约表里是否已经有银联返回的结果了
                    if(row != null){
                        param.setSign_code(MD5Util.convertMD5(row.get("SIGN_CODE"))); //md5解密，表里存放的是加密的
                        result = sendPayReq(param); //调用支付接口
                        break;
                    }
                }
            }
            else{
                result.put("status", "E13");
                result.put("detail", "支付失败！发送绑定接口报文失败 或 日志流水插入失败");
            }  
        } catch (Exception e) {
            result.put("status", "E14");
            result.put("detail", "支付失败！发送绑定接口报文失败 或 日志流水插入失败");
            e.printStackTrace();
            return result;
        }   
        
        return result;
    }
    
    private Map<String, String> sendPayReq(UnionPayParam param){
        Map<String, String> result = new HashMap<String, String>();
        boolean isSuccess = false;
        try {
            //银行卡支付接口 参数封装成map,转换层xml，生成md5摘要，3des加密,生成可发送的报文
            Map<String, String> xmlMap = UnionPayUtil.genPayReq(param);
            byte[] xmlSend = UnionPayUtil.genByteReq(xmlMap);
            //调用mina客户端发送报文
            if(xmlSend != null){
                isSuccess = UnionPayUtil.sendMsg(xmlSend);
            }    
            
            //调用支付接口后插订单支付日志表
            int n2 = unionPayDao.insertPaylog(xmlMap.get(UnionPayAttrs.sysTradeNo), //pay_id
                    xmlMap.get(UnionPayAttrs.sysTradeNo).substring(14, 16), //partition_id
                    "01",  //pay_type
                    xmlMap.get(UnionPayAttrs.cardType).equals("01") ? "11" : "12", //pay_mode
                            "0", //pay_state 初始0已发起支付
                            xmlMap.get(UnionPayAttrs.timeStamp), //req_time
                            isSuccess ? "00" : "01",  //req_status
                                    xmlMap.get(UnionPayAttrs.TradeType), //req_trade_type
                                    xmlMap.get(UnionPayAttrs.sysTradeNo), //sys_trade_no
                                    param.getOrder_id(),
                                    param.getFee()
                    );
            
            //如果支付接口调用成功就要开始等待银联返回了，如果超时未返回则支付失败
            if(isSuccess && n2>0){
                int timeout = 0;
                while(true){
                    if(timeout >= UnionPayCons.WAIT_TIMEOUT){
                        result.put("status", "E21");
                        result.put("detail", "支付失败！发送支付接口报文后未接收到银联响应");
                        break;
                    }
                    try {
                        Thread.sleep(UnionPayCons.SLEEP_INTERVAL);
                        timeout += UnionPayCons.SLEEP_INTERVAL;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } //每次轮询等待5秒钟
                    Map<String, String> row = unionPayDao.queryPaylog(xmlMap.get(UnionPayAttrs.sysTradeNo) ); //查询支付日志表里是否已经有银联返回的结果了
                    if(row != null && row.get("RESULT_CODE") != null){
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
            }
            else{
                result.put("status", "E23");
                result.put("detail", "支付失败！发送支付接口报文失败 或 日志流水插入失败");
            }
        } catch (Exception e) {
            result.put("status", "E24");
            result.put("detail", "支付失败！发送支付接口其他异常");
            e.printStackTrace();
            return result;
        }  
        
        return result;
    }
    
    private void checkParam(UnionPayParam param, Map<String, String> signCodeRow, Map<String, String> result) {

    }
    
/*    public Map<String, String> querySignCode(String bank_card_no, String bank_card_cvn, String phone_no,
            String full_name, String id_card_no, String bank_card_expire_date) {
        return unionPayDao.querySignCode(bank_card_no, bank_card_cvn, phone_no, full_name, id_card_no,
                bank_card_expire_date);
    }
    
    public int insertSignCode(Map<String, String> respMap) {
        return unionPayDao.insertSignCode(respMap);
    }*/
}
