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
   List<HashMap<Object, Object>>  qslist= qsdao.querystock();
   List<HashMap<Object, Object>> qslinkman=qsdao.queryLinkman();
   Iterator it=qslist.iterator();
   for(int i=0;i<qslist.size();i++){
   Map<Object,Object> map=qslist.get(i);   
   Set<Object> keys=map.keySet();
   //遍历List中的每一个Map集合
   for(Object key:keys){
	 if(key.equals("CARD_VALUE")){//当键值为库存时再调用if，否则会判断两次，equals("CONUT(*)"也可以)
	   if(Integer.parseInt(map.get("COUNT(*)").toString())<3){
		 System.out.println("面额为"+map.get("CARD_VALUE")+"剩余"+map.get("COUNT(*)").toString()+"张");
		   for(int j=0;j<qslinkman.size();j++){
			   Map<Object, Object> map2=qslinkman.get(j);
			   Set<Object> keys2=map2.keySet();
			   //遍历List中的每一个Map集合
			   for(Object key2:keys2){//遍历集合，找出号码
		   SmsUtils.doSendMessage(map2.get("PARAM_VALUE").toString(), "MB-2015111119", "@1@=" + map.get("CARD_VALUE") + ",@2@=" + map.get("COUNT(*)").toString());//发送库存不足短信
			   }
		   }
	   }
	   }
   }//for循环结束
   }
   
     System.out.println("===end===");
	}
}

