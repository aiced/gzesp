package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.MyAcctDao;
import com.ai.gzesp.utils.DESUtil;

@Service
public class MyAcctService {

    @Autowired
    private MyAcctDao myAcctDao;
	//通过userid 获得账户信息
    public Map<String, Object> queryAcctByUserId(String user_id) {
        return myAcctDao.queryAcctByUserId(user_id);
    }
    //插入账号信息表
    public int insertAccount(String user_id,String acct_id,String balance,String acct_type,String acct_status,String version)
    {
    	return myAcctDao.insertAccount(user_id,acct_id,balance,acct_type,acct_status,version);
    }
    
    //插入数据 密码表
    public int insertAcctPwd(String user_id,String user_pwd){
    	return myAcctDao.insertAcctPwd(user_id,user_pwd);
    	
    	
    	
    }
    //更新数据 密码表
    public int updateAcctPwd(String user_id,String user_pwd){
    	return myAcctDao.updateAcctPwd(user_id,user_pwd);
    }
    //通过userid获得绑定银行卡信息
    public List<Map<String, Object>> queryAcctBankByUserId(String user_id)
    {
        //查询数据库
        List<Map<String, Object>> acctbankinfo_temp =myAcctDao.queryAcctBankByUserId(user_id);
        List<Map<String, Object>> acctbankinfolist=null;
        if(acctbankinfo_temp == null)
        {
        	return null;
        }
    	acctbankinfolist=new ArrayList<Map<String,Object>>();
    	for (int i = 0; i < acctbankinfo_temp.size(); i++) {
    		Map<String, Object> acctbankinfo=new HashMap<String, Object>();
			for (String key : acctbankinfo_temp.get(i).keySet()) {
				if (key.equalsIgnoreCase("bank_no")){
					byte[] srcBytes=DESUtil.HexString2Bytes(acctbankinfo_temp.get(i).get(key).toString());
        			byte[] bank_no=DESUtil.decryptMode(Constants.desKey.getBytes(),srcBytes);
        			acctbankinfo.put(key, new String(bank_no));
				}
				else {
					acctbankinfo.put(key, acctbankinfo_temp.get(i).get(key));	
				}
			}
			acctbankinfolist.add(acctbankinfo);
		}
        return acctbankinfolist;        

    }
    
    //通过账号和密码判断是否为该用户
    public Map<String, String> queryAcctByUserId_UserPwd(String user_id,String user_pwd)
    {
    	return myAcctDao.queryAcctByUserId_UserPwd(user_id,user_pwd);
    }

    //通过uiserid插入账户银行关系表：ACT_D_BANKCARD
    public int insertAcctBank(String user_id,String bank_no,String cvn2,String phone,String name,String certificate_code,String expire_date,String card_type,String bank_type,String sign_code,String valid_flag,String priority,String systradeno)
    {
    	return myAcctDao.insertAcctBank(user_id,bank_no,cvn2,phone,name,certificate_code,expire_date,card_type,bank_type,sign_code,valid_flag,priority,systradeno);
    }
    //通过userid和银行卡号来
    public int updateAcctBank(String user_id,String bank_no,String cvn2,String phone,String name,String certificate_code,String expire_date,String card_type,String bank_type,String sign_code,String valid_flag,String priority,String systradeno)
    {
    	return myAcctDao.updateAcctBank(user_id,bank_no,cvn2,phone,name,certificate_code,expire_date,card_type,bank_type,sign_code,valid_flag,priority,systradeno);
    }
    //通过userid和银行卡卡号 获得银行详细信息
    public Map<String, Object> queryAcctBankDetail(String user_id,String bank_no)
    {
    	byte[] bank_no_temp=DESUtil.encryptMode(Constants.desKey.getBytes(),bank_no.getBytes());
    	String strbank_no=DESUtil.Bytes2HexString(bank_no_temp);
    	
    	Map<String, Object> acctbankinfo_temp=myAcctDao.queryAcctBankDetail(user_id,strbank_no);
    	
    	if(acctbankinfo_temp ==null)
    	{
        	return null;
    	}
    	
		Map<String, Object> acctbankinfo=new HashMap<String, Object>();
		for (String key : acctbankinfo_temp.keySet()) {
			if (key.equalsIgnoreCase("bank_no")){
				byte[] srcBytes=DESUtil.HexString2Bytes(acctbankinfo_temp.get(key).toString());
    			byte[] bank_no_bak=DESUtil.decryptMode(Constants.desKey.getBytes(),srcBytes);
    			acctbankinfo.put(key, new String(bank_no_bak));
			}
			else {
				acctbankinfo.put(key, acctbankinfo_temp.get(key));	
			}
		}
    	return acctbankinfo;
    }
    
    //通过userid和银行卡卡号 删除绑定银行卡
    public int delAcctBankDetail(String user_id,String bank_no)
    {
    	return myAcctDao.delAcctBankDetail(user_id,bank_no);
    }
    //通过userid 查询收支明细
    public List<Map<String, Object>> queryAcctBalanceLog(String user_id,int iFlag,int page_num,int page_size,String strDate)
    {
    	return myAcctDao.queryAcctBalanceLog(user_id,iFlag,page_num,page_size,strDate);
    }
    
    //通过userid，类型（type），查询收支明细
    public List<Map<String, Object>> queryAcctBalanceLogPage(String user_id,int iFlag,int page_num,int page_size,String strDate)
    {
    	return myAcctDao.queryAcctBalanceLogPage(user_id,iFlag,page_num,page_size,strDate);
    }

    //通过order_id，查询实付金额 普通产品
    public Map<String, String> queryToPayMoneyByOrderId(String order_id)
    {
    	return myAcctDao.queryToPayMoneyByOrderId(order_id);
    }
    //通过order_id，查询实付金额 充值卡缴费查询
    public Map<String, String> queryToPayMoneyCardByOrderId(String order_id)
    {
    	return myAcctDao.queryToPayMoneyCardByOrderId(order_id);
    }
    
    
    //插入ACT_D_WITHDRAW_AUDIT表
    public int insertWidthDrawAuDit(String log_id,String partition_id,String apply_time,String user_id,String withdraw_fee,String audit_state)
    {
    	Double dwithdraw_fee=Double.valueOf(withdraw_fee)*1000;
    	
    	int iRet=-1;
    	iRet=myAcctDao.insertWidthDrawAuDit(log_id,partition_id,apply_time,user_id,dwithdraw_fee,audit_state);
    	
    	if (iRet<=0) {
			return iRet;
		}
    	//后面是需要以后移植到网盟后台的代码
    	//注意事务的处理
    	
    	
    	iRet=updateAcct();
    	if (iRet<=0) {
			return iRet;
		}
    	
    	iRet=insertAccessLog();
    	if (iRet<=0) {
			return iRet;
		}
    	return iRet;
    }
    
    //更新账户表 ACT_D_ACCOUNT
    public int updateAcct()
    {
    	return 0;
    }
    
    //插入账户明细表  ACT_D_ACCESS_LOG
    public int insertAccessLog()
    {
    	return 0;
    }
    
}
