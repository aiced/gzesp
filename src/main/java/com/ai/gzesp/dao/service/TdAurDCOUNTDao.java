package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDCOUNT;
import com.ai.gzesp.dao.persistence.TdAurDCOUNTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdAurDCOUNTDao
* @Description: AUR_D_COUNT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdAurDCOUNTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdAurDCOUNTDao.class);

    /**
     * @Fields TdAurDCOUNT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdAurDCOUNTMapper tdAurDCOUNTMapper;

    /**
    * @Title TdAurDCOUNTDao.countByExample
    * @Description: 根据查询条件，计算AUR_D_COUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdAurDCOUNTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdAurDCOUNTDao.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_COUNT结果集
    * @param example 通用查询条件类
    * @return List<TdAurDCOUNT>AUR_D_COUNT结果集
     */
    public List<TdAurDCOUNT> selectByExample(Criteria example) {
        return this.tdAurDCOUNTMapper.selectByExample(example);
    }

    /**
    * @Title TdAurDCOUNTDao.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_COUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdAurDCOUNTMapper.deleteByExample(example);
    }

    /**
    * @Title TdAurDCOUNTDao.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_COUNT部分字段
    * @param record 要更新成为的TdAurDCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdAurDCOUNT record, Criteria example) {
        return this.tdAurDCOUNTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdAurDCOUNTDao.updateByExample
    * @Description: 根据查询条件更新AUR_D_COUNT全表字段
    * @param record 要更新成为的TdAurDCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdAurDCOUNT record, Criteria example) {
        return this.tdAurDCOUNTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdAurDCOUNTDao.insert
    * @Description: 插入一个AUR_D_COUNT
    * @param record AUR_D_COUNT的bean对象
    * @return int  插入个数
     */
    public int insert(TdAurDCOUNT record) {
        return this.tdAurDCOUNTMapper.insert(record);
    }

    /**
    * @Title TdAurDCOUNTDao.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_COUNT
    * @param record 只含部分字段的AUR_D_COUNT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdAurDCOUNT record) {
        return this.tdAurDCOUNTMapper.insertSelective(record);
    }
}