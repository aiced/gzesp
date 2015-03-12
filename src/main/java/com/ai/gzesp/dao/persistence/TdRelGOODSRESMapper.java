package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdRelGOODSRES;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdRelGOODSRESMapper
* @Description: REL_GOODS_RES表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdRelGOODSRESMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdRelGOODSRESMapper.countByExample
    * @Description: 根据查询条件，计算REL_GOODS_RES个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdRelGOODSRESMapper.deleteByExample
    * @Description: 根据查询条件，删除REL_GOODS_RES
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdRelGOODSRESMapper.insert
    * @Description: 插入一个REL_GOODS_RES
    * @param record REL_GOODS_RES的bean对象
    * @return int  插入个数
     */
    int insert(TdRelGOODSRES record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdRelGOODSRESMapper.insertSelective
    * @Description: 插入一个只有部分字段的REL_GOODS_RES
    * @param record 只含部分字段的REL_GOODS_RES的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdRelGOODSRES record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdRelGOODSRESMapper.selectByExample
    * @Description: 根据查询条件类，返回REL_GOODS_RES结果集
    * @param example 通用查询条件类
    * @return List<TdRelGOODSRES>REL_GOODS_RES结果集
     */
    List<TdRelGOODSRES> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdRelGOODSRESMapper.updateByExampleSelective
    * @Description: 根据查询条件更新REL_GOODS_RES部分字段
    * @param record 要更新成为的TdRelGOODSRES对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdRelGOODSRES record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdRelGOODSRESMapper.updateByExample
    * @Description: 根据查询条件更新REL_GOODS_RES全表字段
    * @param record 要更新成为的TdRelGOODSRES对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdRelGOODSRES record, @Param("example") Criteria criteria);
}