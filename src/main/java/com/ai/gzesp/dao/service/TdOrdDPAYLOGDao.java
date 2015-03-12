package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPAYLOG;
import com.ai.gzesp.dao.persistence.TdOrdDPAYLOGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDPAYLOGDao
* @Description: ORD_D_PAYLOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDPAYLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDPAYLOGDao.class);

    /**
     * @Fields TdOrdDPAYLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDPAYLOGMapper tdOrdDPAYLOGMapper;

    /**
    * @Title TdOrdDPAYLOGDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_PAYLOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDPAYLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDPAYLOGDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PAYLOG结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPAYLOG>ORD_D_PAYLOG结果集
     */
    public List<TdOrdDPAYLOG> selectByExample(Criteria example) {
        return this.tdOrdDPAYLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDPAYLOGDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PAYLOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDPAYLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDPAYLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PAYLOG部分字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDPAYLOG record, Criteria example) {
        return this.tdOrdDPAYLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDPAYLOGDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_PAYLOG全表字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDPAYLOG record, Criteria example) {
        return this.tdOrdDPAYLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDPAYLOGDao.insert
    * @Description: 插入一个ORD_D_PAYLOG
    * @param record ORD_D_PAYLOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDPAYLOG record) {
        return this.tdOrdDPAYLOGMapper.insert(record);
    }

    /**
    * @Title TdOrdDPAYLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PAYLOG
    * @param record 只含部分字段的ORD_D_PAYLOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDPAYLOG record) {
        return this.tdOrdDPAYLOGMapper.insertSelective(record);
    }
}