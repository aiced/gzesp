package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.beans.TdOrdDREFUNDKey;
import com.ai.gzesp.dao.persistence.TdOrdDREFUNDMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDREFUNDDao
* @Description: ORD_D_REFUND表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDREFUNDDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDREFUNDDao.class);

    /**
     * @Fields TdOrdDREFUND表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDREFUNDMapper tdOrdDREFUNDMapper;

    /**
    * @Title TdOrdDREFUNDDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_REFUND个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDREFUNDMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDREFUNDDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_REFUND
    * @param key key
    * @return TdOrdDREFUND bean对象
     */
    public TdOrdDREFUND selectByPrimaryKey(TdOrdDREFUNDKey key) {
        return this.tdOrdDREFUNDMapper.selectByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDREFUNDDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_REFUND结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDREFUND>ORD_D_REFUND结果集
     */
    public List<TdOrdDREFUND> selectByExample(Criteria example) {
        return this.tdOrdDREFUNDMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDREFUNDDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_REFUND
    * @param key key
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(TdOrdDREFUNDKey key) {
        return this.tdOrdDREFUNDMapper.deleteByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDREFUNDDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_REFUND部分字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdOrdDREFUND record) {
        return this.tdOrdDREFUNDMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdOrdDREFUNDDao.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_REFUND全部字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdOrdDREFUND record) {
        return this.tdOrdDREFUNDMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdOrdDREFUNDDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_REFUND
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDREFUNDMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDREFUNDDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_REFUND部分字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDREFUND record, Criteria example) {
        return this.tdOrdDREFUNDMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDREFUNDDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_REFUND全表字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDREFUND record, Criteria example) {
        return this.tdOrdDREFUNDMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDREFUNDDao.insert
    * @Description: 插入一个ORD_D_REFUND
    * @param record ORD_D_REFUND的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDREFUND record) {
        return this.tdOrdDREFUNDMapper.insert(record);
    }

    /**
    * @Title TdOrdDREFUNDDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_REFUND
    * @param record 只含部分字段的ORD_D_REFUND的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDREFUND record) {
        return this.tdOrdDREFUNDMapper.insertSelective(record);
    }
}