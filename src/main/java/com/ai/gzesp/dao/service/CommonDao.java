package com.ai.gzesp.dao.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.persistence.CommonMapper;


@Service
public class CommonDao extends ITableDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class); 
    
    @Resource
    private CommonMapper commonMapper;
    
    @Resource
    protected JdbcTemplate jdbcTemplate;
    
    public List query(String sql, RowMapper mapping) {
    	return jdbcTemplate.query(sql, mapping);
    }
    
    public void execute(String sql) {
    	jdbcTemplate.execute(sql);
    }
    
    public int update(String sql) {
    	return jdbcTemplate.update(sql);
    }
     
//    public String getCurrent(String seqname){
//        return commonMapper.getCurrent(seqname);         
//    }
     
    public String getNext(String seqname){        
        return commonMapper.getNext(seqname);          
    }
    
    public String getLogId(String seqname){        
        return commonMapper.getLogId(seqname);          
    }
}