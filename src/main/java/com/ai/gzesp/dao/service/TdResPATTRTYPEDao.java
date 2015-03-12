package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResPATTRTYPE;
import com.ai.gzesp.dao.persistence.TdResPATTRTYPEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdResPATTRTYPEDao
* @Description: RES_P_ATTRTYPE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdResPATTRTYPEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdResPATTRTYPEDao.class);

    /**
     * @Fields TdResPATTRTYPE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdResPATTRTYPEMapper tdResPATTRTYPEMapper;

    /**
    * @Title TdResPATTRTYPEDao.countByExample
    * @Description: 根据查询条件，计算RES_P_ATTRTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdResPATTRTYPEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdResPATTRTYPEDao.selectByExample
    * @Description: 根据查询条件类，返回RES_P_ATTRTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdResPATTRTYPE>RES_P_ATTRTYPE结果集
     */
    public List<TdResPATTRTYPE> selectByExample(Criteria example) {
        return this.tdResPATTRTYPEMapper.selectByExample(example);
    }

    /**
    * @Title TdResPATTRTYPEDao.deleteByExample
    * @Description: 根据查询条件，删除RES_P_ATTRTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdResPATTRTYPEMapper.deleteByExample(example);
    }

    /**
    * @Title TdResPATTRTYPEDao.updateByExampleSelective
    * @Description: 根据查询条件更新RES_P_ATTRTYPE部分字段
    * @param record 要更新成为的TdResPATTRTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdResPATTRTYPE record, Criteria example) {
        return this.tdResPATTRTYPEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdResPATTRTYPEDao.updateByExample
    * @Description: 根据查询条件更新RES_P_ATTRTYPE全表字段
    * @param record 要更新成为的TdResPATTRTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdResPATTRTYPE record, Criteria example) {
        return this.tdResPATTRTYPEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdResPATTRTYPEDao.insert
    * @Description: 插入一个RES_P_ATTRTYPE
    * @param record RES_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    public int insert(TdResPATTRTYPE record) {
        return this.tdResPATTRTYPEMapper.insert(record);
    }

    /**
    * @Title TdResPATTRTYPEDao.insertSelective
    * @Description: 插入一个只有部分字段的RES_P_ATTRTYPE
    * @param record 只含部分字段的RES_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdResPATTRTYPE record) {
        return this.tdResPATTRTYPEMapper.insertSelective(record);
    }
}