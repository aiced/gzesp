package com.ai.osapp.dao.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ai.osapp.dao.persistence.CommonMapper;


@Service
public class CommonDao extends ITableDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class); 
    
    @Resource
    private CommonMapper commonMapper;
    
    @Resource
    protected JdbcTemplate jdbcTemplate;
    
    /**
    sql = "select t1.task_id, t1.task_score from TD_APP_TASK t1 "
  			+ "	where t1.task_type = 4 ";
  	List<String[]> taskIdList = commonDao.query(sql,
  			new RowMapper() {
					public Object mapRow(ResultSet rs, int paramInt)
							throws SQLException {
							String[] strArr = {
									rs.getString("TASK_ID"),
									rs.getString("TASK_SCORE")
							};
					       return strArr;
					}
  	});

  	sql = "update TD_APP_USER_SIGN t1 "
  			+ " set user_score = user_score+"+taskScore
  			+ " where t1.USER_ID in "
  			+ " (select user_id from TD_M_USER "
  			+ "		where preserve_1='"+ inviteCode + "')";
  	
  	int count = commonDao.update(sql);
  	**/
    
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