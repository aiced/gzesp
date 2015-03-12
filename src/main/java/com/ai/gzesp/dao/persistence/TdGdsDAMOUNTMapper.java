package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDAMOUNT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDAMOUNTMapper
* @Description: GDS_D_AMOUNT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDAMOUNTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDAMOUNTMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_AMOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDAMOUNTMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_AMOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDAMOUNTMapper.insert
    * @Description: 插入一个GDS_D_AMOUNT
    * @param record GDS_D_AMOUNT的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDAMOUNT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDAMOUNTMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_AMOUNT
    * @param record 只含部分字段的GDS_D_AMOUNT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDAMOUNT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDAMOUNTMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_AMOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDAMOUNT>GDS_D_AMOUNT结果集
     */
    List<TdGdsDAMOUNT> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDAMOUNTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_AMOUNT部分字段
    * @param record 要更新成为的TdGdsDAMOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDAMOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDAMOUNTMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_AMOUNT全表字段
    * @param record 要更新成为的TdGdsDAMOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDAMOUNT record, @Param("example") Criteria criteria);
}