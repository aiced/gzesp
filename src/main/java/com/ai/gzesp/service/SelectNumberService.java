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
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> queryNumberListByPage(String eparchy_code, String nice_rule, int nice_fee_start,
            int nice_fee_end, int pageNum, int pageSize, String keyword, String sort, String sortCol) {
        return orderDao.queryNumberListByPage(eparchy_code, nice_rule, nice_fee_start, nice_fee_end, pageNum, pageSize,
                keyword, sort, sortCol);
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

}
