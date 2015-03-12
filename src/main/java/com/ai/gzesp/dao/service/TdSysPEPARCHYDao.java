package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPEPARCHY;
import com.ai.gzesp.dao.persistence.TdSysPEPARCHYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPEPARCHYDao
* @Description: SYS_P_EPARCHY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPEPARCHYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPEPARCHYDao.class);

    /**
     * @Fields TdSysPEPARCHY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPEPARCHYMapper tdSysPEPARCHYMapper;

    /**
    * @Title TdSysPEPARCHYDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_EPARCHY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPEPARCHYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPEPARCHYDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_EPARCHY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPEPARCHY>SYS_P_EPARCHY结果集
     */
    public List<TdSysPEPARCHY> selectByExample(Criteria example) {
        return this.tdSysPEPARCHYMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPEPARCHYDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_EPARCHY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPEPARCHYMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPEPARCHYDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_EPARCHY部分字段
    * @param record 要更新成为的TdSysPEPARCHY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPEPARCHY record, Criteria example) {
        return this.tdSysPEPARCHYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPEPARCHYDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_EPARCHY全表字段
    * @param record 要更新成为的TdSysPEPARCHY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPEPARCHY record, Criteria example) {
        return this.tdSysPEPARCHYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPEPARCHYDao.insert
    * @Description: 插入一个SYS_P_EPARCHY
    * @param record SYS_P_EPARCHY的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPEPARCHY record) {
        return this.tdSysPEPARCHYMapper.insert(record);
    }

    /**
    * @Title TdSysPEPARCHYDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_EPARCHY
    * @param record 只含部分字段的SYS_P_EPARCHY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPEPARCHY record) {
        return this.tdSysPEPARCHYMapper.insertSelective(record);
    }
}