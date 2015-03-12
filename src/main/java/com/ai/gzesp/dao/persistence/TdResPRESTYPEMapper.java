package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResPRESTYPE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdResPRESTYPEMapper
* @Description: RES_P_RESTYPE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdResPRESTYPEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdResPRESTYPEMapper.countByExample
    * @Description: 根据查询条件，计算RES_P_RESTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdResPRESTYPEMapper.deleteByExample
    * @Description: 根据查询条件，删除RES_P_RESTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdResPRESTYPEMapper.insert
    * @Description: 插入一个RES_P_RESTYPE
    * @param record RES_P_RESTYPE的bean对象
    * @return int  插入个数
     */
    int insert(TdResPRESTYPE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdResPRESTYPEMapper.insertSelective
    * @Description: 插入一个只有部分字段的RES_P_RESTYPE
    * @param record 只含部分字段的RES_P_RESTYPE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdResPRESTYPE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdResPRESTYPEMapper.selectByExample
    * @Description: 根据查询条件类，返回RES_P_RESTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdResPRESTYPE>RES_P_RESTYPE结果集
     */
    List<TdResPRESTYPE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdResPRESTYPEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新RES_P_RESTYPE部分字段
    * @param record 要更新成为的TdResPRESTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdResPRESTYPE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdResPRESTYPEMapper.updateByExample
    * @Description: 根据查询条件更新RES_P_RESTYPE全表字段
    * @param record 要更新成为的TdResPRESTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdResPRESTYPE record, @Param("example") Criteria criteria);
}