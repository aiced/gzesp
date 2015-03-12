package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsPATTRTYPE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsPATTRTYPEMapper
* @Description: GDS_P_ATTRTYPE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsPATTRTYPEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.countByExample
    * @Description: 根据查询条件，计算GDS_P_ATTRTYPE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_P_ATTRTYPE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.insert
    * @Description: 插入一个GDS_P_ATTRTYPE
    * @param record GDS_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsPATTRTYPE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_P_ATTRTYPE
    * @param record 只含部分字段的GDS_P_ATTRTYPE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsPATTRTYPE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_P_ATTRTYPE结果集
    * @param example 通用查询条件类
    * @return List<TdGdsPATTRTYPE>GDS_P_ATTRTYPE结果集
     */
    List<TdGdsPATTRTYPE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_P_ATTRTYPE部分字段
    * @param record 要更新成为的TdGdsPATTRTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsPATTRTYPE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsPATTRTYPEMapper.updateByExample
    * @Description: 根据查询条件更新GDS_P_ATTRTYPE全表字段
    * @param record 要更新成为的TdGdsPATTRTYPE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsPATTRTYPE record, @Param("example") Criteria criteria);
}