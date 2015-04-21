package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    public List<Map<Object, Object>> queryNumberListByPage(@Param("eparchy_code") String eparchy_code,
            @Param("nice_rule") String nice_rule, @Param("nice_fee_start") int nice_fee_start,
            @Param("nice_fee_end") int nice_fee_end, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
            @Param("keyword") String keyword, @Param("sort") String sort, @Param("sortCol") String sortCol, 
            @Param("net_type_code") String net_type_code);
    
    public List<Map<Object, Object>> getNumberRules(); 
    
    public int updateNumberState(@Param("serial_number") String serial_number); 
    
    public int updateGoodsAmount(@Param("goods_id") String goods_id);
    
    public Map<Object, Object> getNetTypeByGoodsId(@Param("goods_id") String goods_id); 
}
