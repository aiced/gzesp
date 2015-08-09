package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBANDBALANCE;
import com.ai.gzesp.dao.persistence.TdOrdDBANDBALANCEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDBANDBALANCEDao
* @Description: ORD_D_BANDBALANCE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDBANDBALANCEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDBANDBALANCEDao.class);

    /**
     * @Fields TdOrdDBANDBALANCE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDBANDBALANCEMapper tdOrdDBANDBALANCEMapper;

    /**
    * @Title TdOrdDBANDBALANCEDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_BANDBALANCE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDBANDBALANCEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_BANDBALANCE
    * @param logId logId
    * @return TdOrdDBANDBALANCE bean对象
     */
    public TdOrdDBANDBALANCE selectByPrimaryKey(String logId) {
        return this.tdOrdDBANDBALANCEMapper.selectByPrimaryKey(logId);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BANDBALANCE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBANDBALANCE>ORD_D_BANDBALANCE结果集
     */
    public List<TdOrdDBANDBALANCE> selectByExample(Criteria example) {
        return this.tdOrdDBANDBALANCEMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_BANDBALANCE
    * @param logId logId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(String logId) {
        return this.tdOrdDBANDBALANCEMapper.deleteByPrimaryKey(logId);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_BANDBALANCE部分字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdOrdDBANDBALANCE record) {
        return this.tdOrdDBANDBALANCEMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_BANDBALANCE全部字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdOrdDBANDBALANCE record) {
        return this.tdOrdDBANDBALANCEMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BANDBALANCE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDBANDBALANCEMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BANDBALANCE部分字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDBANDBALANCE record, Criteria example) {
        return this.tdOrdDBANDBALANCEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_BANDBALANCE全表字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDBANDBALANCE record, Criteria example) {
        return this.tdOrdDBANDBALANCEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.insert
    * @Description: 插入一个ORD_D_BANDBALANCE
    * @param record ORD_D_BANDBALANCE的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDBANDBALANCE record) {
        return this.tdOrdDBANDBALANCEMapper.insert(record);
    }

    /**
    * @Title TdOrdDBANDBALANCEDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BANDBALANCE
    * @param record 只含部分字段的ORD_D_BANDBALANCE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDBANDBALANCE record) {
        return this.tdOrdDBANDBALANCEMapper.insertSelective(record);
    }
}