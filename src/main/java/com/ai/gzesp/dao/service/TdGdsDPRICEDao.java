package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDPRICE;
import com.ai.gzesp.dao.persistence.TdGdsDPRICEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdGdsDPRICEDao
* @Description: GDS_D_PRICE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdGdsDPRICEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdGdsDPRICEDao.class);

    /**
     * @Fields TdGdsDPRICE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdGdsDPRICEMapper tdGdsDPRICEMapper;

    /**
    * @Title TdGdsDPRICEDao.countByExample
    * @Description: 根据查询条件，计算GDS_D_PRICE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdGdsDPRICEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdGdsDPRICEDao.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_PRICE结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDPRICE>GDS_D_PRICE结果集
     */
    public List<TdGdsDPRICE> selectByExample(Criteria example) {
        return this.tdGdsDPRICEMapper.selectByExample(example);
    }

    /**
    * @Title TdGdsDPRICEDao.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_PRICE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdGdsDPRICEMapper.deleteByExample(example);
    }

    /**
    * @Title TdGdsDPRICEDao.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_PRICE部分字段
    * @param record 要更新成为的TdGdsDPRICE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdGdsDPRICE record, Criteria example) {
        return this.tdGdsDPRICEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdGdsDPRICEDao.updateByExample
    * @Description: 根据查询条件更新GDS_D_PRICE全表字段
    * @param record 要更新成为的TdGdsDPRICE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdGdsDPRICE record, Criteria example) {
        return this.tdGdsDPRICEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdGdsDPRICEDao.insert
    * @Description: 插入一个GDS_D_PRICE
    * @param record GDS_D_PRICE的bean对象
    * @return int  插入个数
     */
    public int insert(TdGdsDPRICE record) {
        return this.tdGdsDPRICEMapper.insert(record);
    }

    /**
    * @Title TdGdsDPRICEDao.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_PRICE
    * @param record 只含部分字段的GDS_D_PRICE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdGdsDPRICE record) {
        return this.tdGdsDPRICEMapper.insertSelective(record);
    }
}