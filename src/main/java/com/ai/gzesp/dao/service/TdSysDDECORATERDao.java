package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDDECORATER;
import com.ai.gzesp.dao.persistence.TdSysDDECORATERMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDDECORATERDao
* @Description: SYS_D_DECORATER表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDDECORATERDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDDECORATERDao.class);

    /**
     * @Fields TdSysDDECORATER表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDDECORATERMapper tdSysDDECORATERMapper;

    /**
    * @Title TdSysDDECORATERDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_DECORATER个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDDECORATERMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDDECORATERDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_DECORATER结果集
    * @param example 通用查询条件类
    * @return List<TdSysDDECORATER>SYS_D_DECORATER结果集
     */
    public List<TdSysDDECORATER> selectByExample(Criteria example) {
        return this.tdSysDDECORATERMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDDECORATERDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_DECORATER
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDDECORATERMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDDECORATERDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_DECORATER部分字段
    * @param record 要更新成为的TdSysDDECORATER对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDDECORATER record, Criteria example) {
        return this.tdSysDDECORATERMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDDECORATERDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_DECORATER全表字段
    * @param record 要更新成为的TdSysDDECORATER对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDDECORATER record, Criteria example) {
        return this.tdSysDDECORATERMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDDECORATERDao.insert
    * @Description: 插入一个SYS_D_DECORATER
    * @param record SYS_D_DECORATER的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDDECORATER record) {
        return this.tdSysDDECORATERMapper.insert(record);
    }

    /**
    * @Title TdSysDDECORATERDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_DECORATER
    * @param record 只含部分字段的SYS_D_DECORATER的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDDECORATER record) {
        return this.tdSysDDECORATERMapper.insertSelective(record);
    }
}