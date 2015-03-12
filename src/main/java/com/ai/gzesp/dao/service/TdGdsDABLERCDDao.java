package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.persistence.TdGdsDABLERCDMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDABLERCDDao
* @Description: GDS_D_ABLE_RCD表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDABLERCDDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDABLERCDDao.class);

    /**
     * @Fields TdGdsDABLERCD表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDABLERCDMapper tdGdsDABLERCDMapper;

    /**
    * @Title TdGdsDABLERCDDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_ABLE_RCD个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDABLERCDMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDABLERCDDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ABLE_RCD结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDABLERCD>GDS_D_ABLE_RCD结果集
     */
    public List<TdGdsDABLERCD> selectByExample(Criteria example) {
        return this.tdGdsDABLERCDMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDABLERCDDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ABLE_RCD
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDABLERCDMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDABLERCDDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ABLE_RCD部分字段
    * @param record 要更新成为的TdGdsDABLERCD对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDABLERCD record, Criteria example) {
        return this.tdGdsDABLERCDMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDABLERCDDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_ABLE_RCD全表字段
    * @param record 要更新成为的TdGdsDABLERCD对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDABLERCD record, Criteria example) {
        return this.tdGdsDABLERCDMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDABLERCDDao.insert
    * @Description: 插入一个GDS_D_ABLE_RCD
    * @param record GDS_D_ABLE_RCD的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDABLERCD record) {
        return this.tdGdsDABLERCDMapper.insert(record);
    }

    /**
    * @Title TdGdsDABLERCDDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ABLE_RCD
    * @param record 只含部分字段的GDS_D_ABLE_RCD的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDABLERCD record) {
        return this.tdGdsDABLERCDMapper.insertSelective(record);
    }
}