package com.ai.gzesp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.AppDao;

/**
 * app接口调用service
 * @author xmh
 *
 */
@Service
public class AppService {
	
	@Resource
	private AppDao appDao;
	
	/**
	 * 查询最新版本号
	 */
	public Map<String, String> queryLatestVersion(Map<String, String> param) {
		return appDao.queryLatestVersion(param.get("os"));
	}
	
	/**
	 * 4G 订单状态同步，app每次查询到统一门户的订单状态，要同时保存到沃掌柜里
	 */
	public int updateOrderIntfStatus(Map<String, String> param) {
		return appDao.updateOrderIntfStatus(param.get("phone_number"), param.get("intf_order_status"),
				param.get("intf_order_desc"));
	}
	
	/**
	 * 4G 沃掌柜写卡状态同步，app每次写卡完毕，除了要通知统一门户接口，还要同时保存到沃掌柜里，
	 */
	public int updateWriteCardStatus(Map<String, String> param) {
		return appDao.updateWriteCardStatus(param.get("phone_number"), param.get("write_card_status"));
	}	

}
