package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDNOTICE;
import com.ai.gzesp.dao.persistence.TdSysDNOTICEMapper;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdSysDNOTICEDao
* @Description: SYS_D_NOTICE表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdSysDNOTICEDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdSysDNOTICEDao.class);

    /**
     * @Fields TdSysDNOTICE表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdSysDNOTICEMapper tdSysDNOTICEMapper;

    /**
    * @Title TdSysDNOTICEDao.countByExample
    * @Description: 根据查询条件，计算SYS_D_NOTICE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdSysDNOTICEMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdSysDNOTICEDao.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_NOTICE结果集
    * @param example 通用查询条件类
    * @return List<TdSysDNOTICE>SYS_D_NOTICE结果集
     */
    public List<TdSysDNOTICE> selectByExample(Criteria example) {
        return this.tdSysDNOTICEMapper.selectByExample(example);
    }

    /**
    * @Title TdSysDNOTICEDao.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_NOTICE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdSysDNOTICEMapper.deleteByExample(example);
    }

    /**
    * @Title TdSysDNOTICEDao.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_NOTICE部分字段
    * @param record 要更新成为的TdSysDNOTICE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdSysDNOTICE record, Criteria example) {
        return this.tdSysDNOTICEMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdSysDNOTICEDao.updateByExample
    * @Description: 根据查询条件更新SYS_D_NOTICE全表字段
    * @param record 要更新成为的TdSysDNOTICE对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdSysDNOTICE record, Criteria example) {
        return this.tdSysDNOTICEMapper.updateByExample(record, example);
    }

    /**
    * @Title TdSysDNOTICEDao.insert
    * @Description: 插入一个SYS_D_NOTICE
    * @param record SYS_D_NOTICE的bean对象
    * @return int  插入个数
     */
    public int insert(TdSysDNOTICE record) {
        return this.tdSysDNOTICEMapper.insert(record);
    }

    /**
    * @Title TdSysDNOTICEDao.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_NOTICE
    * @param record 只含部分字段的SYS_D_NOTICE的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdSysDNOTICE record) {
        return this.tdSysDNOTICEMapper.insertSelective(record);
    }
}