package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdLDEALLOG;
import com.ai.gzesp.dao.persistence.TdOrdLDEALLOGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdLDEALLOGDao
* @Description: ORD_L_DEALLOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdLDEALLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdLDEALLOGDao.class);

    /**
     * @Fields TdOrdLDEALLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdLDEALLOGMapper tdOrdLDEALLOGMapper;

    /**
    * @Title TdOrdLDEALLOGDao.countByExample
    * @Description: 根据查询条件，计算ORD_L_DEALLOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdLDEALLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdLDEALLOGDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_L_DEALLOG结果集
    * @param example 通用查询条件类
    * @return List<TdOrdLDEALLOG>ORD_L_DEALLOG结果集
     */
    public List<TdOrdLDEALLOG> selectByExample(Criteria example) {
        return this.tdOrdLDEALLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdLDEALLOGDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_L_DEALLOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdLDEALLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdLDEALLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_L_DEALLOG部分字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdLDEALLOG record, Criteria example) {
        return this.tdOrdLDEALLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdLDEALLOGDao.updateByExample
    * @Description: 根据查询条件更新ORD_L_DEALLOG全表字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdLDEALLOG record, Criteria example) {
        return this.tdOrdLDEALLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdLDEALLOGDao.insert
    * @Description: 插入一个ORD_L_DEALLOG
    * @param record ORD_L_DEALLOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdLDEALLOG record) {
        return this.tdOrdLDEALLOGMapper.insert(record);
    }

    /**
    * @Title TdOrdLDEALLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_L_DEALLOG
    * @param record 只含部分字段的ORD_L_DEALLOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdLDEALLOG record) {
        return this.tdOrdLDEALLOGMapper.insertSelective(record);
    }
}