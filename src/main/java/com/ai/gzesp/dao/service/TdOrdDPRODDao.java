package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPROD;
import com.ai.gzesp.dao.beans.TdOrdDPRODKey;
import com.ai.gzesp.dao.persistence.TdOrdDPRODMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDPRODDao
* @Description: ORD_D_PROD表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDPRODDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDPRODDao.class);

    /**
     * @Fields TdOrdDPROD表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDPRODMapper tdOrdDPRODMapper;

    /**
    * @Title TdOrdDPRODDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_PROD个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDPRODMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDPRODDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_PROD
    * @param key key
    * @return TdOrdDPROD bean对象
     */
    public TdOrdDPROD selectByPrimaryKey(TdOrdDPRODKey key) {
        return this.tdOrdDPRODMapper.selectByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDPRODDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PROD结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPROD>ORD_D_PROD结果集
     */
    public List<TdOrdDPROD> selectByExample(Criteria example) {
        return this.tdOrdDPRODMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDPRODDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_PROD
    * @param key key
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(TdOrdDPRODKey key) {
        return this.tdOrdDPRODMapper.deleteByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDPRODDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_PROD部分字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdOrdDPROD record) {
        return this.tdOrdDPRODMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdOrdDPRODDao.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_PROD全部字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdOrdDPROD record) {
        return this.tdOrdDPRODMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdOrdDPRODDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PROD
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDPRODMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDPRODDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PROD部分字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDPROD record, Criteria example) {
        return this.tdOrdDPRODMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDPRODDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_PROD全表字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDPROD record, Criteria example) {
        return this.tdOrdDPRODMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDPRODDao.insert
    * @Description: 插入一个ORD_D_PROD
    * @param record ORD_D_PROD的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDPROD record) {
        return this.tdOrdDPRODMapper.insert(record);
    }

    /**
    * @Title TdOrdDPRODDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PROD
    * @param record 只含部分字段的ORD_D_PROD的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDPROD record) {
        return this.tdOrdDPRODMapper.insertSelective(record);
    }
}