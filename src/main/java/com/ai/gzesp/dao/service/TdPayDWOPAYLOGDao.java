package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWOPAYLOG;
import com.ai.gzesp.dao.persistence.TdPayDWOPAYLOGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdPayDWOPAYLOGDao
* @Description: PAY_D_WOPAY_LOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdPayDWOPAYLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdPayDWOPAYLOGDao.class);

    /**
     * @Fields TdPayDWOPAYLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdPayDWOPAYLOGMapper tdPayDWOPAYLOGMapper;

    /**
    * @Title TdPayDWOPAYLOGDao.countByExample
    * @Description: 根据查询条件，计算PAY_D_WOPAY_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdPayDWOPAYLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdPayDWOPAYLOGDao.selectByPrimaryKey
    * @Description: 根据主键类，返回PAY_D_WOPAY_LOG
    * @param logId logId
    * @return TdPayDWOPAYLOG bean对象
     */
    public TdPayDWOPAYLOG selectByPrimaryKey(Long logId) {
        return this.tdPayDWOPAYLOGMapper.selectByPrimaryKey(logId);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.selectByExample
    * @Description: 根据查询条件类，返回PAY_D_WOPAY_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdPayDWOPAYLOG>PAY_D_WOPAY_LOG结果集
     */
    public List<TdPayDWOPAYLOG> selectByExample(Criteria example) {
        return this.tdPayDWOPAYLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除PAY_D_WOPAY_LOG
    * @param logId logId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long logId) {
        return this.tdPayDWOPAYLOGMapper.deleteByPrimaryKey(logId);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新PAY_D_WOPAY_LOG部分字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdPayDWOPAYLOG record) {
        return this.tdPayDWOPAYLOGMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.updateByPrimaryKey
    * @Description: 根据主键更新PAY_D_WOPAY_LOG全部字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdPayDWOPAYLOG record) {
        return this.tdPayDWOPAYLOGMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.deleteByExample
    * @Description: 根据查询条件，删除PAY_D_WOPAY_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdPayDWOPAYLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新PAY_D_WOPAY_LOG部分字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdPayDWOPAYLOG record, Criteria example) {
        return this.tdPayDWOPAYLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.updateByExample
    * @Description: 根据查询条件更新PAY_D_WOPAY_LOG全表字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdPayDWOPAYLOG record, Criteria example) {
        return this.tdPayDWOPAYLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.insert
    * @Description: 插入一个PAY_D_WOPAY_LOG
    * @param record PAY_D_WOPAY_LOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdPayDWOPAYLOG record) {
        return this.tdPayDWOPAYLOGMapper.insert(record);
    }

    /**
    * @Title TdPayDWOPAYLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的PAY_D_WOPAY_LOG
    * @param record 只含部分字段的PAY_D_WOPAY_LOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdPayDWOPAYLOG record) {
        return this.tdPayDWOPAYLOGMapper.insertSelective(record);
    }
}