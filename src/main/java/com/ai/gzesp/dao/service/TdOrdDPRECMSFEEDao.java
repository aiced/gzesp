package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPRECMSFEE;
import com.ai.gzesp.dao.persistence.TdOrdDPRECMSFEEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDPRECMSFEEDao
* @Description: ORD_D_PRECMSFEE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDPRECMSFEEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDPRECMSFEEDao.class);

    /**
     * @Fields TdOrdDPRECMSFEE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDPRECMSFEEMapper tdOrdDPRECMSFEEMapper;

    /**
    * @Title TdOrdDPRECMSFEEDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_PRECMSFEE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDPRECMSFEEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PRECMSFEE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPRECMSFEE>ORD_D_PRECMSFEE结果集
     */
    public List<TdOrdDPRECMSFEE> selectByExample(Criteria example) {
        return this.tdOrdDPRECMSFEEMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PRECMSFEE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDPRECMSFEEMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PRECMSFEE部分字段
    * @param record 要更新成为的TdOrdDPRECMSFEE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDPRECMSFEE record, Criteria example) {
        return this.tdOrdDPRECMSFEEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_PRECMSFEE全表字段
    * @param record 要更新成为的TdOrdDPRECMSFEE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDPRECMSFEE record, Criteria example) {
        return this.tdOrdDPRECMSFEEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.insert
    * @Description: 插入一个ORD_D_PRECMSFEE
    * @param record ORD_D_PRECMSFEE的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDPRECMSFEE record) {
        return this.tdOrdDPRECMSFEEMapper.insert(record);
    }

    /**
    * @Title TdOrdDPRECMSFEEDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PRECMSFEE
    * @param record 只含部分字段的ORD_D_PRECMSFEE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDPRECMSFEE record) {
        return this.tdOrdDPRECMSFEEMapper.insertSelective(record);
    }
}