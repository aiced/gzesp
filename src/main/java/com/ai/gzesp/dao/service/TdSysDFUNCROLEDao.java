package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDFUNCROLE;
import com.ai.gzesp.dao.persistence.TdSysDFUNCROLEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDFUNCROLEDao
* @Description: SYS_D_FUNCROLE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDFUNCROLEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDFUNCROLEDao.class);

    /**
     * @Fields TdSysDFUNCROLE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDFUNCROLEMapper tdSysDFUNCROLEMapper;

    /**
    * @Title TdSysDFUNCROLEDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_FUNCROLE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDFUNCROLEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDFUNCROLEDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_FUNCROLE结果集
    * @param example 通用查询条件类
    * @return List<TdSysDFUNCROLE>SYS_D_FUNCROLE结果集
     */
    public List<TdSysDFUNCROLE> selectByExample(Criteria example) {
        return this.tdSysDFUNCROLEMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDFUNCROLEDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_FUNCROLE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDFUNCROLEMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDFUNCROLEDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_FUNCROLE部分字段
    * @param record 要更新成为的TdSysDFUNCROLE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDFUNCROLE record, Criteria example) {
        return this.tdSysDFUNCROLEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDFUNCROLEDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_FUNCROLE全表字段
    * @param record 要更新成为的TdSysDFUNCROLE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDFUNCROLE record, Criteria example) {
        return this.tdSysDFUNCROLEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDFUNCROLEDao.insert
    * @Description: 插入一个SYS_D_FUNCROLE
    * @param record SYS_D_FUNCROLE的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDFUNCROLE record) {
        return this.tdSysDFUNCROLEMapper.insert(record);
    }

    /**
    * @Title TdSysDFUNCROLEDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_FUNCROLE
    * @param record 只含部分字段的SYS_D_FUNCROLE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDFUNCROLE record) {
        return this.tdSysDFUNCROLEMapper.insertSelective(record);
    }
}