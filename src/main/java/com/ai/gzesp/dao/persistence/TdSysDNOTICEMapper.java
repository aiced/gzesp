package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDNOTICE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDNOTICEMapper
* @Description: SYS_D_NOTICE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDNOTICEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDNOTICEMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_NOTICE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDNOTICEMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_NOTICE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDNOTICEMapper.insert
    * @Description: 插入一个SYS_D_NOTICE
    * @param record SYS_D_NOTICE的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDNOTICE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDNOTICEMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_NOTICE
    * @param record 只含部分字段的SYS_D_NOTICE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDNOTICE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDNOTICEMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_NOTICE结果集
    * @param example 通用查询条件类
    * @return List<TdSysDNOTICE>SYS_D_NOTICE结果集
     */
    List<TdSysDNOTICE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDNOTICEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_NOTICE部分字段
    * @param record 要更新成为的TdSysDNOTICE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDNOTICE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDNOTICEMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_NOTICE全表字段
    * @param record 要更新成为的TdSysDNOTICE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDNOTICE record, @Param("example") Criteria criteria);
}