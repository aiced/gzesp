package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WeShopDao {

    public List<Map<Object, Object>> getDevloperInfo(@Param("developerId") String developerId);
    
    public List<Map<Object, Object>> getBanners();
}
