package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFFFUNCRIGHT;
import com.ai.gzesp.dao.persistence.TdSysDSTAFFFUNCRIGHTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTAFFFUNCRIGHTDao
* @Description: SYS_D_STAFF_FUNCRIGHT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTAFFFUNCRIGHTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTAFFFUNCRIGHTDao.class);

    /**
     * @Fields TdSysDSTAFFFUNCRIGHT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTAFFFUNCRIGHTMapper tdSysDSTAFFFUNCRIGHTMapper;

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF_FUNCRIGHT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTAFFFUNCRIGHTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF_FUNCRIGHT结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFFFUNCRIGHT>SYS_D_STAFF_FUNCRIGHT结果集
     */
    public List<TdSysDSTAFFFUNCRIGHT> selectByExample(Criteria example) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF_FUNCRIGHT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF_FUNCRIGHT部分字段
    * @param record 要更新成为的TdSysDSTAFFFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTAFFFUNCRIGHT record, Criteria example) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF_FUNCRIGHT全表字段
    * @param record 要更新成为的TdSysDSTAFFFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTAFFFUNCRIGHT record, Criteria example) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.insert
    * @Description: 插入一个SYS_D_STAFF_FUNCRIGHT
    * @param record SYS_D_STAFF_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTAFFFUNCRIGHT record) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.insert(record);
    }

    /**
    * @Title TdSysDSTAFFFUNCRIGHTDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF_FUNCRIGHT
    * @param record 只含部分字段的SYS_D_STAFF_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTAFFFUNCRIGHT record) {
        return this.tdSysDSTAFFFUNCRIGHTMapper.insertSelective(record);
    }
}