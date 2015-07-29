package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCARDPAY;
import com.ai.gzesp.dao.persistence.TdOrdDCARDPAYMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdOrdDCARDPAYDao
* @Description: ORD_D_CARD_PAY表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdOrdDCARDPAYDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdOrdDCARDPAYDao.class);

    /**
     * @Fields TdOrdDCARDPAY表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdOrdDCARDPAYMapper tdOrdDCARDPAYMapper;

    /**
    * @Title TdOrdDCARDPAYDao.countByExample
    * @Description: 根据查询条件，计算ORD_D_CARD_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdOrdDCARDPAYMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdOrdDCARDPAYDao.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CARD_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCARDPAY>ORD_D_CARD_PAY结果集
     */
    public List<TdOrdDCARDPAY> selectByExample(Criteria example) {
        return this.tdOrdDCARDPAYMapper.selectByExample(example);
    }

    /**
    * @Title TdOrdDCARDPAYDao.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CARD_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdOrdDCARDPAYMapper.deleteByExample(example);
    }

    /**
    * @Title TdOrdDCARDPAYDao.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CARD_PAY部分字段
    * @param record 要更新成为的TdOrdDCARDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdOrdDCARDPAY record, Criteria example) {
        return this.tdOrdDCARDPAYMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdOrdDCARDPAYDao.updateByExample
    * @Description: 根据查询条件更新ORD_D_CARD_PAY全表字段
    * @param record 要更新成为的TdOrdDCARDPAY对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdOrdDCARDPAY record, Criteria example) {
        return this.tdOrdDCARDPAYMapper.updateByExample(record, example);
    }

    /**
    * @Title TdOrdDCARDPAYDao.insert
    * @Description: 插入一个ORD_D_CARD_PAY
    * @param record ORD_D_CARD_PAY的bean对象
    * @return int  插入个数
     */
    public int insert(TdOrdDCARDPAY record) {
        return this.tdOrdDCARDPAYMapper.insert(record);
    }

    /**
    * @Title TdOrdDCARDPAYDao.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CARD_PAY
    * @param record 只含部分字段的ORD_D_CARD_PAY的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdOrdDCARDPAY record) {
        return this.tdOrdDCARDPAYMapper.insertSelective(record);
    }
}