package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdITFDWEIXINLOG;
import com.ai.gzesp.dao.persistence.TdITFDWEIXINLOGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdITFDWEIXINLOGDao
* @Description: ITF_D_WEIXIN_LOG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdITFDWEIXINLOGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdITFDWEIXINLOGDao.class);

    /**
     * @Fields TdITFDWEIXINLOG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdITFDWEIXINLOGMapper tdITFDWEIXINLOGMapper;

    /**
    * @Title TdITFDWEIXINLOGDao.countByExample
    * @Description: 根据查询条件，计算ITF_D_WEIXIN_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdITFDWEIXINLOGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdITFDWEIXINLOGDao.selectByExample
    * @Description: 根据查询条件类，返回ITF_D_WEIXIN_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdITFDWEIXINLOG>ITF_D_WEIXIN_LOG结果集
     */
    public List<TdITFDWEIXINLOG> selectByExample(Criteria example) {
        return this.tdITFDWEIXINLOGMapper.selectByExample(example);
    }

    /**
    * @Title TdITFDWEIXINLOGDao.deleteByExample
    * @Description: 根据查询条件，删除ITF_D_WEIXIN_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdITFDWEIXINLOGMapper.deleteByExample(example);
    }

    /**
    * @Title TdITFDWEIXINLOGDao.updateByExampleSelective
    * @Description: 根据查询条件更新ITF_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdITFDWEIXINLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdITFDWEIXINLOG record, Criteria example) {
        return this.tdITFDWEIXINLOGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdITFDWEIXINLOGDao.updateByExample
    * @Description: 根据查询条件更新ITF_D_WEIXIN_LOG全表字段
    * @param record 要更新成为的TdITFDWEIXINLOG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdITFDWEIXINLOG record, Criteria example) {
        return this.tdITFDWEIXINLOGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdITFDWEIXINLOGDao.insert
    * @Description: 插入一个ITF_D_WEIXIN_LOG
    * @param record ITF_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    public int insert(TdITFDWEIXINLOG record) {
        return this.tdITFDWEIXINLOGMapper.insert(record);
    }

    /**
    * @Title TdITFDWEIXINLOGDao.insertSelective
    * @Description: 插入一个只有部分字段的ITF_D_WEIXIN_LOG
    * @param record 只含部分字段的ITF_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdITFDWEIXINLOG record) {
        return this.tdITFDWEIXINLOGMapper.insertSelective(record);
    }
}