package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTAFFFUNCRIGHT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDSTAFFFUNCRIGHTMapper
* @Description: SYS_D_STAFF_FUNCRIGHT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDSTAFFFUNCRIGHTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_STAFF_FUNCRIGHT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STAFF_FUNCRIGHT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.insert
    * @Description: 插入一个SYS_D_STAFF_FUNCRIGHT
    * @param record SYS_D_STAFF_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDSTAFFFUNCRIGHT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STAFF_FUNCRIGHT
    * @param record 只含部分字段的SYS_D_STAFF_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDSTAFFFUNCRIGHT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STAFF_FUNCRIGHT结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTAFFFUNCRIGHT>SYS_D_STAFF_FUNCRIGHT结果集
     */
    List<TdSysDSTAFFFUNCRIGHT> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STAFF_FUNCRIGHT部分字段
    * @param record 要更新成为的TdSysDSTAFFFUNCRIGHT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDSTAFFFUNCRIGHT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDSTAFFFUNCRIGHTMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_STAFF_FUNCRIGHT全表字段
    * @param record 要更新成为的TdSysDSTAFFFUNCRIGHT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDSTAFFFUNCRIGHT record, @Param("example") Criteria criteria);
}