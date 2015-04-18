package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsPRULE;
import com.ai.gzesp.dao.persistence.TdCmsPRULEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdCmsPRULEDao
* @Description: CMS_P_RULE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdCmsPRULEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdCmsPRULEDao.class);

    /**
     * @Fields TdCmsPRULE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdCmsPRULEMapper tdCmsPRULEMapper;

    /**
    * @Title TdCmsPRULEDao.countByExample
    * @Description: 根据查询条件，计算CMS_P_RULE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdCmsPRULEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdCmsPRULEDao.selectByPrimaryKey
    * @Description: 根据主键类，返回CMS_P_RULE
    * @param id id
    * @return TdCmsPRULE bean对象
     */
    public TdCmsPRULE selectByPrimaryKey(Long id) {
        return this.tdCmsPRULEMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title TdCmsPRULEDao.selectByExample
    * @Description: 根据查询条件类，返回CMS_P_RULE结果集
    * @param example 通用查询条件类
    * @return List<TdCmsPRULE>CMS_P_RULE结果集
     */
    public List<TdCmsPRULE> selectByExample(Criteria example) {
        return this.tdCmsPRULEMapper.selectByExample(example);
    }

    /**
    * @Title TdCmsPRULEDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除CMS_P_RULE
    * @param id id
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long id) {
        return this.tdCmsPRULEMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title TdCmsPRULEDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新CMS_P_RULE部分字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdCmsPRULE record) {
        return this.tdCmsPRULEMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdCmsPRULEDao.updateByPrimaryKey
    * @Description: 根据主键更新CMS_P_RULE全部字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdCmsPRULE record) {
        return this.tdCmsPRULEMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdCmsPRULEDao.deleteByExample
    * @Description: 根据查询条件，删除CMS_P_RULE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdCmsPRULEMapper.deleteByExample(example);
    }

    /**
    * @Title TdCmsPRULEDao.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_P_RULE部分字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdCmsPRULE record, Criteria example) {
        return this.tdCmsPRULEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdCmsPRULEDao.updateByExample
    * @Description: 根据查询条件更新CMS_P_RULE全表字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdCmsPRULE record, Criteria example) {
        return this.tdCmsPRULEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdCmsPRULEDao.insert
    * @Description: 插入一个CMS_P_RULE
    * @param record CMS_P_RULE的bean对象
    * @return int  插入个数
     */
    public int insert(TdCmsPRULE record) {
        return this.tdCmsPRULEMapper.insert(record);
    }

    /**
    * @Title TdCmsPRULEDao.insertSelective
    * @Description: 插入一个只有部分字段的CMS_P_RULE
    * @param record 只含部分字段的CMS_P_RULE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdCmsPRULE record) {
        return this.tdCmsPRULEMapper.insertSelective(record);
    }
}