package com.ai.gzesp.dao.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdActDACCESSLOG;
import com.ai.gzesp.dao.persistence.TdActDACCESSLOGMapper;

/**
 * @ClassName: TdActDACCESSLOGDao
* @Description: ACT_D_ACCESS_LOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdActDACCESSLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdActDACCESSLOGDao.class);

    /**
     * @Fields TdActDACCESSLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdActDACCESSLOGMapper tdActDACCESSLOGMapper;

    /**
    * @Title TdActDACCESSLOGDao.countByExample
    * @Description: 根据查询条件，计算ACT_D_ACCESS_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdActDACCESSLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdActDACCESSLOGDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ACT_D_ACCESS_LOG
    * @param logId logId
    * @return TdActDACCESSLOG bean对象
     */
    public TdActDACCESSLOG selectByPrimaryKey(Long logId) {
        return this.tdActDACCESSLOGMapper.selectByPrimaryKey(logId);
    }

    /**
    * @Title TdActDACCESSLOGDao.selectByExample
    * @Description: 根据查询条件类，返回ACT_D_ACCESS_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdActDACCESSLOG>ACT_D_ACCESS_LOG结果集
     */
    public List<TdActDACCESSLOG> selectByExample(Criteria example) {
        return this.tdActDACCESSLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdActDACCESSLOGDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ACT_D_ACCESS_LOG
    * @param logId logId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long logId) {
        return this.tdActDACCESSLOGMapper.deleteByPrimaryKey(logId);
    }

    /**
    * @Title TdActDACCESSLOGDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ACT_D_ACCESS_LOG部分字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdActDACCESSLOG record) {
        return this.tdActDACCESSLOGMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdActDACCESSLOGDao.updateByPrimaryKey
    * @Description: 根据主键更新ACT_D_ACCESS_LOG全部字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdActDACCESSLOG record) {
        return this.tdActDACCESSLOGMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdActDACCESSLOGDao.deleteByExample
    * @Description: 根据查询条件，删除ACT_D_ACCESS_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdActDACCESSLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdActDACCESSLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新ACT_D_ACCESS_LOG部分字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdActDACCESSLOG record, Criteria example) {
        return this.tdActDACCESSLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdActDACCESSLOGDao.updateByExample
    * @Description: 根据查询条件更新ACT_D_ACCESS_LOG全表字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdActDACCESSLOG record, Criteria example) {
        return this.tdActDACCESSLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdActDACCESSLOGDao.insert
    * @Description: 插入一个ACT_D_ACCESS_LOG
    * @param record ACT_D_ACCESS_LOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdActDACCESSLOG record) {
        return this.tdActDACCESSLOGMapper.insert(record);
    }

    /**
    * @Title TdActDACCESSLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的ACT_D_ACCESS_LOG
    * @param record 只含部分字段的ACT_D_ACCESS_LOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdActDACCESSLOG record) {
        return this.tdActDACCESSLOGMapper.insertSelective(record);
    }
    
    public int insertReverseAccessLog(TdActDACCESSLOG record) {
    	 return this.tdActDACCESSLOGMapper.insertReverseAccessLog(record);
    }
    
    public int updateReverseAccessLog(String orderId) {
    	 return this.tdActDACCESSLOGMapper.updateReverseAccessLog(orderId);
    }
}