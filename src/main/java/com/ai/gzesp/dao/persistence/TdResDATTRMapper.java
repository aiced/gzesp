package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdResDATTR;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdResDATTRMapper
* @Description: RES_D_ATTR表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdResDATTRMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdResDATTRMapper.countByExample
    * @Description: 根据查询条件，计算RES_D_ATTR个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdResDATTRMapper.deleteByExample
    * @Description: 根据查询条件，删除RES_D_ATTR
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdResDATTRMapper.insert
    * @Description: 插入一个RES_D_ATTR
    * @param record RES_D_ATTR的bean对象
    * @return int  插入个数
     */
    int insert(TdResDATTR record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdResDATTRMapper.insertSelective
    * @Description: 插入一个只有部分字段的RES_D_ATTR
    * @param record 只含部分字段的RES_D_ATTR的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdResDATTR record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdResDATTRMapper.selectByExample
    * @Description: 根据查询条件类，返回RES_D_ATTR结果集
    * @param example 通用查询条件类
    * @return List<TdResDATTR>RES_D_ATTR结果集
     */
    List<TdResDATTR> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdResDATTRMapper.updateByExampleSelective
    * @Description: 根据查询条件更新RES_D_ATTR部分字段
    * @param record 要更新成为的TdResDATTR对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdResDATTR record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdResDATTRMapper.updateByExample
    * @Description: 根据查询条件更新RES_D_ATTR全表字段
    * @param record 要更新成为的TdResDATTR对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdResDATTR record, @Param("example") Criteria criteria);
}