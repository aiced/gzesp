package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPPROVINCE;
import com.ai.gzesp.dao.persistence.TdSysPPROVINCEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPPROVINCEDao
* @Description: SYS_P_PROVINCE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPPROVINCEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPPROVINCEDao.class);

    /**
     * @Fields TdSysPPROVINCE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPPROVINCEMapper tdSysPPROVINCEMapper;

    /**
    * @Title TdSysPPROVINCEDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_PROVINCE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPPROVINCEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPPROVINCEDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_PROVINCE结果集
    * @param example 通用查询条件类
    * @return List<TdSysPPROVINCE>SYS_P_PROVINCE结果集
     */
    public List<TdSysPPROVINCE> selectByExample(Criteria example) {
        return this.tdSysPPROVINCEMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPPROVINCEDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_PROVINCE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPPROVINCEMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPPROVINCEDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_PROVINCE部分字段
    * @param record 要更新成为的TdSysPPROVINCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPPROVINCE record, Criteria example) {
        return this.tdSysPPROVINCEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPPROVINCEDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_PROVINCE全表字段
    * @param record 要更新成为的TdSysPPROVINCE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPPROVINCE record, Criteria example) {
        return this.tdSysPPROVINCEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPPROVINCEDao.insert
    * @Description: 插入一个SYS_P_PROVINCE
    * @param record SYS_P_PROVINCE的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPPROVINCE record) {
        return this.tdSysPPROVINCEMapper.insert(record);
    }

    /**
    * @Title TdSysPPROVINCEDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_PROVINCE
    * @param record 只含部分字段的SYS_P_PROVINCE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPPROVINCE record) {
        return this.tdSysPPROVINCEMapper.insertSelective(record);
    }
}