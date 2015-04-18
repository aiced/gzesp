package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsPGOODSRULE;
import com.ai.gzesp.dao.beans.TdCmsPGOODSRULEKey;
import com.ai.gzesp.dao.persistence.TdCmsPGOODSRULEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdCmsPGOODSRULEDao
* @Description: CMS_P_GOODS_RULE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdCmsPGOODSRULEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdCmsPGOODSRULEDao.class);

    /**
     * @Fields TdCmsPGOODSRULE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdCmsPGOODSRULEMapper tdCmsPGOODSRULEMapper;

    /**
    * @Title TdCmsPGOODSRULEDao.countByExample
    * @Description: 根据查询条件，计算CMS_P_GOODS_RULE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdCmsPGOODSRULEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdCmsPGOODSRULEDao.selectByPrimaryKey
    * @Description: 根据主键类，返回CMS_P_GOODS_RULE
    * @param key key
    * @return TdCmsPGOODSRULE bean对象
     */
    public TdCmsPGOODSRULE selectByPrimaryKey(TdCmsPGOODSRULEKey key) {
        return this.tdCmsPGOODSRULEMapper.selectByPrimaryKey(key);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.selectByExample
    * @Description: 根据查询条件类，返回CMS_P_GOODS_RULE结果集
    * @param example 通用查询条件类
    * @return List<TdCmsPGOODSRULE>CMS_P_GOODS_RULE结果集
     */
    public List<TdCmsPGOODSRULE> selectByExample(Criteria example) {
        return this.tdCmsPGOODSRULEMapper.selectByExample(example);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除CMS_P_GOODS_RULE
    * @param key key
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(TdCmsPGOODSRULEKey key) {
        return this.tdCmsPGOODSRULEMapper.deleteByPrimaryKey(key);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新CMS_P_GOODS_RULE部分字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdCmsPGOODSRULE record) {
        return this.tdCmsPGOODSRULEMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.updateByPrimaryKey
    * @Description: 根据主键更新CMS_P_GOODS_RULE全部字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdCmsPGOODSRULE record) {
        return this.tdCmsPGOODSRULEMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.deleteByExample
    * @Description: 根据查询条件，删除CMS_P_GOODS_RULE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdCmsPGOODSRULEMapper.deleteByExample(example);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_P_GOODS_RULE部分字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdCmsPGOODSRULE record, Criteria example) {
        return this.tdCmsPGOODSRULEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.updateByExample
    * @Description: 根据查询条件更新CMS_P_GOODS_RULE全表字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdCmsPGOODSRULE record, Criteria example) {
        return this.tdCmsPGOODSRULEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.insert
    * @Description: 插入一个CMS_P_GOODS_RULE
    * @param record CMS_P_GOODS_RULE的bean对象
    * @return int  插入个数
     */
    public int insert(TdCmsPGOODSRULE record) {
        return this.tdCmsPGOODSRULEMapper.insert(record);
    }

    /**
    * @Title TdCmsPGOODSRULEDao.insertSelective
    * @Description: 插入一个只有部分字段的CMS_P_GOODS_RULE
    * @param record 只含部分字段的CMS_P_GOODS_RULE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdCmsPGOODSRULE record) {
        return this.tdCmsPGOODSRULEMapper.insertSelective(record);
    }
}