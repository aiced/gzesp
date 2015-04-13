package com.ai.gzesp.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    @Autowired
    //@Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate; //常规的JdbcTemplate，固定连接某个db
    
    public Map<String, Object> queryTest() {
        String sql = "select * from SYS_D_UNIONPAY_SIGNCODE";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        
        return map;
    }
}
