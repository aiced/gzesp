package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPWEBCITY;
import com.ai.gzesp.dao.persistence.TdSysPWEBCITYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPWEBCITYDao
* @Description: SYS_P_WEB_CITY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPWEBCITYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPWEBCITYDao.class);

    /**
     * @Fields TdSysPWEBCITY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPWEBCITYMapper tdSysPWEBCITYMapper;

    /**
    * @Title TdSysPWEBCITYDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_WEB_CITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPWEBCITYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPWEBCITYDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_WEB_CITY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPWEBCITY>SYS_P_WEB_CITY结果集
     */
    public List<TdSysPWEBCITY> selectByExample(Criteria example) {
        return this.tdSysPWEBCITYMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPWEBCITYDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_WEB_CITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPWEBCITYMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPWEBCITYDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_WEB_CITY部分字段
    * @param record 要更新成为的TdSysPWEBCITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPWEBCITY record, Criteria example) {
        return this.tdSysPWEBCITYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPWEBCITYDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_WEB_CITY全表字段
    * @param record 要更新成为的TdSysPWEBCITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPWEBCITY record, Criteria example) {
        return this.tdSysPWEBCITYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPWEBCITYDao.insert
    * @Description: 插入一个SYS_P_WEB_CITY
    * @param record SYS_P_WEB_CITY的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPWEBCITY record) {
        return this.tdSysPWEBCITYMapper.insert(record);
    }

    /**
    * @Title TdSysPWEBCITYDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_WEB_CITY
    * @param record 只含部分字段的SYS_P_WEB_CITY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPWEBCITY record) {
        return this.tdSysPWEBCITYMapper.insertSelective(record);
    }
}