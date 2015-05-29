package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWEIXINLOG;
import com.ai.gzesp.dao.persistence.TdPayDWEIXINLOGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdPayDWEIXINLOGDao
* @Description: PAY_D_WEIXIN_LOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdPayDWEIXINLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdPayDWEIXINLOGDao.class);

    /**
     * @Fields TdPayDWEIXINLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdPayDWEIXINLOGMapper tdPayDWEIXINLOGMapper;

    /**
    * @Title TdPayDWEIXINLOGDao.countByExample
    * @Description: 根据查询条件，计算PAY_D_WEIXIN_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdPayDWEIXINLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdPayDWEIXINLOGDao.selectByPrimaryKey
    * @Description: 根据主键类，返回PAY_D_WEIXIN_LOG
    * @param logId logId
    * @return TdPayDWEIXINLOG bean对象
     */
    public TdPayDWEIXINLOG selectByPrimaryKey(Long logId) {
        return this.tdPayDWEIXINLOGMapper.selectByPrimaryKey(logId);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.selectByExample
    * @Description: 根据查询条件类，返回PAY_D_WEIXIN_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdPayDWEIXINLOG>PAY_D_WEIXIN_LOG结果集
     */
    public List<TdPayDWEIXINLOG> selectByExample(Criteria example) {
        return this.tdPayDWEIXINLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除PAY_D_WEIXIN_LOG
    * @param logId logId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long logId) {
        return this.tdPayDWEIXINLOGMapper.deleteByPrimaryKey(logId);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新PAY_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdPayDWEIXINLOG record) {
        return this.tdPayDWEIXINLOGMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.updateByPrimaryKey
    * @Description: 根据主键更新PAY_D_WEIXIN_LOG全部字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdPayDWEIXINLOG record) {
        return this.tdPayDWEIXINLOGMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.deleteByExample
    * @Description: 根据查询条件，删除PAY_D_WEIXIN_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdPayDWEIXINLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新PAY_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdPayDWEIXINLOG record, Criteria example) {
        return this.tdPayDWEIXINLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.updateByExample
    * @Description: 根据查询条件更新PAY_D_WEIXIN_LOG全表字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdPayDWEIXINLOG record, Criteria example) {
        return this.tdPayDWEIXINLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.insert
    * @Description: 插入一个PAY_D_WEIXIN_LOG
    * @param record PAY_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdPayDWEIXINLOG record) {
        return this.tdPayDWEIXINLOGMapper.insert(record);
    }

    /**
    * @Title TdPayDWEIXINLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的PAY_D_WEIXIN_LOG
    * @param record 只含部分字段的PAY_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdPayDWEIXINLOG record) {
        return this.tdPayDWEIXINLOGMapper.insertSelective(record);
    }
}