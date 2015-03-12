package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFFROLE;
import com.ai.gzesp.dao.persistence.TdSysDSTAFFROLEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTAFFROLEDao
* @Description: SYS_D_STAFF_ROLE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTAFFROLEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTAFFROLEDao.class);

    /**
     * @Fields TdSysDSTAFFROLE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTAFFROLEMapper tdSysDSTAFFROLEMapper;

    /**
    * @Title TdSysDSTAFFROLEDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF_ROLE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTAFFROLEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTAFFROLEDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF_ROLE结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFFROLE>SYS_D_STAFF_ROLE结果集
     */
    public List<TdSysDSTAFFROLE> selectByExample(Criteria example) {
        return this.tdSysDSTAFFROLEMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTAFFROLEDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF_ROLE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTAFFROLEMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTAFFROLEDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF_ROLE部分字段
    * @param record 要更新成为的TdSysDSTAFFROLE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTAFFROLE record, Criteria example) {
        return this.tdSysDSTAFFROLEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTAFFROLEDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF_ROLE全表字段
    * @param record 要更新成为的TdSysDSTAFFROLE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTAFFROLE record, Criteria example) {
        return this.tdSysDSTAFFROLEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTAFFROLEDao.insert
    * @Description: 插入一个SYS_D_STAFF_ROLE
    * @param record SYS_D_STAFF_ROLE的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTAFFROLE record) {
        return this.tdSysDSTAFFROLEMapper.insert(record);
    }

    /**
    * @Title TdSysDSTAFFROLEDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF_ROLE
    * @param record 只含部分字段的SYS_D_STAFF_ROLE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTAFFROLE record) {
        return this.tdSysDSTAFFROLEMapper.insertSelective(record);
    }
}