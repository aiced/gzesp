package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdTFAAGENTACCOUNT;
import com.ai.gzesp.dao.persistence.TdTFAAGENTACCOUNTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdTFAAGENTACCOUNTDao
* @Description: TF_A_AGENT_ACCOUNT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdTFAAGENTACCOUNTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdTFAAGENTACCOUNTDao.class);

    /**
     * @Fields TdTFAAGENTACCOUNT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdTFAAGENTACCOUNTMapper tdTFAAGENTACCOUNTMapper;

    /**
    * @Title TdTFAAGENTACCOUNTDao.countByExample
    * @Description: 根据查询条件，计算TF_A_AGENT_ACCOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdTFAAGENTACCOUNTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.selectByPrimaryKey
    * @Description: 根据主键类，返回TF_A_AGENT_ACCOUNT
    * @param agentId agentId
    * @return TdTFAAGENTACCOUNT bean对象
     */
    public TdTFAAGENTACCOUNT selectByPrimaryKey(Integer agentId) {
        return this.tdTFAAGENTACCOUNTMapper.selectByPrimaryKey(agentId);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.selectByExample
    * @Description: 根据查询条件类，返回TF_A_AGENT_ACCOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdTFAAGENTACCOUNT>TF_A_AGENT_ACCOUNT结果集
     */
    public List<TdTFAAGENTACCOUNT> selectByExample(Criteria example) {
        return this.tdTFAAGENTACCOUNTMapper.selectByExample(example);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除TF_A_AGENT_ACCOUNT
    * @param agentId agentId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer agentId) {
        return this.tdTFAAGENTACCOUNTMapper.deleteByPrimaryKey(agentId);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新TF_A_AGENT_ACCOUNT部分字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdTFAAGENTACCOUNT record) {
        return this.tdTFAAGENTACCOUNTMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.updateByPrimaryKey
    * @Description: 根据主键更新TF_A_AGENT_ACCOUNT全部字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdTFAAGENTACCOUNT record) {
        return this.tdTFAAGENTACCOUNTMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.deleteByExample
    * @Description: 根据查询条件，删除TF_A_AGENT_ACCOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdTFAAGENTACCOUNTMapper.deleteByExample(example);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.updateByExampleSelective
    * @Description: 根据查询条件更新TF_A_AGENT_ACCOUNT部分字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdTFAAGENTACCOUNT record, Criteria example) {
        return this.tdTFAAGENTACCOUNTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.updateByExample
    * @Description: 根据查询条件更新TF_A_AGENT_ACCOUNT全表字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdTFAAGENTACCOUNT record, Criteria example) {
        return this.tdTFAAGENTACCOUNTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.insert
    * @Description: 插入一个TF_A_AGENT_ACCOUNT
    * @param record TF_A_AGENT_ACCOUNT的bean对象
    * @return int  插入个数
     */
    public int insert(TdTFAAGENTACCOUNT record) {
        return this.tdTFAAGENTACCOUNTMapper.insert(record);
    }

    /**
    * @Title TdTFAAGENTACCOUNTDao.insertSelective
    * @Description: 插入一个只有部分字段的TF_A_AGENT_ACCOUNT
    * @param record 只含部分字段的TF_A_AGENT_ACCOUNT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdTFAAGENTACCOUNT record) {
        return this.tdTFAAGENTACCOUNTMapper.insertSelective(record);
    }
}