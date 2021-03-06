package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDRES;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDRESMapper
* @Description: ORD_D_RES表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDRESMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDRESMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_RES个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDRESMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_RES
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDRESMapper.insert
    * @Description: 插入一个ORD_D_RES
    * @param record ORD_D_RES的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDRES record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDRESMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_RES
    * @param record 只含部分字段的ORD_D_RES的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDRES record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDRESMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_RES结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDRES>ORD_D_RES结果集
     */
    List<TdOrdDRES> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDRESMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_RES部分字段
    * @param record 要更新成为的TdOrdDRES对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDRES record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDRESMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_RES全表字段
    * @param record 要更新成为的TdOrdDRES对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDRES record, @Param("example") Criteria criteria);
}