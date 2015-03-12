package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFF;
import com.ai.gzesp.dao.persistence.TdSysDSTAFFMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTAFFDao
* @Description: SYS_D_STAFF表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTAFFDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTAFFDao.class);

    /**
     * @Fields TdSysDSTAFF表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTAFFMapper tdSysDSTAFFMapper;

    /**
    * @Title TdSysDSTAFFDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTAFFMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTAFFDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFF>SYS_D_STAFF结果集
     */
    public List<TdSysDSTAFF> selectByExample(Criteria example) {
        return this.tdSysDSTAFFMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTAFFDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTAFFMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTAFFDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF部分字段
    * @param record 要更新成为的TdSysDSTAFF对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTAFF record, Criteria example) {
        return this.tdSysDSTAFFMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTAFFDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF全表字段
    * @param record 要更新成为的TdSysDSTAFF对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTAFF record, Criteria example) {
        return this.tdSysDSTAFFMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTAFFDao.insert
    * @Description: 插入一个SYS_D_STAFF
    * @param record SYS_D_STAFF的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTAFF record) {
        return this.tdSysDSTAFFMapper.insert(record);
    }

    /**
    * @Title TdSysDSTAFFDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF
    * @param record 只含部分字段的SYS_D_STAFF的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTAFF record) {
        return this.tdSysDSTAFFMapper.insertSelective(record);
    }
}