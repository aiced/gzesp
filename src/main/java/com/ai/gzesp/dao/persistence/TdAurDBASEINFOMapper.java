package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdAurDBASEINFOMapper
* @Description: AUR_D_BASEINFO表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdAurDBASEINFOMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdAurDBASEINFOMapper.countByExample
    * @Description: 根据查询条件，计算AUR_D_BASEINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdAurDBASEINFOMapper.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_BASEINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdAurDBASEINFOMapper.insert
    * @Description: 插入一个AUR_D_BASEINFO
    * @param record AUR_D_BASEINFO的bean对象
    * @return int  插入个数
     */
    int insert(TdAurDBASEINFO record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdAurDBASEINFOMapper.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_BASEINFO
    * @param record 只含部分字段的AUR_D_BASEINFO的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdAurDBASEINFO record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdAurDBASEINFOMapper.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_BASEINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDBASEINFO>AUR_D_BASEINFO结果集
     */
    List<TdAurDBASEINFO> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdAurDBASEINFOMapper.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_BASEINFO部分字段
    * @param record 要更新成为的TdAurDBASEINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdAurDBASEINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdAurDBASEINFOMapper.updateByExample
    * @Description: 根据查询条件更新AUR_D_BASEINFO全表字段
    * @param record 要更新成为的TdAurDBASEINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdAurDBASEINFO record, @Param("example") Criteria criteria);
}