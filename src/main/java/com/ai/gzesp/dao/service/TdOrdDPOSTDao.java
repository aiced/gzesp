package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPOST;
import com.ai.gzesp.dao.persistence.TdOrdDPOSTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDPOSTDao
* @Description: ORD_D_POST表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDPOSTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDPOSTDao.class);

    /**
     * @Fields TdOrdDPOST表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDPOSTMapper tdOrdDPOSTMapper;

    /**
    * @Title TdOrdDPOSTDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_POST个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDPOSTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDPOSTDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_POST结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPOST>ORD_D_POST结果集
     */
    public List<TdOrdDPOST> selectByExample(Criteria example) {
        return this.tdOrdDPOSTMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDPOSTDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_POST
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDPOSTMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDPOSTDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_POST部分字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDPOST record, Criteria example) {
        return this.tdOrdDPOSTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDPOSTDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_POST全表字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDPOST record, Criteria example) {
        return this.tdOrdDPOSTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDPOSTDao.insert
    * @Description: 插入一个ORD_D_POST
    * @param record ORD_D_POST的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDPOST record) {
        return this.tdOrdDPOSTMapper.insert(record);
    }

    /**
    * @Title TdOrdDPOSTDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_POST
    * @param record 只含部分字段的ORD_D_POST的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDPOST record) {
        return this.tdOrdDPOSTMapper.insertSelective(record);
    }
}