package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDRELINFO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdAurDRELINFOMapper
* @Description: AUR_D_RELINFO表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdAurDRELINFOMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdAurDRELINFOMapper.countByExample
    * @Description: 根据查询条件，计算AUR_D_RELINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdAurDRELINFOMapper.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_RELINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdAurDRELINFOMapper.insert
    * @Description: 插入一个AUR_D_RELINFO
    * @param record AUR_D_RELINFO的bean对象
    * @return int  插入个数
     */
    int insert(TdAurDRELINFO record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdAurDRELINFOMapper.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_RELINFO
    * @param record 只含部分字段的AUR_D_RELINFO的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdAurDRELINFO record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdAurDRELINFOMapper.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_RELINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDRELINFO>AUR_D_RELINFO结果集
     */
    List<TdAurDRELINFO> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdAurDRELINFOMapper.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_RELINFO部分字段
    * @param record 要更新成为的TdAurDRELINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdAurDRELINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdAurDRELINFOMapper.updateByExample
    * @Description: 根据查询条件更新AUR_D_RELINFO全表字段
    * @param record 要更新成为的TdAurDRELINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdAurDRELINFO record, @Param("example") Criteria criteria);
}