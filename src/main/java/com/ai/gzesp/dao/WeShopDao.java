package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WeShopDao {

    public Map<Object, Object> getDevloperInfo(@Param("user_id") String user_id);

    public List<Map<Object, Object>> getBanners();

    public List<Map<Object, Object>> getDztj(@Param("user_id") String user_id);

    public List<Map<Object, Object>> getRxhy();

    public List<Map<Object, Object>> getRxwk();

    public List<Map<Object, Object>> getGoodPhotos(@Param("goods_id") String goods_id);

    public Map<Object, Object> getGoodDetail(@Param("goods_id") String goods_id, @Param("user_id") String user_id);

    public List<Map<Object, Object>> getCitys();

    public List<Map<Object, Object>> getAttrs(@Param("goods_id") String goods_id);

    public List<Map<Object, Object>> queryGoodListByPage(@Param("ctlgArray") String[] ctlgArray,
            @Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("keyword") String keyword,
            @Param("sort") String sort, @Param("sortCol") String sortCol);
}
