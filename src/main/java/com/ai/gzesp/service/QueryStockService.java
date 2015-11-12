package com.ai.gzesp.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.QueryStockDao;
import com.ai.gzesp.utils.SmsUtils;
/**
 * @author diwj
 *@function 查询充值卡库存
 */
@Service
public class QueryStockService {
@Autowired
private QueryStockDao qsdao;

	public  void  querystock(){
   List<HashMap<Object, Object>>  qslist= qsdao.querystock();//
   Iterator it=qslist.iterator();
   StringBuffer sb=new StringBuffer();
   for(int i=0;i<qslist.size();i++){
   Map<Object,Object> map=qslist.get(i);   
   Set<Object> keys=map.keySet();
   //遍历List中的每一个Map集合
   for(Object key:keys){
	   if(key.equals("CARD_VALUE")){//当键值为库存时再调用if，否则会判断两次，equals("CONUT(*)"也可以)
	   if(Integer.parseInt(map.get("COUNT(*)").toString())<3){
		   sb.append("面额为"+map.get("CARD_VALUE")+"剩余"+map.get("COUNT(*)").toString()+"张");
	       sb.append("    ********    ");
	   }
	   }
   }
   }
   List<HashMap<Object, Object>> qslinkman=qsdao.queryLinkman();
   System.out.println("++++++++++++"+qslinkman.size()+"++++++++++++");
   for(int i=0;i<qslinkman.size();i++){
	   Map<Object, Object> map2=qslinkman.get(i);
	   Set<Object> keys=map2.keySet();
	   //遍历List中的每一个Map集合
	   for(Object key:keys){//遍历集合，找出号码
		   SmsUtils.doSendMessage(map2.get(key).toString(), "MB-2015052754", "@1@="+sb);//发送库存不足短信
	   }
   }
   
 //  SmsUtils.doSendMessage("13655169732", "MB-2015052754", "@1@="+"我也是醉了");
     System.out.println("===end===");
	}
}

