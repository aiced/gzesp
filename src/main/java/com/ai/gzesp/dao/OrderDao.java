package com.ai.gzesp.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ai.gzesp.utils.DateUtils;



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
    
    public int updateOrderBaseState(@Param("orderIds") String[] orderIds);
    
    //edit_by_wenh//订单透明化
    public List<Map<String, Object>> queryOrdersDealLogByOrderId(@Param("order_id") String order_id);
    //edit_by_wenh 充值卡查询
    public List<Map<String, Object>> queryCZCard(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("user_id") String user_id,@Param("czcard_no") String czcard_no,@Param("hidepageindex") int hidepageindex);
    //edit_by_wenh 查询宽带续约产品id
    public Map<String, Object> queryBandGoodsId(@Param("ctlg_code") String ctlg_code);
    //edit_by_wenh 查询宽带续约产品信息
    public Map<String , Object> queryBandProByOrderId(@Param("order_id") String order_id);
    //edit_by_wenh 插入BSSlog日志表
    public int insertBSSLog(	
    		@Param("log_id") String log_id,			//logid
    		@Param("partition_id") String partition_id,	//分区id
    		@Param("interfacename") String interfacename,	//接口名称
    		@Param("create_time") String create_time,
    		@Param("result_code") String result_code,
    		@Param("user_id") String user_id,
    		@Param("band_numid") String band_numid,
    		@Param("user_name") String user_name,
    		@Param("actprovince") String actprovince,
    		@Param("actcity") String actcity,
    		@Param("nettype") String nettype,
    		@Param("paytype") String paytype,
    		@Param("userstatus") String userstatus,
    		@Param("usertype") String usertype,
    		@Param("curproinfo") String curproinfo,
    		@Param("proinfo") String proinfo,
    		@Param("finalproinfo") String finalproinfo,
    		@Param("order_id") String order_id
    		);
    public List<LinkedHashMap<String, String>> queryBandOrderByDate(@Param("req_day") String req_day);

    public int updateOrdBandPay(@Param("order_id") String order_id,@Param("order_state") String order_state);
    
    public List<Map<String, String>> queryOfflineOrders(@Param("user_id") String user_id, 
    		@Param("is_ok") String is_ok,
    		@Param("phone_number") String phone_number, 
    		@Param("start_day") String start_day,
    		@Param("end_day") String end_day,
    		@Param("pageNum") String pageNum, 
    		@Param("pageSize") String pageSize
    		);
    
    public int updateOrderPsptNo(@Param("order_id") String order_id,@Param("pspt_no") String pspt_no,@Param("cust_name") String cust_name);
    
    public int updateOrderCustName(@Param("order_id") String order_id, @Param("cust_name") String cust_name);
    
    public List<Map<String, String>> queryAllPke();
}
