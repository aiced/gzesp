package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdNumDNUMINFO;
import com.ai.gzesp.dao.persistence.TdNumDNUMINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdNumDNUMINFODao
* @Description: NUM_D_NUMINFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdNumDNUMINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdNumDNUMINFODao.class);

    /**
     * @Fields TdNumDNUMINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdNumDNUMINFOMapper tdNumDNUMINFOMapper;

    /**
    * @Title TdNumDNUMINFODao.countByExample
    * @Description: 根据查询条件，计算NUM_D_NUMINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdNumDNUMINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdNumDNUMINFODao.selectByExample
    * @Description: 根据查询条件类，返回NUM_D_NUMINFO结果集
    * @param example 通用查询条件类
    * @return List<TdNumDNUMINFO>NUM_D_NUMINFO结果集
     */
    public List<TdNumDNUMINFO> selectByExample(Criteria example) {
        return this.tdNumDNUMINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdNumDNUMINFODao.deleteByExample
    * @Description: 根据查询条件，删除NUM_D_NUMINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdNumDNUMINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdNumDNUMINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新NUM_D_NUMINFO部分字段
    * @param record 要更新成为的TdNumDNUMINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdNumDNUMINFO record, Criteria example) {
        return this.tdNumDNUMINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdNumDNUMINFODao.updateByExample
    * @Description: 根据查询条件更新NUM_D_NUMINFO全表字段
    * @param record 要更新成为的TdNumDNUMINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdNumDNUMINFO record, Criteria example) {
        return this.tdNumDNUMINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdNumDNUMINFODao.insert
    * @Description: 插入一个NUM_D_NUMINFO
    * @param record NUM_D_NUMINFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdNumDNUMINFO record) {
        return this.tdNumDNUMINFOMapper.insert(record);
    }

    /**
    * @Title TdNumDNUMINFODao.insertSelective
    * @Description: 插入一个只有部分字段的NUM_D_NUMINFO
    * @param record 只含部分字段的NUM_D_NUMINFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdNumDNUMINFO record) {
        return this.tdNumDNUMINFOMapper.insertSelective(record);
    }
}