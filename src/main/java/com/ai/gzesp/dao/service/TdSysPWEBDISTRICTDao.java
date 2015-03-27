package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPWEBDISTRICT;
import com.ai.gzesp.dao.persistence.TdSysPWEBDISTRICTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPWEBDISTRICTDao
* @Description: SYS_P_WEB_DISTRICT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPWEBDISTRICTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPWEBDISTRICTDao.class);

    /**
     * @Fields TdSysPWEBDISTRICT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPWEBDISTRICTMapper tdSysPWEBDISTRICTMapper;

    /**
    * @Title TdSysPWEBDISTRICTDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_WEB_DISTRICT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPWEBDISTRICTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_WEB_DISTRICT结果集
    * @param example 通用查询条件类
    * @return List<TdSysPWEBDISTRICT>SYS_P_WEB_DISTRICT结果集
     */
    public List<TdSysPWEBDISTRICT> selectByExample(Criteria example) {
        return this.tdSysPWEBDISTRICTMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_WEB_DISTRICT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPWEBDISTRICTMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_WEB_DISTRICT部分字段
    * @param record 要更新成为的TdSysPWEBDISTRICT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPWEBDISTRICT record, Criteria example) {
        return this.tdSysPWEBDISTRICTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_WEB_DISTRICT全表字段
    * @param record 要更新成为的TdSysPWEBDISTRICT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPWEBDISTRICT record, Criteria example) {
        return this.tdSysPWEBDISTRICTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.insert
    * @Description: 插入一个SYS_P_WEB_DISTRICT
    * @param record SYS_P_WEB_DISTRICT的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPWEBDISTRICT record) {
        return this.tdSysPWEBDISTRICTMapper.insert(record);
    }

    /**
    * @Title TdSysPWEBDISTRICTDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_WEB_DISTRICT
    * @param record 只含部分字段的SYS_P_WEB_DISTRICT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPWEBDISTRICT record) {
        return this.tdSysPWEBDISTRICTMapper.insertSelective(record);
    }
}