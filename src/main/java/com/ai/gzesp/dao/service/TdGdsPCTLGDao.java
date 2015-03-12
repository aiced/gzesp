package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsPCTLG;
import com.ai.gzesp.dao.persistence.TdGdsPCTLGMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsPCTLGDao
* @Description: GDS_P_CTLG表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsPCTLGDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsPCTLGDao.class);

    /**
     * @Fields TdGdsPCTLG表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsPCTLGMapper tdGdsPCTLGMapper;

    /**
    * @Title TdGdsPCTLGDao.countByExample
    * @Description: 根据查询条件，计算GDS_P_CTLG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsPCTLGMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsPCTLGDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_P_CTLG结果集
    * @param example 通用查询条件类
    * @return List<TdGdsPCTLG>GDS_P_CTLG结果集
     */
    public List<TdGdsPCTLG> selectByExample(Criteria example) {
        return this.tdGdsPCTLGMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsPCTLGDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_P_CTLG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsPCTLGMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsPCTLGDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_P_CTLG部分字段
    * @param record 要更新成为的TdGdsPCTLG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsPCTLG record, Criteria example) {
        return this.tdGdsPCTLGMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsPCTLGDao.updateByExample
    * @Description: 根据查询条件更新GDS_P_CTLG全表字段
    * @param record 要更新成为的TdGdsPCTLG对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsPCTLG record, Criteria example) {
        return this.tdGdsPCTLGMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsPCTLGDao.insert
    * @Description: 插入一个GDS_P_CTLG
    * @param record GDS_P_CTLG的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsPCTLG record) {
        return this.tdGdsPCTLGMapper.insert(record);
    }

    /**
    * @Title TdGdsPCTLGDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_P_CTLG
    * @param record 只含部分字段的GDS_P_CTLG的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsPCTLG record) {
        return this.tdGdsPCTLGMapper.insertSelective(record);
    }
}