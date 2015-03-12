package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTFGRMBR;
import com.ai.gzesp.dao.beans.TdSysDSTFGRMBRKey;
import com.ai.gzesp.dao.persistence.TdSysDSTFGRMBRMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTFGRMBRDao
* @Description: SYS_D_STFGR_MBR表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTFGRMBRDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTFGRMBRDao.class);

    /**
     * @Fields TdSysDSTFGRMBR表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTFGRMBRMapper tdSysDSTFGRMBRMapper;

    /**
    * @Title TdSysDSTFGRMBRDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STFGR_MBR个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTFGRMBRMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTFGRMBRDao.selectByPrimaryKey
    * @Description: 根据主键类，返回SYS_D_STFGR_MBR
    * @param key key
    * @return TdSysDSTFGRMBR bean对象
     */
    public TdSysDSTFGRMBR selectByPrimaryKey(TdSysDSTFGRMBRKey key) {
        return this.tdSysDSTFGRMBRMapper.selectByPrimaryKey(key);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STFGR_MBR结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTFGRMBR>SYS_D_STFGR_MBR结果集
     */
    public List<TdSysDSTFGRMBR> selectByExample(Criteria example) {
        return this.tdSysDSTFGRMBRMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除SYS_D_STFGR_MBR
    * @param key key
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(TdSysDSTFGRMBRKey key) {
        return this.tdSysDSTFGRMBRMapper.deleteByPrimaryKey(key);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新SYS_D_STFGR_MBR部分字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdSysDSTFGRMBR record) {
        return this.tdSysDSTFGRMBRMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.updateByPrimaryKey
    * @Description: 根据主键更新SYS_D_STFGR_MBR全部字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdSysDSTFGRMBR record) {
        return this.tdSysDSTFGRMBRMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STFGR_MBR
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTFGRMBRMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STFGR_MBR部分字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTFGRMBR record, Criteria example) {
        return this.tdSysDSTFGRMBRMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STFGR_MBR全表字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTFGRMBR record, Criteria example) {
        return this.tdSysDSTFGRMBRMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.insert
    * @Description: 插入一个SYS_D_STFGR_MBR
    * @param record SYS_D_STFGR_MBR的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTFGRMBR record) {
        return this.tdSysDSTFGRMBRMapper.insert(record);
    }

    /**
    * @Title TdSysDSTFGRMBRDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STFGR_MBR
    * @param record 只含部分字段的SYS_D_STFGR_MBR的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTFGRMBR record) {
        return this.tdSysDSTFGRMBRMapper.insertSelective(record);
    }
}