package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResPATTRTYPE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdResPATTRTYPEMapper
* @Description: RES_P_ATTRTYPE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdResPATTRTYPEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdResPATTRTYPEMapper.countByExample
    * @Description: 根据查询条件，计算RES_P_ATTRTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdResPATTRTYPEMapper.deleteByExample
    * @Description: 根据查询条件，删除RES_P_ATTRTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdResPATTRTYPEMapper.insert
    * @Description: 插入一个RES_P_ATTRTYPE
    * @param record RES_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    int insert(TdResPATTRTYPE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdResPATTRTYPEMapper.insertSelective
    * @Description: 插入一个只有部分字段的RES_P_ATTRTYPE
    * @param record 只含部分字段的RES_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdResPATTRTYPE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdResPATTRTYPEMapper.selectByExample
    * @Description: 根据查询条件类，返回RES_P_ATTRTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdResPATTRTYPE>RES_P_ATTRTYPE结果集
     */
    List<TdResPATTRTYPE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdResPATTRTYPEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新RES_P_ATTRTYPE部分字段
    * @param record 要更新成为的TdResPATTRTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdResPATTRTYPE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdResPATTRTYPEMapper.updateByExample
    * @Description: 根据查询条件更新RES_P_ATTRTYPE全表字段
    * @param record 要更新成为的TdResPATTRTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdResPATTRTYPE record, @Param("example") Criteria criteria);
}