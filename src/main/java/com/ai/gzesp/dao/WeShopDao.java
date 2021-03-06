package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ai.gzesp.dto.GoodsDetailResult;

public interface WeShopDao {

    public Map<Object, Object> getDevloperInfo(@Param("user_id") String user_id);

    public List<Map<Object, Object>> getBanners();

    public List<Map<Object, Object>> getDztj(@Param("user_id") String user_id, @Param("mchId") String mchId);

    public List<Map<Object, Object>> getRxhySpecial(@Param("mchId") String mchId);
   
    public List<Map<Object, Object>> getRxhyRest(@Param("goodsArray") String[] goodsArray, @Param("rest_num") int rest_num, @Param("mchId") String mchId);
    
    //edit_by_wenh_2015_4_23
    public List<Map<Object, Object>> getRxtcSpecial(@Param("mchId") String mchId);
    
    public List<Map<Object, Object>> getRxtcRest(@Param("goodsArray") String[] goodsArray, @Param("rest_num") int rest_num, @Param("mchId") String mchId);
    
    public List<Map<Object, Object>> getRxwkSpecial(@Param("mchId") String mchId);
    
    public List<Map<Object, Object>> getRxwkRest(@Param("goodsArray") String[] goodsArray, @Param("rest_num") int rest_num, @Param("mchId") String mchId);
    
    public List<Map<Object, Object>> getGoodPhotos(@Param("goods_id") String goods_id);

    public GoodsDetailResult getGoodDetail(@Param("goods_id") String goods_id, @Param("user_id") String user_id);

    public List<Map<Object, Object>> getCitys();
    
    public List<Map<Object, Object>> getCityByUser(@Param("user_id") String user_id);

    public List<Map<Object, Object>> getAttrs(@Param("goods_id") String goods_id);

    public List<Map<Object, Object>> queryGoodListByPage(@Param("ctlgArray") String[] ctlgArray,
            @Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("keyword") String keyword,
            @Param("sort") String sort, @Param("sortCol") String sortCol, @Param("mchId") String mchId);
    
    public int insertVisitLog(@Param("log_id") String log_id,@Param("partition_id") String partition_id,@Param("store_id") String store_id, @Param("user_id") String user_id);

    public Map<Object, Object> getStoreNum(@Param("goods_id") String goods_id);
    
    public Map<String, String> getCtlgCode(@Param("goods_id") String goods_id);
    
    public List<Map<Object, Object>> queryGoodListById(@Param("goods_list") String[] goods_list);
    
    public Map<String, String> getGoodInfoById(@Param("goods_id") String goods_id);
}
