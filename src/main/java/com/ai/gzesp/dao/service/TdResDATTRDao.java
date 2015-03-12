package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResDATTR;
import com.ai.gzesp.dao.persistence.TdResDATTRMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdResDATTRDao
* @Description: RES_D_ATTR表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdResDATTRDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdResDATTRDao.class);

    /**
     * @Fields TdResDATTR表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdResDATTRMapper tdResDATTRMapper;

    /**
    * @Title TdResDATTRDao.countByExample
    * @Description: 根据查询条件，计算RES_D_ATTR个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdResDATTRMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdResDATTRDao.selectByExample
    * @Description: 根据查询条件类，返回RES_D_ATTR结果集
    * @param example 通用查询条件类
    * @return List<TdResDATTR>RES_D_ATTR结果集
     */
    public List<TdResDATTR> selectByExample(Criteria example) {
        return this.tdResDATTRMapper.selectByExample(example);
    }

    /**
    * @Title TdResDATTRDao.deleteByExample
    * @Description: 根据查询条件，删除RES_D_ATTR
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdResDATTRMapper.deleteByExample(example);
    }

    /**
    * @Title TdResDATTRDao.updateByExampleSelective
    * @Description: 根据查询条件更新RES_D_ATTR部分字段
    * @param record 要更新成为的TdResDATTR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdResDATTR record, Criteria example) {
        return this.tdResDATTRMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdResDATTRDao.updateByExample
    * @Description: 根据查询条件更新RES_D_ATTR全表字段
    * @param record 要更新成为的TdResDATTR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdResDATTR record, Criteria example) {
        return this.tdResDATTRMapper.updateByExample(record, example);
    }

    /**
    * @Title TdResDATTRDao.insert
    * @Description: 插入一个RES_D_ATTR
    * @param record RES_D_ATTR的bean对象
    * @return int  插入个数
     */
    public int insert(TdResDATTR record) {
        return this.tdResDATTRMapper.insert(record);
    }

    /**
    * @Title TdResDATTRDao.insertSelective
    * @Description: 插入一个只有部分字段的RES_D_ATTR
    * @param record 只含部分字段的RES_D_ATTR的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdResDATTR record) {
        return this.tdResDATTRMapper.insertSelective(record);
    }
}