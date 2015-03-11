package com.ai.gzesp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    public List<Map<Object, Object>> query1(@Param("startMon") String startMon, @Param("endMon")  String endMon);
}
