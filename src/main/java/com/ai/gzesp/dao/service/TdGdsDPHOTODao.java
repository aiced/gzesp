package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDPHOTO;
import com.ai.gzesp.dao.persistence.TdGdsDPHOTOMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDPHOTODao
* @Description: GDS_D_PHOTO表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDPHOTODao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDPHOTODao.class);

    /**
     * @Fields TdGdsDPHOTO表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDPHOTOMapper tdGdsDPHOTOMapper;

    /**
    * @Title TdGdsDPHOTODao.countByExample
    * @Description: 根据查询条件，计算GDS_D_PHOTO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDPHOTOMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDPHOTODao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_PHOTO结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDPHOTO>GDS_D_PHOTO结果集
     */
    public List<TdGdsDPHOTO> selectByExample(Criteria example) {
        return this.tdGdsDPHOTOMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDPHOTODao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_PHOTO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDPHOTOMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDPHOTODao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_PHOTO部分字段
    * @param record 要更新成为的TdGdsDPHOTO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDPHOTO record, Criteria example) {
        return this.tdGdsDPHOTOMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDPHOTODao.updateByExample
    * @Description: 根据查询条件更新GDS_D_PHOTO全表字段
    * @param record 要更新成为的TdGdsDPHOTO对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDPHOTO record, Criteria example) {
        return this.tdGdsDPHOTOMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDPHOTODao.insert
    * @Description: 插入一个GDS_D_PHOTO
    * @param record GDS_D_PHOTO的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDPHOTO record) {
        return this.tdGdsDPHOTOMapper.insert(record);
    }

    /**
    * @Title TdGdsDPHOTODao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_PHOTO
    * @param record 只含部分字段的GDS_D_PHOTO的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDPHOTO record) {
        return this.tdGdsDPHOTOMapper.insertSelective(record);
    }
}