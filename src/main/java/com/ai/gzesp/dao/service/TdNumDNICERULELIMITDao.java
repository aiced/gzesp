package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdNumDNICERULELIMIT;
import com.ai.gzesp.dao.persistence.TdNumDNICERULELIMITMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdNumDNICERULELIMITDao
* @Description: NUM_D_NICERULE_LIMIT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdNumDNICERULELIMITDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdNumDNICERULELIMITDao.class);

    /**
     * @Fields TdNumDNICERULELIMIT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdNumDNICERULELIMITMapper tdNumDNICERULELIMITMapper;

    /**
    * @Title TdNumDNICERULELIMITDao.countByExample
    * @Description: 根据查询条件，计算NUM_D_NICERULE_LIMIT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdNumDNICERULELIMITMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdNumDNICERULELIMITDao.selectByExample
    * @Description: 根据查询条件类，返回NUM_D_NICERULE_LIMIT结果集
    * @param example 通用查询条件类
    * @return List<TdNumDNICERULELIMIT>NUM_D_NICERULE_LIMIT结果集
     */
    public List<TdNumDNICERULELIMIT> selectByExample(Criteria example) {
        return this.tdNumDNICERULELIMITMapper.selectByExample(example);
    }

    /**
    * @Title TdNumDNICERULELIMITDao.deleteByExample
    * @Description: 根据查询条件，删除NUM_D_NICERULE_LIMIT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdNumDNICERULELIMITMapper.deleteByExample(example);
    }

    /**
    * @Title TdNumDNICERULELIMITDao.updateByExampleSelective
    * @Description: 根据查询条件更新NUM_D_NICERULE_LIMIT部分字段
    * @param record 要更新成为的TdNumDNICERULELIMIT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdNumDNICERULELIMIT record, Criteria example) {
        return this.tdNumDNICERULELIMITMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdNumDNICERULELIMITDao.updateByExample
    * @Description: 根据查询条件更新NUM_D_NICERULE_LIMIT全表字段
    * @param record 要更新成为的TdNumDNICERULELIMIT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdNumDNICERULELIMIT record, Criteria example) {
        return this.tdNumDNICERULELIMITMapper.updateByExample(record, example);
    }

    /**
    * @Title TdNumDNICERULELIMITDao.insert
    * @Description: 插入一个NUM_D_NICERULE_LIMIT
    * @param record NUM_D_NICERULE_LIMIT的bean对象
    * @return int  插入个数
     */
    public int insert(TdNumDNICERULELIMIT record) {
        return this.tdNumDNICERULELIMITMapper.insert(record);
    }

    /**
    * @Title TdNumDNICERULELIMITDao.insertSelective
    * @Description: 插入一个只有部分字段的NUM_D_NICERULE_LIMIT
    * @param record 只含部分字段的NUM_D_NICERULE_LIMIT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdNumDNICERULELIMIT record) {
        return this.tdNumDNICERULELIMITMapper.insertSelective(record);
    }
}