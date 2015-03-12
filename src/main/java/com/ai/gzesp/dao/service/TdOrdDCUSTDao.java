package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCUST;
import com.ai.gzesp.dao.persistence.TdOrdDCUSTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDCUSTDao
* @Description: ORD_D_CUST表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDCUSTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDCUSTDao.class);

    /**
     * @Fields TdOrdDCUST表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDCUSTMapper tdOrdDCUSTMapper;

    /**
    * @Title TdOrdDCUSTDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_CUST个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDCUSTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDCUSTDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CUST结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCUST>ORD_D_CUST结果集
     */
    public List<TdOrdDCUST> selectByExample(Criteria example) {
        return this.tdOrdDCUSTMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDCUSTDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CUST
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDCUSTMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDCUSTDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CUST部分字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDCUST record, Criteria example) {
        return this.tdOrdDCUSTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDCUSTDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_CUST全表字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDCUST record, Criteria example) {
        return this.tdOrdDCUSTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDCUSTDao.insert
    * @Description: 插入一个ORD_D_CUST
    * @param record ORD_D_CUST的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDCUST record) {
        return this.tdOrdDCUSTMapper.insert(record);
    }

    /**
    * @Title TdOrdDCUSTDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CUST
    * @param record 只含部分字段的ORD_D_CUST的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDCUST record) {
        return this.tdOrdDCUSTMapper.insertSelective(record);
    }
}