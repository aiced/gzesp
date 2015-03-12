package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import com.ai.gzesp.dao.persistence.TdGdsDABLEACTIVITYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDABLEACTIVITYDao
* @Description: GDS_D_ABLE_ACTIVITY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDABLEACTIVITYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDABLEACTIVITYDao.class);

    /**
     * @Fields TdGdsDABLEACTIVITY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDABLEACTIVITYMapper tdGdsDABLEACTIVITYMapper;

    /**
    * @Title TdGdsDABLEACTIVITYDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_ABLE_ACTIVITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDABLEACTIVITYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ABLE_ACTIVITY结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDABLEACTIVITY>GDS_D_ABLE_ACTIVITY结果集
     */
    public List<TdGdsDABLEACTIVITY> selectByExample(Criteria example) {
        return this.tdGdsDABLEACTIVITYMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ABLE_ACTIVITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDABLEACTIVITYMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ABLE_ACTIVITY部分字段
    * @param record 要更新成为的TdGdsDABLEACTIVITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDABLEACTIVITY record, Criteria example) {
        return this.tdGdsDABLEACTIVITYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_ABLE_ACTIVITY全表字段
    * @param record 要更新成为的TdGdsDABLEACTIVITY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDABLEACTIVITY record, Criteria example) {
        return this.tdGdsDABLEACTIVITYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.insert
    * @Description: 插入一个GDS_D_ABLE_ACTIVITY
    * @param record GDS_D_ABLE_ACTIVITY的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDABLEACTIVITY record) {
        return this.tdGdsDABLEACTIVITYMapper.insert(record);
    }

    /**
    * @Title TdGdsDABLEACTIVITYDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ABLE_ACTIVITY
    * @param record 只含部分字段的GDS_D_ABLE_ACTIVITY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDABLEACTIVITY record) {
        return this.tdGdsDABLEACTIVITYMapper.insertSelective(record);
    }
}