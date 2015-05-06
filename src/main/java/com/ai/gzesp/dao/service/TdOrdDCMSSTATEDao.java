package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCMSSTATE;
import com.ai.gzesp.dao.persistence.TdOrdDCMSSTATEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDCMSSTATEDao
* @Description: ORD_D_CMSSTATE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDCMSSTATEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDCMSSTATEDao.class);

    /**
     * @Fields TdOrdDCMSSTATE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDCMSSTATEMapper tdOrdDCMSSTATEMapper;

    /**
    * @Title TdOrdDCMSSTATEDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_CMSSTATE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDCMSSTATEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDCMSSTATEDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CMSSTATE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCMSSTATE>ORD_D_CMSSTATE结果集
     */
    public List<TdOrdDCMSSTATE> selectByExample(Criteria example) {
        return this.tdOrdDCMSSTATEMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDCMSSTATEDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CMSSTATE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDCMSSTATEMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDCMSSTATEDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CMSSTATE部分字段
    * @param record 要更新成为的TdOrdDCMSSTATE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDCMSSTATE record, Criteria example) {
        return this.tdOrdDCMSSTATEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDCMSSTATEDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_CMSSTATE全表字段
    * @param record 要更新成为的TdOrdDCMSSTATE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDCMSSTATE record, Criteria example) {
        return this.tdOrdDCMSSTATEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDCMSSTATEDao.insert
    * @Description: 插入一个ORD_D_CMSSTATE
    * @param record ORD_D_CMSSTATE的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDCMSSTATE record) {
        return this.tdOrdDCMSSTATEMapper.insert(record);
    }

    /**
    * @Title TdOrdDCMSSTATEDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CMSSTATE
    * @param record 只含部分字段的ORD_D_CMSSTATE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDCMSSTATE record) {
        return this.tdOrdDCMSSTATEMapper.insertSelective(record);
    }
}