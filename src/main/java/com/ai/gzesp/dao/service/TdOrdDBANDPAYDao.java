package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBANDPAY;
import com.ai.gzesp.dao.persistence.TdOrdDBANDPAYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDBANDPAYDao
* @Description: ORD_D_BAND_PAY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDBANDPAYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDBANDPAYDao.class);

    /**
     * @Fields TdOrdDBANDPAY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDBANDPAYMapper tdOrdDBANDPAYMapper;

    /**
    * @Title TdOrdDBANDPAYDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_BAND_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDBANDPAYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDBANDPAYDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_BAND_PAY
    * @param orderId orderId
    * @return TdOrdDBANDPAY bean对象
     */
    public TdOrdDBANDPAY selectByPrimaryKey(Long orderId) {
        return this.tdOrdDBANDPAYMapper.selectByPrimaryKey(orderId);
    }

    /**
    * @Title TdOrdDBANDPAYDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BAND_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBANDPAY>ORD_D_BAND_PAY结果集
     */
    public List<TdOrdDBANDPAY> selectByExample(Criteria example) {
        return this.tdOrdDBANDPAYMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDBANDPAYDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_BAND_PAY
    * @param orderId orderId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long orderId) {
        return this.tdOrdDBANDPAYMapper.deleteByPrimaryKey(orderId);
    }

    /**
    * @Title TdOrdDBANDPAYDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_BAND_PAY部分字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdOrdDBANDPAY record) {
        return this.tdOrdDBANDPAYMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdOrdDBANDPAYDao.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_BAND_PAY全部字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdOrdDBANDPAY record) {
        return this.tdOrdDBANDPAYMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdOrdDBANDPAYDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BAND_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDBANDPAYMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDBANDPAYDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BAND_PAY部分字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDBANDPAY record, Criteria example) {
        return this.tdOrdDBANDPAYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDBANDPAYDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_BAND_PAY全表字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDBANDPAY record, Criteria example) {
        return this.tdOrdDBANDPAYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDBANDPAYDao.insert
    * @Description: 插入一个ORD_D_BAND_PAY
    * @param record ORD_D_BAND_PAY的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDBANDPAY record) {
        return this.tdOrdDBANDPAYMapper.insert(record);
    }

    /**
    * @Title TdOrdDBANDPAYDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BAND_PAY
    * @param record 只含部分字段的ORD_D_BAND_PAY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDBANDPAY record) {
        return this.tdOrdDBANDPAYMapper.insertSelective(record);
    }
}