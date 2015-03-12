package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPMENU;
import com.ai.gzesp.dao.persistence.TdSysPMENUMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysPMENUDao
* @Description: SYS_P_MENU表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysPMENUDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysPMENUDao.class);

    /**
     * @Fields TdSysPMENU表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysPMENUMapper tdSysPMENUMapper;

    /**
    * @Title TdSysPMENUDao.countByExample
    * @Description: 根据查询条件，计算SYS_P_MENU个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysPMENUMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysPMENUDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_MENU结果集
    * @param example 通用查询条件类
    * @return List<TdSysPMENU>SYS_P_MENU结果集
     */
    public List<TdSysPMENU> selectByExample(Criteria example) {
        return this.tdSysPMENUMapper.selectByExample(example);
    }

    /**
    * @Title TdSysPMENUDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_MENU
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysPMENUMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysPMENUDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_MENU部分字段
    * @param record 要更新成为的TdSysPMENU对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysPMENU record, Criteria example) {
        return this.tdSysPMENUMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysPMENUDao.updateByExample
    * @Description: 根据查询条件更新SYS_P_MENU全表字段
    * @param record 要更新成为的TdSysPMENU对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysPMENU record, Criteria example) {
        return this.tdSysPMENUMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysPMENUDao.insert
    * @Description: 插入一个SYS_P_MENU
    * @param record SYS_P_MENU的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysPMENU record) {
        return this.tdSysPMENUMapper.insert(record);
    }

    /**
    * @Title TdSysPMENUDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_MENU
    * @param record 只含部分字段的SYS_P_MENU的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysPMENU record) {
        return this.tdSysPMENUMapper.insertSelective(record);
    }
}