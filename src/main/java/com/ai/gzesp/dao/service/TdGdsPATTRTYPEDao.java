package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsPATTRTYPE;
import com.ai.gzesp.dao.persistence.TdGdsPATTRTYPEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsPATTRTYPEDao
* @Description: GDS_P_ATTRTYPE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsPATTRTYPEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsPATTRTYPEDao.class);

    /**
     * @Fields TdGdsPATTRTYPE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsPATTRTYPEMapper tdGdsPATTRTYPEMapper;

    /**
    * @Title TdGdsPATTRTYPEDao.countByExample
    * @Description: 根据查询条件，计算GDS_P_ATTRTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsPATTRTYPEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsPATTRTYPEDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_P_ATTRTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdGdsPATTRTYPE>GDS_P_ATTRTYPE结果集
     */
    public List<TdGdsPATTRTYPE> selectByExample(Criteria example) {
        return this.tdGdsPATTRTYPEMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsPATTRTYPEDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_P_ATTRTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsPATTRTYPEMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsPATTRTYPEDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_P_ATTRTYPE部分字段
    * @param record 要更新成为的TdGdsPATTRTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsPATTRTYPE record, Criteria example) {
        return this.tdGdsPATTRTYPEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsPATTRTYPEDao.updateByExample
    * @Description: 根据查询条件更新GDS_P_ATTRTYPE全表字段
    * @param record 要更新成为的TdGdsPATTRTYPE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsPATTRTYPE record, Criteria example) {
        return this.tdGdsPATTRTYPEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsPATTRTYPEDao.insert
    * @Description: 插入一个GDS_P_ATTRTYPE
    * @param record GDS_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsPATTRTYPE record) {
        return this.tdGdsPATTRTYPEMapper.insert(record);
    }

    /**
    * @Title TdGdsPATTRTYPEDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_P_ATTRTYPE
    * @param record 只含部分字段的GDS_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsPATTRTYPE record) {
        return this.tdGdsPATTRTYPEMapper.insertSelective(record);
    }
}