package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCITY;
import com.ai.gzesp.dao.persistence.TdSysPCITYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPCITYDao
* @Description: SYS_P_CITY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPCITYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPCITYDao.class);

    /**
     * @Fields TdSysPCITY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPCITYMapper tdSysPCITYMapper;

    /**
    * @Title TdSysPCITYDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_CITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPCITYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPCITYDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_CITY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPCITY>SYS_P_CITY结果集
     */
    public List<TdSysPCITY> selectByExample(Criteria example) {
        return this.tdSysPCITYMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPCITYDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_CITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPCITYMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPCITYDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_CITY部分字段
    * @param record 要更新成为的TdSysPCITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPCITY record, Criteria example) {
        return this.tdSysPCITYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPCITYDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_CITY全表字段
    * @param record 要更新成为的TdSysPCITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPCITY record, Criteria example) {
        return this.tdSysPCITYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPCITYDao.insert
    * @Description: 插入一个SYS_P_CITY
    * @param record SYS_P_CITY的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPCITY record) {
        return this.tdSysPCITYMapper.insert(record);
    }

    /**
    * @Title TdSysPCITYDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_CITY
    * @param record 只含部分字段的SYS_P_CITY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPCITY record) {
        return this.tdSysPCITYMapper.insertSelective(record);
    }
}