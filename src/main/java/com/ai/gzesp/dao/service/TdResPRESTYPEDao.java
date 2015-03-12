package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResPRESTYPE;
import com.ai.gzesp.dao.persistence.TdResPRESTYPEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdResPRESTYPEDao
* @Description: RES_P_RESTYPE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdResPRESTYPEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdResPRESTYPEDao.class);

    /**
     * @Fields TdResPRESTYPE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdResPRESTYPEMapper tdResPRESTYPEMapper;

    /**
    * @Title TdResPRESTYPEDao.countByExample
    * @Description: 根据查询条件，计算RES_P_RESTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdResPRESTYPEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdResPRESTYPEDao.selectByExample
    * @Description: 根据查询条件类，返回RES_P_RESTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdResPRESTYPE>RES_P_RESTYPE结果集
     */
    public List<TdResPRESTYPE> selectByExample(Criteria example) {
        return this.tdResPRESTYPEMapper.selectByExample(example);
    }

    /**
    * @Title TdResPRESTYPEDao.deleteByExample
    * @Description: 根据查询条件，删除RES_P_RESTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdResPRESTYPEMapper.deleteByExample(example);
    }

    /**
    * @Title TdResPRESTYPEDao.updateByExampleSelective
    * @Description: 根据查询条件更新RES_P_RESTYPE部分字段
    * @param record 要更新成为的TdResPRESTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdResPRESTYPE record, Criteria example) {
        return this.tdResPRESTYPEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdResPRESTYPEDao.updateByExample
    * @Description: 根据查询条件更新RES_P_RESTYPE全表字段
    * @param record 要更新成为的TdResPRESTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdResPRESTYPE record, Criteria example) {
        return this.tdResPRESTYPEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdResPRESTYPEDao.insert
    * @Description: 插入一个RES_P_RESTYPE
    * @param record RES_P_RESTYPE的bean对象
    * @return int  插入个数
     */
    public int insert(TdResPRESTYPE record) {
        return this.tdResPRESTYPEMapper.insert(record);
    }

    /**
    * @Title TdResPRESTYPEDao.insertSelective
    * @Description: 插入一个只有部分字段的RES_P_RESTYPE
    * @param record 只含部分字段的RES_P_RESTYPE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdResPRESTYPE record) {
        return this.tdResPRESTYPEMapper.insertSelective(record);
    }
}