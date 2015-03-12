package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.persistence.TdGdsDINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDINFODao
* @Description: GDS_D_INFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDINFODao.class);

    /**
     * @Fields TdGdsDINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDINFOMapper tdGdsDINFOMapper;

    /**
    * @Title TdGdsDINFODao.countByExample
    * @Description: 根据查询条件，计算GDS_D_INFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDINFODao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_INFO结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDINFO>GDS_D_INFO结果集
     */
    public List<TdGdsDINFO> selectByExample(Criteria example) {
        return this.tdGdsDINFOMapper.selectByExampleWithBLOBs(example);
    }

    /**
    * @Title TdGdsDINFODao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_INFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_INFO部分字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDINFO record, Criteria example) {
        return this.tdGdsDINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDINFODao.updateByExample
    * @Description: 根据查询条件更新GDS_D_INFO全表字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDINFO record, Criteria example) {
        return this.tdGdsDINFOMapper.updateByExampleWithBLOBs(record, example);
    }

    /**
    * @Title TdGdsDINFODao.insert
    * @Description: 插入一个GDS_D_INFO
    * @param record GDS_D_INFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDINFO record) {
        return this.tdGdsDINFOMapper.insert(record);
    }

    /**
    * @Title TdGdsDINFODao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_INFO
    * @param record 只含部分字段的GDS_D_INFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDINFO record) {
        return this.tdGdsDINFOMapper.insertSelective(record);
    }
}