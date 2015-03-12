package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDATTR;
import com.ai.gzesp.dao.persistence.TdGdsDATTRMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDATTRDao
* @Description: GDS_D_ATTR表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDATTRDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDATTRDao.class);

    /**
     * @Fields TdGdsDATTR表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDATTRMapper tdGdsDATTRMapper;

    /**
    * @Title TdGdsDATTRDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_ATTR个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDATTRMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDATTRDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ATTR结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDATTR>GDS_D_ATTR结果集
     */
    public List<TdGdsDATTR> selectByExample(Criteria example) {
        return this.tdGdsDATTRMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDATTRDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ATTR
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDATTRMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDATTRDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ATTR部分字段
    * @param record 要更新成为的TdGdsDATTR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDATTR record, Criteria example) {
        return this.tdGdsDATTRMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDATTRDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_ATTR全表字段
    * @param record 要更新成为的TdGdsDATTR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDATTR record, Criteria example) {
        return this.tdGdsDATTRMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDATTRDao.insert
    * @Description: 插入一个GDS_D_ATTR
    * @param record GDS_D_ATTR的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDATTR record) {
        return this.tdGdsDATTRMapper.insert(record);
    }

    /**
    * @Title TdGdsDATTRDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ATTR
    * @param record 只含部分字段的GDS_D_ATTR的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDATTR record) {
        return this.tdGdsDATTRMapper.insertSelective(record);
    }
}