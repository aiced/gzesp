package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.persistence.TdAurDAUTHINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdAurDAUTHINFODao
* @Description: AUR_D_AUTHINFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdAurDAUTHINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdAurDAUTHINFODao.class);

    /**
     * @Fields TdAurDAUTHINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdAurDAUTHINFOMapper tdAurDAUTHINFOMapper;

    /**
    * @Title TdAurDAUTHINFODao.countByExample
    * @Description: 根据查询条件，计算AUR_D_AUTHINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdAurDAUTHINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdAurDAUTHINFODao.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_AUTHINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDAUTHINFO>AUR_D_AUTHINFO结果集
     */
    public List<TdAurDAUTHINFO> selectByExample(Criteria example) {
        return this.tdAurDAUTHINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdAurDAUTHINFODao.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_AUTHINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdAurDAUTHINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdAurDAUTHINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_AUTHINFO部分字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdAurDAUTHINFO record, Criteria example) {
        return this.tdAurDAUTHINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdAurDAUTHINFODao.updateByExample
    * @Description: 根据查询条件更新AUR_D_AUTHINFO全表字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdAurDAUTHINFO record, Criteria example) {
        return this.tdAurDAUTHINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdAurDAUTHINFODao.insert
    * @Description: 插入一个AUR_D_AUTHINFO
    * @param record AUR_D_AUTHINFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdAurDAUTHINFO record) {
        return this.tdAurDAUTHINFOMapper.insert(record);
    }

    /**
    * @Title TdAurDAUTHINFODao.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_AUTHINFO
    * @param record 只含部分字段的AUR_D_AUTHINFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdAurDAUTHINFO record) {
        return this.tdAurDAUTHINFOMapper.insertSelective(record);
    }
}