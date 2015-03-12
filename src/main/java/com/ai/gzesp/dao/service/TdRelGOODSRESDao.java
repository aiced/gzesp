package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdRelGOODSRES;
import com.ai.gzesp.dao.persistence.TdRelGOODSRESMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdRelGOODSRESDao
* @Description: REL_GOODS_RES表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdRelGOODSRESDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdRelGOODSRESDao.class);

    /**
     * @Fields TdRelGOODSRES表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdRelGOODSRESMapper tdRelGOODSRESMapper;

    /**
    * @Title TdRelGOODSRESDao.countByExample
    * @Description: 根据查询条件，计算REL_GOODS_RES个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdRelGOODSRESMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdRelGOODSRESDao.selectByExample
    * @Description: 根据查询条件类，返回REL_GOODS_RES结果集
    * @param example 通用查询条件类
    * @return List<TdRelGOODSRES>REL_GOODS_RES结果集
     */
    public List<TdRelGOODSRES> selectByExample(Criteria example) {
        return this.tdRelGOODSRESMapper.selectByExample(example);
    }

    /**
    * @Title TdRelGOODSRESDao.deleteByExample
    * @Description: 根据查询条件，删除REL_GOODS_RES
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdRelGOODSRESMapper.deleteByExample(example);
    }

    /**
    * @Title TdRelGOODSRESDao.updateByExampleSelective
    * @Description: 根据查询条件更新REL_GOODS_RES部分字段
    * @param record 要更新成为的TdRelGOODSRES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdRelGOODSRES record, Criteria example) {
        return this.tdRelGOODSRESMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdRelGOODSRESDao.updateByExample
    * @Description: 根据查询条件更新REL_GOODS_RES全表字段
    * @param record 要更新成为的TdRelGOODSRES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdRelGOODSRES record, Criteria example) {
        return this.tdRelGOODSRESMapper.updateByExample(record, example);
    }

    /**
    * @Title TdRelGOODSRESDao.insert
    * @Description: 插入一个REL_GOODS_RES
    * @param record REL_GOODS_RES的bean对象
    * @return int  插入个数
     */
    public int insert(TdRelGOODSRES record) {
        return this.tdRelGOODSRESMapper.insert(record);
    }

    /**
    * @Title TdRelGOODSRESDao.insertSelective
    * @Description: 插入一个只有部分字段的REL_GOODS_RES
    * @param record 只含部分字段的REL_GOODS_RES的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdRelGOODSRES record) {
        return this.tdRelGOODSRESMapper.insertSelective(record);
    }
}