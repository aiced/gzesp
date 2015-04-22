package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdNumDRESERVE;
import com.ai.gzesp.dao.persistence.TdNumDRESERVEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdNumDRESERVEDao
* @Description: NUM_D_RESERVE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdNumDRESERVEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdNumDRESERVEDao.class);

    /**
     * @Fields TdNumDRESERVE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdNumDRESERVEMapper tdNumDRESERVEMapper;

    /**
    * @Title TdNumDRESERVEDao.countByExample
    * @Description: 根据查询条件，计算NUM_D_RESERVE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdNumDRESERVEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdNumDRESERVEDao.selectByPrimaryKey
    * @Description: 根据主键类，返回NUM_D_RESERVE
    * @param serialNumber serialNumber
    * @return TdNumDRESERVE bean对象
     */
    public TdNumDRESERVE selectByPrimaryKey(String serialNumber) {
        return this.tdNumDRESERVEMapper.selectByPrimaryKey(serialNumber);
    }

    /**
    * @Title TdNumDRESERVEDao.selectByExample
    * @Description: 根据查询条件类，返回NUM_D_RESERVE结果集
    * @param example 通用查询条件类
    * @return List<TdNumDRESERVE>NUM_D_RESERVE结果集
     */
    public List<TdNumDRESERVE> selectByExample(Criteria example) {
        return this.tdNumDRESERVEMapper.selectByExample(example);
    }

    /**
    * @Title TdNumDRESERVEDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除NUM_D_RESERVE
    * @param serialNumber serialNumber
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(String serialNumber) {
        return this.tdNumDRESERVEMapper.deleteByPrimaryKey(serialNumber);
    }

    /**
    * @Title TdNumDRESERVEDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新NUM_D_RESERVE部分字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdNumDRESERVE record) {
        return this.tdNumDRESERVEMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdNumDRESERVEDao.updateByPrimaryKey
    * @Description: 根据主键更新NUM_D_RESERVE全部字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdNumDRESERVE record) {
        return this.tdNumDRESERVEMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdNumDRESERVEDao.deleteByExample
    * @Description: 根据查询条件，删除NUM_D_RESERVE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdNumDRESERVEMapper.deleteByExample(example);
    }

    /**
    * @Title TdNumDRESERVEDao.updateByExampleSelective
    * @Description: 根据查询条件更新NUM_D_RESERVE部分字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdNumDRESERVE record, Criteria example) {
        return this.tdNumDRESERVEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdNumDRESERVEDao.updateByExample
    * @Description: 根据查询条件更新NUM_D_RESERVE全表字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdNumDRESERVE record, Criteria example) {
        return this.tdNumDRESERVEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdNumDRESERVEDao.insert
    * @Description: 插入一个NUM_D_RESERVE
    * @param record NUM_D_RESERVE的bean对象
    * @return int  插入个数
     */
    public int insert(TdNumDRESERVE record) {
        return this.tdNumDRESERVEMapper.insert(record);
    }

    /**
    * @Title TdNumDRESERVEDao.insertSelective
    * @Description: 插入一个只有部分字段的NUM_D_RESERVE
    * @param record 只含部分字段的NUM_D_RESERVE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdNumDRESERVE record) {
        return this.tdNumDRESERVEMapper.insertSelective(record);
    }
}