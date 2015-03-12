package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDDEAL;
import com.ai.gzesp.dao.persistence.TdOrdDDEALMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDDEALDao
* @Description: ORD_D_DEAL表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDDEALDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDDEALDao.class);

    /**
     * @Fields TdOrdDDEAL表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDDEALMapper tdOrdDDEALMapper;

    /**
    * @Title TdOrdDDEALDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_DEAL个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDDEALMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDDEALDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_DEAL结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDDEAL>ORD_D_DEAL结果集
     */
    public List<TdOrdDDEAL> selectByExample(Criteria example) {
        return this.tdOrdDDEALMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDDEALDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_DEAL
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDDEALMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDDEALDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_DEAL部分字段
    * @param record 要更新成为的TdOrdDDEAL对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDDEAL record, Criteria example) {
        return this.tdOrdDDEALMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDDEALDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_DEAL全表字段
    * @param record 要更新成为的TdOrdDDEAL对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDDEAL record, Criteria example) {
        return this.tdOrdDDEALMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDDEALDao.insert
    * @Description: 插入一个ORD_D_DEAL
    * @param record ORD_D_DEAL的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDDEAL record) {
        return this.tdOrdDDEALMapper.insert(record);
    }

    /**
    * @Title TdOrdDDEALDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_DEAL
    * @param record 只含部分字段的ORD_D_DEAL的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDDEAL record) {
        return this.tdOrdDDEALMapper.insertSelective(record);
    }
}