package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPAY;
import com.ai.gzesp.dao.beans.TdOrdDPAYKey;
import com.ai.gzesp.dao.persistence.TdOrdDPAYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDPAYDao
* @Description: ORD_D_PAY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDPAYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDPAYDao.class);

    /**
     * @Fields TdOrdDPAY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDPAYMapper tdOrdDPAYMapper;

    /**
    * @Title TdOrdDPAYDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDPAYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDPAYDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_PAY
    * @param key key
    * @return TdOrdDPAY bean对象
     */
    public TdOrdDPAY selectByPrimaryKey(TdOrdDPAYKey key) {
        return this.tdOrdDPAYMapper.selectByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDPAYDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPAY>ORD_D_PAY结果集
     */
    public List<TdOrdDPAY> selectByExample(Criteria example) {
        return this.tdOrdDPAYMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDPAYDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_PAY
    * @param key key
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(TdOrdDPAYKey key) {
        return this.tdOrdDPAYMapper.deleteByPrimaryKey(key);
    }

    /**
    * @Title TdOrdDPAYDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_PAY部分字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdOrdDPAY record) {
        return this.tdOrdDPAYMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdOrdDPAYDao.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_PAY全部字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdOrdDPAY record) {
        return this.tdOrdDPAYMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdOrdDPAYDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDPAYMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDPAYDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PAY部分字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDPAY record, Criteria example) {
        return this.tdOrdDPAYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDPAYDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_PAY全表字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDPAY record, Criteria example) {
        return this.tdOrdDPAYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDPAYDao.insert
    * @Description: 插入一个ORD_D_PAY
    * @param record ORD_D_PAY的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDPAY record) {
        return this.tdOrdDPAYMapper.insert(record);
    }

    /**
    * @Title TdOrdDPAYDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PAY
    * @param record 只含部分字段的ORD_D_PAY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDPAY record) {
        return this.tdOrdDPAYMapper.insertSelective(record);
    }
}