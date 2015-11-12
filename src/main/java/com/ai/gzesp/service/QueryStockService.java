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
 * @author dwj
 *@function 查询库存
 */
@Service
public class QueryStockService {
	@Autowired
	private QueryStockDao qsdao;

	public void querystock() {
		List<HashMap<Object, Object>> qslist = qsdao.querystock();// 查询库存
		List<HashMap<Object, Object>> qslinkman = qsdao.queryLinkman();// 查询库存不足时联系人
		Iterator it = qslist.iterator();
		for (int i = 0; i < qslist.size(); i++) {

			Map<Object, Object> map = qslist.get(i);//遍历取出库存每条记录

			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				if (entry.getKey().equals("CARD_VALUE")) {//加上此条件是为了不让短信发送两次
					if (Integer.parseInt(map.get("NUM").toString()) < 10) {//当判断每个面值的库存
						for (int j = 0; j < qslinkman.size(); j++) {
							Map<Object, Object> map2 = qslinkman.get(j);
							for (Map.Entry<Object, Object> entry2 : map2
									.entrySet()) {
								SmsUtils.doSendMessage(entry2.getValue().toString()
										, "MB-2015111119", "@1@="
										+ map.get("CARD_VALUE") + ",@2@="
										+ map.get("NUM").toString());// 发送库存不足短信
							}
						}
					}

				}
			}
		}

	}
}
