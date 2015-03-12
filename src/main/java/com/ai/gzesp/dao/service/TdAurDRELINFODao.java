package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDRELINFO;
import com.ai.gzesp.dao.persistence.TdAurDRELINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdAurDRELINFODao
* @Description: AUR_D_RELINFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdAurDRELINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdAurDRELINFODao.class);

    /**
     * @Fields TdAurDRELINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdAurDRELINFOMapper tdAurDRELINFOMapper;

    /**
    * @Title TdAurDRELINFODao.countByExample
    * @Description: 根据查询条件，计算AUR_D_RELINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdAurDRELINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdAurDRELINFODao.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_RELINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDRELINFO>AUR_D_RELINFO结果集
     */
    public List<TdAurDRELINFO> selectByExample(Criteria example) {
        return this.tdAurDRELINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdAurDRELINFODao.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_RELINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdAurDRELINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdAurDRELINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_RELINFO部分字段
    * @param record 要更新成为的TdAurDRELINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdAurDRELINFO record, Criteria example) {
        return this.tdAurDRELINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdAurDRELINFODao.updateByExample
    * @Description: 根据查询条件更新AUR_D_RELINFO全表字段
    * @param record 要更新成为的TdAurDRELINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdAurDRELINFO record, Criteria example) {
        return this.tdAurDRELINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdAurDRELINFODao.insert
    * @Description: 插入一个AUR_D_RELINFO
    * @param record AUR_D_RELINFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdAurDRELINFO record) {
        return this.tdAurDRELINFOMapper.insert(record);
    }

    /**
    * @Title TdAurDRELINFODao.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_RELINFO
    * @param record 只含部分字段的AUR_D_RELINFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdAurDRELINFO record) {
        return this.tdAurDRELINFOMapper.insertSelective(record);
    }
}