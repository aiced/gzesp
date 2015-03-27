package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPWEBPROVINCE;
import com.ai.gzesp.dao.persistence.TdSysPWEBPROVINCEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPWEBPROVINCEDao
* @Description: SYS_P_WEB_PROVINCE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPWEBPROVINCEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPWEBPROVINCEDao.class);

    /**
     * @Fields TdSysPWEBPROVINCE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPWEBPROVINCEMapper tdSysPWEBPROVINCEMapper;

    /**
    * @Title TdSysPWEBPROVINCEDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_WEB_PROVINCE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPWEBPROVINCEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_WEB_PROVINCE结果集
    * @param example 通用查询条件类
    * @return List<TdSysPWEBPROVINCE>SYS_P_WEB_PROVINCE结果集
     */
    public List<TdSysPWEBPROVINCE> selectByExample(Criteria example) {
        return this.tdSysPWEBPROVINCEMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_WEB_PROVINCE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPWEBPROVINCEMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_WEB_PROVINCE部分字段
    * @param record 要更新成为的TdSysPWEBPROVINCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPWEBPROVINCE record, Criteria example) {
        return this.tdSysPWEBPROVINCEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_WEB_PROVINCE全表字段
    * @param record 要更新成为的TdSysPWEBPROVINCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPWEBPROVINCE record, Criteria example) {
        return this.tdSysPWEBPROVINCEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.insert
    * @Description: 插入一个SYS_P_WEB_PROVINCE
    * @param record SYS_P_WEB_PROVINCE的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPWEBPROVINCE record) {
        return this.tdSysPWEBPROVINCEMapper.insert(record);
    }

    /**
    * @Title TdSysPWEBPROVINCEDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_WEB_PROVINCE
    * @param record 只含部分字段的SYS_P_WEB_PROVINCE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPWEBPROVINCE record) {
        return this.tdSysPWEBPROVINCEMapper.insertSelective(record);
    }
}