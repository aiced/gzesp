package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.persistence.TdAurDBASEINFOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdAurDBASEINFODao
* @Description: AUR_D_BASEINFO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdAurDBASEINFODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdAurDBASEINFODao.class);

    /**
     * @Fields TdAurDBASEINFO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdAurDBASEINFOMapper tdAurDBASEINFOMapper;

    /**
    * @Title TdAurDBASEINFODao.countByExample
    * @Description: 根据查询条件，计算AUR_D_BASEINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdAurDBASEINFOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdAurDBASEINFODao.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_BASEINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDBASEINFO>AUR_D_BASEINFO结果集
     */
    public List<TdAurDBASEINFO> selectByExample(Criteria example) {
        return this.tdAurDBASEINFOMapper.selectByExample(example);
    }

    /**
    * @Title TdAurDBASEINFODao.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_BASEINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdAurDBASEINFOMapper.deleteByExample(example);
    }

    /**
    * @Title TdAurDBASEINFODao.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_BASEINFO部分字段
    * @param record 要更新成为的TdAurDBASEINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdAurDBASEINFO record, Criteria example) {
        return this.tdAurDBASEINFOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdAurDBASEINFODao.updateByExample
    * @Description: 根据查询条件更新AUR_D_BASEINFO全表字段
    * @param record 要更新成为的TdAurDBASEINFO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdAurDBASEINFO record, Criteria example) {
        return this.tdAurDBASEINFOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdAurDBASEINFODao.insert
    * @Description: 插入一个AUR_D_BASEINFO
    * @param record AUR_D_BASEINFO的bean对象
    * @return int  插入个数
     */
    public int insert(TdAurDBASEINFO record) {
        return this.tdAurDBASEINFOMapper.insert(record);
    }

    /**
    * @Title TdAurDBASEINFODao.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_BASEINFO
    * @param record 只含部分字段的AUR_D_BASEINFO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdAurDBASEINFO record) {
        return this.tdAurDBASEINFOMapper.insertSelective(record);
    }
}