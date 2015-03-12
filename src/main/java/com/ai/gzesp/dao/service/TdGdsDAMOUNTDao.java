package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDAMOUNT;
import com.ai.gzesp.dao.persistence.TdGdsDAMOUNTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDAMOUNTDao
* @Description: GDS_D_AMOUNT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDAMOUNTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDAMOUNTDao.class);

    /**
     * @Fields TdGdsDAMOUNT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDAMOUNTMapper tdGdsDAMOUNTMapper;

    /**
    * @Title TdGdsDAMOUNTDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_AMOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDAMOUNTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDAMOUNTDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_AMOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDAMOUNT>GDS_D_AMOUNT结果集
     */
    public List<TdGdsDAMOUNT> selectByExample(Criteria example) {
        return this.tdGdsDAMOUNTMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDAMOUNTDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_AMOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDAMOUNTMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDAMOUNTDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_AMOUNT部分字段
    * @param record 要更新成为的TdGdsDAMOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDAMOUNT record, Criteria example) {
        return this.tdGdsDAMOUNTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDAMOUNTDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_AMOUNT全表字段
    * @param record 要更新成为的TdGdsDAMOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDAMOUNT record, Criteria example) {
        return this.tdGdsDAMOUNTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDAMOUNTDao.insert
    * @Description: 插入一个GDS_D_AMOUNT
    * @param record GDS_D_AMOUNT的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDAMOUNT record) {
        return this.tdGdsDAMOUNTMapper.insert(record);
    }

    /**
    * @Title TdGdsDAMOUNTDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_AMOUNT
    * @param record 只含部分字段的GDS_D_AMOUNT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDAMOUNT record) {
        return this.tdGdsDAMOUNTMapper.insertSelective(record);
    }
}