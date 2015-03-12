package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPFUNCRIGHT;
import com.ai.gzesp.dao.persistence.TdSysPFUNCRIGHTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPFUNCRIGHTDao
* @Description: SYS_P_FUNCRIGHT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPFUNCRIGHTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPFUNCRIGHTDao.class);

    /**
     * @Fields TdSysPFUNCRIGHT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPFUNCRIGHTMapper tdSysPFUNCRIGHTMapper;

    /**
    * @Title TdSysPFUNCRIGHTDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_FUNCRIGHT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPFUNCRIGHTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_FUNCRIGHT结果集
    * @param example 通用查询条件类
    * @return List<TdSysPFUNCRIGHT>SYS_P_FUNCRIGHT结果集
     */
    public List<TdSysPFUNCRIGHT> selectByExample(Criteria example) {
        return this.tdSysPFUNCRIGHTMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_FUNCRIGHT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPFUNCRIGHTMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_FUNCRIGHT部分字段
    * @param record 要更新成为的TdSysPFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPFUNCRIGHT record, Criteria example) {
        return this.tdSysPFUNCRIGHTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_FUNCRIGHT全表字段
    * @param record 要更新成为的TdSysPFUNCRIGHT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPFUNCRIGHT record, Criteria example) {
        return this.tdSysPFUNCRIGHTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.insert
    * @Description: 插入一个SYS_P_FUNCRIGHT
    * @param record SYS_P_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPFUNCRIGHT record) {
        return this.tdSysPFUNCRIGHTMapper.insert(record);
    }

    /**
    * @Title TdSysPFUNCRIGHTDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_FUNCRIGHT
    * @param record 只含部分字段的SYS_P_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPFUNCRIGHT record) {
        return this.tdSysPFUNCRIGHTMapper.insertSelective(record);
    }
}