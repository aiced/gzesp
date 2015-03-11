package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WeShopDao {

    public List<Map<Object, Object>> getInfo(@Param("startMon") String startMon, @Param("endMon")  String endMon);
}
