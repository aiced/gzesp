package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFF;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDSTAFFMapper
* @Description: SYS_D_STAFF表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDSTAFFMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDSTAFFMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDSTAFFMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDSTAFFMapper.insert
    * @Description: 插入一个SYS_D_STAFF
    * @param record SYS_D_STAFF的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDSTAFF record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDSTAFFMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF
    * @param record 只含部分字段的SYS_D_STAFF的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDSTAFF record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDSTAFFMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFF>SYS_D_STAFF结果集
     */
    List<TdSysDSTAFF> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTAFFMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF部分字段
    * @param record 要更新成为的TdSysDSTAFF对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDSTAFF record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDSTAFFMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF全表字段
    * @param record 要更新成为的TdSysDSTAFF对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDSTAFF record, @Param("example") Criteria criteria);
}