package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResPRESINFO;
import com.ai.gzesp.dao.persistence.TdResPRESINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdResPRESINFODao
* @Description: RES_P_RESINFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdResPRESINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdResPRESINFODao.class);

    /**
     * @Fields TdResPRESINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdResPRESINFOMapper tdResPRESINFOMapper;

    /**
    * @Title TdResPRESINFODao.countByExample
    * @Description: 根据查询条件，计算RES_P_RESINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdResPRESINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdResPRESINFODao.selectByExample
    * @Description: 根据查询条件类，返回RES_P_RESINFO结果集
    * @param example 通用查询条件类
    * @return List<TdResPRESINFO>RES_P_RESINFO结果集
     */
    public List<TdResPRESINFO> selectByExample(Criteria example) {
        return this.tdResPRESINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdResPRESINFODao.deleteByExample
    * @Description: 根据查询条件，删除RES_P_RESINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdResPRESINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdResPRESINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新RES_P_RESINFO部分字段
    * @param record 要更新成为的TdResPRESINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdResPRESINFO record, Criteria example) {
        return this.tdResPRESINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdResPRESINFODao.updateByExample
    * @Description: 根据查询条件更新RES_P_RESINFO全表字段
    * @param record 要更新成为的TdResPRESINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdResPRESINFO record, Criteria example) {
        return this.tdResPRESINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdResPRESINFODao.insert
    * @Description: 插入一个RES_P_RESINFO
    * @param record RES_P_RESINFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdResPRESINFO record) {
        return this.tdResPRESINFOMapper.insert(record);
    }

    /**
    * @Title TdResPRESINFODao.insertSelective
    * @Description: 插入一个只有部分字段的RES_P_RESINFO
    * @param record 只含部分字段的RES_P_RESINFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdResPRESINFO record) {
        return this.tdResPRESINFOMapper.insertSelective(record);
    }
}