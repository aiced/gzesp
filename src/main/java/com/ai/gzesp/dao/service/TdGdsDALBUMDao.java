package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDALBUM;
import com.ai.gzesp.dao.persistence.TdGdsDALBUMMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDALBUMDao
* @Description: GDS_D_ALBUM表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDALBUMDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDALBUMDao.class);

    /**
     * @Fields TdGdsDALBUM表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDALBUMMapper tdGdsDALBUMMapper;

    /**
    * @Title TdGdsDALBUMDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_ALBUM个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDALBUMMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDALBUMDao.selectByPrimaryKey
    * @Description: 根据主键类，返回GDS_D_ALBUM
    * @param albumId albumId
    * @return TdGdsDALBUM bean对象
     */
    public TdGdsDALBUM selectByPrimaryKey(Long albumId) {
        return this.tdGdsDALBUMMapper.selectByPrimaryKey(albumId);
    }

    /**
    * @Title TdGdsDALBUMDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ALBUM结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDALBUM>GDS_D_ALBUM结果集
     */
    public List<TdGdsDALBUM> selectByExample(Criteria example) {
        return this.tdGdsDALBUMMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDALBUMDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除GDS_D_ALBUM
    * @param albumId albumId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(Long albumId) {
        return this.tdGdsDALBUMMapper.deleteByPrimaryKey(albumId);
    }

    /**
    * @Title TdGdsDALBUMDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新GDS_D_ALBUM部分字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdGdsDALBUM record) {
        return this.tdGdsDALBUMMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdGdsDALBUMDao.updateByPrimaryKey
    * @Description: 根据主键更新GDS_D_ALBUM全部字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdGdsDALBUM record) {
        return this.tdGdsDALBUMMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdGdsDALBUMDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ALBUM
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDALBUMMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDALBUMDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ALBUM部分字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDALBUM record, Criteria example) {
        return this.tdGdsDALBUMMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDALBUMDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_ALBUM全表字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDALBUM record, Criteria example) {
        return this.tdGdsDALBUMMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDALBUMDao.insert
    * @Description: 插入一个GDS_D_ALBUM
    * @param record GDS_D_ALBUM的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDALBUM record) {
        return this.tdGdsDALBUMMapper.insert(record);
    }

    /**
    * @Title TdGdsDALBUMDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ALBUM
    * @param record 只含部分字段的GDS_D_ALBUM的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDALBUM record) {
        return this.tdGdsDALBUMMapper.insertSelective(record);
    }
}