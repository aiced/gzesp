package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDATTRVAL;
import com.ai.gzesp.dao.persistence.TdGdsDATTRVALMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDATTRVALDao
* @Description: GDS_D_ATTRVAL表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDATTRVALDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDATTRVALDao.class);

    /**
     * @Fields TdGdsDATTRVAL表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDATTRVALMapper tdGdsDATTRVALMapper;

    /**
    * @Title TdGdsDATTRVALDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_ATTRVAL个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDATTRVALMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDATTRVALDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ATTRVAL结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDATTRVAL>GDS_D_ATTRVAL结果集
     */
    public List<TdGdsDATTRVAL> selectByExample(Criteria example) {
        return this.tdGdsDATTRVALMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDATTRVALDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ATTRVAL
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDATTRVALMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDATTRVALDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ATTRVAL部分字段
    * @param record 要更新成为的TdGdsDATTRVAL对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDATTRVAL record, Criteria example) {
        return this.tdGdsDATTRVALMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDATTRVALDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_ATTRVAL全表字段
    * @param record 要更新成为的TdGdsDATTRVAL对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDATTRVAL record, Criteria example) {
        return this.tdGdsDATTRVALMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDATTRVALDao.insert
    * @Description: 插入一个GDS_D_ATTRVAL
    * @param record GDS_D_ATTRVAL的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDATTRVAL record) {
        return this.tdGdsDATTRVALMapper.insert(record);
    }

    /**
    * @Title TdGdsDATTRVALDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ATTRVAL
    * @param record 只含部分字段的GDS_D_ATTRVAL的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDATTRVAL record) {
        return this.tdGdsDATTRVALMapper.insertSelective(record);
    }
}