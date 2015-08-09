package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsDDAILY;
import com.ai.gzesp.dao.persistence.TdCmsDDAILYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdCmsDDAILYDao
* @Description: CMS_D_DAILY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdCmsDDAILYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdCmsDDAILYDao.class);

    /**
     * @Fields TdCmsDDAILY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdCmsDDAILYMapper tdCmsDDAILYMapper;

    /**
    * @Title TdCmsDDAILYDao.countByExample
    * @Description: 根据查询条件，计算CMS_D_DAILY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdCmsDDAILYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdCmsDDAILYDao.selectByExample
    * @Description: 根据查询条件类，返回CMS_D_DAILY结果集
    * @param example 通用查询条件类
    * @return List<TdCmsDDAILY>CMS_D_DAILY结果集
     */
    public List<TdCmsDDAILY> selectByExample(Criteria example) {
        return this.tdCmsDDAILYMapper.selectByExample(example);
    }

    /**
    * @Title TdCmsDDAILYDao.deleteByExample
    * @Description: 根据查询条件，删除CMS_D_DAILY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdCmsDDAILYMapper.deleteByExample(example);
    }

    /**
    * @Title TdCmsDDAILYDao.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_D_DAILY部分字段
    * @param record 要更新成为的TdCmsDDAILY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdCmsDDAILY record, Criteria example) {
        return this.tdCmsDDAILYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdCmsDDAILYDao.updateByExample
    * @Description: 根据查询条件更新CMS_D_DAILY全表字段
    * @param record 要更新成为的TdCmsDDAILY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdCmsDDAILY record, Criteria example) {
        return this.tdCmsDDAILYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdCmsDDAILYDao.insert
    * @Description: 插入一个CMS_D_DAILY
    * @param record CMS_D_DAILY的bean对象
    * @return int  插入个数
     */
    public int insert(TdCmsDDAILY record) {
        return this.tdCmsDDAILYMapper.insert(record);
    }

    /**
    * @Title TdCmsDDAILYDao.insertSelective
    * @Description: 插入一个只有部分字段的CMS_D_DAILY
    * @param record 只含部分字段的CMS_D_DAILY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdCmsDDAILY record) {
        return this.tdCmsDDAILYMapper.insertSelective(record);
    }
}