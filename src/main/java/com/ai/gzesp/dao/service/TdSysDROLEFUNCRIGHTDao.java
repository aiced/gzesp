package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDROLEFUNCRIGHT;
import com.ai.gzesp.dao.persistence.TdSysDROLEFUNCRIGHTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDROLEFUNCRIGHTDao
* @Description: SYS_D_ROLE_FUNCRIGHT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDROLEFUNCRIGHTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDROLEFUNCRIGHTDao.class);

    /**
     * @Fields TdSysDROLEFUNCRIGHT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDROLEFUNCRIGHTMapper tdSysDROLEFUNCRIGHTMapper;

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_ROLE_FUNCRIGHT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDROLEFUNCRIGHTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_ROLE_FUNCRIGHT结果集
    * @param example 通用查询条件类
    * @return List<TdSysDROLEFUNCRIGHT>SYS_D_ROLE_FUNCRIGHT结果集
     */
    public List<TdSysDROLEFUNCRIGHT> selectByExample(Criteria example) {
        return this.tdSysDROLEFUNCRIGHTMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_ROLE_FUNCRIGHT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDROLEFUNCRIGHTMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_ROLE_FUNCRIGHT部分字段
    * @param record 要更新成为的TdSysDROLEFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDROLEFUNCRIGHT record, Criteria example) {
        return this.tdSysDROLEFUNCRIGHTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_ROLE_FUNCRIGHT全表字段
    * @param record 要更新成为的TdSysDROLEFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDROLEFUNCRIGHT record, Criteria example) {
        return this.tdSysDROLEFUNCRIGHTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.insert
    * @Description: 插入一个SYS_D_ROLE_FUNCRIGHT
    * @param record SYS_D_ROLE_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDROLEFUNCRIGHT record) {
        return this.tdSysDROLEFUNCRIGHTMapper.insert(record);
    }

    /**
    * @Title TdSysDROLEFUNCRIGHTDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_ROLE_FUNCRIGHT
    * @param record 只含部分字段的SYS_D_ROLE_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDROLEFUNCRIGHT record) {
        return this.tdSysDROLEFUNCRIGHTMapper.insertSelective(record);
    }
}