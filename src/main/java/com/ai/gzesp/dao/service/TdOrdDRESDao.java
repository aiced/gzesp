package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDRES;
import com.ai.gzesp.dao.persistence.TdOrdDRESMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDRESDao
* @Description: ORD_D_RES表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDRESDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDRESDao.class);

    /**
     * @Fields TdOrdDRES表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDRESMapper tdOrdDRESMapper;

    /**
    * @Title TdOrdDRESDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_RES个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDRESMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDRESDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_RES结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDRES>ORD_D_RES结果集
     */
    public List<TdOrdDRES> selectByExample(Criteria example) {
        return this.tdOrdDRESMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDRESDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_RES
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDRESMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDRESDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_RES部分字段
    * @param record 要更新成为的TdOrdDRES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDRES record, Criteria example) {
        return this.tdOrdDRESMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDRESDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_RES全表字段
    * @param record 要更新成为的TdOrdDRES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDRES record, Criteria example) {
        return this.tdOrdDRESMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDRESDao.insert
    * @Description: 插入一个ORD_D_RES
    * @param record ORD_D_RES的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDRES record) {
        return this.tdOrdDRESMapper.insert(record);
    }

    /**
    * @Title TdOrdDRESDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_RES
    * @param record 只含部分字段的ORD_D_RES的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDRES record) {
        return this.tdOrdDRESMapper.insertSelective(record);
    }
}