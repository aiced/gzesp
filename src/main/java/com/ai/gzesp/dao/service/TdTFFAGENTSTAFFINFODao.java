package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdTFFAGENTSTAFFINFO;
import com.ai.gzesp.dao.persistence.TdTFFAGENTSTAFFINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdTFFAGENTSTAFFINFODao
* @Description: TF_F_AGENT_STAFF_INFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdTFFAGENTSTAFFINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdTFFAGENTSTAFFINFODao.class);

    /**
     * @Fields TdTFFAGENTSTAFFINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdTFFAGENTSTAFFINFOMapper tdTFFAGENTSTAFFINFOMapper;

    /**
    * @Title TdTFFAGENTSTAFFINFODao.countByExample
    * @Description: 根据查询条件，计算TF_F_AGENT_STAFF_INFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdTFFAGENTSTAFFINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.selectByExample
    * @Description: 根据查询条件类，返回TF_F_AGENT_STAFF_INFO结果集
    * @param example 通用查询条件类
    * @return List<TdTFFAGENTSTAFFINFO>TF_F_AGENT_STAFF_INFO结果集
     */
    public List<TdTFFAGENTSTAFFINFO> selectByExample(Criteria example) {
        return this.tdTFFAGENTSTAFFINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.deleteByExample
    * @Description: 根据查询条件，删除TF_F_AGENT_STAFF_INFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdTFFAGENTSTAFFINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新TF_F_AGENT_STAFF_INFO部分字段
    * @param record 要更新成为的TdTFFAGENTSTAFFINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdTFFAGENTSTAFFINFO record, Criteria example) {
        return this.tdTFFAGENTSTAFFINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.updateByExample
    * @Description: 根据查询条件更新TF_F_AGENT_STAFF_INFO全表字段
    * @param record 要更新成为的TdTFFAGENTSTAFFINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdTFFAGENTSTAFFINFO record, Criteria example) {
        return this.tdTFFAGENTSTAFFINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.insert
    * @Description: 插入一个TF_F_AGENT_STAFF_INFO
    * @param record TF_F_AGENT_STAFF_INFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdTFFAGENTSTAFFINFO record) {
        return this.tdTFFAGENTSTAFFINFOMapper.insert(record);
    }

    /**
    * @Title TdTFFAGENTSTAFFINFODao.insertSelective
    * @Description: 插入一个只有部分字段的TF_F_AGENT_STAFF_INFO
    * @param record 只含部分字段的TF_F_AGENT_STAFF_INFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdTFFAGENTSTAFFINFO record) {
        return this.tdTFFAGENTSTAFFINFOMapper.insertSelective(record);
    }
}