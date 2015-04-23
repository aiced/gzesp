package com.ai.gzesp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.OrderDao;

@Service
public class SelectNumberService {
    
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
			String sortCol, String net_type) {
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
    
    public int updateNumberState(String serial_number){
        return orderDao.updateNumberState(serial_number);
    }
    
    /**
     * 根据商品id 查询网络类型 是2G/3G/4G/CARD
     * @return
     */
    public Map<Object, Object> getNetTypeByGoodsId(String goods_id){
        return orderDao.getNetTypeByGoodsId(goods_id);
    }

}
