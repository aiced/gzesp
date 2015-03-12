package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.persistence.TdOrdDBASEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDBASEDao
* @Description: ORD_D_BASE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDBASEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDBASEDao.class);

    /**
     * @Fields TdOrdDBASE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDBASEMapper tdOrdDBASEMapper;

    /**
    * @Title TdOrdDBASEDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_BASE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDBASEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDBASEDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BASE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBASE>ORD_D_BASE结果集
     */
    public List<TdOrdDBASE> selectByExample(Criteria example) {
        return this.tdOrdDBASEMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDBASEDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BASE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDBASEMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDBASEDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BASE部分字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDBASE record, Criteria example) {
        return this.tdOrdDBASEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDBASEDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_BASE全表字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDBASE record, Criteria example) {
        return this.tdOrdDBASEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDBASEDao.insert
    * @Description: 插入一个ORD_D_BASE
    * @param record ORD_D_BASE的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDBASE record) {
        return this.tdOrdDBASEMapper.insert(record);
    }

    /**
    * @Title TdOrdDBASEDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BASE
    * @param record 只含部分字段的ORD_D_BASE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDBASE record) {
        return this.tdOrdDBASEMapper.insertSelective(record);
    }
}