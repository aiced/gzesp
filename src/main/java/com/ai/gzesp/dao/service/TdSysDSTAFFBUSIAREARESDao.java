package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFFBUSIAREARES;
import com.ai.gzesp.dao.persistence.TdSysDSTAFFBUSIAREARESMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDSTAFFBUSIAREARESDao
* @Description: SYS_D_STAFF_BUSIAREA_RES表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDSTAFFBUSIAREARESDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDSTAFFBUSIAREARESDao.class);

    /**
     * @Fields TdSysDSTAFFBUSIAREARES表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDSTAFFBUSIAREARESMapper tdSysDSTAFFBUSIAREARESMapper;

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF_BUSIAREA_RES个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDSTAFFBUSIAREARESMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF_BUSIAREA_RES结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFFBUSIAREARES>SYS_D_STAFF_BUSIAREA_RES结果集
     */
    public List<TdSysDSTAFFBUSIAREARES> selectByExample(Criteria example) {
        return this.tdSysDSTAFFBUSIAREARESMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF_BUSIAREA_RES
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDSTAFFBUSIAREARESMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF_BUSIAREA_RES部分字段
    * @param record 要更新成为的TdSysDSTAFFBUSIAREARES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDSTAFFBUSIAREARES record, Criteria example) {
        return this.tdSysDSTAFFBUSIAREARESMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF_BUSIAREA_RES全表字段
    * @param record 要更新成为的TdSysDSTAFFBUSIAREARES对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDSTAFFBUSIAREARES record, Criteria example) {
        return this.tdSysDSTAFFBUSIAREARESMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.insert
    * @Description: 插入一个SYS_D_STAFF_BUSIAREA_RES
    * @param record SYS_D_STAFF_BUSIAREA_RES的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDSTAFFBUSIAREARES record) {
        return this.tdSysDSTAFFBUSIAREARESMapper.insert(record);
    }

    /**
    * @Title TdSysDSTAFFBUSIAREARESDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF_BUSIAREA_RES
    * @param record 只含部分字段的SYS_D_STAFF_BUSIAREA_RES的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDSTAFFBUSIAREARES record) {
        return this.tdSysDSTAFFBUSIAREARESMapper.insertSelective(record);
    }
}