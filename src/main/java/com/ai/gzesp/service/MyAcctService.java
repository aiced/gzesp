package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.MyAcctDao;
import com.ai.gzesp.utils.DESUtil;

@Service
public class MyAcctService {

    @Autowired
    private MyAcctDao myAcctDao;
    
    @Autowired
    private PayService payService;
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
        return acctbankinfo_temp;  
        
    	//银行卡加密,暂时先去掉，因为在提现的地方，需要知道明文的银行卡卡号，所以把之前密文的地方全部修改了。edit_by_wenh_2015_09_14
//    	acctbankinfolist=new ArrayList<Map<String,Object>>();
//    	for (int i = 0; i < acctbankinfo_temp.size(); i++) {
//    		Map<String, Object> acctbankinfo=new HashMap<String, Object>();
//			for (String key : acctbankinfo_temp.get(i).keySet()) {
//				if (key.equalsIgnoreCase("bank_no")){
//					byte[] srcBytes=DESUtil.HexString2Bytes(acctbankinfo_temp.get(i).get(key).toString());
//        			byte[] bank_no=DESUtil.decryptMode(Constants.desKey.getBytes(),srcBytes);
//        			acctbankinfo.put(key, new String(bank_no));
//				}
//				else {
//					acctbankinfo.put(key, acctbankinfo_temp.get(i).get(key));	
//				}
//			}
//			acctbankinfolist.add(acctbankinfo);
//		}
//        return acctbankinfolist;        

    }
    
    //通过账号和密码判断是否为该用户
    public Map<String, String> queryAcctByUserId_UserPwd(String user_id,String user_pwd)
    {
    	return myAcctDao.queryAcctByUserId_UserPwd(user_id,user_pwd);
    }

    //通过uiserid插入账户银行关系表：ACT_D_BANKCARD
    public int insertAcctBank(String user_id,String bank_no,String cvn2,String phone,String name,String certificate_code,String expire_date,String card_type,String bank_type,String sign_code,String valid_flag,String priority,String systradeno, String bank_branch, String province_code, String eparchy_code, String city_code)
    {
    	return myAcctDao.insertAcctBank(user_id,bank_no,cvn2,phone,name,certificate_code,expire_date,card_type,bank_type,sign_code,valid_flag,priority,systradeno,bank_branch,province_code,eparchy_code,city_code);
    }
    //通过userid和银行卡号来
    public int updateAcctBank(String user_id,String bank_no,String cvn2,String phone,String name,String certificate_code,String expire_date,String card_type,String bank_type,String sign_code,String valid_flag,String priority,String systradeno, String bank_branch, String province_code, String eparchy_code, String city_code)
    {
    	return myAcctDao.updateAcctBank(user_id,bank_no,cvn2,phone,name,certificate_code,expire_date,card_type,bank_type,sign_code,valid_flag,priority,systradeno,bank_branch,province_code,eparchy_code,city_code);
    }
    //通过userid和银行卡号来解绑
    public int updateAcctBankState(String user_id,String bank_no,String valid_flag)
    {
    	return myAcctDao.updateAcctBankState(user_id,bank_no,valid_flag);
    }    
    //通过userid和银行卡卡号 获得银行详细信息
    public Map<String, Object> queryAcctBankDetail(String user_id,String bank_no)
    {
    	//银行卡加密,暂时先去掉，因为在提现的地方，需要知道明文的银行卡卡号，所以把之前密文的地方全部修改了。edit_by_wenh_2015_09_14
    	//
//    	byte[] bank_no_temp=DESUtil.encryptMode(Constants.desKey.getBytes(),bank_no.getBytes());
//    	String strbank_no=DESUtil.Bytes2HexString(bank_no_temp);  	
//    	Map<String, Object> acctbankinfo_temp=myAcctDao.queryAcctBankDetail(user_id,strbank_no);
    	Map<String, Object> acctbankinfo_temp=myAcctDao.queryAcctBankDetail(user_id,bank_no);
    	
    	if(acctbankinfo_temp ==null)
    	{
        	return null;
    	}
    	
    	//银行卡加密,暂时先去掉，因为在提现的地方，需要知道明文的银行卡卡号，所以把之前密文的地方全部修改了。edit_by_wenh_2015_09_14
//		Map<String, Object> acctbankinfo=new HashMap<String, Object>();
//		for (String key : acctbankinfo_temp.keySet()) {
//			if (key.equalsIgnoreCase("bank_no")){
//				byte[] srcBytes=DESUtil.HexString2Bytes(acctbankinfo_temp.get(key).toString());
//    			byte[] bank_no_bak=DESUtil.decryptMode(Constants.desKey.getBytes(),srcBytes);
//    			acctbankinfo.put(key, new String(bank_no_bak));
//			}
//			else {
//				acctbankinfo.put(key, acctbankinfo_temp.get(key));	
//			}
//		}
    	return acctbankinfo_temp;
    }
    //隐藏接口用到的service方法，改方法将act_d_bankcard表中所有银行卡的密文查询出来，然后做一下解密操作。之后在更新成为明文。
    public List<Map<Integer, Object>> queryEnCodeCardNo()
    {
    	List<Map<String, Object>> listacctbankinfo=myAcctDao.queryEnCodeCardNo();
    	List<Map<Integer, Object>> listRet=new ArrayList<Map<Integer,Object>>();
    	
    	for (int i = 0; i < listacctbankinfo.size(); i++) {
			Map<String, Object> mapacctbankinfo=listacctbankinfo.get(i);
			for (String key : mapacctbankinfo.keySet()) {
				if (key.equalsIgnoreCase("bank_no"))
				{
					if (mapacctbankinfo.get(key).toString().length()<30) {
						continue;
					}
					
					byte[] srcBytes=DESUtil.HexString2Bytes(mapacctbankinfo.get(key).toString());
	    			byte[] bank_no_bak=DESUtil.decryptMode(Constants.desKey.getBytes(),srcBytes);
	    			String strdecodebankno=new String(bank_no_bak);
	    			
	    			int iRet=updateDeCodeCardNo(strdecodebankno,mapacctbankinfo.get(key).toString());
				
	    			Map<Integer, Object> map=new HashMap<Integer, Object>();
	    			map.put(i, iRet);
	    			listRet.add(map);
				}
			}
		}
    	return listRet;
    }
    //隐藏接口用到的Serverce方法，改方法将得到的明文，更新act_d_bankcard中的银行卡卡号字段
    /**
     * 
     * @param bank_no_decode 解密后的银行卡号
     * @param bank_no_encode 加密后的银行卡号
     * @return 更新成功的条目数
     */
    public int updateDeCodeCardNo(String bank_no_decode,String bank_no_encode)
    {
    	return myAcctDao.updateDeCodeCardNo(bank_no_decode,bank_no_encode);
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
    public String insertWidthDrawAuDit(String log_id,String partition_id,String apply_time,String user_id,String withdraw_fee,String audit_state,String hide_acctid,String hide_bank_no,String hide_bank_type)
    {
    	//注意提现的地方，金额为负数
    	double dwithdraw_fee=-Double.valueOf(withdraw_fee)*1000;

    	
    	int iRet=-1;
    	iRet=myAcctDao.insertWidthDrawAuDit(log_id,partition_id,apply_time,user_id,dwithdraw_fee,audit_state,hide_bank_no,hide_bank_type);

    	if (iRet<=0) {
			return "操作失败";
		}
    	//后面是需要以后移植到网盟后台的代码
    	//注意事务的处理

    	//String log_tip, String trade_type, String acct_id, int pay_fee, String order_id
    	Map<String, String> map=payService.acctChangeAndAccessLog("账户提现","60",hide_acctid,(int)dwithdraw_fee,null);
    	if (map!=null && map.size()>0) {
    		 return map.get("detail");
		}
    	else {
    		return "操作成功";
		}

    }
    
    /**
     * 获取省份下拉框结果集
     * @return
     */
    public List<Map<String, String>> getProvinceList(String province_code)
    {
    	return myAcctDao.getProvinceList(province_code);
    }
    
    /**
     * 获取地市下拉框结果集，根据省份编码
     * @return
     */
    public List<Map<String, String>> geteEparchyList(String province_code)
    {
    	return myAcctDao.geteEparchyList(province_code);
    }
    
    /**
     * 获取区县下拉框结果集，根据地市编码
     * @return
     */
    public List<Map<String, String>> geteCityList(String eparchy_code)
    {
    	return myAcctDao.geteCityList(eparchy_code);
    }
    
//    //更新账户表 ACT_D_ACCOUNT
//    public int updateAcct()
//    {
//    	return 0;
//    }
//    
//    //插入账户明细表  ACT_D_ACCESS_LOG
//    public int insertAccessLog()
//    {
//    	return 0;
//    }
    
    
    /**
     * 保存 银行卡信息修改
     * @param paramsMap
     * @return
     */
    public int saveBankCardInfo(Map<String, String> paramsMap)
    {
    	return myAcctDao.saveBankCardInfo(paramsMap);
    }
    
}
