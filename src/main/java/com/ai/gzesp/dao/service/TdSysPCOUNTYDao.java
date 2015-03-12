package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCOUNTY;
import com.ai.gzesp.dao.persistence.TdSysPCOUNTYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPCOUNTYDao
* @Description: SYS_P_COUNTY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPCOUNTYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPCOUNTYDao.class);

    /**
     * @Fields TdSysPCOUNTY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPCOUNTYMapper tdSysPCOUNTYMapper;

    /**
    * @Title TdSysPCOUNTYDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_COUNTY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPCOUNTYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPCOUNTYDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_COUNTY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPCOUNTY>SYS_P_COUNTY结果集
     */
    public List<TdSysPCOUNTY> selectByExample(Criteria example) {
        return this.tdSysPCOUNTYMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPCOUNTYDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_COUNTY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPCOUNTYMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPCOUNTYDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_COUNTY部分字段
    * @param record 要更新成为的TdSysPCOUNTY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPCOUNTY record, Criteria example) {
        return this.tdSysPCOUNTYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPCOUNTYDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_COUNTY全表字段
    * @param record 要更新成为的TdSysPCOUNTY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPCOUNTY record, Criteria example) {
        return this.tdSysPCOUNTYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPCOUNTYDao.insert
    * @Description: 插入一个SYS_P_COUNTY
    * @param record SYS_P_COUNTY的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPCOUNTY record) {
        return this.tdSysPCOUNTYMapper.insert(record);
    }

    /**
    * @Title TdSysPCOUNTYDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_COUNTY
    * @param record 只含部分字段的SYS_P_COUNTY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPCOUNTY record) {
        return this.tdSysPCOUNTYMapper.insertSelective(record);
    }
}