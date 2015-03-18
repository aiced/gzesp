package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDCOUNT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdAurDCOUNTMapper
* @Description: AUR_D_COUNT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdAurDCOUNTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdAurDCOUNTMapper.countByExample
    * @Description: 根据查询条件，计算AUR_D_COUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdAurDCOUNTMapper.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_COUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdAurDCOUNTMapper.insert
    * @Description: 插入一个AUR_D_COUNT
    * @param record AUR_D_COUNT的bean对象
    * @return int  插入个数
     */
    int insert(TdAurDCOUNT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdAurDCOUNTMapper.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_COUNT
    * @param record 只含部分字段的AUR_D_COUNT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdAurDCOUNT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdAurDCOUNTMapper.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_COUNT结果集
    * @param example 通用查询条件类
    * @return List<TdAurDCOUNT>AUR_D_COUNT结果集
     */
    List<TdAurDCOUNT> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdAurDCOUNTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_COUNT部分字段
    * @param record 要更新成为的TdAurDCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdAurDCOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdAurDCOUNTMapper.updateByExample
    * @Description: 根据查询条件更新AUR_D_COUNT全表字段
    * @param record 要更新成为的TdAurDCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdAurDCOUNT record, @Param("example") Criteria criteria);
}