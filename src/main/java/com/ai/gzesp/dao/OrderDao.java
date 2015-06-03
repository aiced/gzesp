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
    
    public int insertNumberReserve(@Param("serial_number") String serial_number, @Param("code_state") String code_state); 
    
    public int updateGoodsAmount(@Param("goods_id") String goods_id);
    
    public int updateGoodsAmountReverse(@Param("goodIds") String[] goodIds);
    
    public Map<Object, Object> getNetTypeByGoodsId(@Param("goods_id") String goods_id); 
    
    public List<Map<Object, Object>> queryNumbersTimeout(); 
    
    public List<Map<Object, Object>> queryOrdersTimeout(); 
    
    public List<Map<Object, Object>> queryOrdersTimeout2();
    
    public int releaseNumberState(@Param("numbers") String[] numbers); 
    
    public int deleteNumberReserve(@Param("numbers") String[] numbers); 
    
    public Map<Object, Object> getNumberByOrderId(@Param("order_id") String order_id); 
    
    public int deleteOrderBaseInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderCustInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderDealInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderPostInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderResInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderCMSPreFee(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderProdInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderCMSStateInfo(@Param("orderIds") String[] orderIds);
    
    public int deleteOrderPreCMSFeeInfo(@Param("orderIds") String[] orderIds);
}
