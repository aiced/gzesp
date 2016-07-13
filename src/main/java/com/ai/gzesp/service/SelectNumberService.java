package com.ai.gzesp.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;
import com.ai.gzesp.task.ReleaseNumberTask;

@Service
public class SelectNumberService {
	private static Logger log = Logger.getLogger(SelectNumberService.class); 
    
    @Autowired
    private OrderDao orderDao;
    
    /**
     * 功能描述: 按页获取号码列表，包括按关键字搜索，排序，靓号规则筛选，地市筛选<br>
     *
     * @param eparchy_code
     * @param nice_rule
     * @param nice_fee_start
     * @param nice_fee_end
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @param sort
     * @param sortCol
     * @param net_type
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public List<Map<Object, Object>> queryNumberListByPage(String eparchy_code,
			String nice_rule, int nice_fee_start, int nice_fee_end,
			int pageNum, int pageSize, String keyword, String sort,
			String sortCol, String ctlg_code) {
		//此处只能写死对应关系 01:3G，02:2G，03 4G，04:CARD。
		//物品属性表里的 NETTYPE属性的值是 2G/3G/4G/CARD,号码表里的net_type_code是01/02/03/04,
		//20150423 需求又改，iphone5s可以选3g又可以选4g号码，2g不会有，所以这边只需要在sql里限制排除上网卡号码
		String net_type_code = null;
/*		String net_type_code = "01";
		if("2G".equals(net_type)){
			net_type_code = "02";
		}
		else if("3G".equals(net_type)){
			net_type_code = "01";
		}
		else if("4G".equals(net_type)){
			net_type_code = "03";
		}
		else if("CARD".equals(net_type)){
			net_type_code = "04";
		}*/
		
		return orderDao.queryNumberListByPage(eparchy_code, nice_rule,
				nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, sort,
				sortCol, net_type_code);
	}
    
    /**
     * 功能描述: 获取靓号规则<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getNumberRules(){
        return orderDao.getNumberRules();
    }
    
    /**
     * 选择号码后预占号码信息表状态改为预占，号码预占表里新增一条预占记录
     * @param serial_number
     * @return
     */
    public boolean updateNumberState(String serial_number){
    	//更新号码信息表里状态为预占
    	int r1 = orderDao.updateNumberState(serial_number);
    	int r2 = 0;
    	if(r1 > 0){
    		//号码预占表里新增一条预占记录，用于后面 定时任务 释放 超时未支付而预占的号码
    		r2 = orderDao.insertNumberReserve(serial_number, "2"); //2表示预占
    	}
    	if(r1 > 0 && r2 > 0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    /**
     * 根据商品id 查询网络类型 是2G/3G/4G/CARD
     * @return
     */
    public Map<Object, Object> getNetTypeByGoodsId(String goods_id){
        return orderDao.getNetTypeByGoodsId(goods_id);
    }
    
    /**
     * 查询超时预占的号码列表，sql里写死了超时时间为半小时 
     * @return
     */
    public List<Map<Object, Object>> queryNumbersTimeout(){
    	List<Map<Object, Object>> list = orderDao.queryNumbersTimeout();
        log.debug("【号码预占释放定时任务：查询到超时预占号码 " + list.size() + " 个】");
        return list;
    }
    
    /**
     * 释放预占超时的号码，事务控制
     * @param numbers
     * @return
     */
    public boolean releaseNumberState(String[] numbers){
    	//先更新号码信息表状态为上架
        int r1 = orderDao.releaseNumberState(numbers);
        log.debug("【号码预占释放定时任务：号码信息表update " + r1 + " 条记录】");
        int r2 = 0;
        if(r1 > 0){
        	//再删除号码预占表里的记录
        	r2 = orderDao.deleteNumberReserve(numbers);
        	log.debug("【号码预占释放定时任务：号码预占表delete " + r2 + " 条记录】");
        }
        
        if(r1>0 && r2>0){
        	return true;
        }
        else{
        	return false;
        }
        
    }
    
    /**
     * 根据order_id 查找是否用了手机号码
     * @param order_id
     * @return
     */
    public Map<Object, Object> getNumberByOrderId(String order_id){
        return orderDao.getNumberByOrderId(order_id);
    }


    /**
     * 支付成功后删除号码预占表里的记录
     * @param numbers
     * @return
     */
    public int deleteNumberReserve(String[] numbers){
    	int r2 = orderDao.deleteNumberReserve(numbers);
    	StringBuffer sb = new StringBuffer();
    	for(String number : numbers){
    		sb.append(numbers);
    		sb.append(", ");
    	}
    	log.debug("【支付成功：号码预占表delete " + r2 + " 条记录," + sb.toString() + "】");
    	return r2;
    }

}
