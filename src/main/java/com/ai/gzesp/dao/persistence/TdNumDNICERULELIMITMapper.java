package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdNumDNICERULELIMIT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdNumDNICERULELIMITMapper
* @Description: NUM_D_NICERULE_LIMIT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdNumDNICERULELIMITMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.countByExample
    * @Description: 根据查询条件，计算NUM_D_NICERULE_LIMIT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.deleteByExample
    * @Description: 根据查询条件，删除NUM_D_NICERULE_LIMIT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.insert
    * @Description: 插入一个NUM_D_NICERULE_LIMIT
    * @param record NUM_D_NICERULE_LIMIT的bean对象
    * @return int  插入个数
     */
    int insert(TdNumDNICERULELIMIT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.insertSelective
    * @Description: 插入一个只有部分字段的NUM_D_NICERULE_LIMIT
    * @param record 只含部分字段的NUM_D_NICERULE_LIMIT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdNumDNICERULELIMIT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.selectByExample
    * @Description: 根据查询条件类，返回NUM_D_NICERULE_LIMIT结果集
    * @param example 通用查询条件类
    * @return List<TdNumDNICERULELIMIT>NUM_D_NICERULE_LIMIT结果集
     */
    List<TdNumDNICERULELIMIT> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.updateByExampleSelective
    * @Description: 根据查询条件更新NUM_D_NICERULE_LIMIT部分字段
    * @param record 要更新成为的TdNumDNICERULELIMIT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdNumDNICERULELIMIT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdNumDNICERULELIMITMapper.updateByExample
    * @Description: 根据查询条件更新NUM_D_NICERULE_LIMIT全表字段
    * @param record 要更新成为的TdNumDNICERULELIMIT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdNumDNICERULELIMIT record, @Param("example") Criteria criteria);
}