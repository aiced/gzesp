package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTFGRP;
import com.ai.gzesp.dao.persistence.TdSysDSTFGRPMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTFGRPDao
* @Description: SYS_D_STFGRP表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTFGRPDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTFGRPDao.class);

    /**
     * @Fields TdSysDSTFGRP表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTFGRPMapper tdSysDSTFGRPMapper;

    /**
    * @Title TdSysDSTFGRPDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STFGRP个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTFGRPMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTFGRPDao.selectByPrimaryKey
    * @Description: 根据主键类，返回SYS_D_STFGRP
    * @param stfgrpId stfgrpId
    * @return TdSysDSTFGRP bean对象
     */
    public TdSysDSTFGRP selectByPrimaryKey(Integer stfgrpId) {
        return this.tdSysDSTFGRPMapper.selectByPrimaryKey(stfgrpId);
    }

    /**
    * @Title TdSysDSTFGRPDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STFGRP结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTFGRP>SYS_D_STFGRP结果集
     */
    public List<TdSysDSTFGRP> selectByExample(Criteria example) {
        return this.tdSysDSTFGRPMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTFGRPDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除SYS_D_STFGRP
    * @param stfgrpId stfgrpId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer stfgrpId) {
        return this.tdSysDSTFGRPMapper.deleteByPrimaryKey(stfgrpId);
    }

    /**
    * @Title TdSysDSTFGRPDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新SYS_D_STFGRP部分字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdSysDSTFGRP record) {
        return this.tdSysDSTFGRPMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdSysDSTFGRPDao.updateByPrimaryKey
    * @Description: 根据主键更新SYS_D_STFGRP全部字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdSysDSTFGRP record) {
        return this.tdSysDSTFGRPMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdSysDSTFGRPDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STFGRP
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTFGRPMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTFGRPDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STFGRP部分字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTFGRP record, Criteria example) {
        return this.tdSysDSTFGRPMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTFGRPDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STFGRP全表字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTFGRP record, Criteria example) {
        return this.tdSysDSTFGRPMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTFGRPDao.insert
    * @Description: 插入一个SYS_D_STFGRP
    * @param record SYS_D_STFGRP的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTFGRP record) {
        return this.tdSysDSTFGRPMapper.insert(record);
    }

    /**
    * @Title TdSysDSTFGRPDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STFGRP
    * @param record 只含部分字段的SYS_D_STFGRP的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTFGRP record) {
        return this.tdSysDSTFGRPMapper.insertSelective(record);
    }
}