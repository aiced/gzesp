package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPSTATIC;
import com.ai.gzesp.dao.persistence.TdSysPSTATICMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPSTATICDao
* @Description: SYS_P_STATIC表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPSTATICDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPSTATICDao.class);

    /**
     * @Fields TdSysPSTATIC表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPSTATICMapper tdSysPSTATICMapper;

    /**
    * @Title TdSysPSTATICDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_STATIC个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPSTATICMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPSTATICDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_STATIC结果集
    * @param example 通用查询条件类
    * @return List<TdSysPSTATIC>SYS_P_STATIC结果集
     */
    public List<TdSysPSTATIC> selectByExample(Criteria example) {
        return this.tdSysPSTATICMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPSTATICDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_STATIC
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPSTATICMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPSTATICDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_STATIC部分字段
    * @param record 要更新成为的TdSysPSTATIC对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPSTATIC record, Criteria example) {
        return this.tdSysPSTATICMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPSTATICDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_STATIC全表字段
    * @param record 要更新成为的TdSysPSTATIC对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPSTATIC record, Criteria example) {
        return this.tdSysPSTATICMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPSTATICDao.insert
    * @Description: 插入一个SYS_P_STATIC
    * @param record SYS_P_STATIC的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPSTATIC record) {
        return this.tdSysPSTATICMapper.insert(record);
    }

    /**
    * @Title TdSysPSTATICDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_STATIC
    * @param record 只含部分字段的SYS_P_STATIC的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPSTATIC record) {
        return this.tdSysPSTATICMapper.insertSelective(record);
    }
}